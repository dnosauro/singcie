package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Exception;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LDAPResult implements LDAPResponse, Serializable {
    static final byte TYPE_REFERRAL_URLS = -93;
    private static final long serialVersionUID = 2215819095653175991L;
    private final String diagnosticMessage;
    private final String matchedDN;
    private final int messageID;
    private final Byte protocolOpType;
    private final String[] referralURLs;
    private final Control[] responseControls;
    private final ResultCode resultCode;

    public LDAPResult(int i, ResultCode resultCode2) {
        this((Byte) null, i, resultCode2, (String) null, (String) null, StaticUtils.NO_STRINGS, NO_CONTROLS);
    }

    public LDAPResult(int i, ResultCode resultCode2, String str, String str2, List<String> list, List<Control> list2) {
        this((Byte) null, i, resultCode2, str, str2, list, list2);
    }

    public LDAPResult(int i, ResultCode resultCode2, String str, String str2, String[] strArr, Control[] controlArr) {
        this((Byte) null, i, resultCode2, str, str2, strArr, controlArr);
    }

    protected LDAPResult(LDAPResult lDAPResult) {
        this.protocolOpType = lDAPResult.protocolOpType;
        this.messageID = lDAPResult.messageID;
        this.resultCode = lDAPResult.resultCode;
        this.diagnosticMessage = lDAPResult.diagnosticMessage;
        this.matchedDN = lDAPResult.matchedDN;
        this.referralURLs = lDAPResult.referralURLs;
        this.responseControls = lDAPResult.responseControls;
    }

    private LDAPResult(Byte b, int i, ResultCode resultCode2, String str, String str2, List<String> list, List<Control> list2) {
        this.protocolOpType = b;
        this.messageID = i;
        this.resultCode = resultCode2;
        this.diagnosticMessage = str;
        this.matchedDN = str2;
        if (list == null || list.isEmpty()) {
            this.referralURLs = StaticUtils.NO_STRINGS;
        } else {
            this.referralURLs = new String[list.size()];
            list.toArray(this.referralURLs);
        }
        if (list2 == null || list2.isEmpty()) {
            this.responseControls = NO_CONTROLS;
            return;
        }
        this.responseControls = new Control[list2.size()];
        list2.toArray(this.responseControls);
    }

    private LDAPResult(Byte b, int i, ResultCode resultCode2, String str, String str2, String[] strArr, Control[] controlArr) {
        this.protocolOpType = b;
        this.messageID = i;
        this.resultCode = resultCode2;
        this.diagnosticMessage = str;
        this.matchedDN = str2;
        if (strArr == null) {
            this.referralURLs = StaticUtils.NO_STRINGS;
        } else {
            this.referralURLs = strArr;
        }
        if (controlArr == null) {
            this.responseControls = NO_CONTROLS;
        } else {
            this.responseControls = controlArr;
        }
    }

    static LDAPResult readLDAPResultFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        Control[] controlArr;
        try {
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            byte type = beginSequence.getType();
            ResultCode valueOf = ResultCode.valueOf(aSN1StreamReader.readEnumerated().intValue());
            String readString = aSN1StreamReader.readString();
            String str = readString.length() == 0 ? null : readString;
            String readString2 = aSN1StreamReader.readString();
            String str2 = readString2.length() == 0 ? null : readString2;
            String[] strArr = StaticUtils.NO_STRINGS;
            if (beginSequence.hasMoreElements()) {
                ArrayList arrayList = new ArrayList(1);
                ASN1StreamReaderSequence beginSequence2 = aSN1StreamReader.beginSequence();
                while (beginSequence2.hasMoreElements()) {
                    arrayList.add(aSN1StreamReader.readString());
                }
                strArr = new String[arrayList.size()];
                arrayList.toArray(strArr);
            }
            String[] strArr2 = strArr;
            Control[] controlArr2 = NO_CONTROLS;
            if (aSN1StreamReaderSequence.hasMoreElements()) {
                ArrayList arrayList2 = new ArrayList(1);
                ASN1StreamReaderSequence beginSequence3 = aSN1StreamReader.beginSequence();
                while (beginSequence3.hasMoreElements()) {
                    arrayList2.add(Control.readFrom(aSN1StreamReader));
                }
                Control[] controlArr3 = new Control[arrayList2.size()];
                arrayList2.toArray(controlArr3);
                controlArr = controlArr3;
            } else {
                controlArr = controlArr2;
            }
            return new LDAPResult(Byte.valueOf(type), i, valueOf, str2, str, strArr2, controlArr);
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw e;
        } catch (ASN1Exception e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_RESULT_CANNOT_DECODE.get(e2.getMessage()), e2);
        } catch (Exception e3) {
            Debug.debugException(e3);
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_RESULT_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e3)), e3);
        }
    }

    public final String getDiagnosticMessage() {
        return this.diagnosticMessage;
    }

    public final String getMatchedDN() {
        return this.matchedDN;
    }

    public final int getMessageID() {
        return this.messageID;
    }

    public final String[] getReferralURLs() {
        return this.referralURLs;
    }

    public final Control getResponseControl(String str) {
        for (Control control : this.responseControls) {
            if (control.getOID().equals(str)) {
                return control;
            }
        }
        return null;
    }

    public final Control[] getResponseControls() {
        return this.responseControls;
    }

    public final ResultCode getResultCode() {
        return this.resultCode;
    }

    public final boolean hasResponseControl() {
        return this.responseControls.length > 0;
    }

    public final boolean hasResponseControl(String str) {
        for (Control oid : this.responseControls) {
            if (oid.getOID().equals(str)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        String str;
        sb.append("LDAPResult(resultCode=");
        sb.append(this.resultCode);
        if (this.messageID >= 0) {
            sb.append(", messageID=");
            sb.append(this.messageID);
        }
        Byte b = this.protocolOpType;
        if (b != null) {
            byte byteValue = b.byteValue();
            if (byteValue == 97) {
                str = ", opType='bind'";
            } else if (byteValue == 101) {
                str = ", opType='search'";
            } else if (byteValue == 103) {
                str = ", opType='modify'";
            } else if (byteValue == 105) {
                str = ", opType='add'";
            } else if (byteValue == 107) {
                str = ", opType='delete'";
            } else if (byteValue == 109) {
                str = ", opType='modify DN'";
            } else if (byteValue == 111) {
                str = ", opType='compare'";
            } else if (byteValue == 120) {
                str = ", opType='extended'";
            }
            sb.append(str);
        }
        if (this.diagnosticMessage != null) {
            sb.append(", diagnosticMessage='");
            sb.append(this.diagnosticMessage);
            sb.append('\'');
        }
        if (this.matchedDN != null) {
            sb.append(", matchedDN='");
            sb.append(this.matchedDN);
            sb.append('\'');
        }
        if (this.referralURLs.length > 0) {
            sb.append(", referralURLs={");
            for (int i = 0; i < this.referralURLs.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append('\'');
                sb.append(this.referralURLs[i]);
                sb.append('\'');
            }
            sb.append('}');
        }
        if (this.responseControls.length > 0) {
            sb.append(", responseControls={");
            for (int i2 = 0; i2 < this.responseControls.length; i2++) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(this.responseControls[i2]);
            }
            sb.append('}');
        }
        sb.append(')');
    }
}
