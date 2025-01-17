package org.junit.experimental.theories.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.junit.Assume;
import org.junit.experimental.theories.DataPoint;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.ParameterSignature;
import org.junit.experimental.theories.ParameterSupplier;
import org.junit.experimental.theories.PotentialAssignment;
import org.junit.runners.model.FrameworkField;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.TestClass;

public class AllMembersSupplier extends ParameterSupplier {
    private final TestClass clazz;

    static class MethodParameterValue extends PotentialAssignment {
        private final FrameworkMethod method;

        private MethodParameterValue(FrameworkMethod frameworkMethod) {
            this.method = frameworkMethod;
        }

        public String getDescription() {
            return this.method.getName();
        }

        public Object getValue() {
            boolean z = false;
            try {
                return this.method.invokeExplosively((Object) null, new Object[0]);
            } catch (IllegalArgumentException unused) {
                throw new RuntimeException("unexpected: argument length is checked");
            } catch (IllegalAccessException unused2) {
                throw new RuntimeException("unexpected: getMethods returned an inaccessible method");
            } catch (Throwable th) {
                DataPoint dataPoint = (DataPoint) this.method.getAnnotation(DataPoint.class);
                if (dataPoint == null || !AllMembersSupplier.isAssignableToAnyOf(dataPoint.ignoredExceptions(), th)) {
                    z = true;
                }
                Assume.assumeTrue(z);
                throw new PotentialAssignment.CouldNotGenerateValueException(th);
            }
        }
    }

    public AllMembersSupplier(TestClass testClass) {
        this.clazz = testClass;
    }

    private void addArrayValues(ParameterSignature parameterSignature, String str, List<PotentialAssignment> list, Object obj) {
        for (int i = 0; i < Array.getLength(obj); i++) {
            Object obj2 = Array.get(obj, i);
            if (parameterSignature.canAcceptValue(obj2)) {
                list.add(PotentialAssignment.forValue(str + "[" + i + "]", obj2));
            }
        }
    }

    private void addDataPointsValues(Class<?> cls, ParameterSignature parameterSignature, String str, List<PotentialAssignment> list, Object obj) {
        if (cls.isArray()) {
            addArrayValues(parameterSignature, str, list, obj);
        } else if (Iterable.class.isAssignableFrom(cls)) {
            addIterableValues(parameterSignature, str, list, (Iterable) obj);
        }
    }

    private void addIterableValues(ParameterSignature parameterSignature, String str, List<PotentialAssignment> list, Iterable<?> iterable) {
        int i = 0;
        for (Object next : iterable) {
            if (parameterSignature.canAcceptValue(next)) {
                list.add(PotentialAssignment.forValue(str + "[" + i + "]", next));
            }
            i++;
        }
    }

    private void addMultiPointFields(ParameterSignature parameterSignature, List<PotentialAssignment> list) {
        for (Field next : getDataPointsFields(parameterSignature)) {
            addDataPointsValues(next.getType(), parameterSignature, next.getName(), list, getStaticFieldValue(next));
        }
    }

    private void addMultiPointMethods(ParameterSignature parameterSignature, List<PotentialAssignment> list) {
        for (FrameworkMethod next : getDataPointsMethods(parameterSignature)) {
            Class<?> returnType = next.getReturnType();
            if ((returnType.isArray() && parameterSignature.canPotentiallyAcceptType(returnType.getComponentType())) || Iterable.class.isAssignableFrom(returnType)) {
                try {
                    addDataPointsValues(returnType, parameterSignature, next.getName(), list, next.invokeExplosively((Object) null, new Object[0]));
                } catch (Throwable th) {
                    DataPoints dataPoints = (DataPoints) next.getAnnotation(DataPoints.class);
                    if (dataPoints == null || !isAssignableToAnyOf(dataPoints.ignoredExceptions(), th)) {
                        throw th;
                    }
                    return;
                }
            }
        }
    }

    private void addSinglePointFields(ParameterSignature parameterSignature, List<PotentialAssignment> list) {
        for (Field next : getSingleDataPointFields(parameterSignature)) {
            Object staticFieldValue = getStaticFieldValue(next);
            if (parameterSignature.canAcceptValue(staticFieldValue)) {
                list.add(PotentialAssignment.forValue(next.getName(), staticFieldValue));
            }
        }
    }

    private void addSinglePointMethods(ParameterSignature parameterSignature, List<PotentialAssignment> list) {
        for (FrameworkMethod next : getSingleDataPointMethods(parameterSignature)) {
            if (parameterSignature.canAcceptType(next.getType())) {
                list.add(new MethodParameterValue(next));
            }
        }
    }

    private Object getStaticFieldValue(Field field) {
        try {
            return field.get((Object) null);
        } catch (IllegalArgumentException unused) {
            throw new RuntimeException("unexpected: field from getClass doesn't exist on object");
        } catch (IllegalAccessException unused2) {
            throw new RuntimeException("unexpected: getFields returned an inaccessible field");
        }
    }

    /* access modifiers changed from: private */
    public static boolean isAssignableToAnyOf(Class<?>[] clsArr, Object obj) {
        for (Class<?> isAssignableFrom : clsArr) {
            if (isAssignableFrom.isAssignableFrom(obj.getClass())) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public Collection<Field> getDataPointsFields(ParameterSignature parameterSignature) {
        List<FrameworkField> annotatedFields = this.clazz.getAnnotatedFields(DataPoints.class);
        ArrayList arrayList = new ArrayList();
        for (FrameworkField field : annotatedFields) {
            arrayList.add(field.getField());
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public Collection<FrameworkMethod> getDataPointsMethods(ParameterSignature parameterSignature) {
        return this.clazz.getAnnotatedMethods(DataPoints.class);
    }

    /* access modifiers changed from: protected */
    public Collection<Field> getSingleDataPointFields(ParameterSignature parameterSignature) {
        List<FrameworkField> annotatedFields = this.clazz.getAnnotatedFields(DataPoint.class);
        ArrayList arrayList = new ArrayList();
        for (FrameworkField field : annotatedFields) {
            arrayList.add(field.getField());
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public Collection<FrameworkMethod> getSingleDataPointMethods(ParameterSignature parameterSignature) {
        return this.clazz.getAnnotatedMethods(DataPoint.class);
    }

    public List<PotentialAssignment> getValueSources(ParameterSignature parameterSignature) {
        ArrayList arrayList = new ArrayList();
        addSinglePointFields(parameterSignature, arrayList);
        addMultiPointFields(parameterSignature, arrayList);
        addSinglePointMethods(parameterSignature, arrayList);
        addMultiPointMethods(parameterSignature, arrayList);
        return arrayList;
    }
}
