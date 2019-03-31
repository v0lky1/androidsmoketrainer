package com.v0lky1.smoketrainer.providers;

import com.v0lky1.smoketrainer.MapType;
import com.v0lky1.smoketrainer.objects.Smoke;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmokeProvider {
    static Map<MapType, List<Smoke>> smokeMap = new HashMap<>();

    static {
        //init
        smokeMap.put(MapType.DUST2, new ArrayList<Smoke>());
        smokeMap.put(MapType.MIRAGE, new ArrayList<Smoke>());
        smokeMap.put(MapType.CACHE, new ArrayList<Smoke>());
        //initial data
        smokeMap.get(MapType.DUST2).add(new Smoke("CT", "https://www.youtube.com/embed/FwchfGjl3Yw"));
        smokeMap.get(MapType.DUST2).add(new Smoke("Xbox", "https://www.youtube.com/embed/mrN0Yix_348"));
        smokeMap.get(MapType.CACHE).add(new Smoke("A main", "https://www.youtube.com/embed/Nsozmzl_wYU"));
        smokeMap.get(MapType.CACHE).add(new Smoke("Smoke mid", "https://www.youtube.com/embed/e7oD-xgMd2U"));
        smokeMap.get(MapType.MIRAGE).add(new Smoke("Window", "https://www.youtube.com/embed/geIjiGT1KJo"));
        smokeMap.get(MapType.MIRAGE).add(new Smoke("Connector", "https://youtube.com/embed/W4jS2A6KQ8I"));



    }

    public static Map<MapType, List<Smoke>> getSmokeMap() {
        return smokeMap;
    }
}
