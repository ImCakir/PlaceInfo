package com.example.PlaceInfoApplication.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/places")
public class PlaceInfoController {
    private PlaceInfoClient m_placeInfoClient;

    public PlaceInfoController(PlaceInfoClient placeInfoClient)
    {
        m_placeInfoClient = placeInfoClient;
    }


}
