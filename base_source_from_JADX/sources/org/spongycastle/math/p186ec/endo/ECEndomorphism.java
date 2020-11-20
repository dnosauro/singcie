package org.spongycastle.math.p186ec.endo;

import org.spongycastle.math.p186ec.ECPointMap;

/* renamed from: org.spongycastle.math.ec.endo.ECEndomorphism */
public interface ECEndomorphism {
    ECPointMap getPointMap();

    boolean hasEfficientPointMap();
}
