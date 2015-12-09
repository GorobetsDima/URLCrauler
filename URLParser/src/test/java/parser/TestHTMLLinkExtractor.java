package parser;

import java.util.Set;
import java.util.Vector;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

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
                new Object[] { "abc hahaha <a href='" + TEST_LINK + "'>google</a>" },
                new Object[] { "abc hahaha <a HREF='" + TEST_LINK + "'>google</a>" },

                new Object[] { "abc hahaha <A HREF='" + TEST_LINK + "'>google</A> , "
                        + "abc hahaha <A HREF='" + TEST_LINK + "' target='_blank'>google</A>" },

                new Object[] { "abc hahaha <A HREF='" + TEST_LINK + "' target='_blank'>google</A>" },
                new Object[] { "abc hahaha <A target='_blank' HREF='" + TEST_LINK + "'>google</A>" },
                new Object[] { "abc hahaha <A target='_blank' HREF=\"" + TEST_LINK + "\">google</A>" },
                new Object[] { "abc hahaha <a HREF=" + TEST_LINK + ">google</a>" }, };
    }

    @Test(dataProvider = "HTMLContentProvider")
    public void ValidHTMLLinkTest(String htmlToString) {

        Set<String> links = htmlLinkExtractor.parseStringBuilder(htmlToString);

        
        Assert.assertTrue(links.size() != 0);


           for(String link:links) {

               Assert.assertEquals(link, TEST_LINK);
           }

        }

    }

