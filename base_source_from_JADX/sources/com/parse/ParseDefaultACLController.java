package com.parse;

import java.lang.ref.WeakReference;

class ParseDefaultACLController {
    ParseACL defaultACL;
    boolean defaultACLUsesCurrentUser;
    ParseACL defaultACLWithCurrentUser;
    WeakReference<ParseUser> lastCurrentUser;

    ParseDefaultACLController() {
    }

    public ParseACL get() {
        ParseUser currentUser;
        if (!this.defaultACLUsesCurrentUser || this.defaultACL == null || (currentUser = ParseUser.getCurrentUser()) == null) {
            return this.defaultACL;
        }
        WeakReference<ParseUser> weakReference = this.lastCurrentUser;
        if ((weakReference != null ? (ParseUser) weakReference.get() : null) != currentUser) {
            ParseACL copy = this.defaultACL.copy();
            copy.setShared(true);
            copy.setReadAccess(currentUser, true);
            copy.setWriteAccess(currentUser, true);
            this.defaultACLWithCurrentUser = copy;
            this.lastCurrentUser = new WeakReference<>(currentUser);
        }
        return this.defaultACLWithCurrentUser;
    }

    public void set(ParseACL parseACL, boolean z) {
        this.defaultACLWithCurrentUser = null;
        this.lastCurrentUser = null;
        if (parseACL != null) {
            ParseACL copy = parseACL.copy();
            copy.setShared(true);
            this.defaultACL = copy;
            this.defaultACLUsesCurrentUser = z;
            return;
        }
        this.defaultACL = null;
    }
}
