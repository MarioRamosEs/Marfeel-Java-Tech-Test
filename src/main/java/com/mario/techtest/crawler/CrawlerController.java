package com.mario.techtest.crawler;

import com.mario.techtest.crawler.checker.Checker;
import com.mario.techtest.crawler.checker.CheckerTitleNews;
import com.mario.techtest.model.Site;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CrawlerController {
    private ArrayList<Site> sites;
    private ArrayList<Checker> checkers;

    public CrawlerController(ArrayList<Site> sites){
        this.sites = sites;

        //Set checkers
        checkers = new ArrayList<>();
        checkers.add(new CheckerTitleNews());
    }

    public void analyze(){
        ExecutorService es = Executors.newCachedThreadPool();
        for (Site site : sites){
            Crawler crawler = new Crawler(site, checkers);
            es.execute(crawler);
        }

        es.shutdown();
        try {
            es.awaitTermination(1, TimeUnit.MINUTES); // Thread timeout 1 minute
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
