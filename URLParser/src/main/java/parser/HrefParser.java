package parser;

import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by Дарья on 17.09.2015.
 */

//http://www.mkyong.com/java/how-to-read-file-from-java-bufferedreader-example/
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

//TODO use library http://www.mkyong.com/java/jsoup-html-parser-hello-world-examples/
}
