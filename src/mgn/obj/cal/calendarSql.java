/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.cal;

import java.io.Serializable;

/**
 *
 * @author lmeans
 */
public class calendarSql implements Serializable{
    private  final String xxx9987="skjdfksd",
            
            sqlRoot = 
            " select c.cal_id,c.cal_rollup_id,c.cal_desc,c.cal_type,c.startDate,c.enddate,c.user_id, "+
            " c.dept_id, c.lookup_id,c.lookup_flag,c.subject_text,c.subject_body,c.moddate, ",
            sqlSelect =sqlRoot+
           
            " u.first_name,u.last_name,s.sys_desc "+
            " from mgn_calendar c  "+
	            " left join mgn_user u on c.user_id = u.user_id "+
	            " left join mgn_lookup_sys s on c.dept_id = s.sys_id",
            sqlSelectCalendar = sqlRoot+
            " '','',''"+
            " from mgn_calendar c  ",
	           
            sqlSelectScheduleSqlV2 =
            "select s.schedule_id,s.sys_id,s.cust_id,s.hrs, s.min, s.dur, s.dow,s.dow_ind, s.lookup_id, s.subject_text,"+
            " s.subject_body,s.path,s.vendor_id,s.start_date,s.end_date, "+
            " (SELECT count(*) FROM mgn_schedule_attach x where x.schedule_id = s.schedule_id)"+
            " from  mgn_schedule s";
            //" select c.cal_id,c.cal_rollup_id,c.cal_desc,c.cal_type,c.startDate,c.enddate,c.user_id, "+
            //" c.dept_id, c.lookup_id,c.lookup_flag,c.subject_text,c.subject_body,moddate "+
            //" from mgn_calendar c";
    
    public  String getCalSelectBydate(String dept){
        return sqlSelect+" where c.startDate >= ? and c.startDate <= ? and c.cal_type = ? "; //and c.dept_id in ("+dept+")";
    }
    public  String getCalSelectBydateNext(String dept){
        return sqlSelect+" where c.startDate > ? and c.cal_type = ? and c.moddate >= ? and c.moddate <= ? and c.dept_id in ("+dept+")";
    }
    public  String getCalSelecCalId(){
        return sqlSelectCalendar+" where c.cal_id = ?";
    }
    
    public  String getCalSelectByType(){
        return sqlSelectCalendar+" where c.cal_type = ? and c.lookup_flag = ? order by c.startDate desc,c.cal_id desc";
    }
    public  String getCalSelectByTypeAll(){
        return sqlSelectCalendar+" where c.cal_type = ? order by c.cal_id desc";
    }
    
    public  String sqlGetSelectPostingList(int cnt){
            return sqlSelect+
          "  where  c.cal_type = ? and  "+
          " c.enddate >= DATE_FORMAT(now() ,'%Y-%m-%d') AND "+
          " c.startdate < DATE_FORMAT(DATE_ADD(now() ,interval "+cnt+" day),'%Y-%m-%d') "+
          " order by 13 desc";
    }
    public  String sqlGetSelectPostingListToday(int cnt){
            return sqlSelect+
          "  where  c.cal_type = ? and  "+
          " c.enddate >= DATE_FORMAT(now() ,'%Y-%m-%d') AND "+
          " c.startdate < DATE_FORMAT(DATE_ADD(now() ,interval "+cnt+" day),'%Y-%m-%d') "+
          " union "+sqlSelect+" where  c.cal_type = 0  and "+
                    " c.startDate >= DATE_FORMAT(now() ,'%Y-%m-%d') and "+
                    " c.startDate < DATE_FORMAT(DATE_ADD(now() ,interval 1 day),'%Y-%m-%d')"+
          " order by 13 desc" ;
    }
    public  String sqlGetSelectPostingListTodayNonGrpUsr(int cnt){
            return sqlSelectCalendar+
          "  where  c.cal_type = ? and  c.cal_id > 0 and"+
          " c.enddate >= DATE_FORMAT(now() ,'%Y-%m-%d') AND "+
          " c.startdate < DATE_FORMAT(DATE_ADD(now() ,interval "+cnt+" day),'%Y-%m-%d') "+
          " union "+sqlSelectCalendar+" where  c.cal_type = 0  and  c.cal_id > 0 and "+
                    " c.startDate >= DATE_FORMAT(now() ,'%Y-%m-%d') and "+
                    " c.startDate < DATE_FORMAT(DATE_ADD(now() ,interval 1 day),'%Y-%m-%d')"+
          " order by 13 desc" ;
    }
    public  final String
     sqlInsertScheduler = " INSERT INTO mgn_schedule (sys_id,cust_id,hrs,min,dur,dow,dow_ind,lookup_id,subject_text,subject_body,path,vendor_id,start_date,end_date) "+
        " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?) ",
     sqlUpldateSchudler = "UPDATE mgn_schedule SET sys_id = ?, cust_id = ?,hrs = ?,min = ?,dur = ?,"+
        " dow = ?,dow_ind = ?,lookup_id = ?,subject_text = ?,subject_body = ?,path = ?"+
        ",vendor_id=?,start_date=?,end_date=?"+
        " WHERE schedule_id = ? ",
     sqlSelectSchedule_SysId = sqlSelectScheduleSqlV2+" where s.sys_id = ?",
     sqlSelectSchedule_CustId = sqlSelectScheduleSqlV2+" where s.cust_id = ?",
     sqlSelectPostCnt =
            " select count(*), DATE_FORMAT(c.moddate ,'%Y-%m-%d'),c.cal_type "+
            " from mgn_calendar c  "+
            " where c.moddate >= ? and c.moddate <= ? and c.cal_type = ? "+
            " group by DATE_FORMAT(c.moddate ,'%Y-%m-%d'),c.cal_type ",
                    
