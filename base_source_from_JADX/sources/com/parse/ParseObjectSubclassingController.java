package com.parse;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Map;

class ParseObjectSubclassingController {
    private final Object mutex = new Object();
    private final Map<String, Constructor<? extends ParseObject>> registeredSubclasses = new HashMap();

    ParseObjectSubclassingController() {
    }

    private static Constructor<? extends ParseObject> getConstructor(Class<? extends ParseObject> cls) {
        Constructor<? extends ParseObject> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
        if (declaredConstructor != null) {
            int modifiers = declaredConstructor.getModifiers();
            if (Modifier.isPublic(modifiers) || (cls.getPackage().getName().equals("com.parse") && !Modifier.isProtected(modifiers) && !Modifier.isPrivate(modifiers))) {
                return declaredConstructor;
            }
            throw new IllegalAccessException();
        }
        throw new NoSuchMethodException();
    }

    /* access modifiers changed from: package-private */
    public String getClassName(Class<? extends ParseObject> cls) {
        ParseClassName parseClassName = (ParseClassName) cls.getAnnotation(ParseClassName.class);
        if (parseClassName != null) {
            return parseClassName.value();
        }
        throw new IllegalArgumentException("No ParseClassName annotation provided on " + cls);
    }

    /* access modifiers changed from: package-private */
    public boolean isSubclassValid(String str, Class<? extends ParseObject> cls) {
        Constructor constructor;
        synchronized (this.mutex) {
            constructor = this.registeredSubclasses.get(str);
        }
        if (constructor == null) {
            if (cls == ParseObject.class) {
                return true;
            }
        } else if (constructor.getDeclaringClass() == cls) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public ParseObject newInstance(String str) {
        Constructor constructor;
        synchronized (this.mutex) {
            constructor = this.registeredSubclasses.get(str);
        }
        if (constructor == null) {
            return new ParseObject(str);
        }
        try {
            return (ParseObject) constructor.newInstance(new Object[0]);
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception e2) {
            throw new RuntimeException("Failed to create instance of subclass.", e2);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x006a, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0076, code lost:
        if (r0.equals(getClassName(com.parse.ParseUser.class)) == false) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0078, code lost:
        com.parse.ParseUser.getCurrentUserController().clearFromMemory();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        if (r0.equals(getClassName(com.parse.ParseInstallation.class)) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008c, code lost:
        com.parse.ParseInstallation.getCurrentInstallationController().clearFromMemory();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0094 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void registerSubclass(java.lang.Class<? extends com.parse.ParseObject> r7) {
        /*
            r6 = this;
            java.lang.Class<com.parse.ParseObject> r0 = com.parse.ParseObject.class
            boolean r0 = r0.isAssignableFrom(r7)
            if (r0 == 0) goto L_0x00bb
            java.lang.String r0 = r6.getClassName(r7)
            java.lang.Object r1 = r6.mutex
            monitor-enter(r1)
            java.util.Map<java.lang.String, java.lang.reflect.Constructor<? extends com.parse.ParseObject>> r2 = r6.registeredSubclasses     // Catch:{ all -> 0x00b8 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x00b8 }
            java.lang.reflect.Constructor r2 = (java.lang.reflect.Constructor) r2     // Catch:{ all -> 0x00b8 }
            if (r2 == 0) goto L_0x0060
            java.lang.Class r3 = r2.getDeclaringClass()     // Catch:{ all -> 0x00b8 }
            boolean r4 = r7.isAssignableFrom(r3)     // Catch:{ all -> 0x00b8 }
            if (r4 == 0) goto L_0x0025
            monitor-exit(r1)     // Catch:{ all -> 0x00b8 }
            return
        L_0x0025:
            boolean r4 = r3.isAssignableFrom(r7)     // Catch:{ all -> 0x00b8 }
            if (r4 == 0) goto L_0x002c
            goto L_0x0060
        L_0x002c:
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00b8 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r4.<init>()     // Catch:{ all -> 0x00b8 }
            java.lang.String r5 = "Tried to register both "
            r4.append(r5)     // Catch:{ all -> 0x00b8 }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x00b8 }
            r4.append(r3)     // Catch:{ all -> 0x00b8 }
            java.lang.String r3 = " and "
            r4.append(r3)     // Catch:{ all -> 0x00b8 }
            java.lang.String r7 = r7.getName()     // Catch:{ all -> 0x00b8 }
            r4.append(r7)     // Catch:{ all -> 0x00b8 }
            java.lang.String r7 = " as the ParseObject subclass of "
            r4.append(r7)     // Catch:{ all -> 0x00b8 }
            r4.append(r0)     // Catch:{ all -> 0x00b8 }
            java.lang.String r7 = ". Cannot determine the right class to use because neither inherits from the other."
            r4.append(r7)     // Catch:{ all -> 0x00b8 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x00b8 }
            r2.<init>(r7)     // Catch:{ all -> 0x00b8 }
            throw r2     // Catch:{ all -> 0x00b8 }
        L_0x0060:
            java.util.Map<java.lang.String, java.lang.reflect.Constructor<? extends com.parse.ParseObject>> r3 = r6.registeredSubclasses     // Catch:{ NoSuchMethodException -> 0x00b0, IllegalAccessException -> 0x0094 }
            java.lang.reflect.Constructor r4 = getConstructor(r7)     // Catch:{ NoSuchMethodException -> 0x00b0, IllegalAccessException -> 0x0094 }
            r3.put(r0, r4)     // Catch:{ NoSuchMethodException -> 0x00b0, IllegalAccessException -> 0x0094 }
            monitor-exit(r1)     // Catch:{ all -> 0x00b8 }
            if (r2 == 0) goto L_0x0093
            java.lang.Class<com.parse.ParseUser> r7 = com.parse.ParseUser.class
            java.lang.String r7 = r6.getClassName(r7)
            boolean r7 = r0.equals(r7)
            if (r7 == 0) goto L_0x0080
            com.parse.ParseCurrentUserController r7 = com.parse.ParseUser.getCurrentUserController()
            r7.clearFromMemory()
            goto L_0x0093
        L_0x0080:
            java.lang.Class<com.parse.ParseInstallation> r7 = com.parse.ParseInstallation.class
            java.lang.String r7 = r6.getClassName(r7)
            boolean r7 = r0.equals(r7)
            if (r7 == 0) goto L_0x0093
            com.parse.ParseCurrentInstallationController r7 = com.parse.ParseInstallation.getCurrentInstallationController()
            r7.clearFromMemory()
        L_0x0093:
            return
        L_0x0094:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00b8 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b8 }
            r2.<init>()     // Catch:{ all -> 0x00b8 }
            java.lang.String r3 = "Default constructor for "
            r2.append(r3)     // Catch:{ all -> 0x00b8 }
            r2.append(r7)     // Catch:{ all -> 0x00b8 }
            java.lang.String r7 = " is not accessible."
            r2.append(r7)     // Catch:{ all -> 0x00b8 }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x00b8 }
            r0.<init>(r7)     // Catch:{ all -> 0x00b8 }
            throw r0     // Catch:{ all -> 0x00b8 }
        L_0x00b0:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00b8 }
            java.lang.String r0 = "Cannot register a type that does not implement the default constructor!"
            r7.<init>(r0)     // Catch:{ all -> 0x00b8 }
            throw r7     // Catch:{ all -> 0x00b8 }
        L_0x00b8:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00b8 }
            throw r7
        L_0x00bb:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "Cannot register a type that is not a subclass of ParseObject"
            r7.<init>(r0)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.parse.ParseObjectSubclassingController.registerSubclass(java.lang.Class):void");
    }

    /* access modifiers changed from: package-private */
    public void unregisterSubclass(Class<? extends ParseObject> cls) {
        String className = getClassName(cls);
        synchronized (this.mutex) {
            this.registeredSubclasses.remove(className);
        }
    }
}
