package com.mario.techtest.crawler;

import com.mario.techtest.model.Site;

import java.util.ArrayList;

public class CrawlerController {
    ArrayList<Site> sites;

    public CrawlerController(ArrayList<Site> sites){
        this.sites = sites;
    }

    public String analyze(){
        String output = "";
        for (Site site : sites){
            Crawler crawler = new Crawler(site);
            crawler.start();
        }
        return output;
    }
}
