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
        String key = calculateKey(strings[i]);

        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<>());
        }

        map.get(key).add(strings[i]);
    }

    List<List<String>> result = new ArrayList<>(map.values());

    return result;
}

private static String calculateKey(String str) {
    String key = "";
    int len = str.length();

    for (int i = 1; i < len; i++) {
        int diff = str.charAt(i) - str.charAt(i - 1);
        if (diff < 0) {
            diff += 26;
        }
        key += diff + ", ";
    }

    return key.toString();
}
}
