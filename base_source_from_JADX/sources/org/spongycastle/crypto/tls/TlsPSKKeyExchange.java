package org.spongycastle.crypto.tls;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Vector;
import org.spongycastle.asn1.x509.Certificate;
import org.spongycastle.crypto.params.AsymmetricKeyParameter;
import org.spongycastle.crypto.params.DHParameters;
import org.spongycastle.crypto.params.DHPrivateKeyParameters;
import org.spongycastle.crypto.params.DHPublicKeyParameters;
import org.spongycastle.crypto.params.ECPrivateKeyParameters;
import org.spongycastle.crypto.params.ECPublicKeyParameters;
import org.spongycastle.crypto.params.RSAKeyParameters;
import org.spongycastle.crypto.util.PublicKeyFactory;
import org.spongycastle.util.Arrays;
import org.spongycastle.util.p191io.Streams;

public class TlsPSKKeyExchange extends AbstractTlsKeyExchange {
    protected short[] clientECPointFormats;
    protected DHPrivateKeyParameters dhAgreePrivateKey = null;
    protected DHPublicKeyParameters dhAgreePublicKey = null;
    protected DHParameters dhParameters;
    protected ECPrivateKeyParameters ecAgreePrivateKey = null;
    protected ECPublicKeyParameters ecAgreePublicKey = null;
    protected int[] namedCurves;
    protected byte[] premasterSecret;
    protected byte[] psk = null;
    protected TlsPSKIdentity pskIdentity;
    protected TlsPSKIdentityManager pskIdentityManager;
    protected byte[] psk_identity_hint = null;
    protected RSAKeyParameters rsaServerPublicKey = null;
    protected TlsEncryptionCredentials serverCredentials = null;
    protected short[] serverECPointFormats;
    protected AsymmetricKeyParameter serverPublicKey = null;

    public TlsPSKKeyExchange(int i, Vector vector, TlsPSKIdentity tlsPSKIdentity, TlsPSKIdentityManager tlsPSKIdentityManager, DHParameters dHParameters, int[] iArr, short[] sArr, short[] sArr2) {
        super(i, vector);
        if (i != 24) {
            switch (i) {
                case 13:
                case 14:
                case 15:
                    break;
                default:
                    throw new IllegalArgumentException("unsupported key exchange algorithm");
            }
        }
        this.pskIdentity = tlsPSKIdentity;
        this.pskIdentityManager = tlsPSKIdentityManager;
        this.dhParameters = dHParameters;
        this.namedCurves = iArr;
        this.clientECPointFormats = sArr;
        this.serverECPointFormats = sArr2;
    }

