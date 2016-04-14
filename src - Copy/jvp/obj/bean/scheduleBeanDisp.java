/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvp.obj.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import jvp.obj.eNum.eNumDayOfWeek;
import jvp.obj.eNum.eNumWeekInd;

/**
 *
 * @author lmeans
 */
@ManagedBean(name = "scheduleBeanDisp")
public class scheduleBeanDisp extends scheduleBean  implements Serializable{
    private String dowStr=null,dowIndStr=null;
    public String getDowStr(){
        if (dowStr == null) dowStr = eNumDayOfWeek.sunday.getDowStr(this.getDow()).getDow();
        return dowStr;
    }
    public String getDowIndStr(){
        if (dowIndStr == null) dowIndStr = eNumWeekInd.every.geteNumWeekInd(this.getDowInd()).getDow();
        return dowIndStr;
    }
    public String getTime(){
        String am = "am";
        int i = this.getHrs();
        if (i > 12){
            i = i - 12;
            am = "pm";
        }
        return i+":"+this.getMin()+" "+am;
    }
    
}
