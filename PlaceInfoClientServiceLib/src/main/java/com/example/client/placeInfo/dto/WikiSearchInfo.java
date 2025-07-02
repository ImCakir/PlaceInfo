package com.example.client.placeInfo.dto;

import lombok.Data;

@Data
public class WikiSearchInfo {
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

    @Override
    public String toString() {
        return "WikiSearchInfo{" +
                "summary='" + summary + '\'' +
                ", elevation=" + elevation +
                ", geoNameId=" + geoNameId +
                ", feature='" + feature + '\'' +
                ", lng=" + lng +
                ", countryCode='" + countryCode + '\'' +
                ", rank=" + rank +
                ", thumbnailImg='" + thumbnailImg + '\'' +
                ", lang='" + lang + '\'' +
                ", title='" + title + '\'' +
                ", lat=" + lat +
                ", wikipediaUrl='" + wikipediaUrl + '\'' +
                '}';
    }
}