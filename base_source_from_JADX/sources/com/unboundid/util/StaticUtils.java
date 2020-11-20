package com.unboundid.util;

import com.unboundid.ldap.sdk.Control;
import com.unboundid.ldap.sdk.Version;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.UUID;
import org.apache.commons.p172io.IOUtils;
import org.spongycastle.crypto.tls.CipherSuite;

public final class StaticUtils {
    public static final String EOL = System.getProperty("line.separator");
    public static final byte[] EOL_BYTES = getBytes(EOL);
    public static final byte[] NO_BYTES = new byte[0];
    public static final Control[] NO_CONTROLS = new Control[0];
    public static final String[] NO_STRINGS = new String[0];
    private static final ThreadLocal<SimpleDateFormat> dateFormatters = new ThreadLocal<>();

    private StaticUtils() {
    }

    public static <T> boolean arraysEqualOrderIndependent(T[] tArr, T[] tArr2) {
        if (tArr == null) {
            return tArr2 == null;
        }
        if (tArr2 != null && tArr.length == tArr2.length) {
            return tArr.length == 1 ? tArr[0].equals(tArr2[0]) : new HashSet(Arrays.asList(tArr)).equals(new HashSet(Arrays.asList(tArr2)));
        }
        return false;
    }

    public static boolean bothNullOrEqual(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        if (obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static boolean bothNullOrEqualIgnoreCase(String str, String str2) {
        if (str == null) {
            return str2 == null;
        }
        if (str2 == null) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static String capitalize(String str) {
        if (str == null) {
            return null;
        }
        switch (str.length()) {
            case 0:
                return str;
            case 1:
                return str.toUpperCase();
            default:
                char charAt = str.charAt(0);
                if (Character.isUpperCase(charAt)) {
                    return str;
                }
                return Character.toUpperCase(charAt) + str.substring(1);
        }
    }

    public static String concatenateStrings(List<String> list) {
        Validator.ensureNotNull(list);
        StringBuilder sb = new StringBuilder();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append("  ");
            }
        }
        return sb.toString();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00bc, code lost:
        r5 = r5.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c7, code lost:
        r7 = r4;
        r4 = r3;
        r3 = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Date decodeGeneralizedTime(java.lang.String r8) {
        /*
            com.unboundid.util.Validator.ensureNotNull(r8)
            java.lang.String r0 = "Z"
            boolean r0 = r8.endsWith(r0)
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0019
            java.lang.String r0 = "UTC"
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r0)
            int r3 = r8.length()
            int r3 = r3 - r1
            goto L_0x007b
        L_0x0019:
            r0 = 45
            int r0 = r8.lastIndexOf(r0)
            if (r0 >= 0) goto L_0x003a
            r0 = 43
            int r0 = r8.lastIndexOf(r0)
            if (r0 < 0) goto L_0x002a
            goto L_0x003a
        L_0x002a:
            java.text.ParseException r0 = new java.text.ParseException
            com.unboundid.util.UtilityMessages r3 = com.unboundid.util.UtilityMessages.ERR_GENTIME_DECODE_CANNOT_PARSE_TZ
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r8
            java.lang.String r8 = r3.get(r1)
            r0.<init>(r8, r2)
            throw r0
        L_0x003a:
            r3 = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "GMT"
            r0.append(r4)
            java.lang.String r4 = r8.substring(r3)
            r0.append(r4)
            java.lang.String r0 = r0.toString()
            java.util.TimeZone r0 = java.util.TimeZone.getTimeZone(r0)
            int r4 = r0.getRawOffset()
            if (r4 != 0) goto L_0x007b
            java.lang.String r4 = "+0000"
            boolean r4 = r8.endsWith(r4)
            if (r4 != 0) goto L_0x007b
            java.lang.String r4 = "-0000"
            boolean r4 = r8.endsWith(r4)
            if (r4 == 0) goto L_0x006b
            goto L_0x007b
        L_0x006b:
            java.text.ParseException r0 = new java.text.ParseException
            com.unboundid.util.UtilityMessages r4 = com.unboundid.util.UtilityMessages.ERR_GENTIME_DECODE_CANNOT_PARSE_TZ
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r8
            java.lang.String r8 = r4.get(r1)
            r0.<init>(r8, r3)
            throw r0
        L_0x007b:
            r4 = 46
            int r4 = r8.lastIndexOf(r4, r3)
            if (r4 <= 0) goto L_0x00cb
            int r3 = r3 - r4
            int r3 = r3 - r1
            switch(r3) {
                case 0: goto L_0x00c1;
                case 1: goto L_0x00a7;
                case 2: goto L_0x0091;
                default: goto L_0x0088;
            }
        L_0x0088:
            java.lang.String r3 = ".SSS"
            int r5 = r4 + 4
            java.lang.String r5 = r8.substring(r2, r5)
            goto L_0x00c7
        L_0x0091:
            java.lang.String r3 = ".SSS"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r6 = r4 + 3
            java.lang.String r6 = r8.substring(r2, r6)
            r5.append(r6)
            r6 = 48
            r5.append(r6)
            goto L_0x00bc
        L_0x00a7:
            java.lang.String r3 = ".SSS"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            int r6 = r4 + 2
            java.lang.String r6 = r8.substring(r2, r6)
            r5.append(r6)
            java.lang.String r6 = "00"
            r5.append(r6)
        L_0x00bc:
            java.lang.String r5 = r5.toString()
            goto L_0x00c7
        L_0x00c1:
            java.lang.String r3 = ""
            java.lang.String r5 = r8.substring(r2, r4)
        L_0x00c7:
            r7 = r4
            r4 = r3
            r3 = r7
            goto L_0x00d1
        L_0x00cb:
            java.lang.String r4 = ""
            java.lang.String r5 = r8.substring(r2, r3)
        L_0x00d1:
            r6 = 10
            if (r3 == r6) goto L_0x00fd
            r6 = 12
            if (r3 == r6) goto L_0x00f5
            r6 = 14
            if (r3 != r6) goto L_0x00e5
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "yyyyMMddHHmmss"
            goto L_0x0104
        L_0x00e5:
            java.text.ParseException r0 = new java.text.ParseException
            com.unboundid.util.UtilityMessages r4 = com.unboundid.util.UtilityMessages.ERR_GENTIME_CANNOT_PARSE_INVALID_LENGTH
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r8
            java.lang.String r8 = r4.get(r1)
            r0.<init>(r8, r3)
            throw r0
        L_0x00f5:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "yyyyMMddHHmm"
            goto L_0x0104
        L_0x00fd:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "yyyyMMddHH"
        L_0x0104:
            r8.append(r1)
            r8.append(r4)
            java.lang.String r8 = r8.toString()
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            r1.<init>(r8)
            r1.setTimeZone(r0)
            r1.setLenient(r2)
            java.util.Date r8 = r1.parse(r5)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.util.StaticUtils.decodeGeneralizedTime(java.lang.String):java.util.Date");
    }

    public static UUID decodeUUID(byte[] bArr) {
        if (bArr.length == 16) {
            long j = 0;
            long j2 = 0;
            for (int i = 0; i < 8; i++) {
                j2 = (j2 << 8) | ((long) (bArr[i] & 255));
            }
            for (int i2 = 8; i2 < 16; i2++) {
                j = (j << 8) | ((long) (bArr[i2] & 255));
            }
            return new UUID(j2, j);
        }
        throw new ParseException(UtilityMessages.ERR_DECODE_UUID_INVALID_LENGTH.get(toHex(bArr)), 0);
    }

    public static String encodeGeneralizedTime(Date date) {
        SimpleDateFormat simpleDateFormat = dateFormatters.get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss.SSS'Z'");
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
            dateFormatters.set(simpleDateFormat);
        }
        return simpleDateFormat.format(date);
    }

    public static byte[] encodeUUID(UUID uuid) {
        long mostSignificantBits = uuid.getMostSignificantBits();
        long leastSignificantBits = uuid.getLeastSignificantBits();
        return new byte[]{(byte) ((int) ((mostSignificantBits >> 56) & 255)), (byte) ((int) ((mostSignificantBits >> 48) & 255)), (byte) ((int) ((mostSignificantBits >> 40) & 255)), (byte) ((int) ((mostSignificantBits >> 32) & 255)), (byte) ((int) ((mostSignificantBits >> 24) & 255)), (byte) ((int) ((mostSignificantBits >> 16) & 255)), (byte) ((int) ((mostSignificantBits >> 8) & 255)), (byte) ((int) (mostSignificantBits & 255)), (byte) ((int) ((leastSignificantBits >> 56) & 255)), (byte) ((int) ((leastSignificantBits >> 48) & 255)), (byte) ((int) ((leastSignificantBits >> 40) & 255)), (byte) ((int) ((leastSignificantBits >> 32) & 255)), (byte) ((int) ((leastSignificantBits >> 24) & 255)), (byte) ((int) ((leastSignificantBits >> 16) & 255)), (byte) ((int) ((leastSignificantBits >> 8) & 255)), (byte) ((int) (leastSignificantBits & 255))};
    }

    public static byte[] getBytes(String str) {
        int length;
        if (str == null || (length = str.length()) == 0) {
            return NO_BYTES;
        }
        byte[] bArr = new byte[length];
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt <= 127) {
                bArr[i] = (byte) (charAt & 127);
                i++;
            } else {
                try {
                    return str.getBytes("UTF-8");
                } catch (Exception e) {
                    Debug.debugException(e);
                    return str.getBytes();
                }
            }
        }
        return bArr;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0050  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getExceptionMessage(java.lang.Throwable r2) {
        /*
            if (r2 != 0) goto L_0x0009
            com.unboundid.util.UtilityMessages r2 = com.unboundid.util.UtilityMessages.ERR_NO_EXCEPTION
            java.lang.String r2 = r2.get()
            return r2
        L_0x0009:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            boolean r1 = r2 instanceof com.unboundid.util.LDAPSDKException
            if (r1 == 0) goto L_0x001d
            r1 = r2
            com.unboundid.util.LDAPSDKException r1 = (com.unboundid.util.LDAPSDKException) r1
            java.lang.String r1 = r1.getExceptionMessage()
        L_0x0019:
            r0.append(r1)
            goto L_0x0029
        L_0x001d:
            boolean r1 = r2 instanceof com.unboundid.util.LDAPSDKRuntimeException
            if (r1 == 0) goto L_0x0029
            r1 = r2
            com.unboundid.util.LDAPSDKRuntimeException r1 = (com.unboundid.util.LDAPSDKRuntimeException) r1
            java.lang.String r1 = r1.getExceptionMessage()
            goto L_0x0019
        L_0x0029:
            boolean r1 = r2 instanceof java.lang.RuntimeException
            if (r1 != 0) goto L_0x0050
            boolean r1 = r2 instanceof java.lang.Error
            if (r1 == 0) goto L_0x0032
            goto L_0x0050
        L_0x0032:
            java.lang.String r1 = java.lang.String.valueOf(r2)
            r0.append(r1)
            java.lang.Throwable r2 = r2.getCause()
            if (r2 == 0) goto L_0x004b
            java.lang.String r1 = " caused by "
            r0.append(r1)
            java.lang.String r2 = getExceptionMessage(r2)
            r0.append(r2)
        L_0x004b:
            java.lang.String r2 = r0.toString()
            return r2
        L_0x0050:
            java.lang.String r2 = getStackTrace((java.lang.Throwable) r2)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.util.StaticUtils.getExceptionMessage(java.lang.Throwable):java.lang.String");
    }

    public static String getStackTrace(Throwable th) {
        StringBuilder sb = new StringBuilder();
        getStackTrace(th, sb);
        return sb.toString();
    }

    public static String getStackTrace(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb = new StringBuilder();
        getStackTrace(stackTraceElementArr, sb);
        return sb.toString();
    }

    public static void getStackTrace(Throwable th, StringBuilder sb) {
        sb.append(getUnqualifiedClassName(th.getClass()));
        sb.append('(');
        String message = th.getMessage();
        if (message != null) {
            sb.append("message='");
            sb.append(message);
            sb.append("', ");
        }
        sb.append("trace='");
        getStackTrace(th.getStackTrace(), sb);
        sb.append('\'');
        Throwable cause = th.getCause();
        if (cause != null) {
            sb.append(", cause=");
            getStackTrace(cause, sb);
        }
        sb.append(", revision=");
        sb.append(Version.REVISION_NUMBER);
        sb.append(')');
    }

    public static void getStackTrace(StackTraceElement[] stackTraceElementArr, StringBuilder sb) {
        for (int i = 0; i < stackTraceElementArr.length; i++) {
            if (i > 0) {
                sb.append(" / ");
            }
            sb.append(stackTraceElementArr[i].getMethodName());
            sb.append('(');
            sb.append(stackTraceElementArr[i].getFileName());
            int lineNumber = stackTraceElementArr[i].getLineNumber();
            if (lineNumber > 0) {
                sb.append(':');
                sb.append(lineNumber);
            }
            sb.append(')');
        }
    }

    public static String getUnqualifiedClassName(Class<?> cls) {
        String name = cls.getName();
        int lastIndexOf = name.lastIndexOf(46);
        return lastIndexOf > 0 ? name.substring(lastIndexOf + 1) : name;
    }

    public static void hexEncode(char c, StringBuilder sb) {
        for (byte hex : c <= 127 ? new byte[]{(byte) (c & 127)} : getBytes(String.valueOf(c))) {
            sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
            toHex(hex, sb);
        }
    }

    public static boolean isHex(char c) {
        switch (c) {
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
                return true;
            default:
                switch (c) {
                    case 'A':
                    case 'B':
                    case 'C':
                    case 'D':
                    case 'E':
                    case 'F':
                        return true;
                    default:
                        switch (c) {
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                return true;
                            default:
                                return false;
                        }
                }
        }
    }

    public static boolean isNumericOID(String str) {
        boolean z = false;
        boolean z2 = true;
        for (char c : str.toCharArray()) {
            switch (c) {
                case '.':
                    if (!z2) {
                        z = true;
                        z2 = true;
                        break;
                    } else {
                        return false;
                    }
                case '0':
                case '1':
                case '2':
                case '3':
                case '4':
                case '5':
                case '6':
                case '7':
                case '8':
                case '9':
                    z2 = false;
                    break;
                default:
                    return false;
            }
        }
        return z && !z2;
    }

    public static boolean isWindows() {
        String lowerCase = toLowerCase(System.getProperty("os.name"));
        return lowerCase != null && lowerCase.contains("windows");
    }

    public static String millisToHumanReadableDuration(long j) {
        UtilityMessages utilityMessages;
        Object[] objArr;
        String str;
        Object[] objArr2;
        UtilityMessages utilityMessages2;
        Object[] objArr3;
        UtilityMessages utilityMessages3;
        Object[] objArr4;
        UtilityMessages utilityMessages4;
        StringBuilder sb = new StringBuilder();
        long j2 = j / 86400000;
        if (j2 > 0) {
            j -= 86400000 * j2;
            if (j2 == 1) {
                utilityMessages4 = UtilityMessages.INFO_NUM_DAYS_SINGULAR;
                objArr4 = new Object[]{Long.valueOf(j2)};
            } else {
                utilityMessages4 = UtilityMessages.INFO_NUM_DAYS_PLURAL;
                objArr4 = new Object[]{Long.valueOf(j2)};
            }
            sb.append(utilityMessages4.get(objArr4));
        }
        long j3 = j / 3600000;
        if (j3 > 0) {
            j -= 3600000 * j3;
            if (sb.length() > 0) {
                sb.append(", ");
            }
            if (j3 == 1) {
                utilityMessages3 = UtilityMessages.INFO_NUM_HOURS_SINGULAR;
                objArr3 = new Object[]{Long.valueOf(j3)};
            } else {
                utilityMessages3 = UtilityMessages.INFO_NUM_HOURS_PLURAL;
                objArr3 = new Object[]{Long.valueOf(j3)};
            }
            sb.append(utilityMessages3.get(objArr3));
        }
        long j4 = j / 60000;
        if (j4 > 0) {
            j -= 60000 * j4;
            if (sb.length() > 0) {
                sb.append(", ");
            }
            if (j4 == 1) {
                utilityMessages2 = UtilityMessages.INFO_NUM_MINUTES_SINGULAR;
                objArr2 = new Object[]{Long.valueOf(j4)};
            } else {
                utilityMessages2 = UtilityMessages.INFO_NUM_MINUTES_PLURAL;
                objArr2 = new Object[]{Long.valueOf(j4)};
            }
            sb.append(utilityMessages2.get(objArr2));
        }
        if (j == 1000) {
            if (sb.length() > 0) {
                sb.append(", ");
            }
            utilityMessages = UtilityMessages.INFO_NUM_SECONDS_SINGULAR;
            objArr = new Object[]{1};
        } else {
            if (j > 0 || sb.length() == 0) {
                if (sb.length() > 0) {
                    sb.append(", ");
                }
                long j5 = j / 1000;
                long j6 = j - (j5 * 1000);
                if (j6 % 1000 != 0) {
                    double d = ((double) j5) + (((double) j6) / 1000.0d);
                    DecimalFormat decimalFormat = new DecimalFormat("0.000");
                    str = UtilityMessages.INFO_NUM_SECONDS_WITH_DECIMAL.get(decimalFormat.format(d));
                    sb.append(str);
                } else {
                    utilityMessages = UtilityMessages.INFO_NUM_SECONDS_PLURAL;
                    objArr = new Object[]{Long.valueOf(j5)};
                }
            }
            return sb.toString();
        }
        str = utilityMessages.get(objArr);
        sb.append(str);
        return sb.toString();
    }

    public static long millisToNanos(long j) {
        return Math.max(0, j * 1000000);
    }

    public static long nanosToMillis(long j) {
        return Math.max(0, Math.round(((double) j) / 1000000.0d));
    }

    public static String secondsToHumanReadableDuration(long j) {
        return millisToHumanReadableDuration(j * 1000);
    }

    public static boolean stringsEqualIgnoreCaseOrderIndependent(String[] strArr, String[] strArr2) {
        if (strArr == null) {
            return strArr2 == null;
        }
        if (strArr2 == null || strArr.length != strArr2.length) {
            return false;
        }
        if (strArr.length == 1) {
            return strArr[0].equalsIgnoreCase(strArr2[0]);
        }
        HashSet hashSet = new HashSet(strArr.length);
        for (String lowerCase : strArr) {
            hashSet.add(toLowerCase(lowerCase));
        }
        HashSet hashSet2 = new HashSet(strArr2.length);
        for (String lowerCase2 : strArr2) {
            hashSet2.add(toLowerCase(lowerCase2));
        }
        return hashSet.equals(hashSet2);
    }

    public static List<String> toArgumentList(String str) {
        if (str == null || str.length() == 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        int i = -1;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (z) {
                sb.append(charAt);
                z = false;
            } else if (charAt == '\\') {
                z = true;
            } else if (charAt == '\"') {
                i = i >= 0 ? -1 : i2;
            } else if (charAt != ' ' || i >= 0) {
                sb.append(charAt);
            } else if (sb.length() > 0) {
                arrayList.add(sb.toString());
                sb.setLength(0);
            }
        }
        if (str.endsWith("\\") && !str.endsWith("\\\\")) {
            throw new ParseException(UtilityMessages.ERR_ARG_STRING_DANGLING_BACKSLASH.get(), str.length() - 1);
        } else if (i < 0) {
            if (sb.length() > 0) {
                arrayList.add(sb.toString());
            }
            return Collections.unmodifiableList(arrayList);
        } else {
            throw new ParseException(UtilityMessages.ERR_ARG_STRING_UNMATCHED_QUOTE.get(Integer.valueOf(i)), i);
        }
    }

    public static String toHex(byte b) {
        StringBuilder sb = new StringBuilder(2);
        toHex(b, sb);
        return sb.toString();
    }

    public static String toHex(byte[] bArr) {
        Validator.ensureNotNull(bArr);
        StringBuilder sb = new StringBuilder(bArr.length * 2);
        toHex(bArr, sb);
        return sb.toString();
    }

    public static void toHex(byte b, StringBuilder sb) {
        char c;
        char c2;
        byte b2 = b;
        StringBuilder sb2 = sb;
        switch (b2 & 240) {
            case 0:
                sb2.append('0');
                break;
            case 16:
                c2 = '1';
                break;
            case 32:
                c2 = '2';
                break;
            case 48:
                sb2.append('3');
                break;
            case 64:
                sb2.append('4');
                break;
            case 80:
                sb2.append('5');
                break;
            case 96:
                sb2.append('6');
                break;
            case 112:
                sb2.append('7');
                break;
            case 128:
                sb2.append('8');
                break;
            case CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA /*144*/:
                sb2.append('9');
                break;
            case 160:
                sb2.append('a');
                break;
            case CipherSuite.TLS_PSK_WITH_NULL_SHA256 /*176*/:
                sb2.append('b');
                break;
            case 192:
                sb2.append('c');
                break;
            case com.parse.ParseException.ACCOUNT_ALREADY_LINKED:
                sb2.append('d');
                break;
            case 224:
                sb2.append('e');
                break;
            case 240:
                c2 = 'f';
                break;
        }
        sb2.append(c2);
        switch (b2 & 15) {
            case 0:
                sb2.append('0');
                return;
            case 1:
                c = '1';
                break;
            case 2:
                c = '2';
                break;
            case 3:
                sb2.append('3');
                return;
            case 4:
                sb2.append('4');
                return;
            case 5:
                sb2.append('5');
                return;
            case 6:
                sb2.append('6');
                return;
            case 7:
                sb2.append('7');
                return;
            case 8:
                sb2.append('8');
                return;
            case 9:
                sb2.append('9');
                return;
            case 10:
                sb2.append('a');
                return;
            case 11:
                sb2.append('b');
                return;
            case 12:
                sb2.append('c');
                return;
            case 13:
                sb2.append('d');
                return;
            case 14:
                sb2.append('e');
                return;
            case 15:
                c = 'f';
                break;
            default:
                return;
        }
        sb2.append(c);
    }

    public static void toHex(byte[] bArr, String str, StringBuilder sb) {
        boolean z = true;
        for (byte b : bArr) {
            if (z) {
                z = false;
            } else if (str != null) {
                sb.append(str);
            }
            toHex(b, sb);
        }
    }

    public static void toHex(byte[] bArr, StringBuilder sb) {
        toHex(bArr, (String) null, sb);
    }

    public static String toHexPlusASCII(byte[] bArr, int i) {
        StringBuilder sb = new StringBuilder();
        toHexPlusASCII(bArr, i, sb);
        return sb.toString();
    }

    public static void toHexPlusASCII(byte[] bArr, int i, StringBuilder sb) {
        int length;
        if (bArr != null && bArr.length != 0) {
            for (int i2 = 0; i2 < i; i2++) {
                sb.append(' ');
            }
            int i3 = 0;
            int i4 = 0;
            while (i3 < bArr.length) {
                int i5 = i3 + 1;
                toHex(bArr[i3], sb);
                sb.append(' ');
                if (i5 % 16 == 0) {
                    sb.append("  ");
                    while (i4 < i5) {
                        if (bArr[i4] < 32 || bArr[i4] > 126) {
                            sb.append(' ');
                        } else {
                            sb.append((char) bArr[i4]);
                        }
                        i4++;
                    }
                    sb.append(EOL);
                    if (i5 < bArr.length) {
                        for (int i6 = 0; i6 < i; i6++) {
                            sb.append(' ');
                        }
                    }
                    i3 = i5;
                    i4 = i3;
                } else {
                    i3 = i5;
                }
            }
            if (bArr.length % 16 != 0 && (length = 16 - (bArr.length % 16)) > 0) {
                for (int i7 = 0; i7 < length; i7++) {
                    sb.append("   ");
                }
                sb.append("  ");
                while (i4 < bArr.length) {
                    if (bArr[i4] < 32 || bArr[i4] > 126) {
                        sb.append(' ');
                    } else {
                        sb.append((char) bArr[i4]);
                    }
                    i4++;
                }
                sb.append(EOL);
            }
        }
    }

    public static String toInitialLowerCase(String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        if (str.length() == 1) {
            return toLowerCase(str);
        }
        char charAt = str.charAt(0);
        if ((charAt < 'A' || charAt > 'Z') && charAt >= ' ' && charAt <= '~') {
            return str;
        }
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(0, Character.toLowerCase(charAt));
        return sb.toString();
    }

    public static <T> List<T> toList(T[] tArr) {
        if (tArr == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.addAll(Arrays.asList(tArr));
        return arrayList;
    }

    public static String toLowerCase(String str) {
        if (str == null) {
            return null;
        }
        int length = str.length();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            switch (charArray[i]) {
                case 'A':
                    charArray[i] = 'a';
                    break;
                case 'B':
                    charArray[i] = 'b';
                    break;
                case 'C':
                    charArray[i] = 'c';
                    break;
                case 'D':
                    charArray[i] = 'd';
                    break;
                case 'E':
                    charArray[i] = 'e';
                    break;
                case 'F':
                    charArray[i] = 'f';
                    break;
                case 'G':
                    charArray[i] = 'g';
                    break;
                case 'H':
                    charArray[i] = 'h';
                    break;
                case 'I':
                    charArray[i] = 'i';
                    break;
                case 'J':
                    charArray[i] = 'j';
                    break;
                case 'K':
                    charArray[i] = 'k';
                    break;
                case 'L':
                    charArray[i] = 'l';
                    break;
                case 'M':
                    charArray[i] = 'm';
                    break;
                case 'N':
                    charArray[i] = 'n';
                    break;
                case 'O':
                    charArray[i] = 'o';
                    break;
                case 'P':
                    charArray[i] = 'p';
                    break;
                case 'Q':
                    charArray[i] = 'q';
                    break;
                case 'R':
                    charArray[i] = 'r';
                    break;
                case 'S':
                    charArray[i] = 's';
                    break;
                case 'T':
                    charArray[i] = 't';
                    break;
                case 'U':
                    charArray[i] = 'u';
                    break;
                case 'V':
                    charArray[i] = 'v';
                    break;
                case 'W':
                    charArray[i] = 'w';
                    break;
                case 'X':
                    charArray[i] = 'x';
                    break;
                case 'Y':
                    charArray[i] = 'y';
                    break;
                case 'Z':
                    charArray[i] = 'z';
                    break;
                default:
                    if (charArray[i] <= 127) {
                        break;
                    } else {
                        return str.toLowerCase();
                    }
            }
        }
        return new String(charArray);
    }

    public static <T> List<T> toNonNullList(T[] tArr) {
        if (tArr == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(tArr.length);
        arrayList.addAll(Arrays.asList(tArr));
        return arrayList;
    }

    public static String toUTF8String(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (Exception e) {
            Debug.debugException(e);
            return new String(bArr);
        }
    }

    public static String toUTF8String(byte[] bArr, int i, int i2) {
        try {
            return new String(bArr, i, i2, "UTF-8");
        } catch (Exception e) {
            Debug.debugException(e);
            return new String(bArr, i, i2);
        }
    }

    public static String trimLeading(String str) {
        Validator.ensureNotNull(str);
        int length = str.length();
        int i = 0;
        while (i < length && str.charAt(i) == ' ') {
            i++;
        }
        return i == 0 ? str : i >= length ? "" : str.substring(i, length);
    }

    public static String trimTrailing(String str) {
        Validator.ensureNotNull(str);
        int length = str.length() - 1;
        int i = length;
        while (i >= 0 && str.charAt(i) == ' ') {
            i--;
        }
        return i < 0 ? "" : i == length ? str : str.substring(0, i + 1);
    }

    public static List<String> wrapLine(String str, int i) {
        if (str.indexOf(10) >= 0) {
            ArrayList arrayList = new ArrayList(10);
            StringTokenizer stringTokenizer = new StringTokenizer(str, IOUtils.LINE_SEPARATOR_WINDOWS);
            while (stringTokenizer.hasMoreTokens()) {
                arrayList.addAll(wrapLine(stringTokenizer.nextToken(), i));
            }
            return arrayList;
        }
        int length = str.length();
        if (i <= 0 || length < i) {
            return Arrays.asList(new String[]{str});
        }
        ArrayList arrayList2 = new ArrayList(5);
        int i2 = i;
        int i3 = 0;
        do {
            int lastIndexOf = str.lastIndexOf(32, i2);
            if (lastIndexOf > i3) {
                String trimTrailing = trimTrailing(str.substring(i3, lastIndexOf));
                if (trimTrailing.length() > 0) {
                    arrayList2.add(trimTrailing);
                }
                i3 = lastIndexOf;
            } else {
                arrayList2.add(str.substring(i3, i2));
                i3 = i2;
            }
            while (i3 < length && str.charAt(i3) == ' ') {
                i3++;
            }
            i2 = i3 + i;
        } while (i2 < length);
        if (i3 < length) {
            String trimTrailing2 = trimTrailing(str.substring(i3));
            if (trimTrailing2.length() > 0) {
                arrayList2.add(trimTrailing2);
            }
        }
        return arrayList2;
    }
}
