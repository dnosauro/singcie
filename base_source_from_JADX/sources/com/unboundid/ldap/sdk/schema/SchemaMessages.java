package com.unboundid.ldap.sdk.schema;

import java.text.MessageFormat;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;

enum SchemaMessages {
    ERR_ATTRSYNTAX_DECODE_CLOSE_NOT_AT_END("Unable to decode the provided string ''{0}'' as an attribute syntax because the closing parenthesis was not at the end of the string."),
    ERR_ATTRSYNTAX_DECODE_DUP_EXT("Unable to decode the provided string ''{0}'' as an attribute syntax because it included multiple occurrences of the ''{1}'' extension."),
    ERR_ATTRSYNTAX_DECODE_EMPTY("An empty string cannot be decoded as an attribute syntax."),
    ERR_ATTRSYNTAX_DECODE_MULTIPLE_DESC("Unable to decode the provided string ''{0}'' as an attribute syntax because it included multiple DESC elements."),
    ERR_ATTRSYNTAX_DECODE_NO_OPENING_PAREN("Unable to decode the provided string ''{0}'' as an attribute syntax definition because it does not start with an opening parenthesis."),
    ERR_ATTRSYNTAX_DECODE_UNEXPECTED_TOKEN("Unable to decode the provided string ''{0}'' as an attribute syntax because it included an unexpected token ''{1}''."),
    ERR_ATTRTYPE_DECODE_CLOSE_NOT_AT_END("Unable to decode the provided string ''{0}'' as an attribute type because the closing parenthesis was not at the end of the string."),
    ERR_ATTRTYPE_DECODE_DUP_EXT("Unable to decode the provided string ''{0}'' as an attribute type because it included multiple occurrences of the ''{1}'' extension."),
    ERR_ATTRTYPE_DECODE_EMPTY("An empty string cannot be decoded as an attribute type."),
    ERR_ATTRTYPE_DECODE_INVALID_USAGE("Unable to decode the provided string ''{0}'' as an attribute type because it included an invalid attribute usage of ''{1}''."),
    ERR_ATTRTYPE_DECODE_MULTIPLE_ELEMENTS("Unable to decode the provided string ''{0}'' as an attribute type because it included multiple occurrences of the {1} element."),
    ERR_ATTRTYPE_DECODE_NO_OPENING_PAREN("Unable to decode the provided string ''{0}'' as an attribute type definition because it does not start with an opening parenthesis."),
    ERR_ATTRTYPE_DECODE_UNEXPECTED_TOKEN("Unable to decode the provided string ''{0}'' as an attribute type because it included an unexpected token ''{1}''."),
    ERR_DCR_DECODE_CLOSE_NOT_AT_END("Unable to decode the provided string ''{0}'' as a DIT content rule because the closing parenthesis was not at the end of the string."),
    ERR_DCR_DECODE_DUP_EXT("Unable to decode the provided string ''{0}'' as a DIT content rule because it included multiple occurrences of the ''{1}'' extension."),
    ERR_DCR_DECODE_EMPTY("An empty string cannot be decoded as a DIT content rule."),
    ERR_DCR_DECODE_MULTIPLE_ELEMENTS("Unable to decode the provided string ''{0}'' as a DIT content rule because it included multiple occurrences of the {1} element."),
    ERR_DCR_DECODE_NO_OPENING_PAREN("Unable to decode the provided string ''{0}'' as a DIT content rule definition because it does not start with an opening parenthesis."),
    ERR_DSR_DECODE_CLOSE_NOT_AT_END("Unable to decode the provided string ''{0}'' as a DIT structure rule because the closing parenthesis was not at the end of the string."),
    ERR_DSR_DECODE_DUP_EXT("Unable to decode the provided string ''{0}'' as a DIT structure rule because it included multiple occurrences of the ''{1}'' extension."),
    ERR_DSR_DECODE_EMPTY("An empty string cannot be decoded as a DIT structure rule."),
    ERR_DSR_DECODE_MULTIPLE_ELEMENTS("Unable to decode the provided string ''{0}'' as a DIT structure rule because it included multiple occurrences of the {1} element."),
    ERR_DSR_DECODE_NO_FORM("Unable to decode the provided string ''{0}'' as a DIT structure rule because dit not include the required FORM element."),
    ERR_DSR_DECODE_NO_OPENING_PAREN("Unable to decode the provided string ''{0}'' as a DIT structure rule definition because it does not start with an opening parenthesis."),
    ERR_DSR_DECODE_RULE_ID_NOT_INT("Unable to decode the provided string ''{0}'' as a DIT structure rule because the rule ID could not be parsed as an integer."),
    ERR_DSR_DECODE_SUP_ID_NOT_INT("Unable to decode the provided string ''{0}'' as a DIT structure rule because one of the superior rule IDs could not be parsed as an integer."),
    ERR_DSR_DECODE_UNEXPECTED_TOKEN("Unable to decode the provided string ''{0}'' as a DIT structure rule because it included an unexpected token ''{1}''."),
    ERR_MRU_DECODE_CLOSE_NOT_AT_END("Unable to decode the provided string ''{0}'' as a matching rule use because the closing parenthesis was not at the end of the string."),
    ERR_MRU_DECODE_DUP_EXT("Unable to decode the provided string ''{0}'' as a matching rule use because it included multiple occurrences of the ''{1}'' extension."),
    ERR_MRU_DECODE_EMPTY("An empty string cannot be decoded as a matching rule use."),
    ERR_MRU_DECODE_MULTIPLE_ELEMENTS("Unable to decode the provided string ''{0}'' as a matching rule use because it included multiple occurrences of the {1} element."),
    ERR_MRU_DECODE_NO_APPLIES("Unable to decode the provided string ''{0}'' as a matching rule use because it did not include any applicable attribute types."),
    ERR_MRU_DECODE_NO_OPENING_PAREN("Unable to decode the provided string ''{0}'' as a matching rule use definition because it does not start with an opening parenthesis."),
    ERR_MRU_DECODE_UNEXPECTED_TOKEN("Unable to decode the provided string ''{0}'' as a matching rule use because it included an unexpected token ''{1}''."),
    ERR_MR_DECODE_CLOSE_NOT_AT_END("Unable to decode the provided string ''{0}'' as a matching rule because the closing parenthesis was not at the end of the string."),
    ERR_MR_DECODE_DUP_EXT("Unable to decode the provided string ''{0}'' as a matching rule because it included multiple occurrences of the ''{1}'' extension."),
    ERR_MR_DECODE_EMPTY("An empty string cannot be decoded as a matching rule."),
    ERR_MR_DECODE_MULTIPLE_ELEMENTS("Unable to decode the provided string ''{0}'' as a matching rule because it included multiple occurrences of the {1} element."),
    ERR_MR_DECODE_NO_OPENING_PAREN("Unable to decode the provided string ''{0}'' as a matching rule definition because it does not start with an opening parenthesis."),
    ERR_MR_DECODE_NO_SYNTAX("Unable to decode the provided string ''{0}'' as a matching rule because it did not include a syntax OID."),
    ERR_MR_DECODE_UNEXPECTED_TOKEN("Unable to decode the provided string ''{0}'' as a matching rule because it included an unexpected token ''{1}''."),
    ERR_NF_DECODE_CLOSE_NOT_AT_END("Unable to decode the provided string ''{0}'' as a name form because the closing parenthesis was not at the end of the string."),
    ERR_NF_DECODE_DUP_EXT("Unable to decode the provided string ''{0}'' as a name form because it included multiple occurrences of the ''{1}'' extension."),
    ERR_NF_DECODE_EMPTY("An empty string cannot be decoded as a name form."),
    ERR_NF_DECODE_MULTIPLE_ELEMENTS("Unable to decode the provided string ''{0}'' as a name form because it included multiple occurrences of the {1} element."),
    ERR_NF_DECODE_NO_MUST("Unable to decode the provided string ''{0}'' as a name form because it did not include any required attributes."),
    ERR_NF_DECODE_NO_OC("Unable to decode the provided string ''{0}'' as a name form because it did not include a structural object class."),
    ERR_NF_DECODE_NO_OPENING_PAREN("Unable to decode the provided string ''{0}'' as a name form definition because it does not start with an opening parenthesis."),
    ERR_NF_DECODE_UNEXPECTED_TOKEN("Unable to decode the provided string ''{0}'' as a name form because it included an unexpected token ''{1}''."),
    ERR_OC_DECODE_CLOSE_NOT_AT_END("Unable to decode the provided string ''{0}'' as an object class because the closing parenthesis was not at the end of the string."),
    ERR_OC_DECODE_DUP_EXT("Unable to decode the provided string ''{0}'' as an object class because it included multiple occurrences of the ''{1}'' extension."),
    ERR_OC_DECODE_EMPTY("An empty string cannot be decoded as an object class."),
    ERR_OC_DECODE_MULTIPLE_ELEMENTS("Unable to decode the provided string ''{0}'' as an object class because it included multiple occurrences of the {1} element."),
    ERR_OC_DECODE_MULTIPLE_OC_TYPES("Unable to decode the provided string ''{0}'' as an object class because it included multiple object class type elements."),
    ERR_OC_DECODE_NO_OPENING_PAREN("Unable to decode the provided string ''{0}'' as an object class definition because it does not start with an opening parenthesis."),
    ERR_OC_DECODE_UNEXPECTED_TOKEN("Unable to decode the provided string ''{0}'' as an object class because it included an unexpected token ''{1}''."),
    ERR_SCHEMA_CANNOT_LOAD_DEFAULT_DEFINITIONS("An error occurred while attempting to load or parse a default set of standard schema elements:  {0}"),
    ERR_SCHEMA_ELEM_EMPTY_OID("Unable to parse string ''{0}'' as a schema element because an empty string was founded where a schema element name or OID was expected."),
    ERR_SCHEMA_ELEM_EMPTY_OID_LIST("Unable to parse string ''{0}'' as a schema element because it contained an empty OID list."),
    ERR_SCHEMA_ELEM_EMPTY_QUOTES("Unable to parse string ''{0}'' as a schema element because it contained an empty quoted string."),
    ERR_SCHEMA_ELEM_EMPTY_STRING_LIST("Unable to parse string ''{0}'' as a schema element because it contained an empty quoted-string list."),
    ERR_SCHEMA_ELEM_ENDS_WITH_BACKSLASH("Unable to parse string ''{0}'' as a schema element because the string ended with a backslash."),
    ERR_SCHEMA_ELEM_EXPECTED_QUOTE_OR_PAREN("Unable to parse string ''{0}'' as a schema element because either a single quote or a closing parenthesis was expected at position {1,number,0}."),
    ERR_SCHEMA_ELEM_EXPECTED_SINGLE_QUOTE("Unable to parse string ''{0}''  as a schema element because a single quote was expected at position {1,number,0}."),
    ERR_SCHEMA_ELEM_INVALID_HEX_CHAR("Unable to parse string ''{0}'' as a schema element because it contained an invalid hex character ''{1}'' at position {2,number,0}."),
    ERR_SCHEMA_ELEM_MISSING_HEX_CHAR("Unable to parse string ''{0}'' as a schema element because two hex digits were expected after a backslash but only one was found."),
    ERR_SCHEMA_ELEM_NO_CLOSING_PAREN("Unable to parse string ''{0}'' as a schema element because the end of the string was reached without finding an expected space after a closing single quote."),
    ERR_SCHEMA_ELEM_NO_SPACE_AFTER_OID("Unable to parse string ''{0}'' as a schema element because the end of the string was reached before finding a space to mark the end of an element name or OID."),
    ERR_SCHEMA_ELEM_NO_SPACE_AFTER_OID_LIST("Unable to parse string ''{0}'' as a schema element because the end of the string was reached without finding an expected space after an OID list."),
    ERR_SCHEMA_ELEM_NO_SPACE_AFTER_QUOTE("Unable to parse string ''{0}'' as a schema element because the end of the string was reached without finding an expected space after a closing single quote."),
    ERR_SCHEMA_ELEM_SKIP_SPACES_NO_CLOSE_PAREN("Unable to parse string ''{0}'' as a schema element because the end of the string was reached while skipping over spaces and not finding a closing parenthesis."),
    ERR_SCHEMA_ELEM_UNEXPECTED_CHAR_IN_OID("Unable to parse string ''{0}'' as a schema element because an unexpected character was found at position {1,number,0} while attempting to read an element name or OID."),
    ERR_SCHEMA_ELEM_UNEXPECTED_CHAR_IN_OID_LIST("Unable to parse string ''{0}'' as a schema element because it contained an unexpected character at position {1,number,0} in an OID list.");
    
    private static final ConcurrentHashMap<SchemaMessages, MessageFormat> MESSAGES = null;
    private static final ConcurrentHashMap<SchemaMessages, String> MESSAGE_STRINGS = null;
    private static final ResourceBundle RESOURCE_BUNDLE = null;
    private final String defaultText;

    private SchemaMessages(String str) {
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
