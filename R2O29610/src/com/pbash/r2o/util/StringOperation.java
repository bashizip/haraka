/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pbash.r2o.util;

/**
 *
 * @author Bash
 */
public class StringOperation {

    public static String upFirstChar(String s) {
        char fc = s.charAt(0);

        String cn = s.substring(1);

        String finale = String.valueOf(fc).toUpperCase() + cn;
        return finale;
    }

    public static String removeLastComma(String s){
        return String.copyValueOf(s.toCharArray(), 0, s.length() - 1);
    }

      public static String removeLast(String s, int leng){
        return String.copyValueOf(s.toCharArray(), 0, s.length() - leng);
    }

}
