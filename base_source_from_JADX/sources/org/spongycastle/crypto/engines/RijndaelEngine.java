package org.spongycastle.crypto.engines;

import com.parse.ParseException;
import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.protocol.ExtendedResponseProtocolOp;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.sdk.Filter;
import java.lang.reflect.Array;
import org.spongycastle.asn1.cmc.BodyPartID;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.crypto.tls.CipherSuite;

public class RijndaelEngine implements BlockCipher {
    private static final int MAXKC = 64;
    private static final int MAXROUNDS = 14;

    /* renamed from: S */
    private static final byte[] f7708S = {LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, 124, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, 123, -14, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, -59, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 1, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, 43, -2, -41, -85, 118, -54, MatchingRule.SUBSTRING_TYPE_SUBFINAL, -55, 125, -6, 89, 71, -16, -83, -44, Filter.FILTER_TYPE_NOT, -81, -100, Filter.FILTER_TYPE_SUBSTRING, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, Filter.FILTER_TYPE_GREATER_OR_EQUAL, -27, -15, 113, -40, ASN1Constants.UNIVERSAL_SET_TYPE, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, 60, -97, Filter.FILTER_TYPE_APPROXIMATE_MATCH, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, Tnaf.POW_2_WIDTH, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, 93, 25, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, -25, -56, 55, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, -115, -43, 78, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, 86, -12, -22, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, 122, -82, 8, -70, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, 37, 46, 28, Filter.FILTER_TYPE_LESS_OR_EQUAL, -76, -58, -24, -35, 116, 31, 75, -67, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, 112, 62, -75, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, 72, 3, -10, 14, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, Filter.FILTER_TYPE_OR, -119, 13, -65, -26, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, 65, -103, 45, 15, -80, 84, -69, 22};

