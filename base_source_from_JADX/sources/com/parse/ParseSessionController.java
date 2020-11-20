package com.parse;

import bolts.Task;
import com.parse.ParseObject;

interface ParseSessionController {
    Task<ParseObject.State> getSessionAsync(String str);

    Task<Void> revokeAsync(String str);

    Task<ParseObject.State> upgradeToRevocable(String str);
}
