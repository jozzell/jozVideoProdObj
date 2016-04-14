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
public enum eNumDayOfWeek {
   
    sunday(0,"Sunday"),
            monday(1, "Monday"),
            tuesday(2, "Tuesday"),
            wednesday(3, "Wednesday"),
            thursday(4, "Thursday"),
            friday(5, "Friday"),
            saturday(6, "Saturday"),
            weekdays(7, "Monday-Friday"),
            weekends(8, "Saturday/Sunday"),
            daily(-1, "Daily");
    private int i;
    private String dow;
    private eNumDayOfWeek(int i,String dow){
        this.i = i;
        this.dow = dow;
    }
    public int getDowId(){
        return i;
    }
    public String getDow(){
        return this.dow;
    }
    public eNumDayOfWeek getDowStr(int i){
            switch(i){
                case -1:
                    return eNumDayOfWeek.daily;
            case 0:
                return eNumDayOfWeek.sunday;
            case 1:
                 return eNumDayOfWeek.monday;
            case 2:
                 return eNumDayOfWeek.tuesday;
            case 3:
                return eNumDayOfWeek.wednesday;
            case 4:
                return eNumDayOfWeek.thursday;
            case 5:
                return eNumDayOfWeek.friday;
            case 6:
                return eNumDayOfWeek.saturday;
            case 7:
                return eNumDayOfWeek.weekdays;
            case 8:
                return eNumDayOfWeek.weekends;
            default:
                return eNumDayOfWeek.sunday;
        }
    }
}
