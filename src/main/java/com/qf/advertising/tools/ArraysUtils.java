package com.qf.advertising.tools;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArraysUtils {
    /**
     * @Description：去除空格
     * @author: GuXiYang
     * @date: 2015-10-12 下午4:18:59
     * @param str
     * @return
     */
    public static String getStringNoBlank(String str) {
        if (str != null && !"".equals(str)) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            String strNoBlank = m.replaceAll("");
            return strNoBlank;
        } else {
            return str;
        }
    }

    /**
     * @Description： 判断数组中是否包含某个值
     * @author: GuXiYang
     * @date: 2015-9-25 下午2:32:50
     * @param arr
     * @param targetValue
     * @see ，http://www.diguage.com/
     * @return
     */
    public static boolean useList(String[] arr, String targetValue) {
        return Arrays.asList(arr).contains(targetValue);
    }

    /**
     * Coder：D瓜哥，http://www.diguage.com/
     */
    public static boolean useSet(String[] arr, String targetValue) {
        Set<String> set = new HashSet<String>(Arrays.asList(arr));
        return set.contains(targetValue);
    }

    /**
     * Coder：D瓜哥，http://www.diguage.com/
     */
    public static boolean useLoop(String[] arr, String targetValue) {
        for (String s : arr) {
            if (s.equals(targetValue)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @Description： 判断map中是否包含指定的key
     * @author: GuXiYang
     * @date: 2015-11-17 下午3:48:27
     * @param map
     * @param key
     * @return true/false
     */
    public static boolean vidateKey(Map map, String key) {
        return map.containsKey(key);
    }

    /**
     * @Description： 验证对象是不是数组
     * @author: GuXiYang
     * @date: 2017/04/29 16:48:38
     * @param obj
     * @return
     */
    public static boolean isArray(Object obj) {
        return (obj != null && obj.getClass().isArray());
    }

    /**
     * @Description： 判断数组是否为空
     * @author: GuXiYang
     * @date: 2017/04/29 16:49:15
     * @param array
     *            数组
     * @return true/false
     */
    public static boolean isEmpty(Object[] array) {
        return (array == null || array.length == 0);
    }

    /**
     * Determine if the given objects are equal, returning {@code true} if both
     * are {@code null} or {@code false} if only one is {@code null}.
     * <p>
     * Compares arrays with {@code Arrays.equals}, performing an equality check
     * based on the array elements rather than the array reference.
     *
     * @param o1
     *            first Object to compare
     * @param o2
     *            second Object to compare
     * @return whether the given objects are equal
     * @see Arrays#equals
     */
    public static boolean nullSafeEquals(Object o1, Object o2) {
        if (o1 == o2) {
            return true;
        }
        if (o1 == null || o2 == null) {
            return false;
        }
        if (o1.equals(o2)) {
            return true;
        }
        if (o1.getClass().isArray() && o2.getClass().isArray()) {
            if (o1 instanceof Object[] && o2 instanceof Object[]) {
                return Arrays.equals((Object[]) o1, (Object[]) o2);
            }
            if (o1 instanceof boolean[] && o2 instanceof boolean[]) {
                return Arrays.equals((boolean[]) o1, (boolean[]) o2);
            }
            if (o1 instanceof byte[] && o2 instanceof byte[]) {
                return Arrays.equals((byte[]) o1, (byte[]) o2);
            }
            if (o1 instanceof char[] && o2 instanceof char[]) {
                return Arrays.equals((char[]) o1, (char[]) o2);
            }
            if (o1 instanceof double[] && o2 instanceof double[]) {
                return Arrays.equals((double[]) o1, (double[]) o2);
            }
            if (o1 instanceof float[] && o2 instanceof float[]) {
                return Arrays.equals((float[]) o1, (float[]) o2);
            }
            if (o1 instanceof int[] && o2 instanceof int[]) {
                return Arrays.equals((int[]) o1, (int[]) o2);
            }
            if (o1 instanceof long[] && o2 instanceof long[]) {
                return Arrays.equals((long[]) o1, (long[]) o2);
            }
            if (o1 instanceof short[] && o2 instanceof short[]) {
                return Arrays.equals((short[]) o1, (short[]) o2);
            }
        }
        return false;
    }

    /**
     * @Description： 验证数组是否包括元素
     * @author: GuXiYang
     * @date: 2017/04/29 16:50:23
     * @param array
     *            数组
     * @param element
     *            元素
     * @return
     */
    public static boolean containsElement(Object[] array, Object element) {
        if (array == null) {
            return false;
        }
        for (Object arrayEle : array) {
            if (nullSafeEquals(arrayEle, element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether the given array of enum constants contains a constant with
     * the given name.
     *
     * @param enumValues
     *            the enum values to check, typically the product of a call to
     *            MyEnum.values()
     * @param constant
     *            the constant name to find (must not be null or empty string)
     * @param caseSensitive
     *            whether case is significant in determining a match
     * @return whether the constant has been found in the given array
     *         判断枚举数组中是否包含某个字符串
     */
    public static boolean containsConstant(Enum<?>[] enumValues,
                                           String constant, boolean caseSensitive) {
        for (Enum<?> candidate : enumValues) {
            if (caseSensitive ? candidate.toString().equals(constant)
                    : candidate.toString().equalsIgnoreCase(constant)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Check whether the given array of enum constants contains a constant with
     * the given name, ignoring case when determining a match.
     *
     * @param enumValues
     *            the enum values to check, typically the product of a call to
     *            MyEnum.values()
     * @param constant
     *            the constant name to find (must not be null or empty string)
     * @return whether the constant has been found in the given array
     *         判断枚举数组中是否包含某个字符串(忽略大小写)
     */
    public static boolean containsConstant(Enum<?>[] enumValues, String constant) {
        return containsConstant(enumValues, constant, false);
    }

    /**
     * Case insensitive alternative to {@link Enum#valueOf(Class, String)}.
     *
     * @param <E>
     *            the concrete Enum type
     * @param enumValues
     *            the array of all Enum constants in question, usually per
     *            Enum.values()
     * @param constant
     *            the constant to get the enum value of
     * @throws IllegalArgumentException
     *             if the given constant is not found in the given array of enum
     *             values. Use {@link #containsConstant(Enum[], String)} as a
     *             guard to avoid this exception.
     */
    public static <E extends Enum<?>> E caseInsensitiveValueOf(E[] enumValues,
                                                               String constant) {
        for (E candidate : enumValues) {
            if (candidate.toString().equalsIgnoreCase(constant)) {
                return candidate;
            }
        }
        throw new IllegalArgumentException(String.format(
                "constant [%s] does not exist in enum type %s", constant,
                enumValues.getClass().getComponentType().getName()));
    }
}
