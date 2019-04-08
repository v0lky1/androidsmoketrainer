package com.v0lky1.smoketrainer.providers;

import com.v0lky1.smoketrainer.objects.CounterStrikeMap;
import com.v0lky1.smoketrainer.objects.Smoke;

import java.util.ArrayList;
import java.util.List;

public class MapProvider {
    private static List<CounterStrikeMap> maps = new ArrayList<>();


    static {
        CounterStrikeMap mirage = new CounterStrikeMap("Mirage");
        CounterStrikeMap cache = new CounterStrikeMap("Cache");
        CounterStrikeMap dusttwo = new CounterStrikeMap("Dust 2");

        maps.add(mirage);
        maps.add(cache);
        maps.add(dusttwo);

        mirage.addSmoke(new Smoke("CT", "https://www.youtube.com/embed/CMusM2fueqw"));
        mirage.addSmoke(new Smoke("Other CT", "https://www.youtube.com/embed/CMusM2fueqw"));
        cache.addSmoke(new Smoke("CT", "https://www.youtube.com/embed/CMusM2fueqw"));
        cache.addSmoke(new Smoke("Other CT", "https://www.youtube.com/embed/CMusM2fueqw"));
        dusttwo.addSmoke(new Smoke("CT", "https://www.youtube.com/embed/CMusM2fueqw"));
        dusttwo.addSmoke(new Smoke("Other CT", "https://www.youtube.com/embed/CMusM2fueqw"));

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
