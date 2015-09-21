package parser;

import java.util.Set;
import java.util.Vector;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
/**
 * Created by Дарья on 17.09.2015.
 */
public class TestHTMLLinkExtractor {
    private HTMLLinkExtractor htmlLinkExtractor;
    String TEST_LINK = "http://www.google.com";

    @BeforeClass
    public void initData() {
        htmlLinkExtractor = new HTMLLinkExtractor();
    }

    @DataProvider
    public Object[][] HTMLContentProvider() {
        return new Object[][] {
                new Object[] { "abc hahaha <a href='" +"111111"+ TEST_LINK + "'>31e21google</a>" },
                new Object[] { "abc hahaha <a HREF='" + TEST_LINK + "'>googlecdscc</a>" },

                new Object[] { "abc hahaha <A HREF='" + TEST_LINK + "'>google</A> , "
                        + "abc hahaha <A HREF='" + TEST_LINK + "' target='_blank'>google</A>" },

                new Object[] { "abc hahaha <A HREF='" + TEST_LINK + "' target='_blank'>google</A>" },
                new Object[] { "abc hahaha <A target='_blank' HREF='" + TEST_LINK + "'>google</A>" },
                new Object[] { "abc hahaha <A target='_blank' HREF=\"" + TEST_LINK + "\">google</A>" },
                new Object[] { "abc hahaha <a HREF=" + TEST_LINK + ">google</a>" }, };
    }

    @Test(dataProvider = "HTMLContentProvider")
    public void ValidHTMLLinkTest(String htmlToString) {
htmlToString =GetURLContent.writeToFile("http://www.google.com","TestLinks.html");
        Set<String> links = htmlLinkExtractor.parseStringBuilder(htmlToString);

        //there must have something
        Assert.assertTrue(links.size() != 0);

        for (int i = 0; i < links.size(); i++) {
            if (links.iterator().hasNext()) {
                String htmlLinks = links.iterator().next();

                System.out.println(htmlLinks);
                Assert.assertEquals(htmlLinks, TEST_LINK);
            }
        }

    }
}
