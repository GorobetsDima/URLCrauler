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
    private Set<String> links = extractor.parseStringBuilder(htmlToString);
//    private  int numberOfLinks = 1;

    //метод который заходит в множество ссылок и записывает в файл их содержимое
    public Set<String> writeToDiffFiles(int numberOfLinks) {

        HTMLLinkExtractor htmlExtr = new HTMLLinkExtractor();
        Set<String> setOfLinks = new Set<String>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<String> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(String s) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends String> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }
        };
        Set<String> linksDeep = null;

        for (int numOfLiks = 0; numOfLiks < numberOfLinks; numOfLiks++) {


            for (int setSize = 0; setSize < writeToDiffFiles(numberOfLinks).size(); setSize++) {
                if (links.iterator().hasNext()) {
                    String fileName = "C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser\\html.files\\" + links.iterator().next() + ".html";
                    String htmlToStringDeep = GetURLContent.writeToFile(links.iterator().next(), fileName);
                    linksDeep = htmlExtr.parseStringBuilder(htmlToStringDeep);
//                setOfLinks.add(htmlToStringDeep);
                }

            }
            if (setOfLinks.iterator().hasNext()) {
                numberOfLinks = linksDeep.size();
                writeToDiffFiles(numberOfLinks);
            }
        }


        return linksDeep;

    }

    @Override
    public void run() {


//        System.out.println("Thread started:::"+Thread.currentThread().getName());
//        try {
//            Thread.sleep(4000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println("Thread ended:::"+Thread.currentThread().getName());
    }

}