    /* renamed from: Si */
    private static final byte[] f7709Si = {82, 9, 106, -43, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 54, Filter.FILTER_TYPE_GREATER_OR_EQUAL, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, MatchingRule.SUBSTRING_TYPE_SUBFINAL, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, Filter.FILTER_TYPE_LESS_OR_EQUAL, -62, 35, 61, -18, 76, -107, 11, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, -6, -61, 78, 8, 46, Filter.FILTER_TYPE_OR, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, 40, -39, 36, -78, 118, 91, Filter.FILTER_TYPE_NOT, 73, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, -47, 37, 114, -8, -10, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, -122, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, -104, 22, -44, Filter.FILTER_TYPE_SUBSTRING, 92, -52, 93, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, -74, -110, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, 112, 72, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, 15, 2, -63, -81, -67, 3, 1, 19, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, 58, -111, 17, 65, 79, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, -36, -22, -105, -14, -49, -50, -16, -76, -26, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, 71, -15, 26, 113, 29, 41, -59, -119, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, 32, -102, -37, -64, -2, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, -51, 90, -12, 31, -35, Filter.FILTER_TYPE_APPROXIMATE_MATCH, 51, -120, 7, -57, ASN1Constants.UNIVERSAL_SET_TYPE, -79, 18, Tnaf.POW_2_WIDTH, 89, 39, Byte.MIN_VALUE, -20, 95, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, 81, Byte.MAX_VALUE, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, 25, -75, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, 13, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, 23, 43, 4, 126, -70, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, -42, 38, -31, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, 20, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, 85, 33, 12, 125};
    private static final byte[] aLogtable = {0, 3, 5, 15, 17, 51, 85, -1, 26, 46, 114, -106, Filter.FILTER_TYPE_OR, -8, 19, 53, 95, -31, 56, 72, -40, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, -107, Filter.FILTER_TYPE_SUBSTRING, -9, 2, 6, 10, 30, 34, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, ASN1Constants.UNIVERSAL_SET_TYPE, 83, -11, 4, 12, 20, 60, 68, -52, 79, -47, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, -72, -45, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, -78, -51, 76, -44, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, -32, 59, 77, -41, 98, Filter.FILTER_TYPE_LESS_OR_EQUAL, -15, 8, 24, 40, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, -120, -125, -98, -71, -48, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, -67, -36, Byte.MAX_VALUE, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, Tnaf.POW_2_WIDTH, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, -16, 11, 29, 39, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, -69, -42, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, -93, -2, 25, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, -96, -5, 22, 58, 78, -46, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, -73, -62, 93, -25, 50, 86, -6, 21, 63, 65, -61, 94, -30, 61, 71, -55, 64, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, -84, -17, 42, 126, MatchingRule.SUBSTRING_TYPE_SUBFINAL, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, Byte.MIN_VALUE, -101, -74, -63, 88, -24, 35, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, -81, -22, 37, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, -79, -56, 67, -59, 84, -4, 31, 33, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, Filter.FILTER_TYPE_GREATER_OR_EQUAL, -12, 7, 9, 27, 45, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, -103, -80, -53, 70, -54, 69, -49, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, -34, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, -122, -111, Filter.FILTER_TYPE_APPROXIMATE_MATCH, -29, 62, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, -58, 81, -13, 14, 18, 54, 90, -18, 41, 123, -115, -116, -113, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, -123, -108, -89, -14, 13, 23, 57, 75, -35, 124, -124, -105, Filter.FILTER_TYPE_NOT, -3, 28, 36, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, -76, -57, 82, -10, 1, 3, 5, 15, 17, 51, 85, -1, 26, 46, 114, -106, Filter.FILTER_TYPE_OR, -8, 19, 53, 95, -31, 56, 72, -40, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, -107, Filter.FILTER_TYPE_SUBSTRING, -9, 2, 6, 10, 30, 34, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, -86, -27, 52, 92, -28, 55, 89, -21, 38, 106, -66, -39, 112, -112, -85, -26, ASN1Constants.UNIVERSAL_SET_TYPE, 83, -11, 4, 12, 20, 60, 68, -52, 79, -47, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, -72, -45, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, -78, -51, 76, -44, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, -32, 59, 77, -41, 98, Filter.FILTER_TYPE_LESS_OR_EQUAL, -15, 8, 24, 40, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, -120, -125, -98, -71, -48, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, -67, -36, Byte.MAX_VALUE, -127, -104, -77, -50, 73, -37, 118, -102, -75, -60, 87, -7, Tnaf.POW_2_WIDTH, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, -16, 11, 29, 39, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, -69, -42, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, -93, -2, 25, 43, 125, -121, -110, -83, -20, 47, 113, -109, -82, -23, 32, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, -96, -5, 22, 58, 78, -46, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, -73, -62, 93, -25, 50, 86, -6, 21, 63, 65, -61, 94, -30, 61, 71, -55, 64, -64, 91, -19, 44, 116, -100, -65, -38, 117, -97, -70, -43, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, -84, -17, 42, 126, MatchingRule.SUBSTRING_TYPE_SUBFINAL, -99, PSSSigner.TRAILER_IMPLICIT, -33, 122, -114, -119, Byte.MIN_VALUE, -101, -74, -63, 88, -24, 35, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, -81, -22, 37, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, -79, -56, 67, -59, 84, -4, 31, 33, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, Filter.FILTER_TYPE_GREATER_OR_EQUAL, -12, 7, 9, 27, 45, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, -103, -80, -53, 70, -54, 69, -49, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, -34, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, -122, -111, Filter.FILTER_TYPE_APPROXIMATE_MATCH, -29, 62, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, -58, 81, -13, 14, 18, 54, 90, -18, 41, 123, -115, -116, -113, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, -123, -108, -89, -14, 13, 23, 57, 75, -35, 124, -124, -105, Filter.FILTER_TYPE_NOT, -3, 28, 36, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, -76, -57, 82, -10, 1};
    private static final byte[] logtable = {0, 0, 25, 1, 50, 2, 26, -58, 75, -57, 27, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, 51, -18, -33, 3, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, 4, -32, 14, 52, -115, -127, -17, 76, 113, 8, -56, -8, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, 28, -63, 125, -62, 29, -75, -7, -71, 39, 106, 77, -28, Filter.FILTER_TYPE_LESS_OR_EQUAL, 114, -102, -55, 9, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, 47, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, 5, 33, 15, -31, 36, 18, -16, MatchingRule.SUBSTRING_TYPE_SUBFINAL, 69, 53, -109, -38, -114, -106, -113, -37, -67, 54, -48, -50, -108, 19, 92, -46, -15, 64, 70, -125, 56, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, -35, -3, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, -65, 6, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, 98, -77, 37, -30, -104, 34, -120, -111, Tnaf.POW_2_WIDTH, 126, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, 72, -61, -93, -74, 30, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, 58, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, 40, 84, -6, -123, 61, -70, 43, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, 10, 21, -101, -97, 94, -54, 78, -44, -84, -27, -13, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, -89, 87, -81, 88, Filter.FILTER_TYPE_APPROXIMATE_MATCH, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, -12, -22, -42, 116, 79, -82, -23, -43, -25, -26, -83, -24, 44, -41, 117, 122, -21, 22, 11, -11, 89, -53, 95, -80, -100, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, 81, -96, Byte.MAX_VALUE, 12, -10, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, 23, -60, 73, -20, -40, 67, 31, 45, Filter.FILTER_TYPE_SUBSTRING, 118, 123, -73, -52, -69, 62, 90, -5, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, -79, -122, 59, 82, Filter.FILTER_TYPE_OR, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, -86, 85, 41, -99, -105, -78, -121, -112, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, -66, -36, -4, PSSSigner.TRAILER_IMPLICIT, -107, -49, -51, 55, 63, 91, -47, 83, 57, -124, 60, 65, Filter.FILTER_TYPE_NOT, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, 71, 20, 42, -98, 93, 86, -14, -45, -85, 68, 17, -110, -39, 35, 32, 46, -119, -76, 124, -72, 38, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, -103, -29, Filter.FILTER_TYPE_GREATER_OR_EQUAL, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, -19, -34, -59, ASN1Constants.UNIVERSAL_SET_TYPE, -2, 24, 13, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, -116, Byte.MIN_VALUE, -64, -9, 112, 7};
    private static final int[] rcon = {1, 2, 4, 8, 16, 32, 64, 128, 27, 54, 108, 216, CipherSuite.TLS_DHE_PSK_WITH_AES_256_GCM_SHA384, 77, CipherSuite.TLS_DHE_RSA_WITH_SEED_CBC_SHA, 47, 94, 188, 99, 198, CipherSuite.TLS_DH_DSS_WITH_SEED_CBC_SHA, 53, 106, 212, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA384, ParseException.INVALID_EMAIL_ADDRESS, ParseException.LINKED_ID_MISSING, 239, CipherSuite.TLS_DH_anon_WITH_CAMELLIA_256_CBC_SHA256, CipherSuite.TLS_DHE_PSK_WITH_AES_256_CBC_SHA};
    static byte[][] shifts0 = {new byte[]{0, 8, Tnaf.POW_2_WIDTH, 24}, new byte[]{0, 8, Tnaf.POW_2_WIDTH, 24}, new byte[]{0, 8, Tnaf.POW_2_WIDTH, 24}, new byte[]{0, 8, Tnaf.POW_2_WIDTH, 32}, new byte[]{0, 8, 24, 32}};
    static byte[][] shifts1 = {new byte[]{0, 24, Tnaf.POW_2_WIDTH, 8}, new byte[]{0, 32, 24, Tnaf.POW_2_WIDTH}, new byte[]{0, 40, 32, 24}, new byte[]{0, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 40, 24}, new byte[]{0, 56, 40, 32}};

