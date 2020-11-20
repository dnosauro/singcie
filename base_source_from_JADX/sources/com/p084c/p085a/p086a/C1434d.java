package com.p084c.p085a.p086a;

import com.p084c.p085a.p086a.C1432c;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;

/* renamed from: com.c.a.a.d */
public final class C1434d {

    /* renamed from: a */
    private static final C1431b f4277a = new C1446f(C1432c.C1433a.VERBOSE, "%logger", "%date %caller%n");

    /* renamed from: b */
    private static final C1432c f4278b = new C1447g(Logger.ROOT_LOGGER_NAME, f4277a);

    /* renamed from: c */
    private static final Pattern f4279c = Pattern.compile("(.*?):(.*?)(:(.*))?");

    /* renamed from: d */
    private static final Map<String, C1431b> f4280d = Collections.unmodifiableMap(m5432a());

    /* renamed from: e */
    private static final Map<String, C1432c> f4281e = new WeakHashMap();

    private C1434d() {
        throw new UnsupportedOperationException();
    }

    /* renamed from: a */
    public static C1432c m5431a(String str) {
        C1432c cVar;
        synchronized (f4281e) {
            cVar = f4281e.get(str);
        }
        if (cVar == null) {
            cVar = new C1447g(str, m5435c(str));
            synchronized (f4281e) {
                f4281e.put(cVar.mo6893a(), cVar);
            }
        }
        return cVar;
    }

    /* renamed from: a */
    private static Map<String, C1431b> m5432a() {
        HashMap hashMap = new HashMap();
        Properties properties = new Properties();
        try {
            m5433a(properties);
            if (!properties.propertyNames().hasMoreElements()) {
                f4278b.mo6896b("Logger configuration file is empty. Default configuration will be used", new Object[0]);
                hashMap.put((Object) null, f4277a);
                return hashMap;
            }
            Enumeration<?> propertyNames = properties.propertyNames();
            while (propertyNames.hasMoreElements()) {
                String str = (String) propertyNames.nextElement();
                C1431b b = m5434b(properties.getProperty(str));
                if (b != null) {
                    if (str.equals("root")) {
                        hashMap.put((Object) null, b);
                    } else if (str.startsWith("logger.")) {
                        String substring = str.substring(7);
                        if (substring.equalsIgnoreCase(Logger.ROOT_LOGGER_NAME)) {
                            substring = null;
                        }
                        hashMap.put(substring, b);
                    } else {
                        f4278b.mo6896b("unknown key '%s' in '%s' file", str, "android-logger.properties");
                    }
                }
            }
            if (!hashMap.containsKey((Object) null)) {
                hashMap.put((Object) null, f4277a);
            }
            return hashMap;
        } catch (IOException e) {
            f4278b.mo6895a((Throwable) e, "Cannot configure logger from '%s'. Default configuration will be used", "android-logger.properties");
        }
    }

    /* renamed from: a */
    private static void m5433a(Properties properties) {
        InputStream inputStream = null;
        try {
            InputStream resourceAsStream = C1434d.class.getClassLoader().getResourceAsStream("android-logger.properties");
            if (!(resourceAsStream == null && (resourceAsStream = ClassLoader.getSystemClassLoader().getResourceAsStream("android-logger.properties")) == null)) {
                properties.load(resourceAsStream);
            }
        } finally {
            if (inputStream != null) {
                inputStream.close();
            }
        }
    }

    /* renamed from: b */
    private static C1431b m5434b(String str) {
        Matcher matcher = f4279c.matcher(str);
        if (matcher.matches()) {
            String group = matcher.group(1);
            String group2 = matcher.group(2);
            String group3 = matcher.group(4);
            if (group2.length() > 23) {
                String substring = group2.substring(0, 23);
                f4278b.mo6894a("Android doesn't support tags %d characters longer. Tag '%s' will be trimmed to '%s'", 23, group2, substring);
                group2 = substring;
            }
            try {
                return new C1446f(C1432c.C1433a.valueOf(group), group2, group3);
            } catch (IllegalArgumentException unused) {
                f4278b.mo6894a("Cannot parse '%s' as logging level. Only %s are allowed", group, Arrays.toString(C1432c.C1433a.values()));
                return null;
            }
        } else {
            f4278b.mo6894a("Wrong format of logger configuration: '%s'", str);
            return null;
        }
    }

    /* renamed from: c */
    private static C1431b m5435c(String str) {
        String str2 = null;
        if (str != null) {
            for (String next : f4280d.keySet()) {
                if (next != null && str.startsWith(next)) {
                    if ((next.length() >= str.length() || str.charAt(next.length()) == '.' || str.charAt(next.length()) == '$') && (str2 == null || str2.length() < next.length())) {
                        str2 = next;
                    }
                }
            }
        }
        C1431b bVar = f4280d.get(str2);
        return bVar != null ? bVar : f4277a;
    }
}
