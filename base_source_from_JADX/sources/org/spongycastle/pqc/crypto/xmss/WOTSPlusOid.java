package org.spongycastle.pqc.crypto.xmss;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

final class WOTSPlusOid implements XMSSOid {
    private static final Map<String, WOTSPlusOid> oidLookupTable;
    private final int oid;
    private final String stringRepresentation;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put(createKey(McElieceCCA2KeyGenParameterSpec.SHA256, 32, 16, 67), new WOTSPlusOid(16777217, "WOTSP_SHA2-256_W16"));
        hashMap.put(createKey(McElieceCCA2KeyGenParameterSpec.SHA512, 64, 16, 131), new WOTSPlusOid(33554434, "WOTSP_SHA2-512_W16"));
        hashMap.put(createKey("SHAKE128", 32, 16, 67), new WOTSPlusOid(50331651, "WOTSP_SHAKE128_W16"));
        hashMap.put(createKey("SHAKE256", 64, 16, 131), new WOTSPlusOid(67108868, "WOTSP_SHAKE256_W16"));
        oidLookupTable = Collections.unmodifiableMap(hashMap);
    }

    private WOTSPlusOid(int i, String str) {
        this.oid = i;
        this.stringRepresentation = str;
    }

    private static String createKey(String str, int i, int i2, int i3) {
        if (str != null) {
            return str + "-" + i + "-" + i2 + "-" + i3;
        }
        throw new NullPointerException("algorithmName == null");
    }

    protected static WOTSPlusOid lookup(String str, int i, int i2, int i3) {
        if (str != null) {
            return oidLookupTable.get(createKey(str, i, i2, i3));
        }
        throw new NullPointerException("algorithmName == null");
    }

    public int getOid() {
        return this.oid;
    }

    public String toString() {
        return this.stringRepresentation;
    }
}
