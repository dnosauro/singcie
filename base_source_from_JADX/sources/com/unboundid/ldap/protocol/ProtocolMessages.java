package com.unboundid.ldap.protocol;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

enum ProtocolMessages {
    ERR_ABANDON_REQUEST_CANNOT_DECODE("Unable to read or decode an abandon request protocol op:  {0}"),
    ERR_ADD_REQUEST_CANNOT_DECODE("Unable to read or decode an add request protocol op:  {0}"),
    ERR_BIND_REQUEST_CANNOT_DECODE("Unable to read or decode a bind request protocol op:  {0}"),
    ERR_BIND_REQUEST_INVALID_CRED_TYPE("Invalid credentials type {0} in a bind request protocol op."),
    ERR_BIND_RESPONSE_CANNOT_DECODE("Unable to read or decode a bind response:  {0}"),
    ERR_BIND_RESPONSE_INVALID_ELEMENT("Invalid element type {0} in a bind response protocol op."),
    ERR_COMPARE_REQUEST_CANNOT_DECODE("Unable to read or decode a compare request protocol op:  {0}"),
    ERR_DELETE_REQUEST_CANNOT_DECODE("Unable to read or decode a delete request protocol op:  {0}"),
    ERR_EXTENDED_REQUEST_CANNOT_DECODE("Unable to read or decode an extended request protocol op:  {0}"),
    ERR_EXTENDED_RESPONSE_CANNOT_DECODE("Unable to read or decode an extended response:  {0}"),
    ERR_EXTENDED_RESPONSE_INVALID_ELEMENT("Invalid element type {0} in an extended response protocol op."),
    ERR_INTERMEDIATE_RESPONSE_CANNOT_DECODE("Unable to read or decode an intermediate response:  {0}"),
    ERR_INTERMEDIATE_RESPONSE_INVALID_ELEMENT("Invalid element type {0} in an extended response protocol op."),
    ERR_MESSAGE_CANNOT_DECODE("Unable to read or decode an LDAP message:  {0}"),
    ERR_MESSAGE_INVALID_PROTOCOL_OP_TYPE("Invalid protocol op type {0} encountered in an LDAP message."),
    ERR_MESSAGE_IO_ERROR("An I/O error occurred while trying to read the response from the server:  {0}"),
    ERR_MESSAGE_PROTOCOL_OP_TYPE_NOT_RESPONSE("Request protocol op type {0} encountered in an LDAP message when a response type was expected."),
    ERR_MODIFY_REQUEST_CANNOT_DECODE("Unable to read or decode a modify request protocol op:  {0}"),
    ERR_RESPONSE_CANNOT_DECODE("Unable to read or decode an LDAP response:  {0}"),
    ERR_SEARCH_ENTRY_CANNOT_DECODE("Unable to read or decode a search result entry protocol op:  {0}"),
    ERR_SEARCH_REFERENCE_CANNOT_DECODE("Unable to read or decode a search result reference protocol op:  {0}"),
    ERR_SEARCH_REQUEST_CANNOT_DECODE("Unable to read or decode a search request protocol op:  {0}"),
    ERR_UNBIND_REQUEST_CANNOT_DECODE("Unable to read or decode an unbind request protocol op:  {0}");
    
    private static final ConcurrentHashMap<ProtocolMessages, MessageFormat> MESSAGES = null;
    private static final ConcurrentHashMap<ProtocolMessages, String> MESSAGE_STRINGS = null;
    private static final ResourceBundle RESOURCE_BUNDLE = null;
    private final String defaultText;

    private ProtocolMessages(String str) {
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
