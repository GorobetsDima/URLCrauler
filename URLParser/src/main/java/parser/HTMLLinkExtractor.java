package parser;


import java.util.*;
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
    public Set <String> parseStringBuilder( String htmlToString) {
//        htmlToString= GetURLContent.writeToFile(GetURLContent.urlAddress, GetURLContent.fileName);

        Set<String> result = new HashSet<>();



        matcherTag = patternTag.matcher(htmlToString);

        while (matcherTag.find()) {


            String href = matcherTag.group(1); // href
            String linkText = matcherTag.group(2); // link text


            matcherLink = patternLink.matcher(href);


            while (matcherLink.find()) {

                String link = matcherLink.group(1); // link
                link = link.replaceAll("'", "");
                link = link.replaceAll("\"", "");

                if (link.startsWith("http")) {

                result.add(link);

            }
            }
            }
        for (String b :result){
            System.out.println(b);
        }

        return result;
        }






}



        