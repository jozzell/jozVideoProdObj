/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.model;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import jvp.obj.bean.scheduleBean;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author lmeans
 */
public class scheduleBeanModel extends ListDataModel<scheduleBean> implements SelectableDataModel<scheduleBean>, Serializable {
    public scheduleBeanModel() {
        super();
        //reset = true;
    }

    public scheduleBeanModel(List<scheduleBean> list) {
        super(list);
        //reset = false;

    }

    @Override
    public Object getRowKey(scheduleBean t) {
        return t.getScheduleId();
    }

    @Override
    public scheduleBean getRowData(String string) {
        long id = Long.parseLong(string);
        List<scheduleBean> list = (List<scheduleBean>) getWrappedData();
        if (list != null) {
            for (scheduleBean list1 : list) {
                if (list1.getScheduleId() == id) {
                    //(new factoryObj()).setAccessBeanFromFacesContext(modelName, FacesContext.getCurrentInstance(), list1);
                    return list1;
                }
            }
        }
        return null;
    }
}
