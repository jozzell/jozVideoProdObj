/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cal;

import java.io.Serializable;

/**
 *
 * @author lmeans
 */
public class attachSql  implements Serializable{
    private final String
     sql = " SELECT a.attach_id,  a.schedule_id,   a.attach_desc,    a.attach_path, "+
        " a.attach_body,    a.attach_text,    a.attach_type,    a.attach_category, a.flag_ind"+
        " FROM mgn_schedule_attach a" ;
    public final String
       sqlSelectSchedule = sql+" where  a.schedule_id = ?",
       sqlUpdate = 
            " UPDATE jlroomsc_mgn.mgn_schedule_attach "+
            " SET schedule_id = ?,attach_desc =?,attach_path = ?,attach_body = ?, "+
            " attach_text = ?,attach_type = ?,attach_category = ?,flag_ind = ? "+
            " WHERE attach_id = ?",
       sqlInsert = "INSERT INTO mgn_schedule_attach "+
                " (schedule_id,attach_desc,attach_path,attach_body,attach_text,attach_type,attach_category,flag_ind) "+
                " VALUES (?,?,?,?,?,?,?,?)   ";
}
