import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import static org.junit.Assert.*;

public class JsoupCrawlerTest {

    @Test
    public void makeHtml() {
        assertEquals("<!DOCTYPE html><html lang=\"ko\"><head> <meta charset=\"utf-8\"><title>주요뉴스 Crawling</title></head><body><div><ul><li>test_html_tag</li></ul></div></body></html>", JsoupCrawler.makeHtml("<li>test_html_tag</li>"));
        assertEquals("<!DOCTYPE html><html lang=\"ko\"><head> <meta charset=\"utf-8\"><title>주요뉴스 Crawling</title></head><body><div><ul><li>Kim Yongjun</li></ul></div></body></html>", JsoupCrawler.makeHtml("<li>Kim Yongjun</li>"));
    }

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