    /* renamed from: A0 */
    private long f7710A0;

    /* renamed from: A1 */
    private long f7711A1;

    /* renamed from: A2 */
    private long f7712A2;

    /* renamed from: A3 */
    private long f7713A3;

    /* renamed from: BC */
    private int f7714BC;
    private long BC_MASK;
    private int ROUNDS;
    private int blockBits;
    private boolean forEncryption;
    private byte[] shifts0SC;
    private byte[] shifts1SC;
    private long[][] workingKey;

    public RijndaelEngine() {
        this(128);
    }

    public RijndaelEngine(int i) {
        byte[] bArr;
        if (i == 128) {
            this.f7714BC = 32;
            this.BC_MASK = BodyPartID.bodyIdMax;
            this.shifts0SC = shifts0[0];
            bArr = shifts1[0];
        } else if (i == 160) {
            this.f7714BC = 40;
            this.BC_MASK = 1099511627775L;
            this.shifts0SC = shifts0[1];
            bArr = shifts1[1];
        } else if (i == 192) {
            this.f7714BC = 48;
            this.BC_MASK = 281474976710655L;
            this.shifts0SC = shifts0[2];
            bArr = shifts1[2];
        } else if (i == 224) {
            this.f7714BC = 56;
            this.BC_MASK = 72057594037927935L;
            this.shifts0SC = shifts0[3];
            bArr = shifts1[3];
        } else if (i == 256) {
            this.f7714BC = 64;
            this.BC_MASK = -1;
            this.shifts0SC = shifts0[4];
            bArr = shifts1[4];
        } else {
            throw new IllegalArgumentException("unknown blocksize to Rijndael");
        }
        this.shifts1SC = bArr;
        this.blockBits = i;
    }

