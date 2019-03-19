package com.example.smoketrainer;

import java.util.ArrayList;
import java.util.List;

public class SmokeProvider {


    public static List<Smoke> getSmokes(MapType mapType) {
        List<Smoke> smokes = new ArrayList<>();
        switch(mapType) {
            case DUST2:
                smokes.add(new Smoke("ct", "https://streamable.com/s/oi1x3/cmuqfk"));
                smokes.add(new Smoke("t", "https://www.youtube.com/embed/YHGyMy53LP4"));
                break;
            case MIRAGE:
                smokes.add(new Smoke("ct", "https://www.youtube.com/embed/YHGyMy53LP4"));
                smokes.add(new Smoke("t", "https://www.youtube.com/embed/YHGyMy53LP4"));
                break;
            case CACHE:
                smokes.add(new Smoke("ct", "https://www.youtube.com/embed/YHGyMy53LP4"));
                smokes.add(new Smoke("t", "https://www.youtube.com/embed/YHGyMy53LP4"));
                break;
        }
        return smokes;
    }
}
