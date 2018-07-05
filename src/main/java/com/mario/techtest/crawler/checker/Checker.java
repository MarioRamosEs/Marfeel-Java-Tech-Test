package com.mario.techtest.crawler.checker;

import org.jsoup.nodes.Document;

public interface Checker {
    boolean check(Document document);
}
