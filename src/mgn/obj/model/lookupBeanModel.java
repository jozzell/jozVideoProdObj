package mgn.obj.model;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import jvp.obj.bean.lookupBean;
import org.primefaces.model.SelectableDataModel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmeans
 */
public class lookupBeanModel extends ListDataModel<lookupBean> implements SelectableDataModel<lookupBean>, Serializable {
    public lookupBeanModel() {
        super();
        //reset = true;
    }

    public lookupBeanModel(List<lookupBean> list) {
        super(list);
        //reset = false;

    }

    @Override
    public Object getRowKey(lookupBean t) {
        return t.getVal();
    }

    @Override
    public lookupBean getRowData(String string) {
        long id = Long.parseLong(string);
        List<lookupBean> list = (List<lookupBean>) getWrappedData();
        if (list != null) {
            for (lookupBean list1 : list) {
                if (list1.getVal()== id) {
                    //(new factoryObj()).setAccessBeanFromFacesContext(modelName, FacesContext.getCurrentInstance(), list1);
                    return list1;
                }
            }
        }
        return null;
    }
}
