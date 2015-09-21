package parser;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * Created by Вика on 21.09.2015.
 */
public class ThreadGetSetOfLinks extends Thread {
    String urlAddress;
    String fileName;
    int n;

    public ThreadGetSetOfLinks(int n, String name, String urlAddress, String fileName) {
        super(name);
        this.urlAddress = urlAddress;
        this.fileName = fileName;
        this.n = n;
    }

    @Override
    public void run() {

        Set<String> links = GetDeeperUrlConnect.getSetOfLinks(urlAddress, fileName);
        urlAddress = links.iterator().next();
        fileName = "C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser\\html.files\\" + links.iterator().next() + ".html";
        GetDeeperUrlConnect.writeToDiffFiles(n - 1, urlAddress, fileName);

    }

}
