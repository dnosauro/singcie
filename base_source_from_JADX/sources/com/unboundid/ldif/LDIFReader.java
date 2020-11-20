package com.unboundid.ldif;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.Entry;
import com.unboundid.ldap.sdk.Modification;
import com.unboundid.ldap.sdk.ModificationType;
import com.unboundid.ldap.sdk.schema.Schema;
import com.unboundid.util.AggregateInputStream;
import com.unboundid.util.Base64;
import com.unboundid.util.Debug;
import com.unboundid.util.LDAPSDKThreadFactory;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import com.unboundid.util.parallel.AsynchronousParallelProcessor;
import com.unboundid.util.parallel.ParallelProcessor;
import com.unboundid.util.parallel.Processor;
import com.unboundid.util.parallel.Result;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public final class LDIFReader {
    private static final int ASYNC_MIN_PER_PARSING_THREAD = 3;
    private static final int ASYNC_QUEUE_SIZE = 500;
    public static final int DEFAULT_BUFFER_SIZE = 131072;
    private static final String DEFAULT_RELATIVE_BASE_PATH;
    /* access modifiers changed from: private */
    public static final Entry SKIP_ENTRY = new Entry("cn=skipped");
    private final BlockingQueue<Result<UnparsedLDIFRecord, LDIFRecord>> asyncParsedRecords;
    /* access modifiers changed from: private */
    public final AsynchronousParallelProcessor<UnparsedLDIFRecord, LDIFRecord> asyncParser;
    /* access modifiers changed from: private */
    public final AtomicBoolean asyncParsingComplete;
    private volatile DuplicateValueBehavior duplicateValueBehavior;
    /* access modifiers changed from: private */
    public final LDIFReaderEntryTranslator entryTranslator;
    private final boolean isAsync;
    private long lineNumberCounter;
    private final BufferedReader reader;
    /* access modifiers changed from: private */
    public volatile String relativeBasePath;
    private Schema schema;
    private volatile TrailingSpaceBehavior trailingSpaceBehavior;

    private final class LineReaderThread extends Thread {
        private LineReaderThread() {
            super("Asynchronous LDIF line reader");
            setDaemon(true);
        }

        public void run() {
            UnparsedLDIFRecord unparsedLDIFRecord;
            boolean z = false;
            while (!z) {
                try {
                    unparsedLDIFRecord = LDIFReader.this.readUnparsedRecord();
                } catch (IOException e) {
                    Debug.debugException(e);
                    unparsedLDIFRecord = new UnparsedLDIFRecord(e);
                    z = true;
                } catch (Exception e2) {
                    Debug.debugException(e2);
                    unparsedLDIFRecord = new UnparsedLDIFRecord(e2);
                } catch (Throwable th) {
                    try {
                        LDIFReader.this.asyncParser.shutdown();
                    } catch (InterruptedException e3) {
                        Debug.debugException(e3);
                    } catch (Throwable th2) {
                        LDIFReader.this.asyncParsingComplete.set(true);
                        throw th2;
                    }
                    LDIFReader.this.asyncParsingComplete.set(true);
                    throw th;
                }
                try {
                    LDIFReader.this.asyncParser.submit(unparsedLDIFRecord);
                } catch (InterruptedException e4) {
                    Debug.debugException(e4);
                    z = true;
                }
                if (unparsedLDIFRecord == null || unparsedLDIFRecord.isEOF()) {
                    z = true;
                }
            }
            try {
                LDIFReader.this.asyncParser.shutdown();
            } catch (InterruptedException e5) {
                Debug.debugException(e5);
            } catch (Throwable th3) {
                LDIFReader.this.asyncParsingComplete.set(true);
                throw th3;
            }
            LDIFReader.this.asyncParsingComplete.set(true);
        }
    }

    private final class RecordParser implements Processor<UnparsedLDIFRecord, LDIFRecord> {
        private RecordParser() {
        }

        public LDIFRecord process(UnparsedLDIFRecord unparsedLDIFRecord) {
            LDIFRecord access$1500 = LDIFReader.decodeRecord(unparsedLDIFRecord, LDIFReader.this.relativeBasePath);
            if (!(access$1500 instanceof Entry) || LDIFReader.this.entryTranslator == null) {
                return access$1500;
            }
            Entry translate = LDIFReader.this.entryTranslator.translate((Entry) access$1500, unparsedLDIFRecord.getFirstLineNumber());
            return translate == null ? LDIFReader.SKIP_ENTRY : translate;
        }
    }

    private static final class UnparsedLDIFRecord {
        private final DuplicateValueBehavior duplicateValueBehavior;
        private final Exception failureCause;
        private final long firstLineNumber;
        private final boolean isEOF;
        private final ArrayList<StringBuilder> lineList;
        private final Schema schema;
        private final TrailingSpaceBehavior trailingSpaceBehavior;

        private UnparsedLDIFRecord(Exception exc) {
            this.failureCause = exc;
            this.lineList = null;
            this.firstLineNumber = 0;
            this.duplicateValueBehavior = DuplicateValueBehavior.REJECT;
            this.trailingSpaceBehavior = TrailingSpaceBehavior.REJECT;
            this.schema = null;
            this.isEOF = false;
        }

        private UnparsedLDIFRecord(ArrayList<StringBuilder> arrayList, DuplicateValueBehavior duplicateValueBehavior2, TrailingSpaceBehavior trailingSpaceBehavior2, Schema schema2, long j) {
            this.lineList = arrayList;
            this.firstLineNumber = j;
            this.duplicateValueBehavior = duplicateValueBehavior2;
            this.trailingSpaceBehavior = trailingSpaceBehavior2;
            this.schema = schema2;
            this.failureCause = null;
            this.isEOF = j < 0 || (arrayList != null && arrayList.isEmpty());
        }

        /* access modifiers changed from: private */
        public DuplicateValueBehavior getDuplicateValueBehavior() {
            return this.duplicateValueBehavior;
        }

        /* access modifiers changed from: private */
        public Exception getFailureCause() {
            return this.failureCause;
        }

        /* access modifiers changed from: private */
        public long getFirstLineNumber() {
            return this.firstLineNumber;
        }

        /* access modifiers changed from: private */
        public ArrayList<StringBuilder> getLineList() {
            return this.lineList;
        }

        /* access modifiers changed from: private */
        public Schema getSchema() {
            return this.schema;
        }

        /* access modifiers changed from: private */
        public TrailingSpaceBehavior getTrailingSpaceBehavior() {
            return this.trailingSpaceBehavior;
        }

        /* access modifiers changed from: private */
        public boolean isEOF() {
            return this.isEOF;
        }
    }

    static {
        String property = System.getProperty("user.dir");
        String absolutePath = (property == null ? new File(".") : new File(property)).getAbsolutePath();
        if (!absolutePath.endsWith(File.separator)) {
            absolutePath = absolutePath + File.separator;
        }
        DEFAULT_RELATIVE_BASE_PATH = absolutePath;
    }

    public LDIFReader(BufferedReader bufferedReader) {
        this(bufferedReader, 0);
    }

    public LDIFReader(BufferedReader bufferedReader, int i) {
        this(bufferedReader, i, (LDIFReaderEntryTranslator) null);
    }

    public LDIFReader(BufferedReader bufferedReader, int i, LDIFReaderEntryTranslator lDIFReaderEntryTranslator) {
        this.lineNumberCounter = 0;
        Validator.ensureNotNull(bufferedReader);
        Validator.ensureTrue(i >= 0, "LDIFReader.numParseThreads must not be negative.");
        this.reader = bufferedReader;
        this.entryTranslator = lDIFReaderEntryTranslator;
        this.duplicateValueBehavior = DuplicateValueBehavior.STRIP;
        this.trailingSpaceBehavior = TrailingSpaceBehavior.REJECT;
        this.relativeBasePath = DEFAULT_RELATIVE_BASE_PATH;
        if (i == 0) {
            this.isAsync = false;
            this.asyncParser = null;
            this.asyncParsingComplete = null;
            this.asyncParsedRecords = null;
            return;
        }
        this.isAsync = true;
        this.asyncParsingComplete = new AtomicBoolean(false);
        ParallelProcessor parallelProcessor = new ParallelProcessor(new RecordParser(), new LDAPSDKThreadFactory("LDIFReader Worker", true, (ThreadGroup) null), i, 3);
        ArrayBlockingQueue arrayBlockingQueue = new ArrayBlockingQueue(ASYNC_QUEUE_SIZE);
        this.asyncParsedRecords = new ArrayBlockingQueue(1100);
        this.asyncParser = new AsynchronousParallelProcessor<>(arrayBlockingQueue, parallelProcessor, this.asyncParsedRecords);
        new LineReaderThread().start();
    }

    public LDIFReader(File file) {
        this((InputStream) new FileInputStream(file));
    }

    public LDIFReader(File file, int i) {
        this((InputStream) new FileInputStream(file), i);
    }

    public LDIFReader(InputStream inputStream) {
        this(inputStream, 0);
    }

    public LDIFReader(InputStream inputStream, int i) {
        this(new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")), 131072), i);
    }

    public LDIFReader(InputStream inputStream, int i, LDIFReaderEntryTranslator lDIFReaderEntryTranslator) {
        this(new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")), 131072), i, lDIFReaderEntryTranslator);
    }

    public LDIFReader(String str) {
        this((InputStream) new FileInputStream(str));
    }

    public LDIFReader(String str, int i) {
        this((InputStream) new FileInputStream(str), i);
    }

    public LDIFReader(File[] fileArr, int i, LDIFReaderEntryTranslator lDIFReaderEntryTranslator) {
        this(createAggregateInputStream(fileArr), i, lDIFReaderEntryTranslator);
    }

    /* JADX INFO: finally extract failed */
    private static InputStream createAggregateInputStream(File... fileArr) {
        if (fileArr.length != 0) {
            if (fileArr.length == 1) {
                return new FileInputStream(fileArr[0]);
            }
            File createTempFile = File.createTempFile("ldif-reader-spacer", ".ldif");
            createTempFile.deleteOnExit();
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(createTempFile));
            try {
                bufferedWriter.newLine();
                bufferedWriter.newLine();
                bufferedWriter.close();
                File[] fileArr2 = new File[((fileArr.length * 2) - 1)];
                fileArr2[0] = fileArr[0];
                int i = 1;
                for (int i2 = 1; i2 < fileArr.length; i2++) {
                    int i3 = i + 1;
                    fileArr2[i] = createTempFile;
                    i = i3 + 1;
                    fileArr2[i3] = fileArr[i2];
                }
                return new AggregateInputStream(fileArr2);
            } catch (Throwable th) {
                bufferedWriter.close();
                throw th;
            }
        } else {
            throw new IOException(LDIFMessages.ERR_READ_NO_LDIF_FILES.get());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x02b9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.unboundid.ldif.LDIFChangeRecord decodeChangeRecord(com.unboundid.ldif.LDIFReader.UnparsedLDIFRecord r15, java.lang.String r16, boolean r17) {
        /*
            java.util.ArrayList r6 = r15.getLineList()
            long r8 = r15.getFirstLineNumber()
            java.util.Iterator r0 = r6.iterator()
            java.lang.Object r1 = r0.next()
            java.lang.StringBuilder r1 = (java.lang.StringBuilder) r1
            com.unboundid.ldif.TrailingSpaceBehavior r2 = r15.getTrailingSpaceBehavior()
            r3 = 0
            handleTrailingSpaces(r1, r3, r8, r2)
            java.lang.String r2 = ":"
            int r2 = r1.indexOf(r2)
            r10 = 0
            r3 = 1
            if (r2 < 0) goto L_0x02d1
            java.lang.String r4 = r1.substring(r10, r2)
            java.lang.String r5 = "dn"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x02d1
            int r4 = r1.length()
            int r5 = r2 + 1
            r7 = 58
            r11 = 32
            r12 = 2
            if (r4 != r5) goto L_0x0042
            java.lang.String r1 = ""
        L_0x003f:
            r13 = r1
            goto L_0x00b5
        L_0x0042:
            char r13 = r1.charAt(r5)
            if (r13 != r7) goto L_0x00a5
            int r2 = r2 + r12
        L_0x0049:
            if (r2 >= r4) goto L_0x0054
            char r5 = r1.charAt(r2)
            if (r5 != r11) goto L_0x0054
            int r2 = r2 + 1
            goto L_0x0049
        L_0x0054:
            java.lang.String r1 = r1.substring(r2)     // Catch:{ ParseException -> 0x0083, Exception -> 0x0065 }
            byte[] r1 = com.unboundid.util.Base64.decode(r1)     // Catch:{ ParseException -> 0x0083, Exception -> 0x0065 }
            java.lang.String r2 = new java.lang.String     // Catch:{ ParseException -> 0x0083, Exception -> 0x0065 }
            java.lang.String r4 = "UTF-8"
            r2.<init>(r1, r4)     // Catch:{ ParseException -> 0x0083, Exception -> 0x0065 }
            r13 = r2
            goto L_0x00b5
        L_0x0065:
            r0 = move-exception
            r7 = r0
            com.unboundid.util.Debug.debugException(r7)
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_CR_CANNOT_BASE64_DECODE_DN
            java.lang.Object[] r2 = new java.lang.Object[r12]
            java.lang.Long r4 = java.lang.Long.valueOf(r8)
            r2[r10] = r4
            r2[r3] = r7
            java.lang.String r2 = r1.get(r2)
            r5 = 1
            r1 = r0
            r3 = r8
            r1.<init>((java.lang.String) r2, (long) r3, (boolean) r5, (java.util.List<? extends java.lang.CharSequence>) r6, (java.lang.Throwable) r7)
            throw r0
        L_0x0083:
            r0 = move-exception
            r7 = r0
            com.unboundid.util.Debug.debugException(r7)
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_CR_CANNOT_BASE64_DECODE_DN
            java.lang.Object[] r2 = new java.lang.Object[r12]
            java.lang.Long r4 = java.lang.Long.valueOf(r8)
            r2[r10] = r4
            java.lang.String r4 = r7.getMessage()
            r2[r3] = r4
            java.lang.String r2 = r1.get(r2)
            r5 = 1
            r1 = r0
            r3 = r8
            r1.<init>((java.lang.String) r2, (long) r3, (boolean) r5, (java.util.List<? extends java.lang.CharSequence>) r6, (java.lang.Throwable) r7)
            throw r0
        L_0x00a5:
            if (r5 >= r4) goto L_0x00b0
            char r2 = r1.charAt(r5)
            if (r2 != r11) goto L_0x00b0
            int r5 = r5 + 1
            goto L_0x00a5
        L_0x00b0:
            java.lang.String r1 = r1.substring(r5)
            goto L_0x003f
        L_0x00b5:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x02b9
            if (r17 == 0) goto L_0x00d7
            java.lang.Object r1 = r6.get(r3)
            java.lang.StringBuilder r1 = (java.lang.StringBuilder) r1
            java.lang.String r1 = r1.toString()
            java.lang.String r1 = com.unboundid.util.StaticUtils.toLowerCase(r1)
            java.lang.String r2 = "changetype:"
            boolean r1 = r1.startsWith(r2)
            if (r1 != 0) goto L_0x00d7
            java.lang.String r1 = "add"
            goto L_0x0172
        L_0x00d7:
            java.lang.Object r1 = r0.next()
            java.lang.StringBuilder r1 = (java.lang.StringBuilder) r1
            com.unboundid.ldif.TrailingSpaceBehavior r2 = r15.getTrailingSpaceBehavior()
            handleTrailingSpaces(r1, r13, r8, r2)
            java.lang.String r2 = ":"
            int r2 = r1.indexOf(r2)
            if (r2 < 0) goto L_0x02a1
            java.lang.String r4 = r1.substring(r10, r2)
            java.lang.String r5 = "changetype"
            boolean r4 = r4.equalsIgnoreCase(r5)
            if (r4 == 0) goto L_0x02a1
            int r4 = r1.length()
            int r5 = r2 + 1
            if (r4 == r5) goto L_0x0289
            char r14 = r1.charAt(r5)
            if (r14 != r7) goto L_0x0163
            int r2 = r2 + r12
        L_0x0107:
            if (r2 >= r4) goto L_0x0112
            char r5 = r1.charAt(r2)
            if (r5 != r11) goto L_0x0112
            int r2 = r2 + 1
            goto L_0x0107
        L_0x0112:
            java.lang.String r1 = r1.substring(r2)     // Catch:{ ParseException -> 0x0141, Exception -> 0x0123 }
            byte[] r1 = com.unboundid.util.Base64.decode(r1)     // Catch:{ ParseException -> 0x0141, Exception -> 0x0123 }
            java.lang.String r2 = new java.lang.String     // Catch:{ ParseException -> 0x0141, Exception -> 0x0123 }
            java.lang.String r4 = "UTF-8"
            r2.<init>(r1, r4)     // Catch:{ ParseException -> 0x0141, Exception -> 0x0123 }
            r1 = r2
            goto L_0x0172
        L_0x0123:
            r0 = move-exception
            r7 = r0
            com.unboundid.util.Debug.debugException(r7)
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_CANNOT_BASE64_DECODE_CT
            java.lang.Object[] r2 = new java.lang.Object[r12]
            java.lang.Long r4 = java.lang.Long.valueOf(r8)
            r2[r10] = r4
            r2[r3] = r7
            java.lang.String r2 = r1.get(r2)
            r5 = 1
            r1 = r0
            r3 = r8
            r1.<init>((java.lang.String) r2, (long) r3, (boolean) r5, (java.util.List<? extends java.lang.CharSequence>) r6, (java.lang.Throwable) r7)
            throw r0
        L_0x0141:
            r0 = move-exception
            r7 = r0
            com.unboundid.util.Debug.debugException(r7)
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_CANNOT_BASE64_DECODE_CT
            java.lang.Object[] r2 = new java.lang.Object[r12]
            java.lang.Long r4 = java.lang.Long.valueOf(r8)
            r2[r10] = r4
            java.lang.String r4 = r7.getMessage()
            r2[r3] = r4
            java.lang.String r2 = r1.get(r2)
            r5 = 1
            r1 = r0
            r3 = r8
            r1.<init>((java.lang.String) r2, (long) r3, (boolean) r5, (java.util.List<? extends java.lang.CharSequence>) r6, (java.lang.Throwable) r7)
            throw r0
        L_0x0163:
            if (r5 >= r4) goto L_0x016e
            char r2 = r1.charAt(r5)
            if (r2 != r11) goto L_0x016e
            int r5 = r5 + 1
            goto L_0x0163
        L_0x016e:
            java.lang.String r1 = r1.substring(r5)
        L_0x0172:
            java.lang.String r2 = com.unboundid.util.StaticUtils.toLowerCase(r1)
            java.lang.String r4 = "add"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x01cf
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x01b7
            com.unboundid.ldif.DuplicateValueBehavior r2 = r15.getDuplicateValueBehavior()
            com.unboundid.ldif.TrailingSpaceBehavior r3 = r15.getTrailingSpaceBehavior()
            com.unboundid.ldap.sdk.schema.Schema r4 = r15.getSchema()
            r1 = r13
            r5 = r6
            r6 = r0
            r7 = r16
            java.util.ArrayList r0 = parseAttributes(r1, r2, r3, r4, r5, r6, r7, r8)
            int r1 = r0.size()
            com.unboundid.ldap.sdk.Attribute[] r1 = new com.unboundid.ldap.sdk.Attribute[r1]
            java.util.Iterator r0 = r0.iterator()
        L_0x01a3:
            int r2 = r1.length
            if (r10 >= r2) goto L_0x01b1
            java.lang.Object r2 = r0.next()
            com.unboundid.ldap.sdk.Attribute r2 = (com.unboundid.ldap.sdk.Attribute) r2
            r1[r10] = r2
            int r10 = r10 + 1
            goto L_0x01a3
        L_0x01b1:
            com.unboundid.ldif.LDIFAddChangeRecord r0 = new com.unboundid.ldif.LDIFAddChangeRecord
            r0.<init>((java.lang.String) r13, (com.unboundid.ldap.sdk.Attribute[]) r1)
            return r0
        L_0x01b7:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_CR_NO_ATTRIBUTES
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            r2[r10] = r3
            java.lang.String r2 = r1.get(r2)
            r5 = 1
            r7 = 0
            r1 = r0
            r3 = r8
            r1.<init>((java.lang.String) r2, (long) r3, (boolean) r5, (java.util.List<? extends java.lang.CharSequence>) r6, (java.lang.Throwable) r7)
            throw r0
        L_0x01cf:
            java.lang.String r4 = "delete"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x01fb
            boolean r0 = r0.hasNext()
            if (r0 != 0) goto L_0x01e3
            com.unboundid.ldif.LDIFDeleteChangeRecord r0 = new com.unboundid.ldif.LDIFDeleteChangeRecord
            r0.<init>((java.lang.String) r13)
            return r0
        L_0x01e3:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_CR_EXTRA_DELETE_DATA
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            r2[r10] = r3
            java.lang.String r2 = r1.get(r2)
            r5 = 1
            r7 = 0
            r1 = r0
            r3 = r8
            r1.<init>((java.lang.String) r2, (long) r3, (boolean) r5, (java.util.List<? extends java.lang.CharSequence>) r6, (java.lang.Throwable) r7)
            throw r0
        L_0x01fb:
            java.lang.String r4 = "modify"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0233
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x021b
            com.unboundid.ldif.TrailingSpaceBehavior r2 = r15.getTrailingSpaceBehavior()
            r1 = r13
            r3 = r6
            r4 = r0
            r5 = r8
            com.unboundid.ldap.sdk.Modification[] r0 = parseModifications(r1, r2, r3, r4, r5)
            com.unboundid.ldif.LDIFModifyChangeRecord r1 = new com.unboundid.ldif.LDIFModifyChangeRecord
            r1.<init>((java.lang.String) r13, (com.unboundid.ldap.sdk.Modification[]) r0)
            return r1
        L_0x021b:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_CR_NO_MODS
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            r2[r10] = r3
            java.lang.String r2 = r1.get(r2)
            r5 = 1
            r7 = 0
            r1 = r0
            r3 = r8
            r1.<init>((java.lang.String) r2, (long) r3, (boolean) r5, (java.util.List<? extends java.lang.CharSequence>) r6, (java.lang.Throwable) r7)
            throw r0
        L_0x0233:
            java.lang.String r4 = "moddn"
            boolean r4 = r2.equals(r4)
            if (r4 != 0) goto L_0x025e
            java.lang.String r4 = "modrdn"
            boolean r2 = r2.equals(r4)
            if (r2 == 0) goto L_0x0244
            goto L_0x025e
        L_0x0244:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r2 = com.unboundid.ldif.LDIFMessages.ERR_READ_CR_INVALID_CT
            java.lang.Object[] r4 = new java.lang.Object[r12]
            r4[r10] = r1
            java.lang.Long r1 = java.lang.Long.valueOf(r8)
            r4[r3] = r1
            java.lang.String r2 = r2.get(r4)
            r5 = 1
            r7 = 0
            r1 = r0
            r3 = r8
            r1.<init>((java.lang.String) r2, (long) r3, (boolean) r5, (java.util.List<? extends java.lang.CharSequence>) r6, (java.lang.Throwable) r7)
            throw r0
        L_0x025e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0271
            com.unboundid.ldif.TrailingSpaceBehavior r4 = r15.getTrailingSpaceBehavior()
            r1 = r6
            r2 = r0
            r3 = r13
            r5 = r8
            com.unboundid.ldif.LDIFModifyDNChangeRecord r0 = parseModifyDNChangeRecord(r1, r2, r3, r4, r5)
            return r0
        L_0x0271:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_CR_NO_NEWRDN
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            r2[r10] = r3
            java.lang.String r2 = r1.get(r2)
            r5 = 1
            r7 = 0
            r1 = r0
            r3 = r8
            r1.<init>((java.lang.String) r2, (long) r3, (boolean) r5, (java.util.List<? extends java.lang.CharSequence>) r6, (java.lang.Throwable) r7)
            throw r0
        L_0x0289:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_CT_LINE_NO_CT_VALUE
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            r2[r10] = r3
            java.lang.String r2 = r1.get(r2)
            r5 = 1
            r7 = 0
            r1 = r0
            r3 = r8
            r1.<init>((java.lang.String) r2, (long) r3, (boolean) r5, (java.util.List<? extends java.lang.CharSequence>) r6, (java.lang.Throwable) r7)
            throw r0
        L_0x02a1:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_CR_CT_LINE_DOESNT_START_WITH_CT
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            r2[r10] = r3
            java.lang.String r2 = r1.get(r2)
            r5 = 1
            r7 = 0
            r1 = r0
            r3 = r8
            r1.<init>((java.lang.String) r2, (long) r3, (boolean) r5, (java.util.List<? extends java.lang.CharSequence>) r6, (java.lang.Throwable) r7)
            throw r0
        L_0x02b9:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_CR_TOO_SHORT
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            r2[r10] = r3
            java.lang.String r2 = r1.get(r2)
            r5 = 1
            r7 = 0
            r1 = r0
            r3 = r8
            r1.<init>((java.lang.String) r2, (long) r3, (boolean) r5, (java.util.List<? extends java.lang.CharSequence>) r6, (java.lang.Throwable) r7)
            throw r0
        L_0x02d1:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_CR_DN_LINE_DOESNT_START_WITH_DN
            java.lang.Object[] r2 = new java.lang.Object[r3]
            java.lang.Long r3 = java.lang.Long.valueOf(r8)
            r2[r10] = r3
            java.lang.String r2 = r1.get(r2)
            r5 = 1
            r7 = 0
            r1 = r0
            r3 = r8
            r1.<init>((java.lang.String) r2, (long) r3, (boolean) r5, (java.util.List<? extends java.lang.CharSequence>) r6, (java.lang.Throwable) r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldif.LDIFReader.decodeChangeRecord(com.unboundid.ldif.LDIFReader$UnparsedLDIFRecord, java.lang.String, boolean):com.unboundid.ldif.LDIFChangeRecord");
    }

    public static LDIFChangeRecord decodeChangeRecord(boolean z, Schema schema2, boolean z2, String... strArr) {
        LDIFChangeRecord decodeChangeRecord = decodeChangeRecord(prepareRecord(z ? DuplicateValueBehavior.STRIP : DuplicateValueBehavior.REJECT, TrailingSpaceBehavior.REJECT, schema2, strArr), DEFAULT_RELATIVE_BASE_PATH, z2);
        Debug.debugLDIFRead(decodeChangeRecord);
        return decodeChangeRecord;
    }

    public static LDIFChangeRecord decodeChangeRecord(boolean z, String... strArr) {
        LDIFChangeRecord decodeChangeRecord = decodeChangeRecord(prepareRecord(DuplicateValueBehavior.STRIP, TrailingSpaceBehavior.REJECT, (Schema) null, strArr), DEFAULT_RELATIVE_BASE_PATH, z);
        Debug.debugLDIFRead(decodeChangeRecord);
        return decodeChangeRecord;
    }

    public static LDIFChangeRecord decodeChangeRecord(String... strArr) {
        return decodeChangeRecord(false, strArr);
    }

    /* JADX WARNING: Removed duplicated region for block: B:31:0x00bb  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00c5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.unboundid.ldap.sdk.Entry decodeEntry(com.unboundid.ldif.LDIFReader.UnparsedLDIFRecord r13, java.lang.String r14) {
        /*
            java.util.ArrayList r5 = r13.getLineList()
            long r7 = r13.getFirstLineNumber()
            java.util.Iterator r6 = r5.iterator()
            java.lang.Object r0 = r6.next()
            java.lang.StringBuilder r0 = (java.lang.StringBuilder) r0
            com.unboundid.ldif.TrailingSpaceBehavior r1 = r13.getTrailingSpaceBehavior()
            r2 = 0
            handleTrailingSpaces(r0, r2, r7, r1)
            java.lang.String r1 = ":"
            int r1 = r0.indexOf(r1)
            r2 = 0
            r3 = 1
            if (r1 < 0) goto L_0x00e3
            java.lang.String r4 = r0.substring(r2, r1)
            java.lang.String r9 = "dn"
            boolean r4 = r4.equalsIgnoreCase(r9)
            if (r4 == 0) goto L_0x00e3
            int r4 = r0.length()
            int r9 = r1 + 1
            if (r4 != r9) goto L_0x003d
            java.lang.String r0 = ""
        L_0x003a:
            r9 = r0
            goto L_0x00b5
        L_0x003d:
            char r10 = r0.charAt(r9)
            r11 = 58
            r12 = 32
            if (r10 != r11) goto L_0x00a5
            r9 = 2
            int r1 = r1 + r9
        L_0x0049:
            if (r1 >= r4) goto L_0x0054
            char r10 = r0.charAt(r1)
            if (r10 != r12) goto L_0x0054
            int r1 = r1 + 1
            goto L_0x0049
        L_0x0054:
            java.lang.String r0 = r0.substring(r1)     // Catch:{ ParseException -> 0x0083, Exception -> 0x0065 }
            byte[] r0 = com.unboundid.util.Base64.decode(r0)     // Catch:{ ParseException -> 0x0083, Exception -> 0x0065 }
            java.lang.String r1 = new java.lang.String     // Catch:{ ParseException -> 0x0083, Exception -> 0x0065 }
            java.lang.String r4 = "UTF-8"
            r1.<init>(r0, r4)     // Catch:{ ParseException -> 0x0083, Exception -> 0x0065 }
            r9 = r1
            goto L_0x00b5
        L_0x0065:
            r13 = move-exception
            r6 = r13
            com.unboundid.util.Debug.debugException(r6)
            com.unboundid.ldif.LDIFException r13 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r14 = com.unboundid.ldif.LDIFMessages.ERR_READ_CANNOT_BASE64_DECODE_DN
            java.lang.Object[] r0 = new java.lang.Object[r9]
            java.lang.Long r1 = java.lang.Long.valueOf(r7)
            r0[r2] = r1
            r0[r3] = r6
            java.lang.String r1 = r14.get(r0)
            r4 = 1
            r0 = r13
            r2 = r7
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r13
        L_0x0083:
            r13 = move-exception
            r6 = r13
            com.unboundid.util.Debug.debugException(r6)
            com.unboundid.ldif.LDIFException r13 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r14 = com.unboundid.ldif.LDIFMessages.ERR_READ_CANNOT_BASE64_DECODE_DN
            java.lang.Object[] r0 = new java.lang.Object[r9]
            java.lang.Long r1 = java.lang.Long.valueOf(r7)
            r0[r2] = r1
            java.lang.String r1 = r6.getMessage()
            r0[r3] = r1
            java.lang.String r1 = r14.get(r0)
            r4 = 1
            r0 = r13
            r2 = r7
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r13
        L_0x00a5:
            if (r9 >= r4) goto L_0x00b0
            char r1 = r0.charAt(r9)
            if (r1 != r12) goto L_0x00b0
            int r9 = r9 + 1
            goto L_0x00a5
        L_0x00b0:
            java.lang.String r0 = r0.substring(r9)
            goto L_0x003a
        L_0x00b5:
            boolean r0 = r6.hasNext()
            if (r0 != 0) goto L_0x00c5
            com.unboundid.ldap.sdk.Entry r14 = new com.unboundid.ldap.sdk.Entry
            com.unboundid.ldap.sdk.schema.Schema r13 = r13.getSchema()
            r14.<init>((java.lang.String) r9, (com.unboundid.ldap.sdk.schema.Schema) r13)
            return r14
        L_0x00c5:
            com.unboundid.ldap.sdk.Entry r10 = new com.unboundid.ldap.sdk.Entry
            com.unboundid.ldap.sdk.schema.Schema r11 = r13.getSchema()
            com.unboundid.ldif.DuplicateValueBehavior r1 = r13.getDuplicateValueBehavior()
            com.unboundid.ldif.TrailingSpaceBehavior r2 = r13.getTrailingSpaceBehavior()
            com.unboundid.ldap.sdk.schema.Schema r3 = r13.getSchema()
            r0 = r9
            r4 = r5
            r5 = r6
            r6 = r14
            java.util.ArrayList r13 = parseAttributes(r0, r1, r2, r3, r4, r5, r6, r7)
            r10.<init>((java.lang.String) r9, (com.unboundid.ldap.sdk.schema.Schema) r11, (java.util.Collection<com.unboundid.ldap.sdk.Attribute>) r13)
            return r10
        L_0x00e3:
            com.unboundid.ldif.LDIFException r13 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r14 = com.unboundid.ldif.LDIFMessages.ERR_READ_DN_LINE_DOESNT_START_WITH_DN
            java.lang.Object[] r0 = new java.lang.Object[r3]
            java.lang.Long r1 = java.lang.Long.valueOf(r7)
            r0[r2] = r1
            java.lang.String r1 = r14.get(r0)
            r4 = 1
            r6 = 0
            r0 = r13
            r2 = r7
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldif.LDIFReader.decodeEntry(com.unboundid.ldif.LDIFReader$UnparsedLDIFRecord, java.lang.String):com.unboundid.ldap.sdk.Entry");
    }

    public static Entry decodeEntry(boolean z, Schema schema2, String... strArr) {
        Entry decodeEntry = decodeEntry(prepareRecord(z ? DuplicateValueBehavior.STRIP : DuplicateValueBehavior.REJECT, TrailingSpaceBehavior.REJECT, schema2, strArr), DEFAULT_RELATIVE_BASE_PATH);
        Debug.debugLDIFRead(decodeEntry);
        return decodeEntry;
    }

    public static Entry decodeEntry(String... strArr) {
        Entry decodeEntry = decodeEntry(prepareRecord(DuplicateValueBehavior.STRIP, TrailingSpaceBehavior.REJECT, (Schema) null, strArr), DEFAULT_RELATIVE_BASE_PATH);
        Debug.debugLDIFRead(decodeEntry);
        return decodeEntry;
    }

    /* access modifiers changed from: private */
    public static LDIFRecord decodeRecord(UnparsedLDIFRecord unparsedLDIFRecord, String str) {
        Exception access$500 = unparsedLDIFRecord.getFailureCause();
        if (access$500 != null) {
            if (access$500 instanceof LDIFException) {
                LDIFException lDIFException = (LDIFException) access$500;
                throw new LDIFException(lDIFException.getMessage(), lDIFException.getLineNumber(), lDIFException.mayContinueReading(), (List<? extends CharSequence>) lDIFException.getDataLines(), lDIFException.getCause());
            }
            throw new LDIFException(StaticUtils.getExceptionMessage(access$500), -1, true, access$500);
        } else if (unparsedLDIFRecord.isEOF()) {
            return null;
        } else {
            ArrayList access$600 = unparsedLDIFRecord.getLineList();
            if (unparsedLDIFRecord.getLineList() == null) {
                return null;
            }
            LDIFRecord decodeEntry = (access$600.size() <= 1 || !StaticUtils.toLowerCase(((StringBuilder) access$600.get(1)).toString()).startsWith("changetype:")) ? decodeEntry(unparsedLDIFRecord, str) : decodeChangeRecord(unparsedLDIFRecord, str, false);
            Debug.debugLDIFRead(decodeEntry);
            return decodeEntry;
        }
    }

    private static void handleTrailingSpaces(StringBuilder sb, String str, long j, TrailingSpaceBehavior trailingSpaceBehavior2) {
        int length = sb.length() - 1;
        boolean z = false;
        while (length >= 0 && sb.charAt(length) == ' ') {
            length--;
            z = true;
        }
        if (z && sb.charAt(length) != ':') {
            switch (trailingSpaceBehavior2) {
                case STRIP:
                    sb.setLength(length + 1);
                    return;
                case REJECT:
                    if (str == null) {
                        throw new LDIFException(LDIFMessages.ERR_READ_ILLEGAL_TRAILING_SPACE_WITHOUT_DN.get(Long.valueOf(j), sb.toString()), j, true);
                    }
                    throw new LDIFException(LDIFMessages.ERR_READ_ILLEGAL_TRAILING_SPACE_WITH_DN.get(str, Long.valueOf(j), sb.toString()), j, true);
                default:
                    return;
            }
        }
    }

    private boolean isAsync() {
        return this.isAsync;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v26, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v54, resolved type: java.io.FileInputStream} */
    /* JADX WARNING: type inference failed for: r4v53 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<com.unboundid.ldap.sdk.Attribute> parseAttributes(java.lang.String r19, com.unboundid.ldif.DuplicateValueBehavior r20, com.unboundid.ldif.TrailingSpaceBehavior r21, com.unboundid.ldap.sdk.schema.Schema r22, java.util.ArrayList<java.lang.StringBuilder> r23, java.util.Iterator<java.lang.StringBuilder> r24, java.lang.String r25, long r26) {
        /*
            r1 = r19
            r0 = r20
            r2 = r22
            java.util.LinkedHashMap r3 = new java.util.LinkedHashMap
            int r4 = r23.size()
            r3.<init>(r4)
        L_0x000f:
            boolean r4 = r24.hasNext()
            if (r4 == 0) goto L_0x0416
            java.lang.Object r4 = r24.next()
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            r5 = r21
            r12 = r26
            handleTrailingSpaces(r4, r1, r12, r5)
            java.lang.String r6 = ":"
            int r6 = r4.indexOf(r6)
            r14 = 0
            if (r6 <= 0) goto L_0x03f9
            java.lang.String r11 = r4.substring(r14, r6)
            java.lang.String r7 = com.unboundid.util.StaticUtils.toLowerCase(r11)
            if (r2 != 0) goto L_0x003a
            com.unboundid.ldap.matchingrules.CaseIgnoreStringMatchingRule r8 = com.unboundid.ldap.matchingrules.CaseIgnoreStringMatchingRule.getInstance()
            goto L_0x003e
        L_0x003a:
            com.unboundid.ldap.matchingrules.MatchingRule r8 = com.unboundid.ldap.matchingrules.MatchingRule.selectEqualityMatchingRule(r11, r2)
        L_0x003e:
            java.lang.Object r9 = r3.get(r7)
            if (r9 != 0) goto L_0x0046
            r8 = 0
            goto L_0x0064
        L_0x0046:
            boolean r10 = r9 instanceof com.unboundid.ldap.sdk.Attribute
            if (r10 == 0) goto L_0x0061
            r10 = r9
            com.unboundid.ldap.sdk.Attribute r10 = (com.unboundid.ldap.sdk.Attribute) r10
            com.unboundid.ldif.LDIFAttribute r15 = new com.unboundid.ldif.LDIFAttribute
            java.lang.String r2 = r10.getName()
            com.unboundid.asn1.ASN1OctetString[] r10 = r10.getRawValues()
            r10 = r10[r14]
            r15.<init>(r2, r8, r10)
            r3.put(r7, r15)
            r8 = r15
            goto L_0x0064
        L_0x0061:
            r8 = r9
            com.unboundid.ldif.LDIFAttribute r8 = (com.unboundid.ldif.LDIFAttribute) r8
        L_0x0064:
            int r2 = r4.length()
            int r10 = r6 + 1
            r15 = 3
            r16 = 2
            if (r2 != r10) goto L_0x00db
            if (r9 != 0) goto L_0x007e
            com.unboundid.ldap.sdk.Attribute r2 = new com.unboundid.ldap.sdk.Attribute
            java.lang.String r4 = ""
            r2.<init>((java.lang.String) r11, (java.lang.String) r4)
            r3.put(r7, r2)
        L_0x007b:
            r6 = r0
            goto L_0x03c8
        L_0x007e:
            com.unboundid.asn1.ASN1OctetString r2 = new com.unboundid.asn1.ASN1OctetString     // Catch:{ LDAPException -> 0x00b2 }
            r2.<init>()     // Catch:{ LDAPException -> 0x00b2 }
            boolean r2 = r8.addValue(r2, r0)     // Catch:{ LDAPException -> 0x00b2 }
            if (r2 != 0) goto L_0x007b
            com.unboundid.ldif.DuplicateValueBehavior r2 = com.unboundid.ldif.DuplicateValueBehavior.STRIP     // Catch:{ LDAPException -> 0x00b2 }
            if (r0 != r2) goto L_0x008e
            goto L_0x007b
        L_0x008e:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException     // Catch:{ LDAPException -> 0x00b2 }
            com.unboundid.ldif.LDIFMessages r2 = com.unboundid.ldif.LDIFMessages.ERR_READ_DUPLICATE_VALUE     // Catch:{ LDAPException -> 0x00b2 }
            java.lang.Object[] r3 = new java.lang.Object[r15]     // Catch:{ LDAPException -> 0x00b2 }
            r3[r14] = r1     // Catch:{ LDAPException -> 0x00b2 }
            java.lang.Long r4 = java.lang.Long.valueOf(r26)     // Catch:{ LDAPException -> 0x00b2 }
            r5 = 1
            r3[r5] = r4     // Catch:{ LDAPException -> 0x00b2 }
            r3[r16] = r11     // Catch:{ LDAPException -> 0x00b2 }
            java.lang.String r6 = r2.get(r3)     // Catch:{ LDAPException -> 0x00b2 }
            r9 = 1
            r2 = 0
            r5 = r0
            r7 = r26
            r10 = r23
            r4 = r11
            r11 = r2
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)     // Catch:{ LDAPException -> 0x00b0 }
            throw r0     // Catch:{ LDAPException -> 0x00b0 }
        L_0x00b0:
            r0 = move-exception
            goto L_0x00b4
        L_0x00b2:
            r0 = move-exception
            r4 = r11
        L_0x00b4:
            r11 = r0
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r2 = com.unboundid.ldif.LDIFMessages.ERR_READ_VALUE_SYNTAX_VIOLATION
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r14] = r1
            java.lang.Long r1 = java.lang.Long.valueOf(r26)
            r5 = 1
            r3[r5] = r1
            r3[r16] = r4
            java.lang.String r1 = com.unboundid.util.StaticUtils.getExceptionMessage(r11)
            r3[r15] = r1
            java.lang.String r6 = r2.get(r3)
            r9 = 1
            r5 = r0
            r7 = r26
            r10 = r23
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)
            throw r0
        L_0x00db:
            char r14 = r4.charAt(r10)
            r15 = 58
            r5 = 32
            if (r14 != r15) goto L_0x0195
            int r6 = r6 + 2
        L_0x00e7:
            if (r6 >= r2) goto L_0x00f2
            char r10 = r4.charAt(r6)
            if (r10 != r5) goto L_0x00f2
            int r6 = r6 + 1
            goto L_0x00e7
        L_0x00f2:
            java.lang.String r2 = r4.substring(r6)     // Catch:{ ParseException -> 0x016a }
            byte[] r2 = com.unboundid.util.Base64.decode(r2)     // Catch:{ ParseException -> 0x016a }
            if (r9 != 0) goto L_0x0106
            com.unboundid.ldap.sdk.Attribute r4 = new com.unboundid.ldap.sdk.Attribute     // Catch:{ ParseException -> 0x016a }
            r4.<init>((java.lang.String) r11, (byte[]) r2)     // Catch:{ ParseException -> 0x016a }
            r3.put(r7, r4)     // Catch:{ ParseException -> 0x016a }
            goto L_0x007b
        L_0x0106:
            com.unboundid.asn1.ASN1OctetString r4 = new com.unboundid.asn1.ASN1OctetString     // Catch:{ LDAPException -> 0x013d }
            r4.<init>((byte[]) r2)     // Catch:{ LDAPException -> 0x013d }
            boolean r2 = r8.addValue(r4, r0)     // Catch:{ LDAPException -> 0x013d }
            if (r2 != 0) goto L_0x007b
            com.unboundid.ldif.DuplicateValueBehavior r2 = com.unboundid.ldif.DuplicateValueBehavior.STRIP     // Catch:{ LDAPException -> 0x013d }
            if (r0 != r2) goto L_0x0117
            goto L_0x007b
        L_0x0117:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException     // Catch:{ LDAPException -> 0x013d }
            com.unboundid.ldif.LDIFMessages r2 = com.unboundid.ldif.LDIFMessages.ERR_READ_DUPLICATE_VALUE     // Catch:{ LDAPException -> 0x013d }
            r3 = 3
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ LDAPException -> 0x013d }
            r3 = 0
            r4[r3] = r1     // Catch:{ LDAPException -> 0x013d }
            java.lang.Long r3 = java.lang.Long.valueOf(r26)     // Catch:{ LDAPException -> 0x013d }
            r5 = 1
            r4[r5] = r3     // Catch:{ LDAPException -> 0x013d }
            r4[r16] = r11     // Catch:{ LDAPException -> 0x013d }
            java.lang.String r6 = r2.get(r4)     // Catch:{ LDAPException -> 0x013d }
            r9 = 1
            r2 = 0
            r5 = r0
            r7 = r26
            r10 = r23
            r14 = r11
            r11 = r2
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)     // Catch:{ LDAPException -> 0x013b }
            throw r0     // Catch:{ LDAPException -> 0x013b }
        L_0x013b:
            r0 = move-exception
            goto L_0x013f
        L_0x013d:
            r0 = move-exception
            r14 = r11
        L_0x013f:
            r11 = r0
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException     // Catch:{ ParseException -> 0x0168 }
            com.unboundid.ldif.LDIFMessages r2 = com.unboundid.ldif.LDIFMessages.ERR_READ_VALUE_SYNTAX_VIOLATION     // Catch:{ ParseException -> 0x0168 }
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ ParseException -> 0x0168 }
            r4 = 0
            r3[r4] = r1     // Catch:{ ParseException -> 0x0168 }
            java.lang.Long r1 = java.lang.Long.valueOf(r26)     // Catch:{ ParseException -> 0x0168 }
            r4 = 1
            r3[r4] = r1     // Catch:{ ParseException -> 0x0168 }
            r3[r16] = r14     // Catch:{ ParseException -> 0x0168 }
            java.lang.String r1 = com.unboundid.util.StaticUtils.getExceptionMessage(r11)     // Catch:{ ParseException -> 0x0168 }
            r4 = 3
            r3[r4] = r1     // Catch:{ ParseException -> 0x0168 }
            java.lang.String r6 = r2.get(r3)     // Catch:{ ParseException -> 0x0168 }
            r9 = 1
            r5 = r0
            r7 = r26
            r10 = r23
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)     // Catch:{ ParseException -> 0x0168 }
            throw r0     // Catch:{ ParseException -> 0x0168 }
        L_0x0168:
            r0 = move-exception
            goto L_0x016c
        L_0x016a:
            r0 = move-exception
            r14 = r11
        L_0x016c:
            r11 = r0
            com.unboundid.util.Debug.debugException(r11)
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_CANNOT_BASE64_DECODE_ATTR
            r2 = 3
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r14
            java.lang.Long r3 = java.lang.Long.valueOf(r26)
            r4 = 1
            r2[r4] = r3
            java.lang.String r3 = r11.getMessage()
            r2[r16] = r3
            java.lang.String r6 = r1.get(r2)
            r9 = 1
            r5 = r0
            r7 = r26
            r10 = r23
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)
            throw r0
        L_0x0195:
            r14 = r11
            char r11 = r4.charAt(r10)
            r15 = 60
            if (r11 != r15) goto L_0x037a
            int r6 = r6 + 2
        L_0x01a0:
            if (r6 >= r2) goto L_0x01ab
            char r10 = r4.charAt(r6)
            if (r10 != r5) goto L_0x01ab
            int r6 = r6 + 1
            goto L_0x01a0
        L_0x01ab:
            java.lang.String r2 = r4.substring(r6)
            java.lang.String r4 = com.unboundid.util.StaticUtils.toLowerCase(r2)
            java.lang.String r5 = "file:/"
            boolean r5 = r4.startsWith(r5)
            r6 = 5
            if (r5 == 0) goto L_0x01d7
            r4 = 6
        L_0x01bd:
            int r5 = r2.length()
            if (r4 >= r5) goto L_0x01ce
            char r5 = r2.charAt(r4)
            r10 = 47
            if (r5 != r10) goto L_0x01ce
            int r4 = r4 + 1
            goto L_0x01bd
        L_0x01ce:
            int r4 = r4 + -1
            java.lang.String r4 = r2.substring(r4)
            r11 = r25
            goto L_0x01f4
        L_0x01d7:
            java.lang.String r5 = "file:"
            boolean r4 = r4.startsWith(r5)
            if (r4 == 0) goto L_0x0358
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r11 = r25
            r4.append(r11)
            java.lang.String r5 = r2.substring(r6)
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L_0x01f4:
            java.io.File r5 = new java.io.File     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r5.<init>(r4)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            boolean r4 = r5.exists()     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            if (r4 == 0) goto L_0x0301
            r15 = r7
            long r6 = r5.length()     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r17 = 10485760(0xa00000, double:5.180654E-317)
            int r10 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r10 > 0) goto L_0x02cf
            int r4 = (int) r6     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            byte[] r10 = new byte[r4]     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            java.io.FileInputStream r11 = new java.io.FileInputStream     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r11.<init>(r5)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r12 = r4
            r4 = 0
        L_0x0215:
            long r0 = (long) r4
            int r13 = (r0 > r6 ? 1 : (r0 == r6 ? 0 : -1))
            if (r13 >= 0) goto L_0x0252
            int r0 = r11.read(r10, r4, r12)     // Catch:{ all -> 0x024e }
            if (r0 < 0) goto L_0x0223
            int r4 = r4 + r0
            int r12 = r12 - r0
            goto L_0x0215
        L_0x0223:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException     // Catch:{ all -> 0x024e }
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_URL_FILE_SIZE_CHANGED     // Catch:{ all -> 0x024e }
            r3 = 4
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ all -> 0x024e }
            r3 = 0
            r4[r3] = r14     // Catch:{ all -> 0x024e }
            r3 = 1
            r4[r3] = r2     // Catch:{ all -> 0x024e }
            java.lang.Long r3 = java.lang.Long.valueOf(r26)     // Catch:{ all -> 0x024e }
            r4[r16] = r3     // Catch:{ all -> 0x024e }
            java.lang.String r3 = r5.getAbsolutePath()     // Catch:{ all -> 0x024e }
            r5 = 3
            r4[r5] = r3     // Catch:{ all -> 0x024e }
            java.lang.String r6 = r1.get(r4)     // Catch:{ all -> 0x024e }
            r9 = 1
            r1 = 0
            r5 = r0
            r7 = r26
            r10 = r23
            r4 = r11
            r11 = r1
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)     // Catch:{ all -> 0x02ca }
            throw r0     // Catch:{ all -> 0x02ca }
        L_0x024e:
            r0 = move-exception
            r4 = r11
            goto L_0x02cb
        L_0x0252:
            r4 = r11
            int r0 = r4.read()     // Catch:{ all -> 0x02ca }
            r1 = -1
            if (r0 != r1) goto L_0x02a1
            r4.close()     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            if (r9 != 0) goto L_0x026c
            com.unboundid.ldap.sdk.Attribute r0 = new com.unboundid.ldap.sdk.Attribute     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r0.<init>((java.lang.String) r14, (byte[]) r10)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r1 = r15
            r3.put(r1, r0)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r6 = r20
            goto L_0x03c8
        L_0x026c:
            com.unboundid.asn1.ASN1OctetString r0 = new com.unboundid.asn1.ASN1OctetString     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r0.<init>((byte[]) r10)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r6 = r20
            boolean r0 = r8.addValue(r0, r6)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            if (r0 != 0) goto L_0x03c8
            com.unboundid.ldif.DuplicateValueBehavior r0 = com.unboundid.ldif.DuplicateValueBehavior.STRIP     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            if (r6 != r0) goto L_0x027f
            goto L_0x03c8
        L_0x027f:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_DUPLICATE_VALUE     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r3 = 3
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r3 = 0
            r4[r3] = r19     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            java.lang.Long r3 = java.lang.Long.valueOf(r26)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r5 = 1
            r4[r5] = r3     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r4[r16] = r14     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            java.lang.String r6 = r1.get(r4)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r9 = 1
            r11 = 0
            r5 = r0
            r7 = r26
            r10 = r23
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            throw r0     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
        L_0x02a1:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException     // Catch:{ all -> 0x02ca }
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_URL_FILE_SIZE_CHANGED     // Catch:{ all -> 0x02ca }
            r3 = 4
            java.lang.Object[] r6 = new java.lang.Object[r3]     // Catch:{ all -> 0x02ca }
            r3 = 0
            r6[r3] = r14     // Catch:{ all -> 0x02ca }
            r3 = 1
            r6[r3] = r2     // Catch:{ all -> 0x02ca }
            java.lang.Long r3 = java.lang.Long.valueOf(r26)     // Catch:{ all -> 0x02ca }
            r6[r16] = r3     // Catch:{ all -> 0x02ca }
            java.lang.String r3 = r5.getAbsolutePath()     // Catch:{ all -> 0x02ca }
            r5 = 3
            r6[r5] = r3     // Catch:{ all -> 0x02ca }
            java.lang.String r6 = r1.get(r6)     // Catch:{ all -> 0x02ca }
            r9 = 1
            r11 = 0
            r5 = r0
            r7 = r26
            r10 = r23
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)     // Catch:{ all -> 0x02ca }
            throw r0     // Catch:{ all -> 0x02ca }
        L_0x02ca:
            r0 = move-exception
        L_0x02cb:
            r4.close()     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            throw r0     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
        L_0x02cf:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_URL_FILE_TOO_LARGE     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r3 = 5
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r4 = 0
            r3[r4] = r14     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r4 = 1
            r3[r4] = r2     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            java.lang.Long r4 = java.lang.Long.valueOf(r26)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r3[r16] = r4     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            java.lang.String r4 = r5.getAbsolutePath()     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r5 = 3
            r3[r5] = r4     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r4 = 10485760(0xa00000, float:1.469368E-38)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r5 = 4
            r3[r5] = r4     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            java.lang.String r6 = r1.get(r3)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r9 = 1
            r11 = 0
            r5 = r0
            r7 = r26
            r10 = r23
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            throw r0     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
        L_0x0301:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_URL_NO_SUCH_FILE     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r3 = 4
            java.lang.Object[] r4 = new java.lang.Object[r3]     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r3 = 0
            r4[r3] = r14     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r3 = 1
            r4[r3] = r2     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            java.lang.Long r3 = java.lang.Long.valueOf(r26)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r4[r16] = r3     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            java.lang.String r3 = r5.getAbsolutePath()     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r5 = 3
            r4[r5] = r3     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            java.lang.String r6 = r1.get(r4)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            r9 = 1
            r11 = 0
            r5 = r0
            r7 = r26
            r10 = r23
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
            throw r0     // Catch:{ LDIFException -> 0x0353, Exception -> 0x032a }
        L_0x032a:
            r0 = move-exception
            r11 = r0
            com.unboundid.util.Debug.debugException(r11)
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_URL_EXCEPTION
            r3 = 4
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r14
            r4 = 1
            r3[r4] = r2
            java.lang.Long r2 = java.lang.Long.valueOf(r26)
            r3[r16] = r2
            r2 = 3
            r3[r2] = r11
            java.lang.String r6 = r1.get(r3)
            r9 = 1
            r5 = r0
            r7 = r26
            r10 = r23
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)
            throw r0
        L_0x0353:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)
            throw r0
        L_0x0358:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_URL_INVALID_SCHEME
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r14
            r4 = 1
            r3[r4] = r2
            java.lang.Long r2 = java.lang.Long.valueOf(r26)
            r3[r16] = r2
            java.lang.String r6 = r1.get(r3)
            r9 = 1
            r11 = 0
            r5 = r0
            r7 = r26
            r10 = r23
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)
            throw r0
        L_0x037a:
            r6 = r0
            r1 = r7
        L_0x037c:
            if (r10 >= r2) goto L_0x0387
            char r0 = r4.charAt(r10)
            if (r0 != r5) goto L_0x0387
            int r10 = r10 + 1
            goto L_0x037c
        L_0x0387:
            java.lang.String r0 = r4.substring(r10)
            if (r9 != 0) goto L_0x0396
            com.unboundid.ldap.sdk.Attribute r2 = new com.unboundid.ldap.sdk.Attribute
            r2.<init>((java.lang.String) r14, (java.lang.String) r0)
            r3.put(r1, r2)
            goto L_0x03c8
        L_0x0396:
            com.unboundid.asn1.ASN1OctetString r1 = new com.unboundid.asn1.ASN1OctetString     // Catch:{ LDAPException -> 0x03cf }
            r1.<init>((java.lang.String) r0)     // Catch:{ LDAPException -> 0x03cf }
            boolean r0 = r8.addValue(r1, r6)     // Catch:{ LDAPException -> 0x03cf }
            if (r0 != 0) goto L_0x03c8
            com.unboundid.ldif.DuplicateValueBehavior r0 = com.unboundid.ldif.DuplicateValueBehavior.STRIP     // Catch:{ LDAPException -> 0x03cf }
            if (r6 != r0) goto L_0x03a6
            goto L_0x03c8
        L_0x03a6:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException     // Catch:{ LDAPException -> 0x03cf }
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_DUPLICATE_VALUE     // Catch:{ LDAPException -> 0x03cf }
            r2 = 3
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ LDAPException -> 0x03cf }
            r2 = 0
            r3[r2] = r19     // Catch:{ LDAPException -> 0x03cf }
            java.lang.Long r2 = java.lang.Long.valueOf(r26)     // Catch:{ LDAPException -> 0x03cf }
            r4 = 1
            r3[r4] = r2     // Catch:{ LDAPException -> 0x03cf }
            r3[r16] = r14     // Catch:{ LDAPException -> 0x03cf }
            java.lang.String r6 = r1.get(r3)     // Catch:{ LDAPException -> 0x03cf }
            r9 = 1
            r11 = 0
            r5 = r0
            r7 = r26
            r10 = r23
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)     // Catch:{ LDAPException -> 0x03cf }
            throw r0     // Catch:{ LDAPException -> 0x03cf }
        L_0x03c8:
            r2 = r22
            r1 = r19
            r0 = r6
            goto L_0x000f
        L_0x03cf:
            r0 = move-exception
            r11 = r0
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_VALUE_SYNTAX_VIOLATION
            r2 = 4
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = 0
            r2[r3] = r19
            java.lang.Long r3 = java.lang.Long.valueOf(r26)
            r4 = 1
            r2[r4] = r3
            r2[r16] = r14
            java.lang.String r3 = com.unboundid.util.StaticUtils.getExceptionMessage(r11)
            r4 = 3
            r2[r4] = r3
            java.lang.String r6 = r1.get(r2)
            r9 = 1
            r5 = r0
            r7 = r26
            r10 = r23
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)
            throw r0
        L_0x03f9:
            com.unboundid.ldif.LDIFException r0 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r1 = com.unboundid.ldif.LDIFMessages.ERR_READ_NO_ATTR_COLON
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Long r3 = java.lang.Long.valueOf(r26)
            r4 = 0
            r2[r4] = r3
            java.lang.String r6 = r1.get(r2)
            r9 = 1
            r11 = 0
            r5 = r0
            r7 = r26
            r10 = r23
            r5.<init>((java.lang.String) r6, (long) r7, (boolean) r9, (java.util.List<? extends java.lang.CharSequence>) r10, (java.lang.Throwable) r11)
            throw r0
        L_0x0416:
            java.util.ArrayList r0 = new java.util.ArrayList
            int r1 = r3.size()
            r0.<init>(r1)
            java.util.Collection r1 = r3.values()
            java.util.Iterator r1 = r1.iterator()
        L_0x0427:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0442
            java.lang.Object r2 = r1.next()
            boolean r3 = r2 instanceof com.unboundid.ldap.sdk.Attribute
            if (r3 == 0) goto L_0x0438
            com.unboundid.ldap.sdk.Attribute r2 = (com.unboundid.ldap.sdk.Attribute) r2
            goto L_0x043e
        L_0x0438:
            com.unboundid.ldif.LDIFAttribute r2 = (com.unboundid.ldif.LDIFAttribute) r2
            com.unboundid.ldap.sdk.Attribute r2 = r2.toAttribute()
        L_0x043e:
            r0.add(r2)
            goto L_0x0427
        L_0x0442:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldif.LDIFReader.parseAttributes(java.lang.String, com.unboundid.ldif.DuplicateValueBehavior, com.unboundid.ldif.TrailingSpaceBehavior, com.unboundid.ldap.sdk.schema.Schema, java.util.ArrayList, java.util.Iterator, java.lang.String, long):java.util.ArrayList");
    }

    private static Modification[] parseModifications(String str, TrailingSpaceBehavior trailingSpaceBehavior2, ArrayList<StringBuilder> arrayList, Iterator<StringBuilder> it, long j) {
        ModificationType modificationType;
        String str2;
        ASN1OctetString aSN1OctetString;
        String str3 = str;
        TrailingSpaceBehavior trailingSpaceBehavior3 = trailingSpaceBehavior2;
        long j2 = j;
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        while (it.hasNext()) {
            StringBuilder next = it.next();
            handleTrailingSpaces(next, str3, j2, trailingSpaceBehavior3);
            int indexOf = next.indexOf(":");
            int i = 0;
            if (indexOf >= 0) {
                String lowerCase = StaticUtils.toLowerCase(next.substring(0, indexOf));
                if (lowerCase.equals("add")) {
                    modificationType = ModificationType.ADD;
                } else if (lowerCase.equals("delete")) {
                    modificationType = ModificationType.DELETE;
                } else if (lowerCase.equals("replace")) {
                    modificationType = ModificationType.REPLACE;
                } else if (lowerCase.equals("increment")) {
                    modificationType = ModificationType.INCREMENT;
                } else {
                    throw new LDIFException(LDIFMessages.ERR_READ_MOD_CR_INVALID_MODTYPE.get(lowerCase, Long.valueOf(j)), j, true, (List<? extends CharSequence>) arrayList, (Throwable) null);
                }
                int length = next.length();
                int i2 = indexOf + 1;
                if (length != i2) {
                    if (next.charAt(i2) == ':') {
                        int i3 = indexOf + 2;
                        while (i3 < length && next.charAt(i3) == ' ') {
                            i3++;
                        }
                        try {
                            str2 = new String(Base64.decode(next.substring(i3)), "UTF-8");
                        } catch (ParseException e) {
                            ParseException parseException = e;
                            Debug.debugException(parseException);
                            throw new LDIFException(LDIFMessages.ERR_READ_MOD_CR_MODTYPE_CANNOT_BASE64_DECODE_ATTR.get(Long.valueOf(j), parseException.getMessage()), j, true, (List<? extends CharSequence>) arrayList, (Throwable) parseException);
                        } catch (Exception e2) {
                            Exception exc = e2;
                            Debug.debugException(exc);
                            throw new LDIFException(LDIFMessages.ERR_READ_MOD_CR_MODTYPE_CANNOT_BASE64_DECODE_ATTR.get(Long.valueOf(j), exc), j, true, (List<? extends CharSequence>) arrayList, (Throwable) exc);
                        }
                    } else {
                        while (i2 < length && next.charAt(i2) == ' ') {
                            i2++;
                        }
                        str2 = next.substring(i2);
                    }
                    if (str2.length() != 0) {
                        ArrayList arrayList3 = new ArrayList(arrayList.size());
                        while (it.hasNext()) {
                            StringBuilder next2 = it.next();
                            handleTrailingSpaces(next2, str3, j2, trailingSpaceBehavior3);
                            if (next2.toString().equals("-")) {
                                break;
                            }
                            int indexOf2 = next2.indexOf(":");
                            if (indexOf2 < 0) {
                                throw new LDIFException(LDIFMessages.ERR_READ_NO_ATTR_COLON.get(Long.valueOf(j)), j, true, (List<? extends CharSequence>) arrayList, (Throwable) null);
                            } else if (next2.substring(i, indexOf2).equalsIgnoreCase(str2)) {
                                int length2 = next2.length();
                                int i4 = indexOf2 + 1;
                                if (length2 == i4) {
                                    aSN1OctetString = new ASN1OctetString();
                                } else if (next2.charAt(i4) == ':') {
                                    int i5 = indexOf2 + 2;
                                    while (i5 < length2 && next2.charAt(i5) == ' ') {
                                        i5++;
                                    }
                                    try {
                                        aSN1OctetString = new ASN1OctetString(Base64.decode(next2.substring(i5)));
                                    } catch (ParseException e3) {
                                        ParseException parseException2 = e3;
                                        Debug.debugException(parseException2);
                                        throw new LDIFException(LDIFMessages.ERR_READ_CANNOT_BASE64_DECODE_ATTR.get(str2, Long.valueOf(j), parseException2.getMessage()), j, true, (List<? extends CharSequence>) arrayList, (Throwable) parseException2);
                                    } catch (Exception e4) {
                                        Exception exc2 = e4;
                                        Debug.debugException(exc2);
                                        throw new LDIFException(LDIFMessages.ERR_READ_CANNOT_BASE64_DECODE_ATTR.get(Long.valueOf(j), exc2), j, true, (List<? extends CharSequence>) arrayList, (Throwable) exc2);
                                    }
                                } else {
                                    while (i4 < length2 && next2.charAt(i4) == ' ') {
                                        i4++;
                                    }
                                    aSN1OctetString = new ASN1OctetString(next2.substring(i4));
                                }
                                arrayList3.add(aSN1OctetString);
                                i = 0;
                            } else {
                                throw new LDIFException(LDIFMessages.ERR_READ_MOD_CR_ATTR_MISMATCH.get(Long.valueOf(j), next2.substring(0, indexOf2), str2), j, true, (List<? extends CharSequence>) arrayList, (Throwable) null);
                            }
                        }
                        ASN1OctetString[] aSN1OctetStringArr = new ASN1OctetString[arrayList3.size()];
                        arrayList3.toArray(aSN1OctetStringArr);
                        if (modificationType.intValue() == ModificationType.ADD.intValue() && aSN1OctetStringArr.length == 0) {
                            throw new LDIFException(LDIFMessages.ERR_READ_MOD_CR_NO_ADD_VALUES.get(str2, Long.valueOf(j)), j, true, (List<? extends CharSequence>) arrayList, (Throwable) null);
                        } else if (modificationType.intValue() != ModificationType.INCREMENT.intValue() || aSN1OctetStringArr.length == 1) {
                            arrayList2.add(new Modification(modificationType, str2, aSN1OctetStringArr));
                        } else {
                            throw new LDIFException(LDIFMessages.ERR_READ_MOD_CR_INVALID_INCR_VALUE_COUNT.get(Long.valueOf(j), str2), j, true, (List<? extends CharSequence>) arrayList, (Throwable) null);
                        }
                    } else {
                        throw new LDIFException(LDIFMessages.ERR_READ_MOD_CR_MODTYPE_NO_ATTR.get(Long.valueOf(j)), j, true, (List<? extends CharSequence>) arrayList, (Throwable) null);
                    }
                } else {
                    throw new LDIFException(LDIFMessages.ERR_READ_MOD_CR_MODTYPE_NO_ATTR.get(Long.valueOf(j)), j, true, (List<? extends CharSequence>) arrayList, (Throwable) null);
                }
            } else {
                throw new LDIFException(LDIFMessages.ERR_READ_MOD_CR_NO_MODTYPE.get(Long.valueOf(j)), j, true, (List<? extends CharSequence>) arrayList, (Throwable) null);
            }
        }
        Modification[] modificationArr = new Modification[arrayList2.size()];
        arrayList2.toArray(modificationArr);
        return modificationArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:104:0x0266  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x026d  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0273  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x01a9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.unboundid.ldif.LDIFModifyDNChangeRecord parseModifyDNChangeRecord(java.util.ArrayList<java.lang.StringBuilder> r15, java.util.Iterator<java.lang.StringBuilder> r16, java.lang.String r17, com.unboundid.ldif.TrailingSpaceBehavior r18, long r19) {
        /*
            r0 = r17
            r1 = r18
            r2 = r19
            java.lang.Object r4 = r16.next()
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            handleTrailingSpaces(r4, r0, r2, r1)
            java.lang.String r5 = ":"
            int r5 = r4.indexOf(r5)
            r6 = 0
            r7 = 1
            if (r5 < 0) goto L_0x030f
            java.lang.String r8 = r4.substring(r6, r5)
            java.lang.String r9 = "newrdn"
            boolean r8 = r8.equalsIgnoreCase(r9)
            if (r8 == 0) goto L_0x030f
            int r8 = r4.length()
            int r9 = r5 + 1
            if (r8 == r9) goto L_0x02f5
            char r10 = r4.charAt(r9)
            r11 = 58
            r12 = 32
            r13 = 2
            if (r10 != r11) goto L_0x009a
            int r5 = r5 + r13
        L_0x0039:
            if (r5 >= r8) goto L_0x0044
            char r9 = r4.charAt(r5)
            if (r9 != r12) goto L_0x0044
            int r5 = r5 + 1
            goto L_0x0039
        L_0x0044:
            java.lang.String r4 = r4.substring(r5)     // Catch:{ ParseException -> 0x0075, Exception -> 0x0054 }
            byte[] r4 = com.unboundid.util.Base64.decode(r4)     // Catch:{ ParseException -> 0x0075, Exception -> 0x0054 }
            java.lang.String r5 = new java.lang.String     // Catch:{ ParseException -> 0x0075, Exception -> 0x0054 }
            java.lang.String r8 = "UTF-8"
            r5.<init>(r4, r8)     // Catch:{ ParseException -> 0x0075, Exception -> 0x0054 }
            goto L_0x00a9
        L_0x0054:
            r0 = move-exception
            r8 = r0
            com.unboundid.util.Debug.debugException(r8)
            com.unboundid.ldif.LDIFException r9 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_CANNOT_BASE64_DECODE_NEWRDN
            java.lang.Object[] r1 = new java.lang.Object[r13]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            r1[r7] = r8
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r0 = r9
            r2 = r19
            r5 = r15
            r6 = r8
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r9
        L_0x0075:
            r0 = move-exception
            r8 = r0
            com.unboundid.util.Debug.debugException(r8)
            com.unboundid.ldif.LDIFException r9 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_CANNOT_BASE64_DECODE_NEWRDN
            java.lang.Object[] r1 = new java.lang.Object[r13]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            java.lang.String r4 = r8.getMessage()
            r1[r7] = r4
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r0 = r9
            r2 = r19
            r5 = r15
            r6 = r8
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r9
        L_0x009a:
            if (r9 >= r8) goto L_0x00a5
            char r5 = r4.charAt(r9)
            if (r5 != r12) goto L_0x00a5
            int r9 = r9 + 1
            goto L_0x009a
        L_0x00a5:
            java.lang.String r5 = r4.substring(r9)
        L_0x00a9:
            int r4 = r5.length()
            if (r4 == 0) goto L_0x02db
            boolean r4 = r16.hasNext()
            if (r4 == 0) goto L_0x02c1
            java.lang.Object r4 = r16.next()
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            handleTrailingSpaces(r4, r0, r2, r1)
            java.lang.String r8 = ":"
            int r8 = r4.indexOf(r8)
            if (r8 < 0) goto L_0x02a7
            java.lang.String r9 = r4.substring(r6, r8)
            java.lang.String r10 = "deleteoldrdn"
            boolean r9 = r9.equalsIgnoreCase(r10)
            if (r9 == 0) goto L_0x02a7
            int r9 = r4.length()
            int r10 = r8 + 1
            if (r9 == r10) goto L_0x028d
            char r14 = r4.charAt(r10)
            if (r14 != r11) goto L_0x0142
            int r8 = r8 + r13
        L_0x00e1:
            if (r8 >= r9) goto L_0x00ec
            char r10 = r4.charAt(r8)
            if (r10 != r12) goto L_0x00ec
            int r8 = r8 + 1
            goto L_0x00e1
        L_0x00ec:
            java.lang.String r4 = r4.substring(r8)     // Catch:{ ParseException -> 0x011d, Exception -> 0x00fc }
            byte[] r4 = com.unboundid.util.Base64.decode(r4)     // Catch:{ ParseException -> 0x011d, Exception -> 0x00fc }
            java.lang.String r8 = new java.lang.String     // Catch:{ ParseException -> 0x011d, Exception -> 0x00fc }
            java.lang.String r9 = "UTF-8"
            r8.<init>(r4, r9)     // Catch:{ ParseException -> 0x011d, Exception -> 0x00fc }
            goto L_0x0151
        L_0x00fc:
            r0 = move-exception
            r8 = r0
            com.unboundid.util.Debug.debugException(r8)
            com.unboundid.ldif.LDIFException r9 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_CANNOT_BASE64_DECODE_DELOLDRDN
            java.lang.Object[] r1 = new java.lang.Object[r13]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            r1[r7] = r8
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r0 = r9
            r2 = r19
            r5 = r15
            r6 = r8
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r9
        L_0x011d:
            r0 = move-exception
            r8 = r0
            com.unboundid.util.Debug.debugException(r8)
            com.unboundid.ldif.LDIFException r9 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_CANNOT_BASE64_DECODE_DELOLDRDN
            java.lang.Object[] r1 = new java.lang.Object[r13]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            java.lang.String r4 = r8.getMessage()
            r1[r7] = r4
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r0 = r9
            r2 = r19
            r5 = r15
            r6 = r8
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r9
        L_0x0142:
            if (r10 >= r9) goto L_0x014d
            char r8 = r4.charAt(r10)
            if (r8 != r12) goto L_0x014d
            int r10 = r10 + 1
            goto L_0x0142
        L_0x014d:
            java.lang.String r8 = r4.substring(r10)
        L_0x0151:
            java.lang.String r4 = "0"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x015b
        L_0x0159:
            r4 = 0
            goto L_0x01a3
        L_0x015b:
            java.lang.String r4 = "1"
            boolean r4 = r8.equals(r4)
            if (r4 == 0) goto L_0x0165
            r4 = 1
            goto L_0x01a3
        L_0x0165:
            java.lang.String r4 = "false"
            boolean r4 = r8.equalsIgnoreCase(r4)
            if (r4 != 0) goto L_0x0159
            java.lang.String r4 = "no"
            boolean r4 = r8.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0176
            goto L_0x0159
        L_0x0176:
            java.lang.String r4 = "true"
            boolean r4 = r8.equalsIgnoreCase(r4)
            if (r4 != 0) goto L_0x0159
            java.lang.String r4 = "yes"
            boolean r4 = r8.equalsIgnoreCase(r4)
            if (r4 == 0) goto L_0x0187
            goto L_0x0159
        L_0x0187:
            com.unboundid.ldif.LDIFException r9 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_INVALID_DELOLDRDN
            java.lang.Object[] r1 = new java.lang.Object[r13]
            r1[r6] = r8
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r7] = r4
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r6 = 0
            r0 = r9
            r2 = r19
            r5 = r15
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r9
        L_0x01a3:
            boolean r8 = r16.hasNext()
            if (r8 == 0) goto L_0x0266
            java.lang.Object r8 = r16.next()
            java.lang.StringBuilder r8 = (java.lang.StringBuilder) r8
            handleTrailingSpaces(r8, r0, r2, r1)
            java.lang.String r1 = ":"
            int r1 = r8.indexOf(r1)
            if (r1 < 0) goto L_0x024c
            java.lang.String r9 = r8.substring(r6, r1)
            java.lang.String r10 = "newsuperior"
            boolean r9 = r9.equalsIgnoreCase(r10)
            if (r9 == 0) goto L_0x024c
            int r9 = r8.length()
            int r10 = r1 + 1
            if (r9 != r10) goto L_0x01d2
            java.lang.String r1 = ""
            goto L_0x0267
        L_0x01d2:
            char r14 = r8.charAt(r10)
            if (r14 != r11) goto L_0x023c
            int r1 = r1 + r13
        L_0x01d9:
            if (r1 >= r9) goto L_0x01e4
            char r10 = r8.charAt(r1)
            if (r10 != r12) goto L_0x01e4
            int r1 = r1 + 1
            goto L_0x01d9
        L_0x01e4:
            java.lang.String r1 = r8.substring(r1)     // Catch:{ ParseException -> 0x0217, Exception -> 0x01f6 }
            byte[] r1 = com.unboundid.util.Base64.decode(r1)     // Catch:{ ParseException -> 0x0217, Exception -> 0x01f6 }
            java.lang.String r8 = new java.lang.String     // Catch:{ ParseException -> 0x0217, Exception -> 0x01f6 }
            java.lang.String r9 = "UTF-8"
            r8.<init>(r1, r9)     // Catch:{ ParseException -> 0x0217, Exception -> 0x01f6 }
            r1 = r8
            goto L_0x0267
        L_0x01f6:
            r0 = move-exception
            r8 = r0
            com.unboundid.util.Debug.debugException(r8)
            com.unboundid.ldif.LDIFException r9 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_CANNOT_BASE64_DECODE_NEWSUPERIOR
            java.lang.Object[] r1 = new java.lang.Object[r13]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            r1[r7] = r8
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r0 = r9
            r2 = r19
            r5 = r15
            r6 = r8
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r9
        L_0x0217:
            r0 = move-exception
            r8 = r0
            com.unboundid.util.Debug.debugException(r8)
            com.unboundid.ldif.LDIFException r9 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_CANNOT_BASE64_DECODE_NEWSUPERIOR
            java.lang.Object[] r1 = new java.lang.Object[r13]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            java.lang.String r4 = r8.getMessage()
            r1[r7] = r4
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r0 = r9
            r2 = r19
            r5 = r15
            r6 = r8
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r9
        L_0x023c:
            if (r10 >= r9) goto L_0x0247
            char r1 = r8.charAt(r10)
            if (r1 != r12) goto L_0x0247
            int r10 = r10 + 1
            goto L_0x023c
        L_0x0247:
            java.lang.String r1 = r8.substring(r10)
            goto L_0x0267
        L_0x024c:
            com.unboundid.ldif.LDIFException r8 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_NO_NEWSUPERIOR_COLON
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r6 = 0
            r0 = r8
            r2 = r19
            r5 = r15
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r8
        L_0x0266:
            r1 = 0
        L_0x0267:
            boolean r8 = r16.hasNext()
            if (r8 != 0) goto L_0x0273
            com.unboundid.ldif.LDIFModifyDNChangeRecord r2 = new com.unboundid.ldif.LDIFModifyDNChangeRecord
            r2.<init>(r0, r5, r4, r1)
            return r2
        L_0x0273:
            com.unboundid.ldif.LDIFException r8 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_CR_EXTRA_MODDN_DATA
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r6 = 0
            r0 = r8
            r2 = r19
            r5 = r15
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r8
        L_0x028d:
            com.unboundid.ldif.LDIFException r8 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_NO_DELOLDRDN_VALUE
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r6 = 0
            r0 = r8
            r2 = r19
            r5 = r15
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r8
        L_0x02a7:
            com.unboundid.ldif.LDIFException r8 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_NO_DELOLDRDN_COLON
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r6 = 0
            r0 = r8
            r2 = r19
            r5 = r15
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r8
        L_0x02c1:
            com.unboundid.ldif.LDIFException r8 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_NO_DELOLDRDN_COLON
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r6 = 0
            r0 = r8
            r2 = r19
            r5 = r15
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r8
        L_0x02db:
            com.unboundid.ldif.LDIFException r8 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_NO_NEWRDN_VALUE
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r6 = 0
            r0 = r8
            r2 = r19
            r5 = r15
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r8
        L_0x02f5:
            com.unboundid.ldif.LDIFException r8 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_NO_NEWRDN_VALUE
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r6 = 0
            r0 = r8
            r2 = r19
            r5 = r15
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r8
        L_0x030f:
            com.unboundid.ldif.LDIFException r8 = new com.unboundid.ldif.LDIFException
            com.unboundid.ldif.LDIFMessages r0 = com.unboundid.ldif.LDIFMessages.ERR_READ_MODDN_CR_NO_NEWRDN_COLON
            java.lang.Object[] r1 = new java.lang.Object[r7]
            java.lang.Long r4 = java.lang.Long.valueOf(r19)
            r1[r6] = r4
            java.lang.String r1 = r0.get(r1)
            r4 = 1
            r6 = 0
            r0 = r8
            r2 = r19
            r5 = r15
            r0.<init>((java.lang.String) r1, (long) r2, (boolean) r4, (java.util.List<? extends java.lang.CharSequence>) r5, (java.lang.Throwable) r6)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldif.LDIFReader.parseModifyDNChangeRecord(java.util.ArrayList, java.util.Iterator, java.lang.String, com.unboundid.ldif.TrailingSpaceBehavior, long):com.unboundid.ldif.LDIFModifyDNChangeRecord");
    }

    private static UnparsedLDIFRecord prepareRecord(DuplicateValueBehavior duplicateValueBehavior2, TrailingSpaceBehavior trailingSpaceBehavior2, Schema schema2, String... strArr) {
        int i;
        Validator.ensureNotNull(strArr);
        Validator.ensureFalse(strArr.length == 0, "LDIFReader.prepareRecord.ldifLines must not be empty.");
        ArrayList arrayList = new ArrayList(strArr.length);
        int i2 = 0;
        boolean z = false;
        while (i2 < strArr.length) {
            String str = strArr[i2];
            if (str.length() != 0 || (i = i2 + 1) >= strArr.length) {
                if (str.charAt(0) == ' ') {
                    if (i2 <= 0) {
                        throw new LDIFException(LDIFMessages.ERR_READ_UNEXPECTED_FIRST_SPACE_NO_NUMBER.get(), 0, true, (CharSequence[]) strArr, (Throwable) null);
                    } else if (!z) {
                        ((StringBuilder) arrayList.get(arrayList.size() - 1)).append(str.substring(1));
                    }
                } else if (str.charAt(0) == '#') {
                    z = true;
                } else {
                    arrayList.add(new StringBuilder(str));
                    z = false;
                }
                i2++;
            } else if (strArr[i].length() > 0) {
                throw new LDIFException(LDIFMessages.ERR_READ_UNEXPECTED_BLANK.get(Integer.valueOf(i2)), (long) i2, true, (CharSequence[]) strArr, (Throwable) null);
            } else if (!arrayList.isEmpty()) {
                return new UnparsedLDIFRecord(arrayList, duplicateValueBehavior2, trailingSpaceBehavior2, schema2, 0);
            } else {
                throw new LDIFException(LDIFMessages.ERR_READ_ONLY_BLANKS.get(), 0, true, (CharSequence[]) strArr, (Throwable) null);
            }
        }
        if (!arrayList.isEmpty()) {
            return new UnparsedLDIFRecord(arrayList, duplicateValueBehavior2, trailingSpaceBehavior2, schema2, 0);
        }
        throw new LDIFException(LDIFMessages.ERR_READ_NO_DATA.get(), 0, true, (CharSequence[]) strArr, (Throwable) null);
    }

    private LDIFChangeRecord readChangeRecordAsync(boolean z) {
        Result<UnparsedLDIFRecord, LDIFRecord> readLDIFRecordResultAsync = readLDIFRecordResultAsync();
        if (readLDIFRecordResultAsync == null) {
            return null;
        }
        LDIFRecord output = readLDIFRecordResultAsync.getOutput();
        if (output instanceof LDIFChangeRecord) {
            return (LDIFChangeRecord) output;
        }
        if (!(output instanceof Entry)) {
            throw new AssertionError("LDIFRecords must either be an Entry or an LDIFChangeRecord");
        } else if (z) {
            return new LDIFAddChangeRecord((Entry) output);
        } else {
            long access$200 = readLDIFRecordResultAsync.getInput().getFirstLineNumber();
            throw new LDIFException(LDIFMessages.ERR_READ_NOT_CHANGE_RECORD.get(Long.valueOf(access$200)), access$200, true);
        }
    }

    private LDIFChangeRecord readChangeRecordInternal(boolean z) {
        UnparsedLDIFRecord readUnparsedRecord = readUnparsedRecord();
        if (readUnparsedRecord.isEOF()) {
            return null;
        }
        LDIFChangeRecord decodeChangeRecord = decodeChangeRecord(readUnparsedRecord, this.relativeBasePath, z);
        Debug.debugLDIFRead(decodeChangeRecord);
        return decodeChangeRecord;
    }

    private static List<Entry> readEntries(LDIFReader lDIFReader) {
        try {
            ArrayList arrayList = new ArrayList(10);
            while (true) {
                Entry readEntry = lDIFReader.readEntry();
                if (readEntry == null) {
                    return arrayList;
                }
                arrayList.add(readEntry);
            }
        } finally {
            lDIFReader.close();
        }
    }

    public static List<Entry> readEntries(File file) {
        return readEntries(new LDIFReader(file));
    }

    public static List<Entry> readEntries(InputStream inputStream) {
        return readEntries(new LDIFReader(inputStream));
    }

    public static List<Entry> readEntries(String str) {
        return readEntries(new LDIFReader(str));
    }

    private Entry readEntryAsync() {
        Object obj = null;
        Result<UnparsedLDIFRecord, LDIFRecord> result = null;
        while (obj == null) {
            result = readLDIFRecordResultAsync();
            if (result == null) {
                return null;
            }
            obj = (LDIFRecord) result.getOutput();
            if (obj == SKIP_ENTRY) {
                obj = null;
            }
        }
        if (obj instanceof Entry) {
            return (Entry) obj;
        }
        try {
            return ((LDIFChangeRecord) obj).toEntry();
        } catch (LDIFException e) {
            LDIFException lDIFException = e;
            Debug.debugException(lDIFException);
            throw new LDIFException(lDIFException.getExceptionMessage(), result.getInput().getFirstLineNumber(), true, lDIFException);
        }
    }

    private Entry readEntryInternal() {
        Entry entry = null;
        while (entry == null) {
            UnparsedLDIFRecord readUnparsedRecord = readUnparsedRecord();
            if (readUnparsedRecord.isEOF()) {
                return null;
            }
            Entry decodeEntry = decodeEntry(readUnparsedRecord, this.relativeBasePath);
            Debug.debugLDIFRead(decodeEntry);
            LDIFReaderEntryTranslator lDIFReaderEntryTranslator = this.entryTranslator;
            entry = lDIFReaderEntryTranslator != null ? lDIFReaderEntryTranslator.translate(decodeEntry, readUnparsedRecord.getFirstLineNumber()) : decodeEntry;
        }
        return entry;
    }

    private LDIFRecord readLDIFRecordAsync() {
        Result<UnparsedLDIFRecord, LDIFRecord> readLDIFRecordResultAsync = readLDIFRecordResultAsync();
        if (readLDIFRecordResultAsync == null) {
            return null;
        }
        return readLDIFRecordResultAsync.getOutput();
    }

    private LDIFRecord readLDIFRecordInternal() {
        return decodeRecord(readUnparsedRecord(), this.relativeBasePath);
    }

    private Result<UnparsedLDIFRecord, LDIFRecord> readLDIFRecordResultAsync() {
        Result<UnparsedLDIFRecord, LDIFRecord> result;
        if (this.asyncParsingComplete.get()) {
            result = (Result) this.asyncParsedRecords.poll();
        } else {
            result = null;
            while (result == null) {
                try {
                    if (this.asyncParsingComplete.get()) {
                        break;
                    }
                    result = this.asyncParsedRecords.poll(1, TimeUnit.SECONDS);
                } catch (InterruptedException e) {
                    Debug.debugException(e);
                    throw new IOException(StaticUtils.getExceptionMessage(e));
                }
            }
            if (result == null) {
                result = (Result) this.asyncParsedRecords.poll();
            }
        }
        if (result == null) {
            return null;
        }
        rethrow(result.getFailureCause());
        if (!result.getInput().isEOF()) {
            return result;
        }
        this.asyncParsingComplete.set(true);
        try {
            this.asyncParsedRecords.put(result);
        } catch (InterruptedException e2) {
            Debug.debugException(e2);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public UnparsedLDIFRecord readUnparsedRecord() {
        String readLine;
        ArrayList arrayList = new ArrayList(20);
        long j = this.lineNumberCounter + 1;
        loop0:
        while (true) {
            boolean z = false;
            while (true) {
                readLine = this.reader.readLine();
                this.lineNumberCounter++;
                if (readLine == null) {
                    if (arrayList.isEmpty()) {
                        return new UnparsedLDIFRecord(new ArrayList(0), this.duplicateValueBehavior, this.trailingSpaceBehavior, this.schema, -1);
                    }
                } else if (readLine.length() == 0) {
                    if (!arrayList.isEmpty()) {
                        break loop0;
                    }
                    j++;
                } else if (readLine.charAt(0) == ' ') {
                    if (arrayList.isEmpty()) {
                        throw new LDIFException(LDIFMessages.ERR_READ_UNEXPECTED_FIRST_SPACE.get(Long.valueOf(this.lineNumberCounter)), this.lineNumberCounter, false);
                    } else if (!z) {
                        ((StringBuilder) arrayList.get(arrayList.size() - 1)).append(readLine.substring(1));
                    }
                } else if (readLine.charAt(0) != '#' && (!arrayList.isEmpty() || !readLine.startsWith("version:"))) {
                    arrayList.add(new StringBuilder(readLine));
                } else {
                    z = true;
                }
            }
            arrayList.add(new StringBuilder(readLine));
        }
        return new UnparsedLDIFRecord(arrayList, this.duplicateValueBehavior, this.trailingSpaceBehavior, this.schema, j);
    }

    static void rethrow(Throwable th) {
        if (th != null) {
            if (th instanceof IOException) {
                throw ((IOException) th);
            } else if (th instanceof LDIFException) {
                throw ((LDIFException) th);
            } else if (th instanceof RuntimeException) {
                throw ((RuntimeException) th);
            } else if (th instanceof Error) {
                throw ((Error) th);
            } else {
                throw new IOException(StaticUtils.getExceptionMessage(th));
            }
        }
    }

    public void close() {
        this.reader.close();
        if (isAsync()) {
            this.asyncParsedRecords.clear();
        }
    }

    public DuplicateValueBehavior getDuplicateValueBehavior() {
        return this.duplicateValueBehavior;
    }

    public String getRelativeBasePath() {
        return this.relativeBasePath;
    }

    public Schema getSchema() {
        return this.schema;
    }

    public TrailingSpaceBehavior getTrailingSpaceBehavior() {
        return this.trailingSpaceBehavior;
    }

    @Deprecated
    public boolean ignoreDuplicateValues() {
        return this.duplicateValueBehavior == DuplicateValueBehavior.STRIP;
    }

    public LDIFChangeRecord readChangeRecord() {
        return readChangeRecord(false);
    }

    public LDIFChangeRecord readChangeRecord(boolean z) {
        return isAsync() ? readChangeRecordAsync(z) : readChangeRecordInternal(z);
    }

    public Entry readEntry() {
        return isAsync() ? readEntryAsync() : readEntryInternal();
    }

    public LDIFRecord readLDIFRecord() {
        return isAsync() ? readLDIFRecordAsync() : readLDIFRecordInternal();
    }

    public void setDuplicateValueBehavior(DuplicateValueBehavior duplicateValueBehavior2) {
        this.duplicateValueBehavior = duplicateValueBehavior2;
    }

    @Deprecated
    public void setIgnoreDuplicateValues(boolean z) {
        this.duplicateValueBehavior = z ? DuplicateValueBehavior.STRIP : DuplicateValueBehavior.REJECT;
    }

    public void setRelativeBasePath(File file) {
        String absolutePath = file.getAbsolutePath();
        if (!absolutePath.endsWith(File.separator)) {
            absolutePath = absolutePath + File.separator;
        }
        this.relativeBasePath = absolutePath;
    }

    public void setRelativeBasePath(String str) {
        setRelativeBasePath(new File(str));
    }

    public void setSchema(Schema schema2) {
        this.schema = schema2;
    }

    @Deprecated
    public void setStripTrailingSpaces(boolean z) {
        this.trailingSpaceBehavior = z ? TrailingSpaceBehavior.STRIP : TrailingSpaceBehavior.REJECT;
    }

    public void setTrailingSpaceBehavior(TrailingSpaceBehavior trailingSpaceBehavior2) {
        this.trailingSpaceBehavior = trailingSpaceBehavior2;
    }

    @Deprecated
    public boolean stripTrailingSpaces() {
        return this.trailingSpaceBehavior == TrailingSpaceBehavior.STRIP;
    }
}
