package com.identity.utils;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Text {
    private Text(){}

    public static String[] divideWords(String text){
        String regex = "[\\s\\p{P}\\d]+"; // all " " and others symbols (most to be sincere)
        return text.trim().split(regex);
    }

    public static String[] divideSentences(String text) {
        String regex = "[.!?\\“\\”\"]+[\\s\\n]*"; // to check
        String[]divided = text.trim().split(regex);
        List<String> sentences = new ArrayList<>();
        for(String s : divided){
            if(s.length()!=0)
                sentences.add(s);
        }
        return sentences.toArray(new String[sentences.size()]);
    }

    public static List<String> findDialog(String text) {
        List<String> dialogs = new ArrayList<>();
        Pattern pattern1 = Pattern.compile("\"\\w[\\w\\s\\,\\.\\?\\!]+");
        Matcher m = pattern1.matcher(text);
        while (m.find()){
            dialogs.add(m.group());
            //System.out.println(m.group());
        }
        Pattern pattern2 = Pattern.compile("\\“\\w[\\w\\s\\,\\.\\?\\!]+");
        m = pattern2.matcher(text);
        while (m.find()) {
            dialogs.add(m.group());
        }
        return dialogs;
    }

    public static int findAmount(String text, String searched) {
        int amount = 0;
        Pattern pattern = Pattern.compile(searched);
        Matcher m = pattern.matcher(text);
        while (m.find()) {
            amount++;
        }
        return amount;
    }
}
