package org.spongycastle.crypto.engines;

import com.unboundid.asn1.ASN1Constants;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.protocol.ExtendedResponseProtocolOp;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.sdk.Filter;
import java.lang.reflect.Array;
import org.spongycastle.crypto.BlockCipher;
import org.spongycastle.crypto.CipherParameters;
import org.spongycastle.crypto.DataLengthException;
import org.spongycastle.crypto.OutputLengthException;
import org.spongycastle.crypto.params.KeyParameter;
import org.spongycastle.crypto.signers.PSSSigner;
import org.spongycastle.util.encoders.Hex;

public class ARIAEngine implements BlockCipher {
    protected static final int BLOCK_SIZE = 16;

    /* renamed from: C */
    private static final byte[][] f7663C = {Hex.decode("517cc1b727220a94fe13abe8fa9a6ee0"), Hex.decode("6db14acc9e21c820ff28b1d5ef5de2b0"), Hex.decode("db92371d2126e9700324977504e8c90e")};
    private static final byte[] SB1_sbox = {LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, 124, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, 123, -14, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, -59, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 1, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, 43, -2, -41, -85, 118, -54, MatchingRule.SUBSTRING_TYPE_SUBFINAL, -55, 125, -6, 89, 71, -16, -83, -44, Filter.FILTER_TYPE_NOT, -81, -100, Filter.FILTER_TYPE_SUBSTRING, 114, -64, -73, -3, -109, 38, 54, 63, -9, -52, 52, Filter.FILTER_TYPE_GREATER_OR_EQUAL, -27, -15, 113, -40, ASN1Constants.UNIVERSAL_SET_TYPE, 21, 4, -57, 35, -61, 24, -106, 5, -102, 7, 18, Byte.MIN_VALUE, -30, -21, 39, -78, 117, 9, -125, 44, 26, 27, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, 90, -96, 82, 59, -42, -77, 41, -29, 47, -124, 83, -47, 0, -19, 32, -4, -79, 91, 106, -53, -66, 57, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, 76, 88, -49, -48, -17, -86, -5, 67, 77, 51, -123, 69, -7, 2, Byte.MAX_VALUE, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, 60, -97, Filter.FILTER_TYPE_APPROXIMATE_MATCH, 81, -93, 64, -113, -110, -99, 56, -11, PSSSigner.TRAILER_IMPLICIT, -74, -38, 33, Tnaf.POW_2_WIDTH, -1, -13, -46, -51, 12, 19, -20, 95, -105, 68, 23, -60, -89, 126, 61, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, 93, 25, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, -127, 79, -36, 34, 42, -112, -120, 70, -18, -72, 20, -34, 94, 11, -37, -32, 50, 58, 10, 73, 6, 36, 92, -62, -45, -84, 98, -111, -107, -28, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, -25, -56, 55, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, -115, -43, 78, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, 86, -12, -22, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, 122, -82, 8, -70, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, 37, 46, 28, Filter.FILTER_TYPE_LESS_OR_EQUAL, -76, -58, -24, -35, 116, 31, 75, -67, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, 112, 62, -75, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, 72, 3, -10, 14, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, 53, 87, -71, -122, -63, 29, -98, -31, -8, -104, 17, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, -39, -114, -108, -101, 30, -121, -23, -50, 85, 40, -33, -116, Filter.FILTER_TYPE_OR, -119, 13, -65, -26, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, 65, -103, 45, 15, -80, 84, -69, 22};
    private static final byte[] SB2_sbox = {-30, 78, 84, -4, -108, -62, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, -52, 98, 13, 106, 70, 60, 77, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, -47, 94, -6, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, -53, -76, -105, -66, 43, PSSSigner.TRAILER_IMPLICIT, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, 46, 3, -45, 25, 89, -63, 29, 6, 65, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, 85, -16, -103, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, -22, -100, 24, -82, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, -33, -25, -69, 0, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, -5, -106, 76, -123, -28, 58, 9, 69, -86, 15, -18, Tnaf.POW_2_WIDTH, -21, 45, Byte.MAX_VALUE, -12, 41, -84, -49, -83, -111, -115, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, -56, -107, -7, 47, -50, -51, 8, 122, -120, 56, 92, -125, 42, 40, 71, -37, -72, -57, -109, Filter.FILTER_TYPE_SUBSTRING, 18, 83, -1, -121, 14, ASN1Constants.UNIVERSAL_SET_TYPE, 54, 33, 88, 72, 1, -114, 55, 116, 50, -54, -23, -79, -73, -85, 12, -41, -60, 86, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, 38, 7, -104, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, -39, -74, -71, 17, 64, -20, 32, -116, -67, -96, -55, -124, 4, 73, 35, -15, 79, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, 31, 19, -36, -40, -64, -98, 87, -29, -61, 123, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, 59, 2, -113, 62, -24, 37, -110, -27, 21, -35, -3, 23, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, -65, -44, -102, 126, -59, 57, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, -2, 118, -99, 67, -89, -31, -48, -11, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, -14, 27, 52, 112, 5, -93, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, -43, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, -122, Filter.FILTER_TYPE_APPROXIMATE_MATCH, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, -58, 81, 75, 30, Filter.FILTER_TYPE_LESS_OR_EQUAL, 39, -10, 53, -46, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, 36, 22, MatchingRule.SUBSTRING_TYPE_SUBFINAL, 95, -38, -26, 117, Filter.FILTER_TYPE_NOT, -17, 44, -78, 28, -97, 93, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, Byte.MIN_VALUE, 10, 114, 68, -101, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, -112, 11, 91, 51, 125, 90, 82, -13, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, Filter.FILTER_TYPE_OR, -9, -80, -42, 63, 124, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, -19, 20, -32, Filter.FILTER_TYPE_GREATER_OR_EQUAL, 61, 34, -77, -8, -119, -34, 113, 26, -81, -70, -75, -127};
    private static final byte[] SB3_sbox = {82, 9, 106, -43, ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, 54, Filter.FILTER_TYPE_GREATER_OR_EQUAL, 56, -65, 64, -93, -98, -127, -13, -41, -5, 124, -29, 57, MatchingRule.SUBSTRING_TYPE_SUBFINAL, -101, 47, -1, -121, 52, -114, 67, 68, -60, -34, -23, -53, 84, 123, -108, 50, Filter.FILTER_TYPE_LESS_OR_EQUAL, -62, 35, 61, -18, 76, -107, 11, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, -6, -61, 78, 8, 46, Filter.FILTER_TYPE_OR, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, 40, -39, 36, -78, 118, 91, Filter.FILTER_TYPE_NOT, 73, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, -47, 37, 114, -8, -10, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, -122, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, -104, 22, -44, Filter.FILTER_TYPE_SUBSTRING, 92, -52, 93, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, -74, -110, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, 112, 72, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, -3, -19, -71, -38, 94, 21, 70, 87, -89, -115, -99, -124, -112, -40, -85, 0, -116, PSSSigner.TRAILER_IMPLICIT, -45, 10, -9, -28, 88, 5, -72, -77, 69, 6, -48, 44, 30, -113, -54, 63, 15, 2, -63, -81, -67, 3, 1, 19, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, 58, -111, 17, 65, 79, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, -36, -22, -105, -14, -49, -50, -16, -76, -26, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, -106, -84, 116, 34, -25, -83, 53, -123, -30, -7, 55, -24, 28, 117, -33, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, 71, -15, 26, 113, 29, 41, -59, -119, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, -73, 98, 14, -86, 24, -66, 27, -4, 86, 62, 75, -58, -46, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, 32, -102, -37, -64, -2, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, -51, 90, -12, 31, -35, Filter.FILTER_TYPE_APPROXIMATE_MATCH, 51, -120, 7, -57, ASN1Constants.UNIVERSAL_SET_TYPE, -79, 18, Tnaf.POW_2_WIDTH, 89, 39, Byte.MIN_VALUE, -20, 95, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST, 81, Byte.MAX_VALUE, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, 25, -75, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, 13, 45, -27, 122, -97, -109, -55, -100, -17, -96, -32, 59, 77, -82, 42, -11, -80, -56, -21, -69, 60, -125, 83, -103, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, 23, 43, 4, 126, -70, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, -42, 38, -31, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, 20, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, 85, 33, 12, 125};
    private static final byte[] SB4_sbox = {ASN1Constants.UNIVERSAL_SEQUENCE_TYPE, LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, -103, 27, -121, -71, 33, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, 57, -37, -31, 114, 9, 98, 60, 62, 126, 94, -114, -15, -96, -52, -93, 42, 29, -5, -74, -42, 32, -60, -115, -127, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, -11, -119, -53, -99, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, -58, 87, 67, 86, 23, -44, 64, 26, 77, -64, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, -29, -73, -56, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, 106, 83, -86, 56, -104, 12, -12, -101, -19, Byte.MAX_VALUE, 34, 118, -81, -35, 58, 11, 88, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, -120, 6, -61, 53, 13, 1, ExtendedResponseProtocolOp.TYPE_RESPONSE_VALUE, -116, -62, -26, 95, 2, 36, 117, -109, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, 30, -27, -30, 84, -40, Tnaf.POW_2_WIDTH, -50, 122, -24, 8, 44, 18, -105, 50, -85, -76, 39, 10, 35, -33, -17, -54, -39, -72, -6, -36, ASN1Constants.UNIVERSAL_SET_TYPE, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, -47, -83, 25, 73, -67, 81, -106, -18, -28, Filter.FILTER_TYPE_APPROXIMATE_MATCH, 65, -38, -1, -51, 85, -122, 54, -66, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, 82, -8, -69, 14, MatchingRule.SUBSTRING_TYPE_SUBFINAL, 72, LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, -102, -32, 71, -98, 92, 4, 75, 52, 21, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, 38, -89, -34, 41, -82, -110, -41, -124, -23, -46, -70, 93, -13, -59, -80, -65, Filter.FILTER_TYPE_SUBSTRING, 59, 113, 68, 70, 43, -4, -21, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, -43, -10, 20, -2, 124, 112, 90, 125, -3, 47, 24, -125, 22, Filter.FILTER_TYPE_GREATER_OR_EQUAL, -111, 31, 5, -107, 116, Filter.FILTER_TYPE_EXTENSIBLE_MATCH, -63, 91, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, -123, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, 19, 7, 79, 78, 69, -78, 15, -55, 28, Filter.FILTER_TYPE_LESS_OR_EQUAL, PSSSigner.TRAILER_IMPLICIT, -20, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, -112, 123, -49, 89, -113, Filter.FILTER_TYPE_OR, -7, 45, -14, -79, 0, -108, 55, -97, -48, 46, -100, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, 40, 63, Byte.MIN_VALUE, -16, 61, -45, 37, ExtendedResponseProtocolOp.TYPE_RESPONSE_OID, -75, -25, LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST, -77, -57, -22, -9, 76, 17, 51, 3, Filter.FILTER_TYPE_NOT, -84, LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST};
    private byte[][] roundKeys;

