package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardItem;

public final class zzawd extends zzavf {
    private final String type;
    private final int zzdxu;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzawd(RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzawd(zzava zzava) {
        this(zzava != null ? zzava.type : "", zzava != null ? zzava.zzdxu : 1);
    }

    public zzawd(String str, int i) {
        this.type = str;
        this.zzdxu = i;
    }

    public final int getAmount() {
        return this.zzdxu;
    }

    public final String getType() {
        return this.type;
    }
}
