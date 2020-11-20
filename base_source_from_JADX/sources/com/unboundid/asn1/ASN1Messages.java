package com.unboundid.asn1;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

enum ASN1Messages {
    ERR_BOOLEAN_INVALID_LENGTH("ASN.1 Boolean elements must have a value whose length is exactly one byte."),
    ERR_ELEMENT_DECODE_EXCEPTION("Unable to decode the provided byte array as an ASN.1 BER element:  {0}"),
    ERR_ELEMENT_LENGTH_MISMATCH("The decoded length of {0,number,0} does not match the number of bytes remaining in the provided array ({1,number,0})."),
    ERR_ENUMERATED_INVALID_LENGTH("Invalid value length of {0,number,0} for an ASN.1 enumerated element.  Enumerated element values must have a length between 1 and 4 bytes."),
    ERR_INTEGER_INVALID_LENGTH("Invalid value length of {0,number,0} for an ASN.1 integer element.  Integer element values must have a length between 1 and 4 bytes."),
    ERR_LONG_INVALID_LENGTH("Invalid value length of {0,number,0} for an ASN.1 long element.  Long element values must have a length between 1 and 8 bytes."),
    ERR_NULL_HAS_VALUE("ASN.1 null elements must not have a value."),
    ERR_READ_END_BEFORE_FIRST_LENGTH("The end of the input stream was reached before the first length byte could be read."),
    ERR_READ_END_BEFORE_LENGTH_END("The end of the input stream was reached before the full length could be read."),
    ERR_READ_END_BEFORE_VALUE_END("The end of the input stream was reached before the full value could be read."),
    ERR_READ_LENGTH_EXCEEDS_MAX("The element indicated that it required {0,number,0} bytes to hold the value, but this is larger than the maximum of {1,number,0} bytes that the client has been configured to accept."),
    ERR_READ_LENGTH_TOO_LONG("The element indicated that it required {0,number,0} bytes to encode the multi-byte length, but multi-byte lengths must be encoded in 1 to 4 bytes."),
    ERR_SEQUENCE_BYTES_DECODE_EXCEPTION("Unable to decode the provided byte array as a sequence:  {0}"),
    ERR_SEQUENCE_BYTES_DECODE_LENGTH_EXCEEDS_AVAILABLE("Unable to decode the provided byte array as a sequence because the decoded length of an embedded element exceeds the number of bytes remaining."),
    ERR_SEQUENCE_DECODE_EXCEPTION("Unable to decode the provided ASN.1 element {0} as a sequence:  {1}"),
    ERR_SEQUENCE_DECODE_LENGTH_EXCEEDS_AVAILABLE("Unable to decode the provided ASN.1 element {0} as a sequence because the decoded length of an embedded element exceeds the number of bytes remaining."),
    ERR_SET_BYTES_DECODE_EXCEPTION("Unable to decode the provided byte array as a set:  {0}"),
    ERR_SET_BYTES_DECODE_LENGTH_EXCEEDS_AVAILABLE("Unable to decode the provided byte array as a set because the decoded length of an embedded element exceeds the number of bytes remaining."),
    ERR_SET_DECODE_EXCEPTION("Unable to decode the provided ASN.1 element {0} as a set:  {1}"),
    ERR_SET_DECODE_LENGTH_EXCEEDS_AVAILABLE("Unable to decode the provided ASN.1 element {0} as a set because the decoded length of an embedded element exceeds the number of bytes remaining."),
    ERR_STREAM_READER_SEQUENCE_READ_PAST_END("The ASN.1 stream reader has already read beyond the end of this sequence (expected sequence of length {0} to end at {1} bytes into the stream, but {2} bytes have already been read from the stream)."),
    ERR_STREAM_READER_SET_READ_PAST_END("The ASN.1 stream reader has already read beyond the end of this set (expected set of length {0} to end at {1} bytes into the stream, but {2} bytes have already been read from the stream).");
    
    private static final ConcurrentHashMap<ASN1Messages, MessageFormat> MESSAGES = null;
    private static final ConcurrentHashMap<ASN1Messages, String> MESSAGE_STRINGS = null;
    private static final ResourceBundle RESOURCE_BUNDLE = null;
    private final String defaultText;

    private ASN1Messages(String str) {
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
