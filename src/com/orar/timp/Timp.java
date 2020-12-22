package com.orar.timp;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

public class Timp {
    int year;
    int month;
    int nDay;
    int hour;
    int minute;
    int secunde;
    public Timp() {
        LocalDateTime now = LocalDateTime.now();
        year = now.getYear();
        month = now.getMonthValue();
        DayOfWeek day = now.getDayOfWeek();
        nDay = day.getValue();
        hour = now.getHour();
        minute = now.getMinute();
        secunde = now.getSecond();
    }
    public Timp getTime() {
        LocalDateTime now = LocalDateTime.now();
        year = now.getYear();
        month = now.getMonthValue();
        DayOfWeek day = now.getDayOfWeek();
        nDay = day.getValue();
        hour = now.getHour();
        minute = now.getMinute();
        secunde = now.getSecond();
        return this;
    }

    public int getnDay() {
        return nDay;
    }

    public int getHour() {
        if (hour > 22 || hour < 8) {
            return 22;
        } else {
            return hour;
        }
    }

    public int getMinute() {
        return hour;
    }

    public int getSecunde() {
        return hour;
    }

    public static String numeZi(int z) {
        if (z > 7) {
            z = z % 7 + 1;
        }
        if (z == 1) {
            return "Luni";
        } else if (z == 2) {
            return "Marti";
        } else if (z == 3) {
            return "Miercuri";
        } else if (z == 4) {
            return "Joi";
        } else if (z == 5) {
            return "Vineri";
        } else if (z == 6) {
            return "Sambata";
        } else {
            return "Duminica";
        }
    }
}
