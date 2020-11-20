package com.unboundid.util.ssl;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

enum SSLMessages {
    ERR_CERTIFICATE_REJECTED_BY_USER("The user rejected the provided certificate."),
    ERR_KEYSTORE_CANNOT_GET_KEY_MANAGERS("Unable to obtain key managers for key store file ''{0}'' using format ''{1}'':  {2}"),
    ERR_KEYSTORE_CANNOT_LOAD("Unable to load key store ''{0}'' of type ''{1}'':  {2}"),
    ERR_KEYSTORE_NO_SUCH_FILE("Key store file ''{0}'' does not exist."),
    ERR_PKCS11_CANNOT_ACCESS("Unable to access the PKCS#11 key store:  {0}"),
    ERR_PKCS11_CANNOT_GET_KEY_MANAGERS("Unable to obtain key managers for the PKCS#11 key store:  {0}"),
    ERR_TRUSTSTORE_CANNOT_GET_TRUST_MANAGERS("Unable to obtain trust managers for trust store file ''{0}'' using format ''{1}'':  {2}"),
    ERR_TRUSTSTORE_CANNOT_LOAD("Unable to load trust store ''{0}'' of type ''{1}'':  {2}"),
    ERR_TRUSTSTORE_NO_SUCH_FILE("Trust store file ''{0}'' does not exist."),
    ERR_TRUSTSTORE_UNSUPPORTED_FORMAT("Unsupported trust store format ''{0}''."),
    INFO_PROMPT_CLIENT_HEADING("The client presented the following certificate:"),
    INFO_PROMPT_ISSUER_SUBJECT("Issuer[{0,number,0}] Subject:  {1}"),
    INFO_PROMPT_MD5_FINGERPRINT("MD5 Fingerprint:  {0}"),
    INFO_PROMPT_MESSAGE("Do you wish to trust this certificate?  Enter 'y' or 'n':"),
    INFO_PROMPT_SERVER_HEADING("The server presented the following certificate:"),
    INFO_PROMPT_SHA1_FINGERPRINT("SHA-1 Fingerprint:  {0}"),
    INFO_PROMPT_SUBJECT("Subject:  {0}"),
    INFO_PROMPT_VALIDITY("The certificate is valid from {0} to {1}."),
    WARN_PROMPT_EXPIRED("WARNING:  This certificate is expired."),
    WARN_PROMPT_NOT_YET_VALID("WARNING:  The current time is before the certificate validity start date."),
    WARN_PROMPT_SELF_SIGNED("WARNING:  The certificate is self-signed.");
    
    private static final ConcurrentHashMap<SSLMessages, MessageFormat> MESSAGES = null;
    private static final ConcurrentHashMap<SSLMessages, String> MESSAGE_STRINGS = null;
    private static final ResourceBundle RESOURCE_BUNDLE = null;
    private final String defaultText;

    private SSLMessages(String str) {
        this.defaultText = str;
    }

    public String get() {
        String str = MESSAGE_STRINGS.get(this);
        if (str == null) {
            ResourceBundle resourceBundle = RESOURCE_BUNDLE;
            if (resourceBundle == null) {
                return this.defaultText;
            }
            try {
                str = resourceBundle.getString(name());
            } catch (Exception unused) {
                str = this.defaultText;
            }
            MESSAGE_STRINGS.putIfAbsent(this, str);
        }
        return str;
    }

    public String get(Object... objArr) {
        String format;
        MessageFormat messageFormat = MESSAGES.get(this);
        if (messageFormat == null) {
            ResourceBundle resourceBundle = RESOURCE_BUNDLE;
            if (resourceBundle == null) {
                messageFormat = new MessageFormat(this.defaultText);
            } else {
                try {
                    messageFormat = new MessageFormat(resourceBundle.getString(name()));
                } catch (Exception unused) {
                    messageFormat = new MessageFormat(this.defaultText);
                }
            }
            MESSAGES.putIfAbsent(this, messageFormat);
        }
        synchronized (messageFormat) {
            format = messageFormat.format(objArr);
        }
        return format;
    }

    public String toString() {
        return get();
    }
}
