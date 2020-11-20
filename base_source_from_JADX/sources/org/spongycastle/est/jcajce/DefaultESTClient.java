package org.spongycastle.est.jcajce;

import java.io.OutputStream;
import java.net.URL;
import java.nio.charset.Charset;
import okhttp3.internal.http.StatusLine;
import org.spongycastle.est.ESTClient;
import org.spongycastle.est.ESTClientSourceProvider;
import org.spongycastle.est.ESTException;
import org.spongycastle.est.ESTRequest;
import org.spongycastle.est.ESTRequestBuilder;
import org.spongycastle.est.ESTResponse;

class DefaultESTClient implements ESTClient {
    private static byte[] CRLF = {13, 10};
    private static final Charset utf8 = Charset.forName("UTF-8");
    private final ESTClientSourceProvider sslSocketProvider;

    private class PrintingOutputStream extends OutputStream {
        private final OutputStream tgt;

        public PrintingOutputStream(OutputStream outputStream) {
            this.tgt = outputStream;
        }

        public void write(int i) {
            System.out.print(String.valueOf((char) i));
            this.tgt.write(i);
        }
    }

    public DefaultESTClient(ESTClientSourceProvider eSTClientSourceProvider) {
        this.sslSocketProvider = eSTClientSourceProvider;
    }

