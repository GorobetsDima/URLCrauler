package parser;


import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLLinkExtractor {

    private Pattern patternTag;
    private Pattern patternLink;
    private Matcher matcherTag;
    private Matcher matcherLink;

    private static final String HTML_A_TAG_PATTERN = "(?i)<a([^>]+)>(.+?)</a>";
    private static final String HTML_A_HREF_TAG_PATTERN =
            "\\s*(?i)href\\s*=\\s*(\"([^\"]*\")|'[^']*'|([^'\">\\s]+))";


    public HTMLLinkExtractor() {
        patternTag = Pattern.compile(HTML_A_TAG_PATTERN);
        patternLink = Pattern.compile(HTML_A_HREF_TAG_PATTERN);
    }


    /**
     * Validate html with regular expression
     *
     * @param htmlToString string content for validation
     * @return Set htmlToString
     */
    public Set <String> parseStringBuilder(String htmlToString) {

        Set<String> result = new Set<String>() {
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
        } ;

        matcherTag = patternTag.matcher(htmlToString);

        while (matcherTag.find()) {


            String href = matcherTag.group(1); // href


            matcherLink = patternLink.matcher(href);


            while (matcherLink.find()) {

                String link = matcherLink.group(1); // link

                result.add(link);

            }
            System.out.println(result.toString());
        }
        return result;
    }

}

        