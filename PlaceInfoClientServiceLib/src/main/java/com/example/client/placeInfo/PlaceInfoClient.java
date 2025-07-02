package com.example.client.placeInfo;

import com.example.client.placeInfo.dto.WikiSearch;
import com.example.client.placeInfo.dto.WikiSearchInfo;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PlaceInfoClient {
    private final RestTemplate restTemplate;
    private static final String WIKI_SEARCH_API_URL_TEMPLATE =
            "http://api.geonames.org/wikipediaSearchJSON?q=%s&maxRows=1&username=imXaka";

    public PlaceInfoClient(RestTemplate RestTemplate)
    {
        this.restTemplate = RestTemplate;
    }

    public WikiSearch getWikiSearch(String question)
    {
       return restTemplate.getForObject(String.format(WIKI_SEARCH_API_URL_TEMPLATE, question), WikiSearch.class);
    }

    public Iterable<WikiSearchInfo> getWikiSearchInList(String question)
    {
        return getWikiSearch(question).geonames;
    }

    public WikiSearchInfo getWikiSearchInSingle(String question) {
        WikiSearch wikiSearch = restTemplate.getForObject(String.format(WIKI_SEARCH_API_URL_TEMPLATE, question), WikiSearch.class);
        if (wikiSearch != null && wikiSearch.geonames != null && !wikiSearch.geonames.isEmpty()) {
            return wikiSearch.geonames.get(0);
        }
        return null;
    }
}
