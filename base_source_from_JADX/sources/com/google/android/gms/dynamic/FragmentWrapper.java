package com.google.android.gms.dynamic;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IFragmentWrapper;

@SuppressLint({"NewApi"})
@KeepForSdk
public final class FragmentWrapper extends IFragmentWrapper.Stub {
    private Fragment zza;

    private FragmentWrapper(Fragment fragment) {
        this.zza = fragment;
    }

    @KeepForSdk
    public static FragmentWrapper wrap(Fragment fragment) {
        if (fragment != null) {
            return new FragmentWrapper(fragment);
        }
        return null;
    }

    public final IObjectWrapper zza() {
        return ObjectWrapper.wrap(this.zza.getActivity());
    }

    public final void zza(Intent intent) {
        this.zza.startActivity(intent);
    }

    public final void zza(Intent intent, int i) {
        this.zza.startActivityForResult(intent, i);
    }

    public final void zza(IObjectWrapper iObjectWrapper) {
        this.zza.registerForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zza(boolean z) {
        this.zza.setHasOptionsMenu(z);
    }

    public final Bundle zzb() {
        return this.zza.getArguments();
    }

    public final void zzb(IObjectWrapper iObjectWrapper) {
        this.zza.unregisterForContextMenu((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzb(boolean z) {
        this.zza.setMenuVisibility(z);
    }

    public final int zzc() {
        return this.zza.getId();
    }

    public final void zzc(boolean z) {
        this.zza.setRetainInstance(z);
    }

    public final IFragmentWrapper zzd() {
        return wrap(this.zza.getParentFragment());
    }

    public final void zzd(boolean z) {
        this.zza.setUserVisibleHint(z);
    }

    public final IObjectWrapper zze() {
        return ObjectWrapper.wrap(this.zza.getResources());
    }

    public final boolean zzf() {
        return this.zza.getRetainInstance();
    }

    public final String zzg() {
        return this.zza.getTag();
    }

    public final IFragmentWrapper zzh() {
        return wrap(this.zza.getTargetFragment());
    }

    public final int zzi() {
        return this.zza.getTargetRequestCode();
    }

    public final boolean zzj() {
        return this.zza.getUserVisibleHint();
    }

    public final IObjectWrapper zzk() {
        return ObjectWrapper.wrap(this.zza.getView());
    }

    public final boolean zzl() {
        return this.zza.isAdded();
    }

    public final boolean zzm() {
        return this.zza.isDetached();
    }

    public final boolean zzn() {
        return this.zza.isHidden();
    }

    public final boolean zzo() {
        return this.zza.isInLayout();
    }

    public final boolean zzp() {
        return this.zza.isRemoving();
    }

    public final boolean zzq() {
        return this.zza.isResumed();
    }

    public final boolean zzr() {
        return this.zza.isVisible();
    }
}
