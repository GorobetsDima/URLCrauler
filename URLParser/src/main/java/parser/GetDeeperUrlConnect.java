package parser;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Gorobets Dmitriy on 20.09.2015.
 */
class GetDeeperUrlConnect  {


    //метод возвращает сет ссылок полученных с html
    public static Set<String> getSetOfLinks(String urlAddress, String dirName) {

        HTMLLinkExtractor extractor = new HTMLLinkExtractor();

        Set<String> links = null;
        String htmlToStringDeep = GetURLContent.writeToFile(urlAddress, dirName);
        links = extractor.parseStringBuilder(htmlToStringDeep);

        return links;
    }

    // метод переберает ссылки из полученного сета вызвает рекурсивно метод getSetLinks
    public static void writeToDiffFiles(int n, String urlAddress, String dirName) {

        if (n == 0) return;
        Set<String> links = getSetOfLinks(urlAddress, dirName);
        for (String link : links) {
            urlAddress = link;
        ThreadGetSetOfLinks th = new ThreadGetSetOfLinks(n, String.format("%s%s", "Thread:", link), urlAddress, dirName);
            th.start();
            try {
                th.join(100);
            } catch (InterruptedException e) {
                System.out.println("Thread" + th + "was interrupted");

            }
            writeToDiffFiles(n - 1, urlAddress, dirName);
        }
    }
}


