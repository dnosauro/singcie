package com.unboundid.ldif;

import com.unboundid.ldap.sdk.Entry;

public interface LDIFReaderEntryTranslator {
    Entry translate(Entry entry, long j);
}
