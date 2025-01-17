package org.spongycastle.cms;

import java.io.OutputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.BERSequenceGenerator;
import org.spongycastle.asn1.cms.CMSObjectIdentifiers;
import org.spongycastle.operator.OutputCompressor;

public class CMSCompressedDataStreamGenerator {
    public static final String ZLIB = "1.2.840.113549.1.9.16.3.8";
    private int _bufferSize;

    private class CmsCompressedOutputStream extends OutputStream {
        private BERSequenceGenerator _cGen;
        private BERSequenceGenerator _eiGen;
        private OutputStream _out;
        private BERSequenceGenerator _sGen;

        CmsCompressedOutputStream(OutputStream outputStream, BERSequenceGenerator bERSequenceGenerator, BERSequenceGenerator bERSequenceGenerator2, BERSequenceGenerator bERSequenceGenerator3) {
            this._out = outputStream;
            this._sGen = bERSequenceGenerator;
            this._cGen = bERSequenceGenerator2;
            this._eiGen = bERSequenceGenerator3;
        }

        public void close() {
            this._out.close();
            this._eiGen.close();
            this._cGen.close();
            this._sGen.close();
        }

        public void write(int i) {
            this._out.write(i);
        }

        public void write(byte[] bArr) {
            this._out.write(bArr);
        }

        public void write(byte[] bArr, int i, int i2) {
            this._out.write(bArr, i, i2);
        }
    }

    public OutputStream open(OutputStream outputStream, OutputCompressor outputCompressor) {
        return open(CMSObjectIdentifiers.data, outputStream, outputCompressor);
    }

    public OutputStream open(ASN1ObjectIdentifier aSN1ObjectIdentifier, OutputStream outputStream, OutputCompressor outputCompressor) {
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject(CMSObjectIdentifiers.compressedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject(new ASN1Integer(0));
        bERSequenceGenerator2.addObject(outputCompressor.getAlgorithmIdentifier());
        BERSequenceGenerator bERSequenceGenerator3 = new BERSequenceGenerator(bERSequenceGenerator2.getRawOutputStream());
        bERSequenceGenerator3.addObject(aSN1ObjectIdentifier);
        return new CmsCompressedOutputStream(outputCompressor.getOutputStream(CMSUtils.createBEROctetOutputStream(bERSequenceGenerator3.getRawOutputStream(), 0, true, this._bufferSize)), bERSequenceGenerator, bERSequenceGenerator2, bERSequenceGenerator3);
    }

    public void setBufferSize(int i) {
        this._bufferSize = i;
    }
}
