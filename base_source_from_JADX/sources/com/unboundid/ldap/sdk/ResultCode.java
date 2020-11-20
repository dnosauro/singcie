package com.unboundid.ldap.sdk;

import java.io.Serializable;
import java.util.HashMap;

public final class ResultCode implements Serializable {
    public static final ResultCode ADMIN_LIMIT_EXCEEDED = new ResultCode(LDAPMessages.INFO_RC_ADMIN_LIMIT_EXCEEDED.get(), 11);
    public static final int ADMIN_LIMIT_EXCEEDED_INT_VALUE = 11;
    public static final ResultCode AFFECTS_MULTIPLE_DSAS = new ResultCode(LDAPMessages.INFO_RC_AFFECTS_MULTIPLE_DSAS.get(), 71);
    public static final int AFFECTS_MULTIPLE_DSAS_INT_VALUE = 71;
    public static final ResultCode ALIAS_DEREFERENCING_PROBLEM = new ResultCode(LDAPMessages.INFO_RC_ALIAS_DEREFERENCING_PROBLEM.get(), 36);
    public static final int ALIAS_DEREFERENCING_PROBLEM_INT_VALUE = 36;
    public static final ResultCode ALIAS_PROBLEM = new ResultCode(LDAPMessages.INFO_RC_ALIAS_PROBLEM.get(), 33);
    public static final int ALIAS_PROBLEM_INT_VALUE = 33;
    public static final ResultCode ASSERTION_FAILED = new ResultCode(LDAPMessages.INFO_RC_ASSERTION_FAILED.get(), 122);
    public static final int ASSERTION_FAILED_INT_VALUE = 122;
    public static final ResultCode ATTRIBUTE_OR_VALUE_EXISTS = new ResultCode(LDAPMessages.INFO_RC_ATTRIBUTE_OR_VALUE_EXISTS.get(), 20);
    public static final int ATTRIBUTE_OR_VALUE_EXISTS_INT_VALUE = 20;
    public static final ResultCode AUTHORIZATION_DENIED = new ResultCode(LDAPMessages.INFO_RC_AUTHORIZATION_DENIED.get(), 123);
    public static final int AUTHORIZATION_DENIED_INT_VALUE = 123;
    public static final ResultCode AUTH_METHOD_NOT_SUPPORTED = new ResultCode(LDAPMessages.INFO_RC_AUTH_METHOD_NOT_SUPPORTED.get(), 7);
    public static final int AUTH_METHOD_NOT_SUPPORTED_INT_VALUE = 7;
    public static final ResultCode AUTH_UNKNOWN = new ResultCode(LDAPMessages.INFO_RC_AUTH_UNKNOWN.get(), 86);
    public static final int AUTH_UNKNOWN_INT_VALUE = 86;
    public static final ResultCode BUSY = new ResultCode(LDAPMessages.INFO_RC_BUSY.get(), 51);
    public static final int BUSY_INT_VALUE = 51;
    public static final ResultCode CANCELED = new ResultCode(LDAPMessages.INFO_RC_CANCELED.get(), 118);
    public static final int CANCELED_INT_VALUE = 118;
    public static final ResultCode CANNOT_CANCEL = new ResultCode(LDAPMessages.INFO_RC_CANNOT_CANCEL.get(), 121);
    public static final int CANNOT_CANCEL_INT_VALUE = 121;
    public static final ResultCode CLIENT_LOOP = new ResultCode(LDAPMessages.INFO_RC_CLIENT_LOOP.get(), 96);
    public static final int CLIENT_LOOP_INT_VALUE = 96;
    public static final ResultCode COMPARE_FALSE = new ResultCode(LDAPMessages.INFO_RC_COMPARE_FALSE.get(), 5);
    public static final int COMPARE_FALSE_INT_VALUE = 5;
    public static final ResultCode COMPARE_TRUE = new ResultCode(LDAPMessages.INFO_RC_COMPARE_TRUE.get(), 6);
    public static final int COMPARE_TRUE_INT_VALUE = 6;
    public static final ResultCode CONFIDENTIALITY_REQUIRED = new ResultCode(LDAPMessages.INFO_RC_CONFIDENTIALITY_REQUIRED.get(), 13);
    public static final int CONFIDENTIALITY_REQUIRED_INT_VALUE = 13;
    public static final ResultCode CONNECT_ERROR = new ResultCode(LDAPMessages.INFO_RC_CONNECT_ERROR.get(), 91);
    public static final int CONNECT_ERROR_INT_VALUE = 91;
    public static final ResultCode CONSTRAINT_VIOLATION = new ResultCode(LDAPMessages.INFO_RC_CONSTRAINT_VIOLATION.get(), 19);
    public static final int CONSTRAINT_VIOLATION_INT_VALUE = 19;
    public static final ResultCode CONTROL_NOT_FOUND = new ResultCode(LDAPMessages.INFO_RC_CONTROL_NOT_FOUND.get(), 93);
    public static final int CONTROL_NOT_FOUND_INT_VALUE = 93;
    public static final ResultCode DECODING_ERROR = new ResultCode(LDAPMessages.INFO_RC_DECODING_ERROR.get(), 84);
    public static final int DECODING_ERROR_INT_VALUE = 84;
    public static final ResultCode ENCODING_ERROR = new ResultCode(LDAPMessages.INFO_RC_ENCODING_ERROR.get(), 83);
    public static final int ENCODING_ERROR_INT_VALUE = 83;
    public static final ResultCode ENTRY_ALREADY_EXISTS = new ResultCode(LDAPMessages.INFO_RC_ENTRY_ALREADY_EXISTS.get(), 68);
    public static final int ENTRY_ALREADY_EXISTS_INT_VALUE = 68;
    public static final ResultCode E_SYNC_REFRESH_REQUIRED = new ResultCode(LDAPMessages.INFO_RC_E_SYNC_REFRESH_REQUIRED.get(), 4096);
    public static final int E_SYNC_REFRESH_REQUIRED_INT_VALUE = 4096;
    public static final ResultCode FILTER_ERROR = new ResultCode(LDAPMessages.INFO_RC_FILTER_ERROR.get(), 87);
    public static final int FILTER_ERROR_INT_VALUE = 87;
    public static final ResultCode INAPPROPRIATE_AUTHENTICATION = new ResultCode(LDAPMessages.INFO_RC_INAPPROPRIATE_AUTHENTICATION.get(), 48);
    public static final int INAPPROPRIATE_AUTHENTICATION_INT_VALUE = 48;
    public static final ResultCode INAPPROPRIATE_MATCHING = new ResultCode(LDAPMessages.INFO_RC_INAPPROPRIATE_MATCHING.get(), 18);
    public static final int INAPPROPRIATE_MATCHING_INT_VALUE = 18;
    public static final ResultCode INSUFFICIENT_ACCESS_RIGHTS = new ResultCode(LDAPMessages.INFO_RC_INSUFFICIENT_ACCESS_RIGHTS.get(), 50);
    public static final int INSUFFICIENT_ACCESS_RIGHTS_INT_VALUE = 50;
    public static final ResultCode INTERACTIVE_TRANSACTION_ABORTED = new ResultCode(LDAPMessages.INFO_RC_INTERACTIVE_TRANSACTION_ABORTED.get(), INTERACTIVE_TRANSACTION_ABORTED_INT_VALUE);
    public static final int INTERACTIVE_TRANSACTION_ABORTED_INT_VALUE = 30221001;
    public static final ResultCode INVALID_ATTRIBUTE_SYNTAX = new ResultCode(LDAPMessages.INFO_RC_INVALID_ATTRIBUTE_SYNTAX.get(), 21);
    public static final int INVALID_ATTRIBUTE_SYNTAX_INT_VALUE = 21;
    public static final ResultCode INVALID_CREDENTIALS = new ResultCode(LDAPMessages.INFO_RC_INVALID_CREDENTIALS.get(), 49);
    public static final int INVALID_CREDENTIALS_INT_VALUE = 49;
    public static final ResultCode INVALID_DN_SYNTAX = new ResultCode(LDAPMessages.INFO_RC_INVALID_DN_SYNTAX.get(), 34);
    public static final int INVALID_DN_SYNTAX_INT_VALUE = 34;
    public static final ResultCode LOCAL_ERROR = new ResultCode(LDAPMessages.INFO_RC_LOCAL_ERROR.get(), 82);
    public static final int LOCAL_ERROR_INT_VALUE = 82;
    public static final ResultCode LOOP_DETECT = new ResultCode(LDAPMessages.INFO_RC_LOOP_DETECT.get(), 54);
    public static final int LOOP_DETECT_INT_VALUE = 54;
    public static final ResultCode MORE_RESULTS_TO_RETURN = new ResultCode(LDAPMessages.INFO_RC_MORE_RESULTS_TO_RETURN.get(), 95);
    public static final int MORE_RESULTS_TO_RETURN_INT_VALUE = 95;
    public static final ResultCode NAMING_VIOLATION = new ResultCode(LDAPMessages.INFO_RC_NAMING_VIOLATION.get(), 64);
    public static final int NAMING_VIOLATION_INT_VALUE = 64;
    public static final ResultCode NOT_ALLOWED_ON_NONLEAF = new ResultCode(LDAPMessages.INFO_RC_NOT_ALLOWED_ON_NONLEAF.get(), 66);
    public static final int NOT_ALLOWED_ON_NONLEAF_INT_VALUE = 66;
    public static final ResultCode NOT_ALLOWED_ON_RDN = new ResultCode(LDAPMessages.INFO_RC_NOT_ALLOWED_ON_RDN.get(), 67);
    public static final int NOT_ALLOWED_ON_RDN_INT_VALUE = 67;
    public static final ResultCode NOT_SUPPORTED = new ResultCode(LDAPMessages.INFO_RC_NOT_SUPPORTED.get(), 92);
    public static final int NOT_SUPPORTED_INT_VALUE = 92;
    public static final ResultCode NO_MEMORY = new ResultCode(LDAPMessages.INFO_RC_NO_MEMORY.get(), 90);
    public static final int NO_MEMORY_INT_VALUE = 90;
    public static final ResultCode NO_OPERATION = new ResultCode(LDAPMessages.INFO_RC_NO_OPERATION.get(), NO_OPERATION_INT_VALUE);
    public static final int NO_OPERATION_INT_VALUE = 16654;
    public static final ResultCode NO_RESULTS_RETURNED = new ResultCode(LDAPMessages.INFO_RC_NO_RESULTS_RETURNED.get(), 94);
    public static final int NO_RESULTS_RETURNED_INT_VALUE = 94;
    public static final ResultCode NO_SUCH_ATTRIBUTE = new ResultCode(LDAPMessages.INFO_RC_NO_SUCH_ATTRIBUTE.get(), 16);
    public static final int NO_SUCH_ATTRIBUTE_INT_VALUE = 16;
    public static final ResultCode NO_SUCH_OBJECT = new ResultCode(LDAPMessages.INFO_RC_NO_SUCH_OBJECT.get(), 32);
    public static final int NO_SUCH_OBJECT_INT_VALUE = 32;
    public static final ResultCode NO_SUCH_OPERATION = new ResultCode(LDAPMessages.INFO_RC_NO_SUCH_OPERATION.get(), 119);
    public static final int NO_SUCH_OPERATION_INT_VALUE = 119;
    public static final ResultCode OBJECT_CLASS_MODS_PROHIBITED = new ResultCode(LDAPMessages.INFO_RC_OBJECT_CLASS_MODS_PROHIBITED.get(), 69);
    public static final int OBJECT_CLASS_MODS_PROHIBITED_INT_VALUE = 69;
    public static final ResultCode OBJECT_CLASS_VIOLATION = new ResultCode(LDAPMessages.INFO_RC_OBJECT_CLASS_VIOLATION.get(), 65);
    public static final int OBJECT_CLASS_VIOLATION_INT_VALUE = 65;
    public static final ResultCode OFFSET_RANGE_ERROR = new ResultCode(LDAPMessages.INFO_RC_OFFSET_RANGE_ERROR.get(), 61);
    public static final int OFFSET_RANGE_ERROR_INT_VALUE = 61;
    public static final ResultCode OPERATIONS_ERROR = new ResultCode(LDAPMessages.INFO_RC_OPERATIONS_ERROR.get(), 1);
    public static final int OPERATIONS_ERROR_INT_VALUE = 1;
    public static final ResultCode OTHER = new ResultCode(LDAPMessages.INFO_RC_OTHER.get(), 80);
    public static final int OTHER_INT_VALUE = 80;
    public static final ResultCode PARAM_ERROR = new ResultCode(LDAPMessages.INFO_RC_PARAM_ERROR.get(), 89);
    public static final int PARAM_ERROR_INT_VALUE = 89;
    public static final ResultCode PROTOCOL_ERROR = new ResultCode(LDAPMessages.INFO_RC_PROTOCOL_ERROR.get(), 2);
    public static final int PROTOCOL_ERROR_INT_VALUE = 2;
    public static final ResultCode REFERRAL = new ResultCode(LDAPMessages.INFO_RC_REFERRAL.get(), 10);
    public static final int REFERRAL_INT_VALUE = 10;
    public static final ResultCode REFERRAL_LIMIT_EXCEEDED = new ResultCode(LDAPMessages.INFO_RC_REFERRAL_LIMIT_EXCEEDED.get(), 97);
    public static final int REFERRAL_LIMIT_EXCEEDED_INT_VALUE = 97;
    public static final ResultCode SASL_BIND_IN_PROGRESS = new ResultCode(LDAPMessages.INFO_RC_SASL_BIND_IN_PROGRESS.get(), 14);
    public static final int SASL_BIND_IN_PROGRESS_INT_VALUE = 14;
    public static final ResultCode SERVER_DOWN = new ResultCode(LDAPMessages.INFO_RC_SERVER_DOWN.get(), 81);
    public static final int SERVER_DOWN_INT_VALUE = 81;
    public static final ResultCode SIZE_LIMIT_EXCEEDED = new ResultCode(LDAPMessages.INFO_RC_SIZE_LIMIT_EXCEEDED.get(), 4);
    public static final int SIZE_LIMIT_EXCEEDED_INT_VALUE = 4;
    public static final ResultCode SORT_CONTROL_MISSING = new ResultCode(LDAPMessages.INFO_RC_SORT_CONTROL_MISSING.get(), 60);
    public static final int SORT_CONTROL_MISSING_INT_VALUE = 60;
    public static final ResultCode STRONG_AUTH_REQUIRED = new ResultCode(LDAPMessages.INFO_RC_STRONG_AUTH_REQUIRED.get(), 8);
    public static final int STRONG_AUTH_REQUIRED_INT_VALUE = 8;
    public static final ResultCode SUCCESS = new ResultCode(LDAPMessages.INFO_RC_SUCCESS.get(), 0);
    public static final int SUCCESS_INT_VALUE = 0;
    public static final ResultCode TIMEOUT = new ResultCode(LDAPMessages.INFO_RC_TIMEOUT.get(), 85);
    public static final int TIMEOUT_INT_VALUE = 85;
    public static final ResultCode TIME_LIMIT_EXCEEDED = new ResultCode(LDAPMessages.INFO_RC_TIME_LIMIT_EXCEEDED.get(), 3);
    public static final int TIME_LIMIT_EXCEEDED_INT_VALUE = 3;
    public static final ResultCode TOO_LATE = new ResultCode(LDAPMessages.INFO_RC_TOO_LATE.get(), 120);
    public static final int TOO_LATE_INT_VALUE = 120;
    public static final ResultCode UNAVAILABLE = new ResultCode(LDAPMessages.INFO_RC_UNAVAILABLE.get(), 52);
    public static final ResultCode UNAVAILABLE_CRITICAL_EXTENSION = new ResultCode(LDAPMessages.INFO_RC_UNAVAILABLE_CRITICAL_EXTENSION.get(), 12);
    public static final int UNAVAILABLE_CRITICAL_EXTENSION_INT_VALUE = 12;
    public static final int UNAVAILABLE_INT_VALUE = 52;
    public static final ResultCode UNDEFINED_ATTRIBUTE_TYPE = new ResultCode(LDAPMessages.INFO_RC_UNDEFINED_ATTRIBUTE_TYPE.get(), 17);
    public static final int UNDEFINED_ATTRIBUTE_TYPE_INT_VALUE = 17;
    private static final HashMap<Integer, ResultCode> UNDEFINED_RESULT_CODES = new HashMap<>();
    public static final ResultCode UNWILLING_TO_PERFORM = new ResultCode(LDAPMessages.INFO_RC_UNWILLING_TO_PERFORM.get(), 53);
    public static final int UNWILLING_TO_PERFORM_INT_VALUE = 53;
    public static final ResultCode USER_CANCELED = new ResultCode(LDAPMessages.INFO_RC_USER_CANCELED.get(), 88);
    public static final int USER_CANCELED_INT_VALUE = 88;
    public static final ResultCode VIRTUAL_LIST_VIEW_ERROR = new ResultCode(LDAPMessages.INFO_RC_VIRTUAL_LIST_VIEW_ERR0R.get(), 76);
    public static final int VIRTUAL_LIST_VIEW_ERROR_INT_VALUE = 76;
    private static final long serialVersionUID = 7609311304252378100L;
    private final int intValue;
    private final String name;
    private final String stringRepresentation;

