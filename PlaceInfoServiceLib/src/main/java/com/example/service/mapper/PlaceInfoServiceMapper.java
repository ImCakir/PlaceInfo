package com.example.service.mapper;

import com.example.client.placeInfo.dto.WikiSearch;
import com.example.client.placeInfo.dto.WikiSearchInfo;

import com.example.entity.Place;
import com.example.entity.PlaceInfo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(implementationName = "PlaceInfoMapperImpl", componentModel = "spring")
public interface PlaceInfoServiceMapper {

    @Mapping(source = "lang", target = "language")
    @Mapping(source = "lng", target = "longitude")
    @Mapping(source = "lat", target = "latitude")
    Iterable<PlaceInfo> dtoToIterableEntity(Iterable<WikiSearchInfo> dtoIterable);

    @Mapping(source = "lang", target = "language")
    @Mapping(source = "lng", target = "longitude")
    @Mapping(source = "lat", target = "latitude")
    PlaceInfo wikiSearchInfoToPlaceInfo(WikiSearchInfo wikiSearchInfo);
    //wikiSearchToPlace'nun içererisindeki List<wikiSearchInfo> olduğu için var

    @Mapping(source = "geonames", target = "placeInfoList")
    Place wikiSearchToPlace(WikiSearch wikiSearch);
}