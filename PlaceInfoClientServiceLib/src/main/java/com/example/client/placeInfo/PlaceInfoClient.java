package com.example.client.placeInfo;


import com.example.client.placeInfo.dto.Root;
import com.example.client.placeInfo.dto.WikiSearch;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Component
public class PlaceInfoClient {
    private final RestTemplate restTemplate;
    private static final String WIKI_SEARCH_API_URL_TEMPLATE =
            "http://api.geonames.org/wikipediaSearchJSON?q=%s&maxRows=1&username=imXaka";

    public PlaceInfoClient(RestTemplate RestTemplate)
    {
        this.restTemplate = RestTemplate;
    }


    public Root getWikiSearch(String question)
    {
       return restTemplate.getForObject(String.format(WIKI_SEARCH_API_URL_TEMPLATE, question), Root.class);
    }

    public Iterable<WikiSearch> getWikiSearchInList(String question)
    {
        return getWikiSearch(question).geonames;
    }

    public WikiSearch getWikiSearchInSingle(String question)
    {
        return Objects.requireNonNull(restTemplate.getForObject(String.format(WIKI_SEARCH_API_URL_TEMPLATE, question), Root.class)).geonames.get(1);
    }



}
