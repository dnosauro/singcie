package com.cyberneid.p105d.p108b;

import com.unboundid.ldap.protocol.LDAPMessage;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.b.c */
public final class C1606c extends C1605b {

    /* renamed from: a */
    public static final byte[] f4864a = {116, 114, 117, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE};

    /* renamed from: b */
    public static final byte[] f4865b = {LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE};

    /* renamed from: c */
    public static final C1606c f4866c = new C1606c(true);

    /* renamed from: d */
    public static final C1606c f4867d = new C1606c(false);

    /* renamed from: e */
    private final boolean f4868e;

    private C1606c(boolean z) {
        this.f4868e = z;
    }

    /* renamed from: b */
    public static C1606c m6372b(boolean z) {
        return z ? f4866c : f4867d;
    }

    /* renamed from: a */
    public Object mo7486a(C1624r rVar) {
        return rVar.mo7648a(this);
    }

    /* renamed from: a */
    public void mo7507a(OutputStream outputStream) {
        outputStream.write(this.f4868e ? f4864a : f4865b);
    }

    /* renamed from: a */
    public boolean mo7508a() {
        return this.f4868e;
    }

    public String toString() {
        return String.valueOf(this.f4868e);
    }
}
