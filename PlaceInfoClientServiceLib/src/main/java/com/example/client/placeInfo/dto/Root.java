package com.example.client.placeInfo.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data


public class Root {
    @JsonProperty("geonames")
    public List<WikiSearch> listWikiSearch;

}
