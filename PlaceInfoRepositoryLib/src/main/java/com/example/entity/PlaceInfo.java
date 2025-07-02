package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "place_info")
@Data
public class PlaceInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "placeInfo_id")
    public long id;

    @Column(name = "location_ıd")
    public long geoNameId;

    @Column(name = "altitude")
    public double elevation;

    @Column(name = "visibility_score")
    public int rank;

    public double longitude;

    public double latitude;

    @Column(name = "property")
    public String feature;

    @Column(name ="iso_country_cod")
    public String countryCode;

    @Column(name = "preview_image")
    public String thumbnailImg;

    public String language;

    public String title;

    @Column(length = 1024)
    public String summary;

    @Column(name = "wikipedia_url")
    public String wikipediaUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question", nullable = false)
    public Place place;

}
