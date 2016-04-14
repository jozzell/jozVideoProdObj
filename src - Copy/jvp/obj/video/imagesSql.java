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
public class imagesSql  implements Serializable{
    final private String 
            sql = 
            " select d.image_display_id,d.image_id,d.lookup_id, "+
	            " d.image_path,d.image_text,d.image_desc ,d.OrderId, "+
	            " i.user_id,i.image_desc,i.image_text "+
	            " from jvp_image_display d, jvp_image i "+
	            " where i.image_id = d.image_id ";
    public final String
            sqlImageId = sql+" and i.image_id=? order by d.OrderId,d.image_display_id",
            sqlCustIdAndImageId = sql+" and i.image_id=? and i.user_id = ? order by d.OrderId,d.image_display_id ";
}
