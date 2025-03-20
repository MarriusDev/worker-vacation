package com.example.VacationWorker;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class HolidayCalculator {

    public Set<LocalDate> getHolidays(LocalDate date) {
        Set<LocalDate> holidays = new HashSet<>();

        holidays.add(LocalDate.of(date.getYear(), 1, 1));
        holidays.add(LocalDate.of(date.getYear(), 5, 1));
        holidays.add(LocalDate.of(date.getYear(), 5, 8));
        holidays.add(LocalDate.of(date.getYear(), 7, 5));
        holidays.add(LocalDate.of(date.getYear(), 7, 6));
        holidays.add(LocalDate.of(date.getYear(), 9, 28));
        holidays.add(LocalDate.of(date.getYear(), 10, 28));
        holidays.add(LocalDate.of(date.getYear(), 11, 17));
        holidays.add(LocalDate.of(date.getYear(), 12, 24));
        holidays.add(LocalDate.of(date.getYear(), 12, 25));
        holidays.add(LocalDate.of(date.getYear(), 12, 26));


        LocalDate easterSunday = getEasterSunday(date.getYear());
        holidays.add(easterSunday.minusDays(2));
        holidays.add(easterSunday.plusDays(1));

        return holidays;
    }

    private LocalDate getEasterSunday(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l - 7 * m + 114) / 31;
        int day = ((h + l - 7 * m + 114) % 31) + 1;

        return LocalDate.of(year, month, day);
    }

}
