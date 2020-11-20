package com.parse;

import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

class ParseCorePlugins {
    static final String FILENAME_CURRENT_CONFIG = "currentConfig";
    static final String FILENAME_CURRENT_INSTALLATION = "currentInstallation";
    static final String FILENAME_CURRENT_USER = "currentUser";
    private static final ParseCorePlugins INSTANCE = new ParseCorePlugins();
    static final String PIN_CURRENT_INSTALLATION = "_currentInstallation";
    static final String PIN_CURRENT_USER = "_currentUser";
    private AtomicReference<ParseAnalyticsController> analyticsController = new AtomicReference<>();
    private AtomicReference<ParseAuthenticationManager> authenticationController = new AtomicReference<>();
    private AtomicReference<ParseCloudCodeController> cloudCodeController = new AtomicReference<>();
    private AtomicReference<ParseConfigController> configController = new AtomicReference<>();
    private AtomicReference<ParseCurrentInstallationController> currentInstallationController = new AtomicReference<>();
    private AtomicReference<ParseCurrentUserController> currentUserController = new AtomicReference<>();
    private AtomicReference<ParseDefaultACLController> defaultACLController = new AtomicReference<>();
    private AtomicReference<ParseFileController> fileController = new AtomicReference<>();
    private AtomicReference<LocalIdManager> localIdManager = new AtomicReference<>();
    private AtomicReference<ParseObjectController> objectController = new AtomicReference<>();
    private AtomicReference<ParsePushChannelsController> pushChannelsController = new AtomicReference<>();
    private AtomicReference<ParsePushController> pushController = new AtomicReference<>();
    private AtomicReference<ParseQueryController> queryController = new AtomicReference<>();
    private AtomicReference<ParseSessionController> sessionController = new AtomicReference<>();
    private AtomicReference<ParseObjectSubclassingController> subclassingController = new AtomicReference<>();
    private AtomicReference<ParseUserController> userController = new AtomicReference<>();

    private ParseCorePlugins() {
    }

    public static ParseCorePlugins getInstance() {
        return INSTANCE;
    }

    public ParseAnalyticsController getAnalyticsController() {
        if (this.analyticsController.get() == null) {
            this.analyticsController.compareAndSet((Object) null, new ParseAnalyticsController(Parse.getEventuallyQueue()));
        }
        return this.analyticsController.get();
    }

    public ParseAuthenticationManager getAuthenticationManager() {
        if (this.authenticationController.get() == null) {
            this.authenticationController.compareAndSet((Object) null, new ParseAuthenticationManager(getCurrentUserController()));
        }
        return this.authenticationController.get();
    }

    public ParseCloudCodeController getCloudCodeController() {
        if (this.cloudCodeController.get() == null) {
            this.cloudCodeController.compareAndSet((Object) null, new ParseCloudCodeController(ParsePlugins.get().restClient()));
        }
        return this.cloudCodeController.get();
    }

    public ParseConfigController getConfigController() {
        if (this.configController.get() == null) {
            this.configController.compareAndSet((Object) null, new ParseConfigController(ParsePlugins.get().restClient(), new ParseCurrentConfigController(new File(ParsePlugins.get().getParseDir(), FILENAME_CURRENT_CONFIG))));
        }
        return this.configController.get();
    }

    public ParseCurrentInstallationController getCurrentInstallationController() {
        if (this.currentInstallationController.get() == null) {
            FileObjectStore fileObjectStore = new FileObjectStore(ParseInstallation.class, new File(ParsePlugins.get().getParseDir(), FILENAME_CURRENT_INSTALLATION), ParseObjectCurrentCoder.get());
            this.currentInstallationController.compareAndSet((Object) null, new CachedCurrentInstallationController(Parse.isLocalDatastoreEnabled() ? new OfflineObjectStore(ParseInstallation.class, PIN_CURRENT_INSTALLATION, fileObjectStore) : fileObjectStore, ParsePlugins.get().installationId()));
        }
        return this.currentInstallationController.get();
    }

