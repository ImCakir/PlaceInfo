package com.example.PlaceInfoApplication.Controller;

import com.example.client.placeInfo.PlaceInfoClient;
import com.example.client.placeInfo.dto.Root;
import com.example.client.placeInfo.dto.WikiSearch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev/api")
public class PlaceInfoController {
    private final PlaceInfoClient m_placeInfoClient;

    public PlaceInfoController(PlaceInfoClient placeInfoClient)
    {
        m_placeInfoClient = placeInfoClient;
    }
    @GetMapping("place")
    public WikiSearch getPlace(@RequestParam String q)
    {
        return m_placeInfoClient.getWikiSearchInSingle(q);
    }
    @GetMapping("details")
    public Iterable<WikiSearch>  getPlaceInList(@RequestParam String q)
    {
        return m_placeInfoClient.getWikiSearchInList(q);
    }

    @GetMapping("demo")
    public Root getPlaceRoot(@RequestParam String q)
    {
        return m_placeInfoClient.getWikiSearch(q);
    }
}