    /* renamed from: A */
    protected static void m9191A(byte[] bArr) {
        byte b = bArr[0];
        byte b2 = bArr[1];
        byte b3 = bArr[2];
        byte b4 = bArr[3];
        byte b5 = bArr[4];
        byte b6 = bArr[5];
        byte b7 = bArr[6];
        byte b8 = bArr[7];
        byte b9 = bArr[8];
        byte b10 = bArr[9];
        byte b11 = bArr[10];
        byte b12 = bArr[11];
        byte b13 = bArr[12];
        byte b14 = bArr[13];
        byte b15 = bArr[14];
        byte b16 = bArr[15];
        bArr[0] = (byte) ((((((b4 ^ b5) ^ b7) ^ b9) ^ b10) ^ b14) ^ b15);
        bArr[1] = (byte) ((((((b3 ^ b6) ^ b8) ^ b9) ^ b10) ^ b13) ^ b16);
        bArr[2] = (byte) ((((((b2 ^ b5) ^ b7) ^ b11) ^ b12) ^ b13) ^ b16);
        bArr[3] = (byte) ((((((b ^ b6) ^ b8) ^ b11) ^ b12) ^ b14) ^ b15);
        byte b17 = b ^ b3;
        bArr[4] = (byte) (((((b17 ^ b6) ^ b9) ^ b12) ^ b15) ^ b16);
        byte b18 = b2 ^ b4;
        bArr[5] = (byte) (((((b18 ^ b5) ^ b10) ^ b11) ^ b15) ^ b16);
        bArr[6] = (byte) (((((b17 ^ b8) ^ b10) ^ b11) ^ b13) ^ b14);
        bArr[7] = (byte) (((((b18 ^ b7) ^ b9) ^ b12) ^ b13) ^ b14);
        byte b19 = b ^ b2;
        bArr[8] = (byte) (((((b19 ^ b5) ^ b8) ^ b11) ^ b14) ^ b16);
        bArr[9] = (byte) (((((b19 ^ b6) ^ b7) ^ b12) ^ b13) ^ b15);
        byte b20 = b3 ^ b4;
        bArr[10] = (byte) (((((b20 ^ b6) ^ b7) ^ b9) ^ b14) ^ b16);
        bArr[11] = (byte) (((((b20 ^ b5) ^ b8) ^ b10) ^ b13) ^ b15);
        byte b21 = b2 ^ b3;
        bArr[12] = (byte) (((((b21 ^ b7) ^ b8) ^ b10) ^ b12) ^ b13);
        byte b22 = b ^ b4;
        bArr[13] = (byte) (((((b22 ^ b7) ^ b8) ^ b9) ^ b11) ^ b14);
        bArr[14] = (byte) (((((b22 ^ b5) ^ b6) ^ b10) ^ b12) ^ b15);
        bArr[15] = (byte) (((((b21 ^ b5) ^ b6) ^ b9) ^ b11) ^ b16);
    }

