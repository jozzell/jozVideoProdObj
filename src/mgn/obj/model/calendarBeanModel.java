/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.model;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import jvp.obj.bean.calendarBean;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author lmeans
 */
public class calendarBeanModel extends ListDataModel<calendarBean> implements SelectableDataModel<calendarBean>, Serializable {
    //private boolean reset = true;
  public static final String modelName = "calendar-Bean-Model";

    public calendarBeanModel() {
        super();
        //reset = true;
    }

    public calendarBeanModel(List<calendarBean> list) {
        super(list);
        //reset = false;

    }

    @Override
    public Object getRowKey(calendarBean t) {
        return t.getCalId();
    }

    @Override
    public calendarBean getRowData(String string) {
        long id = Long.parseLong(string);
        List<calendarBean> list = (List<calendarBean>) getWrappedData();
        if (list != null) {
            for (calendarBean list1 : list) {
                if (list1.getCalId() == id) {
                    //(new factoryObj()).setAccessBeanFromFacesContext(modelName, FacesContext.getCurrentInstance(), list1);
                    return list1;
                }
            }
        }
        return null;
    }


}
