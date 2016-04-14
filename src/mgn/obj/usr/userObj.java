/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.usr;

import jvp.obj.bean.userBean;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import obj.db.v1.dbMgrInterface;
import sun.jdbc.rowset.CachedRowSet;

/**
 *
 * @author lmeans
 */
public class userObj implements  Serializable{
    userSql userSql;
    
   public  final org.apache.log4j.Logger logger = (org.apache.log4j.Logger) org.apache.log4j.Logger.getLogger(userObj.class);
    public userObj(){
        userSql = new userSql();
    }
    public void trackUser(String id,dbMgrInterface db){
        try {
            db.updateDatabase(userSql.mgn_access, new Object[]{id,Calendar.getInstance().getTime()});
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
    public  void updatePassword(int id,String password,dbMgrInterface db){
        try {
            db.updateDatabase(userSql.updatePassword, new Object[]{password.toLowerCase(),id});
        } catch (Exception ex) {
            logger.error(ex.toString());
        }
    }
    public  userBean login(String user,String pass,dbMgrInterface db){
        if (user == null || 
                user.trim().length() == 0 ||
                pass == null || 
                pass.trim().length() == 0){
            return null;
        }
        userBean b = null;
        CachedRowSet rs = null;
        try {
            rs = db.getCachedRowSet(userSql.select_login, new Object[]{user.toLowerCase().trim(),pass.toLowerCase().trim()});
            while(rs.next()){
              b =    getSoulCustomerBean(rs);
            }
        } catch (Exception ex) {
             logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(rs);
        }
        return b;
       
    }
    public  List<userBean> select(dbMgrInterface db){
        List<userBean> list = new ArrayList<userBean>();
        CachedRowSet rs = null;
        try {
            rs = db.getCachedRowSet(userSql.select, new Object[]{});
            while(rs.next()){
                list.add(getSoulCustomerBean(rs));
            }
        } catch (Exception ex) {
             logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(rs);
        }
        
        return list;
    }
    public  userBean select(String email,dbMgrInterface db){
         if (email == null || 
                email.trim().length() == 0 ){
            return null;
        }
        userBean b = null;
        CachedRowSet rs = null;
        try {
            
            rs = db.getCachedRowSet(userSql.select_eMail, new Object[]{email.toLowerCase()});
            while(rs.next()){
                b = getSoulCustomerBean(rs);
            }
        } catch (Exception ex) {
             logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(rs);
        }
        return b;
    }
    
    
    //select_byDept
    public  List<userBean> selectALL(dbMgrInterface db){
        return select(userSql.select_byALL,new Object[]{},db);
    }
    private  List<userBean> select(String sql, Object[] obj,dbMgrInterface db){
        List<userBean> list = new ArrayList<userBean>();
        CachedRowSet rs = null;
        try {
            
            rs = db.getCachedRowSet(sql, obj);
            while(rs.next()){
                list.add(getSoulCustomerBean(rs));
            }
        } catch (Exception ex) {
             logger.error(ex.toString());
        } finally {
            db.closeCachedRowSet(rs);
        }
        return list;
    }
    
    public  void update(userBean b, dbMgrInterface db) {
        try {
            if (b.getCustId() == 0) {
               
                db.updateDatabase(userSql.insert, getsoulCustomerBean(b));
                userBean x = select(b.getEMail(),db);
                b.setCustId(x.getCustId());
            } else {
                db.updateDatabase(userSql.update, getsoulCustomerBean(b));
            }
        } catch (Exception ex) {
             logger.error(ex.toString());
        }
    }

    public  Object[] getsoulCustomerBean(userBean b) {
        if (b.getCustId() >  0){
            return new Object[]{
            b.getFirstName() == null ? "" : b.getFirstName(),
            b.getLastName() == null ? "" : b.getLastName(),
            b.getAddr1() == null ? "" : b.getAddr1(),
            b.getAddr2() == null ? "" : b.getAddr2(),
            b.getCity() == null ? "" : b.getCity(),
            b.getState() == null ? "" : b.getState(),
            b.getHmPhone() == null ? "" : b.getHmPhone(),
            b.getWkPhone() == null ? "" : b.getWkPhone(),
            b.getWkExt() == null ? "" : b.getWkExt(),
            b.getZip() == null ? "" : b.getZip(),
            b.getSubjectText() == null ? "" : b.getSubjectText(),
            b.getSubjectTody() == null ? "" : b.getSubjectTody(),
            b.getAccessLvl(),
            b.getCustId()};
        } else {
        return new Object[]{
            b.getFirstName() == null ? "" : b.getFirstName(),
            b.getLastName() == null ? "" : b.getLastName(),
            b.getAddr1() == null ? "" : b.getAddr1(),
            b.getAddr2() == null ? "" : b.getAddr2(),
            b.getCity() == null ? "" : b.getCity(),
            b.getState() == null ? "" : b.getState(),
            b.getHmPhone() == null ? "" : b.getHmPhone(),
            b.getWkPhone() == null ? "" : b.getWkPhone(),
            b.getWkExt() == null ? "" : b.getWkExt(),
            b.getZip() == null ? "" : b.getZip(),
            b.getEMail() == null ? "" : b.getEMail().toLowerCase().trim(),
            b.getUserPass() == null ? "" : b.getUserPass().toLowerCase().trim(),
            b.getSubjectText() == null ? "" : b.getSubjectText(),
            b.getSubjectTody() == null ? "" : b.getSubjectTody(),
            b.getAccessLvl()
        };
        }
    }

   
    private  userBean getSoulCustomerBean(CachedRowSet r) {
       userBean b = null;
        try {
            b = new userBean();
            b.setCustId(r.getInt(1));
            b.setFirstName(r.getString(2));
            b.setLastName(r.getString(3));
            b.setAddr1(r.getString(4));
            b.setAddr2(r.getString(5));
            b.setCity(r.getString(6));
            b.setState(r.getString(7));
            b.setHmPhone(r.getString(8));
            b.setWkPhone(r.getString(9));
            b.setWkExt(r.getString(10));
            b.setZip(r.getString(11));
            
            b.setEMail(r.getString(12));
            b.setEMailChk(r.getString(12));
            
            b.setUserPass(r.getString(13));
            b.setUserPassChk(r.getString(13));
            
            b.setSubjectText(r.getString(14));
            b.setSubjectTody((String)r.getObject(15));
            b.setAccessLvl(r.getInt(16));
            b.setAccessLvlDesc(r.getString(17));
        } catch (SQLException ex) {
            logger.error(ex.toString());
        }
        return b;
    }
    
}
