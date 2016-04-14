/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mgn.obj.usr;

import java.io.Serializable;

/**
 *
 * @author lmeans
 */
public class userSql implements Serializable{
    private  final String xyx_0012 = "";
     private  final String
             sqlTTT= "",
             
            sqlV2 =
           " select c.user_id,c.FIRST_NAME,c.LAST_NAME,c.ADDR1,c.ADDR2,c.CITY,c.STATE,c.HM_PHONE,c.WK_PHONE,c.WK_EXT, "+
           " c.ZIP,c.EMAIL,c.user_pass,c.subject_text,c.subject_body,c.access_lvl,  s.sys_desc " +
            "      from mgn_user c ,mgn_lookup_sys s where  c.access_lvl = s.lookup_flag and s.sys_type = 1 "
        
            ;
    public  final String
            sqlttt= "",
            mgn_access = "insert into mgn_access (mgn_id,mgn_ts) values (?,?)",
            select = sqlV2+" order by c.LAST_NAME,c.FIRST_NAME",
            select_byALL    = sqlV2+" order by c.LAST_NAME,c.FIRST_NAME",
            select_byDeptNEW = sqlV2+" and c.user_id not in (select x.user_id from mgn_user_dept x where c.user_id = x.user_id and dept_id = ?)",
            select_eMail = sqlV2+" and c.EMAIL = ?",
            select_login = sqlV2+" and  c.EMAIL = ? and c.user_pass = ?",
            select_custID = sqlV2+" and c.user_id = ?",
            
            insert = "INSERT INTO mgn_user ( "+
                "FIRST_NAME,LAST_NAME,ADDR1,ADDR2,CITY,STATE,HM_PHONE,WK_PHONE,WK_EXT, "+
                " ZIP,EMAIL,user_pass,subject_text,subject_body,access_lvl) "+
                " VALUES  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ",            
             updatePassword = 
                " UPDATE mgn_user SET user_pass = ? WHERE user_id= ? ",
            update = 
            " UPDATE mgn_user SET FIRST_NAME = ?,LAST_NAME = ?,ADDR1 = ?,ADDR2 = ?, "+
            " CITY = ?,STATE = ?,HM_PHONE = ?,WK_PHONE = ?,WK_EXT =?,ZIP = ?, "+
            " subject_text = ?,subject_body = ?,access_lvl = ? WHERE user_id= ? ";


}
