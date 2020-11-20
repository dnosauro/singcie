package org.spongycastle.math.p186ec.tools;

import java.io.PrintStream;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.TreeSet;
import org.spongycastle.asn1.p176x9.ECNamedCurveTable;
import org.spongycastle.asn1.p176x9.X9ECParameters;
import org.spongycastle.crypto.p180ec.CustomNamedCurves;
import org.spongycastle.math.p186ec.ECAlgorithms;
import org.spongycastle.math.p186ec.ECFieldElement;

/* renamed from: org.spongycastle.math.ec.tools.F2mSqrtOptimizer */
public class F2mSqrtOptimizer {
    private static ArrayList enumToList(Enumeration enumeration) {
        ArrayList arrayList = new ArrayList();
        while (enumeration.hasMoreElements()) {
            arrayList.add(enumeration.nextElement());
        }
        return arrayList;
    }

    private static void implPrintRootZ(X9ECParameters x9ECParameters) {
        ECFieldElement fromBigInteger = x9ECParameters.getCurve().fromBigInteger(BigInteger.valueOf(2));
        ECFieldElement sqrt = fromBigInteger.sqrt();
        System.out.println(sqrt.toBigInteger().toString(16).toUpperCase());
        if (!sqrt.square().equals(fromBigInteger)) {
            throw new IllegalStateException("Optimized-sqrt sanity check failed");
        }
    }

    public static void main(String[] strArr) {
        TreeSet<String> treeSet = new TreeSet<>(enumToList(ECNamedCurveTable.getNames()));
        treeSet.addAll(enumToList(CustomNamedCurves.getNames()));
        for (String str : treeSet) {
            X9ECParameters byName = CustomNamedCurves.getByName(str);
            if (byName == null) {
                byName = ECNamedCurveTable.getByName(str);
            }
            if (byName != null && ECAlgorithms.isF2mCurve(byName.getCurve())) {
                PrintStream printStream = System.out;
                printStream.print(str + ":");
                implPrintRootZ(byName);
            }
        }
    }

    public static void printRootZ(X9ECParameters x9ECParameters) {
        if (ECAlgorithms.isF2mCurve(x9ECParameters.getCurve())) {
            implPrintRootZ(x9ECParameters);
            return;
        }
        throw new IllegalArgumentException("Sqrt optimization only defined over characteristic-2 fields");
    }
}