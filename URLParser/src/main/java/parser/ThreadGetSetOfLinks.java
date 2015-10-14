package parser;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;

/**
 * Created by Dmitriy Gorobets on 21.09.2015.
 */
public class ThreadGetSetOfLinks extends Thread {
    String urlAddress;
    String dirName;
    int n;

    public ThreadGetSetOfLinks(int n, String name, String urlAddress, String dirName) {
        super(name);
        this.urlAddress = urlAddress;
        this.dirName = dirName;
        this.n = n;
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread started:::" + Thread.currentThread().getName());
                Set<String> links = GetDeeperUrlConnect.getSetOfLinks(urlAddress, dirName);
                for (String link : links) {
                    urlAddress = link;
                    dirName = dirName + link+ ".html";
                    GetDeeperUrlConnect.writeToDiffFiles(n - 1, urlAddress, dirName);// рекурсивно вызываю метод поиска новых ссылок

            }
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::" + Thread.currentThread().getName());

    }
}
