package com.mario.techtest.crawler;

import com.mario.techtest.model.Site;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CrawlerController {
    ArrayList<Site> sites;

    public CrawlerController(ArrayList<Site> sites){
        this.sites = sites;
    }

    /*public String analyze(){
        String output = "";
        for (Site site : sites){
            Crawler crawler = new Crawler(site);
            crawler.start();
        }
        return output;
    }*/

    public String analyze(){
        ExecutorService es = Executors.newCachedThreadPool();
        for (Site site : sites){
            Crawler crawler = new Crawler(site);
            es.execute(crawler);
            //crawler.start();
        }

        es.shutdown();
        try {
            boolean finshed = es.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String output = "";
        for (Site site : sites){
            output += site.getMarfeelizable()+" --- "+site.getUrl() + "\n";
        }
        return output;
    }
}
