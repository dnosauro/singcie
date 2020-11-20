package com.unboundid.ldap.sdk.schema;

import com.github.appintro.AppIntroBaseFragmentKt;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public final class AttributeSyntaxDefinition extends SchemaElement {
    private static final long serialVersionUID = 8593718232711987488L;
    private final String attributeSyntaxString;
    private final String description;
    private final Map<String, String[]> extensions;
    private final String oid;

    public AttributeSyntaxDefinition(String str) {
        Validator.ensureNotNull(str);
        this.attributeSyntaxString = str.trim();
        int length = this.attributeSyntaxString.length();
        if (length == 0) {
            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRSYNTAX_DECODE_EMPTY.get());
        } else if (this.attributeSyntaxString.charAt(0) == '(') {
            int skipSpaces = skipSpaces(this.attributeSyntaxString, 1, length);
            StringBuilder sb = new StringBuilder();
            int readOID = readOID(this.attributeSyntaxString, skipSpaces, length, sb);
            this.oid = sb.toString();
            String str2 = null;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (true) {
                int skipSpaces2 = skipSpaces(this.attributeSyntaxString, readOID, length);
                int i = skipSpaces2;
                while (i < length && this.attributeSyntaxString.charAt(i) != ' ') {
                    i++;
                }
                String substring = this.attributeSyntaxString.substring(skipSpaces2, i);
                String lowerCase = StaticUtils.toLowerCase(substring);
                if (lowerCase.equals(")")) {
                    if (i >= length) {
                        this.description = str2;
                        this.extensions = Collections.unmodifiableMap(linkedHashMap);
                        return;
                    }
                    throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRSYNTAX_DECODE_CLOSE_NOT_AT_END.get(this.attributeSyntaxString));
                } else if (lowerCase.equals(AppIntroBaseFragmentKt.ARG_DESC)) {
                    if (str2 == null) {
                        int skipSpaces3 = skipSpaces(this.attributeSyntaxString, i, length);
                        StringBuilder sb2 = new StringBuilder();
                        readOID = readQDString(this.attributeSyntaxString, skipSpaces3, length, sb2);
                        str2 = sb2.toString();
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRSYNTAX_DECODE_MULTIPLE_DESC.get(this.attributeSyntaxString));
                    }
                } else if (lowerCase.startsWith("x-")) {
                    int skipSpaces4 = skipSpaces(this.attributeSyntaxString, i, length);
                    ArrayList arrayList = new ArrayList();
                    int readQDStrings = readQDStrings(this.attributeSyntaxString, skipSpaces4, length, arrayList);
                    String[] strArr = new String[arrayList.size()];
                    arrayList.toArray(strArr);
                    if (!linkedHashMap.containsKey(substring)) {
                        linkedHashMap.put(substring, strArr);
                        readOID = readQDStrings;
                    } else {
                        throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRSYNTAX_DECODE_DUP_EXT.get(this.attributeSyntaxString, substring));
                    }
                } else {
                    throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRSYNTAX_DECODE_UNEXPECTED_TOKEN.get(this.attributeSyntaxString, substring));
                }
            }
        } else {
            throw new LDAPException(ResultCode.DECODING_ERROR, SchemaMessages.ERR_ATTRSYNTAX_DECODE_NO_OPENING_PAREN.get(this.attributeSyntaxString));
        }
    }

    public AttributeSyntaxDefinition(String str, String str2, Map<String, String[]> map) {
        Validator.ensureNotNull(str);
        this.oid = str;
        this.description = str2;
        this.extensions = map == null ? Collections.emptyMap() : Collections.unmodifiableMap(map);
        StringBuilder sb = new StringBuilder();
        createDefinitionString(sb);
        this.attributeSyntaxString = sb.toString();
    }

    private void createDefinitionString(StringBuilder sb) {
        sb.append("( ");
        sb.append(this.oid);
        if (this.description != null) {
            sb.append(" DESC '");
            encodeValue(this.description, sb);
            sb.append('\'');
        }
        for (Map.Entry next : this.extensions.entrySet()) {
            String str = (String) next.getKey();
            String[] strArr = (String[]) next.getValue();
            if (strArr.length == 1) {
                sb.append(' ');
                sb.append(str);
                sb.append(" '");
                encodeValue(strArr[0], sb);
                sb.append('\'');
            } else {
                sb.append(' ');
                sb.append(str);
                sb.append(" (");
                for (String encodeValue : strArr) {
                    sb.append(" '");
                    encodeValue(encodeValue, sb);
                    sb.append('\'');
                }
                sb.append(" )");
            }
        }
        sb.append(" )");
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeSyntaxDefinition)) {
            return false;
        }
        AttributeSyntaxDefinition attributeSyntaxDefinition = (AttributeSyntaxDefinition) obj;
        return this.oid.equals(attributeSyntaxDefinition.oid) && StaticUtils.bothNullOrEqualIgnoreCase(this.description, attributeSyntaxDefinition.description) && extensionsEqual(this.extensions, attributeSyntaxDefinition.extensions);
    }

    public String getDescription() {
        return this.description;
    }

    public Map<String, String[]> getExtensions() {
        return this.extensions;
    }

    public String getOID() {
        return this.oid;
    }

    public int hashCode() {
        return this.oid.hashCode();
    }

    public String toString() {
        return this.attributeSyntaxString;
    }
}
