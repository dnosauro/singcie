package com.google.firebase.messaging;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.p018c.C0400a;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

@SafeParcelable.Class(creator = "RemoteMessageCreator")
@SafeParcelable.Reserved({1})
public final class RemoteMessage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<RemoteMessage> CREATOR = new zzt();
    public static final int PRIORITY_HIGH = 1;
    public static final int PRIORITY_NORMAL = 2;
    public static final int PRIORITY_UNKNOWN = 0;
    @SafeParcelable.Field(mo11699id = 2)
    Bundle zza;
    private Map<String, String> zzb;
    private Notification zzc;

    public static class Builder {
        private final Bundle zza = new Bundle();
        private final Map<String, String> zzb = new C0400a();

        public Builder(String str) {
            if (TextUtils.isEmpty(str)) {
                String valueOf = String.valueOf(str);
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid to: ".concat(valueOf) : new String("Invalid to: "));
            } else {
                this.zza.putString("google.to", str);
            }
        }

        public Builder addData(String str, String str2) {
            this.zzb.put(str, str2);
            return this;
        }

        public RemoteMessage build() {
            Bundle bundle = new Bundle();
            for (Map.Entry next : this.zzb.entrySet()) {
                bundle.putString((String) next.getKey(), (String) next.getValue());
            }
            bundle.putAll(this.zza);
            this.zza.remove("from");
            return new RemoteMessage(bundle);
        }

        public Builder clearData() {
            this.zzb.clear();
            return this;
        }

        public Builder setCollapseKey(String str) {
            this.zza.putString("collapse_key", str);
            return this;
        }

        public Builder setData(Map<String, String> map) {
            this.zzb.clear();
            this.zzb.putAll(map);
            return this;
        }

        public Builder setMessageId(String str) {
            this.zza.putString("google.message_id", str);
            return this;
        }

        public Builder setMessageType(String str) {
            this.zza.putString("message_type", str);
            return this;
        }

        public Builder setTtl(int i) {
            this.zza.putString("google.ttl", String.valueOf(i));
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface MessagePriority {
    }

    public static class Notification {
        private final String zza;
        private final String zzb;
        private final String[] zzc;
        private final String zzd;
        private final String zze;
        private final String[] zzf;
        private final String zzg;
        private final String zzh;
        private final String zzi;
        private final String zzj;
        private final String zzk;
        private final String zzl;
        private final String zzm;
        private final Uri zzn;
        private final String zzo;
        private final Integer zzp;
        private final Integer zzq;
        private final Integer zzr;
        private final int[] zzs;
        private final Long zzt;
        private final boolean zzu;
        private final boolean zzv;
        private final boolean zzw;
        private final boolean zzx;
        private final boolean zzy;
        private final long[] zzz;

        private Notification(zzr zzr2) {
            this.zza = zzr2.zza("gcm.n.title");
            this.zzb = zzr2.zze("gcm.n.title");
            this.zzc = zza(zzr2, "gcm.n.title");
            this.zzd = zzr2.zza("gcm.n.body");
            this.zze = zzr2.zze("gcm.n.body");
            this.zzf = zza(zzr2, "gcm.n.body");
            this.zzg = zzr2.zza("gcm.n.icon");
            this.zzi = zzr2.zzb();
            this.zzj = zzr2.zza("gcm.n.tag");
            this.zzk = zzr2.zza("gcm.n.color");
            this.zzl = zzr2.zza("gcm.n.click_action");
            this.zzm = zzr2.zza("gcm.n.android_channel_id");
            this.zzn = zzr2.zza();
            this.zzh = zzr2.zza("gcm.n.image");
            this.zzo = zzr2.zza("gcm.n.ticker");
            this.zzp = zzr2.zzc("gcm.n.notification_priority");
            this.zzq = zzr2.zzc("gcm.n.visibility");
            this.zzr = zzr2.zzc("gcm.n.notification_count");
            this.zzu = zzr2.zzb("gcm.n.sticky");
            this.zzv = zzr2.zzb("gcm.n.local_only");
            this.zzw = zzr2.zzb("gcm.n.default_sound");
            this.zzx = zzr2.zzb("gcm.n.default_vibrate_timings");
            this.zzy = zzr2.zzb("gcm.n.default_light_settings");
            this.zzt = zzr2.zzd("gcm.n.event_time");
            this.zzs = zzr2.zzd();
            this.zzz = zzr2.zzc();
        }

        private static String[] zza(zzr zzr2, String str) {
            Object[] zzf2 = zzr2.zzf(str);
            if (zzf2 == null) {
                return null;
            }
            String[] strArr = new String[zzf2.length];
            for (int i = 0; i < zzf2.length; i++) {
                strArr[i] = String.valueOf(zzf2[i]);
            }
            return strArr;
        }

        public String getBody() {
            return this.zzd;
        }

        public String[] getBodyLocalizationArgs() {
            return this.zzf;
        }

        public String getBodyLocalizationKey() {
            return this.zze;
        }

        public String getChannelId() {
            return this.zzm;
        }

        public String getClickAction() {
            return this.zzl;
        }

        public String getColor() {
            return this.zzk;
        }

        public boolean getDefaultLightSettings() {
            return this.zzy;
        }

        public boolean getDefaultSound() {
            return this.zzw;
        }

        public boolean getDefaultVibrateSettings() {
            return this.zzx;
        }

        public Long getEventTime() {
            return this.zzt;
        }

        public String getIcon() {
            return this.zzg;
        }

        public Uri getImageUrl() {
            String str = this.zzh;
            if (str != null) {
                return Uri.parse(str);
            }
            return null;
        }

        public int[] getLightSettings() {
            return this.zzs;
        }

        public Uri getLink() {
            return this.zzn;
        }

        public boolean getLocalOnly() {
            return this.zzv;
        }

        public Integer getNotificationCount() {
            return this.zzr;
        }

        public Integer getNotificationPriority() {
            return this.zzp;
        }

        public String getSound() {
            return this.zzi;
        }

        public boolean getSticky() {
            return this.zzu;
        }

        public String getTag() {
            return this.zzj;
        }

        public String getTicker() {
            return this.zzo;
        }

        public String getTitle() {
            return this.zza;
        }

        public String[] getTitleLocalizationArgs() {
            return this.zzc;
        }

        public String getTitleLocalizationKey() {
            return this.zzb;
        }

        public long[] getVibrateTimings() {
            return this.zzz;
        }

        public Integer getVisibility() {
            return this.zzq;
        }
    }

    @SafeParcelable.Constructor
    public RemoteMessage(@SafeParcelable.Param(mo11702id = 2) Bundle bundle) {
        this.zza = bundle;
    }

    private static int zza(String str) {
        if ("high".equals(str)) {
            return 1;
        }
        return "normal".equals(str) ? 2 : 0;
    }

    public final String getCollapseKey() {
        return this.zza.getString("collapse_key");
    }

    public final Map<String, String> getData() {
        if (this.zzb == null) {
            Bundle bundle = this.zza;
            C0400a aVar = new C0400a();
            for (String str : bundle.keySet()) {
                Object obj = bundle.get(str);
                if (obj instanceof String) {
                    String str2 = (String) obj;
                    if (!str.startsWith("google.") && !str.startsWith("gcm.") && !str.equals("from") && !str.equals("message_type") && !str.equals("collapse_key")) {
                        aVar.put(str, str2);
                    }
                }
            }
            this.zzb = aVar;
        }
        return this.zzb;
    }

    public final String getFrom() {
        return this.zza.getString("from");
    }

    public final String getMessageId() {
        String string = this.zza.getString("google.message_id");
        return string == null ? this.zza.getString("message_id") : string;
    }

    public final String getMessageType() {
        return this.zza.getString("message_type");
    }

    public final Notification getNotification() {
        if (this.zzc == null && zzr.zza(this.zza)) {
            this.zzc = new Notification(new zzr(this.zza));
        }
        return this.zzc;
    }

    public final int getOriginalPriority() {
        String string = this.zza.getString("google.original_priority");
        if (string == null) {
            string = this.zza.getString("google.priority");
        }
        return zza(string);
    }

    public final int getPriority() {
        String string = this.zza.getString("google.delivered_priority");
        if (string == null) {
            if ("1".equals(this.zza.getString("google.priority_reduced"))) {
                return 2;
            }
            string = this.zza.getString("google.priority");
        }
        return zza(string);
    }

    public final long getSentTime() {
        Object obj = this.zza.get("google.sent_time");
        if (obj instanceof Long) {
            return ((Long) obj).longValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Long.parseLong((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 19);
            sb.append("Invalid sent time: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
            return 0;
        }
    }

    public final String getTo() {
        return this.zza.getString("google.to");
    }

    public final int getTtl() {
        Object obj = this.zza.get("google.ttl");
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue();
        }
        if (!(obj instanceof String)) {
            return 0;
        }
        try {
            return Integer.parseInt((String) obj);
        } catch (NumberFormatException unused) {
            String valueOf = String.valueOf(obj);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 13);
            sb.append("Invalid TTL: ");
            sb.append(valueOf);
            Log.w("FirebaseMessaging", sb.toString());
            return 0;
        }
    }

    @KeepForSdk
    public final Intent toIntent() {
        Intent intent = new Intent();
        intent.putExtras(this.zza);
        return intent;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, this.zza, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
