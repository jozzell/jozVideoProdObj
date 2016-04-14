/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jvp.obj.video;

import java.io.Serializable;

/**
 *
 * @author lmeans
 */
public class jvpLookupSql  implements Serializable {
     final  String sqlCont = 
            " SELECT l.lookup_id,l.lookup_rollup_id,l.lookup_type,l.lookup_desc, "+
            " l.lookup_flag,l.subject_text,  l.subject_body,l.sys_id, "+
            " (select count(*) from jvp_video where  video_type = l.lookup_type) "+
             " FROM jvp_lookup l,jvp_lookup_sys s where l.sys_id =  s.sys_id"
           ;
    public  final String
       sqlSelectSysId = sqlCont+" and s.sys_id = ?",
       sqlLookupIns = "insert into jvp_lookup (lookup_rollup_id,lookup_type,lookup_desc,lookup_flag,subject_text,subject_body,searchKey )"+
            " values (?,?,?,?,?,?,?)",
       sqlLookupkey = "select max(lookup_id) from jvp_lookup where searchKey = ?",
       sqlLookupByType = sqlCont + "where l.lookup_type = ?  order by l.lookup_desc";
}
