/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgn.obj.model;

import java.io.Serializable;
import java.util.List;
import javax.faces.model.ListDataModel;
import jvp.obj.bean.imgBean;
import org.primefaces.model.SelectableDataModel;

/**
 *
 * @author lmeans
 */
public class imgBeanModel  extends ListDataModel<imgBean> implements SelectableDataModel<imgBean>, Serializable {
    public imgBeanModel() {
        super();
        //reset = true;
    }

    public imgBeanModel(List<imgBean> list) {
        super(list);
        //reset = false;

    }

    @Override
    public Object getRowKey(imgBean t) {
        return t.getFileId();
    }

    @Override
    public imgBean getRowData(String string) {
        long id = Long.parseLong(string);
        List<imgBean> list = (List<imgBean>) getWrappedData();
        if (list != null) {
            for (imgBean list1 : list) {
                if (list1.getFileId() == id) {
                    //(new factoryObj()).setAccessBeanFromFacesContext(modelName, FacesContext.getCurrentInstance(), list1);
                    return list1;
                }
            }
        }
        return null;
    }
}
