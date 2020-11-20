package p066b.p067a.p068a.p069a;

import android.nfc.NfcAdapter;
import android.nfc.Tag;
import android.nfc.TagLostException;
import android.nfc.tech.IsoDep;
import org.jetbrains.annotations.Nullable;
import p066b.p067a.p068a.p070b.C1344a;
import p066b.p067a.p068a.p070b.C1345b;
import p066b.p067a.p068a.p070b.C1347d;
import p066b.p067a.p068a.p070b.C1348e;
import p066b.p067a.p068a.p071c.C1349a;
import p066b.p067a.p068a.p071c.C1351c;
import p066b.p067a.p068a.p071c.C1352d;
import p066b.p067a.p068a.p071c.C1353e;
import p066b.p067a.p068a.p072d.C1366e;
import p066b.p067a.p068a.p075e.C1373a;
import p157d.p161d.p163b.C3250h;
import p157d.p166g.C3276e;

/* renamed from: b.a.a.a.b */
public final class C1343b implements NfcAdapter.ReaderCallback {

    /* renamed from: a */
    public static final C1343b f4129a = new C1343b();

    /* renamed from: b */
    private static C1342a f4130b;
    @Nullable

    /* renamed from: c */
    private static C1366e f4131c;

    /* renamed from: d */
    private static boolean f4132d;

    /* renamed from: e */
    private static String f4133e = "";

    /* renamed from: f */
    private static final C3276e f4134f = new C3276e("^[0-9]{8}$");

    private C1343b() {
    }

    /* renamed from: a */
    public final boolean mo6692a() {
        return f4132d;
    }

    public void onTagDiscovered(@Nullable Tag tag) {
        C1342a aVar;
        C1344a aVar2;
        try {
            C1342a aVar3 = f4130b;
            if (aVar3 != null) {
                aVar3.mo6690a(new C1344a(C1348e.ON_TAG_DISCOVERED, (Integer) null, (String) null, 6, (C3247e) null));
            }
            IsoDep isoDep = IsoDep.get(tag);
            C3250h.m9053a((Object) isoDep, "isoDep");
            isoDep.setTimeout(30000);
            isoDep.connect();
            f4131c = new C1366e(isoDep);
            C1366e eVar = f4131c;
            if (eVar == null) {
                C3250h.m9052a();
            }
            eVar.mo6756b();
            C1366e eVar2 = f4131c;
            if (eVar2 == null) {
                C3250h.m9052a();
            }
            eVar2.mo6753a(f4133e);
            C1366e eVar3 = f4131c;
            if (eVar3 == null) {
                C3250h.m9052a();
            }
            eVar3.mo6758c();
        } catch (Throwable th) {
            C1373a.f4197a.mo6761a(th.toString());
            if (th instanceof C1353e) {
                C1342a aVar4 = f4130b;
                if (aVar4 != null) {
                    aVar4.mo6690a(new C1344a(C1345b.ON_PIN_ERROR, Integer.valueOf(((C1353e) th).mo6697a()), (String) null, 4, (C3247e) null));
                    return;
                }
                return;
            }
            if (th instanceof C1352d) {
                aVar = f4130b;
                if (aVar != null) {
                    aVar2 = new C1344a(C1347d.PIN_INPUT_ERROR, (Integer) null, (String) null, 6, (C3247e) null);
                } else {
                    return;
                }
            } else if (th instanceof C1349a) {
                aVar = f4130b;
                if (aVar != null) {
                    aVar2 = new C1344a(C1345b.ON_CARD_PIN_LOCKED, (Integer) null, (String) null, 6, (C3247e) null);
                } else {
                    return;
                }
            } else if (th instanceof C1351c) {
                aVar = f4130b;
                if (aVar != null) {
                    aVar2 = new C1344a(C1348e.ON_TAG_DISCOVERED_NOT_CIE, (Integer) null, (String) null, 6, (C3247e) null);
                } else {
                    return;
                }
            } else if (th instanceof TagLostException) {
                aVar = f4130b;
                if (aVar != null) {
                    aVar2 = new C1344a(C1348e.ON_TAG_LOST, (Integer) null, (String) null, 6, (C3247e) null);
                } else {
                    return;
                }
            } else {
                C1342a aVar5 = f4130b;
                if (aVar5 != null) {
                    aVar5.mo6691a(th);
                    return;
                }
                return;
            }
            aVar.mo6690a(aVar2);
        }
    }
}
