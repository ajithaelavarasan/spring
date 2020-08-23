package com.mission.ajitha;


import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public class Shows {
    String name;
    String channel;
    ShowTime st;
    List<String> broadcastinglangs;
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getBroadcastinglangs() {
        return broadcastinglangs;
    }

    public void setBroadcastinglangs(List<String> broadcastinglangs) {
        this.broadcastinglangs = broadcastinglangs;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public ShowTime getSt() {
        return st;
    }

    public void setSt(ShowTime st) {
        this.st = st;
    }
}
