import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JsoupCrawler {

    private static String URL = "https://sports.news.naver.com/kbaseball/index.nhn";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements elements = doc.select("div.home_news");

            for (Element element : elements.select("li > a")) {
                System.out.println("<li><a href=\"https://sports.news.naver.com" + element.attr("href") +"\"><span>"+element.getElementsByTag("span").text()+"</span></a></li>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

