package org.spongycastle.jcajce.provider.symmetric;

import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.cms.GCMParameters;
import org.spongycastle.jcajce.provider.symmetric.util.ClassUtil;
import org.spongycastle.util.Integers;

class GcmSpecUtil {
    static final Class gcmSpecClass = ClassUtil.loadClass(GcmSpecUtil.class, "javax.crypto.spec.GCMParameterSpec");

    GcmSpecUtil() {
    }

    static GCMParameters extractGcmParameters(AlgorithmParameterSpec algorithmParameterSpec) {
        try {
            return new GCMParameters((byte[]) gcmSpecClass.getDeclaredMethod("getIV", new Class[0]).invoke(algorithmParameterSpec, new Object[0]), ((Integer) gcmSpecClass.getDeclaredMethod("getTLen", new Class[0]).invoke(algorithmParameterSpec, new Object[0])).intValue() / 8);
        } catch (Exception unused) {
            throw new InvalidParameterSpecException("Cannot process GCMParameterSpec");
        }
    }

    static AlgorithmParameterSpec extractGcmSpec(ASN1Primitive aSN1Primitive) {
        try {
            GCMParameters instance = GCMParameters.getInstance(aSN1Primitive);
            return (AlgorithmParameterSpec) gcmSpecClass.getConstructor(new Class[]{Integer.TYPE, byte[].class}).newInstance(new Object[]{Integers.valueOf(instance.getIcvLen() * 8), instance.getNonce()});
        } catch (NoSuchMethodException unused) {
            throw new InvalidParameterSpecException("No constructor found!");
        } catch (Exception e) {
            throw new InvalidParameterSpecException("Construction failed: " + e.getMessage());
        }
    }

    static boolean gcmSpecExists() {
        return gcmSpecClass != null;
    }

    static boolean isGcmSpec(Class cls) {
        return gcmSpecClass == cls;
    }

    static boolean isGcmSpec(AlgorithmParameterSpec algorithmParameterSpec) {
        Class cls = gcmSpecClass;
        return cls != null && cls.isInstance(algorithmParameterSpec);
    }
}