    public ParseCurrentUserController getCurrentUserController() {
        if (this.currentUserController.get() == null) {
            FileObjectStore fileObjectStore = new FileObjectStore(ParseUser.class, new File(Parse.getParseDir(), FILENAME_CURRENT_USER), (ParseObjectCurrentCoder) ParseUserCurrentCoder.get());
            this.currentUserController.compareAndSet((Object) null, new CachedCurrentUserController(Parse.isLocalDatastoreEnabled() ? new OfflineObjectStore(ParseUser.class, PIN_CURRENT_USER, fileObjectStore) : fileObjectStore));
        }
        return this.currentUserController.get();
    }

    public ParseDefaultACLController getDefaultACLController() {
        if (this.defaultACLController.get() == null) {
            this.defaultACLController.compareAndSet((Object) null, new ParseDefaultACLController());
        }
        return this.defaultACLController.get();
    }

    public ParseFileController getFileController() {
        if (this.fileController.get() == null) {
            this.fileController.compareAndSet((Object) null, new ParseFileController(ParsePlugins.get().restClient(), Parse.getParseCacheDir("files")));
        }
        return this.fileController.get();
    }

    public LocalIdManager getLocalIdManager() {
        if (this.localIdManager.get() == null) {
            this.localIdManager.compareAndSet((Object) null, new LocalIdManager(Parse.getParseDir()));
        }
        return this.localIdManager.get();
    }

    public ParseObjectController getObjectController() {
        if (this.objectController.get() == null) {
            this.objectController.compareAndSet((Object) null, new NetworkObjectController(ParsePlugins.get().restClient()));
        }
        return this.objectController.get();
    }

    public ParsePushChannelsController getPushChannelsController() {
        if (this.pushChannelsController.get() == null) {
            this.pushChannelsController.compareAndSet((Object) null, new ParsePushChannelsController());
        }
        return this.pushChannelsController.get();
    }

    public ParsePushController getPushController() {
        if (this.pushController.get() == null) {
            this.pushController.compareAndSet((Object) null, new ParsePushController(ParsePlugins.get().restClient()));
        }
        return this.pushController.get();
    }

    public ParseQueryController getQueryController() {
        if (this.queryController.get() == null) {
            NetworkQueryController networkQueryController = new NetworkQueryController(ParsePlugins.get().restClient());
            this.queryController.compareAndSet((Object) null, Parse.isLocalDatastoreEnabled() ? new OfflineQueryController(Parse.getLocalDatastore(), networkQueryController) : new CacheQueryController(networkQueryController));
        }
        return this.queryController.get();
    }

    public ParseSessionController getSessionController() {
        if (this.sessionController.get() == null) {
            this.sessionController.compareAndSet((Object) null, new NetworkSessionController(ParsePlugins.get().restClient()));
        }
        return this.sessionController.get();
    }

    public ParseObjectSubclassingController getSubclassingController() {
        if (this.subclassingController.get() == null) {
            this.subclassingController.compareAndSet((Object) null, new ParseObjectSubclassingController());
        }
        return this.subclassingController.get();
    }

    public ParseUserController getUserController() {
        if (this.userController.get() == null) {
            this.userController.compareAndSet((Object) null, new NetworkUserController(ParsePlugins.get().restClient()));
        }
        return this.userController.get();
    }

    public void registerAnalyticsController(ParseAnalyticsController parseAnalyticsController) {
        if (!this.analyticsController.compareAndSet((Object) null, parseAnalyticsController)) {
            throw new IllegalStateException("Another analytics controller was already registered: " + this.analyticsController.get());
        }
    }

    public void registerAuthenticationManager(ParseAuthenticationManager parseAuthenticationManager) {
        if (!this.authenticationController.compareAndSet((Object) null, parseAuthenticationManager)) {
            throw new IllegalStateException("Another authentication manager was already registered: " + this.authenticationController.get());
        }
    }

    public void registerCloudCodeController(ParseCloudCodeController parseCloudCodeController) {
        if (!this.cloudCodeController.compareAndSet((Object) null, parseCloudCodeController)) {
            throw new IllegalStateException("Another cloud code controller was already registered: " + this.cloudCodeController.get());
        }
    }

