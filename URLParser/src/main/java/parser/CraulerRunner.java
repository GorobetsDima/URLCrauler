package parser;

/**
 * Created by ���� on 21.09.2015.
 */
public class CraulerRunner {
    public static void main(String[] args) {
//        ThreadCreator.startThreads();

//        HTMLLinkExtractor html  = new HTMLLinkExtractor();
//        html.parseStringBuilder(GetURLContent.writeToFile("http://www.mkyong.com", "C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser"));

        GetDeeperUrlConnect.writeToDiffFiles(2,"http://www.mkyong.com", "C:\\Users\\Вика\\IdeaProjects\\URLParser\\URLParser");
    }
}
