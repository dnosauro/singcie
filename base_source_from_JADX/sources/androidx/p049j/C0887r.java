package androidx.p049j;

import android.animation.TimeInterpolator;
import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import androidx.p049j.C0874n;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.p172io.IOUtils;

/* renamed from: androidx.j.r */
public class C0887r extends C0874n {

    /* renamed from: a */
    int f2906a;

    /* renamed from: b */
    boolean f2907b = false;

    /* renamed from: c */
    private ArrayList<C0874n> f2908c = new ArrayList<>();

    /* renamed from: d */
    private boolean f2909d = true;

    /* renamed from: e */
    private int f2910e = 0;

    /* renamed from: androidx.j.r$a */
    static class C0889a extends C0882o {

        /* renamed from: a */
        C0887r f2913a;

        C0889a(C0887r rVar) {
            this.f2913a = rVar;
        }

        /* renamed from: b */
        public void mo4694b(C0874n nVar) {
            C0887r rVar = this.f2913a;
            rVar.f2906a--;
            if (this.f2913a.f2906a == 0) {
                C0887r rVar2 = this.f2913a;
                rVar2.f2907b = false;
                rVar2.end();
            }
            nVar.removeListener(this);
        }

        /* renamed from: e */
        public void mo4698e(C0874n nVar) {
            if (!this.f2913a.f2907b) {
                this.f2913a.start();
                this.f2913a.f2907b = true;
            }
        }
    }

    /* renamed from: b */
    private void m3553b() {
        C0889a aVar = new C0889a(this);
        Iterator<C0874n> it = this.f2908c.iterator();
        while (it.hasNext()) {
            it.next().addListener(aVar);
        }
        this.f2906a = this.f2908c.size();
    }

    /* renamed from: b */
    private void m3554b(C0874n nVar) {
        this.f2908c.add(nVar);
        nVar.mParent = this;
    }

    /* renamed from: a */
    public int mo4813a() {
        return this.f2908c.size();
    }

    /* renamed from: a */
    public C0887r mo4814a(int i) {
        boolean z;
        switch (i) {
            case 0:
                z = true;
                break;
            case 1:
                z = false;
                break;
            default:
                throw new AndroidRuntimeException("Invalid parameter for TransitionSet ordering: " + i);
        }
        this.f2909d = z;
        return this;
    }

