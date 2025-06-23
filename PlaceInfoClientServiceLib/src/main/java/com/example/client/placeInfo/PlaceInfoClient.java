package com.example.client.placeInfo;


import com.example.client.placeInfo.dto.Root;
import com.example.client.placeInfo.dto.WikiSearch;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class PlaceInfoClient {
    private final RestTemplate restTemplate;
    private static final String WIKI_SEARCH_API_URL_TEMPLATE =
            "http://api.geonames.org/wikipediaSearchJSON?formatted=true&q=%s&maxRows=1&username=imXaka&style=full";

    public PlaceInfoClient(RestTemplate RestTemplate)
    {
        this.restTemplate = RestTemplate;
    }


    public WikiSearch getWikiSearch(String question)
    {
        var WIKI_SEARCH_API_URL = String.format(WIKI_SEARCH_API_URL_TEMPLATE, question);

        return restTemplate.getForObject(WIKI_SEARCH_API_URL, WikiSearch.class);
    }

    public List<WikiSearch> getWikiSearchInList(String question)
    {
        var WIKI_SEARCH_API_URL = String.format(WIKI_SEARCH_API_URL_TEMPLATE, question);

        return restTemplate.getForObject(WIKI_SEARCH_API_URL, Root.class).getListWikiSearch();
    }



}
