package org.spongycastle.asn1.dvcs;

import java.math.BigInteger;
import org.apache.commons.p172io.IOUtils;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1GeneralizedTime;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.x509.Extensions;
import org.spongycastle.asn1.x509.GeneralNames;
import org.spongycastle.asn1.x509.PolicyInformation;

public class DVCSRequestInformation extends ASN1Object {
    private static final int DEFAULT_VERSION = 1;
    private static final int TAG_DATA_LOCATIONS = 3;
    private static final int TAG_DVCS = 2;
    private static final int TAG_EXTENSIONS = 4;
    private static final int TAG_REQUESTER = 0;
    private static final int TAG_REQUEST_POLICY = 1;
    private GeneralNames dataLocations;
    private GeneralNames dvcs;
    private Extensions extensions;
    private BigInteger nonce;
    private PolicyInformation requestPolicy;
    private DVCSTime requestTime;
    private GeneralNames requester;
    private ServiceType service;
    private int version = 1;

    private DVCSRequestInformation(ASN1Sequence aSN1Sequence) {
        int i = 1;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
            this.version = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue().intValue();
        } else {
            this.version = 1;
            i = 0;
        }
        this.service = ServiceType.getInstance(aSN1Sequence.getObjectAt(i));
        for (int i2 = i + 1; i2 < aSN1Sequence.size(); i2++) {
            ASN1Encodable objectAt = aSN1Sequence.getObjectAt(i2);
            if (objectAt instanceof ASN1Integer) {
                this.nonce = ASN1Integer.getInstance(objectAt).getValue();
            } else if (!(objectAt instanceof ASN1GeneralizedTime) && (objectAt instanceof ASN1TaggedObject)) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(objectAt);
                int tagNo = instance.getTagNo();
                switch (tagNo) {
                    case 0:
                        this.requester = GeneralNames.getInstance(instance, false);
                        break;
                    case 1:
                        this.requestPolicy = PolicyInformation.getInstance(ASN1Sequence.getInstance(instance, false));
                        break;
                    case 2:
                        this.dvcs = GeneralNames.getInstance(instance, false);
                        break;
                    case 3:
                        this.dataLocations = GeneralNames.getInstance(instance, false);
                        break;
                    case 4:
                        this.extensions = Extensions.getInstance(instance, false);
                        break;
                    default:
                        throw new IllegalArgumentException("unknown tag number encountered: " + tagNo);
                }
            } else {
                this.requestTime = DVCSTime.getInstance(objectAt);
            }
        }
    }

    public static DVCSRequestInformation getInstance(Object obj) {
        if (obj instanceof DVCSRequestInformation) {
            return (DVCSRequestInformation) obj;
        }
        if (obj != null) {
            return new DVCSRequestInformation(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static DVCSRequestInformation getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public GeneralNames getDVCS() {
        return this.dvcs;
    }

    public GeneralNames getDataLocations() {
        return this.dataLocations;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public BigInteger getNonce() {
        return this.nonce;
    }

    public PolicyInformation getRequestPolicy() {
        return this.requestPolicy;
    }

    public DVCSTime getRequestTime() {
        return this.requestTime;
    }

    public GeneralNames getRequester() {
        return this.requester;
    }

    public ServiceType getService() {
        return this.service;
    }

    public int getVersion() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        int i = this.version;
        if (i != 1) {
            aSN1EncodableVector.add(new ASN1Integer((long) i));
        }
        aSN1EncodableVector.add(this.service);
        BigInteger bigInteger = this.nonce;
        if (bigInteger != null) {
            aSN1EncodableVector.add(new ASN1Integer(bigInteger));
        }
        DVCSTime dVCSTime = this.requestTime;
        if (dVCSTime != null) {
            aSN1EncodableVector.add(dVCSTime);
        }
        int[] iArr = {0, 1, 2, 3, 4};
        ASN1Encodable[] aSN1EncodableArr = {this.requester, this.requestPolicy, this.dvcs, this.dataLocations, this.extensions};
        for (int i2 = 0; i2 < iArr.length; i2++) {
            int i3 = iArr[i2];
            ASN1Encodable aSN1Encodable = aSN1EncodableArr[i2];
            if (aSN1Encodable != null) {
                aSN1EncodableVector.add(new DERTaggedObject(false, i3, aSN1Encodable));
            }
        }
        return new DERSequence(aSN1EncodableVector);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("DVCSRequestInformation {\n");
        if (this.version != 1) {
            stringBuffer.append("version: " + this.version + IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuffer.append("service: " + this.service + IOUtils.LINE_SEPARATOR_UNIX);
        if (this.nonce != null) {
            stringBuffer.append("nonce: " + this.nonce + IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (this.requestTime != null) {
            stringBuffer.append("requestTime: " + this.requestTime + IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (this.requester != null) {
            stringBuffer.append("requester: " + this.requester + IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (this.requestPolicy != null) {
            stringBuffer.append("requestPolicy: " + this.requestPolicy + IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (this.dvcs != null) {
            stringBuffer.append("dvcs: " + this.dvcs + IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (this.dataLocations != null) {
            stringBuffer.append("dataLocations: " + this.dataLocations + IOUtils.LINE_SEPARATOR_UNIX);
        }
        if (this.extensions != null) {
            stringBuffer.append("extensions: " + this.extensions + IOUtils.LINE_SEPARATOR_UNIX);
        }
        stringBuffer.append("}\n");
        return stringBuffer.toString();
    }
}
