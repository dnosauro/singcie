package com.unboundid.util;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1Element;
import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.ldap.sdk.DisconnectType;
import com.unboundid.ldap.sdk.Entry;
import com.unboundid.ldap.sdk.LDAPConnection;
import com.unboundid.ldap.sdk.LDAPRequest;
import com.unboundid.ldap.sdk.Version;
import com.unboundid.ldif.LDIFRecord;
import java.io.Serializable;
import java.util.EnumSet;
import java.util.Properties;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.p172io.FilenameUtils;

public final class Debug implements Serializable {
    public static final String LOGGER_NAME = "com.unboundid.ldap.sdk";
    public static final String PROPERTY_DEBUG_ENABLED = "com.unboundid.ldap.sdk.debug.enabled";
    public static final String PROPERTY_DEBUG_LEVEL = "com.unboundid.ldap.sdk.debug.level";
    public static final String PROPERTY_DEBUG_TYPE = "com.unboundid.ldap.sdk.debug.type";
    public static final String PROPERTY_INCLUDE_STACK_TRACE = "com.unboundid.ldap.sdk.debug.includeStackTrace";
    private static boolean debugEnabled = false;
    private static EnumSet<DebugType> debugTypes = null;
    private static boolean includeStackTrace = false;
    private static final Logger logger = Logger.getLogger(LOGGER_NAME);
    private static final long serialVersionUID = -6079754380415146030L;

    static {
        initialize(System.getProperties());
    }

    private Debug() {
    }

