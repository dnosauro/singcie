package okhttp3.internal.http2;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okhttp3.internal.Util;
import okhttp3.internal.http2.Hpack;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Http2Reader implements Closeable {
    static final Logger logger = Logger.getLogger(Http2.class.getName());
    private final boolean client;
    private final ContinuationSource continuation = new ContinuationSource(this.source);
    final Hpack.Reader hpackReader = new Hpack.Reader(4096, this.continuation);
    private final BufferedSource source;

    static final class ContinuationSource implements Source {
        byte flags;
        int left;
        int length;
        short padding;
        private final BufferedSource source;
        int streamId;

        ContinuationSource(BufferedSource bufferedSource) {
            this.source = bufferedSource;
        }

        private void readContinuationHeader() {
            int i = this.streamId;
            int readMedium = Http2Reader.readMedium(this.source);
            this.left = readMedium;
            this.length = readMedium;
            byte readByte = (byte) (this.source.readByte() & 255);
            this.flags = (byte) (this.source.readByte() & 255);
            if (Http2Reader.logger.isLoggable(Level.FINE)) {
                Http2Reader.logger.fine(Http2.frameLog(true, this.streamId, this.length, readByte, this.flags));
            }
            this.streamId = this.source.readInt() & Integer.MAX_VALUE;
            if (readByte != 9) {
                throw Http2.ioException("%s != TYPE_CONTINUATION", Byte.valueOf(readByte));
            } else if (this.streamId != i) {
                throw Http2.ioException("TYPE_CONTINUATION streamId changed", new Object[0]);
            }
        }

        public void close() {
        }

        public long read(Buffer buffer, long j) {
            while (true) {
                int i = this.left;
                if (i == 0) {
                    this.source.skip((long) this.padding);
                    this.padding = 0;
                    if ((this.flags & 4) != 0) {
                        return -1;
                    }
                    readContinuationHeader();
                } else {
                    long read = this.source.read(buffer, Math.min(j, (long) i));
                    if (read == -1) {
                        return -1;
                    }
                    this.left = (int) (((long) this.left) - read);
                    return read;
                }
            }
        }

        public Timeout timeout() {
            return this.source.timeout();
        }
    }

    interface Handler {
        void ackSettings();

        void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j);

        void data(boolean z, int i, BufferedSource bufferedSource, int i2);

        void goAway(int i, ErrorCode errorCode, ByteString byteString);

        void headers(boolean z, int i, int i2, List<Header> list);

        void ping(boolean z, int i, int i2);

        void priority(int i, int i2, int i3, boolean z);

        void pushPromise(int i, int i2, List<Header> list);

        void rstStream(int i, ErrorCode errorCode);

        void settings(boolean z, Settings settings);

        void windowUpdate(int i, long j);
    }

    Http2Reader(BufferedSource bufferedSource, boolean z) {
        this.source = bufferedSource;
        this.client = z;
    }

    static int lengthWithoutPadding(int i, byte b, short s) {
        if ((b & 8) != 0) {
            i--;
        }
        if (s <= i) {
            return (short) (i - s);
        }
        throw Http2.ioException("PROTOCOL_ERROR padding %s > remaining length %s", Short.valueOf(s), Integer.valueOf(i));
    }

    private void readData(Handler handler, int i, byte b, int i2) {
        short s = 0;
        if (i2 != 0) {
            boolean z = true;
            boolean z2 = (b & 1) != 0;
            if ((b & 32) == 0) {
                z = false;
            }
            if (!z) {
                if ((b & 8) != 0) {
                    s = (short) (this.source.readByte() & 255);
                }
                handler.data(z2, i2, this.source, lengthWithoutPadding(i, b, s));
                this.source.skip((long) s);
                return;
            }
            throw Http2.ioException("PROTOCOL_ERROR: FLAG_COMPRESSED without SETTINGS_COMPRESS_DATA", new Object[0]);
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_DATA streamId == 0", new Object[0]);
    }

    private void readGoAway(Handler handler, int i, byte b, int i2) {
        if (i < 8) {
            throw Http2.ioException("TYPE_GOAWAY length < 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            int i3 = i - 8;
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt2);
            if (fromHttp2 != null) {
                ByteString byteString = ByteString.EMPTY;
                if (i3 > 0) {
                    byteString = this.source.readByteString((long) i3);
                }
                handler.goAway(readInt, fromHttp2, byteString);
                return;
            }
            throw Http2.ioException("TYPE_GOAWAY unexpected error code: %d", Integer.valueOf(readInt2));
        } else {
            throw Http2.ioException("TYPE_GOAWAY streamId != 0", new Object[0]);
        }
    }

    private List<Header> readHeaderBlock(int i, short s, byte b, int i2) {
        ContinuationSource continuationSource = this.continuation;
        continuationSource.left = i;
        continuationSource.length = i;
        continuationSource.padding = s;
        continuationSource.flags = b;
        continuationSource.streamId = i2;
        this.hpackReader.readHeaders();
        return this.hpackReader.getAndResetHeaderList();
    }

    private void readHeaders(Handler handler, int i, byte b, int i2) {
        short s = 0;
        if (i2 != 0) {
            boolean z = (b & 1) != 0;
            if ((b & 8) != 0) {
                s = (short) (this.source.readByte() & 255);
            }
            if ((b & 32) != 0) {
                readPriority(handler, i2);
                i -= 5;
            }
            handler.headers(z, i2, -1, readHeaderBlock(lengthWithoutPadding(i, b, s), s, b, i2));
            return;
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_HEADERS streamId == 0", new Object[0]);
    }

    static int readMedium(BufferedSource bufferedSource) {
        return (bufferedSource.readByte() & 255) | ((bufferedSource.readByte() & 255) << Tnaf.POW_2_WIDTH) | ((bufferedSource.readByte() & 255) << 8);
    }

    private void readPing(Handler handler, int i, byte b, int i2) {
        boolean z = false;
        if (i != 8) {
            throw Http2.ioException("TYPE_PING length != 8: %s", Integer.valueOf(i));
        } else if (i2 == 0) {
            int readInt = this.source.readInt();
            int readInt2 = this.source.readInt();
            if ((b & 1) != 0) {
                z = true;
            }
            handler.ping(z, readInt, readInt2);
        } else {
            throw Http2.ioException("TYPE_PING streamId != 0", new Object[0]);
        }
    }

    private void readPriority(Handler handler, int i) {
        int readInt = this.source.readInt();
        handler.priority(i, readInt & Integer.MAX_VALUE, (this.source.readByte() & 255) + 1, (Integer.MIN_VALUE & readInt) != 0);
    }

    private void readPriority(Handler handler, int i, byte b, int i2) {
        if (i != 5) {
            throw Http2.ioException("TYPE_PRIORITY length: %d != 5", Integer.valueOf(i));
        } else if (i2 != 0) {
            readPriority(handler, i2);
        } else {
            throw Http2.ioException("TYPE_PRIORITY streamId == 0", new Object[0]);
        }
    }

    private void readPushPromise(Handler handler, int i, byte b, int i2) {
        short s = 0;
        if (i2 != 0) {
            if ((b & 8) != 0) {
                s = (short) (this.source.readByte() & 255);
            }
            handler.pushPromise(i2, this.source.readInt() & Integer.MAX_VALUE, readHeaderBlock(lengthWithoutPadding(i - 4, b, s), s, b, i2));
            return;
        }
        throw Http2.ioException("PROTOCOL_ERROR: TYPE_PUSH_PROMISE streamId == 0", new Object[0]);
    }

    private void readRstStream(Handler handler, int i, byte b, int i2) {
        if (i != 4) {
            throw Http2.ioException("TYPE_RST_STREAM length: %d != 4", Integer.valueOf(i));
        } else if (i2 != 0) {
            int readInt = this.source.readInt();
            ErrorCode fromHttp2 = ErrorCode.fromHttp2(readInt);
            if (fromHttp2 != null) {
                handler.rstStream(i2, fromHttp2);
            } else {
                throw Http2.ioException("TYPE_RST_STREAM unexpected error code: %d", Integer.valueOf(readInt));
            }
        } else {
            throw Http2.ioException("TYPE_RST_STREAM streamId == 0", new Object[0]);
        }
    }

    private void readSettings(Handler handler, int i, byte b, int i2) {
        if (i2 != 0) {
            throw Http2.ioException("TYPE_SETTINGS streamId != 0", new Object[0]);
        } else if ((b & 1) != 0) {
            if (i == 0) {
                handler.ackSettings();
                return;
            }
            throw Http2.ioException("FRAME_SIZE_ERROR ack frame should be empty!", new Object[0]);
        } else if (i % 6 == 0) {
            Settings settings = new Settings();
            for (int i3 = 0; i3 < i; i3 += 6) {
                short readShort = this.source.readShort() & 65535;
                int readInt = this.source.readInt();
                switch (readShort) {
                    case 2:
                        if (!(readInt == 0 || readInt == 1)) {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_ENABLE_PUSH != 0 or 1", new Object[0]);
                        }
                    case 3:
                        readShort = 4;
                        break;
                    case 4:
                        readShort = 7;
                        if (readInt >= 0) {
                            break;
                        } else {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_INITIAL_WINDOW_SIZE > 2^31 - 1", new Object[0]);
                        }
                    case 5:
                        if (readInt >= 16384 && readInt <= 16777215) {
                            break;
                        } else {
                            throw Http2.ioException("PROTOCOL_ERROR SETTINGS_MAX_FRAME_SIZE: %s", Integer.valueOf(readInt));
                        }
                        break;
                }
                settings.set(readShort, readInt);
            }
            handler.settings(false, settings);
        } else {
            throw Http2.ioException("TYPE_SETTINGS length %% 6 != 0: %s", Integer.valueOf(i));
        }
    }

    private void readWindowUpdate(Handler handler, int i, byte b, int i2) {
        if (i == 4) {
            long readInt = ((long) this.source.readInt()) & 2147483647L;
            if (readInt != 0) {
                handler.windowUpdate(i2, readInt);
            } else {
                throw Http2.ioException("windowSizeIncrement was 0", Long.valueOf(readInt));
            }
        } else {
            throw Http2.ioException("TYPE_WINDOW_UPDATE length !=4: %s", Integer.valueOf(i));
        }
    }

    public void close() {
        this.source.close();
    }

    public boolean nextFrame(boolean z, Handler handler) {
        try {
            this.source.require(9);
            int readMedium = readMedium(this.source);
            if (readMedium < 0 || readMedium > 16384) {
                throw Http2.ioException("FRAME_SIZE_ERROR: %s", Integer.valueOf(readMedium));
            }
            byte readByte = (byte) (this.source.readByte() & 255);
            if (!z || readByte == 4) {
                byte readByte2 = (byte) (this.source.readByte() & 255);
                int readInt = this.source.readInt() & Integer.MAX_VALUE;
                if (logger.isLoggable(Level.FINE)) {
                    logger.fine(Http2.frameLog(true, readInt, readMedium, readByte, readByte2));
                }
                switch (readByte) {
                    case 0:
                        readData(handler, readMedium, readByte2, readInt);
                        break;
                    case 1:
                        readHeaders(handler, readMedium, readByte2, readInt);
                        break;
                    case 2:
                        readPriority(handler, readMedium, readByte2, readInt);
                        break;
                    case 3:
                        readRstStream(handler, readMedium, readByte2, readInt);
                        break;
                    case 4:
                        readSettings(handler, readMedium, readByte2, readInt);
                        break;
                    case 5:
                        readPushPromise(handler, readMedium, readByte2, readInt);
                        break;
                    case 6:
                        readPing(handler, readMedium, readByte2, readInt);
                        break;
                    case 7:
                        readGoAway(handler, readMedium, readByte2, readInt);
                        break;
                    case 8:
                        readWindowUpdate(handler, readMedium, readByte2, readInt);
                        break;
                    default:
                        this.source.skip((long) readMedium);
                        break;
                }
                return true;
            }
            throw Http2.ioException("Expected a SETTINGS frame but was %s", Byte.valueOf(readByte));
        } catch (IOException unused) {
            return false;
        }
    }

    public void readConnectionPreface(Handler handler) {
        if (!this.client) {
            ByteString readByteString = this.source.readByteString((long) Http2.CONNECTION_PREFACE.size());
            if (logger.isLoggable(Level.FINE)) {
                logger.fine(Util.format("<< CONNECTION %s", readByteString.hex()));
            }
            if (!Http2.CONNECTION_PREFACE.equals(readByteString)) {
                throw Http2.ioException("Expected a connection header but was %s", readByteString.utf8());
            }
        } else if (!nextFrame(true, handler)) {
            throw Http2.ioException("Required SETTINGS preface not received", new Object[0]);
        }
    }
}
