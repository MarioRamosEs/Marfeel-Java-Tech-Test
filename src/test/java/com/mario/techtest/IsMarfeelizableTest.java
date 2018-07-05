package com.mario.techtest;

import com.mario.techtest.crawler.Crawler;
import com.mario.techtest.crawler.checker.Checker;
import com.mario.techtest.crawler.checker.CheckerTitleNews;
import org.jsoup.nodes.Document;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IsMarfeelizableTest {

    private ArrayList<Checker> checkers;
    private Crawler crawler;

    @Before
    public void setUp() {
        //Set checkers
        checkers = new ArrayList<>();
        checkers.add(new CheckerTitleNews());

        crawler = new Crawler(null, checkers);
    }

    @Test
    public void testIsMarfeelizableIsMarfeelizable() {
        Document document = new Document("");
        document.html("<head><title>News</title></head>");

        boolean result = crawler.isMarfeelizable(document);
        Assert.assertTrue(result);
    }

    @Test
    public void testIsMarfeelizableIsNotMarfeelizable() {
        Document document = new Document("");
        document.html("<head><title>Google</title></head>");

        boolean result = crawler.isMarfeelizable(document);
        Assert.assertFalse(result);
    }

    @Test
    public void testIsMarfeelizableNoTitle() {
        Document document = new Document("");
        document.html("<head></head>");

        boolean result = crawler.isMarfeelizable(document);
        Assert.assertFalse(result);
    }
}