    public void registerConfigController(ParseConfigController parseConfigController) {
        if (!this.configController.compareAndSet((Object) null, parseConfigController)) {
            throw new IllegalStateException("Another config controller was already registered: " + this.configController.get());
        }
    }

    public void registerCurrentInstallationController(ParseCurrentInstallationController parseCurrentInstallationController) {
        if (!this.currentInstallationController.compareAndSet((Object) null, parseCurrentInstallationController)) {
            throw new IllegalStateException("Another currentInstallation controller was already registered: " + this.currentInstallationController.get());
        }
    }

    public void registerCurrentUserController(ParseCurrentUserController parseCurrentUserController) {
        if (!this.currentUserController.compareAndSet((Object) null, parseCurrentUserController)) {
            throw new IllegalStateException("Another currentUser controller was already registered: " + this.currentUserController.get());
        }
    }

    public void registerDefaultACLController(ParseDefaultACLController parseDefaultACLController) {
        if (!this.defaultACLController.compareAndSet((Object) null, parseDefaultACLController)) {
            throw new IllegalStateException("Another defaultACL controller was already registered: " + this.defaultACLController.get());
        }
    }

    public void registerFileController(ParseFileController parseFileController) {
        if (!this.fileController.compareAndSet((Object) null, parseFileController)) {
            throw new IllegalStateException("Another file controller was already registered: " + this.fileController.get());
        }
    }

    public void registerLocalIdManager(LocalIdManager localIdManager2) {
        if (!this.localIdManager.compareAndSet((Object) null, localIdManager2)) {
            throw new IllegalStateException("Another localId manager was already registered: " + this.localIdManager.get());
        }
    }

    public void registerObjectController(ParseObjectController parseObjectController) {
        if (!this.objectController.compareAndSet((Object) null, parseObjectController)) {
            throw new IllegalStateException("Another object controller was already registered: " + this.objectController.get());
        }
    }

    public void registerPushChannelsController(ParsePushChannelsController parsePushChannelsController) {
        if (!this.pushChannelsController.compareAndSet((Object) null, parsePushChannelsController)) {
            throw new IllegalStateException("Another pushChannels controller was already registered: " + this.pushChannelsController.get());
        }
    }

    public void registerPushController(ParsePushController parsePushController) {
        if (!this.pushController.compareAndSet((Object) null, parsePushController)) {
            throw new IllegalStateException("Another push controller was already registered: " + this.pushController.get());
        }
    }

    public void registerQueryController(ParseQueryController parseQueryController) {
        if (!this.queryController.compareAndSet((Object) null, parseQueryController)) {
            throw new IllegalStateException("Another query controller was already registered: " + this.queryController.get());
        }
    }

    public void registerSessionController(ParseSessionController parseSessionController) {
        if (!this.sessionController.compareAndSet((Object) null, parseSessionController)) {
            throw new IllegalStateException("Another session controller was already registered: " + this.sessionController.get());
        }
    }

    public void registerSubclassingController(ParseObjectSubclassingController parseObjectSubclassingController) {
        if (!this.subclassingController.compareAndSet((Object) null, parseObjectSubclassingController)) {
            throw new IllegalStateException("Another subclassing controller was already registered: " + this.subclassingController.get());
        }
    }

    public void registerUserController(ParseUserController parseUserController) {
        if (!this.userController.compareAndSet((Object) null, parseUserController)) {
            throw new IllegalStateException("Another user controller was already registered: " + this.userController.get());
        }
    }

    /* access modifiers changed from: package-private */
    public void reset() {
        this.objectController.set((Object) null);
        this.userController.set((Object) null);
        this.sessionController.set((Object) null);
        this.currentUserController.set((Object) null);
        this.currentInstallationController.set((Object) null);
        this.authenticationController.set((Object) null);
        this.queryController.set((Object) null);
        this.fileController.set((Object) null);
        this.analyticsController.set((Object) null);
        this.cloudCodeController.set((Object) null);
        this.configController.set((Object) null);
        this.pushController.set((Object) null);
        this.pushChannelsController.set((Object) null);
        this.defaultACLController.set((Object) null);
        this.localIdManager.set((Object) null);
    }
}