    private void InvMixColumn() {
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        for (int i = 0; i < this.f7714BC; i += 8) {
            int i2 = (int) ((this.f7710A0 >> i) & 255);
            int i3 = (int) ((this.f7711A1 >> i) & 255);
            int i4 = (int) ((this.f7712A2 >> i) & 255);
            long j5 = j4;
            int i5 = (int) ((this.f7713A3 >> i) & 255);
            byte b = -1;
            byte b2 = i2 != 0 ? logtable[i2 & 255] & 255 : -1;
            byte b3 = i3 != 0 ? logtable[i3 & 255] & 255 : -1;
            byte b4 = i4 != 0 ? logtable[i4 & 255] & 255 : -1;
            if (i5 != 0) {
                b = logtable[i5 & 255] & 255;
            }
            j |= ((long) ((((mul0xe(b2) ^ mul0xb(b3)) ^ mul0xd(b4)) ^ mul0x9(b)) & 255)) << i;
            j2 |= ((long) ((((mul0xe(b3) ^ mul0xb(b4)) ^ mul0xd(b)) ^ mul0x9(b2)) & 255)) << i;
            j3 |= ((long) ((((mul0xe(b4) ^ mul0xb(b)) ^ mul0xd(b2)) ^ mul0x9(b3)) & 255)) << i;
            j4 = j5 | (((long) ((((mul0xe(b) ^ mul0xb(b2)) ^ mul0xd(b3)) ^ mul0x9(b4)) & 255)) << i);
        }
        this.f7710A0 = j;
        this.f7711A1 = j2;
        this.f7712A2 = j3;
        this.f7713A3 = j4;
    }

    private void KeyAddition(long[] jArr) {
        this.f7710A0 ^= jArr[0];
        this.f7711A1 ^= jArr[1];
        this.f7712A2 ^= jArr[2];
        this.f7713A3 ^= jArr[3];
    }

    private void MixColumn() {
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        for (int i = 0; i < this.f7714BC; i += 8) {
            int i2 = (int) ((this.f7710A0 >> i) & 255);
            int i3 = (int) ((this.f7711A1 >> i) & 255);
            int i4 = (int) ((this.f7712A2 >> i) & 255);
            int i5 = (int) ((this.f7713A3 >> i) & 255);
            j |= ((long) ((((mul0x2(i2) ^ mul0x3(i3)) ^ i4) ^ i5) & 255)) << i;
            j2 |= ((long) ((((mul0x2(i3) ^ mul0x3(i4)) ^ i5) ^ i2) & 255)) << i;
            j3 |= ((long) ((((mul0x2(i4) ^ mul0x3(i5)) ^ i2) ^ i3) & 255)) << i;
            j4 |= ((long) ((((mul0x2(i5) ^ mul0x3(i2)) ^ i3) ^ i4) & 255)) << i;
        }
        this.f7710A0 = j;
        this.f7711A1 = j2;
        this.f7712A2 = j3;
        this.f7713A3 = j4;
    }

    private void ShiftRow(byte[] bArr) {
        this.f7711A1 = shift(this.f7711A1, bArr[1]);
        this.f7712A2 = shift(this.f7712A2, bArr[2]);
        this.f7713A3 = shift(this.f7713A3, bArr[3]);
    }

    private void Substitution(byte[] bArr) {
        this.f7710A0 = applyS(this.f7710A0, bArr);
        this.f7711A1 = applyS(this.f7711A1, bArr);
        this.f7712A2 = applyS(this.f7712A2, bArr);
        this.f7713A3 = applyS(this.f7713A3, bArr);
    }

    private long applyS(long j, byte[] bArr) {
        long j2 = 0;
        for (int i = 0; i < this.f7714BC; i += 8) {
            j2 |= ((long) (bArr[(int) ((j >> i) & 255)] & 255)) << i;
        }
        return j2;
    }

    private void decryptBlock(long[][] jArr) {
        KeyAddition(jArr[this.ROUNDS]);
        Substitution(f7709Si);
        ShiftRow(this.shifts1SC);
        for (int i = this.ROUNDS - 1; i > 0; i--) {
            KeyAddition(jArr[i]);
            InvMixColumn();
            Substitution(f7709Si);
            ShiftRow(this.shifts1SC);
        }
        KeyAddition(jArr[0]);
    }

