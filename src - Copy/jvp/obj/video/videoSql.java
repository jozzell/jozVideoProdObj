/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jvp.obj.video;

/**
 *
 * @author lmeans
 */
public class videoSql {
    private  final String 
            sql67 = "Demo",
            sqlV2 =
    " SELECT  v.video_id,v.video_type,v.video_desc,v.video_value,v.video_width, "+
    " v.video_height,v.video_player,v.lookup_id,v.sys_id,v.lookup_flag,v.subject_text, "+
    " v.subject_body,l.sys_desc,l.subject_text,l.txt_col_01,v.image_name,v.video_ranking,v.image_xhtml ,x.lookup_desc "+
    " FROM jvp_video v, jvp_lookup_sys l  ,jvp_lookup x "+
    " where l.sys_id = v.sys_id and x.lookup_type= v.video_type ";
    public String getSqlSelectVideo(String in){
        return sqlV2+" and  v.video_type in ("+in+") order by  v.video_id desc ";
    }
    public  final String
            sql24 = "",
            sqlInsertv2 = " insert into  jvp_video  ("
            + " video_type,video_desc,video_value,video_width, "+
                    " video_height,video_player,lookup_id,sys_id,lookup_flag,subject_text, "+
                    " subject_body,image_name,video_ranking, image_xhtml )  "+
                    " values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
            sqlUpdate =  " update  jvp_video  set "
            + " video_type=?,video_desc=?,video_value=?,video_width=?, "+
                    " video_height=?,video_player=?,lookup_id=?,sys_id=?,lookup_flag=?,subject_text=?, "+
                    " subject_body=?,image_name=?,video_ranking=?,image_xhtml=?  "+
                    " where video_id = ?",
            sqlVideoUpadte = "update jvp_video set image_name = ? , video_ranking = ? where video_id = ?",
            sqlPath ="SELECT subject_text FROM jvp_lookup_sys  where  sys_id = -99",
            sqlTest = "select max(sys_id) from jvp_lookup_sys where sys_id = -11",
            sqlSelectVideoByType = sqlV2+" and v.video_type = ? order by v.lookup_flag desc,v.video_desc",
            sqlSelectVideoBean = sqlV2+" and v.video_id = ? order by v.lookup_flag desc,v.video_id desc",
            sqlSelectVideoBeanHm_MGN = sqlV2+" and v.home_pg_mgn = ? order by  v.lookup_flag desc,v.video_id desc",
            sqlSelectVideoBeanHm = sqlV2+" and v.home_pg = ? order by  v.lookup_flag desc,v.video_id desc",
            sqlGrabNew = "select max(video_id) from  jvp_video where image_name = ?",
             sqlSelectVideoFilter = sqlV2+" and v.video_id in (select video_id from jvp_video_app where appGrp_id = ?)"
            ;
}
