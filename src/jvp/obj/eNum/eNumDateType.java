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
public enum eNumDateType {
     DayOfWeek(0,"Day of Week"),
     Date_Single(1,"Single Date"),
     Date_Range(2,"Singel Date Range")
     ;
    private int i;
    private String str;
    private eNumDateType(int i,String str){
        this.i = i;
        this.str = str;
    }
    public int getDateType(){
        return i;
    }
    public String getDateTypeDesc(){
        return str;
    }
}
