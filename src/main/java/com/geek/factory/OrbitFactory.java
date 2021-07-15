package com.geek.factory;


import com.geek.model.Orbit;


public class OrbitFactory {

    public static Orbit createOrbit(String orbitName) {
    if (orbitName == null || orbitName.isBlank() || orbitName.isEmpty())
        return null;

    switch (orbitName) {
        case "ORBIT1": {
            return new Orbit("ORBIT1", 20,18);
        }

        case "ORBIT2": {
            return new Orbit("ORBIT2", 10,20);
        }
        default:
            return null;
    }
}

}
