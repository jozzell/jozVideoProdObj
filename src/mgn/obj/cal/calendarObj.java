/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cal;

import jvp.obj.bean.calendarBean;
import jvp.obj.bean.scheduleBean;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import obj.db.v1.dbMgrInterface;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class calendarObj implements Serializable{
    public  final org.apache.log4j.Logger logger = (org.apache.log4j.Logger) org.apache.log4j.Logger.getLogger(calendarObj.class);
    calendarSql calendarSql;
    public calendarObj(){
        calendarSql = new calendarSql();
    }
    public List<scheduleBean> getsqlSelectSchedule_CustId(int id, dbMgrInterface db) {
        return getsqlSelectSchedulerDisp(new Object[]{id},calendarSql.sqlSelectSchedule_CustId,db);
    }
    public List<scheduleBean> getsqlSelectSchedule(int sysId, dbMgrInterface db) {
        return getsqlSelectSchedule(new Object[]{sysId},calendarSql.sqlSelectSchedule_SysId,db);
    }
    
    public List<scheduleBean> getsqlSelectSchedule(Object[] obj, String sql,dbMgrInterface db) {
        List<scheduleBean> list = new ArrayList<scheduleBean>();
         CachedRowSet rs = null;
         try {
            rs = db.getCachedRowSet(sql, obj);
            while(rs.next()){
                list.add(getscheduleBean(rs));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(rs);
        }
        return list;
        
    }
    public List<scheduleBean> getsqlSelectSchedulerDisp(Object[] obj, String sql,dbMgrInterface db) {
        List<scheduleBean> list = new ArrayList<scheduleBean>();
         CachedRowSet rs = null;
         try {
            rs = db.getCachedRowSet(sql, obj);
            while(rs.next()){
                list.add(getscheduleBean(rs));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(rs);
        }
        return list;
        
    }
    public void updateScheduler(scheduleBean b,dbMgrInterface db){
        try {
            db.updateDatabase( 
                    b.getScheduleId() == 0 ? calendarSql.sqlInsertScheduler : calendarSql.sqlUpldateSchudler,
                    getScheduler(b));
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
    private Object[] getScheduler(scheduleBean b){
        
        return new Object[]{
            b.getSysId(),
            b.getCustId(),
            b.getHrs(),
            b.getMin(),
            b.getDur(),
            b.getDow(),
            b.getDowInd(),
            b.getLookup(),
            b.getText() == null ? "": b.getText(),
            b.getBody() == null ? "": b.getBody(),
            b.getPath() == null ? "": b.getPath(),
            b.getVendorId(),
            b.getStartDate() != null ? b.getStartDate() : Calendar.getInstance().getTime() ,
            b.getEndDate()  != null ? b.getEndDate() : Calendar.getInstance().getTime() ,
            b.getScheduleId() == 0 ? null: b.getScheduleId()
        };
        //sys_id,cust_id,hrs,min,dur,dow,dow_ind,lookup_id,subject_text,subject_body,path
       
    }
    public scheduleBean getscheduleBean(CachedRowSet rs){
        scheduleBean b = new scheduleBean();
        try {
            b.setScheduleId(rs.getInt(1));
            b.setSysId(rs.getInt(2));
            b.setCustId(rs.getInt(3));
            b.setHrs(rs.getInt(4));
            b.setMin(rs.getInt(5));
            b.setDur(rs.getInt(6));
            b.setDow(rs.getInt(7));
            b.setDowInd(rs.getInt(8));
            b.setLookup(rs.getInt(9));
            b.setText(rs.getString(10));
            b.setBody((String)rs.getObject(11));
            b.setPath(rs.getString(12));
            b.setVendorId(rs.getInt(13));
            b.setStartDate(rs.getDate(14));
            b.setEndDate(rs.getDate(15));
            b.setAttachCnt(rs.getInt(16));
            b.setAm(b.getHrs() <= 12);
            if (!b.isAm()) b.setHrs(b.getHrs() - 12);
        } catch (SQLException ex) {
            logger.error(ex.getMessage());
        }
        return b;
    }
    
    
    
    //sqlGetSelectPostingListToday
    public  List<calendarBean> getListByStartDateAndType(int type,Date Start,Date end,dbMgrInterface db){
        return getList(calendarSql.selectSqlStartDateAndType,new Object[]{Start,end,type},db);
    }
    public  List<calendarBean> getListByEndDateAndType(int type,Date Start,Date end,dbMgrInterface db){
        return getList(calendarSql.selectSqlEndDateAndType,new Object[]{Start,end,type},db);
    }
    public  List<calendarBean> getListByModDateAndType(int type,Date Start,Date end,dbMgrInterface db){
        return getList(calendarSql.selectSqlModDateAndType,new Object[]{Start,end,type},db);
    }
    //
     public  List<calendarBean> getListByType(int type,boolean all,dbMgrInterface db){
         if(all){
             return getList(calendarSql.getCalSelectByTypeAll(),new Object[]{type},db);
         } else {
             return getList(calendarSql.getCalSelectByType(),new Object[]{type,0},db);
         }
        
    }
     
    public calendarBean getSqlSelectCalendarId(int calId, dbMgrInterface db) {
        List<calendarBean>  l =  getList(calendarSql.getCalSelecCalId(),new Object[]{calId},db);
        if (l == null || l.isEmpty()) return null;
        return l.get(0);
        
    }
    
    public  List<calendarBean> getList(String sql,Object[] ary,dbMgrInterface db){
        List<calendarBean> l = new ArrayList<calendarBean>();
        CachedRowSet rs = null;
        try {
            rs = db.getCachedRowSet(sql,ary);
            while(rs.next()){
                l.add(getCalenderBean(rs));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(rs);
        }
        return l;
    }
    // =======================================================================
    
    public  List<calendarBean> getListToday(int type,int days,dbMgrInterface db){
        return getList(type,calendarSql.sqlGetSelectPostingListToday(days),db);
    }
    public  List<calendarBean> getListTodayNonGrpUsr(int type,int days,dbMgrInterface db){
        return getList(type,calendarSql.sqlGetSelectPostingListTodayNonGrpUsr(days),db);
    }
    public  List<calendarBean> getList(int type,int days,dbMgrInterface db){
        return getList(type,calendarSql.sqlGetSelectPostingList(days),db);
    }
    private  List<calendarBean> getList(int type,String sql,dbMgrInterface db){
        List<calendarBean> l = new ArrayList<calendarBean>();
        CachedRowSet rs = null;
        try {
            rs = db.getCachedRowSet(sql, new Object[]{type});
            while(rs.next()){
                l.add(getCalenderBean(rs));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(rs);
        }
        return l;
    }
    public  void saveCalBean(calendarBean b,dbMgrInterface db){
        try {
            
            db.updateDatabase(
                    b.getCalId() == 0 ? calendarSql.calInsert : calendarSql.calUpdate_v2, 
                    getObject(b));
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
    public  calendarBean getCalEvent(int id,dbMgrInterface db ){
        calendarBean calendarBean = new calendarBean();
        CachedRowSet rs = null;
        try {
            rs = db.getCachedRowSet(calendarSql.calSelectById, new Object[]{id});
            while(rs.next()){
                calendarBean = getCalenderBean(rs);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(rs);
        }
        return calendarBean;
    }
    private  calendarBean getCalenderBean(CachedRowSet r){
        calendarBean b = null;
        try {
            b = new calendarBean();
            b.setCalId(r.getInt(1));
            b.setCalRollupId(r.getInt(2));
            b.setCalDesc(r.getString(3));
            b.setCalType(r.getInt(4));
            b.setStartDate(r.getDate(5));
            b.setEnddate(r.getDate(6));
            b.setUserId(r.getInt(7));
            b.setDeptId(r.getInt(8));
            b.setLookupId(r.getInt(9));
            b.setLookupFlag(r.getInt(10));
            b.setSubjectText(r.getString(11));
            b.setSubjectBody((String)r.getObject(12));
            b.setModDate(r.getDate(13));
            
                
            if (b.getStartDate() != null)b.setStartDateDisp(new SimpleDateFormat("EEE MMM dd yyyy hh:mm a").format(b.getStartDate()));
            if (b.getEnddate() != null)  b.setEndDateDisp(new SimpleDateFormat("EEE MMM dd yyyy hh:mm a").format(b.getEnddate()));
            if (b.getModDate() != null)  b.setModDateDisplay(new SimpleDateFormat("EEE MMM dd yyyy hh:mm a").format(b.getModDate()));
            b.setUserName(r.getString(14)+" "+r.getString(15));
            b.setDeptName(r.getString(16));
            
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }
        return b;
    }
    private  Object[] getObject(calendarBean b){

            return new Object[]{
                b.getCalRollupId(),
                b.getCalDesc() == null ? "":b.getCalDesc(),
                b.getCalType(),
              //new java.sql.Date( b.getStartDate().getTime())  ,
              //new java.sql.Date( b.getEnddate().getTime())  ,
               
                b.getStartDate() != null ? b.getStartDate() : Calendar.getInstance().getTime() ,
                b.getEnddate()  != null ? b.getEnddate() : Calendar.getInstance().getTime() ,
            
            
            
                b.getUserId(),
                b.getDeptId(),
                b.getLookupId(),
                b.getLookupFlag(),
                b.getSubjectText() == null ? "": b.getSubjectText(),
                b.getSubjectBody() == null ? "": b.getSubjectBody(),
                 new java.sql.Date(Calendar.getInstance().getTime().getTime())  ,
                b.getCalId() == 0 ? null :b.getCalId()
                  
            };
       
       
       
    }
    /// ============================================================
    
}
