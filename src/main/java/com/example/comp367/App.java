package com.example.comp367;

import java.time.LocalTime;

public class App {
    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.now();
        int hour = currentTime.getHour();

        String greeting;
        if (hour < 12) {
            greeting = "Good morning, Khaleed Opeloyeru, Welcome to COMP367, have a good day";
        } else {
            greeting = "Good afternoon, Khaleed Opeloyeru, Welcome to COMP367, how is your day going?";
        }
        System.out.println(greeting);
    }
}