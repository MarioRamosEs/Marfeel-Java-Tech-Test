package com.mario.techtest.controller;

import com.mario.techtest.crawler.CrawlerController;
import com.mario.techtest.model.Site;
import com.mario.techtest.model.SiteList;
import com.mario.techtest.repository.SiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SiteController {
    @Autowired
    SiteRepository siteRepository;

    @PostMapping("/marfeelCheck")
    public String handlePost(@RequestBody SiteList siteList) {
        CrawlerController crawlerController = new CrawlerController(siteList);
        crawlerController.analyze();

        //Save all sites and give a output message
        String output = "";
        for (Site site : siteList) {
            siteRepository.save(site);
            output += site.isMarfeelizable() + " --- " + site.getUrl() + "\n";
        }
        return output;
    }

    /*
        // Get All Sites
    @GetMapping("/sites")
    public List<Site> getAllSites() {
        return siteRepository.findAll();
    }

    // Create a new Site
    @PostMapping("/sites")
    public Site createSite(@Valid @RequestBody Site site) {
        return siteRepository.save(site);
    }

    // Get a Single Site
    @GetMapping("/sites/{id}")
    public Site getSiteById(@PathVariable(value = "id") Long siteId) {
        return siteRepository.findById(siteId)
                .orElseThrow(() -> new ResourceNotFoundException("Site", "id", siteId));
    }

    // Update a Site
    @PutMapping("/sites/{id}")
    public Site updateSite(@PathVariable(value = "id") Long siteId,
                           @Valid @RequestBody Site siteDetails) {

        Site site = siteRepository.findById(siteId)
                .orElseThrow(() -> new ResourceNotFoundException("Site", "id", siteId));

        site.setUrl(siteDetails.getUrl());
        site.setRank(siteDetails.getRank());
        site.setMarfeelizable(siteDetails.isMarfeelizable());

        Site updatedSite = siteRepository.save(site);
        return updatedSite;
    }

    // Delete a Site
    @DeleteMapping("/sites/{id}")
    public ResponseEntity<?> deleteSite(@PathVariable(value = "id") Long siteId) {
        Site site = siteRepository.findById(siteId)
                .orElseThrow(() -> new ResourceNotFoundException("Site", "id", siteId));

        siteRepository.delete(site);

        return ResponseEntity.ok().build();
    }*/
}