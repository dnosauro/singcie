package com.google.firebase.heartbeatinfo;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

final /* synthetic */ class DefaultHeartBeatInfo$$Lambda$1 implements ComponentFactory {
    private static final DefaultHeartBeatInfo$$Lambda$1 instance = new DefaultHeartBeatInfo$$Lambda$1();

    private DefaultHeartBeatInfo$$Lambda$1() {
    }

    public static ComponentFactory lambdaFactory$() {
        return instance;
    }

    public Object create(ComponentContainer componentContainer) {
        return DefaultHeartBeatInfo.lambda$component$0(componentContainer);
    }
}
