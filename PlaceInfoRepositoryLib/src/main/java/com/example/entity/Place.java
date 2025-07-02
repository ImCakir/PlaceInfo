package com.example.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "place_query")
@Data
public class Place {
    @Id
    public String question;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "place", cascade = CascadeType.ALL)
    public List<PlaceInfo> placeInfoList;

}
