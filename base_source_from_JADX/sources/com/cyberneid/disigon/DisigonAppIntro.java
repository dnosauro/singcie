package com.cyberneid.disigon;

import android.os.Bundle;
import android.util.Log;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.C0735d;
import com.cyberneid.disigon.p134b.C2078b;
import com.cyberneid.disigoncie.R;
import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroCustomLayoutFragment;
import com.github.appintro.AppIntroFragment;
import com.github.appintro.AppIntroPageTransformerType;
import com.parse.ParseConfig;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.p161d.p163b.C3250h;

public final class DisigonAppIntro extends AppIntro {
    @Nullable

    /* renamed from: a */
    private WebView f6196a;

    /* renamed from: com.cyberneid.disigon.DisigonAppIntro$a */
    public static final class C1966a extends WebViewClient {
        C1966a() {
        }

        public boolean shouldOverrideUrlLoading(@Nullable WebView webView, @Nullable String str) {
            if (webView == null) {
                return true;
            }
            webView.loadUrl(str);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "La firma elettronica avanzata a portata di click", "Con quest'app puoi apporre la firma elettronica avanzata ai tuoi documenti con pochi semplici passaggi, usando la tua carta d'identità elettronica", R.drawable.disigon_cie_new_rounded_logo, getResources().getColor(R.color.certificateBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "La Carta d'Identità Elettronica è un dispositivo di firma elettronica avanzata", "Come riportato nell'articolo 61 del DPCM 22/02/2013, \"L’utilizzo della Carta d’Identità Elettronica sostituisce, nei confronti della pubblica amministrazione, la firma elettronica avanzata ai sensi delle presenti regole tecniche per i servizi e le attività di cui agli articoli 64 e 65 del codice.\"", R.drawable.carta_identita_elettronica, getResources().getColor(R.color.pinManagerBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Supporta i formati previsti\npdf e p7m", "Puoi firmare un documento e inviarlo mediante email, whatsapp, telegram etc.", R.drawable.pdf_p7m_banner, getResources().getColor(R.color.settingsBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Sezioni dell'app", "Firma Elettronica, Certificati, Gestione PIN e Impostazioni", R.drawable.screenshot_main, getResources().getColor(R.color.pinManagerBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Nella sezione \"Firme Elettroniche\" troverai i tuoi file firmati elettronicamente", "I file sono ordinati per data decrescente e possono essere condivisi con un semplice click sui pallini alla destra di ogni riga. Usa il tasto + per selezionare un file da firmare.", R.drawable.screenshot_digitalsignature, getResources().getColor(R.color.certificateBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Nella sezione \"PIN\" è possibile modificare o sbloccare il PIN", "Il PIN della tua CIE è composto da 8 cifre e ti è stato consegnato in due momenti successivi: le prime 4 cifre al momento della richiesta al tuo comune. Le seconde 4 cifre all'atto del ritiro presso il tuo comune.", R.drawable.screenshot_pin, getResources().getColor(R.color.digitalSignatureBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Nella firma di un  file PDF è possibile posizionare il timbro della firma", "La firma di un documento PDF riporta il timbro della firma in forma grafica che è possibile posizionare nella pagina e nella posizione desiderata. Usa le frecce in basso per muoverti tra le pagine del documento", R.drawable.screenshot_signature, getResources().getColor(R.color.certificateBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Puoi usare la tua firma autografa o un timbro personalizzato", "Usa i comandi ai quattro angoli del timbro per personalizzare la tua firma", R.drawable.help_stamp, getResources().getColor(R.color.pinManagerBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Puoi inserire del testo nel documento da firmare", "Ridimensiona a posiziona il testo dove preferisci", R.drawable.ss_text, getResources().getColor(R.color.digitalSignatureBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Puoi scansionare un documento cartaceo con la fotocamera e firmarlo con la CIE", "Scatta una foto al documento cartaceo e importalo nell'app", R.drawable.ss_scan, getResources().getColor(R.color.certificateBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroCustomLayoutFragment.Companion.newInstance(R.layout.intro_video_layout));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "L'app ha bisogno di accedere ai file da firmare o già firmati", "Dai il consenso nella finestra che apparirà di seguito.", R.drawable.folder, getResources().getColor(R.color.pinManagerBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Privacy", "Quest'app non acquisisce alcun dato personale e non conserva i documenti in altro luogo all'infuori del dispositivo mobile dell'utente. Per maggiorni informazioni si visiti la pagina: https://firmoconcie.it/privacy.html", R.drawable.privacy, getResources().getColor(R.color.settingsBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        addSlide(AppIntroFragment.Companion.newInstance$default(AppIntroFragment.Companion, "Esclusioni di Garanzia e Responsabilità", "Quest'app è stata realizzata esclusivamente per l'apposizione della firma elettronica avanzata mediante la CIE e potrebbe essere soggetta ad errori e/o malfunzionamenti, pertanto, Cyberneid SRL non si assume alcuna responsabilità per eventuali perdite di dati o danni derivanti dall'uso dell'app", R.drawable.disclaimer_banner_696x366, getResources().getColor(R.color.pinManagerBackgroundColor), getResources().getColor(R.color.fontColor), getResources().getColor(R.color.fontColor), R.font.proximanova_light, R.font.proximanova_light, 0, 256, (Object) null));
        setTransformer(AppIntroPageTransformerType.Fade.INSTANCE);
        askForPermissions(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 8, true);
    }

    /* access modifiers changed from: protected */
    public void onDonePressed(@Nullable C0735d dVar) {
        super.onDonePressed(dVar);
        C2078b.m8282b("FIRST_OPEN", false);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onSkipPressed(@Nullable C0735d dVar) {
        super.onSkipPressed(dVar);
        finish();
    }

    /* access modifiers changed from: protected */
    public void onSlideChanged(@Nullable C0735d dVar, @Nullable C0735d dVar2) {
        WebSettings settings;
        super.onSlideChanged(dVar, dVar2);
        if (dVar2 instanceof AppIntroCustomLayoutFragment) {
            this.f6196a = (WebView) findViewById(R.id.webView);
            WebView webView = this.f6196a;
            if (!(webView == null || (settings = webView.getSettings()) == null)) {
                settings.setJavaScriptEnabled(true);
            }
            WebView webView2 = this.f6196a;
            if (webView2 != null) {
                webView2.setWebViewClient(new C1966a());
            }
            Object obj = ParseConfig.getCurrentConfig().get("video_android");
            Log.d("AppIntro", "videoId: " + obj);
            WebView webView3 = this.f6196a;
            if (webView3 != null) {
                webView3.loadDataWithBaseURL("https://player.vimeo.com/", "<html><body style=\"background: #8686E7; margin:0;\"><iframe style=\"background: #8686E7; margin:0;\" src=\"https://player.vimeo.com/video/" + obj + "\" width=\"100%\" height=\"100%\" frameborder=\"0\" webkitallowfullscreen mozallowfullscreen allowfullscreen></iframe></body></html>", "text/html", "utf-8", (String) null);
                return;
            }
            return;
        }
        WebView webView4 = this.f6196a;
        if (webView4 != null) {
            if (webView4 != null) {
                webView4.loadUrl("about:blank");
            }
            this.f6196a = null;
        }
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
