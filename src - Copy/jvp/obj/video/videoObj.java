/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jvp.obj.video;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import obj.db.v1.dbMgrInterface;
import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class videoObj {
    videoSql videoSql;
    public  final Logger logger = (Logger) Logger.getLogger(videoObj.class);
    public videoObj(){
        videoSql = new videoSql();
    }
     public int grab(String value,dbMgrInterface db){
         CachedRowSet r = null;
         int i = -1;
        try {
            r = db.getCachedRowSet(videoSql.sqlGrabNew, new Object[]{value});
            while(r.next()){
                i = r.getInt(1);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(r);
        }
        return i;
    }
    public int update(videoBean bean,dbMgrInterface db){
        try {
            if (bean.getVideoId() == 0){
                String str = null;
                if (bean.getImageName() == null){
                    str = "[joz]"+(new SimpleDateFormat("dd_MM_yyyy_HH:mm:ss:SSS")).format(Calendar.getInstance().getTime());
                    bean.setImageName(str);
                }
                db.updateDatabase(videoSql.sqlInsertv2, getVideoObj(bean));
                if (str != null)  return grab(str,db);
                return 0;
            } else {
                db.updateDatabase(videoSql.sqlUpdate, getVideoObj(bean));
                return bean.getVideoId();
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } 
        return -1;
    }
    public String getPath(dbMgrInterface db){
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(videoSql.sqlPath, new Object[]{});
            while(r.next()){
                return r.getString(1);
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(r);
        }
        return "";
    }
    public void chConnect(dbMgrInterface db){
         CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(videoSql.sqlTest, new Object[]{});
            while(r.next()){
                
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(r);
        }
    }
     public videoBean getvideoBean(int id,dbMgrInterface db){
       List<videoBean> l=  getVideoBeanList(videoSql.sqlSelectVideoBean,new Object[]{id},db);
       if (l.size() >0) return l.get(0);
       return null;
    }
     
    public  List<videoBean> getVideoBeanListRanked(String rank,dbMgrInterface db){
        return getVideoBeanList(videoSql.sqlSelectVideoFilter,new Object[]{rank},db);
    }
      
    public  List<videoBean> getVideoBeanList(String type,dbMgrInterface db){
        return getVideoBeanList(videoSql.getSqlSelectVideo(type),new Object[]{},db);
    }
     
    public  List<videoBean> getVideoBeanList(int type,dbMgrInterface db){
        return getVideoBeanList(videoSql.sqlSelectVideoByType,new Object[]{type},db);
    }
     public  List<videoBean> getVideoBeanListHm(dbMgrInterface db){
        return getVideoBeanList(videoSql.sqlSelectVideoBeanHm,new Object[]{1},db);
    }
     public  List<videoBean> getVideoBeanListHmMGN(dbMgrInterface db){
        return getVideoBeanList(videoSql.sqlSelectVideoBeanHm_MGN,new Object[]{1},db);
    }
    private  List<videoBean> getVideoBeanList(String sql,Object[] obj,dbMgrInterface db){
        List<videoBean> l = new ArrayList<videoBean>();
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(sql, obj);
            while(r.next()){
                l.add(getVideoBean(r));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(r);
        }
        return l;
    }
   
    private  videoBean getVideoBean(CachedRowSet r){
        videoBean b = new videoBean();
        try {
            
            b.setVideoId(r.getInt(1));//video_id integer    NOT NULL   PRIMARY KEY AUTO_INCREMENT,
            b.setVideoType(r.getInt(2));	//video_type  integer,
            b.setVideoDesc(r.getString(3));//video_desc  VARCHAR(256),
            b.setVideoValue(r.getString(4));//video_value  VARCHAR(60),
            b.setVideoWidth(r.getInt(5));//        video_width
            b.setVideoHeight(r.getInt(6));//                    video_height integer,
               //b.setVideoPlayer(r.getString(7));//video_player
            b.setLookupId(r.getInt(8));
            b.setSysId(r.getInt(9));
            b.setLookupFlag(r.getInt(10));
            b.setSubjectText(r.getString(11));
            b.setSubjectBody((String)r.getObject(12));
            b.setDispyVideoType(r.getString(13));
            b.setRootURL(r.getString(14));
            b.setVideoPlayer(r.getString(15));
           
            b.setImageName(r.getString(16));
            b.setRank(r.getDouble(17));
            b.setImageXhtml(r.getString(18));
            b.setLookupDesc(r.getString(19));
            if (b.getImageName().contains("[joz]")) b.setImageName(null);
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }
        return b;
    }
    public Object[] getVideoObj(videoBean b){
          Object[] obj = new Object[]{
            //video_id integer    NOT NULL   PRIMARY KEY AUTO_INCREMENT,
            b.getVideoType(),	//video_type  integer,
            b.getVideoDesc(),//video_desc  VARCHAR(256),
            b.getVideoValue(),//video_value  VARCHAR(60),
            b.getVideoWidth(),//        video_width
            b.getVideoHeight(),//                    video_height integer,
            b.getVideoPlayer(),//video_player
            b.getLookupId(),
            b.getSysId(),
            b.getLookupFlag(),
            b.getSubjectText() == null ? "":b.getSubjectText(),
            b.getSubjectBody() == null ? "":b.getSubjectBody(),
           
            b.getImageName() == null ? "[joz]" :b.getImageName(),
            b.getRank(),
            b.getImageXhtml() == null ? "" :b.getImageXhtml(),
            b.getVideoId() == 0 ? null: b.getVideoId()
            };
    return obj;
    }
}
