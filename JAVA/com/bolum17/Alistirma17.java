package com.bolum17;

import java.util.function.Function;

public class Alistirma17 {
    public static void main(String[] args) {
        new Thread(() -> {
            String kelime = "Bosluklarına gore ayrılacak kelime";
            for (String temp : kelime.split(" ")) {
                System.out.println(temp);
            }
        }).start();
        Function<String, String> function = new Function<String, String>() {
            StringBuilder builder = new StringBuilder();
            @Override
            public String apply(String s) {
                for (int i = 0; i < s.length(); i++) {
                    if (i % 2 == 0) {
                        builder.append(s.charAt(i));
                    }
                }
                return builder.toString();
            }
        };
        System.out.println(function.apply("0123456789"));
        Function<String, String> function1 = (s) -> {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                if (i % 2 == 0) {
                    builder.append(s.charAt(i));
                }
            }
            return builder.toString();
        };
        System.out.println(function1.apply("0246810"));
        System.out.println(ciftPozisyondakiKarakterleriYazdir(function1,"merhaba arkadaslar"));
    }
    public static String ciftPozisyondakiKarakterleriYazdir(Function<String,String > function,String s){
        return function.apply(s);
    }
}
