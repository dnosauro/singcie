package org.spongycastle.cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1OctetStringParser;
import org.spongycastle.asn1.ASN1SequenceParser;
import org.spongycastle.asn1.cms.CompressedDataParser;
import org.spongycastle.asn1.cms.ContentInfoParser;
import org.spongycastle.operator.InputExpanderProvider;

public class CMSCompressedDataParser extends CMSContentInfoParser {
    public CMSCompressedDataParser(InputStream inputStream) {
        super(inputStream);
    }

    public CMSCompressedDataParser(byte[] bArr) {
        this((InputStream) new ByteArrayInputStream(bArr));
    }

    public CMSTypedStream getContent(InputExpanderProvider inputExpanderProvider) {
        try {
            CompressedDataParser compressedDataParser = new CompressedDataParser((ASN1SequenceParser) this._contentInfo.getContent(16));
            ContentInfoParser encapContentInfo = compressedDataParser.getEncapContentInfo();
            return new CMSTypedStream(encapContentInfo.getContentType().getId(), inputExpanderProvider.get(compressedDataParser.getCompressionAlgorithmIdentifier()).getInputStream(((ASN1OctetStringParser) encapContentInfo.getContent(4)).getOctetStream()));
        } catch (IOException e) {
            throw new CMSException("IOException reading compressed content.", e);
        }
    }
}
