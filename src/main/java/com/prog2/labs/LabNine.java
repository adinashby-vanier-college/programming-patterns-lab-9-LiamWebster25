package com.prog2.labs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 * @author adinashby
 *
 */
public class LabNine {

    /**
     * Write your test code below in the main (optional).
     *
     */
    public static void main(String[] args) {
        String[] input = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
        
        for (List<String> str : groupStrings(input)) {
            System.out.print("[ ");
            for (String s : str) {
                System.out.print(s + ", ");
            }
            System.out.print(" ] ");
        }
    }

    /**
     * Please refer to the README file for question(s) description
     */
    public static List<List<String>> groupStrings(String[] strings) {
        HashMap<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strings.length; i++) {
            int[] shifts = shiftingSeq(i, strings);
            String key = Arrays.toString(shifts);

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(strings[i]);
        }

        List<List<String>> result = new ArrayList<>(map.values());

        return result;
    }

    public static int[] shiftingSeq(int index, String[] strings) {
        int[] shifts = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            if (index != i) {
                int diff = strings[i].charAt(0) - strings[index].charAt(0);

                if (diff < 0) {
                    diff += 26;
                }
                shifts[i] = diff;
            } else {
                shifts[i] = 0;
            }
        }

        return shifts;
    }
}
