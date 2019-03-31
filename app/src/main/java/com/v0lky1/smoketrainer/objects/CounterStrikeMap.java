package com.v0lky1.smoketrainer.objects;

import com.v0lky1.smoketrainer.MapType;

public class CounterStrikeMap {
    private MapType mapType;
    private String name;

    public CounterStrikeMap(String name, MapType mapType) {
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
