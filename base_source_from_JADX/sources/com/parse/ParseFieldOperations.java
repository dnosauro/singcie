package com.parse;

import android.os.Parcel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

final class ParseFieldOperations {
    private static Map<String, ParseFieldOperationFactory> opDecoderMap = new HashMap();

    private interface ParseFieldOperationFactory {
        ParseFieldOperation decode(Parcel parcel, ParseParcelDecoder parseParcelDecoder);

        ParseFieldOperation decode(JSONObject jSONObject, ParseDecoder parseDecoder);
    }

    private ParseFieldOperations() {
    }

    static ParseFieldOperation decode(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
        String readString = parcel.readString();
        ParseFieldOperationFactory parseFieldOperationFactory = opDecoderMap.get(readString);
        if (parseFieldOperationFactory != null) {
            return parseFieldOperationFactory.decode(parcel, parseParcelDecoder);
        }
        throw new RuntimeException("Unable to decode operation of type " + readString);
    }

    static ParseFieldOperation decode(JSONObject jSONObject, ParseDecoder parseDecoder) {
        String optString = jSONObject.optString("__op");
        ParseFieldOperationFactory parseFieldOperationFactory = opDecoderMap.get(optString);
        if (parseFieldOperationFactory != null) {
            return parseFieldOperationFactory.decode(jSONObject, parseDecoder);
        }
        throw new RuntimeException("Unable to decode operation of type " + optString);
    }

    static ArrayList<Object> jsonArrayAsArrayList(JSONArray jSONArray) {
        ArrayList<Object> arrayList = new ArrayList<>(jSONArray.length());
        int i = 0;
        while (i < jSONArray.length()) {
            try {
                arrayList.add(jSONArray.get(i));
                i++;
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        }
        return arrayList;
    }

    private static void registerDecoder(String str, ParseFieldOperationFactory parseFieldOperationFactory) {
        opDecoderMap.put(str, parseFieldOperationFactory);
    }

    static void registerDefaultDecoders() {
        registerDecoder("Batch", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
                return ParseFieldOperations.decode(parcel, parseParcelDecoder).mergeWithPrevious(ParseFieldOperations.decode(parcel, parseParcelDecoder));
            }

            public ParseFieldOperation decode(JSONObject jSONObject, ParseDecoder parseDecoder) {
                JSONArray jSONArray = jSONObject.getJSONArray("ops");
                ParseFieldOperation parseFieldOperation = null;
                for (int i = 0; i < jSONArray.length(); i++) {
                    parseFieldOperation = ParseFieldOperations.decode(jSONArray.getJSONObject(i), parseDecoder).mergeWithPrevious(parseFieldOperation);
                }
                return parseFieldOperation;
            }
        });
        registerDecoder("Delete", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
                return ParseDeleteOperation.getInstance();
            }

            public ParseFieldOperation decode(JSONObject jSONObject, ParseDecoder parseDecoder) {
                return ParseDeleteOperation.getInstance();
            }
        });
        registerDecoder("Increment", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
                return new ParseIncrementOperation((Number) parseParcelDecoder.decode(parcel));
            }

            public ParseFieldOperation decode(JSONObject jSONObject, ParseDecoder parseDecoder) {
                return new ParseIncrementOperation((Number) parseDecoder.decode(jSONObject.opt("amount")));
            }
        });
        registerDecoder("Add", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i = 0; i < readInt; i++) {
                    arrayList.add(i, parseParcelDecoder.decode(parcel));
                }
                return new ParseAddOperation(arrayList);
            }

            public ParseFieldOperation decode(JSONObject jSONObject, ParseDecoder parseDecoder) {
                return new ParseAddOperation((Collection) parseDecoder.decode(jSONObject.opt("objects")));
            }
        });
        registerDecoder("AddUnique", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i = 0; i < readInt; i++) {
                    arrayList.add(i, parseParcelDecoder.decode(parcel));
                }
                return new ParseAddUniqueOperation(arrayList);
            }

            public ParseFieldOperation decode(JSONObject jSONObject, ParseDecoder parseDecoder) {
                return new ParseAddUniqueOperation((Collection) parseDecoder.decode(jSONObject.opt("objects")));
            }
        });
        registerDecoder("Remove", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
                int readInt = parcel.readInt();
                ArrayList arrayList = new ArrayList(readInt);
                for (int i = 0; i < readInt; i++) {
                    arrayList.add(i, parseParcelDecoder.decode(parcel));
                }
                return new ParseRemoveOperation(arrayList);
            }

            public ParseFieldOperation decode(JSONObject jSONObject, ParseDecoder parseDecoder) {
                return new ParseRemoveOperation((Collection) parseDecoder.decode(jSONObject.opt("objects")));
            }
        });
        registerDecoder("AddRelation", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
                int readInt = parcel.readInt();
                HashSet hashSet = new HashSet(readInt);
                for (int i = 0; i < readInt; i++) {
                    hashSet.add((ParseObject) parseParcelDecoder.decode(parcel));
                }
                return new ParseRelationOperation(hashSet, (HashSet) null);
            }

            public ParseFieldOperation decode(JSONObject jSONObject, ParseDecoder parseDecoder) {
                return new ParseRelationOperation(new HashSet((List) parseDecoder.decode(jSONObject.optJSONArray("objects"))), (HashSet) null);
            }
        });
        registerDecoder("RemoveRelation", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
                int readInt = parcel.readInt();
                HashSet hashSet = new HashSet(readInt);
                for (int i = 0; i < readInt; i++) {
                    hashSet.add((ParseObject) parseParcelDecoder.decode(parcel));
                }
                return new ParseRelationOperation((Set) null, hashSet);
            }

            public ParseFieldOperation decode(JSONObject jSONObject, ParseDecoder parseDecoder) {
                return new ParseRelationOperation((Set) null, new HashSet((List) parseDecoder.decode(jSONObject.optJSONArray("objects"))));
            }
        });
        registerDecoder("Set", new ParseFieldOperationFactory() {
            public ParseFieldOperation decode(Parcel parcel, ParseParcelDecoder parseParcelDecoder) {
                return new ParseSetOperation(parseParcelDecoder.decode(parcel));
            }

            public ParseFieldOperation decode(JSONObject jSONObject, ParseDecoder parseDecoder) {
                return null;
            }
        });
    }
}
