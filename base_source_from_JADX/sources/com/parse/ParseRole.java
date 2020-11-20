package com.parse;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.regex.Pattern;

@ParseClassName("_Role")
public class ParseRole extends ParseObject {
    private static final Pattern NAME_PATTERN = Pattern.compile("^[0-9a-zA-Z_\\- ]+$");

    ParseRole() {
    }

    public ParseRole(String str) {
        this();
        setName(str);
    }

    public ParseRole(String str, ParseACL parseACL) {
        this(str);
        setACL(parseACL);
    }

    public static ParseQuery<ParseRole> getQuery() {
        return ParseQuery.getQuery(ParseRole.class);
    }

    public String getName() {
        return getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
    }

    public ParseRelation<ParseRole> getRoles() {
        return getRelation("roles");
    }

    public ParseRelation<ParseUser> getUsers() {
        return getRelation("users");
    }

    public void put(String str, Object obj) {
        if (AppMeasurementSdk.ConditionalUserProperty.NAME.equals(str)) {
            if (getObjectId() != null) {
                throw new IllegalArgumentException("A role's name can only be set before it has been saved.");
            } else if (!(obj instanceof String)) {
                throw new IllegalArgumentException("A role's name must be a String.");
            } else if (!NAME_PATTERN.matcher((String) obj).matches()) {
                throw new IllegalArgumentException("A role's name can only contain alphanumeric characters, _, -, and spaces.");
            }
        }
        super.put(str, obj);
    }

    public void setName(String str) {
        put(AppMeasurementSdk.ConditionalUserProperty.NAME, str);
    }

    /* access modifiers changed from: package-private */
    public void validateSave() {
        synchronized (this.mutex) {
            if (getObjectId() == null) {
                if (getName() == null) {
                    throw new IllegalStateException("New roles must specify a name.");
                }
            }
            super.validateSave();
        }
    }
}
