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
public class imageDisplayMaintBean   implements Serializable{
    private String root;
    private String path;
    private String sessionID;
    private int dirID;
    private int ptr = 0;
    private int lk;
    private int userid;
    
    
    /**
     * @return the root
     */
    public String getRoot() {
        return root;
    }

    /**
     * @param root the root to set
     */
    public void setRoot(String root) {
        this.root = root;
    }

    /**
     * @return the path
     */
    public String getPath() {
        return path;
    }

    /**
     * @param path the path to set
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * @return the sessionID
     */
    public String getSessionID() {
        return sessionID;
    }

    /**
     * @param sessionID the sessionID to set
     */
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    /**
     * @return the dirID
     */
    public int getDirID() {
        return dirID;
    }

    /**
     * @param dirID the dirID to set
     */
    public void setDirID(int dirID) {
        this.dirID = dirID;
    }

    public boolean isBeanNeedToBeReset(){
        return ptr >= 25;
    }
    public int getPtr() {
        return ptr++;
    }

    /**
     * @param ptr the ptr to set
     */
    public void setPtr(int ptr) {
        this.ptr = ptr;
    }

    /**
     * @return the lk
     */
    public int getLk() {
        return lk;
    }

    /**
     * @param lk the lk to set
     */
    public void setLk(int lk) {
        this.lk = lk;
    }

    /**
     * @return the userid
     */
    public int getUserid() {
        return userid;
    }

    /**
     * @param userid the userid to set
     */
    public void setUserid(int userid) {
        this.userid = userid;
    }
}
