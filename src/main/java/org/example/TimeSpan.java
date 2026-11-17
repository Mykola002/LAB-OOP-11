package org.example;

import org.example.exceptions.IllegalInputTimeSpanException;
import org.example.exceptions.IllegalScaleFactorException;
import org.example.exceptions.NegativeTimeSpanException;

public class TimeSpan {
    private int hours;
    private int minutes;

    public TimeSpan(int hours, int minutes) {
        if (hours < 0 || minutes < 0 || minutes >= 60) {
            throw new IllegalInputTimeSpanException("Години та хвилини не можуть бути від'ємними, а хвилини мають бути від 0 до 59.");
        }
        this.hours = hours;
        this.minutes = minutes;
    }

    public void add(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalInputTimeSpanException("Вхідні дані для додавання не можуть бути від'ємними.");
        }
        this.hours += hours;
        this.minutes += minutes;
        if (this.minutes >= 60) {
            this.hours += this.minutes / 60;
            this.minutes %= 60;
        }
    }

    public void sub(int hours, int minutes) {
        if (hours < 0 || minutes < 0) {
            throw new IllegalInputTimeSpanException("Вхідні дані для віднімання не можуть бути від'ємними.");
        }
        int totalMinutes = (this.hours * 60 + this.minutes) - (hours * 60 + minutes);
        if (totalMinutes < 0) {
            throw new NegativeTimeSpanException("Часовий інтервал не може стати від'ємним.");
        }
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public void scale(double factor) {
        if (factor < 0) {
            throw new IllegalScaleFactorException("Множник scale не може бути від'ємним.");
        }
        int totalMinutes = (int) Math.round((this.hours * 60 + this.minutes) * factor);
        this.hours = totalMinutes / 60;
        this.minutes = totalMinutes % 60;
    }

    public int getHours() { return hours; }
    public int getMinutes() { return minutes; }
}