    private ResultCode(int i) {
        this.intValue = i;
        this.name = String.valueOf(i);
        this.stringRepresentation = this.name;
    }

    private ResultCode(String str, int i) {
        this.name = str;
        this.intValue = i;
        this.stringRepresentation = i + " (" + str + ')';
    }

    public static boolean isClientSideResultCode(ResultCode resultCode) {
        switch (resultCode.intValue()) {
            case 81:
            case 82:
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
            case 92:
            case 93:
            case 94:
            case 95:
            case 96:
            case 97:
                return true;
            default:
                return false;
        }
    }

    public static boolean isConnectionUsable(ResultCode resultCode) {
        int intValue2 = resultCode.intValue();
        switch (intValue2) {
            case 1:
            case 2:
                return false;
            default:
                switch (intValue2) {
                    case 51:
                    case 52:
                    case 53:
                        return false;
                    default:
                        switch (intValue2) {
                            case 80:
                            case 81:
                            case 82:
                            case 83:
                            case 84:
                            case 85:
                                return false;
                            default:
                                switch (intValue2) {
                                    case 90:
                                    case 91:
                                        return false;
                                    default:
                                        return true;
                                }
                        }
                }
        }
    }

    public static ResultCode valueOf(int i) {
        return valueOf(i, (String) null);
    }

