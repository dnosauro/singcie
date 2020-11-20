package org.spongycastle.est;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.nist.NISTObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.cms.CMSAttributeTableGenerator;
import org.spongycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.spongycastle.operator.DigestAlgorithmIdentifierFinder;
import org.spongycastle.operator.DigestCalculator;
import org.spongycastle.operator.DigestCalculatorProvider;
import org.spongycastle.operator.OperatorCreationException;
import org.spongycastle.util.Strings;
import org.spongycastle.util.encoders.Base64;
import org.spongycastle.util.encoders.Hex;

public class HttpAuth implements ESTAuth {
    private static final DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder = new DefaultDigestAlgorithmIdentifierFinder();
    private static final Set<String> validParts;
    private final DigestCalculatorProvider digestCalculatorProvider;
    private final SecureRandom nonceGenerator;
    /* access modifiers changed from: private */
    public final char[] password;
    /* access modifiers changed from: private */
    public final String realm;
    /* access modifiers changed from: private */
    public final String username;

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("realm");
        hashSet.add("nonce");
        hashSet.add("opaque");
        hashSet.add("algorithm");
        hashSet.add("qop");
        validParts = Collections.unmodifiableSet(hashSet);
    }

    public HttpAuth(String str, String str2, char[] cArr) {
        this(str, str2, cArr, (SecureRandom) null, (DigestCalculatorProvider) null);
    }

    public HttpAuth(String str, String str2, char[] cArr, SecureRandom secureRandom, DigestCalculatorProvider digestCalculatorProvider2) {
        this.realm = str;
        this.username = str2;
        this.password = cArr;
        this.nonceGenerator = secureRandom;
        this.digestCalculatorProvider = digestCalculatorProvider2;
    }

    public HttpAuth(String str, char[] cArr) {
        this((String) null, str, cArr, (SecureRandom) null, (DigestCalculatorProvider) null);
    }

    public HttpAuth(String str, char[] cArr, SecureRandom secureRandom, DigestCalculatorProvider digestCalculatorProvider2) {
        this((String) null, str, cArr, secureRandom, digestCalculatorProvider2);
    }

    /* access modifiers changed from: private */
    public ESTResponse doDigestFunction(ESTResponse eSTResponse) {
        String str;
        String str2;
        ESTResponse eSTResponse2 = eSTResponse;
        eSTResponse.close();
        ESTRequest originalRequest = eSTResponse.getOriginalRequest();
        try {
            Map<String, String> splitCSL = HttpUtil.splitCSL("Digest", eSTResponse2.getHeader("WWW-Authenticate"));
            try {
                String path = originalRequest.getURL().toURI().getPath();
                for (String next : splitCSL.keySet()) {
                    if (!validParts.contains(next)) {
                        throw new ESTException("Unrecognised entry in WWW-Authenticate header: '" + next + "'");
                    }
                }
                String method = originalRequest.getMethod();
                String str3 = splitCSL.get("realm");
                String str4 = splitCSL.get("nonce");
                String str5 = splitCSL.get("opaque");
                String str6 = splitCSL.get("algorithm");
                String str7 = splitCSL.get("qop");
                ArrayList arrayList = new ArrayList();
                String str8 = this.realm;
                if (str8 == null || str8.equals(str3)) {
                    if (str6 == null) {
                        str6 = "MD5";
                    }
                    if (str6.length() != 0) {
                        String upperCase = Strings.toUpperCase(str6);
                        if (str7 == null) {
                            throw new ESTException("Qop is not defined in WWW-Authenticate header.");
                        } else if (str7.length() != 0) {
                            String[] split = Strings.toLowerCase(str7).split(",");
                            int i = 0;
                            while (i != split.length) {
                                if (split[i].equals("auth") || split[i].equals("auth-int")) {
                                    String trim = split[i].trim();
                                    if (!arrayList.contains(trim)) {
                                        arrayList.add(trim);
                                    }
                                    i++;
                                } else {
                                    throw new ESTException("QoP value unknown: '" + i + "'");
                                }
                            }
                            AlgorithmIdentifier lookupDigest = lookupDigest(upperCase);
                            if (lookupDigest == null || lookupDigest.getAlgorithm() == null) {
                                throw new IOException("auth digest algorithm unknown: " + upperCase);
                            }
                            DigestCalculator digestCalculator = getDigestCalculator(upperCase, lookupDigest);
                            OutputStream outputStream = digestCalculator.getOutputStream();
                            String makeNonce = makeNonce(10);
                            update(outputStream, this.username);
                            update(outputStream, ":");
                            update(outputStream, str3);
                            update(outputStream, ":");
                            update(outputStream, this.password);
                            outputStream.close();
                            byte[] digest = digestCalculator.getDigest();
                            if (upperCase.endsWith("-SESS")) {
                                DigestCalculator digestCalculator2 = getDigestCalculator(upperCase, lookupDigest);
                                OutputStream outputStream2 = digestCalculator2.getOutputStream();
                                update(outputStream2, Hex.toHexString(digest));
                                update(outputStream2, ":");
                                update(outputStream2, str4);
                                update(outputStream2, ":");
                                update(outputStream2, makeNonce);
                                outputStream2.close();
                                digest = digestCalculator2.getDigest();
                            }
                            String hexString = Hex.toHexString(digest);
                            DigestCalculator digestCalculator3 = getDigestCalculator(upperCase, lookupDigest);
                            OutputStream outputStream3 = digestCalculator3.getOutputStream();
                            if (((String) arrayList.get(0)).equals("auth-int")) {
                                DigestCalculator digestCalculator4 = getDigestCalculator(upperCase, lookupDigest);
                                OutputStream outputStream4 = digestCalculator4.getOutputStream();
                                originalRequest.writeData(outputStream4);
                                outputStream4.close();
                                byte[] digest2 = digestCalculator4.getDigest();
                                update(outputStream3, method);
                                update(outputStream3, ":");
                                update(outputStream3, path);
                                update(outputStream3, ":");
                                update(outputStream3, Hex.toHexString(digest2));
                            } else if (((String) arrayList.get(0)).equals("auth")) {
                                update(outputStream3, method);
                                update(outputStream3, ":");
                                update(outputStream3, path);
                            }
                            outputStream3.close();
                            String hexString2 = Hex.toHexString(digestCalculator3.getDigest());
                            DigestCalculator digestCalculator5 = getDigestCalculator(upperCase, lookupDigest);
                            OutputStream outputStream5 = digestCalculator5.getOutputStream();
                            if (arrayList.contains("missing")) {
                                update(outputStream5, hexString);
                                update(outputStream5, ":");
                                update(outputStream5, str4);
                            } else {
                                update(outputStream5, hexString);
                                update(outputStream5, ":");
                                update(outputStream5, str4);
                                update(outputStream5, ":");
                                update(outputStream5, "00000001");
                                update(outputStream5, ":");
                                update(outputStream5, makeNonce);
                                update(outputStream5, ":");
                                update(outputStream5, ((String) arrayList.get(0)).equals("auth-int") ? "auth-int" : "auth");
                            }
                            update(outputStream5, ":");
                            update(outputStream5, hexString2);
                            outputStream5.close();
                            String hexString3 = Hex.toHexString(digestCalculator5.getDigest());
                            HashMap hashMap = new HashMap();
                            hashMap.put("username", this.username);
                            hashMap.put("realm", str3);
                            hashMap.put("nonce", str4);
                            hashMap.put("uri", path);
                            hashMap.put("response", hexString3);
                            if (((String) arrayList.get(0)).equals("auth-int")) {
                                str = "qop";
                                str2 = "auth-int";
                            } else {
                                if (((String) arrayList.get(0)).equals("auth")) {
                                    str = "qop";
                                    str2 = "auth";
                                }
                                hashMap.put("algorithm", upperCase);
                                if (str5 == null || str5.length() == 0) {
                                    hashMap.put("opaque", makeNonce(20));
                                }
                                ESTRequestBuilder withHijacker = new ESTRequestBuilder(originalRequest).withHijacker((ESTHijacker) null);
                                withHijacker.setHeader("Authorization", HttpUtil.mergeCSL("Digest", hashMap));
                                return originalRequest.getClient().doRequest(withHijacker.build());
                            }
                            hashMap.put(str, str2);
                            hashMap.put("nc", "00000001");
                            hashMap.put("cnonce", makeNonce);
                            hashMap.put("algorithm", upperCase);
                            hashMap.put("opaque", makeNonce(20));
                            ESTRequestBuilder withHijacker2 = new ESTRequestBuilder(originalRequest).withHijacker((ESTHijacker) null);
                            withHijacker2.setHeader("Authorization", HttpUtil.mergeCSL("Digest", hashMap));
                            return originalRequest.getClient().doRequest(withHijacker2.build());
                        } else {
                            throw new ESTException("QoP value is empty.");
                        }
                    } else {
                        throw new ESTException("WWW-Authenticate no algorithm defined.");
                    }
                } else {
                    throw new ESTException("Supplied realm '" + this.realm + "' does not match server realm '" + str3 + "'", (Throwable) null, 401, (InputStream) null);
                }
            } catch (Exception e) {
                throw new IOException("unable to process URL in request: " + e.getMessage());
            }
        } catch (Throwable th) {
            throw new ESTException("Parsing WWW-Authentication header: " + th.getMessage(), th, eSTResponse.getStatusCode(), new ByteArrayInputStream(eSTResponse2.getHeader("WWW-Authenticate").getBytes()));
        }
    }

    private DigestCalculator getDigestCalculator(String str, AlgorithmIdentifier algorithmIdentifier) {
        try {
            return this.digestCalculatorProvider.get(algorithmIdentifier);
        } catch (OperatorCreationException e) {
            throw new IOException("cannot create digest calculator for " + str + ": " + e.getMessage());
        }
    }

    private AlgorithmIdentifier lookupDigest(String str) {
        if (str.endsWith("-SESS")) {
            str = str.substring(0, str.length() - 5);
        }
        return str.equals("SHA-512-256") ? new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256, DERNull.INSTANCE) : digestAlgorithmIdentifierFinder.find(str);
    }

    private String makeNonce(int i) {
        byte[] bArr = new byte[i];
        this.nonceGenerator.nextBytes(bArr);
        return Hex.toHexString(bArr);
    }

    private void update(OutputStream outputStream, String str) {
        outputStream.write(Strings.toUTF8ByteArray(str));
    }

    private void update(OutputStream outputStream, char[] cArr) {
        outputStream.write(Strings.toUTF8ByteArray(cArr));
    }

    public void applyAuth(ESTRequestBuilder eSTRequestBuilder) {
        eSTRequestBuilder.withHijacker(new ESTHijacker() {
            public ESTResponse hijack(ESTRequest eSTRequest, Source source) {
                ESTResponse eSTResponse = new ESTResponse(eSTRequest, source);
                if (eSTResponse.getStatusCode() != 401) {
                    return eSTResponse;
                }
                String header = eSTResponse.getHeader("WWW-Authenticate");
                if (header != null) {
                    String lowerCase = Strings.toLowerCase(header);
                    if (lowerCase.startsWith(CMSAttributeTableGenerator.DIGEST)) {
                        return HttpAuth.this.doDigestFunction(eSTResponse);
                    }
                    if (lowerCase.startsWith("basic")) {
                        eSTResponse.close();
                        Map<String, String> splitCSL = HttpUtil.splitCSL("Basic", eSTResponse.getHeader("WWW-Authenticate"));
                        if (HttpAuth.this.realm == null || HttpAuth.this.realm.equals(splitCSL.get("realm"))) {
                            ESTRequestBuilder withHijacker = new ESTRequestBuilder(eSTRequest).withHijacker((ESTHijacker) null);
                            if (HttpAuth.this.realm != null && HttpAuth.this.realm.length() > 0) {
                                withHijacker.setHeader("WWW-Authenticate", "Basic realm=\"" + HttpAuth.this.realm + "\"");
                            }
                            if (!HttpAuth.this.username.contains(":")) {
                                String str = HttpAuth.this.username + ":" + new String(HttpAuth.this.password);
                                withHijacker.setHeader("Authorization", "Basic " + Base64.toBase64String(str.getBytes()));
                                return eSTRequest.getClient().doRequest(withHijacker.build());
                            }
                            throw new IllegalArgumentException("User must not contain a ':'");
                        }
                        throw new ESTException("Supplied realm '" + HttpAuth.this.realm + "' does not match server realm '" + splitCSL.get("realm") + "'", (Throwable) null, 401, (InputStream) null);
                    }
                    throw new ESTException("Unknown auth mode: " + lowerCase);
                }
                throw new ESTException("Status of 401 but no WWW-Authenticate header");
            }
        });
    }
}
