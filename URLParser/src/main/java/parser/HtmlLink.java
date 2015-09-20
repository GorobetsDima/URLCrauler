package parser;

/**
 * Created by Дарья on 17.09.2015.
 */
public class HtmlLink {

    String link;
    String linkText;

    HtmlLink(){};

    @Override
    public String toString() {
        return new StringBuffer("Link : ").append(this.link)
                .append(" Link Text : ").append(this.linkText).toString();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = replaceInvalidChar(link);
    }

    public String getLinkText() {
        return linkText;
    }

    public void setLinkText(String linkText) {
        this.linkText = linkText;
    }

    private String replaceInvalidChar(String link){
        link = link.replaceAll("'", "");
        link = link.replaceAll("\"", "");
        return link;
    }

}
