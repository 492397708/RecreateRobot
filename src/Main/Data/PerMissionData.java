package Main.Data;

import Main.Class.Event;

import java.util.concurrent.ConcurrentHashMap;

public class PerMissionData {
    public Long owner = 492397708L;

    public ConcurrentHashMap<String, Event> events = new ConcurrentHashMap<>();

    public PerMissionData() {
    }
}
