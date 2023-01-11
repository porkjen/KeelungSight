package com.springboot.demo;

import com.springboot.demo.entity.Sight;
import com.springboot.demo.repository.ProductRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class KeelungSightsCrawler {

    @Autowired
    private ProductRepository repository;

    public KeelungSightsCrawler() {

    }

    public List<Sight> getItems() {

        List<Sight> sightList = new ArrayList<>();

        try {
            Document document = Jsoup.connect("https://www.travelking.com.tw/tourguide/taiwan/keelungcity/").get();
            Elements items = document.getElementsByClass("box");
            Elements zones = items.select("h4");
            String[] zoneArray = new String[100];
            int c = 0;
            for(Element zone:zones){
                String text = zone.text();
                zoneArray[c] = text;
                c++;
            }
            for(int count = 1; count <= 7; count++){
                Elements items2 = items.select("ul").get(count).select("a");
                for(int i=0; i<items2.size(); i++){
                    Sight sight = new Sight();
                    sight.setSightName(items2.get(i).attr("title"));
                    sight.setZone(zoneArray[count-1]);
                    Document whole = Jsoup.connect("https://www.travelking.com.tw"+items2.get(i).attr("href")).get();
                    Elements pt = whole.getElementsByClass("point_type");
                    sight.setCategory(pt.select("strong").text());
                    Elements pc = whole.getElementsByClass("gpic");
                    sight.setPhotoURL(pc.select("img").attr("data-src"));
                    Elements dc = whole.getElementsByClass("main fixed").select("meta[itemprop=description]");
                    sight.setDescription(dc.attr("content"));
                    Elements ad = whole.getElementsByClass("main fixed").select("meta[itemprop=address]");
                    sight.setAddress(ad.attr("content"));
                    sightList.add(sight);
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return sightList;
    }
}