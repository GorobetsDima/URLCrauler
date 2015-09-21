package parser;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by Вика on 20.09.2015.
 */
class GetDeeperUrlConnect implements Runnable {
    private String urlAddress = "http://www.mkyong.com";//первая ссылка
    private String fileName = "C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser\\Crauler.html";//первая директория,корневая
//    private HTMLLinkExtractor extractor = new HTMLLinkExtractor();
//    private String htmlToString = GetURLContent.writeToFile(urlAddress, fileName);
//    private Set<String> firstLinks = extractor.parseStringBuilder(htmlToString);


    //TODO метод который заходит в множество ссылок и записывает в файл их содержимое
//    public Set<String> writeToDiffFiles(Set<String> links) {
//        HTMLLinkExtractor extractor = new HTMLLinkExtractor();
//        if (!links.iterator().hasNext()) {
//            return null;
//        }
//
//
//        Set<String> linksDeep = null;
//
//        if (links.iterator().hasNext()) {
//            String newFileName = "C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser\\html.files\\" + links.iterator().next() + ".html";
//            String htmlToStringDeep = GetURLContent.writeToFile(links.iterator().next(), newFileName);
//            linksDeep = extractor.parseStringBuilder(htmlToStringDeep);
//            links.remove(links.iterator().next());
//            writeToDiffFiles(links);
//
//        }
//        return linksDeep;
//    }

    //метод возвращает сет ссылок полученных с html
    public Set<String> getSetOfLinks(String urlAddress, String fileName) {

        HTMLLinkExtractor extractor = new HTMLLinkExtractor();

        Set<String> links = null;
        String htmlToStringDeep = GetURLContent.writeToFile(urlAddress, fileName);
        links = extractor.parseStringBuilder(htmlToStringDeep);

        return links;
    }

    // метод переберает ссылки из полученного сета вызвает рекурсивно метод getSetLinks
    public void writeToDiffFiles(int n, String urlAddress, String fileName) {

        if (n == 0) return;
        Set<String> links = getSetOfLinks(urlAddress, fileName);
        while (links.iterator().hasNext()) {
//            ThreadCreator.startThreads(urlAddress);
            urlAddress = links.iterator().next();
            fileName = "C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser\\html.files\\" + links.iterator().next() + ".html";

            writeToDiffFiles(n - 1, urlAddress, fileName);
        }
    }


//        Set<String> links = null;
//        String htmlToStringDeep = GetURLContent.writeToFile(urlAddress, fileName);
//        links = extractor.parseStringBuilder(htmlToStringDeep);
////        if (links.iterator().hasNext()) {
//        urlAddress = links.iterator().next();
//        fileName = "C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser\\html.files\\" + links.iterator().next() + ".html";
//
//
//        links.remove(links.iterator().next());
//        writeToDiffFiles(links);
//
////        }
//        return links;
//    }


    //    @Override
//    public void run() {
//
//
//        System.out.println("Thread started:::" + Thread.currentThread().getName());
//        try {
//            writeToDiffFiles(2, this.urlAddress, this.fileName);
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Thread ended:::" + Thread.currentThread().getName());
//    }
    @Override
    public void run() {


        System.out.println("Thread started:::" + Thread.currentThread().getName());
        try {
            met(5);

            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread ended:::" + Thread.currentThread().getName());
    }

    public int met(int n) {
        if (n == 0) return 1;
        int result;

        result = met(n - 1) + 1;
        ThreadCreator.startThreads();
        System.out.println(result);
        return result;

    }

}