    private static void writeLine(OutputStream outputStream, String str) {
        outputStream.write(str.getBytes());
        outputStream.write(CRLF);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0015 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.est.ESTResponse doRequest(org.spongycastle.est.ESTRequest r3) {
        /*
            r2 = this;
            r0 = 15
        L_0x0002:
            org.spongycastle.est.ESTResponse r3 = r2.performRequest(r3)
            org.spongycastle.est.ESTRequest r1 = r2.redirectURL(r3)
            if (r1 == 0) goto L_0x0013
            int r0 = r0 + -1
            if (r0 > 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r3 = r1
            goto L_0x0002
        L_0x0013:
            if (r0 == 0) goto L_0x0016
            return r3
        L_0x0016:
            org.spongycastle.est.ESTException r3 = new org.spongycastle.est.ESTException
            java.lang.String r0 = "Too many redirects.."
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.est.jcajce.DefaultESTClient.doRequest(org.spongycastle.est.ESTRequest):org.spongycastle.est.ESTResponse");
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0064 A[Catch:{ all -> 0x0155 }] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006d A[Catch:{ all -> 0x0155 }] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0087 A[Catch:{ all -> 0x0155 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x009a A[Catch:{ all -> 0x0155 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ba A[Catch:{ all -> 0x0155 }] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00f7 A[Catch:{ all -> 0x0155 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x013f A[Catch:{ all -> 0x0155 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x014f A[SYNTHETIC, Splitter:B:38:0x014f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.spongycastle.est.ESTResponse performRequest(org.spongycastle.est.ESTRequest r10) {
        /*
            r9 = this;
            r0 = 0
            org.spongycastle.est.ESTClientSourceProvider r1 = r9.sslSocketProvider     // Catch:{ all -> 0x0155 }
            java.net.URL r2 = r10.getURL()     // Catch:{ all -> 0x0155 }
            java.lang.String r2 = r2.getHost()     // Catch:{ all -> 0x0155 }
            java.net.URL r3 = r10.getURL()     // Catch:{ all -> 0x0155 }
            int r3 = r3.getPort()     // Catch:{ all -> 0x0155 }
            org.spongycastle.est.Source r0 = r1.makeSource(r2, r3)     // Catch:{ all -> 0x0155 }
            org.spongycastle.est.ESTSourceConnectionListener r1 = r10.getListener()     // Catch:{ all -> 0x0155 }
            if (r1 == 0) goto L_0x0025
            org.spongycastle.est.ESTSourceConnectionListener r1 = r10.getListener()     // Catch:{ all -> 0x0155 }
            org.spongycastle.est.ESTRequest r10 = r1.onConnection(r0, r10)     // Catch:{ all -> 0x0155 }
        L_0x0025:
            java.lang.String r1 = "org.spongycastle.debug.est"
            java.util.Set r1 = org.spongycastle.util.Properties.asKeySet(r1)     // Catch:{ all -> 0x0155 }
            java.lang.String r2 = "output"
            boolean r2 = r1.contains(r2)     // Catch:{ all -> 0x0155 }
            if (r2 != 0) goto L_0x0041
            java.lang.String r2 = "all"
            boolean r1 = r1.contains(r2)     // Catch:{ all -> 0x0155 }
            if (r1 == 0) goto L_0x003c
            goto L_0x0041
        L_0x003c:
            java.io.OutputStream r1 = r0.getOutputStream()     // Catch:{ all -> 0x0155 }
            goto L_0x004a
        L_0x0041:
            org.spongycastle.est.jcajce.DefaultESTClient$PrintingOutputStream r1 = new org.spongycastle.est.jcajce.DefaultESTClient$PrintingOutputStream     // Catch:{ all -> 0x0155 }
            java.io.OutputStream r2 = r0.getOutputStream()     // Catch:{ all -> 0x0155 }
            r1.<init>(r2)     // Catch:{ all -> 0x0155 }
        L_0x004a:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0155 }
            r2.<init>()     // Catch:{ all -> 0x0155 }
            java.net.URL r3 = r10.getURL()     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = r3.getPath()     // Catch:{ all -> 0x0155 }
            r2.append(r3)     // Catch:{ all -> 0x0155 }
            java.net.URL r3 = r10.getURL()     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = r3.getQuery()     // Catch:{ all -> 0x0155 }
            if (r3 == 0) goto L_0x006d
            java.net.URL r3 = r10.getURL()     // Catch:{ all -> 0x0155 }
            java.lang.String r3 = r3.getQuery()     // Catch:{ all -> 0x0155 }
            goto L_0x006f
        L_0x006d:
            java.lang.String r3 = ""
        L_0x006f:
            r2.append(r3)     // Catch:{ all -> 0x0155 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0155 }
            org.spongycastle.est.ESTRequestBuilder r3 = new org.spongycastle.est.ESTRequestBuilder     // Catch:{ all -> 0x0155 }
            r3.<init>(r10)     // Catch:{ all -> 0x0155 }
            java.util.Map r4 = r10.getHeaders()     // Catch:{ all -> 0x0155 }
            java.lang.String r5 = "Connection"
            boolean r4 = r4.containsKey(r5)     // Catch:{ all -> 0x0155 }
            if (r4 != 0) goto L_0x008e
            java.lang.String r4 = "Connection"
            java.lang.String r5 = "close"
            r3.addHeader(r4, r5)     // Catch:{ all -> 0x0155 }
        L_0x008e:
            java.net.URL r10 = r10.getURL()     // Catch:{ all -> 0x0155 }
            int r4 = r10.getPort()     // Catch:{ all -> 0x0155 }
            r5 = -1
            r6 = 0
            if (r4 <= r5) goto L_0x00ba
            java.lang.String r4 = "Host"
            java.lang.String r5 = "%s:%d"
            r7 = 2
            java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch:{ all -> 0x0155 }
            java.lang.String r8 = r10.getHost()     // Catch:{ all -> 0x0155 }
            r7[r6] = r8     // Catch:{ all -> 0x0155 }
            int r10 = r10.getPort()     // Catch:{ all -> 0x0155 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ all -> 0x0155 }
            r8 = 1
            r7[r8] = r10     // Catch:{ all -> 0x0155 }
            java.lang.String r10 = java.lang.String.format(r5, r7)     // Catch:{ all -> 0x0155 }
        L_0x00b6:
            r3.setHeader(r4, r10)     // Catch:{ all -> 0x0155 }
            goto L_0x00c1
        L_0x00ba:
            java.lang.String r4 = "Host"
            java.lang.String r10 = r10.getHost()     // Catch:{ all -> 0x0155 }
            goto L_0x00b6
        L_0x00c1:
            org.spongycastle.est.ESTRequest r10 = r3.build()     // Catch:{ all -> 0x0155 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0155 }
            r3.<init>()     // Catch:{ all -> 0x0155 }
            java.lang.String r4 = r10.getMethod()     // Catch:{ all -> 0x0155 }
            r3.append(r4)     // Catch:{ all -> 0x0155 }
            java.lang.String r4 = " "
            r3.append(r4)     // Catch:{ all -> 0x0155 }
            r3.append(r2)     // Catch:{ all -> 0x0155 }
            java.lang.String r2 = " HTTP/1.1"
            r3.append(r2)     // Catch:{ all -> 0x0155 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0155 }
            writeLine(r1, r2)     // Catch:{ all -> 0x0155 }
            java.util.Map r2 = r10.getHeaders()     // Catch:{ all -> 0x0155 }
            java.util.Set r2 = r2.entrySet()     // Catch:{ all -> 0x0155 }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x0155 }
        L_0x00f1:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0155 }
            if (r3 == 0) goto L_0x012b
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0155 }
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3     // Catch:{ all -> 0x0155 }
            java.lang.Object r4 = r3.getValue()     // Catch:{ all -> 0x0155 }
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ all -> 0x0155 }
            java.lang.String[] r4 = (java.lang.String[]) r4     // Catch:{ all -> 0x0155 }
            r5 = 0
        L_0x0106:
            int r7 = r4.length     // Catch:{ all -> 0x0155 }
            if (r5 == r7) goto L_0x00f1
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0155 }
            r7.<init>()     // Catch:{ all -> 0x0155 }
            java.lang.Object r8 = r3.getKey()     // Catch:{ all -> 0x0155 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0155 }
            r7.append(r8)     // Catch:{ all -> 0x0155 }
            java.lang.String r8 = ": "
            r7.append(r8)     // Catch:{ all -> 0x0155 }
            r8 = r4[r5]     // Catch:{ all -> 0x0155 }
            r7.append(r8)     // Catch:{ all -> 0x0155 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0155 }
            writeLine(r1, r7)     // Catch:{ all -> 0x0155 }
            int r5 = r5 + 1
            goto L_0x0106
        L_0x012b:
            byte[] r2 = CRLF     // Catch:{ all -> 0x0155 }
            r1.write(r2)     // Catch:{ all -> 0x0155 }
            r1.flush()     // Catch:{ all -> 0x0155 }
            r10.writeData(r1)     // Catch:{ all -> 0x0155 }
            r1.flush()     // Catch:{ all -> 0x0155 }
            org.spongycastle.est.ESTHijacker r1 = r10.getHijacker()     // Catch:{ all -> 0x0155 }
            if (r1 == 0) goto L_0x014f
            org.spongycastle.est.ESTHijacker r1 = r10.getHijacker()     // Catch:{ all -> 0x0155 }
            org.spongycastle.est.ESTResponse r10 = r1.hijack(r10, r0)     // Catch:{ all -> 0x0155 }
            if (r0 == 0) goto L_0x014e
            if (r10 != 0) goto L_0x014e
            r0.close()
        L_0x014e:
            return r10
        L_0x014f:
            org.spongycastle.est.ESTResponse r1 = new org.spongycastle.est.ESTResponse     // Catch:{ all -> 0x0155 }
            r1.<init>(r10, r0)     // Catch:{ all -> 0x0155 }
            return r1
        L_0x0155:
            r10 = move-exception
            if (r0 == 0) goto L_0x015b
            r0.close()
        L_0x015b:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.est.jcajce.DefaultESTClient.performRequest(org.spongycastle.est.ESTRequest):org.spongycastle.est.ESTResponse");
    }

    /* access modifiers changed from: protected */
    public ESTRequest redirectURL(ESTResponse eSTResponse) {
        ESTRequest eSTRequest;
        ESTRequestBuilder eSTRequestBuilder;
        if (eSTResponse.getStatusCode() < 300 || eSTResponse.getStatusCode() > 399) {
            eSTRequest = null;
        } else {
            switch (eSTResponse.getStatusCode()) {
                case 301:
                case 302:
                case 303:
                case 306:
                case StatusLine.HTTP_TEMP_REDIRECT:
                    String header = eSTResponse.getHeader("Location");
                    if (!"".equals(header)) {
                        ESTRequestBuilder eSTRequestBuilder2 = new ESTRequestBuilder(eSTResponse.getOriginalRequest());
                        if (header.startsWith("http")) {
                            eSTRequestBuilder = eSTRequestBuilder2.withURL(new URL(header));
                        } else {
                            URL url = eSTResponse.getOriginalRequest().getURL();
                            eSTRequestBuilder = eSTRequestBuilder2.withURL(new URL(url.getProtocol(), url.getHost(), url.getPort(), header));
                        }
                        eSTRequest = eSTRequestBuilder.build();
                        break;
                    } else {
                        throw new ESTException("Redirect status type: " + eSTResponse.getStatusCode() + " but no location header");
                    }
                default:
                    throw new ESTException("Client does not handle http status code: " + eSTResponse.getStatusCode());
            }
        }
        if (eSTRequest != null) {
            eSTResponse.close();
        }
        return eSTRequest;
    }
}