    public static ResultCode valueOf(int i, String str) {
        ResultCode resultCode;
        switch (i) {
            case 0:
                return SUCCESS;
            case 1:
                return OPERATIONS_ERROR;
            case 2:
                return PROTOCOL_ERROR;
            case 3:
                return TIME_LIMIT_EXCEEDED;
            case 4:
                return SIZE_LIMIT_EXCEEDED;
            case 5:
                return COMPARE_FALSE;
            case 6:
                return COMPARE_TRUE;
            case 7:
                return AUTH_METHOD_NOT_SUPPORTED;
            case 8:
                return STRONG_AUTH_REQUIRED;
            default:
                switch (i) {
                    case 10:
                        return REFERRAL;
                    case 11:
                        return ADMIN_LIMIT_EXCEEDED;
                    case 12:
                        return UNAVAILABLE_CRITICAL_EXTENSION;
                    case 13:
                        return CONFIDENTIALITY_REQUIRED;
                    case 14:
                        return SASL_BIND_IN_PROGRESS;
                    default:
                        switch (i) {
                            case 16:
                                return NO_SUCH_ATTRIBUTE;
                            case 17:
                                return UNDEFINED_ATTRIBUTE_TYPE;
                            case 18:
                                return INAPPROPRIATE_MATCHING;
                            case 19:
                                return CONSTRAINT_VIOLATION;
                            case 20:
                                return ATTRIBUTE_OR_VALUE_EXISTS;
                            case 21:
                                return INVALID_ATTRIBUTE_SYNTAX;
                            default:
                                switch (i) {
                                    case 32:
                                        return NO_SUCH_OBJECT;
                                    case 33:
                                        return ALIAS_PROBLEM;
                                    case 34:
                                        return INVALID_DN_SYNTAX;
                                    default:
                                        switch (i) {
                                            case 48:
                                                return INAPPROPRIATE_AUTHENTICATION;
                                            case 49:
                                                return INVALID_CREDENTIALS;
                                            case 50:
                                                return INSUFFICIENT_ACCESS_RIGHTS;
                                            case 51:
                                                return BUSY;
                                            case 52:
                                                return UNAVAILABLE;
                                            case 53:
                                                return UNWILLING_TO_PERFORM;
                                            case 54:
                                                return LOOP_DETECT;
                                            default:
                                                switch (i) {
                                                    case 60:
                                                        return SORT_CONTROL_MISSING;
                                                    case 61:
                                                        return OFFSET_RANGE_ERROR;
                                                    default:
                                                        switch (i) {
                                                            case 64:
                                                                return NAMING_VIOLATION;
                                                            case 65:
                                                                return OBJECT_CLASS_VIOLATION;
                                                            case 66:
                                                                return NOT_ALLOWED_ON_NONLEAF;
                                                            case 67:
                                                                return NOT_ALLOWED_ON_RDN;
                                                            case 68:
                                                                return ENTRY_ALREADY_EXISTS;
                                                            case 69:
                                                                return OBJECT_CLASS_MODS_PROHIBITED;
                                                            default:
                                                                switch (i) {
                                                                    case 80:
                                                                        return OTHER;
                                                                    case 81:
                                                                        return SERVER_DOWN;
                                                                    case 82:
                                                                        return LOCAL_ERROR;
                                                                    case 83:
                                                                        return ENCODING_ERROR;
                                                                    case 84:
                                                                        return DECODING_ERROR;
                                                                    case 85:
                                                                        return TIMEOUT;
                                                                    case 86:
                                                                        return AUTH_UNKNOWN;
                                                                    case 87:
                                                                        return FILTER_ERROR;
                                                                    case 88:
                                                                        return USER_CANCELED;
                                                                    case 89:
                                                                        return PARAM_ERROR;
                                                                    case 90:
                                                                        return NO_MEMORY;
                                                                    case 91:
                                                                        return CONNECT_ERROR;
                                                                    case 92:
                                                                        return NOT_SUPPORTED;
                                                                    case 93:
                                                                        return CONTROL_NOT_FOUND;
                                                                    case 94:
                                                                        return NO_RESULTS_RETURNED;
                                                                    case 95:
                                                                        return MORE_RESULTS_TO_RETURN;
                                                                    case 96:
                                                                        return CLIENT_LOOP;
                                                                    case 97:
                                                                        return REFERRAL_LIMIT_EXCEEDED;
                                                                    default:
                                                                        switch (i) {
                                                                            case 118:
                                                                                return CANCELED;
                                                                            case 119:
                                                                                return NO_SUCH_OPERATION;
                                                                            case 120:
                                                                                return TOO_LATE;
                                                                            case 121:
                                                                                return CANNOT_CANCEL;
                                                                            case 122:
                                                                                return ASSERTION_FAILED;
                                                                            case 123:
                                                                                return AUTHORIZATION_DENIED;
                                                                            default:
                                                                                switch (i) {
                                                                                    case 36:
                                                                                        return ALIAS_DEREFERENCING_PROBLEM;
                                                                                    case 71:
                                                                                        return AFFECTS_MULTIPLE_DSAS;
                                                                                    case 76:
                                                                                        return VIRTUAL_LIST_VIEW_ERROR;
                                                                                    case 4096:
                                                                                        return E_SYNC_REFRESH_REQUIRED;
                                                                                    case NO_OPERATION_INT_VALUE /*16654*/:
                                                                                        return NO_OPERATION;
                                                                                    case INTERACTIVE_TRANSACTION_ABORTED_INT_VALUE /*30221001*/:
                                                                                        return INTERACTIVE_TRANSACTION_ABORTED;
                                                                                    default:
                                                                                        synchronized (UNDEFINED_RESULT_CODES) {
                                                                                            resultCode = UNDEFINED_RESULT_CODES.get(Integer.valueOf(i));
                                                                                            if (resultCode == null) {
                                                                                                resultCode = str == null ? new ResultCode(i) : new ResultCode(str, i);
                                                                                                UNDEFINED_RESULT_CODES.put(Integer.valueOf(i), resultCode);
                                                                                            }
                                                                                        }
                                                                                        return resultCode;
                                                                                }
                                                                        }
                                                                }
                                                        }
                                                }
                                        }
                                }
                        }
                }
        }
    }

