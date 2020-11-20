package com.unboundid.ldif;

import com.unboundid.ldap.sdk.C3122DN;
import com.unboundid.util.ByteStringBuffer;
import java.io.Serializable;

public interface LDIFRecord extends Serializable {
    String getDN();

    C3122DN getParsedDN();

    void toLDIF(ByteStringBuffer byteStringBuffer);

    void toLDIF(ByteStringBuffer byteStringBuffer, int i);

    String[] toLDIF();

    String[] toLDIF(int i);

    String toLDIFString();

    String toLDIFString(int i);

    void toLDIFString(StringBuilder sb);

    void toLDIFString(StringBuilder sb, int i);

    String toString();

    void toString(StringBuilder sb);
}
