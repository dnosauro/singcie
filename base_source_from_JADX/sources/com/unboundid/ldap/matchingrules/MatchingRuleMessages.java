package com.unboundid.ldap.matchingrules;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

enum MatchingRuleMessages {
    ERR_BOOLEAN_INVALID_VALUE("The provided value is invalid.  Boolean values may only be 'TRUE' or 'FALSE'."),
    ERR_BOOLEAN_ORDERING_MATCHING_NOT_SUPPORTED("Ordering matching is not supported for Boolean values."),
    ERR_BOOLEAN_SUBSTRING_MATCHING_NOT_SUPPORTED("Substring matching is not supported for Boolean values."),
    ERR_CASE_IGNORE_LIST_EMPTY_ITEM("The provided value ''{0}'' is not valid according to the case-ignore list syntax because it contains a zero-length item."),
    ERR_CASE_IGNORE_LIST_EMPTY_LIST("The provided value ''{0}'' is not valid according to the case-ignore list syntax because it does not contain any items."),
    ERR_CASE_IGNORE_LIST_MALFORMED_HEX_CHAR("The provided value ''{0}'' is not valid according to the case-ignore list syntax because it contains a backslash which is not followed by two hexadecimal digits."),
    ERR_CASE_IGNORE_LIST_NOT_HEX_DIGIT("Character ''{0}'' is not a valid hexadecimal digit."),
    ERR_CASE_IGNORE_LIST_ORDERING_MATCHING_NOT_SUPPORTED("Ordering matching is not supported for case-ignore list values."),
    ERR_CASE_IGNORE_LIST_SUBSTRING_COMPONENT_CONTAINS_DOLLAR("Substring component ''{0}'' is invalid because it contains an unescaped dollar sign."),
    ERR_DN_ORDERING_MATCHING_NOT_SUPPORTED("Ordering matching is not supported for distinguished name values."),
    ERR_DN_SUBSTRING_MATCHING_NOT_SUPPORTED("Substring matching is not supported for distinguished name values."),
    ERR_GENERALIZED_TIME_INVALID_VALUE("The provided value cannot be parsed according to the generalized time syntax:  {0}"),
    ERR_GENERALIZED_TIME_SUBSTRING_MATCHING_NOT_SUPPORTED("Substring matching is not supported for generalized time values."),
    ERR_INTEGER_INVALID_CHARACTER("The provided value is not a valid integer because it contains an invalid character at position {0,number,0}."),
    ERR_INTEGER_INVALID_LEADING_ZERO("Integer values are not allowed to have  leading zeroes."),
    ERR_INTEGER_SUBSTRING_MATCHING_NOT_SUPPORTED("Substring matching is not supported for integer values."),
    ERR_INTEGER_ZERO_LENGTH_NOT_ALLOWED("Integer values are not allowed to be zero-length strings."),
    ERR_NUMERIC_STRING_INVALID_CHARACTER("The provided value is not a valid numeric string because it contains a character other than a space or numeric digit at position {0,number,0}."),
    ERR_TELEPHONE_NUMBER_INVALID_CHARACTER("The provided value cannot be parsed as a telephone number because it contains an invalid character at position {0,number,0}."),
    ERR_TELEPHONE_NUMBER_ORDERING_MATCHING_NOT_SUPPORTED("Ordering matching is not supported for telephone number values.");
    
    private static final ConcurrentHashMap<MatchingRuleMessages, MessageFormat> MESSAGES = null;
    private static final ConcurrentHashMap<MatchingRuleMessages, String> MESSAGE_STRINGS = null;
    private static final ResourceBundle RESOURCE_BUNDLE = null;
    private final String defaultText;

    private MatchingRuleMessages(String str) {
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
