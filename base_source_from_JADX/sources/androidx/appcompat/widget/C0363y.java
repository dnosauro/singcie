package androidx.appcompat.widget;

import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import androidx.core.p029g.C0588f;

/* renamed from: androidx.appcompat.widget.y */
final class C0363y {

    /* renamed from: a */
    private TextView f1272a;

    /* renamed from: b */
    private TextClassifier f1273b;

    C0363y(TextView textView) {
        this.f1272a = (TextView) C0588f.m2266a(textView);
    }

    /* renamed from: a */
    public TextClassifier mo2682a() {
        TextClassifier textClassifier = this.f1273b;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f1272a.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }

    /* renamed from: a */
    public void mo2683a(TextClassifier textClassifier) {
        this.f1273b = textClassifier;
    }
}
