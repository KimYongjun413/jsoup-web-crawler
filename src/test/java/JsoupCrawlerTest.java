import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsoupCrawlerTest {
    @Test
    public void Cookbook() {
        String html = "<p>An <a href='http://example.com/'><b>example</b></a> link.</p>";
        Document doc = Jsoup.parse(html);
        Element link = doc.select("a").first();

        assertEquals("An example link.",doc.body().text());
        assertEquals("<a href=\"http://example.com/\"><b>example</b></a>", link.toString());
        assertEquals("http://example.com/", link.attr("href"));
        assertEquals("http://example.com/",link.attr("abs:href"));
        assertEquals("example",link.text());
        assertEquals("<a href=\"http://example.com/\"><b>example</b></a>",link.outerHtml());
        assertEquals("<b>example</b>",link.html());
    }
}