    private void encryptBlock(long[][] jArr) {
        KeyAddition(jArr[0]);
        for (int i = 1; i < this.ROUNDS; i++) {
            Substitution(f7708S);
            ShiftRow(this.shifts0SC);
            MixColumn();
            KeyAddition(jArr[i]);
        }
        Substitution(f7708S);
        ShiftRow(this.shifts0SC);
        KeyAddition(jArr[this.ROUNDS]);
    }

    private long[][] generateWorkingKey(byte[] bArr) {
        int i;
        int i2;
        int i3;
        byte[] bArr2 = bArr;
        int length = bArr2.length * 8;
        int i4 = 4;
        byte[][] bArr3 = (byte[][]) Array.newInstance(byte.class, new int[]{4, 64});
        long[][] jArr = (long[][]) Array.newInstance(long.class, new int[]{15, 4});
        if (length == 128) {
            i = 4;
        } else if (length == 160) {
            i = 5;
        } else if (length == 192) {
            i = 6;
        } else if (length == 224) {
            i = 7;
        } else if (length == 256) {
            i = 8;
        } else {
            throw new IllegalArgumentException("Key length not 128/160/192/224/256 bits.");
        }
        this.ROUNDS = length >= this.blockBits ? i + 6 : (this.f7714BC / 8) + 6;
        char c = 0;
        int i5 = 0;
        int i6 = 0;
        while (i5 < bArr2.length) {
            bArr3[i5 % 4][i5 / 4] = bArr2[i6];
            i5++;
            i6++;
        }
        int i7 = 0;
        int i8 = 0;
        while (true) {
            i2 = 1;
            if (i7 >= i || i8 >= (this.ROUNDS + 1) * (this.f7714BC / 8)) {
                byte[][] bArr4 = bArr3;
                int i9 = 0;
            } else {
                int i10 = 0;
                while (i10 < i4) {
                    int i11 = this.f7714BC;
                    long[] jArr2 = jArr[i8 / (i11 / 8)];
                    jArr2[i10] = (((long) (bArr3[i10][i7] & 255)) << ((i8 * 8) % i11)) | jArr2[i10];
                    i10++;
                    bArr3 = bArr3;
                    i4 = 4;
                }
                byte[][] bArr5 = bArr3;
                i7++;
                i8++;
                i4 = 4;
            }
        }
        byte[][] bArr42 = bArr3;
        int i92 = 0;
        while (i8 < (this.ROUNDS + i2) * (this.f7714BC / 8)) {
            int i12 = 0;
            while (i12 < 4) {
                byte[] bArr6 = bArr42[i12];
                i12++;
                bArr6[c] = (byte) (bArr6[c] ^ f7708S[bArr42[i12 % 4][i - 1] & 255]);
            }
            byte[] bArr7 = bArr42[c];
            int i13 = i92 + 1;
            bArr7[c] = (byte) (rcon[i92] ^ bArr7[c]);
            if (i <= 6) {
                for (int i14 = 1; i14 < i; i14++) {
                    for (int i15 = 0; i15 < 4; i15++) {
                        byte[] bArr8 = bArr42[i15];
                        bArr8[i14] = (byte) (bArr8[i14] ^ bArr42[i15][i14 - 1]);
                    }
                }
            } else {
                int i16 = 1;
                while (true) {
                    i3 = 4;
                    if (i16 >= 4) {
                        break;
                    }
                    int i17 = 0;
                    while (i17 < i3) {
                        byte[] bArr9 = bArr42[i17];
                        bArr9[i16] = (byte) (bArr9[i16] ^ bArr42[i17][i16 - 1]);
                        i17++;
                        i3 = 4;
                    }
                    i16++;
                }
                for (int i18 = 0; i18 < 4; i18++) {
                    byte[] bArr10 = bArr42[i18];
                    bArr10[4] = (byte) (bArr10[4] ^ f7708S[bArr42[i18][3] & 255]);
                }
                int i19 = 5;
                while (i19 < i) {
                    int i20 = 0;
                    while (i20 < i3) {
                        byte[] bArr11 = bArr42[i20];
                        bArr11[i19] = (byte) (bArr11[i19] ^ bArr42[i20][i19 - 1]);
                        i20++;
                        i3 = 4;
                    }
                    i19++;
                    i3 = 4;
                }
            }
            int i21 = 0;
            while (i21 < i && i8 < (this.ROUNDS + i2) * (this.f7714BC / 8)) {
                int i22 = 0;
                while (i22 < 4) {
                    int i23 = this.f7714BC;
                    long[] jArr3 = jArr[i8 / (i23 / 8)];
                    jArr3[i22] = (((long) (bArr42[i22][i21] & 255)) << ((i8 * 8) % i23)) | jArr3[i22];
                    i22++;
                    i13 = i13;
                }
                int i24 = i13;
                i21++;
                i8++;
                i2 = 1;
            }
            i92 = i13;
            c = 0;
            i2 = 1;
        }
        return jArr;
    }

