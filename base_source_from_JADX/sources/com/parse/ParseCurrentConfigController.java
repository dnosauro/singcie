package com.parse;

import bolts.Task;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.Callable;
import org.json.JSONException;
import org.json.JSONObject;

class ParseCurrentConfigController {
    ParseConfig currentConfig;
    private File currentConfigFile;
    /* access modifiers changed from: private */
    public final Object currentConfigMutex = new Object();

    public ParseCurrentConfigController(File file) {
        this.currentConfigFile = file;
    }

    /* access modifiers changed from: package-private */
    public void clearCurrentConfigForTesting() {
        synchronized (this.currentConfigMutex) {
            this.currentConfig = null;
        }
    }

    public Task<ParseConfig> getCurrentConfigAsync() {
        return Task.call(new Callable<ParseConfig>() {
            public ParseConfig call() {
                synchronized (ParseCurrentConfigController.this.currentConfigMutex) {
                    if (ParseCurrentConfigController.this.currentConfig == null) {
                        ParseConfig fromDisk = ParseCurrentConfigController.this.getFromDisk();
                        ParseCurrentConfigController parseCurrentConfigController = ParseCurrentConfigController.this;
                        if (fromDisk == null) {
                            fromDisk = new ParseConfig();
                        }
                        parseCurrentConfigController.currentConfig = fromDisk;
                    }
                }
                return ParseCurrentConfigController.this.currentConfig;
            }
        }, ParseExecutors.m8824io());
    }

    /* access modifiers changed from: package-private */
    public ParseConfig getFromDisk() {
        try {
            return ParseConfig.decode(ParseFileUtils.readFileToJSONObject(this.currentConfigFile), ParseDecoder.get());
        } catch (IOException | JSONException unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public void saveToDisk(ParseConfig parseConfig) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("params", (JSONObject) NoObjectsEncoder.get().encode(parseConfig.getParams()));
            try {
                ParseFileUtils.writeJSONObjectToFile(this.currentConfigFile, jSONObject);
            } catch (IOException unused) {
            }
        } catch (JSONException unused2) {
            throw new RuntimeException("could not serialize config to JSON");
        }
    }

    public Task<Void> setCurrentConfigAsync(final ParseConfig parseConfig) {
        return Task.call(new Callable<Void>() {
            public Void call() {
                synchronized (ParseCurrentConfigController.this.currentConfigMutex) {
                    ParseCurrentConfigController.this.currentConfig = parseConfig;
                    ParseCurrentConfigController.this.saveToDisk(parseConfig);
                }
                return null;
            }
        }, ParseExecutors.m8824io());
    }
}
