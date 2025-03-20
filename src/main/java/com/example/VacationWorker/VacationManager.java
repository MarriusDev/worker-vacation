package com.example.VacationWorker;

import java.time.LocalDate;

public class VacationManager {

    private final HolidayCalculator holidayCalculator = new HolidayCalculator();

    public double calculateRemainingVacation(LocalDate start, LocalDate end, double balance) {
        double workTime = 7.75;

        while (!start.isAfter(end)) {
            if (isHoliday(start) || start.getDayOfWeek().getValue() >= 6) {
                start = start.plusDays(1);
                continue;
            }

            balance -= workTime;

            start = start.plusDays(1);
        }
        return balance;
    }

    public boolean isHoliday(LocalDate date) {
        return (this.holidayCalculator.getHolidays(date).contains(date));
    }

}
