package com.geek;

import java.util.HashMap;
import java.util.Map;

public class TrafficConstants {
    static Map<String,Float> craterVehicleSpeed = null;
    static
    {
        craterVehicleSpeed = new HashMap(3);
        craterVehicleSpeed.put("BIKE",.02f);
        craterVehicleSpeed.put("CAR",.033f);
        craterVehicleSpeed.put("TUKTUK",.01f);
    }
}
