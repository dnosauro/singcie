package com.unboundid.ldap.sdk.extensions;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

enum ExtOpMessages {
    ERR_CANCEL_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE("Cancel operations are not supported on connections operating in synchronous mode"),
    ERR_CANCEL_REQUEST_CANNOT_DECODE("The provided extended request cannot be decoded as a cancel request because an error occurred while attempting to parse the value:  {0}"),
    ERR_CANCEL_REQUEST_NO_VALUE("The provided extended request cannot be decoded as a cancel request because it does not have a value."),
    ERR_STARTTLS_REQUEST_CANNOT_CREATE_DEFAULT_CONTEXT("An error occurred while attempting to create a default SSL context:  {0}"),
    ERR_STARTTLS_REQUEST_HAS_VALUE("The provided extended cannot request be decoded as a StartTLS request because it has a value."),
    INFO_EXTENDED_REQUEST_NAME_CANCEL("Cancel Extended Request"),
    INFO_EXTENDED_REQUEST_NAME_START_TLS("StartTLS Extended Request"),
    INFO_EXTENDED_RESULT_NAME_NOTICE_OF_DISCONNECT("Notice Of Disconnection Extended Result");
    
    private static final ConcurrentHashMap<ExtOpMessages, MessageFormat> MESSAGES = null;
    private static final ConcurrentHashMap<ExtOpMessages, String> MESSAGE_STRINGS = null;
    private static final ResourceBundle RESOURCE_BUNDLE = null;
    private final String defaultText;

    private ExtOpMessages(String str) {
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
