package org.spongycastle.crypto.tls;

import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import org.spongycastle.util.Arrays;

public class ServerSRPParams {

    /* renamed from: B */
    protected BigInteger f7913B;

    /* renamed from: N */
    protected BigInteger f7914N;

    /* renamed from: g */
    protected BigInteger f7915g;

    /* renamed from: s */
    protected byte[] f7916s;

    public ServerSRPParams(BigInteger bigInteger, BigInteger bigInteger2, byte[] bArr, BigInteger bigInteger3) {
        this.f7914N = bigInteger;
        this.f7915g = bigInteger2;
        this.f7916s = Arrays.clone(bArr);
        this.f7913B = bigInteger3;
    }

    public static ServerSRPParams parse(InputStream inputStream) {
        return new ServerSRPParams(TlsSRPUtils.readSRPParameter(inputStream), TlsSRPUtils.readSRPParameter(inputStream), TlsUtils.readOpaque8(inputStream), TlsSRPUtils.readSRPParameter(inputStream));
    }

    public void encode(OutputStream outputStream) {
        TlsSRPUtils.writeSRPParameter(this.f7914N, outputStream);
        TlsSRPUtils.writeSRPParameter(this.f7915g, outputStream);
        TlsUtils.writeOpaque8(this.f7916s, outputStream);
        TlsSRPUtils.writeSRPParameter(this.f7913B, outputStream);
    }

    public BigInteger getB() {
        return this.f7913B;
    }

    public BigInteger getG() {
        return this.f7915g;
    }

    public BigInteger getN() {
        return this.f7914N;
    }

    public byte[] getS() {
        return this.f7916s;
    }
}
