package com.example.service;

import com.example.client.placeInfo.PlaceInfoClient;
import com.example.dal.PlaceInfoRepositoryHelper;
import com.example.entity.Place;
import com.example.entity.PlaceInfo;
import com.example.service.mapper.PlaceInfoServiceMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.StreamSupport;

@Service
public class PlaceInfoAppService {
    private final PlaceInfoServiceMapper placeInfoServiceMapper;
    private final PlaceInfoRepositoryHelper placeInfoRepositoryHelper;
    private final PlaceInfoClient placeInfoClient;

    public PlaceInfoAppService(PlaceInfoClient placeInfoClient,
                               PlaceInfoRepositoryHelper placeInfoRepositoryHelper,
                               PlaceInfoServiceMapper placeInfoServiceMapper)
    {
        this.placeInfoClient = placeInfoClient;
        this.placeInfoRepositoryHelper = placeInfoRepositoryHelper;
        this.placeInfoServiceMapper = placeInfoServiceMapper;
    }


    public List<PlaceInfo> findByPlaceInfo(String question)
    {
        if(placeInfoRepositoryHelper.existByPlace(question))
            return onDataFoundInDatabase(question);
        return onDataNotFoundInDatabase(question);
    }


    private List<PlaceInfo> onDataFoundInDatabase(String question)
    {
        return  placeInfoRepositoryHelper.findByPlace(question)
                .map(Place::getPlaceInfoList)
                .orElse(List.of());
    }

    private List<PlaceInfo> onDataNotFoundInDatabase(String question)
    {
        var place = new Place();
        place.setQuestion(question);

        var placeInfoIter = placeInfoServiceMapper.dtoToIterableEntity(
                placeInfoClient.getWikiSearchInList(question));

        placeInfoIter.forEach(pi -> pi.setPlace(place));

        place.setPlaceInfoList(StreamSupport.stream(placeInfoIter.spliterator(), false).toList());

        placeInfoRepositoryHelper.savePlace(place);

        var saved = placeInfoRepositoryHelper.saveAllPlaceInfo(placeInfoIter);

        return StreamSupport.stream(saved.spliterator(), false).toList();
    }


    public Place findByPlace(String question)
    {
        throw new UnsupportedOperationException("Not implemented yet");
    }

}
