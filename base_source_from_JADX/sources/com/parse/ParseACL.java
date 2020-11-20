package com.parse;

import android.os.Parcel;
import android.os.Parcelable;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ParseACL implements Parcelable {
    public static final Parcelable.Creator<ParseACL> CREATOR = new Parcelable.Creator<ParseACL>() {
        public ParseACL createFromParcel(Parcel parcel) {
            return new ParseACL(parcel, new ParseObjectParcelDecoder());
        }

        public ParseACL[] newArray(int i) {
            return new ParseACL[i];
        }
    };
    private static final String KEY_ROLE_PREFIX = "role:";
    private static final String PUBLIC_KEY = "*";
    private static final String UNRESOLVED_KEY = "*unresolved";
    private static final String UNRESOLVED_USER_JSON_KEY = "unresolvedUser";
    private final Map<String, Permissions> permissionsById;
    private boolean shared;
    private ParseUser unresolvedUser;

    private static class Permissions {
        private static final String READ_PERMISSION = "read";
        private static final String WRITE_PERMISSION = "write";
        private final boolean readPermission;
        private final boolean writePermission;

        Permissions(Permissions permissions) {
            this.readPermission = permissions.readPermission;
            this.writePermission = permissions.writePermission;
        }

        Permissions(boolean z, boolean z2) {
            this.readPermission = z;
            this.writePermission = z2;
        }

        static Permissions createPermissionsFromJSONObject(JSONObject jSONObject) {
            return new Permissions(jSONObject.optBoolean(READ_PERMISSION, false), jSONObject.optBoolean(WRITE_PERMISSION, false));
        }

        static Permissions createPermissionsFromParcel(Parcel parcel) {
            boolean z = false;
            boolean z2 = parcel.readByte() == 1;
            if (parcel.readByte() == 1) {
                z = true;
            }
            return new Permissions(z2, z);
        }

        /* access modifiers changed from: package-private */
        public boolean getReadPermission() {
            return this.readPermission;
        }

        /* access modifiers changed from: package-private */
        public boolean getWritePermission() {
            return this.writePermission;
        }

        /* access modifiers changed from: package-private */
        public JSONObject toJSONObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                if (this.readPermission) {
                    jSONObject.put(READ_PERMISSION, true);
                }
                if (this.writePermission) {
                    jSONObject.put(WRITE_PERMISSION, true);
                }
                return jSONObject;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }

        /* access modifiers changed from: package-private */
        public void toParcel(Parcel parcel) {
            parcel.writeByte(this.readPermission ? (byte) 1 : 0);
            parcel.writeByte(this.writePermission ? (byte) 1 : 0);
        }
    }

    private static class UserResolutionListener implements GetCallback<ParseObject> {
        private final WeakReference<ParseACL> parent;

        public UserResolutionListener(ParseACL parseACL) {
            this.parent = new WeakReference<>(parseACL);
        }

        public void done(ParseObject parseObject, ParseException parseException) {
            try {
                ParseACL parseACL = (ParseACL) this.parent.get();
                if (parseACL != null) {
                    parseACL.resolveUser((ParseUser) parseObject);
                }
            } finally {
                parseObject.unregisterSaveListener(this);
            }
        }
    }

    public ParseACL() {
        this.permissionsById = new HashMap();
    }

    ParseACL(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
        this.permissionsById = new HashMap();
        this.shared = parcel.readByte() == 1;
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.permissionsById.put(parcel.readString(), Permissions.createPermissionsFromParcel(parcel));
        }
        if (parcel.readByte() == 1) {
            this.unresolvedUser = (ParseUser) parseParcelDecoder.decode(parcel);
            this.unresolvedUser.registerSaveListener(new UserResolutionListener(this));
        }
    }

    public ParseACL(ParseACL parseACL) {
        this.permissionsById = new HashMap();
        for (String next : parseACL.permissionsById.keySet()) {
            this.permissionsById.put(next, new Permissions(parseACL.permissionsById.get(next)));
        }
        this.unresolvedUser = parseACL.unresolvedUser;
        ParseUser parseUser = this.unresolvedUser;
        if (parseUser != null) {
            parseUser.registerSaveListener(new UserResolutionListener(this));
        }
    }

    public ParseACL(ParseUser parseUser) {
        this();
        setReadAccess(parseUser, true);
        setWriteAccess(parseUser, true);
    }

    static ParseACL createACLFromJSONObject(JSONObject jSONObject, ParseDecoder parseDecoder) {
        ParseACL parseACL = new ParseACL();
        for (String next : ParseJSONUtils.keys(jSONObject)) {
            if (next.equals(UNRESOLVED_USER_JSON_KEY)) {
                try {
                    parseACL.unresolvedUser = (ParseUser) parseDecoder.decode(jSONObject.getJSONObject(next));
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            } else {
                try {
                    parseACL.permissionsById.put(next, Permissions.createPermissionsFromJSONObject(jSONObject.getJSONObject(next)));
                } catch (JSONException e2) {
                    throw new RuntimeException("could not decode ACL: " + e2.getMessage());
                }
            }
        }
        return parseACL;
    }

    static ParseACL getDefaultACL() {
        return getDefaultACLController().get();
    }

    private static ParseDefaultACLController getDefaultACLController() {
        return ParseCorePlugins.getInstance().getDefaultACLController();
    }

    private boolean isUnresolvedUser(ParseUser parseUser) {
        ParseUser parseUser2;
        if (parseUser == null || (parseUser2 = this.unresolvedUser) == null) {
            return false;
        }
        return parseUser == parseUser2 || (parseUser.getObjectId() == null && parseUser.getOrCreateLocalId().equals(this.unresolvedUser.getOrCreateLocalId()));
    }

    private void prepareUnresolvedUser(ParseUser parseUser) {
        if (!isUnresolvedUser(parseUser)) {
            this.permissionsById.remove(UNRESOLVED_KEY);
            this.unresolvedUser = parseUser;
            this.unresolvedUser.registerSaveListener(new UserResolutionListener(this));
        }
    }

    public static void setDefaultACL(ParseACL parseACL, boolean z) {
        getDefaultACLController().set(parseACL, z);
    }

    private void setPermissionsIfNonEmpty(String str, boolean z, boolean z2) {
        if (z || z2) {
            this.permissionsById.put(str, new Permissions(z, z2));
        } else {
            this.permissionsById.remove(str);
        }
    }

    private void setUnresolvedReadAccess(ParseUser parseUser, boolean z) {
        prepareUnresolvedUser(parseUser);
        setReadAccess(UNRESOLVED_KEY, z);
    }

    private void setUnresolvedWriteAccess(ParseUser parseUser, boolean z) {
        prepareUnresolvedUser(parseUser);
        setWriteAccess(UNRESOLVED_KEY, z);
    }

    private static void validateRoleState(ParseRole parseRole) {
        if (parseRole == null || parseRole.getObjectId() == null) {
            throw new IllegalArgumentException("Roles must be saved to the server before they can be used in an ACL.");
        }
    }

    /* access modifiers changed from: package-private */
    public ParseACL copy() {
        return new ParseACL(this);
    }

    public int describeContents() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public Map<String, Permissions> getPermissionsById() {
        return this.permissionsById;
    }

    public boolean getPublicReadAccess() {
        return getReadAccess("*");
    }

    public boolean getPublicWriteAccess() {
        return getWriteAccess("*");
    }

    public boolean getReadAccess(ParseUser parseUser) {
        String objectId;
        if (isUnresolvedUser(parseUser)) {
            objectId = UNRESOLVED_KEY;
        } else if (parseUser.isLazy()) {
            return false;
        } else {
            if (parseUser.getObjectId() != null) {
                objectId = parseUser.getObjectId();
            } else {
                throw new IllegalArgumentException("cannot getReadAccess for a user with null id");
            }
        }
        return getReadAccess(objectId);
    }

    public boolean getReadAccess(String str) {
        if (str != null) {
            Permissions permissions = this.permissionsById.get(str);
            return permissions != null && permissions.getReadPermission();
        }
        throw new IllegalArgumentException("cannot getReadAccess for null userId");
    }

    public boolean getRoleReadAccess(ParseRole parseRole) {
        validateRoleState(parseRole);
        return getRoleReadAccess(parseRole.getName());
    }

    public boolean getRoleReadAccess(String str) {
        return getReadAccess(KEY_ROLE_PREFIX + str);
    }

    public boolean getRoleWriteAccess(ParseRole parseRole) {
        validateRoleState(parseRole);
        return getRoleWriteAccess(parseRole.getName());
    }

    public boolean getRoleWriteAccess(String str) {
        return getWriteAccess(KEY_ROLE_PREFIX + str);
    }

    /* access modifiers changed from: package-private */
    public ParseUser getUnresolvedUser() {
        return this.unresolvedUser;
    }

    public boolean getWriteAccess(ParseUser parseUser) {
        String objectId;
        if (isUnresolvedUser(parseUser)) {
            objectId = UNRESOLVED_KEY;
        } else if (parseUser.isLazy()) {
            return false;
        } else {
            if (parseUser.getObjectId() != null) {
                objectId = parseUser.getObjectId();
            } else {
                throw new IllegalArgumentException("cannot getWriteAccess for a user with null id");
            }
        }
        return getWriteAccess(objectId);
    }

    public boolean getWriteAccess(String str) {
        if (str != null) {
            Permissions permissions = this.permissionsById.get(str);
            return permissions != null && permissions.getWritePermission();
        }
        throw new IllegalArgumentException("cannot getWriteAccess for null userId");
    }

    /* access modifiers changed from: package-private */
    public boolean hasUnresolvedUser() {
        return this.unresolvedUser != null;
    }

    /* access modifiers changed from: package-private */
    public boolean isShared() {
        return this.shared;
    }

    /* access modifiers changed from: package-private */
    public void resolveUser(ParseUser parseUser) {
        if (isUnresolvedUser(parseUser)) {
            if (this.permissionsById.containsKey(UNRESOLVED_KEY)) {
                this.permissionsById.put(parseUser.getObjectId(), this.permissionsById.get(UNRESOLVED_KEY));
                this.permissionsById.remove(UNRESOLVED_KEY);
            }
            this.unresolvedUser = null;
        }
    }

    public void setPublicReadAccess(boolean z) {
        setReadAccess("*", z);
    }

    public void setPublicWriteAccess(boolean z) {
        setWriteAccess("*", z);
    }

    public void setReadAccess(ParseUser parseUser, boolean z) {
        if (parseUser.getObjectId() != null) {
            setReadAccess(parseUser.getObjectId(), z);
        } else if (parseUser.isLazy()) {
            setUnresolvedReadAccess(parseUser, z);
        } else {
            throw new IllegalArgumentException("cannot setReadAccess for a user with null id");
        }
    }

    public void setReadAccess(String str, boolean z) {
        if (str != null) {
            setPermissionsIfNonEmpty(str, z, getWriteAccess(str));
            return;
        }
        throw new IllegalArgumentException("cannot setReadAccess for null userId");
    }

    public void setRoleReadAccess(ParseRole parseRole, boolean z) {
        validateRoleState(parseRole);
        setRoleReadAccess(parseRole.getName(), z);
    }

    public void setRoleReadAccess(String str, boolean z) {
        setReadAccess(KEY_ROLE_PREFIX + str, z);
    }

    public void setRoleWriteAccess(ParseRole parseRole, boolean z) {
        validateRoleState(parseRole);
        setRoleWriteAccess(parseRole.getName(), z);
    }

    public void setRoleWriteAccess(String str, boolean z) {
        setWriteAccess(KEY_ROLE_PREFIX + str, z);
    }

    /* access modifiers changed from: package-private */
    public void setShared(boolean z) {
        this.shared = z;
    }

    public void setWriteAccess(ParseUser parseUser, boolean z) {
        if (parseUser.getObjectId() != null) {
            setWriteAccess(parseUser.getObjectId(), z);
        } else if (parseUser.isLazy()) {
            setUnresolvedWriteAccess(parseUser, z);
        } else {
            throw new IllegalArgumentException("cannot setWriteAccess for a user with null id");
        }
    }

    public void setWriteAccess(String str, boolean z) {
        if (str != null) {
            setPermissionsIfNonEmpty(str, getReadAccess(str), z);
            return;
        }
        throw new IllegalArgumentException("cannot setWriteAccess for null userId");
    }

    /* access modifiers changed from: package-private */
    public JSONObject toJSONObject(ParseEncoder parseEncoder) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (String next : this.permissionsById.keySet()) {
                jSONObject.put(next, this.permissionsById.get(next).toJSONObject());
            }
            if (this.unresolvedUser != null) {
                jSONObject.put(UNRESOLVED_USER_JSON_KEY, parseEncoder.encode(this.unresolvedUser));
            }
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        writeToParcel(parcel, (ParseParcelEncoder) new ParseObjectParcelEncoder());
    }

    /* access modifiers changed from: package-private */
    public void writeToParcel(Parcel parcel, ParseParcelEncoder parseParcelEncoder) {
        parcel.writeByte(this.shared ? (byte) 1 : 0);
        parcel.writeInt(this.permissionsById.size());
        for (String next : this.permissionsById.keySet()) {
            parcel.writeString(next);
            this.permissionsById.get(next).toParcel(parcel);
        }
        parcel.writeByte(this.unresolvedUser != null ? (byte) 1 : 0);
        ParseUser parseUser = this.unresolvedUser;
        if (parseUser != null) {
            parseParcelEncoder.encode(parseUser, parcel);
        }
    }
}
