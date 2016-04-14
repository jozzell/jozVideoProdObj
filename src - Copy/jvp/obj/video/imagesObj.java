/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvp.obj.video;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import obj.db.v1.dbMgrInterface;
import org.apache.log4j.Logger;
//import org.apache.log4j.Logger;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class imagesObj {
    imagesSql imagesSql;
    public  final Logger logger = (Logger) Logger.getLogger(imagesObj.class);
    public imagesObj(){
        imagesSql = new imagesSql();
    }
    public List<imagesBean> getImageList(int id,dbMgrInterface db){
        return getList(imagesSql.sqlImageId,new Object[]{id},db);
    }
    private List<imagesBean> getList(String sql,Object[] obj,dbMgrInterface db){
        List<imagesBean> l = new ArrayList<imagesBean>();
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(sql,obj);
            while(r.next()){
                l.add(getImageBean(r));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
           db.closeCachedRowSet(r);
        }
        return l;
        
    }
    private imagesBean getImageBean(CachedRowSet r){
        imagesBean b = new imagesBean();
        try {
            b.setImageDisplayId(r.getInt(1));
            b.setImageId(r.getInt(2));
            b.setLookupId(r.getInt(3));
            b.setImagePath(r.getString(4));
            b.setImageText((String)r.getObject(5));
            b.setImageDesc(r.getString(6));
            b.setOrderId(r.getInt(7));
            b.setUserId(r.getInt(8));
            b.setImageTextRoot((String)r.getObject(9));
            b.setImageDescRoot(r.getString(10));
            //b.setSubjectBody((String)r.getObject(7));
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(imagesObj.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return b;
    }
}
