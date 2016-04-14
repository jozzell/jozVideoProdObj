/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvp.obj.eNum;

/**
 *
 * @author lmeans
 */
public enum eNumWeekInd {

    every(0, "Every"),
    every1st(1, "Every 1st"),
    every2nd(2, "Every 2nd"),
    every3rd(3, "Every 3rd"),
    every4th(4, "Every 4st"),
    every5th(5, "Every 5th");
    private int i;
    private String dow;

    private eNumWeekInd(int i, String dow) {
        this.i = i;
        this.dow = dow;
    }

    public int getDowId() {
        return i;
    }

    public String getDow() {
        return this.dow;
    }

    public eNumWeekInd geteNumWeekInd(int i) {
        switch (i) {

            case 1:
                return eNumWeekInd.every1st;
            case 2:
                return eNumWeekInd.every2nd;
            case 3:
                return eNumWeekInd.every3rd;
            case 4:
                return eNumWeekInd.every4th;
            case 5:
                return eNumWeekInd.every5th;
            default:
                return eNumWeekInd.every;

        }
    }
}
