package com.unboundid.util;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

enum UtilityMessages {
    ERR_AGGREGATE_INPUT_STREAM_MARK_NOT_SUPPORTED("The aggregate input stream does not support the use of mark and reset functionality."),
    ERR_ARG_STRING_DANGLING_BACKSLASH("The provided string cannot be parsed as an argument list because it ends with a backslash that was not immediately preceded by another backslash.  The backslash character will be considered an escape to indicate that the next character should be included as-is with no interpretation."),
    ERR_ARG_STRING_UNMATCHED_QUOTE("The provided string cannot be parsed as an argument list because it has an unmatched quote starting at or near position {0}."),
    ERR_BASE64_DECODE_INVALID_LENGTH("A base64-encoded string must have a length that is a multiple of 4 bytes."),
    ERR_BASE64_DECODE_UNEXPECTED_CHAR("Invalid character ''{0}'' encountered."),
    ERR_BASE64_DECODE_UNEXPECTED_EQUAL("Unexpected equal sign found at position {0,number,0}."),
    ERR_BASE64_URLDECODE_INVALID_LENGTH("The provided string did not have a valid length for base64url-encoded data."),
    ERR_BS_BUFFER_ARRAY_NULL("The provided array is null."),
    ERR_BS_BUFFER_BUFFER_NULL("The provided buffer is null."),
    ERR_BS_BUFFER_BYTE_STRING_NULL("The provided byte string is null."),
    ERR_BS_BUFFER_CAPACITY_NEGATIVE("The provided capacity {0,number,0} is negative."),
    ERR_BS_BUFFER_CHAR_SEQUENCE_NULL("The provided character sequence is null."),
    ERR_BS_BUFFER_LENGTH_NEGATIVE("The provided length {0,number,0} is negative."),
    ERR_BS_BUFFER_OFFSET_NEGATIVE("The provided offset {0,number,0} is negative."),
    ERR_BS_BUFFER_OFFSET_PLUS_LENGTH_TOO_LARGE("The provided offset {0,number,0} plus the provided length {1,number,0} is greater than the size of the provided array ({2,number,0})."),
    ERR_BS_BUFFER_POS_NEGATIVE("The provided position {0,number,0} is negative."),
    ERR_BS_BUFFER_POS_TOO_LARGE("The provided position {0,number,0} is greater than the length of the buffer ({1,number,0})."),
    ERR_DECODE_UUID_INVALID_LENGTH("Unable to decode bytes ''{0}'' as a valid UUID because the length of the provided content was not exactly 128 bits."),
    ERR_GENTIME_CANNOT_PARSE_INVALID_LENGTH("Unable to parse the provided timestamp ''{0}'' because it had an invalid number of characters before the sub-second and/or time zone portion."),
    ERR_GENTIME_DECODE_CANNOT_PARSE_TZ("Unable to parse time zone information from the provided timestamp ''{0}''."),
    ERR_NO_EXCEPTION("No Exception"),
    ERR_VALIDATOR_FAILURE_CUSTOM_MESSAGE("{0}.  Thread stack trace:  {1}"),
    ERR_VALIDATOR_FALSE_CHECK_FAILURE("A result of true was found for a condition which the LDAP SDK requires to be false.  Thread stack trace {0}"),
    ERR_VALIDATOR_NULL_CHECK_FAILURE("A null object was provided where a non-null object is required (non-null index {0,number,0}).  Thread stack trace:  {1}"),
    ERR_VALIDATOR_TRUE_CHECK_FAILURE("A result of false was found for a condition which the LDAP SDK requires to be true.  Thread stack trace {0}"),
    INFO_NUM_DAYS_PLURAL("{0,number,0} days"),
    INFO_NUM_DAYS_SINGULAR("{0,number,0} day"),
    INFO_NUM_HOURS_PLURAL("{0,number,0} hours"),
    INFO_NUM_HOURS_SINGULAR("{0,number,0} hour"),
    INFO_NUM_MINUTES_PLURAL("{0,number,0} minutes"),
    INFO_NUM_MINUTES_SINGULAR("{0,number,0} minute"),
    INFO_NUM_SECONDS_PLURAL("{0,number,0} seconds"),
    INFO_NUM_SECONDS_SINGULAR("{0,number,0} second"),
    INFO_NUM_SECONDS_WITH_DECIMAL("{0} seconds");
    
    private static final ConcurrentHashMap<UtilityMessages, MessageFormat> MESSAGES = null;
    private static final ConcurrentHashMap<UtilityMessages, String> MESSAGE_STRINGS = null;
    private static final ResourceBundle RESOURCE_BUNDLE = null;
    private final String defaultText;

    private UtilityMessages(String str) {
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
