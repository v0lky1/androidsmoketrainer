package com.v0lky1.smoketrainer.objects;

import java.util.ArrayList;
import java.util.List;

public class CounterStrikeMap {
    private List<Smoke> smokes = new ArrayList<>();
    private String name;

    public CounterStrikeMap(String name) {
        this.name = name;
    }

    public void addSmoke(Smoke smoke) {
        smokes.add(smoke);
    }

    public String getName() {
        return name;
    }

    public List<Smoke> getSmokes() {
        return smokes;
    }

    public Smoke getSmokeById(int id) {
        for(Smoke smoke : smokes) {
            if(smoke.getSmokeId() == id) {
                return smoke;
            }
        }
        return null;
    }

}


