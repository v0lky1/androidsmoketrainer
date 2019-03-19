package com.example.smoketrainer;

import java.util.ArrayList;
import java.util.List;

public class MapProvider {
    private static List<CounterStrikeMap> maps = new ArrayList<>();


    static {
        maps.add(new CounterStrikeMap("Mirage"));
        maps.add(new CounterStrikeMap("DustTwo"));
        maps.add(new CounterStrikeMap("Cache"));
        maps.add(new CounterStrikeMap("Inferno"));
        maps.add(new CounterStrikeMap("Train"));
        maps.add(new CounterStrikeMap("Nuke"));
        maps.add(new CounterStrikeMap("Overpass"));
    }

    public static List<CounterStrikeMap> getMaps() {
        return maps;
    }
}