    private static void addCommonHeader(StringBuilder sb, Level level) {
        sb.append("level=\"");
        sb.append(level.getName());
        sb.append("\" threadID=");
        sb.append(Thread.currentThread().getId());
        sb.append(" threadName=\"");
        sb.append(Thread.currentThread().getName());
        if (includeStackTrace) {
            sb.append("\" calledFrom=\"");
            boolean z = false;
            boolean z2 = false;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                if (stackTraceElement.getClassName().equals(Debug.class.getName())) {
                    z = true;
                } else if (z) {
                    if (z2) {
                        sb.append(" / ");
                    }
                    sb.append(stackTraceElement.getMethodName());
                    sb.append('(');
                    sb.append(stackTraceElement.getFileName());
                    int lineNumber = stackTraceElement.getLineNumber();
                    if (lineNumber > 0) {
                        sb.append(':');
                        sb.append(lineNumber);
                    } else if (stackTraceElement.isNativeMethod()) {
                        sb.append(":native");
                    }
                    sb.append(')');
                    z2 = true;
                }
            }
        }
        sb.append("\" revision=");
        sb.append(Version.REVISION_NUMBER);
        sb.append(' ');
    }

    public static void debug(Level level, DebugType debugType, String str) {
        if (debugEnabled && debugTypes.contains(debugType)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, level);
            sb.append("message=\"");
            sb.append(str);
            sb.append('\"');
            logger.log(level, sb.toString());
        }
    }

    public static void debug(Level level, DebugType debugType, String str, Throwable th) {
        if (debugEnabled && debugTypes.contains(debugType)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, level);
            sb.append("message=\"");
            sb.append(str);
            sb.append('\"');
            sb.append(" exception=\"");
            StaticUtils.getStackTrace(th, sb);
            sb.append('\"');
            logger.log(level, sb.toString(), th);
        }
    }

    public static void debugASN1Read(ASN1Element aSN1Element) {
        if (debugEnabled && debugTypes.contains(DebugType.ASN1)) {
            debugASN1Read(Level.INFO, aSN1Element);
        }
    }

    public static void debugASN1Read(Level level, ASN1Element aSN1Element) {
        if (debugEnabled && debugTypes.contains(DebugType.ASN1)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, level);
            sb.append("readASN1Element=\"");
            aSN1Element.toString(sb);
            sb.append('\"');
            logger.log(level, sb.toString());
        }
    }

    public static void debugASN1Write(ASN1Buffer aSN1Buffer) {
        if (debugEnabled && debugTypes.contains(DebugType.ASN1)) {
            debugASN1Write(Level.INFO, aSN1Buffer);
        }
    }

    public static void debugASN1Write(ASN1Element aSN1Element) {
        if (debugEnabled && debugTypes.contains(DebugType.ASN1)) {
            debugASN1Write(Level.INFO, aSN1Element);
        }
    }

    public static void debugASN1Write(Level level, ASN1Buffer aSN1Buffer) {
        if (debugEnabled && debugTypes.contains(DebugType.ASN1)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, level);
            sb.append("writingASN1Element=\"");
            StaticUtils.toHex(aSN1Buffer.toByteArray(), sb);
            sb.append('\"');
            logger.log(level, sb.toString());
        }
    }

    public static void debugASN1Write(Level level, ASN1Element aSN1Element) {
        if (debugEnabled && debugTypes.contains(DebugType.ASN1)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, level);
            sb.append("writingASN1Element=\"");
            aSN1Element.toString(sb);
            sb.append('\"');
            logger.log(level, sb.toString());
        }
    }

    public static void debugCodingError(Throwable th) {
        if (debugEnabled && debugTypes.contains(DebugType.CODING_ERROR)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, Level.SEVERE);
            sb.append("codingError=\"");
            StaticUtils.getStackTrace(th, sb);
            sb.append('\"');
            logger.log(Level.SEVERE, sb.toString());
        }
    }

    public static void debugConnect(String str, int i) {
        if (debugEnabled && debugTypes.contains(DebugType.CONNECT)) {
            debugConnect(Level.INFO, str, i, (LDAPConnection) null);
        }
    }

    public static void debugConnect(String str, int i, LDAPConnection lDAPConnection) {
        if (debugEnabled && debugTypes.contains(DebugType.CONNECT)) {
            debugConnect(Level.INFO, str, i, lDAPConnection);
        }
    }

    public static void debugConnect(Level level, String str, int i) {
        if (debugEnabled && debugTypes.contains(DebugType.CONNECT)) {
            debugConnect(level, str, i, (LDAPConnection) null);
        }
    }

    public static void debugConnect(Level level, String str, int i, LDAPConnection lDAPConnection) {
        if (debugEnabled && debugTypes.contains(DebugType.CONNECT)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, level);
            sb.append("connectedTo=\"");
            sb.append(str);
            sb.append(':');
            sb.append(i);
            sb.append('\"');
            if (lDAPConnection != null) {
                sb.append(" connectionID=");
                sb.append(lDAPConnection.getConnectionID());
                String connectionName = lDAPConnection.getConnectionName();
                if (connectionName != null) {
                    sb.append(" connectionName=\"");
                    sb.append(connectionName);
                    sb.append('\"');
                }
                String connectionPoolName = lDAPConnection.getConnectionPoolName();
                if (connectionPoolName != null) {
                    sb.append(" connectionPoolName=\"");
                    sb.append(connectionPoolName);
                    sb.append('\"');
                }
            }
            logger.log(level, sb.toString());
        }
    }

    public static void debugDisconnect(String str, int i, DisconnectType disconnectType, String str2, Throwable th) {
        if (debugEnabled && debugTypes.contains(DebugType.CONNECT)) {
            debugDisconnect(Level.INFO, str, i, (LDAPConnection) null, disconnectType, str2, th);
        }
    }

    public static void debugDisconnect(String str, int i, LDAPConnection lDAPConnection, DisconnectType disconnectType, String str2, Throwable th) {
        if (debugEnabled && debugTypes.contains(DebugType.CONNECT)) {
            debugDisconnect(Level.INFO, str, i, lDAPConnection, disconnectType, str2, th);
        }
    }

    public static void debugDisconnect(Level level, String str, int i, DisconnectType disconnectType, String str2, Throwable th) {
        if (debugEnabled && debugTypes.contains(DebugType.CONNECT)) {
            debugDisconnect(level, str, i, (LDAPConnection) null, disconnectType, str2, th);
        }
    }

    public static void debugDisconnect(Level level, String str, int i, LDAPConnection lDAPConnection, DisconnectType disconnectType, String str2, Throwable th) {
        if (debugEnabled && debugTypes.contains(DebugType.CONNECT)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, level);
            if (lDAPConnection != null) {
                sb.append("connectionID=");
                sb.append(lDAPConnection.getConnectionID());
                String connectionName = lDAPConnection.getConnectionName();
                if (connectionName != null) {
                    sb.append(" connectionName=\"");
                    sb.append(connectionName);
                    sb.append('\"');
                }
                String connectionPoolName = lDAPConnection.getConnectionPoolName();
                if (connectionPoolName != null) {
                    sb.append(" connectionPoolName=\"");
                    sb.append(connectionPoolName);
                    sb.append('\"');
                }
                sb.append(' ');
            }
            sb.append("disconnectedFrom=\"");
            sb.append(str);
            sb.append(':');
            sb.append(i);
            sb.append("\" disconnectType=\"");
            sb.append(disconnectType.name());
            sb.append('\"');
            if (str2 != null) {
                sb.append("\" disconnectMessage=\"");
                sb.append(str2);
                sb.append('\"');
            }
            if (th != null) {
                sb.append("\" disconnectCause=\"");
                StaticUtils.getStackTrace(th, sb);
                sb.append('\"');
            }
            logger.log(level, sb.toString(), lDAPConnection);
        }
    }

    public static boolean debugEnabled() {
        return debugEnabled;
    }

    public static boolean debugEnabled(DebugType debugType) {
        return debugEnabled && debugTypes.contains(debugType);
    }

    public static void debugException(Throwable th) {
        if (debugEnabled && debugTypes.contains(DebugType.EXCEPTION)) {
            debugException(Level.WARNING, th);
        }
    }

    public static void debugException(Level level, Throwable th) {
        if (debugEnabled && debugTypes.contains(DebugType.EXCEPTION)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, level);
            sb.append("caughtException=\"");
            StaticUtils.getStackTrace(th, sb);
            sb.append('\"');
            logger.log(level, sb.toString(), th);
        }
    }

    public static void debugLDAPRequest(LDAPRequest lDAPRequest) {
        if (debugEnabled && debugTypes.contains(DebugType.LDAP)) {
            debugLDAPRequest(Level.INFO, lDAPRequest, -1, (LDAPConnection) null);
        }
    }

    public static void debugLDAPRequest(LDAPRequest lDAPRequest, int i, LDAPConnection lDAPConnection) {
        if (debugEnabled && debugTypes.contains(DebugType.LDAP)) {
            debugLDAPRequest(Level.INFO, lDAPRequest, i, lDAPConnection);
        }
    }

    public static void debugLDAPRequest(Level level, LDAPRequest lDAPRequest) {
        if (debugEnabled && debugTypes.contains(DebugType.LDAP)) {
            debugLDAPRequest(level, lDAPRequest, -1, (LDAPConnection) null);
        }
    }

    public static void debugLDAPRequest(Level level, LDAPRequest lDAPRequest, int i, LDAPConnection lDAPConnection) {
        if (debugEnabled && debugTypes.contains(DebugType.LDAP)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, level);
            if (lDAPConnection != null) {
                sb.append("connectionID=");
                sb.append(lDAPConnection.getConnectionID());
                String connectionName = lDAPConnection.getConnectionName();
                if (connectionName != null) {
                    sb.append(" connectionName=\"");
                    sb.append(connectionName);
                    sb.append('\"');
                }
                String connectionPoolName = lDAPConnection.getConnectionPoolName();
                if (connectionPoolName != null) {
                    sb.append(" connectionPoolName=\"");
                    sb.append(connectionPoolName);
                    sb.append('\"');
                }
                sb.append(" connectedTo=\"");
                sb.append(lDAPConnection.getConnectedAddress());
                sb.append(':');
                sb.append(lDAPConnection.getConnectedPort());
                sb.append("\" ");
            }
            if (i >= 0) {
                sb.append(" messageID=");
                sb.append(i);
                sb.append(' ');
            }
            sb.append("sendingLDAPRequest=\"");
            lDAPRequest.toString(sb);
            sb.append('\"');
            logger.log(level, sb.toString());
        }
    }

    public static void debugLDAPResult(LDAPResponse lDAPResponse) {
        if (debugEnabled && debugTypes.contains(DebugType.LDAP)) {
            debugLDAPResult(Level.INFO, lDAPResponse, (LDAPConnection) null);
        }
    }

    public static void debugLDAPResult(LDAPResponse lDAPResponse, LDAPConnection lDAPConnection) {
        if (debugEnabled && debugTypes.contains(DebugType.LDAP)) {
            debugLDAPResult(Level.INFO, lDAPResponse, lDAPConnection);
        }
    }

    public static void debugLDAPResult(Level level, LDAPResponse lDAPResponse) {
        if (debugEnabled && debugTypes.contains(DebugType.LDAP)) {
            debugLDAPResult(level, lDAPResponse, (LDAPConnection) null);
        }
    }

    public static void debugLDAPResult(Level level, LDAPResponse lDAPResponse, LDAPConnection lDAPConnection) {
        if (debugEnabled && debugTypes.contains(DebugType.LDAP)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, level);
            if (lDAPConnection != null) {
                sb.append("connectionID=");
                sb.append(lDAPConnection.getConnectionID());
                String connectionName = lDAPConnection.getConnectionName();
                if (connectionName != null) {
                    sb.append(" connectionName=\"");
                    sb.append(connectionName);
                    sb.append('\"');
                }
                String connectionPoolName = lDAPConnection.getConnectionPoolName();
                if (connectionPoolName != null) {
                    sb.append(" connectionPoolName=\"");
                    sb.append(connectionPoolName);
                    sb.append('\"');
                }
                sb.append(" connectedTo=\"");
                sb.append(lDAPConnection.getConnectedAddress());
                sb.append(':');
                sb.append(lDAPConnection.getConnectedPort());
                sb.append("\" ");
            }
            sb.append("readLDAPResult=\"");
            lDAPResponse.toString(sb);
            sb.append('\"');
            logger.log(level, sb.toString());
        }
    }

    public static void debugLDIFRead(LDIFRecord lDIFRecord) {
        if (debugEnabled && debugTypes.contains(DebugType.LDIF)) {
            debugLDIFRead(Level.INFO, lDIFRecord);
        }
    }

    public static void debugLDIFRead(Level level, LDIFRecord lDIFRecord) {
        if (debugEnabled && debugTypes.contains(DebugType.LDIF)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, level);
            sb.append("readLDIFRecord=\"");
            lDIFRecord.toString(sb);
            sb.append('\"');
            logger.log(level, sb.toString());
        }
    }

    public static void debugLDIFWrite(LDIFRecord lDIFRecord) {
        if (debugEnabled && debugTypes.contains(DebugType.LDIF)) {
            debugLDIFWrite(Level.INFO, lDIFRecord);
        }
    }

    public static void debugLDIFWrite(Level level, LDIFRecord lDIFRecord) {
        if (debugEnabled && debugTypes.contains(DebugType.LDIF)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, level);
            sb.append("writingLDIFRecord=\"");
            lDIFRecord.toString(sb);
            sb.append('\"');
            logger.log(level, sb.toString());
        }
    }

    public static void debugMonitor(Entry entry, String str) {
        if (debugEnabled && debugTypes.contains(DebugType.MONITOR)) {
            debugMonitor(Level.FINE, entry, str);
        }
    }

    public static void debugMonitor(Level level, Entry entry, String str) {
        if (debugEnabled && debugTypes.contains(DebugType.MONITOR)) {
            StringBuilder sb = new StringBuilder();
            addCommonHeader(sb, level);
            sb.append("monitorEntryDN=\"");
            sb.append(entry.getDN());
            sb.append("\" message=\"");
            sb.append(str);
            sb.append('\"');
            logger.log(level, sb.toString());
        }
    }

    public static EnumSet<DebugType> getDebugTypes() {
        return debugTypes;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static boolean includeStackTrace() {
        return includeStackTrace;
    }

    public static void initialize() {
        includeStackTrace = false;
        debugEnabled = false;
        debugTypes = EnumSet.allOf(DebugType.class);
        logger.setLevel(Level.ALL);
    }

    public static void initialize(Properties properties) {
        initialize();
        if (properties != null && !properties.isEmpty()) {
            String property = properties.getProperty(PROPERTY_DEBUG_ENABLED);
            if (property != null && property.length() > 0) {
                if (property.equalsIgnoreCase("true")) {
                    debugEnabled = true;
                } else if (property.equalsIgnoreCase("false")) {
                    debugEnabled = false;
                } else {
                    throw new IllegalArgumentException("Invalid value '" + property + "' for property " + PROPERTY_DEBUG_ENABLED + ".  The value must be either " + "'true' or 'false'.");
                }
            }
            String property2 = properties.getProperty(PROPERTY_INCLUDE_STACK_TRACE);
            if (property2 != null && property2.length() > 0) {
                if (property2.equalsIgnoreCase("true")) {
                    includeStackTrace = true;
                } else if (property2.equalsIgnoreCase("false")) {
                    includeStackTrace = false;
                } else {
                    throw new IllegalArgumentException("Invalid value '" + property2 + "' for property " + PROPERTY_INCLUDE_STACK_TRACE + ".  The value must be either " + "'true' or 'false'.");
                }
            }
            String property3 = properties.getProperty(PROPERTY_DEBUG_TYPE);
            if (property3 != null && property3.length() > 0) {
                debugTypes = EnumSet.noneOf(DebugType.class);
                StringTokenizer stringTokenizer = new StringTokenizer(property3, ", ");
                while (stringTokenizer.hasMoreTokens()) {
                    String nextToken = stringTokenizer.nextToken();
                    DebugType forName = DebugType.forName(nextToken);
                    if (forName != null) {
                        debugTypes.add(forName);
                    } else {
                        throw new IllegalArgumentException("Invalid value '" + nextToken + "' for property " + PROPERTY_DEBUG_TYPE + ".  Allowed values include:  " + DebugType.getTypeNameList() + FilenameUtils.EXTENSION_SEPARATOR);
                    }
                }
            }
            String property4 = properties.getProperty(PROPERTY_DEBUG_LEVEL);
            if (property4 != null && property4.length() > 0) {
                logger.setLevel(Level.parse(property4));
            }
        }
    }

    public static void setEnabled(boolean z) {
        debugTypes = EnumSet.allOf(DebugType.class);
        debugEnabled = z;
    }

    public static void setEnabled(boolean z, Set<DebugType> set) {
        debugTypes = (set == null || set.isEmpty()) ? EnumSet.allOf(DebugType.class) : EnumSet.copyOf(set);
        debugEnabled = z;
    }

    public static void setIncludeStackTrace(boolean z) {
        includeStackTrace = z;
    }
}
