package com.mario.techtest.crawler;

import com.mario.techtest.crawler.checker.Checker;
import com.mario.techtest.model.Site;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class Crawler implements Runnable {
    private Site site;
    private ArrayList<Checker> checkers;

    Crawler(Site site, ArrayList<Checker> checkers) {
        this.site = site;
        this.checkers = checkers;
    }

    @Override
    public void run() {
        try {
            Document document = Jsoup.connect("http://" + site.getUrl()).get();

            boolean marfeelizable = true;
            for (Checker checker : checkers) {
                if (!checker.check(document)) marfeelizable = false;
            }
            site.setMarfeelizable(marfeelizable);

        } catch (IOException e) {
            //e.printStackTrace();
        }
    }
}
