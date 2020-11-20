package com.github.appintro.internal;

import java.io.Serializable;
import java.util.Arrays;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p157d.C3266f;
import p157d.p161d.p163b.C3250h;

public final class PermissionWrapper implements Serializable {
    @NotNull
    private String[] permissions;
    private int position;
    private boolean required;

    public PermissionWrapper(@NotNull String[] strArr, int i, boolean z) {
        C3250h.m9056b(strArr, "permissions");
        this.permissions = strArr;
        this.position = i;
        this.required = z;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PermissionWrapper(String[] strArr, int i, boolean z, int i2, C3247e eVar) {
        this(strArr, i, (i2 & 4) != 0 ? true : z);
    }

    public static /* synthetic */ PermissionWrapper copy$default(PermissionWrapper permissionWrapper, String[] strArr, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            strArr = permissionWrapper.permissions;
        }
        if ((i2 & 2) != 0) {
            i = permissionWrapper.position;
        }
        if ((i2 & 4) != 0) {
            z = permissionWrapper.required;
        }
        return permissionWrapper.copy(strArr, i, z);
    }

    @NotNull
    public final String[] component1() {
        return this.permissions;
    }

    public final int component2() {
        return this.position;
    }

    public final boolean component3() {
        return this.required;
    }

    @NotNull
    public final PermissionWrapper copy(@NotNull String[] strArr, int i, boolean z) {
        C3250h.m9056b(strArr, "permissions");
        return new PermissionWrapper(strArr, i, z);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!C3250h.m9055a((Object) getClass(), (Object) obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            PermissionWrapper permissionWrapper = (PermissionWrapper) obj;
            return Arrays.equals(this.permissions, permissionWrapper.permissions) && this.position == permissionWrapper.position && this.required == permissionWrapper.required;
        }
        throw new C3266f("null cannot be cast to non-null type com.github.appintro.internal.PermissionWrapper");
    }

    @NotNull
    public final String[] getPermissions() {
        return this.permissions;
    }

    public final int getPosition() {
        return this.position;
    }

    public final boolean getRequired() {
        return this.required;
    }

    public int hashCode() {
        return (((Arrays.hashCode(this.permissions) * 31) + this.position) * 31) + Boolean.valueOf(this.required).hashCode();
    }

    public final void setPermissions(@NotNull String[] strArr) {
        C3250h.m9056b(strArr, "<set-?>");
        this.permissions = strArr;
    }

    public final void setPosition(int i) {
        this.position = i;
    }

    public final void setRequired(boolean z) {
        this.required = z;
    }

    @NotNull
    public String toString() {
        return "PermissionWrapper(permissions=" + Arrays.toString(this.permissions) + ", position=" + this.position + ", required=" + this.required + ")";
    }
}
