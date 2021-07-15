package com.geek;



import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;


public class Traffic {
    public static void main(String[] args) {
        String inputFile = null;
        try {
            inputFile = args[0];
            List<String> routeParameters;
            routeParameters = Files.readAllLines(Paths.get(inputFile),
                    StandardCharsets.UTF_8);
            // Split the line on basis of Space Char
            routeParameters= Arrays.asList(routeParameters.get(0).split(" "));

            RouteVehicleDeciderService deciderService = new RouteVehicleDeciderService();
          //  deciderService.decider(routeParameters);
           System.out.println(deciderService.evaluate(routeParameters)) ;


        } catch (IOException e) {
            System.out.println(" Specified file " + inputFile + "  not found. Supply valid file location");
        }
    }
}
