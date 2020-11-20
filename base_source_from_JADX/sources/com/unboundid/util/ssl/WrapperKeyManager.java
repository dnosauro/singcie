package com.unboundid.util.ssl;

import java.net.Socket;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.LinkedHashSet;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.X509ExtendedKeyManager;
import javax.net.ssl.X509KeyManager;

public abstract class WrapperKeyManager extends X509ExtendedKeyManager {
    private final String certificateAlias;
    private final X509KeyManager[] keyManagers;

    protected WrapperKeyManager(KeyManager[] keyManagerArr, String str) {
        this.certificateAlias = str;
        this.keyManagers = new X509KeyManager[keyManagerArr.length];
        for (int i = 0; i < keyManagerArr.length; i++) {
            this.keyManagers[i] = keyManagerArr[i];
        }
    }

    protected WrapperKeyManager(X509KeyManager[] x509KeyManagerArr, String str) {
        this.keyManagers = x509KeyManagerArr;
        this.certificateAlias = str;
    }

    public final synchronized String chooseClientAlias(String[] strArr, Principal[] principalArr, Socket socket) {
        if (this.certificateAlias == null) {
            for (X509KeyManager chooseClientAlias : this.keyManagers) {
                String chooseClientAlias2 = chooseClientAlias.chooseClientAlias(strArr, principalArr, socket);
                if (chooseClientAlias2 != null) {
                    return chooseClientAlias2;
                }
            }
            return null;
        }
        for (String str : strArr) {
            for (X509KeyManager clientAliases : this.keyManagers) {
                String[] clientAliases2 = clientAliases.getClientAliases(str, principalArr);
                if (clientAliases2 != null) {
                    for (String equals : clientAliases2) {
                        if (equals.equals(this.certificateAlias)) {
                            return this.certificateAlias;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public final synchronized String chooseEngineClientAlias(String[] strArr, Principal[] principalArr, SSLEngine sSLEngine) {
        if (this.certificateAlias == null) {
            for (X509KeyManager x509KeyManager : this.keyManagers) {
                if (x509KeyManager instanceof X509ExtendedKeyManager) {
                    String chooseEngineClientAlias = ((X509ExtendedKeyManager) x509KeyManager).chooseEngineClientAlias(strArr, principalArr, sSLEngine);
                    if (chooseEngineClientAlias != null) {
                        return chooseEngineClientAlias;
                    }
                } else {
                    String chooseClientAlias = x509KeyManager.chooseClientAlias(strArr, principalArr, (Socket) null);
                    if (chooseClientAlias != null) {
                        return chooseClientAlias;
                    }
                }
            }
            return null;
        }
        for (String str : strArr) {
            for (X509KeyManager clientAliases : this.keyManagers) {
                String[] clientAliases2 = clientAliases.getClientAliases(str, principalArr);
                if (clientAliases2 != null) {
                    for (String equals : clientAliases2) {
                        if (equals.equals(this.certificateAlias)) {
                            return this.certificateAlias;
                        }
                    }
                    continue;
                }
            }
        }
        return null;
    }

    public final synchronized String chooseEngineServerAlias(String str, Principal[] principalArr, SSLEngine sSLEngine) {
        if (this.certificateAlias == null) {
            for (X509KeyManager x509KeyManager : this.keyManagers) {
                if (x509KeyManager instanceof X509ExtendedKeyManager) {
                    String chooseEngineServerAlias = ((X509ExtendedKeyManager) x509KeyManager).chooseEngineServerAlias(str, principalArr, sSLEngine);
                    if (chooseEngineServerAlias != null) {
                        return chooseEngineServerAlias;
                    }
                } else {
                    String chooseServerAlias = x509KeyManager.chooseServerAlias(str, principalArr, (Socket) null);
                    if (chooseServerAlias != null) {
                        return chooseServerAlias;
                    }
                }
            }
            return null;
        }
        for (X509KeyManager serverAliases : this.keyManagers) {
            String[] serverAliases2 = serverAliases.getServerAliases(str, principalArr);
            if (serverAliases2 != null) {
                for (String equals : serverAliases2) {
                    if (equals.equals(this.certificateAlias)) {
                        return this.certificateAlias;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public final synchronized String chooseServerAlias(String str, Principal[] principalArr, Socket socket) {
        if (this.certificateAlias == null) {
            for (X509KeyManager chooseServerAlias : this.keyManagers) {
                String chooseServerAlias2 = chooseServerAlias.chooseServerAlias(str, principalArr, socket);
                if (chooseServerAlias2 != null) {
                    return chooseServerAlias2;
                }
            }
            return null;
        }
        for (X509KeyManager serverAliases : this.keyManagers) {
            String[] serverAliases2 = serverAliases.getServerAliases(str, principalArr);
            if (serverAliases2 != null) {
                for (String equals : serverAliases2) {
                    if (equals.equals(this.certificateAlias)) {
                        return this.certificateAlias;
                    }
                }
                continue;
            }
        }
        return null;
    }

    public String getCertificateAlias() {
        return this.certificateAlias;
    }

    public final synchronized X509Certificate[] getCertificateChain(String str) {
        for (X509KeyManager certificateChain : this.keyManagers) {
            X509Certificate[] certificateChain2 = certificateChain.getCertificateChain(str);
            if (certificateChain2 != null) {
                return certificateChain2;
            }
        }
        return null;
    }

    public final synchronized String[] getClientAliases(String str, Principal[] principalArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (X509KeyManager clientAliases : this.keyManagers) {
            String[] clientAliases2 = clientAliases.getClientAliases(str, principalArr);
            if (clientAliases2 != null) {
                linkedHashSet.addAll(Arrays.asList(clientAliases2));
            }
        }
        if (linkedHashSet.isEmpty()) {
            return null;
        }
        return (String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]);
    }

    public final synchronized PrivateKey getPrivateKey(String str) {
        for (X509KeyManager privateKey : this.keyManagers) {
            PrivateKey privateKey2 = privateKey.getPrivateKey(str);
            if (privateKey2 != null) {
                return privateKey2;
            }
        }
        return null;
    }

    public final synchronized String[] getServerAliases(String str, Principal[] principalArr) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (X509KeyManager serverAliases : this.keyManagers) {
            String[] serverAliases2 = serverAliases.getServerAliases(str, principalArr);
            if (serverAliases2 != null) {
                linkedHashSet.addAll(Arrays.asList(serverAliases2));
            }
        }
        if (linkedHashSet.isEmpty()) {
            return null;
        }
        return (String[]) linkedHashSet.toArray(new String[linkedHashSet.size()]);
    }
}
