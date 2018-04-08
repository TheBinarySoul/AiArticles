package com.thebinarysoul.aiarticles.sites;

import com.thebinarysoul.aiarticles.Article;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.List;

@Slf4j
public class MlWeekly extends Site {
    @Override
    public List<Article> getArticles() {
        try {
            Document document = Jsoup.connect("http://mlweekly.com/").get();
            Elements elements = document.getElementsByAttributeValue("class", "item__title");

            String url = elements.first().getElementsByTag("a").attr("href");
            String title = elements.first().getElementsByTag("a").text();

            list.add(new Article(title, url));

        } catch (Throwable e) {
            log.error("Failed parsing http://mlweekly.com: ", e);
        }

        return list;
    }
}
