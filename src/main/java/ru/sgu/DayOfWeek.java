package ru.sgu;

public enum DayOfWeek {
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;

    public DayOfWeek nextDay(int days) {
        int currentIndex = this.ordinal();
        int nextIndex = (currentIndex + days) % 7;
        return DayOfWeek.values()[nextIndex];
    }
}
