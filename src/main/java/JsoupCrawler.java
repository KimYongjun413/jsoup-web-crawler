import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsoupCrawler {

    private static String URL = "https://sports.news.naver.com/kbaseball/index.nhn";

    public static void main(String[] args) {
        try {
            Document doc = Jsoup.connect(URL).get();
            Elements elements = doc.select("div.home_news");
            StringBuilder htmlTag = new StringBuilder();
            for (Element element : elements.select("li > a")) {
                htmlTag.append("<li><a href=\"https://sports.news.naver.com")
                        .append(element.attr("href"))
                        .append("\"><span>")
                        .append(element.getElementsByTag("span").text())
                        .append("</span></a></li>");
            }
            Files.write(Paths.get("주요뉴스" + ".html"), makeHtml(htmlTag.toString()).getBytes("UTF-8"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String writeHtml(String htmlTag) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>");
        html.append("<html lang=\"ko\">");
        html.append("<head> <meta charset=\"utf-8\">");
        html.append("<title>주요뉴스 Crawling</title>");
        html.append("</head>");
        html.append("<body><div><ul>");
        html.append(htmlTag);
        html.append("</ul></div></body>");
        html.append("</html>");
        return html.toString();
    }

    public static String makeHtml(String htmlTag) {
        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>");
        html.append("<html lang=\"ko\">");
        html.append("<head> <meta charset=\"utf-8\">");
        html.append("<title>주요뉴스 Crawling</title>");
        html.append("</head>");
        html.append("<body><div><ul>");
        html.append(htmlTag);
        html.append("</ul></div></body>");
        html.append("</html>");

        return html.toString();
    }
}

