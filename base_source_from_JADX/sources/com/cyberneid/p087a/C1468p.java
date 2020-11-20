package com.cyberneid.p087a;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Date;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.asn1.x509.X509ObjectIdentifiers;
import org.spongycastle.tsp.TimeStampRequest;
import org.spongycastle.tsp.TimeStampRequestGenerator;
import org.spongycastle.tsp.TimeStampResponse;
import org.spongycastle.tsp.TimeStampToken;
import org.spongycastle.util.encoders.Base64;

/* renamed from: com.cyberneid.a.p */
public class C1468p {

    /* renamed from: a */
    protected String f4353a;

    /* renamed from: b */
    protected String f4354b;

    /* renamed from: c */
    protected String f4355c;

    /* renamed from: d */
    private final SSLSocketFactory f4356d;

    /* renamed from: b */
    private byte[] m5536b(byte[] bArr) {
        HttpURLConnection httpURLConnection;
        URL url = new URL(this.f4353a);
        if (!url.getProtocol().equals("https") || this.f4356d == null) {
            httpURLConnection = (HttpURLConnection) url.openConnection();
        } else {
            System.setProperty("https.protocols", "SSLv3,SSLv2Hello,TLSv1,TLSv1.1,TLSv1.2");
            C14691 r1 = new HostnameVerifier() {
                public boolean verify(String str, SSLSession sSLSession) {
                    return true;
                }
            };
            HttpsURLConnection.setDefaultHostnameVerifier(r1);
            HttpsURLConnection.setDefaultSSLSocketFactory(this.f4356d);
            httpURLConnection = (HttpsURLConnection) url.openConnection();
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) httpURLConnection;
            httpsURLConnection.setSSLSocketFactory(this.f4356d);
            httpsURLConnection.setInstanceFollowRedirects(true);
            httpsURLConnection.setHostnameVerifier(r1);
        }
        httpURLConnection.setDoInput(true);
        httpURLConnection.setDoOutput(true);
        httpURLConnection.setUseCaches(false);
        httpURLConnection.setRequestProperty("Content-Length", "" + bArr.length);
        httpURLConnection.setRequestProperty("Content-Type", "application/timestamp-query");
        httpURLConnection.setRequestProperty("Content-Transfer-Encoding", "BINARY");
        httpURLConnection.setRequestMethod("POST");
        String str = this.f4354b;
        if (str != null && !str.equals("")) {
            String str2 = new String(Base64.encode((this.f4354b + ":" + this.f4355c).getBytes()));
            StringBuilder sb = new StringBuilder();
            sb.append("Basic ");
            sb.append(str2);
            httpURLConnection.setRequestProperty("Authorization", sb.toString());
        }
        DataOutputStream dataOutputStream = new DataOutputStream(httpURLConnection.getOutputStream());
        dataOutputStream.write(bArr);
        dataOutputStream.flush();
        int responseCode = httpURLConnection.getResponseCode();
        if (responseCode <= 200) {
            InputStream inputStream = httpURLConnection.getInputStream();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr2);
                if (read <= 0) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            inputStream.close();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            String contentEncoding = httpURLConnection.getContentEncoding();
            return (contentEncoding == null || !contentEncoding.toLowerCase().equals("base64")) ? byteArray : Base64.decode(byteArray);
        }
        throw new RuntimeException("HTTP error n.: " + responseCode);
    }

    /* renamed from: a */
    public byte[] mo6950a(byte[] bArr) {
        TimeStampRequestGenerator timeStampRequestGenerator = new TimeStampRequestGenerator();
        timeStampRequestGenerator.setCertReq(true);
        TimeStampRequest generate = timeStampRequestGenerator.generate(X509ObjectIdentifiers.id_SHA1, bArr, BigInteger.valueOf(new Date().getTime()));
        TimeStampResponse timeStampResponse = new TimeStampResponse(m5536b(generate.getEncoded()));
        timeStampResponse.validate(generate);
        PKIFailureInfo failInfo = timeStampResponse.getFailInfo();
        int intValue = failInfo == null ? 0 : failInfo.intValue();
        if (intValue == 0) {
            TimeStampToken timeStampToken = timeStampResponse.getTimeStampToken();
            if (timeStampToken != null) {
                timeStampToken.getTimeStampInfo();
                return timeStampToken.getEncoded();
            }
            throw new RuntimeException("tsa failed to return time stamp token: " + this.f4353a + " " + timeStampResponse.getStatusString());
        }
        throw new RuntimeException("invalid tsa response code: " + this.f4353a + " " + intValue);
    }
}
