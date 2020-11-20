package com.cyberneid.disigon;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.cyberneid.disigon.p133a.C2070b;
import com.cyberneid.disigon.p134b.C2078b;
import com.cyberneid.disigoncie.R;
import com.cyberneid.p087a.C1455d;
import com.cyberneid.p105d.p131h.C1941e;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.p137e.p139b.C2137a;
import com.p137e.p139b.C2140d;
import com.parse.Parse;
import com.parse.ParseConfig;
import com.parse.ParseException;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;
import com.parse.fcm.ParseFCM;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.security.Security;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.spongycastle.jce.provider.BouncyCastleProvider;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MainApplication extends Application {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static String f6263a = "MainApplication";

    /* renamed from: b */
    private static Context f6264b;

    /* renamed from: a */
    public static Context m8072a() {
        return f6264b;
    }

    /* renamed from: a */
    private static String m8073a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        char[] charArray = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        boolean z = true;
        for (char c : charArray) {
            if (!z || !Character.isLetter(c)) {
                if (Character.isWhitespace(c)) {
                    z = true;
                }
                sb.append(c);
            } else {
                sb.append(Character.toUpperCase(c));
                z = false;
            }
        }
        return sb.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m8074a(ParseConfig parseConfig, ParseException parseException) {
        if (parseException == null) {
            Log.d(f6263a, "ParseConfig Loaded");
        } else {
            parseException.printStackTrace();
        }
    }

    /* renamed from: a */
    private static void m8075a(String str, OutputStream outputStream) {
        try {
            URL url = new URL(str);
            url.openConnection();
            InputStream openStream = url.openStream();
            C2126g.m8374a(openStream, outputStream);
            openStream.close();
        } catch (FileNotFoundException | IOException unused) {
        }
    }

    /* renamed from: b */
    public static String m8076b() {
        return f6264b.getString(R.string.app_name);
    }

    /* renamed from: c */
    public static File m8077c() {
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), m8076b());
    }

    /* renamed from: d */
    public static String m8078d() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        if (str2.startsWith(str)) {
            return m8073a(str2);
        }
        return m8073a(str) + " " + str2;
    }

    /* renamed from: e */
    public static String m8079e() {
        return Settings.Secure.getString(m8072a().getContentResolver(), "android_id");
    }

    /* renamed from: g */
    private static void m8081g() {
        File file = new File(f6264b.getExternalCacheDir(), "TLS");
        File file2 = new File(file, "tls.xml");
        if (!file.exists()) {
            file.mkdirs();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file2);
        m8075a("https://eidas.agid.gov.it/TL/TSL-IT.xml", (OutputStream) fileOutputStream);
        fileOutputStream.close();
    }

    /* renamed from: h */
    private void m8082h() {
        File file = new File(new File(f6264b.getExternalCacheDir(), "TLS"), "tls.xml");
        DocumentBuilderFactory newInstance = DocumentBuilderFactory.newInstance();
        newInstance.setNamespaceAware(false);
        Document parse = newInstance.newDocumentBuilder().parse(file);
        XPath newXPath = XPathFactory.newInstance().newXPath();
        NodeList nodeList = (NodeList) newXPath.compile("//X509Certificate").evaluate(parse, XPathConstants.NODESET);
        System.out.println(nodeList.getLength());
        for (int i = 0; i < nodeList.getLength(); i++) {
            byte[] a = C2137a.m8392a(((Element) nodeList.item(i)).getTextContent());
            C1455d.m5485a().mo6918a((X509Certificate) CertificateFactory.getInstance("X509").generateCertificate(new ByteArrayInputStream(a)));
        }
        NodeList nodeList2 = (NodeList) newXPath.compile("//dateTime").evaluate(parse, XPathConstants.NODESET);
        System.out.println(nodeList2.getLength());
        if (nodeList2.getLength() > 0) {
            C2078b.m8281b("TLS_NEXT_UPDATE", ((Element) nodeList2.item(0)).getTextContent());
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public /* synthetic */ void m8083i() {
        if (C2078b.m8279a("TLS_NEXT_UPDATE", (String) null) == null) {
            C2078b.m8281b("TLS_NEXT_UPDATE", "2020-01-01T00:00:00Z");
        }
        try {
            if (new Date().after(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(C2078b.m8279a("TLS_NEXT_UPDATE", "2020-01-01T00:00:00Z")))) {
                m8081g();
            }
            m8082h();
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        } catch (CertificateException e2) {
            e2.printStackTrace();
        } catch (XPathExpressionException e3) {
            e3.printStackTrace();
        } catch (IOException e4) {
            e4.printStackTrace();
        } catch (SAXException e5) {
            e5.printStackTrace();
        } catch (ParserConfigurationException e6) {
            e6.printStackTrace();
        }
    }

    public void onCreate() {
        super.onCreate();
        f6264b = this;
        C2070b.m8242a();
        C1941e.m7994a(getApplicationContext());
        Security.insertProviderAt(new BouncyCastleProvider(), 1);
        Parse.enableLocalDatastore(this);
        Parse.initialize(new Parse.Configuration.Builder(this).applicationId("1WjOGTUd7Gq5BCgLcv1XK7uPt0l8xDAMfLit2T4q").clientKey("XgHWfChCgF0OwAG8ej4AHRioQCPXge4x3WWZ04g2").server("https://parseapi.back4app.com/").enableLocalDataStore().build());
        final ParseInstallation currentInstallation = ParseInstallation.getCurrentInstallation();
        currentInstallation.put("GCMSenderId", "183847050497");
        currentInstallation.put("deviceId", m8079e());
        currentInstallation.put("type", "Android");
        currentInstallation.put("model", m8078d());
        currentInstallation.put("brand", Build.BRAND);
        currentInstallation.put("device", Build.DEVICE);
        currentInstallation.put("os", "" + Build.VERSION.SDK_INT);
        currentInstallation.put("product", Build.PRODUCT);
        currentInstallation.put("board", Build.BOARD);
        currentInstallation.put("serial", Build.SERIAL);
        currentInstallation.put("country", Locale.getDefault().getCountry());
        currentInstallation.saveInBackground(new SaveCallback() {
            public void done(ParseException parseException) {
                if (parseException == null) {
                    String string = currentInstallation.getString("deviceToken");
                    String f = MainApplication.f6263a;
                    Log.d(f, "device token " + string);
                    if (string == null) {
                        FirebaseInstanceId.getInstance().getInstanceId().addOnCompleteListener(new OnCompleteListener<InstanceIdResult>() {
                            public void onComplete(Task<InstanceIdResult> task) {
                                if (!task.isSuccessful()) {
                                    Log.w(MainApplication.f6263a, "getInstanceId failed", task.getException());
                                    return;
                                }
                                String token = task.getResult().getToken();
                                String f = MainApplication.f6263a;
                                Log.d(f, "getInstanceId succeds " + token);
                                currentInstallation.put("deviceToken2", token);
                                ParseFCM.register(token);
                            }
                        });
                        return;
                    }
                    return;
                }
                parseException.printStackTrace();
                ParseObject create = ParseObject.create("Exception");
                StringWriter stringWriter = new StringWriter();
                parseException.printStackTrace(new PrintWriter(stringWriter));
                create.put("stackTrace", stringWriter.getBuffer().toString());
                create.saveInBackground();
            }
        });
        ParseConfig.getInBackground($$Lambda$MainApplication$YBoH8kwQZ1gLo6p6IZO3wQUscSo.INSTANCE);
        if (!C2078b.m8280a("REGISTERED", false)) {
            ParseObject parseObject = new ParseObject("Device");
            parseObject.put("deviceId", m8079e());
            parseObject.put("type", "Android");
            parseObject.put("model", m8078d());
            parseObject.put("brand", Build.BRAND);
            parseObject.put("device", Build.DEVICE);
            parseObject.put("product", Build.PRODUCT);
            parseObject.put("board", Build.BOARD);
            parseObject.put("serial", Build.SERIAL);
            parseObject.put("osVersion", Build.VERSION.RELEASE);
            parseObject.put("appVersion", "1.1.5");
            parseObject.put("country", Locale.getDefault().getCountry());
            parseObject.put("language", Locale.getDefault().toLanguageTag());
            parseObject.saveInBackground(new SaveCallback() {
                public void done(ParseException parseException) {
                    if (parseException == null) {
                        C2078b.m8282b("REGISTERED", true);
                    } else {
                        parseException.printStackTrace();
                    }
                }
            });
        }
        MobileAds.initialize((Context) this, (OnInitializationCompleteListener) new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        C2140d.m8402a(new Runnable() {
            public final void run() {
                MainApplication.this.m8083i();
            }
        }, ParseQuery.MAX_LIMIT);
    }
}