    private byte mul0x2(int i) {
        if (i != 0) {
            return aLogtable[(logtable[i] & 255) + 25];
        }
        return 0;
    }

    private byte mul0x3(int i) {
        if (i != 0) {
            return aLogtable[(logtable[i] & 255) + 1];
        }
        return 0;
    }

    private byte mul0x9(int i) {
        if (i >= 0) {
            return aLogtable[i + 199];
        }
        return 0;
    }

    private byte mul0xb(int i) {
        if (i >= 0) {
            return aLogtable[i + 104];
        }
        return 0;
    }

    private byte mul0xd(int i) {
        if (i >= 0) {
            return aLogtable[i + 238];
        }
        return 0;
    }

    private byte mul0xe(int i) {
        if (i >= 0) {
            return aLogtable[i + 223];
        }
        return 0;
    }

    private void packBlock(byte[] bArr, int i) {
        for (int i2 = 0; i2 != this.f7714BC; i2 += 8) {
            int i3 = i + 1;
            bArr[i] = (byte) ((int) (this.f7710A0 >> i2));
            int i4 = i3 + 1;
            bArr[i3] = (byte) ((int) (this.f7711A1 >> i2));
            int i5 = i4 + 1;
            bArr[i4] = (byte) ((int) (this.f7712A2 >> i2));
            i = i5 + 1;
            bArr[i5] = (byte) ((int) (this.f7713A3 >> i2));
        }
    }

    private long shift(long j, int i) {
        return ((j << (this.f7714BC - i)) | (j >>> i)) & this.BC_MASK;
    }

    private void unpackBlock(byte[] bArr, int i) {
        int i2 = i + 1;
        this.f7710A0 = (long) (bArr[i] & 255);
        int i3 = i2 + 1;
        this.f7711A1 = (long) (bArr[i2] & 255);
        int i4 = i3 + 1;
        this.f7712A2 = (long) (bArr[i3] & 255);
        int i5 = i4 + 1;
        this.f7713A3 = (long) (bArr[i4] & 255);
        for (int i6 = 8; i6 != this.f7714BC; i6 += 8) {
            int i7 = i5 + 1;
            this.f7710A0 |= ((long) (bArr[i5] & 255)) << i6;
            int i8 = i7 + 1;
            this.f7711A1 |= ((long) (bArr[i7] & 255)) << i6;
            int i9 = i8 + 1;
            this.f7712A2 |= ((long) (bArr[i8] & 255)) << i6;
            i5 = i9 + 1;
            this.f7713A3 |= ((long) (bArr[i9] & 255)) << i6;
        }
    }

    public String getAlgorithmName() {
        return "Rijndael";
    }

    public int getBlockSize() {
        return this.f7714BC / 2;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.workingKey = generateWorkingKey(((KeyParameter) cipherParameters).getKey());
            this.forEncryption = z;
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to Rijndael init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.workingKey != null) {
            int i3 = this.f7714BC;
            if ((i3 / 2) + i > bArr.length) {
                throw new DataLengthException("input buffer too short");
            } else if ((i3 / 2) + i2 <= bArr2.length) {
                if (this.forEncryption) {
                    unpackBlock(bArr, i);
                    encryptBlock(this.workingKey);
                } else {
                    unpackBlock(bArr, i);
                    decryptBlock(this.workingKey);
                }
                packBlock(bArr2, i2);
                return this.f7714BC / 2;
            } else {
                throw new OutputLengthException("output buffer too short");
            }
        } else {
            throw new IllegalStateException("Rijndael engine not initialised");
        }
    }

    public void reset() {
    }
}
