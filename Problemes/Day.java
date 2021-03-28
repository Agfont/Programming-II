/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ex1;

/**
 *
 * @author SERGIO
 */
public class Day {
    private int hour, minute, second;
    
    Day(int h, int m, int s) {
        this.hour = h;
        this.minute = m;
        this.second = s;
    }
    public void setHour(int h) {
        this.hour = h;
    }
    public int getHour() {
        return this.hour;
    }
    public void setMinute(int m) {
        this.hour = m;
    }
    public int getMinute() {
        return this.minute;
    }
    public void setSecond(int s) {
        this.hour = s;
    }
    public int getSecond() {
        return this.second;
    }
}