    /* renamed from: FE */
    protected static void m9192FE(byte[] bArr, byte[] bArr2) {
        xor(bArr, bArr2);
        SL2(bArr);
        m9191A(bArr);
    }

    /* renamed from: FO */
    protected static void m9193FO(byte[] bArr, byte[] bArr2) {
        xor(bArr, bArr2);
        SL1(bArr);
        m9191A(bArr);
    }

    protected static byte SB1(byte b) {
        return SB1_sbox[b & 255];
    }

    protected static byte SB2(byte b) {
        return SB2_sbox[b & 255];
    }

    protected static byte SB3(byte b) {
        return SB3_sbox[b & 255];
    }

    protected static byte SB4(byte b) {
        return SB4_sbox[b & 255];
    }

    protected static void SL1(byte[] bArr) {
        bArr[0] = SB1(bArr[0]);
        bArr[1] = SB2(bArr[1]);
        bArr[2] = SB3(bArr[2]);
        bArr[3] = SB4(bArr[3]);
        bArr[4] = SB1(bArr[4]);
        bArr[5] = SB2(bArr[5]);
        bArr[6] = SB3(bArr[6]);
        bArr[7] = SB4(bArr[7]);
        bArr[8] = SB1(bArr[8]);
        bArr[9] = SB2(bArr[9]);
        bArr[10] = SB3(bArr[10]);
        bArr[11] = SB4(bArr[11]);
        bArr[12] = SB1(bArr[12]);
        bArr[13] = SB2(bArr[13]);
        bArr[14] = SB3(bArr[14]);
        bArr[15] = SB4(bArr[15]);
    }

