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

public class GetURLContent {
    public static final Logger LOGG = Logger.getLogger(GetURLContent.class);
    static String urlAddress = "http://www.mkyong.com";
    static String dirName = "C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser";


    /**
     * Method that writes to the file a content from urlAddress
     *
     * @param urlAddress Url address for parsing a content
     * @param dirName    Name of directory where will be saved the file with a content
     *                   <p>
     * MalformedURLException :
     *                   throws if we have an invalid url
     *                   <p>
     * IOException:
     *                   throws if  a stream was failed or interrupted .
     */
    public static synchronized String writeToFile(String urlAddress, String dirName) {
        URL url;
        StringBuilder allLinks = new StringBuilder();
        String parsingText = null;
        try {
            // get URL connection

            url = new URL(urlAddress);
            URLConnection conn = url.openConnection();
            LOGG.info("Connection was created");

            // open the stream and put it into BufferedReader
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(conn.getInputStream()));

            String inputContent;
//Create the main directory
            String dirNNN = dirName + "\\All Links";
            File dirr = new File(dirNNN);
            dirr.mkdir();
//Create the directory for every file
            String dirN = dirNNN + "\\" + urlAddress.replaceAll("\\W", "");
            File dir = new File(dirN);
            dir.mkdirs();
//Create the file
            String fileName = dirN + "\\" + urlAddress.replaceAll("\\W", "") + ".html";
            File file = new File(fileName);
            file.createNewFile();
//Write to the file a content

                FileWriter bw = new FileWriter(fileName);
                while ((inputContent = br.readLine()) != null) {
                    bw.write(inputContent);
                    allLinks.append(inputContent).append("\n");//add content to StringBuilder

                }

                bw.close();
                br.close();//close all streams

            LOGG.info("File was written");
            parsingText = allLinks.toString();//transform StringBuilder into the String

        } catch (MalformedURLException e) {
            System.out.println(e.getMessage());
            System.out.println("You have invalid URL");
            LOGG.info("You have a problem with  an url: " + urlAddress);
        } catch (IOException e) {
            System.out.println("Stream was closed");
            LOGG.info("Something wrong with a stream ");
        }
        return parsingText;
    }
}