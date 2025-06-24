package com.example.client.placeInfo.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

public class WikiSearch {
    public String summary;
    public int elevation;
    public int geoNameId;
    public String feature;
    public double lng;
    public String countryCode;
    public int rank;
    public String thumbnailImg;
    public String lang;
    public String title;
    public double lat;
    public String wikipediaUrl;
}