    /* renamed from: a */
    public C0887r setDuration(long j) {
        ArrayList<C0874n> arrayList;
        super.setDuration(j);
        if (this.mDuration >= 0 && (arrayList = this.f2908c) != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f2908c.get(i).setDuration(j);
            }
        }
        return this;
    }

    /* renamed from: a */
    public C0887r setInterpolator(TimeInterpolator timeInterpolator) {
        this.f2910e |= 1;
        ArrayList<C0874n> arrayList = this.f2908c;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                this.f2908c.get(i).setInterpolator(timeInterpolator);
            }
        }
        return (C0887r) super.setInterpolator(timeInterpolator);
    }

    /* renamed from: a */
    public C0887r addTarget(View view) {
        for (int i = 0; i < this.f2908c.size(); i++) {
            this.f2908c.get(i).addTarget(view);
        }
        return (C0887r) super.addTarget(view);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0887r setSceneRoot(ViewGroup viewGroup) {
        super.setSceneRoot(viewGroup);
        int size = this.f2908c.size();
        for (int i = 0; i < size; i++) {
            this.f2908c.get(i).setSceneRoot(viewGroup);
        }
        return this;
    }

    /* renamed from: a */
    public C0887r addListener(C0874n.C0881d dVar) {
        return (C0887r) super.addListener(dVar);
    }

    /* renamed from: a */
    public C0887r mo4820a(C0874n nVar) {
        m3554b(nVar);
        if (this.mDuration >= 0) {
            nVar.setDuration(this.mDuration);
        }
        if ((this.f2910e & 1) != 0) {
            nVar.setInterpolator(getInterpolator());
        }
        if ((this.f2910e & 2) != 0) {
            nVar.setPropagation(getPropagation());
        }
        if ((this.f2910e & 4) != 0) {
            nVar.setPathMotion(getPathMotion());
        }
        if ((this.f2910e & 8) != 0) {
            nVar.setEpicenterCallback(getEpicenterCallback());
        }
        return this;
    }

    /* renamed from: a */
    public C0887r addTarget(Class<?> cls) {
        for (int i = 0; i < this.f2908c.size(); i++) {
            this.f2908c.get(i).addTarget(cls);
        }
        return (C0887r) super.addTarget(cls);
    }

    /* renamed from: a */
    public C0887r addTarget(String str) {
        for (int i = 0; i < this.f2908c.size(); i++) {
            this.f2908c.get(i).addTarget(str);
        }
        return (C0887r) super.addTarget(str);
    }

    /* renamed from: b */
    public C0874n mo4823b(int i) {
        if (i < 0 || i >= this.f2908c.size()) {
            return null;
        }
        return this.f2908c.get(i);
    }

    /* renamed from: b */
    public C0887r setStartDelay(long j) {
        return (C0887r) super.setStartDelay(j);
    }

    /* renamed from: b */
    public C0887r removeTarget(View view) {
        for (int i = 0; i < this.f2908c.size(); i++) {
            this.f2908c.get(i).removeTarget(view);
        }
        return (C0887r) super.removeTarget(view);
    }

    /* renamed from: b */
    public C0887r removeListener(C0874n.C0881d dVar) {
        return (C0887r) super.removeListener(dVar);
    }

    /* renamed from: b */
    public C0887r removeTarget(Class<?> cls) {
        for (int i = 0; i < this.f2908c.size(); i++) {
            this.f2908c.get(i).removeTarget(cls);
        }
        return (C0887r) super.removeTarget(cls);
    }

    /* renamed from: b */
    public C0887r removeTarget(String str) {
        for (int i = 0; i < this.f2908c.size(); i++) {
            this.f2908c.get(i).removeTarget(str);
        }
        return (C0887r) super.removeTarget(str);
    }

    /* renamed from: c */
    public C0887r addTarget(int i) {
        for (int i2 = 0; i2 < this.f2908c.size(); i2++) {
            this.f2908c.get(i2).addTarget(i);
        }
        return (C0887r) super.addTarget(i);
    }

    /* access modifiers changed from: protected */
    public void cancel() {
        super.cancel();
        int size = this.f2908c.size();
        for (int i = 0; i < size; i++) {
            this.f2908c.get(i).cancel();
        }
    }

    public void captureEndValues(C0891t tVar) {
        if (isValidTarget(tVar.f2918b)) {
            Iterator<C0874n> it = this.f2908c.iterator();
            while (it.hasNext()) {
                C0874n next = it.next();
                if (next.isValidTarget(tVar.f2918b)) {
                    next.captureEndValues(tVar);
                    tVar.f2919c.add(next);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void capturePropagationValues(C0891t tVar) {
        super.capturePropagationValues(tVar);
        int size = this.f2908c.size();
        for (int i = 0; i < size; i++) {
            this.f2908c.get(i).capturePropagationValues(tVar);
        }
    }

    public void captureStartValues(C0891t tVar) {
        if (isValidTarget(tVar.f2918b)) {
            Iterator<C0874n> it = this.f2908c.iterator();
            while (it.hasNext()) {
                C0874n next = it.next();
                if (next.isValidTarget(tVar.f2918b)) {
                    next.captureStartValues(tVar);
                    tVar.f2919c.add(next);
                }
            }
        }
    }

    public C0874n clone() {
        C0887r rVar = (C0887r) super.clone();
        rVar.f2908c = new ArrayList<>();
        int size = this.f2908c.size();
        for (int i = 0; i < size; i++) {
            rVar.m3554b(this.f2908c.get(i).clone());
        }
        return rVar;
    }

    /* access modifiers changed from: protected */
    public void createAnimators(ViewGroup viewGroup, C0892u uVar, C0892u uVar2, ArrayList<C0891t> arrayList, ArrayList<C0891t> arrayList2) {
        long startDelay = getStartDelay();
        int size = this.f2908c.size();
        for (int i = 0; i < size; i++) {
            C0874n nVar = this.f2908c.get(i);
            if (startDelay > 0 && (this.f2909d || i == 0)) {
                long startDelay2 = nVar.getStartDelay();
                if (startDelay2 > 0) {
                    nVar.setStartDelay(startDelay2 + startDelay);
                } else {
                    nVar.setStartDelay(startDelay);
                }
            }
            nVar.createAnimators(viewGroup, uVar, uVar2, arrayList, arrayList2);
        }
    }

    /* renamed from: d */
    public C0887r removeTarget(int i) {
        for (int i2 = 0; i2 < this.f2908c.size(); i2++) {
            this.f2908c.get(i2).removeTarget(i);
        }
        return (C0887r) super.removeTarget(i);
    }

    public C0874n excludeTarget(int i, boolean z) {
        for (int i2 = 0; i2 < this.f2908c.size(); i2++) {
            this.f2908c.get(i2).excludeTarget(i, z);
        }
        return super.excludeTarget(i, z);
    }

    public C0874n excludeTarget(View view, boolean z) {
        for (int i = 0; i < this.f2908c.size(); i++) {
            this.f2908c.get(i).excludeTarget(view, z);
        }
        return super.excludeTarget(view, z);
    }

    public C0874n excludeTarget(Class<?> cls, boolean z) {
        for (int i = 0; i < this.f2908c.size(); i++) {
            this.f2908c.get(i).excludeTarget(cls, z);
        }
        return super.excludeTarget(cls, z);
    }

    public C0874n excludeTarget(String str, boolean z) {
        for (int i = 0; i < this.f2908c.size(); i++) {
            this.f2908c.get(i).excludeTarget(str, z);
        }
        return super.excludeTarget(str, z);
    }

    /* access modifiers changed from: package-private */
    public void forceToEnd(ViewGroup viewGroup) {
        super.forceToEnd(viewGroup);
        int size = this.f2908c.size();
        for (int i = 0; i < size; i++) {
            this.f2908c.get(i).forceToEnd(viewGroup);
        }
    }

    public void pause(View view) {
        super.pause(view);
        int size = this.f2908c.size();
        for (int i = 0; i < size; i++) {
            this.f2908c.get(i).pause(view);
        }
    }

    public void resume(View view) {
        super.resume(view);
        int size = this.f2908c.size();
        for (int i = 0; i < size; i++) {
            this.f2908c.get(i).resume(view);
        }
    }

    /* access modifiers changed from: protected */
    public void runAnimators() {
        if (this.f2908c.isEmpty()) {
            start();
            end();
            return;
        }
        m3553b();
        if (!this.f2909d) {
            for (int i = 1; i < this.f2908c.size(); i++) {
                final C0874n nVar = this.f2908c.get(i);
                this.f2908c.get(i - 1).addListener(new C0882o() {
                    /* renamed from: b */
                    public void mo4694b(C0874n nVar) {
                        nVar.runAnimators();
                        nVar.removeListener(this);
                    }
                });
            }
            C0874n nVar2 = this.f2908c.get(0);
            if (nVar2 != null) {
                nVar2.runAnimators();
                return;
            }
            return;
        }
        Iterator<C0874n> it = this.f2908c.iterator();
        while (it.hasNext()) {
            it.next().runAnimators();
        }
    }

    /* access modifiers changed from: package-private */
    public void setCanRemoveViews(boolean z) {
        super.setCanRemoveViews(z);
        int size = this.f2908c.size();
        for (int i = 0; i < size; i++) {
            this.f2908c.get(i).setCanRemoveViews(z);
        }
    }

    public void setEpicenterCallback(C0874n.C0880c cVar) {
        super.setEpicenterCallback(cVar);
        this.f2910e |= 8;
        int size = this.f2908c.size();
        for (int i = 0; i < size; i++) {
            this.f2908c.get(i).setEpicenterCallback(cVar);
        }
    }

    public void setPathMotion(C0866g gVar) {
        super.setPathMotion(gVar);
        this.f2910e |= 4;
        if (this.f2908c != null) {
            for (int i = 0; i < this.f2908c.size(); i++) {
                this.f2908c.get(i).setPathMotion(gVar);
            }
        }
    }

    public void setPropagation(C0886q qVar) {
        super.setPropagation(qVar);
        this.f2910e |= 2;
        int size = this.f2908c.size();
        for (int i = 0; i < size; i++) {
            this.f2908c.get(i).setPropagation(qVar);
        }
    }

    /* access modifiers changed from: package-private */
    public String toString(String str) {
        String nVar = super.toString(str);
        for (int i = 0; i < this.f2908c.size(); i++) {
            StringBuilder sb = new StringBuilder();
            sb.append(nVar);
            sb.append(IOUtils.LINE_SEPARATOR_UNIX);
            sb.append(this.f2908c.get(i).toString(str + "  "));
            nVar = sb.toString();
        }
        return nVar;
    }
}
