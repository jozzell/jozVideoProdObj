/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cal;

import java.io.File;
import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import jvp.obj.bean.scheduleAttachBean;
import jvp.obj.video.imageDisplayMaintBean;
import obj.db.v1.dbMgrInterface;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class attachObj extends attachSql  implements Serializable{
    public  final org.apache.log4j.Logger logger = (org.apache.log4j.Logger) org.apache.log4j.Logger.getLogger(attachObj.class);
    
    public imageDisplayMaintBean getImageDisplayMaintBean(String sessionID,dbMgrInterface db){
        imageDisplayMaintBean b = new imageDisplayMaintBean();
        String root = getPath(db);
        String path  = (new StringBuilder())
                .append("/upload")
                .append(new SimpleDateFormat("/yyyy/MM/dd").format(Calendar.getInstance().getTime()))
                .append("/")
               
                .append(sessionID)
                .append("/")
                //.append((new reusableObj()).paddingString(""+(getCntr()), 5, '0', true))
                //.append("_")
                .toString();
        new File(root +path).mkdirs();
        
        b.setRoot(root);
        b.setPath(path);
        return b;
    }
    private String getPath(dbMgrInterface db){
        List<scheduleAttachBean> l = getList(this.sqlSelectSchedule,new Object[]{-1},db);
        if(l != null && l.size() > 0 ){
            return l.get(0).getPath();
        }
        return null;
    }
    public List<scheduleAttachBean> getListSchedule(int id,dbMgrInterface db){
        return getList(this.sqlSelectSchedule,new Object[]{id},db);
    }
    public void updateSchedulerAttach(scheduleAttachBean b,dbMgrInterface db){
        try {
            db.updateDatabase( 
                    b.getId() == 0 ? this.sqlInsert : this.sqlUpdate,
                    getObject(b));
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
    // --------------------------------------------------------------------------------------------
    private Object[] getObject(scheduleAttachBean b){
        return new Object[]{
            b.getScheduleId(),
            getStr(b.getDesc()),
            getStr(b.getPath()),
            getStr(b.getBody()),
            getStr(b.getText()),
            b.getType(),
            b.getCategory(),
            b.getFlagId(),
            b.getId() == 0 ? null : b.getId()
        };
    }
    
    private  List<scheduleAttachBean> getList(String sql,Object[] obj, dbMgrInterface db){
       List<scheduleAttachBean> l = new ArrayList<scheduleAttachBean>();
       CachedRowSet rs = null;
         try {
            rs = db.getCachedRowSet(sql, obj);
            while(rs.next()){
                l.add(getScheduleAttachBean(rs));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(rs);
        }
        return l; 
    }
   
    private scheduleAttachBean getScheduleAttachBean(CachedRowSet rs) throws SQLException{
        scheduleAttachBean b = new scheduleAttachBean();
        b.setId(rs.getInt(1));
        b.setScheduleId(rs.getInt(2));
        b.setDesc(rs.getString(3));
        b.setPath(rs.getString(4));
       
        b.setBody((String)rs.getObject(5));
        b.setText((String)rs.getObject(6));
        b.setType(rs.getInt(7));
        b.setCategory(rs.getInt(8));
        b.setFlagId(rs.getInt(9));
        return b;
        
    }
    private String getStr(String str){
        if (str == null) return "";
        return str;
    }
}
