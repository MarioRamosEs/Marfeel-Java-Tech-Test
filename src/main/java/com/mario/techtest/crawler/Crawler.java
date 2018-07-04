package com.mario.techtest.crawler;

import com.mario.techtest.model.Site;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class Crawler {
    Site site;

    Crawler(Site site){
        this.site = site;
    }

    String analyze(){
        try {
            Document document = Jsoup.connect("http://"+site.getUrl()).get();
            String title = document.title();

            if(title.contains("news") || title.contains("noticias")){
                site.setMarfeelizable(1);
            }else{
                site.setMarfeelizable(-1);
            }

            return site.getMarfeelizable() + " --- " + document.title();
        } catch (IOException e) {
            //e.printStackTrace();
            return "";
        }
    }
}
