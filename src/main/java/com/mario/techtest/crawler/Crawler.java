package com.mario.techtest.crawler;

import com.mario.techtest.model.Site;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Crawler implements Runnable {
    private Site site;
    private Thread t;

    Crawler(Site site){
        this.site = site;
    }

    @Override
    public void run() {
        try {
            Document document = Jsoup.connect("http://"+site.getUrl()).get();
            site.setTitle(document.title());

            if(site.getTitle().contains("news") || site.getTitle().contains("noticias")){
                site.setMarfeelizable(1);
            }else{
                site.setMarfeelizable(-1);
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }

        System.out.println(site.getMarfeelizable()+" --- "+site.getUrl());
    }

    public void start () {
        //System.out.println("Starting " +  site.getUrl() );
        if (t == null) {
            t = new Thread (this);
            t.start ();
        }
    }
}
