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
    static String urlAddress = "http://www.mkyong.com";
    static String dirName = "C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser";


    public static String writeToFile(String urlAddress, String dirName) {
        URL url;
        StringBuilder allLinks = new StringBuilder();
        String parsingText = null;
        try {
            // get URL content

            url = new URL(urlAddress);
            URLConnection conn = url.openConnection();
            LOGG.info("Connection was created");

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputLine;

            String dirNNN = dirName + "\\All Links" ;
            File dirr = new File(dirNNN);
            dirr.mkdir();

            String dirN = dirNNN + "\\" + urlAddress.replaceAll("\\W", "");
            File dir = new File(dirN);
            dir.mkdirs();

            String fileName = dirN + "\\" + urlAddress.replaceAll("\\W", "") + ".html";
            File file = new File(fileName);
            file.createNewFile();
//
//            if (!file.exists()){
//                file.createNewFile();
//            }

            //use FileWriter to write file
//            BufferedWriter bw;
//            try (FileWriter fw = new FileWriter(file)) {
//                bw = new BufferedWriter(fw);
//            }
            FileWriter bw= new FileWriter(fileName);
            while ((inputLine = br.readLine()) != null) {
                bw.write(inputLine);
                allLinks.append(inputLine).append("\n");

            }

            bw.close();
            br.close();
            LOGG.info("Done");
            parsingText = allLinks.toString();
//            System.out.println(parsingText);

        } catch (MalformedURLException e) {
            e.printStackTrace();//Change!!!
        } catch (IOException e) {
            e.printStackTrace();//Change!!!
        }
        return parsingText;
    }
}