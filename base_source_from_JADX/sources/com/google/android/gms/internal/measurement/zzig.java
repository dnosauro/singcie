package com.google.android.gms.internal.measurement;

import java.io.IOException;

public class zzig extends IOException {
    private zzjg zza = null;

    public zzig(String str) {
        super(str);
    }

    static zzig zza() {
        return new zzig("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static zzig zzb() {
        return new zzig("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static zzig zzc() {
        return new zzig("CodedInputStream encountered a malformed varint.");
    }

    static zzig zzd() {
        return new zzig("Protocol message contained an invalid tag (zero).");
    }

    static zzig zze() {
        return new zzig("Protocol message end-group tag did not match expected tag.");
    }

    static zzif zzf() {
        return new zzif("Protocol message tag had invalid wire type.");
    }

    static zzig zzg() {
        return new zzig("Failed to parse the message.");
    }

    static zzig zzh() {
        return new zzig("Protocol message had invalid UTF-8.");
    }
}
