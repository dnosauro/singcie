package org.spongycastle.crypto.generators;

import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.protocol.LDAPMessage;
import java.io.ByteArrayOutputStream;
import java.util.HashSet;
import java.util.Set;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.Strings;

public class OpenBSDBCrypt {
    private static final Set<String> allowedVersions = new HashSet();
    private static final byte[] decodingTable = new byte[128];
    private static final String defaultVersion = "2y";
    private static final byte[] encodingTable = {46, 47, 65, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, 67, 68, 69, 70, 71, 72, 73, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, 75, 76, 77, 78, 79, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, 98, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, 106, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, 112, 113, 114, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, 116, 117, 118, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, 122, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, ASN1Constants.UNIVERSAL_SET_TYPE, 50, 51, 52, 53, 54, 55, 56, 57};

    static {
        allowedVersions.add("2a");
        allowedVersions.add(defaultVersion);
        allowedVersions.add("2b");
        int i = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr = decodingTable;
            if (i2 >= bArr.length) {
                break;
            }
            bArr[i2] = -1;
            i2++;
        }
        while (true) {
            byte[] bArr2 = encodingTable;
            if (i < bArr2.length) {
                decodingTable[bArr2[i]] = (byte) i;
                i++;
            } else {
                return;
            }
        }
    }

    public static boolean checkPassword(String str, char[] cArr) {
        if (str.length() != 60) {
            throw new DataLengthException("Bcrypt String length: " + str.length() + ", 60 required.");
        } else if (str.charAt(0) == '$' && str.charAt(3) == '$' && str.charAt(6) == '$') {
            String substring = str.substring(1, 3);
            if (allowedVersions.contains(substring)) {
                try {
                    int parseInt = Integer.parseInt(str.substring(4, 6));
                    if (parseInt < 4 || parseInt > 31) {
                        throw new IllegalArgumentException("Invalid cost factor: " + parseInt + ", 4 < cost < 31 expected.");
                    } else if (cArr != null) {
                        return str.equals(generate(substring, cArr, decodeSaltString(str.substring(str.lastIndexOf(36) + 1, str.length() - 31)), parseInt));
                    } else {
                        throw new IllegalArgumentException("Missing password.");
                    }
                } catch (NumberFormatException unused) {
                    throw new IllegalArgumentException("Invalid cost factor: " + str.substring(4, 6));
                }
            } else {
                throw new IllegalArgumentException("Bcrypt version '" + str.substring(1, 3) + "' is not supported by this implementation");
            }
        } else {
            throw new IllegalArgumentException("Invalid Bcrypt String format.");
        }
    }

    private static String createBcryptString(String str, byte[] bArr, byte[] bArr2, int i) {
        String str2;
        if (allowedVersions.contains(str)) {
            StringBuffer stringBuffer = new StringBuffer(60);
            stringBuffer.append('$');
            stringBuffer.append(str);
            stringBuffer.append('$');
            if (i < 10) {
                str2 = "0" + i;
            } else {
                str2 = Integer.toString(i);
            }
            stringBuffer.append(str2);
            stringBuffer.append('$');
            stringBuffer.append(encodeData(bArr2));
            stringBuffer.append(encodeData(BCrypt.generate(bArr, bArr2, i)));
            return stringBuffer.toString();
        }
        throw new IllegalArgumentException("Version " + str + " is not accepted by this implementation.");
    }

    private static byte[] decodeSaltString(String str) {
        char[] charArray = str.toCharArray();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16);
        if (charArray.length == 22) {
            for (char c : charArray) {
                if (c > 'z' || c < '.' || (c > '9' && c < 'A')) {
                    throw new IllegalArgumentException("Salt string contains invalid character: " + c);
                }
            }
            char[] cArr = new char[24];
            System.arraycopy(charArray, 0, cArr, 0, charArray.length);
            int length = cArr.length;
            for (int i = 0; i < length; i += 4) {
                byte[] bArr = decodingTable;
                byte b = bArr[cArr[i]];
                byte b2 = bArr[cArr[i + 1]];
                byte b3 = bArr[cArr[i + 2]];
                byte b4 = bArr[cArr[i + 3]];
                byteArrayOutputStream.write((b << 2) | (b2 >> 4));
                byteArrayOutputStream.write((b2 << 4) | (b3 >> 2));
                byteArrayOutputStream.write(b4 | (b3 << 6));
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byte[] bArr2 = new byte[16];
            System.arraycopy(byteArray, 0, bArr2, 0, bArr2.length);
            return bArr2;
        }
        throw new DataLengthException("Invalid base64 salt length: " + charArray.length + " , 22 required.");
    }

    private static String encodeData(byte[] bArr) {
        boolean z;
        if (bArr.length == 24 || bArr.length == 16) {
            if (bArr.length == 16) {
                byte[] bArr2 = new byte[18];
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
                bArr = bArr2;
                z = true;
            } else {
                bArr[bArr.length - 1] = 0;
                z = false;
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int length = bArr.length;
            for (int i = 0; i < length; i += 3) {
                byte b = bArr[i] & 255;
                byte b2 = bArr[i + 1] & 255;
                byte b3 = bArr[i + 2] & 255;
                byteArrayOutputStream.write(encodingTable[(b >>> 2) & 63]);
                byteArrayOutputStream.write(encodingTable[((b << 4) | (b2 >>> 4)) & 63]);
                byteArrayOutputStream.write(encodingTable[((b2 << 2) | (b3 >>> 6)) & 63]);
                byteArrayOutputStream.write(encodingTable[b3 & 63]);
            }
            String fromByteArray = Strings.fromByteArray(byteArrayOutputStream.toByteArray());
            return fromByteArray.substring(0, z ? 22 : fromByteArray.length() - 1);
        }
        throw new DataLengthException("Invalid length: " + bArr.length + ", 24 for key or 16 for salt expected");
    }

    public static String generate(String str, char[] cArr, byte[] bArr, int i) {
        if (!allowedVersions.contains(str)) {
            throw new IllegalArgumentException("Version " + str + " is not accepted by this implementation.");
        } else if (cArr == null) {
            throw new IllegalArgumentException("Password required.");
        } else if (bArr == null) {
            throw new IllegalArgumentException("Salt required.");
        } else if (bArr.length != 16) {
            throw new DataLengthException("16 byte salt required: " + bArr.length);
        } else if (i < 4 || i > 31) {
            throw new IllegalArgumentException("Invalid cost factor.");
        } else {
            byte[] uTF8ByteArray = Strings.toUTF8ByteArray(cArr);
            int i2 = 72;
            if (uTF8ByteArray.length < 72) {
                i2 = uTF8ByteArray.length + 1;
            }
            byte[] bArr2 = new byte[i2];
            System.arraycopy(uTF8ByteArray, 0, bArr2, 0, bArr2.length > uTF8ByteArray.length ? uTF8ByteArray.length : bArr2.length);
            Arrays.fill(uTF8ByteArray, (byte) 0);
            String createBcryptString = createBcryptString(str, bArr2, bArr, i);
            Arrays.fill(bArr2, (byte) 0);
            return createBcryptString;
        }
    }

    public static String generate(char[] cArr, byte[] bArr, int i) {
        return generate(defaultVersion, cArr, bArr, i);
    }
}
