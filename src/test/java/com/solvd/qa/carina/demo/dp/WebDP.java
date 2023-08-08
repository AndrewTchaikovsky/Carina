package com.solvd.qa.carina.demo.dp;

import org.testng.annotations.DataProvider;

import java.util.Arrays;
import java.util.List;

public class WebDP {
    static List<String> autoPartsAndAccessoriesLinks = Arrays.asList("Car & Truck Parts & Accessories", "Motorcycle & Scooter Parts & Accessories", "Performance & Racing Parts", "In-Car Technology, GPS & Security Devices", "Boat Parts", "Vehicle Repair Manuals & Literature", "View all in Auto Parts & Accessories");
    static List<String> otherVehiclesAndTrailersLinks = Arrays.asList("RVs & Campers", "Commercial Trucks", "Buses", "Vehicle Trailers", "Aircraft", "Golf Carts", "View all in Other Vehicles & Trailers");
    static List<String> motorcyclesLinks = Arrays.asList("Harley-Davidson Motorcycles", "Honda Motorcycles");
    @DataProvider(name = "containerData")
    public static Object[][] containerData() {
        return new Object[][]{
                {"Auto Parts & Accessories", autoPartsAndAccessoriesLinks},
                {"Other Vehicles & Trailers", otherVehiclesAndTrailersLinks},
                {"Motorcycles", motorcyclesLinks}
        };
    }
}
