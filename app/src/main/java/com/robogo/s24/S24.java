package com.robogo.s24;

public class S24 {
    public static String calc(int a, int b, int c, int d) {
        int[] arr = { a, b, c, d };
        return calc(arr, 24);
    }

    static String calc(int[] arr, double expect) {
        if (arr.length == 2) {
            int a = arr[0];
            int b = arr[1];
            if (equals(a + b, expect)) {
                return "(" + a + " + " + b + ")";
            }
            if (equals(a - b, expect)) {
                return "(" + a + " - " + b + ")";
            }
            if (equals(b - a, expect)) {
                return "(" + b + " - " + a + ")";
            }
            if (equals(a * b, expect)) {
                return "(" + a + " * " + b + ")";
            }
            if (equals(a / (double)b, expect)) {
                return "(" + a + " / " + b + ")";
            }
            if (equals(b / (double)a, expect)) {
                return "(" + b + " / " + a + ")";
            }
            return null;
        } else {
            for (int i = 0; i < arr.length; i++) {
                int n = arr[i];
                int[] a = exclude(arr, 1, i, -1);
                String s = calc(n, a, expect, String.valueOf(n));
                if (s != null) {
                    return s;
                }
            }
            for (int i = 1; i < arr.length; i++) {
                int m = arr[0];
                int n = arr[i];
                int[] a = exclude(arr, 2, 0, i);
                String s;

                s = calc(m + n, a, expect, "(" + m + " + " + n + ")");
                if (s != null) {
                    return s;
                }
                s = calc(n - m, a, expect, "(" + n + " - " + m + ")");
                if (s != null) {
                    return s;
                }
                s = calc(m - n, a, expect, "(" + m + " - " + n + ")");
                if (s != null) {
                    return s;
                }
                s = calc(m * n, a, expect, "(" + m + " * " + n + ")");
                if (s != null) {
                    return s;
                }
                s = calc(m / (double)n, a, expect, "(" + m + " / " + n + ")");
                if (s != null) {
                    return s;
                }
                s = calc(n / (double)m, a, expect, "(" + n + " / " + m + ")");
                if (s != null) {
                    return s;
                }
            }
            return null;
        }
    }

    static String calc(double num, int[] arr, double expect, String str) {
        String s;

        s = calc(arr, expect - num);
        if (s != null) {
            return "(" + str + " + " + s + ")";
        }
        s = calc(arr, num + expect);
        if (s != null) {
            return "(" + s + " - " + str + ")";
        }
        s = calc(arr, num - expect);
        if (s != null) {
            return "(" + str + " - " + s + ")";
        }
        if (!equals(0.0, num)) {
            s = calc(arr, expect / num);
            if (s != null) {
                return "(" + str + " * " + s + ")";
            }
            s = calc(arr, num * expect);
            if (s != null) {
                return "(" + s + " / " + str + ")";
            }
            s = calc(arr, num / expect);
            if (s != null) {
                return "(" + str + " / " + s + ")";
            }
        }
        return null;
    }

    static int[] exclude(int[] a, int n, int i, int j) {
        int[] ret = new int[a.length - n];
        for (int p = 0, k = 0; p < a.length; p++) {
            if (p != i && p != j) {
                ret[k++] = a[p];
            }
        }
        return ret;
    }

    static boolean equals(double d1, double d2) {
        if (Math.abs(d1 - d2) < 0.00000001) {
            return true;
        }
        return false;
    }
}
