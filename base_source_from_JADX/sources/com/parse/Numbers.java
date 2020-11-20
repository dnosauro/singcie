package com.parse;

class Numbers {
    Numbers() {
    }

    static Number add(Number number, Number number2) {
        if ((number instanceof Double) || (number2 instanceof Double)) {
            return Double.valueOf(number.doubleValue() + number2.doubleValue());
        }
        if ((number instanceof Float) || (number2 instanceof Float)) {
            return Float.valueOf(number.floatValue() + number2.floatValue());
        }
        if ((number instanceof Long) || (number2 instanceof Long)) {
            return Long.valueOf(number.longValue() + number2.longValue());
        }
        if ((number instanceof Integer) || (number2 instanceof Integer)) {
            return Integer.valueOf(number.intValue() + number2.intValue());
        }
        if ((number instanceof Short) || (number2 instanceof Short)) {
            return Integer.valueOf(number.shortValue() + number2.shortValue());
        }
        if ((number instanceof Byte) || (number2 instanceof Byte)) {
            return Integer.valueOf(number.byteValue() + number2.byteValue());
        }
        throw new RuntimeException("Unknown number type.");
    }

    static int compare(Number number, Number number2) {
        if ((number instanceof Double) || (number2 instanceof Double)) {
            return (int) Math.signum(number.doubleValue() - number2.doubleValue());
        }
        if ((number instanceof Float) || (number2 instanceof Float)) {
            return (int) Math.signum(number.floatValue() - number2.floatValue());
        }
        if ((number instanceof Long) || (number2 instanceof Long)) {
            int i = ((number.longValue() - number2.longValue()) > 0 ? 1 : ((number.longValue() - number2.longValue()) == 0 ? 0 : -1));
            if (i < 0) {
                return -1;
            }
            return i > 0 ? 1 : 0;
        } else if ((number instanceof Integer) || (number2 instanceof Integer)) {
            return number.intValue() - number2.intValue();
        } else {
            if ((number instanceof Short) || (number2 instanceof Short)) {
                return number.shortValue() - number2.shortValue();
            }
            if ((number instanceof Byte) || (number2 instanceof Byte)) {
                return number.byteValue() - number2.byteValue();
            }
            throw new RuntimeException("Unknown number type.");
        }
    }

    static Number subtract(Number number, Number number2) {
        if ((number instanceof Double) || (number2 instanceof Double)) {
            return Double.valueOf(number.doubleValue() - number2.doubleValue());
        }
        if ((number instanceof Float) || (number2 instanceof Float)) {
            return Float.valueOf(number.floatValue() - number2.floatValue());
        }
        if ((number instanceof Long) || (number2 instanceof Long)) {
            return Long.valueOf(number.longValue() - number2.longValue());
        }
        if ((number instanceof Integer) || (number2 instanceof Integer)) {
            return Integer.valueOf(number.intValue() - number2.intValue());
        }
        if ((number instanceof Short) || (number2 instanceof Short)) {
            return Integer.valueOf(number.shortValue() - number2.shortValue());
        }
        if ((number instanceof Byte) || (number2 instanceof Byte)) {
            return Integer.valueOf(number.byteValue() - number2.byteValue());
        }
        throw new RuntimeException("Unknown number type.");
    }
}
