package com.example.PlaceInfoApplication.Controller;

import com.example.client.placeInfo.PlaceInfoClient;
import com.example.client.placeInfo.dto.WikiSearchInfo;
import com.example.entity.PlaceInfo;
import com.example.service.PlaceInfoAppService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dev/api")
public class PlaceInfoController {
    private final PlaceInfoAppService  m_placeInfoAppService;
    private final PlaceInfoClient m_placeInfoClient;

    public PlaceInfoController(PlaceInfoAppService m_placeInfoAppService,
                               PlaceInfoClient m_placeInfoClient)
    {
        this.m_placeInfoAppService = m_placeInfoAppService;
        this.m_placeInfoClient = m_placeInfoClient;
    }

    @GetMapping("db/place")
    public PlaceInfo getPlaceByService(@RequestParam String q) {

        var pi = m_placeInfoAppService.findByPlaceInfo(q).getFirst();
        pi.setPlace(null); //json infinity loop temporary solution, could be handled service layer
        return pi;
    }

    @GetMapping("client/place")
    public WikiSearchInfo getPlaceByClient(@RequestParam String q)
    {
        return m_placeInfoClient.getWikiSearchInSingle(q);
    }

}