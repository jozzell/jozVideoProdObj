/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.model;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import jvp.obj.bean.scheduleBeanDisp;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author lmeans
 */
public class scheduleBeanDispModel extends ListDataModel<scheduleBeanDisp> implements SelectableDataModel<scheduleBeanDisp>, Serializable {
    public scheduleBeanDispModel() {
        super();
        //reset = true;
    }

    public scheduleBeanDispModel(List<scheduleBeanDisp> list) {
        super(list);
        //reset = false;

    }

    @Override
    public Object getRowKey(scheduleBeanDisp t) {
        return t.getScheduleId();
    }

    @Override
    public scheduleBeanDisp getRowData(String string) {
        long id = Long.parseLong(string);
        List<scheduleBeanDisp> list = (List<scheduleBeanDisp>) getWrappedData();
        if (list != null) {
            for (scheduleBeanDisp list1 : list) {
                if (list1.getScheduleId() == id) {
                    //(new factoryObj()).setAccessBeanFromFacesContext(modelName, FacesContext.getCurrentInstance(), list1);
                    return list1;
                }
            }
        }
        return null;
    }
}
