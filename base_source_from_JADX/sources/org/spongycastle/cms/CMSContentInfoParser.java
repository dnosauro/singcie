package org.spongycastle.cms;

import java.io.IOException;
import java.io.InputStream;
import org.spongycastle.asn1.ASN1SequenceParser;
import org.spongycastle.asn1.ASN1StreamParser;
import org.spongycastle.asn1.cms.ContentInfoParser;

public class CMSContentInfoParser {
    protected ContentInfoParser _contentInfo;
    protected InputStream _data;

    protected CMSContentInfoParser(InputStream inputStream) {
        this._data = inputStream;
        try {
            ASN1SequenceParser aSN1SequenceParser = (ASN1SequenceParser) new ASN1StreamParser(inputStream).readObject();
            if (aSN1SequenceParser != null) {
                this._contentInfo = new ContentInfoParser(aSN1SequenceParser);
                return;
            }
            throw new CMSException("No content found.");
        } catch (IOException e) {
            throw new CMSException("IOException reading content.", e);
        } catch (ClassCastException e2) {
            throw new CMSException("Unexpected object reading content.", e2);
        }
    }

    public void close() {
        this._data.close();
    }
}
