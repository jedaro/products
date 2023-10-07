package com.kometsales.products.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {

    /**
     * Genera el codigo del producto a partir del nombre apliando transformaciones
     * @param name nombre del producto
     * @return result code product
     */
    public static String getCodeProduct(String name) {

        String result = "";

        String[] words = name.split(" ");

        if (words.length > 1) {
            for (int i = 0; i < words.length; i++) {
                result = result + transform(words[i]) + " ";
            }
            result = result.stripTrailing();
            result = result.replaceAll("\\s", "-");

        } else {
            result = transform(name);
        }
        return result;
    }

    private static String transform(String name) {
        String code = "";
        char[] chars = name.toCharArray();
        code = code + chars[0];
        String specials = "";
        int countChar = 0;
        for (int i = 1; i < chars.length - 1; i++) {
            char caracter = chars[i];
            if (isSpecial(caracter)) {
                specials = specials + caracter;
            }
            for (int j = 1; j < chars.length - 1; j++) {
                if (chars[j] == caracter) {
                    countChar++;
                }
            }
        }
        code = code + String.valueOf(countChar) + specials;
        code = code + chars[chars.length - 1];

        return code;
    }

    private static boolean isSpecial(char c) {
        Pattern special = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]");

        Matcher hasSpecial = special.matcher(String.valueOf(c));
        return hasSpecial.find();
    }
}
