package com.algorithms.sort;

import java.io.InputStream;

/**
 * @author fanbo@imoran.net
 * @date 2021/2/2 6:39
 */
public class Selection {
    public static void sort(Comparable[] a){
        int N = a.length;
        for (int i = 0; i < N; i++) {
            int  min = i;
            for (int j = i + 1; j < N; j++) {
                if(less(a[j], a[min])){
                    exch(a, i, min);
                }
            }
        }
    }

    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a){
        for(int i = 0; i < a.length; ++i){
            System.out.println(a[i] + " ");
        }
    }

    public static boolean isSorted(Comparable[] a){
        for (int i = 0; i < a.length; i++) {
            if(less(a[i], a[i-1])){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
/*        String [] a = System.in..readStrings();
        sor(a);
        assert isSorted(a);
        show(a);*/
    }
}