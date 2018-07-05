package com.mario.techtest.crawler.checker;

import org.jsoup.nodes.Document;

public class CheckerTitleNews implements Checker {

    private static final String NEWS = "news";
    private static final String NOTICIAS = "noticias";

    @Override
    public boolean check(Document document) {
        String title = document.title().toLowerCase();
        return (title.contains(NEWS) || title.contains(NOTICIAS));
    }
}
