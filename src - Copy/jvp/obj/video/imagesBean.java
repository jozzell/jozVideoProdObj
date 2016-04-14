/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvp.obj.video;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author lmeans
 */
@ManagedBean
public class imagesBean  implements Serializable {
    private int imageDisplayId;
    private int imageId;
    private int lookupId;
    private int OrderId;
    private int userId;
    private String imagePath;
    private String imageText;
    private String imageDesc;
    private String imageTextRoot;
    private String imageDescRoot;

    /**
     * @return the imageDisplayId
     */
    public int getImageDisplayId() {
        return imageDisplayId;
    }

    /**
     * @param imageDisplayId the imageDisplayId to set
     */
    public void setImageDisplayId(int imageDisplayId) {
        this.imageDisplayId = imageDisplayId;
    }

    /**
     * @return the imageId
     */
    public int getImageId() {
        return imageId;
    }

    /**
     * @param imageId the imageId to set
     */
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    /**
     * @return the lookupId
     */
    public int getLookupId() {
        return lookupId;
    }

    /**
     * @param lookupId the lookupId to set
     */
    public void setLookupId(int lookupId) {
        this.lookupId = lookupId;
    }

    /**
     * @return the OrderId
     */
    public int getOrderId() {
        return OrderId;
    }

    /**
     * @param OrderId the OrderId to set
     */
    public void setOrderId(int OrderId) {
        this.OrderId = OrderId;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     * @return the imagePath
     */
    public String getImagePath() {
        return imagePath;
    }

    /**
     * @param imagePath the imagePath to set
     */
    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    /**
     * @return the imageText
     */
    public String getImageText() {
        return imageText;
    }

    /**
     * @param imageText the imageText to set
     */
    public void setImageText(String imageText) {
        this.imageText = imageText;
    }

    /**
     * @return the imageDesc
     */
    public String getImageDesc() {
        return imageDesc;
    }

    /**
     * @param imageDesc the imageDesc to set
     */
    public void setImageDesc(String imageDesc) {
        this.imageDesc = imageDesc;
    }

    /**
     * @return the imageTextRoot
     */
    public String getImageTextRoot() {
        return imageTextRoot;
    }

    /**
     * @param imageTextRoot the imageTextRoot to set
     */
    public void setImageTextRoot(String imageTextRoot) {
        this.imageTextRoot = imageTextRoot;
    }

    /**
     * @return the imageDescRoot
     */
    public String getImageDescRoot() {
        return imageDescRoot;
    }

    /**
     * @param imageDescRoot the imageDescRoot to set
     */
    public void setImageDescRoot(String imageDescRoot) {
        this.imageDescRoot = imageDescRoot;
    }
}
