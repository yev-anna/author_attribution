package com.identity.utils;

import java.io.*;
import java.nio.charset.Charset;



// TO RENAME CLASS NAME!!!!

public class File {
    private File(){}

    public static String readFromFile(String filePath, Charset cs) {
        StringBuilder text = new StringBuilder();

        try (BufferedReader bf = new BufferedReader(
                new InputStreamReader(new FileInputStream(new java.io.File(filePath)), cs));) {

            String line;
            while ((line=bf.readLine()) != null)
                text.append("\n" + line);
            //System.out.println(text);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(text);
    }

    public static boolean writeToFile(String text, String filePath, Charset cs) {
        try(BufferedWriter bw = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(new java.io.File(filePath)), cs));) {

            bw.write(text);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }



    public static String getFileName(String filePath){
        //"data\\library\\James_Joyce_Dubliners.txt"
        String fileName = filePath.substring(13);
        return fileName;
    }

}