    protected static void SL2(byte[] bArr) {
        bArr[0] = SB3(bArr[0]);
        bArr[1] = SB4(bArr[1]);
        bArr[2] = SB1(bArr[2]);
        bArr[3] = SB2(bArr[3]);
        bArr[4] = SB3(bArr[4]);
        bArr[5] = SB4(bArr[5]);
        bArr[6] = SB1(bArr[6]);
        bArr[7] = SB2(bArr[7]);
        bArr[8] = SB3(bArr[8]);
        bArr[9] = SB4(bArr[9]);
        bArr[10] = SB1(bArr[10]);
        bArr[11] = SB2(bArr[11]);
        bArr[12] = SB3(bArr[12]);
        bArr[13] = SB4(bArr[13]);
        bArr[14] = SB1(bArr[14]);
        bArr[15] = SB2(bArr[15]);
    }

    protected static byte[][] keySchedule(boolean z, byte[] bArr) {
        int length = bArr.length;
        if (length < 16 || length > 32 || (length & 7) != 0) {
            throw new IllegalArgumentException("Key length not 128/192/256 bits.");
        }
        int i = (length >>> 3) - 2;
        byte[][] bArr2 = f7663C;
        byte[] bArr3 = bArr2[i];
        byte[] bArr4 = bArr2[(i + 1) % 3];
        byte[] bArr5 = bArr2[(i + 2) % 3];
        byte[] bArr6 = new byte[16];
        byte[] bArr7 = new byte[16];
        System.arraycopy(bArr, 0, bArr6, 0, 16);
        System.arraycopy(bArr, 16, bArr7, 0, length - 16);
        byte[] bArr8 = new byte[16];
        byte[] bArr9 = new byte[16];
        byte[] bArr10 = new byte[16];
        byte[] bArr11 = new byte[16];
        System.arraycopy(bArr6, 0, bArr8, 0, 16);
        System.arraycopy(bArr8, 0, bArr9, 0, 16);
        m9193FO(bArr9, bArr3);
        xor(bArr9, bArr7);
        System.arraycopy(bArr9, 0, bArr10, 0, 16);
        m9192FE(bArr10, bArr4);
        xor(bArr10, bArr8);
        System.arraycopy(bArr10, 0, bArr11, 0, 16);
        m9193FO(bArr11, bArr5);
        xor(bArr11, bArr9);
        int i2 = (i * 2) + 12;
        byte[][] bArr12 = (byte[][]) Array.newInstance(byte.class, new int[]{i2 + 1, 16});
        keyScheduleRound(bArr12[0], bArr8, bArr9, 19);
        keyScheduleRound(bArr12[1], bArr9, bArr10, 19);
        keyScheduleRound(bArr12[2], bArr10, bArr11, 19);
        keyScheduleRound(bArr12[3], bArr11, bArr8, 19);
        keyScheduleRound(bArr12[4], bArr8, bArr9, 31);
        keyScheduleRound(bArr12[5], bArr9, bArr10, 31);
        keyScheduleRound(bArr12[6], bArr10, bArr11, 31);
        keyScheduleRound(bArr12[7], bArr11, bArr8, 31);
        keyScheduleRound(bArr12[8], bArr8, bArr9, 67);
        keyScheduleRound(bArr12[9], bArr9, bArr10, 67);
        keyScheduleRound(bArr12[10], bArr10, bArr11, 67);
        keyScheduleRound(bArr12[11], bArr11, bArr8, 67);
        keyScheduleRound(bArr12[12], bArr8, bArr9, 97);
        if (i2 > 12) {
            keyScheduleRound(bArr12[13], bArr9, bArr10, 97);
            keyScheduleRound(bArr12[14], bArr10, bArr11, 97);
            if (i2 > 14) {
                keyScheduleRound(bArr12[15], bArr11, bArr8, 97);
                keyScheduleRound(bArr12[16], bArr8, bArr9, 109);
            }
        }
        if (!z) {
            reverseKeys(bArr12);
            for (int i3 = 1; i3 < i2; i3++) {
                m9191A(bArr12[i3]);
            }
        }
        return bArr12;
    }

