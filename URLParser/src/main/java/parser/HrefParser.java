package parser;

import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Dmitriy Gorobets.
 */

public class HrefParser {
    public static void main(String[] args) {

        String fileName = "E:\\Basic course of Java\\Практические задания\\Примеры кода\\URLParser\\URLParser\\Crauler.html";

    }
//BR with resources
    public static List<String> parseLinks(String fileName) {
        List<String> links = new LinkedList<String>();


        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

            String sCurrentLine;

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println(sCurrentLine);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


        return links;
    }

}
