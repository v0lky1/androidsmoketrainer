package com.v0lky1.smoketrainer.providers;

import com.v0lky1.smoketrainer.objects.CounterStrikeMap;
import com.v0lky1.smoketrainer.MapType;

import java.util.ArrayList;
import java.util.List;

public class MapProvider {
    private static List<CounterStrikeMap> maps = new ArrayList<>();


    static {
        CounterStrikeMap mirage = new CounterStrikeMap("Mirage", MapType.MIRAGE);
        CounterStrikeMap cache = new CounterStrikeMap("Cache", MapType.CACHE);
        CounterStrikeMap dusttwo = new CounterStrikeMap("Dust 2", MapType.DUST2);

        maps.add(mirage);
        maps.add(cache);
        maps.add(dusttwo);
    }

    public static List<CounterStrikeMap> getMaps() {
        return maps;
    }

    public static CounterStrikeMap returnMap(String name) {
        for (CounterStrikeMap map : maps) {
            if (map.getName().equals(name)) {
                return map;
            }
        }
        // cant happen if input is correct
        return null;
    }
}
