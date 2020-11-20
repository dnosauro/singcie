package org.junit.internal.runners;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import p076c.p078b.C1398d;

public class SuiteMethod extends JUnit38ClassRunner {
    public SuiteMethod(Class<?> cls) {
        super(testFromSuiteMethod(cls));
    }

    public static C1398d testFromSuiteMethod(Class<?> cls) {
        try {
            Method method = cls.getMethod("suite", new Class[0]);
            if (Modifier.isStatic(method.getModifiers())) {
                return (C1398d) method.invoke((Object) null, new Object[0]);
            }
            throw new Exception(cls.getName() + ".suite() must be static");
        } catch (InvocationTargetException e) {
            throw e.getCause();
        }
    }
}
