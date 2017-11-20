package com.bot.sites;

import com.bot.Article;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

public class OpenAI extends Site {
    @Override
    public List<Article> getArticles() {
        try {
            Document document = Jsoup.connect("https://blog.openai.com")
                    .userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_9_2) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.152 Safari/537.36")
                    .get();
            Elements elements = document.getElementsByTag("article");

            String url = "https://blog.openai.com" + elements.first().getElementsByTag("a").first().attr("href");
            String title = elements.first().getElementsByTag("h2").text();

            list.add(new Article(title, url));
        } catch (Throwable e){
            System.out.println("Failed parsing https://blog.openai.com \n\n" + e);
        }

        return list;
    }
}