    protected static void keyScheduleRound(byte[] bArr, byte[] bArr2, byte[] bArr3, int i) {
        int i2 = i >>> 3;
        byte b = i & 7;
        int i3 = 8 - b;
        byte b2 = bArr3[15 - i2] & 255;
        int i4 = 0;
        while (i4 < 16) {
            byte b3 = bArr3[(i4 - i2) & 15] & 255;
            bArr[i4] = (byte) (((b2 << i3) | (b3 >>> b)) ^ (bArr2[i4] & 255));
            i4++;
            b2 = b3;
        }
    }

    protected static void reverseKeys(byte[][] bArr) {
        int length = bArr.length;
        int i = length / 2;
        int i2 = length - 1;
        for (int i3 = 0; i3 < i; i3++) {
            byte[] bArr2 = bArr[i3];
            int i4 = i2 - i3;
            bArr[i3] = bArr[i4];
            bArr[i4] = bArr2;
        }
    }

    protected static void xor(byte[] bArr, byte[] bArr2) {
        for (int i = 0; i < 16; i++) {
            bArr[i] = (byte) (bArr[i] ^ bArr2[i]);
        }
    }

    public String getAlgorithmName() {
        return "ARIA";
    }

    public int getBlockSize() {
        return 16;
    }

    public void init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.roundKeys = keySchedule(z, ((KeyParameter) cipherParameters).getKey());
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to ARIA init - " + cipherParameters.getClass().getName());
    }

    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.roundKeys == null) {
            throw new IllegalStateException("ARIA engine not initialised");
        } else if (i > bArr.length - 16) {
            throw new DataLengthException("input buffer too short");
        } else if (i2 <= bArr2.length - 16) {
            byte[] bArr3 = new byte[16];
            System.arraycopy(bArr, i, bArr3, 0, 16);
            int length = this.roundKeys.length - 3;
            int i3 = 0;
            while (i3 < length) {
                int i4 = i3 + 1;
                m9193FO(bArr3, this.roundKeys[i3]);
                m9192FE(bArr3, this.roundKeys[i4]);
                i3 = i4 + 1;
            }
            int i5 = i3 + 1;
            m9193FO(bArr3, this.roundKeys[i3]);
            xor(bArr3, this.roundKeys[i5]);
            SL2(bArr3);
            xor(bArr3, this.roundKeys[i5 + 1]);
            System.arraycopy(bArr3, 0, bArr2, i2, 16);
            return 16;
        } else {
            throw new OutputLengthException("output buffer too short");
        }
    }

    public void reset() {
    }
}
