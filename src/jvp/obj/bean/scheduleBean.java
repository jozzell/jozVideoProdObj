/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvp.obj.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.bean.ManagedBean;
import jvp.obj.eNum.eNumDayOfWeek;
import jvp.obj.eNum.eNumWeekInd;


/**
 *
 * @author lmeans
 */
@ManagedBean(name = "scheduleBean")
public class scheduleBean  implements Serializable{
    private int scheduleId;
    private int sysId;
    private int custId;
    private int hrs;
    private int min;
    private int dur;
    private int dow;
    private int dowInd,attachCnt;
    private int lookup,vendorId;
    private String text,path;
    private String body;
    private boolean am=true,amEnd;
     private String dowStr=null,dowIndStr=null,startDateStr=null,endDateStr;
     private Date startDate,endDate;
    
     public String getStartDateStr(){
         if(startDateStr == null ){
             if (this.getDowInd() <= -1){
             startDateStr = new SimpleDateFormat("EEE MMMM dd").format(startDate);
             } else {
                 startDateStr= "";
             }
         }
         return startDateStr;
     }
     public String getEndDateStr(){
         if(endDateStr == null){
             if (this.getDowInd() == -2){
                endDateStr = new SimpleDateFormat("EEE MMMM dd").format(endDate);
             } else {
                 endDateStr = "";
             }
         }
         return endDateStr;
     }
     public String getDowStr(){
          if (this.getDowInd() == -1){
                dowStr = "";
            } else {
                if (dowStr == null) dowStr = eNumDayOfWeek.sunday.getDowStr(this.getDow()).getDow();
          }
        return dowStr;
    }
    public String getDowIndStr(){
        if (dowIndStr == null) {
            if (this.getDowInd() <= -1){
                dowIndStr = "";
            } else {
                dowIndStr = eNumWeekInd.every.geteNumWeekInd(this.getDowInd()).getDow();
            }
        }
        return dowIndStr;
    }
    public String getTime(){
        
        return this.getHrs()+":"+(this.getMin() < 10 ? "0"+this.getMin():this.getMin()) +" "+(am ? "am":"pm");
    }
    /**
     * @return the scheduleId
     */
    public int getScheduleId() {
        return scheduleId;
    }

    /**
     * @param scheduleId the scheduleId to set
     */
    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    /**
     * @return the sysId
     */
    public int getSysId() {
        return sysId;
    }

    /**
     * @param sysId the sysId to set
     */
    public void setSysId(int sysId) {
        this.sysId = sysId;
    }

    /**
     * @return the custId
     */
    public int getCustId() {
        return custId;
    }

    /**
     * @param custId the custId to set
     */
    public void setCustId(int custId) {
        this.custId = custId;
    }

    /**
     * @return the hrs
     */
    public int getHrs() {
        return hrs;
    }

    /**
     * @param hrs the hrs to set
     */
    public void setHrs(int hrs) {
        this.hrs = hrs;
    }

    /**
     * @return the min
     */
    public int getMin() {
        return min;
    }

    /**
     * @param min the min to set
     */
    public void setMin(int min) {
        this.min = min;
    }

    /**
     * @return the dur
     */
    public int getDur() {
        return dur;
    }

    /**
     * @param dur the dur to set
     */
    public void setDur(int dur) {
        this.dur = dur;
    }

    /**
     * @return the dow
     */
    public int getDow() {
        return dow;
    }

    /**
     * @param dow the dow to set
     */
    public void setDow(int dow) {
        this.dow = dow;
    }

    /**
     * @return the dowInd
     */
    public int getDowInd() {
        return dowInd;
    }

    /**
     * @param dowInd the dowInd to set
     */
    public void setDowInd(int dowInd) {
        this.dowInd = dowInd;
    }

    /**
     * @return the lookup
     */
    public int getLookup() {
        return lookup;
    }

    /**
     * @param lookup the lookup to set
     */
    public void setLookup(int lookup) {
        this.lookup = lookup;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the body
     */
    public String getBody() {
        return body;
    }

    /**
     * @param body the body to set
     */
    public void setBody(String body) {
        this.body = body;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the am
     */
    public boolean isAm() {
        return am;
    }

    /**
     * @param am the am to set
     */
    public void setAm(boolean am) {
        this.am = am;
    }

    /**
     * @return the vendorId
     */
    public int getVendorId() {
        return vendorId;
    }

    /**
     * @param vendorId the vendorId to set
     */
    public void setVendorId(int vendorId) {
        this.vendorId = vendorId;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the attachCnt
     */
    public int getAttachCnt() {
        return attachCnt;
    }

    /**
     * @param attachCnt the attachCnt to set
     */
    public void setAttachCnt(int attachCnt) {
        this.attachCnt = attachCnt;
    }
}
