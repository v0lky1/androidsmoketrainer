package com.v0lky1.smoketrainer.providers;

import com.v0lky1.smoketrainer.models.CounterStrikeMap;
import com.v0lky1.smoketrainer.models.Smoke;

import java.util.ArrayList;
import java.util.List;

public class MapProvider {
    private static List<CounterStrikeMap> maps = new ArrayList<>();

    /**
     * voegt initiele waarden toe; maps en de desbetreffende smokes
     */

    static {
        CounterStrikeMap mirage = new CounterStrikeMap("Mirage");
        CounterStrikeMap cache = new CounterStrikeMap("Cache");
        CounterStrikeMap dusttwo = new CounterStrikeMap("Dust 2");

        maps.add(mirage);
        maps.add(cache);
        maps.add(dusttwo);

        mirage.addSmoke(new Smoke("CT from backramp", "https://d1playscdntv-a.akamaihd.net/video/IhDm2Pqy-IE/processed/720.mp4"));
        mirage.addSmoke(new Smoke("Jungle from backramp", "https://d1playscdntv-a.akamaihd.net/video/IhDnZ4jAg1F/processed/720.mp4"));
        mirage.addSmoke(new Smoke("Jungle from backramp", "https://d1playscdntv-a.akamaihd.net/video/IhDnxxX1i-H/processed/720.mp4"));
        mirage.addSmoke(new Smoke("Uppermid from spawn", "https://d1playscdntv-a.akamaihd.net/video/IhDog5bMNfH/processed/720.mp4"));
        mirage.addSmoke(new Smoke("Jungle from underpass", "https://d1playscdntv-a.akamaihd.net/video/IhDpTi1A_1k/processed/720.mp4"));


        cache.addSmoke(new Smoke("Car from main", "https://d1playscdntv-a.akamaihd.net/video/IhDqNuMy11j/processed/720.mp4"));
        cache.addSmoke(new Smoke("Mid smokes from garage", "https://d1playscdntv-a.akamaihd.net/video/IhDrNr-Sj-m/processed/720.mp4"));


        dusttwo.addSmoke(new Smoke("Start of B from tunnels", "https://d1playscdntv-a.akamaihd.net/video/IhDmHJSy-Gk/processed/720.mp4"));
        dusttwo.addSmoke(new Smoke("Mid box from outside long", "https://d1playscdntv-a.akamaihd.net/video/IhDll0SSj7G/processed/720.mp4"));
        dusttwo.addSmoke(new Smoke("Cross long from long", "https://d1playscdntv-a.akamaihd.net/video/IhDk22r1i7n/processed/720.mp4" ));
        dusttwo.addSmoke(new Smoke("Mid to B from mid box", "https://d1playscdntv-a.akamaihd.net/video/IhDTGPAzLGm/processed/720.mp4"));
    }

    /**
     * returned maps
     * @return
     */
    public static List<CounterStrikeMap> getMaps() {
        return maps;
    }

    /**
     * 
     * @param id
     * @return
     */
    public static CounterStrikeMap returnById(int id) {
        for(CounterStrikeMap map: maps) {
            if(map.getMapId() == id) {
                return map;
            }
        }
        return null;
    }
    public static void removeCounterStrikeMap(CounterStrikeMap csMap){
        maps.remove(csMap);
    }
}
