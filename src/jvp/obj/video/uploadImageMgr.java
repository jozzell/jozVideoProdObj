package jvp.obj.video;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import obj.reusableObj;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author lmeans
 */
public class uploadImageMgr implements Serializable {
    reusableObj reusableObj;
    int ptr=1;
    public uploadImageMgr(){
        reusableObj = new reusableObj();
    }
    public List<uploadImagesBean> uploadToSrv(int cnt,String root,String path,String prefix,FileUploadEvent event) throws IOException {
        List<uploadImagesBean> ary = new ArrayList<uploadImagesBean>();
        List<UploadedFile> uploadedFiles = new ArrayList<UploadedFile>();
       
        uploadedFiles.add(event.getFile());
        
        String str;
        for (UploadedFile l : uploadedFiles){
            ptr++;
           str = copyFile(root,path,cnt,event.getFile().getFileName(), prefix,event.getFile().getInputstream());
           if (str != null)ary.add(new uploadImagesBean(event.getFile().getFileName(),str));
        }
        return ary;
    }
     public List<String> upload(int cnt,String root,String path,String prefix,FileUploadEvent event) throws IOException {
        List<String> ary = new ArrayList<String>();
        List<UploadedFile> uploadedFiles = new ArrayList<UploadedFile>();
       
        uploadedFiles.add(event.getFile());
        
        String str;
        for (UploadedFile l : uploadedFiles){
            ptr++;
           str = copyFile(root,path,cnt,event.getFile().getFileName(), prefix,event.getFile().getInputstream());
           if (str != null)ary.add(str);
        }
        return ary;
    }
    private String copyFile(String root,String path,int cntr, String fileName,String prefix, InputStream in) {
        String ext = fileName.substring(fileName.lastIndexOf("."));
        String name = prefix+"_"+reusableObj.paddingString("" + (cntr), 5, '0', true)+ "_"+ptr+ ext;
        

        String str = (root+"/"+path + name);

        
        try {
            OutputStream out = new FileOutputStream(new File(str)); 
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
        return (path + name);
    }
}
