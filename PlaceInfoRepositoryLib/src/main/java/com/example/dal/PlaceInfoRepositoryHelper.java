package com.example.dal;

import com.example.entity.Place;
import com.example.entity.PlaceInfo;
import com.example.repository.IPlaceInfoRepository;
import com.example.repository.IPlaceRepository;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PlaceInfoRepositoryHelper {
    private final IPlaceRepository placeRepository;
    private final IPlaceInfoRepository placeInfoRepository;

    public PlaceInfoRepositoryHelper(IPlaceRepository placeRepository,
                                     IPlaceInfoRepository placeInfoRepository) {
        this.placeRepository = placeRepository;
        this.placeInfoRepository = placeInfoRepository;
    }

    public boolean existByPlace(String question)
    {
        return placeRepository.existsById(question);
    }

    public boolean existByPlaceInfo(Long Id)
    {
        return placeInfoRepository.existsById(Id);
    }
    public Iterable<PlaceInfo> saveAllPlaceInfo(Iterable<PlaceInfo> placeInfos)
    {
        return placeInfoRepository.saveAll(placeInfos);
    }

    public Place savePlace(Place place)
    {
        return placeRepository.save(place);
    }

    public PlaceInfo savePlaceInfo(PlaceInfo placeInfo)
    {
        return placeInfoRepository.save(placeInfo);
    }

    public Optional<PlaceInfo>  findByPlaceId(Long Id)
    {
        return placeInfoRepository.findById(Id);
    }
    public Optional<Place>  findByPlace(String question)
    {
        return placeRepository.findById(question);
    }

    public Iterable<Place> findByAllPlace(Iterable<String> iterQ)
    {
        return placeRepository.findAllById(iterQ);
    }

}
