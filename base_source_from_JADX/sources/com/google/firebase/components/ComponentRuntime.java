package com.google.firebase.components;

import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Provider;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public class ComponentRuntime extends AbstractComponentContainer {
    private static final Provider<Set<Object>> EMPTY_PROVIDER = ComponentRuntime$$Lambda$5.lambdaFactory$();
    private final Map<Component<?>, Lazy<?>> components = new HashMap();
    private final EventBus eventBus;
    private final Map<Class<?>, Lazy<?>> lazyInstanceMap = new HashMap();
    private final Map<Class<?>, Lazy<Set<?>>> lazySetMap = new HashMap();

    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        this.eventBus = new EventBus(executor);
        ArrayList<Component> arrayList = new ArrayList<>();
        arrayList.add(Component.m8728of(this.eventBus, EventBus.class, Subscriber.class, Publisher.class));
        for (ComponentRegistrar components2 : iterable) {
            arrayList.addAll(components2.getComponents());
        }
        for (Component<?> component : componentArr) {
            if (component != null) {
                arrayList.add(component);
            }
        }
        CycleDetector.detect(arrayList);
        for (Component component2 : arrayList) {
            this.components.put(component2, new Lazy(ComponentRuntime$$Lambda$1.lambdaFactory$(this, component2)));
        }
        processInstanceComponents();
        processSetComponents();
    }

    static /* synthetic */ Set lambda$processSetComponents$1(Set set) {
        HashSet hashSet = new HashSet();
        Iterator it = set.iterator();
        while (it.hasNext()) {
            hashSet.add(((Lazy) it.next()).get());
        }
        return Collections.unmodifiableSet(hashSet);
    }

    private void processInstanceComponents() {
        for (Map.Entry next : this.components.entrySet()) {
            Component component = (Component) next.getKey();
            if (component.isValue()) {
                Lazy lazy = (Lazy) next.getValue();
                for (Class put : component.getProvidedInterfaces()) {
                    this.lazyInstanceMap.put(put, lazy);
                }
            }
        }
        validateDependencies();
    }

    private void processSetComponents() {
        HashMap hashMap = new HashMap();
        for (Map.Entry next : this.components.entrySet()) {
            Component component = (Component) next.getKey();
            if (!component.isValue()) {
                Lazy lazy = (Lazy) next.getValue();
                for (Class cls : component.getProvidedInterfaces()) {
                    if (!hashMap.containsKey(cls)) {
                        hashMap.put(cls, new HashSet());
                    }
                    ((Set) hashMap.get(cls)).add(lazy);
                }
            }
        }
        for (Map.Entry entry : hashMap.entrySet()) {
            this.lazySetMap.put((Class) entry.getKey(), new Lazy(ComponentRuntime$$Lambda$4.lambdaFactory$((Set) entry.getValue())));
        }
    }

    private void validateDependencies() {
        for (Component next : this.components.keySet()) {
            Iterator<Dependency> it = next.getDependencies().iterator();
            while (true) {
                if (it.hasNext()) {
                    Dependency next2 = it.next();
                    if (next2.isRequired() && !this.lazyInstanceMap.containsKey(next2.getInterface())) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", new Object[]{next, next2.getInterface()}));
                    }
                }
            }
        }
    }

    public /* bridge */ /* synthetic */ Object get(Class cls) {
        return super.get(cls);
    }

    public <T> Provider<T> getProvider(Class<T> cls) {
        Preconditions.checkNotNull(cls, "Null interface requested.");
        return this.lazyInstanceMap.get(cls);
    }

    public void initializeEagerComponents(boolean z) {
        for (Map.Entry next : this.components.entrySet()) {
            Component component = (Component) next.getKey();
            Lazy lazy = (Lazy) next.getValue();
            if (component.isAlwaysEager() || (component.isEagerInDefaultApp() && z)) {
                lazy.get();
            }
        }
        this.eventBus.enablePublishingAndFlushPending();
    }

    public /* bridge */ /* synthetic */ Set setOf(Class cls) {
        return super.setOf(cls);
    }

    public <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        Lazy lazy = this.lazySetMap.get(cls);
        return lazy != null ? lazy : EMPTY_PROVIDER;
    }
}
