package com.cyberneid.disigon;

import android.os.Bundle;
import androidx.fragment.app.C0735d;
import com.cyberneid.disigon.p134b.C2078b;
import com.cyberneid.disigoncie.R;
import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;
import com.github.appintro.AppIntroPageTransformerType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

public final class NewsAppIntro extends AppIntro {
    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Le novità in questa versione", "Questa versione porta numerose novità sulla base delle richieste che abbiamo ricevuto dai numerosi utilizzatori", R.drawable.disigon_cie_new_rounded_logo, getResources().getColor(R.color.certificateBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Puoi usare la tua firma autografa o un timbro personalizzato", "Usa i comandi ai quattro angoli del timbro per personalizzare la tua firma", R.drawable.help_stamp, getResources().getColor(R.color.pinManagerBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Puoi inserire del testo nel documento da firmare", "Ridimensiona a posiziona il testo dove preferisci", R.drawable.ss_text, getResources().getColor(R.color.digitalSignatureBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Puoi scansionare un documento cartaceo con la fotocamera e firmarlo con la CIE", "Scatta una foto al documento cartaceo e importalo nell'app", R.drawable.ss_scan, getResources().getColor(R.color.certificateBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        setTransformer(AppIntroPageTransformerType.Fade.INSTANCE);
    }

    /* access modifiers changed from: protected */
    public void onDonePressed(@Nullable C0735d dVar) {
        super.onDonePressed(dVar);
        C2078b.m8281b("HELP_VERSION", "1.1.5");
        finish();
    }

    /* access modifiers changed from: protected */
    public void onSkipPressed(@Nullable C0735d dVar) {
        super.onSkipPressed(dVar);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onUserDeniedPermission(@NotNull String str) {
        C3250h.m9056b(str, "permissionName");
    }

    /* access modifiers changed from: protected */
    public void onUserDisabledPermission(@NotNull String str) {
        C3250h.m9056b(str, "permissionName");
    }
}
