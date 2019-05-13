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
            String title = elements.select("h2").text().substring(0,4);

            System.out.println("===================================================================================");
            System.out.println(title);
            System.out.println("===================================================================================");
            int idx = 0;
            for (Element element : elements.select("li")) {
                System.out.println(++idx + " : " + element.getElementsByAttribute("href").text());

            }
            System.out.println("===================================================================================\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

