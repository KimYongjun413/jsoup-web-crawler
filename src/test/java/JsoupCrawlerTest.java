import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;

public class JsoupCrawlerTest {


    @Test
    public void writeHtml() {
        assertEquals("<!DOCTYPE html><html lang=\"ko\"><head> <meta charset=\"utf-8\"><title>주요뉴스 Crawling</title><style>.major-news {color:orange;text-shadow:1px 1px;}</style></head><body><div><h1 class=\"major-news\">주요뉴스</h1><ul><li>test_html_tag</li></ul></div></body></html>", JsoupCrawler.writeHtml("<li>test_html_tag</li>"));
        assertEquals("<!DOCTYPE html><html lang=\"ko\"><head> <meta charset=\"utf-8\"><title>주요뉴스 Crawling</title><style>.major-news {color:orange;text-shadow:1px 1px;}</style></head><body><div><h1 class=\"major-news\">주요뉴스</h1><ul><li>Kim Yongjun</li></ul></div></body></html>", JsoupCrawler.writeHtml("<li>Kim Yongjun</li>"));
    }

    @Test
    public void Cookbook() {
        try {
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

            URL baseUrl = new URL("http://baeldung.com");
            URL relativeUrl = new URL(baseUrl, "/a-guide-to-java-sockets");
            assertEquals("http://baeldung.com/a-guide-to-java-sockets",relativeUrl.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void absUrl() throws MalformedURLException {
        String URL = "https://sports.news.naver.com/kbaseball/index.nhn";

        String href = "/kbaseball/news/read.nhn?oid=119&aid=0002328883";
        assertEquals("https://sports.news.naver.com/kbaseball/news/read.nhn?oid=119&aid=0002328883", JsoupCrawler.absUrl(URL, href));
        href = "/kbaseball/news/read.nhn?oid=109&aid=0004009093";
        assertEquals("https://sports.news.naver.com/kbaseball/news/read.nhn?oid=109&aid=0004009093", JsoupCrawler.absUrl(URL, href));
        href = "/kbaseball/news/read.nhn?oid=477&aid=0000183324";
        assertEquals("https://sports.news.naver.com/kbaseball/news/read.nhn?oid=477&aid=0000183324", JsoupCrawler.absUrl(URL, href));
    }
}