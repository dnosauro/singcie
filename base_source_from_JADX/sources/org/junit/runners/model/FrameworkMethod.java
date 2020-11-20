package org.junit.runners.model;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.List;
import org.junit.internal.runners.model.ReflectiveCallable;

public class FrameworkMethod extends FrameworkMember<FrameworkMethod> {
    /* access modifiers changed from: private */
    public final Method method;

    public FrameworkMethod(Method method2) {
        if (method2 != null) {
            this.method = method2;
            return;
        }
        throw new NullPointerException("FrameworkMethod cannot be created without an underlying method.");
    }

    private Class<?>[] getParameterTypes() {
        return this.method.getParameterTypes();
    }

    public boolean equals(Object obj) {
        if (!FrameworkMethod.class.isInstance(obj)) {
            return false;
        }
        return ((FrameworkMethod) obj).method.equals(this.method);
    }

    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return this.method.getAnnotation(cls);
    }

    public Annotation[] getAnnotations() {
        return this.method.getAnnotations();
    }

    public Class<?> getDeclaringClass() {
        return this.method.getDeclaringClass();
    }

    public Method getMethod() {
        return this.method;
    }

    /* access modifiers changed from: protected */
    public int getModifiers() {
        return this.method.getModifiers();
    }

    public String getName() {
        return this.method.getName();
    }

    public Class<?> getReturnType() {
        return this.method.getReturnType();
    }

    public Class<?> getType() {
        return getReturnType();
    }

    public int hashCode() {
        return this.method.hashCode();
    }

    public Object invokeExplosively(final Object obj, final Object... objArr) {
        return new ReflectiveCallable() {
            /* access modifiers changed from: protected */
            public Object runReflectiveCall() {
                return FrameworkMethod.this.method.invoke(obj, objArr);
            }
        }.run();
    }

    public boolean isShadowedBy(FrameworkMethod frameworkMethod) {
        if (!frameworkMethod.getName().equals(getName()) || frameworkMethod.getParameterTypes().length != getParameterTypes().length) {
            return false;
        }
        for (int i = 0; i < frameworkMethod.getParameterTypes().length; i++) {
            if (!frameworkMethod.getParameterTypes()[i].equals(getParameterTypes()[i])) {
                return false;
            }
        }
        return true;
    }

    @Deprecated
    public boolean producesType(Type type) {
        return getParameterTypes().length == 0 && (type instanceof Class) && ((Class) type).isAssignableFrom(this.method.getReturnType());
    }

    public String toString() {
        return this.method.toString();
    }

    public void validateNoTypeParametersOnArgs(List<Throwable> list) {
        new NoGenericTypeParametersValidator(this.method).validate(list);
    }

    public void validatePublicVoid(boolean z, List<Throwable> list) {
        if (isStatic() != z) {
            String str = z ? "should" : "should not";
            list.add(new Exception("Method " + this.method.getName() + "() " + str + " be static"));
        }
        if (!isPublic()) {
            list.add(new Exception("Method " + this.method.getName() + "() should be public"));
        }
        if (this.method.getReturnType() != Void.TYPE) {
            list.add(new Exception("Method " + this.method.getName() + "() should be void"));
        }
    }

    public void validatePublicVoidNoArg(boolean z, List<Throwable> list) {
        validatePublicVoid(z, list);
        if (this.method.getParameterTypes().length != 0) {
            list.add(new Exception("Method " + this.method.getName() + " should have no parameters"));
        }
    }
}
