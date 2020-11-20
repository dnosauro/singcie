package com.parse;

import bolts.Continuation;
import bolts.Task;
import com.parse.ParseObject;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

class NetworkObjectController implements ParseObjectController {
    private ParseHttpClient client;
    /* access modifiers changed from: private */
    public ParseObjectCoder coder = ParseObjectCoder.get();

    public NetworkObjectController(ParseHttpClient parseHttpClient) {
        this.client = parseHttpClient;
    }

    public List<Task<Void>> deleteAllAsync(List<ParseObject.State> list, String str) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            arrayList.add(ParseRESTObjectCommand.deleteObjectCommand(list.get(i), str));
        }
        List<Task<JSONObject>> executeBatch = ParseRESTObjectBatchCommand.executeBatch(this.client, arrayList, str);
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            arrayList2.add(executeBatch.get(i2).makeVoid());
        }
        return arrayList2;
    }

    public Task<Void> deleteAsync(ParseObject.State state, String str) {
        return ParseRESTObjectCommand.deleteObjectCommand(state, str).executeAsync(this.client).makeVoid();
    }

    public Task<ParseObject.State> fetchAsync(final ParseObject.State state, String str, final ParseDecoder parseDecoder) {
        return ParseRESTObjectCommand.getObjectCommand(state.objectId(), state.className(), str).executeAsync(this.client).onSuccess(new Continuation<JSONObject, ParseObject.State>() {
            public ParseObject.State then(Task<JSONObject> task) {
                ParseObject.State.Init clear = state.newBuilder().clear();
                return NetworkObjectController.this.coder.decode(clear, task.getResult(), parseDecoder).isComplete(true).build();
            }
        });
    }

    public List<Task<ParseObject.State>> saveAllAsync(List<ParseObject.State> list, List<ParseOperationSet> list2, String str, List<ParseDecoder> list3) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        PointerEncoder pointerEncoder = PointerEncoder.get();
        for (int i = 0; i < size; i++) {
            ParseObject.State state = list.get(i);
            arrayList.add(ParseRESTObjectCommand.saveObjectCommand(state, this.coder.encode(state, list2.get(i), pointerEncoder), str));
        }
        List<Task<JSONObject>> executeBatch = ParseRESTObjectBatchCommand.executeBatch(this.client, arrayList, str);
        ArrayList arrayList2 = new ArrayList(size);
        for (int i2 = 0; i2 < size; i2++) {
            final ParseObject.State state2 = list.get(i2);
            final ParseDecoder parseDecoder = list3.get(i2);
            arrayList2.add(executeBatch.get(i2).onSuccess(new Continuation<JSONObject, ParseObject.State>() {
                public ParseObject.State then(Task<JSONObject> task) {
                    ParseObject.State.Init clear = state2.newBuilder().clear();
                    return NetworkObjectController.this.coder.decode(clear, task.getResult(), parseDecoder).isComplete(false).build();
                }
            }));
        }
        return arrayList2;
    }

    public Task<ParseObject.State> saveAsync(final ParseObject.State state, ParseOperationSet parseOperationSet, String str, final ParseDecoder parseDecoder) {
        return ParseRESTObjectCommand.saveObjectCommand(state, this.coder.encode(state, parseOperationSet, PointerEncoder.get()), str).executeAsync(this.client).onSuccess(new Continuation<JSONObject, ParseObject.State>() {
            public ParseObject.State then(Task<JSONObject> task) {
                ParseObject.State.Init clear = state.newBuilder().clear();
                return NetworkObjectController.this.coder.decode(clear, task.getResult(), parseDecoder).isComplete(false).build();
            }
        });
    }
}
