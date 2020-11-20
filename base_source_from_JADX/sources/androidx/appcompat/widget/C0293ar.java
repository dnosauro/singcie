package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.core.content.C0529a;
import androidx.p032d.p033a.C0697c;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.WeakHashMap;

@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.widget.ar */
class C0293ar extends C0697c implements View.OnClickListener {

    /* renamed from: j */
    private final SearchManager f1054j = ((SearchManager) this.f2424d.getSystemService(FirebaseAnalytics.Event.SEARCH));

    /* renamed from: k */
    private final SearchView f1055k;

    /* renamed from: l */
    private final SearchableInfo f1056l;

    /* renamed from: m */
    private final Context f1057m;

    /* renamed from: n */
    private final WeakHashMap<String, Drawable.ConstantState> f1058n;

    /* renamed from: o */
    private final int f1059o;

    /* renamed from: p */
    private boolean f1060p = false;

    /* renamed from: q */
    private int f1061q = 1;

    /* renamed from: r */
    private ColorStateList f1062r;

    /* renamed from: s */
    private int f1063s = -1;

    /* renamed from: t */
    private int f1064t = -1;

    /* renamed from: u */
    private int f1065u = -1;

    /* renamed from: v */
    private int f1066v = -1;

    /* renamed from: w */
    private int f1067w = -1;

    /* renamed from: x */
    private int f1068x = -1;

    /* renamed from: androidx.appcompat.widget.ar$a */
    private static final class C0294a {

        /* renamed from: a */
        public final TextView f1069a;

        /* renamed from: b */
        public final TextView f1070b;

        /* renamed from: c */
        public final ImageView f1071c;

        /* renamed from: d */
        public final ImageView f1072d;

        /* renamed from: e */
        public final ImageView f1073e;

        public C0294a(View view) {
            this.f1069a = (TextView) view.findViewById(16908308);
            this.f1070b = (TextView) view.findViewById(16908309);
            this.f1071c = (ImageView) view.findViewById(16908295);
            this.f1072d = (ImageView) view.findViewById(16908296);
            this.f1073e = (ImageView) view.findViewById(C0059a.C0065f.edit_query);
        }
    }

