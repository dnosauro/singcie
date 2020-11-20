package com.google.android.gms.internal.ads;

import java.io.IOException;

public class zzeks extends IOException {
    private zzels zzioe = null;

    public zzeks(String str) {
        super(str);
    }

    static zzeks zzbii() {
        return new zzeks("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzeks zzbij() {
        return new zzeks("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzeks zzbik() {
        return new zzeks("CodedInputStream encountered a malformed varint.");
    }

    static zzeks zzbil() {
        return new zzeks("Protocol message contained an invalid tag (zero).");
    }

    static zzeks zzbim() {
        return new zzeks("Protocol message end-group tag did not match expected tag.");
    }

    static zzekr zzbin() {
        return new zzekr("Protocol message tag had invalid wire type.");
    }

    static zzeks zzbio() {
        return new zzeks("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static zzeks zzbip() {
        return new zzeks("Failed to parse the message.");
    }

    static zzeks zzbiq() {
        return new zzeks("Protocol message had invalid UTF-8.");
    }

    public final zzeks zzl(zzels zzels) {
        this.zzioe = zzels;
        return this;
    }
}
