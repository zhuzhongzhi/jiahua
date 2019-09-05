package com.xgit.iot.infra.util;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class OutputImage {

    private static Logger logger = Logger.getLogger(Watermark.class);

    public static void outputImage(String url, HttpServletResponse response){
        File file = new File(url);
        if(!file.exists()){
            return;
        }
        InputStream in = null;
        OutputStream out = null;
        response.setContentType("image/jpeg");
        try {
             in = new FileInputStream(file);
             out = response.getOutputStream();
             int i;
             byte [] temp = new byte[1024];
             while( (i = in.read(temp))>0 ){
                out.write(temp,0,i);
             }
        } catch (Exception e) {
            logger.error(e.getMessage(),e);
        } finally {
            try {
                out.close();
                out.flush();
                in.close();
            } catch (IOException e) {
                logger.error(e.getMessage(),e);
            }
        }
    }

}
