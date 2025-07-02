package com.example.client.placeInfo.dto;

import lombok.Data;
import java.util.List;

@Data
public class WikiSearch {
    public List<WikiSearchInfo> geonames;

    @Override
    public String toString() {
        return "WikiSearch{" +
                "geonames=" + geonames +
                '}';
    }
}

