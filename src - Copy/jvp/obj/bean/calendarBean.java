/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jvp.obj.bean;


import java.io.Serializable;
import java.util.Date;
import javax.faces.bean.ManagedBean;



@ManagedBean(name = "calendarBean")
public class calendarBean  implements Serializable{
    private int calId ;
    private int calRollupId ;
	private String calDesc;
	private int calType = 0;
	private Date startDate,modDate;
	private Date enddate;
	private int userId;
	private int deptId=-20;
	private int lookupId;
	private int lookupFlag;
	private String subjectText;
	private String subjectBody;
        private String startDateDisp,endDateDisp,modDateDisplay,userName,deptName;
        
        public calendarBean(){
            
        }
    /**
     * @return the calId
     */
    public int getCalId() {
        return calId;
    }

    /**
     * @param calId the calId to set
     */
    public void setCalId(int calId) {
        this.calId = calId;
    }

    /**
     * @return the caRollupId
     */
    public int getCalRollupId() {
        return calRollupId;
    }

    /**
     * @param caRollupId the caRollupId to set
     */
    public void setCalRollupId(int caRollupId) {
        this.calRollupId = caRollupId;
    }

    /**
     * @return the calDesc
     */
    public String getCalDesc() {
        return calDesc;
    }

    /**
     * @param calDesc the calDesc to set
     */
    public void setCalDesc(String calDesc) {
        this.calDesc = calDesc;
    }

    /**
     * @return the calType
     */
    public int getCalType() {
        return calType;
    }

    /**
     * @param calType the calType to set
     */
    public void setCalType(int calType) {
        this.calType = calType;
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
     * @return the enddate
     */
    public Date getEnddate() {
        if (enddate == null) enddate = getStartDate();
        return enddate;
    }

    /**
     * @param enddate the enddate to set
     */
    public void setEnddate(Date enddate) {
        this.enddate = enddate;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the deptId
     */
    public int getDeptId() {
        return deptId;
    }

    /**
     * @param deptId the deptId to set
     */
    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }

    /**
     * @return the lookupId
     */
    public int getLookupId() {
        return lookupId;
    }

    /**
     * @param lookupId the lookupId to set
     */
    public void setLookupId(int lookupId) {
        this.lookupId = lookupId;
    }

    /**
     * @return the lookupFlag
     */
    public int getLookupFlag() {
        return lookupFlag;
    }

    /**
     * @param lookupFlag the lookupFlag to set
     */
    public void setLookupFlag(int lookupFlag) {
        this.lookupFlag = lookupFlag;
    }

    /**
     * @return the subjectText
     */
    public String getSubjectText() {
        if (subjectText == null || subjectText.trim().length() == 0) return this.calDesc;
        return subjectText;
    }

    /**
     * @param subjectText the subjectText to set
     */
    public void setSubjectText(String subjectText) {
        this.subjectText = subjectText;
    }

    /**
     * @return the subjectBody
     */
    public String getSubjectBody() {
        return subjectBody;
    }

    /**
     * @param subjectBody the subjectBody to set
     */
    public void setSubjectBody(String subjectBody) {
        this.subjectBody = subjectBody;
    }

    /**
     * @return the startDateDisp
     */
    public String getStartDateDisp() {
        return startDateDisp;
    }

    /**
     * @param startDateDisp the startDateDisp to set
     */
    public void setStartDateDisp(String startDateDisp) {
        this.startDateDisp = startDateDisp;
    }

    /**
     * @return the endDateDisp
     */
    public String getEndDateDisp() {
        return endDateDisp;
    }

    /**
     * @param endDateDisp the endDateDisp to set
     */
    public void setEndDateDisp(String endDateDisp) {
        this.endDateDisp = endDateDisp;
    }

   

    /**
     * @return the modDateDisplay
     */
    public String getModDateDisplay() {
        return modDateDisplay;
    }

    /**
     * @param modDateDisplay the modDateDisplay to set
     */
    public void setModDateDisplay(String modDateDisplay) {
        this.modDateDisplay = modDateDisplay;
    }

    /**
     * @return the modDate
     */
    public Date getModDate() {
        return modDate;
    }

    /**
     * @param modDate the modDate to set
     */
    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the deptName
     */
    public String getDeptName() {
        return deptName;
    }

    /**
     * @param deptName the deptName to set
     */
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
