package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.Base64;
import android.util.JsonReader;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.ArrayList;

public class CrashlyticsReportJsonTransform {
    private static final DataEncoder CRASHLYTICS_REPORT_JSON_ENCODER = new JsonDataEncoderBuilder().configureWith(AutoCrashlyticsReportEncoder.CONFIG).ignoreNullValues(true).build();

    private interface ObjectParser<T> {
        T parse(JsonReader jsonReader);
    }

    private static CrashlyticsReport.Session.Application parseApp(JsonReader jsonReader) {
        CrashlyticsReport.Session.Application.Builder builder = CrashlyticsReport.Session.Application.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1618432855) {
                if (hashCode != 351608024) {
                    if (hashCode != 719853845) {
                        if (hashCode == 1975623094 && nextName.equals("displayVersion")) {
                            c = 2;
                        }
                    } else if (nextName.equals("installationUuid")) {
                        c = 3;
                    }
                } else if (nextName.equals("version")) {
                    c = 1;
                }
            } else if (nextName.equals("identifier")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    builder.setIdentifier(jsonReader.nextString());
                    break;
                case 1:
                    builder.setVersion(jsonReader.nextString());
                    break;
                case 2:
                    builder.setDisplayVersion(jsonReader.nextString());
                    break;
                case 3:
                    builder.setInstallationUuid(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static <T> ImmutableList<T> parseArray(JsonReader jsonReader, ObjectParser<T> objectParser) {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(objectParser.parse(jsonReader));
        }
        jsonReader.endArray();
        return ImmutableList.from(arrayList);
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.CustomAttribute parseCustomAttribute(JsonReader jsonReader) {
        CrashlyticsReport.CustomAttribute.Builder builder = CrashlyticsReport.CustomAttribute.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 106079) {
                if (hashCode == 111972721 && nextName.equals("value")) {
                    c = 1;
                }
            } else if (nextName.equals("key")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    builder.setKey(jsonReader.nextString());
                    break;
                case 1:
                    builder.setValue(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Device parseDevice(JsonReader jsonReader) {
        CrashlyticsReport.Session.Device.Builder builder = CrashlyticsReport.Session.Device.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1981332476:
                    if (nextName.equals("simulator")) {
                        c = 5;
                        break;
                    }
                    break;
                case -1969347631:
                    if (nextName.equals("manufacturer")) {
                        c = 7;
                        break;
                    }
                    break;
                case 112670:
                    if (nextName.equals("ram")) {
                        c = 3;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c = 0;
                        break;
                    }
                    break;
                case 81784169:
                    if (nextName.equals("diskSpace")) {
                        c = 4;
                        break;
                    }
                    break;
                case 94848180:
                    if (nextName.equals("cores")) {
                        c = 2;
                        break;
                    }
                    break;
                case 104069929:
                    if (nextName.equals("model")) {
                        c = 1;
                        break;
                    }
                    break;
                case 109757585:
                    if (nextName.equals("state")) {
                        c = 6;
                        break;
                    }
                    break;
                case 2078953423:
                    if (nextName.equals("modelClass")) {
                        c = 8;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.setArch(jsonReader.nextInt());
                    break;
                case 1:
                    builder.setModel(jsonReader.nextString());
                    break;
                case 2:
                    builder.setCores(jsonReader.nextInt());
                    break;
                case 3:
                    builder.setRam(jsonReader.nextLong());
                    break;
                case 4:
                    builder.setDiskSpace(jsonReader.nextLong());
                    break;
                case 5:
                    builder.setSimulator(jsonReader.nextBoolean());
                    break;
                case 6:
                    builder.setState(jsonReader.nextInt());
                    break;
                case 7:
                    builder.setManufacturer(jsonReader.nextString());
                    break;
                case 8:
                    builder.setModelClass(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.Session.Event parseEvent(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Builder builder = CrashlyticsReport.Session.Event.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1335157162:
                    if (nextName.equals("device")) {
                        c = 3;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c = 2;
                        break;
                    }
                    break;
                case 107332:
                    if (nextName.equals("log")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c = 1;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c = 0;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.setTimestamp(jsonReader.nextLong());
                    break;
                case 1:
                    builder.setType(jsonReader.nextString());
                    break;
                case 2:
                    builder.setApp(parseEventApp(jsonReader));
                    break;
                case 3:
                    builder.setDevice(parseEventDevice(jsonReader));
                    break;
                case 4:
                    builder.setLog(parseEventLog(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application parseEventApp(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Builder builder = CrashlyticsReport.Session.Event.Application.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1332194002) {
                if (hashCode != -1090974952) {
                    if (hashCode != 555169704) {
                        if (hashCode == 928737948 && nextName.equals("uiOrientation")) {
                            c = 1;
                        }
                    } else if (nextName.equals("customAttributes")) {
                        c = 3;
                    }
                } else if (nextName.equals("execution")) {
                    c = 2;
                }
            } else if (nextName.equals("background")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    builder.setBackground(Boolean.valueOf(jsonReader.nextBoolean()));
                    break;
                case 1:
                    builder.setUiOrientation(jsonReader.nextInt());
                    break;
                case 2:
                    builder.setExecution(parseEventExecution(jsonReader));
                    break;
                case 3:
                    builder.setCustomAttributes(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$3.lambdaFactory$()));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.Session.Event.Application.Execution.BinaryImage parseEventBinaryImage(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 3373707) {
                if (hashCode != 3530753) {
                    if (hashCode != 3601339) {
                        if (hashCode == 1153765347 && nextName.equals("baseAddress")) {
                            c = 1;
                        }
                    } else if (nextName.equals("uuid")) {
                        c = 3;
                    }
                } else if (nextName.equals("size")) {
                    c = 2;
                }
            } else if (nextName.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                c = 0;
            }
            switch (c) {
                case 0:
                    builder.setName(jsonReader.nextString());
                    break;
                case 1:
                    builder.setBaseAddress(jsonReader.nextLong());
                    break;
                case 2:
                    builder.setSize(jsonReader.nextLong());
                    break;
                case 3:
                    builder.setUuidFromUtf8Bytes(Base64.decode(jsonReader.nextString(), 2));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Device parseEventDevice(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Device.Builder builder = CrashlyticsReport.Session.Event.Device.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1708606089:
                    if (nextName.equals("batteryLevel")) {
                        c = 0;
                        break;
                    }
                    break;
                case -1455558134:
                    if (nextName.equals("batteryVelocity")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1439500848:
                    if (nextName.equals("orientation")) {
                        c = 4;
                        break;
                    }
                    break;
                case 279795450:
                    if (nextName.equals("diskUsed")) {
                        c = 2;
                        break;
                    }
                    break;
                case 976541947:
                    if (nextName.equals("ramUsed")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1516795582:
                    if (nextName.equals("proximityOn")) {
                        c = 3;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.setBatteryLevel(Double.valueOf(jsonReader.nextDouble()));
                    break;
                case 1:
                    builder.setBatteryVelocity(jsonReader.nextInt());
                    break;
                case 2:
                    builder.setDiskUsed(jsonReader.nextLong());
                    break;
                case 3:
                    builder.setProximityOn(jsonReader.nextBoolean());
                    break;
                case 4:
                    builder.setOrientation(jsonReader.nextInt());
                    break;
                case 5:
                    builder.setRamUsed(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution parseEventExecution(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1337936983) {
                if (hashCode != -902467928) {
                    if (hashCode != 937615455) {
                        if (hashCode == 1481625679 && nextName.equals("exception")) {
                            c = 1;
                        }
                    } else if (nextName.equals("binaries")) {
                        c = 3;
                    }
                } else if (nextName.equals("signal")) {
                    c = 2;
                }
            } else if (nextName.equals("threads")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    builder.setThreads(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$4.lambdaFactory$()));
                    break;
                case 1:
                    builder.setException(parseEventExecutionException(jsonReader));
                    break;
                case 2:
                    builder.setSignal(parseEventSignal(jsonReader));
                    break;
                case 3:
                    builder.setBinaries(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$5.lambdaFactory$()));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution.Exception parseEventExecutionException(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c = 1;
                        break;
                    }
                    break;
                case -934964668:
                    if (nextName.equals("reason")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c = 3;
                        break;
                    }
                    break;
                case 91997906:
                    if (nextName.equals("causedBy")) {
                        c = 0;
                        break;
                    }
                    break;
                case 581754413:
                    if (nextName.equals("overflowCount")) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.setCausedBy(parseEventExecutionException(jsonReader));
                    break;
                case 1:
                    builder.setFrames(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$6.lambdaFactory$()));
                    break;
                case 2:
                    builder.setOverflowCount(jsonReader.nextInt());
                    break;
                case 3:
                    builder.setType(jsonReader.nextString());
                    break;
                case 4:
                    builder.setReason(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame parseEventFrame(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1019779949) {
                if (hashCode != -887523944) {
                    if (hashCode != 3571) {
                        if (hashCode != 3143036) {
                            if (hashCode == 2125650548 && nextName.equals("importance")) {
                                c = 0;
                            }
                        } else if (nextName.equals("file")) {
                            c = 1;
                        }
                    } else if (nextName.equals("pc")) {
                        c = 3;
                    }
                } else if (nextName.equals("symbol")) {
                    c = 4;
                }
            } else if (nextName.equals("offset")) {
                c = 2;
            }
            switch (c) {
                case 0:
                    builder.setImportance(jsonReader.nextInt());
                    break;
                case 1:
                    builder.setFile(jsonReader.nextString());
                    break;
                case 2:
                    builder.setOffset(jsonReader.nextLong());
                    break;
                case 3:
                    builder.setPc(jsonReader.nextLong());
                    break;
                case 4:
                    builder.setSymbol(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Log parseEventLog(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Log.Builder builder = CrashlyticsReport.Session.Event.Log.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            if (nextName.hashCode() == 951530617 && nextName.equals(FirebaseAnalytics.Param.CONTENT)) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else {
                builder.setContent(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution.Signal parseEventSignal(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Signal.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1147692044) {
                if (hashCode != 3059181) {
                    if (hashCode == 3373707 && nextName.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                        c = 0;
                    }
                } else if (nextName.equals("code")) {
                    c = 1;
                }
            } else if (nextName.equals("address")) {
                c = 2;
            }
            switch (c) {
                case 0:
                    builder.setName(jsonReader.nextString());
                    break;
                case 1:
                    builder.setCode(jsonReader.nextString());
                    break;
                case 2:
                    builder.setAddress(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread parseEventThread(JsonReader jsonReader) {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Thread.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -1266514778) {
                if (hashCode != 3373707) {
                    if (hashCode == 2125650548 && nextName.equals("importance")) {
                        c = 0;
                    }
                } else if (nextName.equals(AppMeasurementSdk.ConditionalUserProperty.NAME)) {
                    c = 1;
                }
            } else if (nextName.equals("frames")) {
                c = 2;
            }
            switch (c) {
                case 0:
                    builder.setImportance(jsonReader.nextInt());
                    break;
                case 1:
                    builder.setName(jsonReader.nextString());
                    break;
                case 2:
                    builder.setFrames(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$7.lambdaFactory$()));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.FilesPayload.File parseFile(JsonReader jsonReader) {
        CrashlyticsReport.FilesPayload.File.Builder builder = CrashlyticsReport.FilesPayload.File.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -734768633) {
                if (hashCode == -567321830 && nextName.equals("contents")) {
                    c = 1;
                }
            } else if (nextName.equals("filename")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    builder.setFilename(jsonReader.nextString());
                    break;
                case 1:
                    builder.setContents(Base64.decode(jsonReader.nextString(), 2));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.FilesPayload parseNdkPayload(JsonReader jsonReader) {
        CrashlyticsReport.FilesPayload.Builder builder = CrashlyticsReport.FilesPayload.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != 97434231) {
                if (hashCode == 106008351 && nextName.equals("orgId")) {
                    c = 1;
                }
            } else if (nextName.equals("files")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    builder.setFiles(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$2.lambdaFactory$()));
                    break;
                case 1:
                    builder.setOrgId(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.OperatingSystem parseOs(JsonReader jsonReader) {
        CrashlyticsReport.Session.OperatingSystem.Builder builder = CrashlyticsReport.Session.OperatingSystem.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -911706486) {
                if (hashCode != -293026577) {
                    if (hashCode != 351608024) {
                        if (hashCode == 1874684019 && nextName.equals("platform")) {
                            c = 0;
                        }
                    } else if (nextName.equals("version")) {
                        c = 1;
                    }
                } else if (nextName.equals("jailbroken")) {
                    c = 3;
                }
            } else if (nextName.equals("buildVersion")) {
                c = 2;
            }
            switch (c) {
                case 0:
                    builder.setPlatform(jsonReader.nextInt());
                    break;
                case 1:
                    builder.setVersion(jsonReader.nextString());
                    break;
                case 2:
                    builder.setBuildVersion(jsonReader.nextString());
                    break;
                case 3:
                    builder.setJailbroken(jsonReader.nextBoolean());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport parseReport(JsonReader jsonReader) {
        CrashlyticsReport.Builder builder = CrashlyticsReport.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c = 7;
                        break;
                    }
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c = 0;
                        break;
                    }
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c = 4;
                        break;
                    }
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c = 1;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c = 3;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c = 2;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c = 5;
                        break;
                    }
                    break;
                case 1984987798:
                    if (nextName.equals("session")) {
                        c = 6;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.setSdkVersion(jsonReader.nextString());
                    break;
                case 1:
                    builder.setGmpAppId(jsonReader.nextString());
                    break;
                case 2:
                    builder.setPlatform(jsonReader.nextInt());
                    break;
                case 3:
                    builder.setInstallationUuid(jsonReader.nextString());
                    break;
                case 4:
                    builder.setBuildVersion(jsonReader.nextString());
                    break;
                case 5:
                    builder.setDisplayVersion(jsonReader.nextString());
                    break;
                case 6:
                    builder.setSession(parseSession(jsonReader));
                    break;
                case 7:
                    builder.setNdkPayload(parseNdkPayload(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session parseSession(JsonReader jsonReader) {
        CrashlyticsReport.Session.Builder builder = CrashlyticsReport.Session.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            switch (nextName.hashCode()) {
                case -2128794476:
                    if (nextName.equals("startedAt")) {
                        c = 2;
                        break;
                    }
                    break;
                case -1618432855:
                    if (nextName.equals("identifier")) {
                        c = 1;
                        break;
                    }
                    break;
                case -1606742899:
                    if (nextName.equals("endedAt")) {
                        c = 3;
                        break;
                    }
                    break;
                case -1335157162:
                    if (nextName.equals("device")) {
                        c = 8;
                        break;
                    }
                    break;
                case -1291329255:
                    if (nextName.equals("events")) {
                        c = 9;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals("os")) {
                        c = 7;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals("app")) {
                        c = 6;
                        break;
                    }
                    break;
                case 3599307:
                    if (nextName.equals("user")) {
                        c = 5;
                        break;
                    }
                    break;
                case 286956243:
                    if (nextName.equals("generator")) {
                        c = 0;
                        break;
                    }
                    break;
                case 1025385094:
                    if (nextName.equals("crashed")) {
                        c = 4;
                        break;
                    }
                    break;
                case 2047016109:
                    if (nextName.equals("generatorType")) {
                        c = 10;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    builder.setGenerator(jsonReader.nextString());
                    break;
                case 1:
                    builder.setIdentifierFromUtf8Bytes(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 2:
                    builder.setStartedAt(jsonReader.nextLong());
                    break;
                case 3:
                    builder.setEndedAt(Long.valueOf(jsonReader.nextLong()));
                    break;
                case 4:
                    builder.setCrashed(jsonReader.nextBoolean());
                    break;
                case 5:
                    builder.setUser(parseUser(jsonReader));
                    break;
                case 6:
                    builder.setApp(parseApp(jsonReader));
                    break;
                case 7:
                    builder.setOs(parseOs(jsonReader));
                    break;
                case 8:
                    builder.setDevice(parseDevice(jsonReader));
                    break;
                case 9:
                    builder.setEvents(parseArray(jsonReader, CrashlyticsReportJsonTransform$$Lambda$1.lambdaFactory$()));
                    break;
                case 10:
                    builder.setGeneratorType(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.User parseUser(JsonReader jsonReader) {
        CrashlyticsReport.Session.User.Builder builder = CrashlyticsReport.Session.User.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            char c = 65535;
            if (nextName.hashCode() == -1618432855 && nextName.equals("identifier")) {
                c = 0;
            }
            if (c != 0) {
                jsonReader.skipValue();
            } else {
                builder.setIdentifier(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event eventFromJson(java.lang.String r3) {
        /*
            r2 = this;
            android.util.JsonReader r0 = new android.util.JsonReader     // Catch:{ IllegalStateException -> 0x0017 }
            java.io.StringReader r1 = new java.io.StringReader     // Catch:{ IllegalStateException -> 0x0017 }
            r1.<init>(r3)     // Catch:{ IllegalStateException -> 0x0017 }
            r0.<init>(r1)     // Catch:{ IllegalStateException -> 0x0017 }
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event r3 = parseEvent(r0)     // Catch:{ Throwable -> 0x0012 }
            r0.close()     // Catch:{ IllegalStateException -> 0x0017 }
            return r3
        L_0x0012:
            r3 = move-exception
            r0.close()     // Catch:{ Throwable -> 0x0016 }
        L_0x0016:
            throw r3     // Catch:{ IllegalStateException -> 0x0017 }
        L_0x0017:
            r3 = move-exception
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.eventFromJson(java.lang.String):com.google.firebase.crashlytics.internal.model.CrashlyticsReport$Session$Event");
    }

    public String eventToJson(CrashlyticsReport.Session.Event event) {
        return CRASHLYTICS_REPORT_JSON_ENCODER.encode(event);
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0016 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.firebase.crashlytics.internal.model.CrashlyticsReport reportFromJson(java.lang.String r3) {
        /*
            r2 = this;
            android.util.JsonReader r0 = new android.util.JsonReader     // Catch:{ IllegalStateException -> 0x0017 }
            java.io.StringReader r1 = new java.io.StringReader     // Catch:{ IllegalStateException -> 0x0017 }
            r1.<init>(r3)     // Catch:{ IllegalStateException -> 0x0017 }
            r0.<init>(r1)     // Catch:{ IllegalStateException -> 0x0017 }
            com.google.firebase.crashlytics.internal.model.CrashlyticsReport r3 = parseReport(r0)     // Catch:{ Throwable -> 0x0012 }
            r0.close()     // Catch:{ IllegalStateException -> 0x0017 }
            return r3
        L_0x0012:
            r3 = move-exception
            r0.close()     // Catch:{ Throwable -> 0x0016 }
        L_0x0016:
            throw r3     // Catch:{ IllegalStateException -> 0x0017 }
        L_0x0017:
            r3 = move-exception
            java.io.IOException r0 = new java.io.IOException
            r0.<init>(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.crashlytics.internal.model.serialization.CrashlyticsReportJsonTransform.reportFromJson(java.lang.String):com.google.firebase.crashlytics.internal.model.CrashlyticsReport");
    }

    public String reportToJson(CrashlyticsReport crashlyticsReport) {
        return CRASHLYTICS_REPORT_JSON_ENCODER.encode(crashlyticsReport);
    }
}
