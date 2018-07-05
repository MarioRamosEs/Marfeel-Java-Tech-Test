package com.mario.techtest;

import com.mario.techtest.crawler.Crawler;
import com.mario.techtest.crawler.checker.Checker;
import com.mario.techtest.crawler.checker.CheckerTitleNews;
import com.mario.techtest.model.Site;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.jsoup.nodes.Document;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.IOException;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TechtestApplicationTests {

    private ArrayList<Checker> checkers;

    @Before
    public void setUp() {
        //Set checkers
        checkers = new ArrayList<>();
        checkers.add(new CheckerTitleNews());
    }

    @Test
    public void testIsMarfeelizableIsMarfeelizable(){
        Document document = new Document("");
        document.html("<head><title>News</title></head>");
        Crawler crawler = new Crawler(null, checkers);

        boolean result = crawler.isMarfeelizable(document);

        Assert.assertTrue(result);
    }

    @Test
    public void testIsMarfeelizableIsNotMarfeelizable(){
        Document document = new Document("");
        document.html("<head><title>Google</title></head>");
        Crawler crawler = new Crawler(null, checkers);

        boolean result = crawler.isMarfeelizable(document);

        Assert.assertFalse(result);
    }

    @Test
    public void testIsMarfeelizableNoTitle(){
        Document document = new Document("");
        document.html("<head></head>");
        Crawler crawler = new Crawler(null, checkers);

        boolean result = crawler.isMarfeelizable(document);

        Assert.assertFalse(result);
    }
}
