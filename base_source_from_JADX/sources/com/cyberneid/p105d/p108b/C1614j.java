package com.cyberneid.p105d.p108b;

import com.unboundid.ldap.protocol.LDAPMessage;
import java.io.OutputStream;

/* renamed from: com.cyberneid.d.b.j */
public final class C1614j extends C1605b {

    /* renamed from: a */
    public static final byte[] f5367a = {LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, 117, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST};

    /* renamed from: b */
    public static final C1614j f5368b = new C1614j();

    private C1614j() {
    }

    /* renamed from: a */
    public Object mo7486a(C1624r rVar) {
        return rVar.mo7654a(this);
    }

    /* renamed from: a */
    public void mo7602a(OutputStream outputStream) {
        outputStream.write(f5367a);
    }

    public String toString() {
        return "COSNull{}";
    }
}
