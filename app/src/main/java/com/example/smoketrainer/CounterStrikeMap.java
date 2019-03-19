package com.example.smoketrainer;

import java.util.ArrayList;
import java.util.List;

public class CounterStrikeMap {
    private MapType mapType;
    private String name;

    public CounterStrikeMap (String name, MapType mapType){
        this.mapType = mapType;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public MapType getMapType() {
        return mapType;
    }
}
