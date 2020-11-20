package com.unboundid.ldap.sdk;

import com.unboundid.util.StaticUtils;

public enum DisconnectType {
    UNBIND(LDAPMessages.INFO_DISCONNECT_TYPE_UNBIND.get(), ResultCode.LOCAL_ERROR),
    BIND_FAILED(LDAPMessages.INFO_DISCONNECT_TYPE_BIND_FAILED.get(), ResultCode.CONNECT_ERROR),
    RECONNECT(LDAPMessages.INFO_DISCONNECT_TYPE_RECONNECT.get(), ResultCode.SERVER_DOWN),
    REFERRAL(LDAPMessages.INFO_DISCONNECT_TYPE_REFERRAL.get(), ResultCode.LOCAL_ERROR),
    SERVER_CLOSED_WITH_NOTICE(LDAPMessages.INFO_DISCONNECT_TYPE_SERVER_CLOSED_WITH_NOTICE.get(), ResultCode.SERVER_DOWN),
    SERVER_CLOSED_WITHOUT_NOTICE(LDAPMessages.INFO_DISCONNECT_TYPE_SERVER_CLOSED_WITHOUT_NOTICE.get(), ResultCode.SERVER_DOWN),
    IO_ERROR(LDAPMessages.INFO_DISCONNECT_TYPE_IO_ERROR.get(), ResultCode.SERVER_DOWN),
    DECODE_ERROR(LDAPMessages.INFO_DISCONNECT_TYPE_DECODE_ERROR.get(), ResultCode.DECODING_ERROR),
    LOCAL_ERROR(LDAPMessages.INFO_DISCONNECT_TYPE_LOCAL_ERROR.get(), ResultCode.LOCAL_ERROR),
    SECURITY_PROBLEM(LDAPMessages.INFO_DISCONNECT_TYPE_SECURITY_PROBLEM.get(), ResultCode.LOCAL_ERROR),
    POOL_CLOSED(LDAPMessages.INFO_DISCONNECT_TYPE_POOL_CLOSED.get(), ResultCode.LOCAL_ERROR),
    POOL_CREATION_FAILURE(LDAPMessages.INFO_DISCONNECT_TYPE_POOL_CREATION_FAILURE.get(), ResultCode.CONNECT_ERROR),
    POOLED_CONNECTION_DEFUNCT(LDAPMessages.INFO_DISCONNECT_TYPE_POOLED_CONNECTION_DEFUNCT.get(), ResultCode.SERVER_DOWN),
    POOLED_CONNECTION_EXPIRED(LDAPMessages.INFO_DISCONNECT_TYPE_POOLED_CONNECTION_EXPIRED.get(), ResultCode.LOCAL_ERROR),
    POOLED_CONNECTION_UNNEEDED(LDAPMessages.INFO_DISCONNECT_TYPE_POOLED_CONNECTION_UNNEEDED.get(), ResultCode.LOCAL_ERROR),
    UNKNOWN(LDAPMessages.INFO_DISCONNECT_TYPE_UNKNOWN.get(), ResultCode.LOCAL_ERROR),
    CLOSED_BY_FINALIZER(LDAPMessages.INFO_DISCONNECT_TYPE_CLOSED_BY_FINALIZER.get(), ResultCode.LOCAL_ERROR),
    OTHER(LDAPMessages.INFO_DISCONNECT_TYPE_OTHER.get(), ResultCode.LOCAL_ERROR);
    
    private final String description;
    private final ResultCode resultCode;

    private DisconnectType(String str, ResultCode resultCode2) {
        this.description = str;
        this.resultCode = resultCode2;
    }

    public static DisconnectType forName(String str) {
        String lowerCase = StaticUtils.toLowerCase(str);
        if (lowerCase.equals("unbind")) {
            return UNBIND;
        }
        if (lowerCase.equals("bind_failed")) {
            return BIND_FAILED;
        }
        if (lowerCase.equals("reconnect")) {
            return RECONNECT;
        }
        if (lowerCase.equals("referral")) {
            return REFERRAL;
        }
        if (lowerCase.equals("server_closed_with_notice")) {
            return SERVER_CLOSED_WITH_NOTICE;
        }
        if (lowerCase.equals("server_closed_without_notice")) {
            return SERVER_CLOSED_WITHOUT_NOTICE;
        }
        if (lowerCase.equals("io_error")) {
            return IO_ERROR;
        }
        if (lowerCase.equals("decode_error")) {
            return DECODE_ERROR;
        }
        if (lowerCase.equals("local_error")) {
            return LOCAL_ERROR;
        }
        if (lowerCase.equals("security_problem")) {
            return SECURITY_PROBLEM;
        }
        if (lowerCase.equals("pool_closed")) {
            return POOL_CLOSED;
        }
        if (lowerCase.equals("pool_creation_failure")) {
            return POOL_CREATION_FAILURE;
        }
        if (lowerCase.equals("pooled_connection_defunct")) {
            return POOLED_CONNECTION_DEFUNCT;
        }
        if (lowerCase.equals("pooled_connection_expired")) {
            return POOLED_CONNECTION_EXPIRED;
        }
        if (lowerCase.equals("pooled_connection_unneeded")) {
            return POOLED_CONNECTION_UNNEEDED;
        }
        if (lowerCase.equals("unknown")) {
            return UNKNOWN;
        }
        if (lowerCase.equals("closed_by_finalizer")) {
            return CLOSED_BY_FINALIZER;
        }
        if (lowerCase.equals("other")) {
            return OTHER;
        }
        return null;
    }

    public static boolean isExpected(DisconnectType disconnectType) {
        switch (disconnectType) {
            case UNBIND:
            case RECONNECT:
            case REFERRAL:
            case POOL_CLOSED:
            case POOLED_CONNECTION_DEFUNCT:
            case POOLED_CONNECTION_EXPIRED:
            case POOLED_CONNECTION_UNNEEDED:
            case CLOSED_BY_FINALIZER:
                return true;
            default:
                return false;
        }
    }

    public String getDescription() {
        return this.description;
    }

    public ResultCode getResultCode() {
        return this.resultCode;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("DisconnectType(name='");
        sb.append(name());
        sb.append("', resultCode='");
        sb.append(this.resultCode);
        sb.append("', description='");
        sb.append(this.description);
        sb.append("')");
    }
}