    selectSqlStartDateAndType = 
            sqlSelect+" where c.startDate >= ? and c.startDate <= ? and c.cal_type = ?",
    selectSqlEndDateAndType = 
            sqlSelect+" where c.enddate >= ? and c.enddate < ? and c.cal_type = ?",
   selectSqlModDateAndType = 
            sqlSelect+" where c.moddate >= ? and c.moddate < ? and c.cal_type = ?",
    calSelectById = 
        sqlSelect+" where c.cal_id= ?",
        calInsert =
           " INSERT INTO mgn_calendar "+
            " (cal_rollup_id,cal_desc,cal_type,startDate,enddate,user_id, "+
            " dept_id,lookup_id,lookup_flag,subject_text,subject_body,moddate) VALUES "+
            " (?,?,?,?,?,?,?,?,?,?,?,?)",
        calUpdate_v2 =
           " UPDATE mgn_calendar  SET "+
            " cal_rollup_id = ?,cal_desc = ?,cal_type = ?, startDate = ?, "+
            " enddate = ?, user_id = ?,dept_id = ?,lookup_id = ?,lookup_flag = ?, "+
            " subject_text = ?,subject_body = ? , moddate = ? WHERE cal_id = ? ",
            // ================================================================
            
            
            
            
            
        sqlCalSelect = 
    " select Cal_ID ,dept_id,CUST_ID ,	StartDate , enddate , 	short_desc, "+
	" contactName ,	Long_desc ,ADDR1 , ADDR2 ,  CITY , "+
        " STATE ,  ZIP ,  ZIP_PLUS , PHONE , FAX , "+
        " EMAIL ,	website ,access_lvl,access_dept  from  mgnCalendar "
            ;
    public final String
      sqlCalInsert = 
          "  insert into  mgnCalendar (dept_id,CUST_ID ,	StartDate , enddate , 	short_desc, "+
	" contactName ,	Long_desc ,ADDR1 , ADDR2 ,  CITY ,STATE ,  ZIP ,  ZIP_PLUS , PHONE , FAX , "+
        " EMAIL ,website ,access_lvl,access_dept )" +
            "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
       sqlCalUpadte =
            " update mgnCalendar set "+
           " dept_id = ?,CUST_ID  = ?,	StartDate  = ?, enddate = ? , 	short_desc = ?, "+    
	" contactName  = ?,	Long_desc  = ?,ADDR1  = ?, ADDR2  = ?,  CITY  = ?,STATE  = ?,"+
         " ZIP  = ?,  ZIP_PLUS  = ?, PHONE  = ?, FAX  = ?, "+
        " EMAIL = ? ,website  = ?,access_lvl = ?,access_dept  = ? where Cal_ID = ?"
            ;
}