    public static ResultCode[] values() {
        return new ResultCode[]{SUCCESS, OPERATIONS_ERROR, PROTOCOL_ERROR, TIME_LIMIT_EXCEEDED, SIZE_LIMIT_EXCEEDED, COMPARE_FALSE, COMPARE_TRUE, AUTH_METHOD_NOT_SUPPORTED, STRONG_AUTH_REQUIRED, REFERRAL, ADMIN_LIMIT_EXCEEDED, UNAVAILABLE_CRITICAL_EXTENSION, CONFIDENTIALITY_REQUIRED, SASL_BIND_IN_PROGRESS, NO_SUCH_ATTRIBUTE, UNDEFINED_ATTRIBUTE_TYPE, INAPPROPRIATE_MATCHING, CONSTRAINT_VIOLATION, ATTRIBUTE_OR_VALUE_EXISTS, INVALID_ATTRIBUTE_SYNTAX, NO_SUCH_OBJECT, ALIAS_PROBLEM, INVALID_DN_SYNTAX, ALIAS_DEREFERENCING_PROBLEM, INAPPROPRIATE_AUTHENTICATION, INVALID_CREDENTIALS, INSUFFICIENT_ACCESS_RIGHTS, BUSY, UNAVAILABLE, UNWILLING_TO_PERFORM, LOOP_DETECT, SORT_CONTROL_MISSING, OFFSET_RANGE_ERROR, NAMING_VIOLATION, OBJECT_CLASS_VIOLATION, NOT_ALLOWED_ON_NONLEAF, NOT_ALLOWED_ON_RDN, ENTRY_ALREADY_EXISTS, OBJECT_CLASS_MODS_PROHIBITED, AFFECTS_MULTIPLE_DSAS, VIRTUAL_LIST_VIEW_ERROR, OTHER, SERVER_DOWN, LOCAL_ERROR, ENCODING_ERROR, DECODING_ERROR, TIMEOUT, AUTH_UNKNOWN, FILTER_ERROR, USER_CANCELED, PARAM_ERROR, NO_MEMORY, CONNECT_ERROR, NOT_SUPPORTED, CONTROL_NOT_FOUND, NO_RESULTS_RETURNED, MORE_RESULTS_TO_RETURN, CLIENT_LOOP, REFERRAL_LIMIT_EXCEEDED, CANCELED, NO_SUCH_OPERATION, TOO_LATE, CANNOT_CANCEL, ASSERTION_FAILED, AUTHORIZATION_DENIED, E_SYNC_REFRESH_REQUIRED, NO_OPERATION, INTERACTIVE_TRANSACTION_ABORTED};
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        return (obj instanceof ResultCode) && this.intValue == ((ResultCode) obj).intValue;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return this.intValue;
    }

    public int intValue() {
        return this.intValue;
    }

    public boolean isClientSideResultCode() {
        return isClientSideResultCode(this);
    }

    public boolean isConnectionUsable() {
        return isConnectionUsable(this);
    }

    public String toString() {
        return this.stringRepresentation;
    }
}
