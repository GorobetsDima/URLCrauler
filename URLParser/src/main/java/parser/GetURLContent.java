package parser;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

// used http://www.mkyong.com/java/how-to-get-url-content-in-java/
public class GetURLContent {
    public static final Logger LOGG = Logger.getLogger(GetURLContent.class);

    public static void main(String[] args) {
        String urlAddress = "http://www.mkyong.com";

        //save to this filename
        String fileName = "C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser\\Crauler.html";

        writeToFile(urlAddress, fileName);


    }

    public static String writeToFile(String urlAddress, String fileName) {
        URL url;
        StringBuilder allLinks = new StringBuilder();
        String parsingText= null;
        try {
            // get URL content

            url = new URL(urlAddress);
            URLConnection conn = url.openConnection();
            LOGG.info("Connection was created");

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputLine;


            File file = new File(fileName);

            if (!file.exists()) {
                file.createNewFile();
            }

            //use FileWriter to write file
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            while ((inputLine = br.readLine()) != null) {
                bw.write(inputLine);
                allLinks.append(inputLine).append("\n");
                //создать стрингбилдер и записать в него весть html в виде строки, потом для этой строки вызвать метод который парсит ссылки он мне
                //выдаст вектор ссылок потом я буду в отдельном методе ходить по  этому вектору,для каждого значения вектора(ссылки) вызывать класс GetURLConnect
                //  и присваивать каждому новому html файла имя ссылки
            }

            bw.close();
            br.close();
            LOGG.info("Done");
            parsingText = allLinks.toString();
            System.out.println(parsingText);

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return parsingText;
    }
}