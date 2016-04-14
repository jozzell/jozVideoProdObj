/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jvp.obj.video;

import java.io.Serializable;
import java.sql.SQLException;
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
public class jvpLookupObj implements Serializable{
    public  final Logger logger = (Logger) Logger.getLogger(jvpLookupObj.class);
    jvpLookupSql jvpLookupSql;
    public jvpLookupObj(){
        jvpLookupSql = new jvpLookupSql();
    }
    public int insertRec(int user,jvpLookupBean bean,dbMgrInterface db){
        int id = -1;
        CachedRowSet r = null;
        bean.setSearchKey(user+"_"+Calendar.getInstance().getTimeInMillis());
        try {
            db.updateDatabase(jvpLookupSql.sqlLookupIns, getObj(bean));
            r = db.getCachedRowSet(jvpLookupSql.sqlLookupkey,new Object[]{bean.getSearchKey()});
            
            while(r.next()){
                id = r.getInt(1);
            }
            
        } catch (Exception ex) {
            logger.error(ex.getMessage());
        }finally {
            db.closeCachedRowSet(r);
        }
        return id;
    }
    public Object[] getObj(jvpLookupBean b){
        return new Object[]{
            //,,,,,,,searchKey
           b.getLookupRollupId(),
           b.getLookupType(),
           b.getLookupDesc(),
           b.getLookupFlag(),
           b.getSubjectText() == null ? "" :b.getSubjectText(),
           b.getSubjectBody() == null ? "" :b.getSubjectBody(),
           b.getSearchKey()
        };
    }

    public  List<jvpLookupBean> getLookupListBySysId(int sysid,dbMgrInterface db){
        return getLookupList(jvpLookupSql.sqlSelectSysId,new Object[]{sysid},db);
    }
    private  List<jvpLookupBean> getLookupList(String sql,Object[] obj,dbMgrInterface db){
        List<jvpLookupBean> list = new ArrayList<jvpLookupBean>();
        CachedRowSet r = null;
        try {
            r = db.getCachedRowSet(sql,obj);
            while(r.next()){
                list.add(getlookupBean(r));
            }
        } catch (Exception ex) {
            logger.error(ex.toString());
        } finally {
           db.closeCachedRowSet(r);
        }
        return list;
    }
    public  jvpLookupBean getlookupBean(CachedRowSet r){
        jvpLookupBean b = new jvpLookupBean();
        try {
            b.setLookupId(r.getInt(1));
            b.setLookupRollupId(r.getInt(2));
            b.setLookupType(r.getInt(3));
            b.setLookupDesc(r.getString(4));
            b.setLookupFlag(r.getInt(5));
            b.setSubjectText(r.getString(6));
            b.setSubjectBody((String)r.getObject(7));
            b.setSysId(r.getInt(8));
            b.setCnt(r.getInt(9));
        } catch (SQLException ex) {
           logger.error(ex.toString());
        }
        
        return b;
    }
}
