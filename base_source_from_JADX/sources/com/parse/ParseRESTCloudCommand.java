package com.parse;

import com.parse.http.ParseHttpRequest;
import java.util.Map;

class ParseRESTCloudCommand extends ParseRESTCommand {
    private ParseRESTCloudCommand(String str, ParseHttpRequest.Method method, Map<String, ?> map, String str2) {
        super(str, method, map, str2);
    }

    public static ParseRESTCloudCommand callFunctionCommand(String str, Map<String, ?> map, String str2) {
        return new ParseRESTCloudCommand(String.format("functions/%s", new Object[]{str}), ParseHttpRequest.Method.POST, map, str2);
    }
}