    public void generateClientKeyExchange(OutputStream outputStream) {
        byte[] bArr = this.psk_identity_hint;
        if (bArr == null) {
            this.pskIdentity.skipIdentityHint();
        } else {
            this.pskIdentity.notifyIdentityHint(bArr);
        }
        byte[] pSKIdentity = this.pskIdentity.getPSKIdentity();
        if (pSKIdentity != null) {
            this.psk = this.pskIdentity.getPSK();
            if (this.psk != null) {
                TlsUtils.writeOpaque16(pSKIdentity, outputStream);
                this.context.getSecurityParameters().pskIdentity = Arrays.clone(pSKIdentity);
                if (this.keyExchange == 14) {
                    this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.dhParameters, outputStream);
                } else if (this.keyExchange == 24) {
                    this.ecAgreePrivateKey = TlsECCUtils.generateEphemeralClientKeyExchange(this.context.getSecureRandom(), this.serverECPointFormats, this.ecAgreePublicKey.getParameters(), outputStream);
                } else if (this.keyExchange == 15) {
                    this.premasterSecret = TlsRSAUtils.generateEncryptedPreMasterSecret(this.context, this.rsaServerPublicKey, outputStream);
                }
            } else {
                throw new TlsFatalAlert(80);
            }
        } else {
            throw new TlsFatalAlert(80);
        }
    }

    /* access modifiers changed from: protected */
    public byte[] generateOtherSecret(int i) {
        if (this.keyExchange == 14) {
            DHPrivateKeyParameters dHPrivateKeyParameters = this.dhAgreePrivateKey;
            if (dHPrivateKeyParameters != null) {
                return TlsDHUtils.calculateDHBasicAgreement(this.dhAgreePublicKey, dHPrivateKeyParameters);
            }
            throw new TlsFatalAlert(80);
        } else if (this.keyExchange != 24) {
            return this.keyExchange == 15 ? this.premasterSecret : new byte[i];
        } else {
            ECPrivateKeyParameters eCPrivateKeyParameters = this.ecAgreePrivateKey;
            if (eCPrivateKeyParameters != null) {
                return TlsECCUtils.calculateECDHBasicAgreement(this.ecAgreePublicKey, eCPrivateKeyParameters);
            }
            throw new TlsFatalAlert(80);
        }
    }

    public byte[] generatePremasterSecret() {
        byte[] generateOtherSecret = generateOtherSecret(this.psk.length);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(generateOtherSecret.length + 4 + this.psk.length);
        TlsUtils.writeOpaque16(generateOtherSecret, byteArrayOutputStream);
        TlsUtils.writeOpaque16(this.psk, byteArrayOutputStream);
        Arrays.fill(this.psk, (byte) 0);
        this.psk = null;
        return byteArrayOutputStream.toByteArray();
    }

    public byte[] generateServerKeyExchange() {
        this.psk_identity_hint = this.pskIdentityManager.getHint();
        if (this.psk_identity_hint == null && !requiresServerKeyExchange()) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bArr = this.psk_identity_hint;
        if (bArr == null) {
            bArr = TlsUtils.EMPTY_BYTES;
        }
        TlsUtils.writeOpaque16(bArr, byteArrayOutputStream);
        if (this.keyExchange == 14) {
            if (this.dhParameters != null) {
                this.dhAgreePrivateKey = TlsDHUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.dhParameters, byteArrayOutputStream);
            } else {
                throw new TlsFatalAlert(80);
            }
        } else if (this.keyExchange == 24) {
            this.ecAgreePrivateKey = TlsECCUtils.generateEphemeralServerKeyExchange(this.context.getSecureRandom(), this.namedCurves, this.clientECPointFormats, byteArrayOutputStream);
        }
        return byteArrayOutputStream.toByteArray();
    }

    public void processClientCredentials(TlsCredentials tlsCredentials) {
        throw new TlsFatalAlert(80);
    }

    public void processClientKeyExchange(InputStream inputStream) {
        byte[] readOpaque16 = TlsUtils.readOpaque16(inputStream);
        this.psk = this.pskIdentityManager.getPSK(readOpaque16);
        if (this.psk != null) {
            this.context.getSecurityParameters().pskIdentity = readOpaque16;
            if (this.keyExchange == 14) {
                this.dhAgreePublicKey = TlsDHUtils.validateDHPublicKey(new DHPublicKeyParameters(TlsDHUtils.readDHParameter(inputStream), this.dhParameters));
            } else if (this.keyExchange == 24) {
                this.ecAgreePublicKey = TlsECCUtils.validateECPublicKey(TlsECCUtils.deserializeECPublicKey(this.serverECPointFormats, this.ecAgreePrivateKey.getParameters(), TlsUtils.readOpaque8(inputStream)));
            } else if (this.keyExchange == 15) {
                this.premasterSecret = this.serverCredentials.decryptPreMasterSecret(TlsUtils.isSSL(this.context) ? Streams.readAll(inputStream) : TlsUtils.readOpaque16(inputStream));
            }
        } else {
            throw new TlsFatalAlert(AlertDescription.unknown_psk_identity);
        }
    }

    public void processServerCertificate(Certificate certificate) {
        if (this.keyExchange != 15) {
            throw new TlsFatalAlert(10);
        } else if (!certificate.isEmpty()) {
            Certificate certificateAt = certificate.getCertificateAt(0);
            try {
                this.serverPublicKey = PublicKeyFactory.createKey(certificateAt.getSubjectPublicKeyInfo());
                if (!this.serverPublicKey.isPrivate()) {
                    this.rsaServerPublicKey = validateRSAPublicKey((RSAKeyParameters) this.serverPublicKey);
                    TlsUtils.validateKeyUsage(certificateAt, 32);
                    super.processServerCertificate(certificate);
                    return;
                }
                throw new TlsFatalAlert(80);
            } catch (RuntimeException e) {
                throw new TlsFatalAlert(43, e);
            }
        } else {
            throw new TlsFatalAlert(42);
        }
    }

    public void processServerCredentials(TlsCredentials tlsCredentials) {
        if (tlsCredentials instanceof TlsEncryptionCredentials) {
            processServerCertificate(tlsCredentials.getCertificate());
            this.serverCredentials = (TlsEncryptionCredentials) tlsCredentials;
            return;
        }
        throw new TlsFatalAlert(80);
    }

    public void processServerKeyExchange(InputStream inputStream) {
        this.psk_identity_hint = TlsUtils.readOpaque16(inputStream);
        if (this.keyExchange == 14) {
            this.dhAgreePublicKey = TlsDHUtils.validateDHPublicKey(ServerDHParams.parse(inputStream).getPublicKey());
            this.dhParameters = this.dhAgreePublicKey.getParameters();
        } else if (this.keyExchange == 24) {
            this.ecAgreePublicKey = TlsECCUtils.validateECPublicKey(TlsECCUtils.deserializeECPublicKey(this.clientECPointFormats, TlsECCUtils.readECParameters(this.namedCurves, this.clientECPointFormats, inputStream), TlsUtils.readOpaque8(inputStream)));
        }
    }

    public boolean requiresServerKeyExchange() {
        int i = this.keyExchange;
        return i == 14 || i == 24;
    }

    public void skipServerCredentials() {
        if (this.keyExchange == 15) {
            throw new TlsFatalAlert(10);
        }
    }

    public void validateCertificateRequest(CertificateRequest certificateRequest) {
        throw new TlsFatalAlert(10);
    }

    /* access modifiers changed from: protected */
    public RSAKeyParameters validateRSAPublicKey(RSAKeyParameters rSAKeyParameters) {
        if (rSAKeyParameters.getExponent().isProbablePrime(2)) {
            return rSAKeyParameters;
        }
        throw new TlsFatalAlert(47);
    }
}
