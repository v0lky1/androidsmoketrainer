package com.v0lky1.smoketrainer.models;

public class Smoke {

    private String title;
    private String url;
    private boolean seen = false;
    private int seenCounter = 0;
    private int smokeId;
    private static int smokeCounter;

    public int getSmokeId() {
        return smokeId;
    }

    public Smoke(String title, String url) {
        this.title = title;
        this.url = url;
        smokeId = smokeCounter++;
    }

    public Smoke() {
        smokeId = smokeCounter++;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public boolean isSeen(){
        return seen;
    }

    public int getSeenCounter() {
        return seenCounter;
    }

    public void setSeenCounter(int seenCounter) {
        this.seenCounter = seenCounter;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
