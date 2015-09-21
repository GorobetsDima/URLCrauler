package parser;

/**
 * Created by Вика on 21.09.2015.
 */
public class CraulerRunner {
    public static void main(String[] args) {
//        ThreadCreator.startThreads();

        HTMLLinkExtractor html  = new HTMLLinkExtractor();
        System.out.println( html.parseStringBuilder(GetURLContent.writeToFile("http://www.mkyong.com", "Crauler.html")));

//        GetDeeperUrlConnect.writeToDiffFiles(1,"http://www.mkyong.com","C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser\\html.files\\Crauler.html");
    }
}
