/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jvp.obj.video;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import obj.reusableObj;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author lmeans
 */
public class uploadImages implements Serializable{
    String path,prefix;
    //int cnt=0;
    reusableObj     reusableObj = new  reusableObj();
   
    public uploadImages(String path){
        this(path,null);
    }
    public uploadImages(String path,String prefix){
        new File(path).mkdirs();
        this.path = path;
        this.prefix = prefix;
    }
    public List<String> upload(FileUploadEvent event) throws IOException {
        List<String> ary = new ArrayList<String>(0);
        List<UploadedFile> uploadedFiles = new ArrayList<UploadedFile>();
        uploadedFiles.add(event.getFile());
        int cnt=0;
        String str;
        for (UploadedFile l : uploadedFiles){
           str = copyFile(cnt++,event.getFile().getFileName(), event.getFile().getInputstream());
           if (str != null)ary.add(str);
        }
        return ary;
    }
    private String copyFile(int cntr, String fileName, InputStream in) {
        String ext = fileName.substring(fileName.lastIndexOf("."));
        String name = reusableObj.paddingString("" + (cntr), 5, '0', true) + "." + ext;

        String str = path + "/" + name;

        try (
            OutputStream out = new FileOutputStream(new File(str.toLowerCase()))) {
            int read = 0;
            byte[] bytes = new byte[1024];

            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.close();

        } catch (IOException e) {
            str = null;
            e.printStackTrace();

        }
        return str;
    }
    
    public String uploadFile(UploadedFile event,int cnt) throws IOException {
       
        
        return copyFile(event.getFileName(), event.getInputstream(),cnt);
    }
    public String uploadFile(int cnt,FileUploadEvent event) throws IOException {
        FacesMessage msg = new FacesMessage("Success! ", event.getFile().getFileName() + " is uploaded.");
        FacesContext.getCurrentInstance().addMessage(null, msg);
        return copyFile(event.getFile().getFileName(), event.getFile().getInputstream(),cnt);
    }
    public String copyFile(String fileName, InputStream in,int cnt) {
        String ext =fileName.substring(fileName.lastIndexOf(".")) ;
        fileName = fileName.substring(0,fileName.lastIndexOf("."));
        String str = path+"/" + 
                (prefix == null?"":prefix+"_")+
                reusableObj.paddingString(""+(cnt++), 3, '0', true)+"_"+
                reusableObj.getUnixName(fileName,"")+ext;
        
        try {
            
            try ( 
                OutputStream out = new FileOutputStream(new File(str.toLowerCase()))) {
                int read = 0;
                byte[] bytes = new byte[1024];

                while ((read = in.read(bytes)) != -1) {
                    out.write(bytes, 0, read);
                }
                in.close();
                out.close();
                
            } finally {
                
            }
        } catch (IOException e) {
            str = null;
            e.printStackTrace();
            
        }
        return str;
    }
    public static void main(String args[]){
        String fileName = "Jozzell.peace.jep";
        String ext =fileName.substring(fileName.lastIndexOf(".")) ;
        fileName = fileName.substring(0,fileName.lastIndexOf("."));
        System.out.println();
    }
}
