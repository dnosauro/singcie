package com.unboundid.ldap.sdk;

import java.io.Serializable;

public abstract class PasswordProvider implements Serializable {
    private static final long serialVersionUID = -1582416755360005908L;

    public abstract byte[] getPasswordBytes();
}
