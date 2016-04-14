/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvp.obj.bean;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import jvp.obj.eNum.eNumDateType;
import jvp.obj.eNum.eNumDayOfWeek;
import jvp.obj.eNum.eNumWeekInd;
/**
 *
 * @author lmeans
 */
@ManagedBean
public class lookupBean implements Serializable{
    private int val;
    private String disp;
    public lookupBean(){
        
    }
    public lookupBean(eNumWeekInd eNum){
        this.val = eNum.getDowId();
        this.disp = eNum.getDow();
    }
    public lookupBean(eNumDayOfWeek eNum){
        this.val = eNum.getDowId();
        this.disp = eNum.getDow();
    }
    public lookupBean(eNumDateType eNum){
        this.val = eNum.getDateType();
        this.disp = eNum.getDateTypeDesc();
    }
    public lookupBean(int val,String disp){
        this.val = val;
        this.disp = disp;
        
    }
    /**
     * @return the val
     */
    public int getVal() {
        return val;
    }

    /**
     * @param val the val to set
     */
    public void setVal(int val) {
        this.val = val;
    }

    /**
     * @return the disp
     */
    public String getDisp() {
        return disp;
    }

    /**
     * @param disp the disp to set
     */
    public void setDisp(String disp) {
        this.disp = disp;
    }
}