    public C0293ar(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), (Cursor) null, true);
        this.f1055k = searchView;
        this.f1056l = searchableInfo;
        this.f1059o = searchView.getSuggestionCommitIconResId();
        this.f1057m = context;
        this.f1058n = weakHashMap;
    }

    /* renamed from: a */
    private Drawable m1041a(ComponentName componentName) {
        String flattenToShortString = componentName.flattenToShortString();
        Drawable.ConstantState constantState = null;
        if (this.f1058n.containsKey(flattenToShortString)) {
            Drawable.ConstantState constantState2 = this.f1058n.get(flattenToShortString);
            if (constantState2 == null) {
                return null;
            }
            return constantState2.newDrawable(this.f1057m.getResources());
        }
        Drawable b = m1048b(componentName);
        if (b != null) {
            constantState = b.getConstantState();
        }
        this.f1058n.put(flattenToShortString, constantState);
        return b;
    }

    /* renamed from: a */
    private Drawable m1042a(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int parseInt = Integer.parseInt(str);
            String str2 = "android.resource://" + this.f1057m.getPackageName() + "/" + parseInt;
            Drawable b = m1050b(str2);
            if (b != null) {
                return b;
            }
            Drawable a = C0529a.m2093a(this.f1057m, parseInt);
            m1047a(str2, a);
            return a;
        } catch (NumberFormatException unused) {
            Drawable b2 = m1050b(str);
            if (b2 != null) {
                return b2;
            }
            Drawable b3 = m1049b(Uri.parse(str));
            m1047a(str, b3);
            return b3;
        } catch (Resources.NotFoundException unused2) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        }
    }

    /* renamed from: a */
    private static String m1043a(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    /* renamed from: a */
    public static String m1044a(Cursor cursor, String str) {
        return m1043a(cursor, cursor.getColumnIndex(str));
    }

    /* renamed from: a */
    private void m1045a(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    /* renamed from: a */
    private void m1046a(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        textView.setVisibility(TextUtils.isEmpty(charSequence) ? 8 : 0);
    }

    /* renamed from: a */
    private void m1047a(String str, Drawable drawable) {
        if (drawable != null) {
            this.f1058n.put(str, drawable.getConstantState());
        }
    }

    /* renamed from: b */
    private Drawable m1048b(ComponentName componentName) {
        String str;
        String nameNotFoundException;
        PackageManager packageManager = this.f2424d.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            str = "SuggestionsAdapter";
            nameNotFoundException = "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString();
            Log.w(str, nameNotFoundException);
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            str = "SuggestionsAdapter";
            nameNotFoundException = e.toString();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        throw new java.io.FileNotFoundException("Resource does not exist: " + r7);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0012 */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m1049b(android.net.Uri r7) {
        /*
            r6 = this;
            r0 = 0
            java.lang.String r1 = r7.getScheme()     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r2 = "android.resource"
            boolean r1 = r2.equals(r1)     // Catch:{ FileNotFoundException -> 0x0089 }
            if (r1 == 0) goto L_0x0029
            android.graphics.drawable.Drawable r7 = r6.mo2333a((android.net.Uri) r7)     // Catch:{ NotFoundException -> 0x0012 }
            return r7
        L_0x0012:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0089 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r3 = "Resource does not exist: "
            r2.append(r3)     // Catch:{ FileNotFoundException -> 0x0089 }
            r2.append(r7)     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x0089 }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0089 }
            throw r1     // Catch:{ FileNotFoundException -> 0x0089 }
        L_0x0029:
            android.content.Context r1 = r6.f1057m     // Catch:{ FileNotFoundException -> 0x0089 }
            android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ FileNotFoundException -> 0x0089 }
            java.io.InputStream r1 = r1.openInputStream(r7)     // Catch:{ FileNotFoundException -> 0x0089 }
            if (r1 == 0) goto L_0x0072
            android.graphics.drawable.Drawable r2 = android.graphics.drawable.Drawable.createFromStream(r1, r0)     // Catch:{ all -> 0x0055 }
            r1.close()     // Catch:{ IOException -> 0x003d }
            goto L_0x0054
        L_0x003d:
            r1 = move-exception
            java.lang.String r3 = "SuggestionsAdapter"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0089 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r5 = "Error closing icon stream for "
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x0089 }
            r4.append(r7)     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0089 }
            android.util.Log.e(r3, r4, r1)     // Catch:{ FileNotFoundException -> 0x0089 }
        L_0x0054:
            return r2
        L_0x0055:
            r2 = move-exception
            r1.close()     // Catch:{ IOException -> 0x005a }
            goto L_0x0071
        L_0x005a:
            r1 = move-exception
            java.lang.String r3 = "SuggestionsAdapter"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0089 }
            r4.<init>()     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r5 = "Error closing icon stream for "
            r4.append(r5)     // Catch:{ FileNotFoundException -> 0x0089 }
            r4.append(r7)     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r4 = r4.toString()     // Catch:{ FileNotFoundException -> 0x0089 }
            android.util.Log.e(r3, r4, r1)     // Catch:{ FileNotFoundException -> 0x0089 }
        L_0x0071:
            throw r2     // Catch:{ FileNotFoundException -> 0x0089 }
        L_0x0072:
            java.io.FileNotFoundException r1 = new java.io.FileNotFoundException     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0089 }
            r2.<init>()     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r3 = "Failed to open "
            r2.append(r3)     // Catch:{ FileNotFoundException -> 0x0089 }
            r2.append(r7)     // Catch:{ FileNotFoundException -> 0x0089 }
            java.lang.String r2 = r2.toString()     // Catch:{ FileNotFoundException -> 0x0089 }
            r1.<init>(r2)     // Catch:{ FileNotFoundException -> 0x0089 }
            throw r1     // Catch:{ FileNotFoundException -> 0x0089 }
        L_0x0089:
            r1 = move-exception
            java.lang.String r2 = "SuggestionsAdapter"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Icon not found: "
            r3.append(r4)
            r3.append(r7)
            java.lang.String r7 = ", "
            r3.append(r7)
            java.lang.String r7 = r1.getMessage()
            r3.append(r7)
            java.lang.String r7 = r3.toString()
            android.util.Log.w(r2, r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0293ar.m1049b(android.net.Uri):android.graphics.drawable.Drawable");
    }

    /* renamed from: b */
    private Drawable m1050b(String str) {
        Drawable.ConstantState constantState = this.f1058n.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* renamed from: b */
    private CharSequence m1051b(CharSequence charSequence) {
        if (this.f1062r == null) {
            TypedValue typedValue = new TypedValue();
            this.f2424d.getTheme().resolveAttribute(C0059a.C0060a.textColorSearchUrl, typedValue, true);
            this.f1062r = this.f2424d.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan((String) null, 0, 0, this.f1062r, (ColorStateList) null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* renamed from: d */
    private void m1052d(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    /* renamed from: e */
    private Drawable m1053e(Cursor cursor) {
        int i = this.f1066v;
        if (i == -1) {
            return null;
        }
        Drawable a = m1042a(cursor.getString(i));
        return a != null ? a : m1055g(cursor);
    }

    /* renamed from: f */
    private Drawable m1054f(Cursor cursor) {
        int i = this.f1067w;
        if (i == -1) {
            return null;
        }
        return m1042a(cursor.getString(i));
    }

    /* renamed from: g */
    private Drawable m1055g(Cursor cursor) {
        Drawable a = m1041a(this.f1056l.getSearchActivity());
        return a != null ? a : this.f2424d.getPackageManager().getDefaultActivityIcon();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Cursor mo2331a(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder fragment = new Uri.Builder().scheme(FirebaseAnalytics.Param.CONTENT).authority(suggestAuthority).query("").fragment("");
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            fragment.appendEncodedPath(suggestPath);
        }
        fragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            fragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            fragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f2424d.getContentResolver().query(fragment.build(), (String[]) null, suggestSelection, strArr2, (String) null);
    }

    /* renamed from: a */
    public Cursor mo2332a(CharSequence charSequence) {
        String charSequence2 = charSequence == null ? "" : charSequence.toString();
        if (this.f1055k.getVisibility() == 0 && this.f1055k.getWindowVisibility() == 0) {
            try {
                Cursor a = mo2331a(this.f1056l, charSequence2, 50);
                if (a != null) {
                    a.getCount();
                    return a;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Drawable mo2333a(Uri uri) {
        int i;
        String authority = uri.getAuthority();
        if (!TextUtils.isEmpty(authority)) {
            try {
                Resources resourcesForApplication = this.f2424d.getPackageManager().getResourcesForApplication(authority);
                List<String> pathSegments = uri.getPathSegments();
                if (pathSegments != null) {
                    int size = pathSegments.size();
                    if (size == 1) {
                        try {
                            i = Integer.parseInt(pathSegments.get(0));
                        } catch (NumberFormatException unused) {
                            throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                        }
                    } else if (size == 2) {
                        i = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
                    } else {
                        throw new FileNotFoundException("More than two path segments: " + uri);
                    }
                    if (i != 0) {
                        return resourcesForApplication.getDrawable(i);
                    }
                    throw new FileNotFoundException("No resource found for: " + uri);
                }
                throw new FileNotFoundException("No path: " + uri);
            } catch (PackageManager.NameNotFoundException unused2) {
                throw new FileNotFoundException("No package found for authority: " + uri);
            }
        } else {
            throw new FileNotFoundException("No authority: " + uri);
        }
    }

    /* renamed from: a */
    public View mo2334a(Context context, Cursor cursor, ViewGroup viewGroup) {
        View a = super.mo2334a(context, cursor, viewGroup);
        a.setTag(new C0294a(a));
        ((ImageView) a.findViewById(C0059a.C0065f.edit_query)).setImageResource(this.f1059o);
        return a;
    }

    /* renamed from: a */
    public void mo2335a(int i) {
        this.f1061q = i;
    }

    /* renamed from: a */
    public void mo2336a(Cursor cursor) {
        if (this.f1060p) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.mo2336a(cursor);
            if (cursor != null) {
                this.f1063s = cursor.getColumnIndex("suggest_text_1");
                this.f1064t = cursor.getColumnIndex("suggest_text_2");
                this.f1065u = cursor.getColumnIndex("suggest_text_2_url");
                this.f1066v = cursor.getColumnIndex("suggest_icon_1");
                this.f1067w = cursor.getColumnIndex("suggest_icon_2");
                this.f1068x = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    /* renamed from: a */
    public void mo2337a(View view, Context context, Cursor cursor) {
        C0294a aVar = (C0294a) view.getTag();
        int i = this.f1068x;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (aVar.f1069a != null) {
            m1046a(aVar.f1069a, (CharSequence) m1043a(cursor, this.f1063s));
        }
        if (aVar.f1070b != null) {
            String a = m1043a(cursor, this.f1065u);
            CharSequence b = a != null ? m1051b((CharSequence) a) : m1043a(cursor, this.f1064t);
            if (TextUtils.isEmpty(b)) {
                if (aVar.f1069a != null) {
                    aVar.f1069a.setSingleLine(false);
                    aVar.f1069a.setMaxLines(2);
                }
            } else if (aVar.f1069a != null) {
                aVar.f1069a.setSingleLine(true);
                aVar.f1069a.setMaxLines(1);
            }
            m1046a(aVar.f1070b, b);
        }
        if (aVar.f1071c != null) {
            m1045a(aVar.f1071c, m1053e(cursor), 4);
        }
        if (aVar.f1072d != null) {
            m1045a(aVar.f1072d, m1054f(cursor), 8);
        }
        int i3 = this.f1061q;
        if (i3 == 2 || (i3 == 1 && (i2 & 1) != 0)) {
            aVar.f1073e.setVisibility(0);
            aVar.f1073e.setTag(aVar.f1069a.getText());
            aVar.f1073e.setOnClickListener(this);
            return;
        }
        aVar.f1073e.setVisibility(8);
    }

    /* renamed from: b */
    public CharSequence mo2338b(Cursor cursor) {
        String a;
        String a2;
        if (cursor == null) {
            return null;
        }
        String a3 = m1044a(cursor, "suggest_intent_query");
        if (a3 != null) {
            return a3;
        }
        if (this.f1056l.shouldRewriteQueryFromData() && (a2 = m1044a(cursor, "suggest_intent_data")) != null) {
            return a2;
        }
        if (!this.f1056l.shouldRewriteQueryFromText() || (a = m1044a(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return a;
    }

    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View b = mo3960b(this.f2424d, this.f2423c, viewGroup);
            if (b != null) {
                ((C0294a) b.getTag()).f1069a.setText(e.toString());
            }
            return b;
        }
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View a = mo2334a(this.f2424d, this.f2423c, viewGroup);
            if (a != null) {
                ((C0294a) a.getTag()).f1069a.setText(e.toString());
            }
            return a;
        }
    }

    public boolean hasStableIds() {
        return false;
    }

    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m1052d(mo3958a());
    }

    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m1052d(mo3958a());
    }

    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1055k.mo1834a((CharSequence) tag);
        }
    }
}
