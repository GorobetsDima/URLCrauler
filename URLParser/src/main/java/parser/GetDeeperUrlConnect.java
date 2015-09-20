package parser;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Вика on 20.09.2015.
 */
class GetDeeperUrlConnect implements Runnable {
    private String urlAddress = "http://www.mkyong.com";
    private String fileName = "C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser\\Crauler.html";
    private HTMLLinkExtractor extractor = new HTMLLinkExtractor();
    private String htmlToString = GetURLContent.writeToFile(urlAddress, fileName);
    private Set<String> firstLinks = extractor.parseStringBuilder(htmlToString);


    //метод который заходит в множество ссылок и записывает в файл их содержимое
    public Set<String> writeToDiffFiles(Set<String> links) {
        HTMLLinkExtractor extractor = new HTMLLinkExtractor();

        Set<String> linksDeep = null;

        if (links.iterator().hasNext()) {
            String newFileName = "C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser\\html.files\\" + links.iterator().next() + ".html";
            String htmlToStringDeep = GetURLContent.writeToFile(links.iterator().next(), newFileName);
            linksDeep = extractor.parseStringBuilder(htmlToStringDeep);

        }
        return linksDeep;
    }



    @Override
    public void run() {


        System.out.println("Thread started:::"+Thread.currentThread().getName());
        try {
            writeToDiffFiles(firstLinks);
            Thread.sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::"+Thread.currentThread().getName());
    }

}
