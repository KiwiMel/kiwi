package test;

import java.util.*;

public class MelTest {

    static {
        System.out.println("blah");
    }

    public static void reverseString(String str) {
        System.out.println("Original String '" + str + "'");

        char[] reversedStr = str.toCharArray();
        int mid = Math.round(str.length() / 2);

        for (int i = 0; i < mid; i++) {
            char c1 = str.charAt(i);
            char c2 = str.charAt(str.length() - i-1);

            reversedStr[i] = c2;
            reversedStr[str.length() - i - 1] = c1;

            System.out.println(i + " -> '" + new String(reversedStr) + "'");
        }


        System.out.println("Reversed String '" + new String(reversedStr) + "'");
    }

    public static int fib(int n)  {
        if(n == 0)
            return 0;
        else if(n == 1)
            return 1;
        else
            return fib(n - 1) + fib(n - 2);
    }


    public static List<Integer> concat(List<Integer> list1, Integer pivot, List<Integer> list3) {
        List<Integer> all = new ArrayList<Integer>();
        all.addAll(list1);
        all.add(pivot);
        all.addAll(list3);

        return all;
    }

    public static List<Integer> quicksort(List<Integer> values) {
        if (values.size() <= 1) {
            return values;  // an array of zero or one elements is already sorted
        }

        int pivotIndex = values.size()/2;
        int pivot = values.get(pivotIndex);

        List<Integer> lowValues = new ArrayList<Integer>();
        List<Integer> highValues = new ArrayList<Integer>();

        boolean pivotFound = false;
        for (Integer value : values) {
            if (value == pivot && !pivotFound) {
                pivotFound = true; // ignore
            }
            else if (value < pivot) {
                lowValues.add(value);
            }
            else {
                highValues.add(value);
            }
        }

        return concat(quicksort(lowValues), pivot, quicksort(highValues));
    }



    public static void main(String[] args) {

        Integer[] s = new Integer[]{1, 4,  2, 7, 23, 45, 33, 4, 2, 8, 5, 55, 44, 90, 4, 2};
        List<Integer> list = Arrays.asList(s);

        System.out.println(list);

        List<Integer> sortedList = quicksort(list);
        System.out.println(sortedList);
    }

}
