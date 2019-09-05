package com.xgit.iot.infra.util;

import com.bkrwin.ufast.infra.infra.log.LogHelper;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @author chenjunfei
 * @email chenjunfei@bkrwin.com
 * @date 2018-11-26
 */
public class StreamUtil {
    /**
     * 文件流转字节数组
     * @param fullFilePath
     * @return
     */
    public static byte[] file2byte(String fullFilePath) {
        File file = new File(fullFilePath);
        if (!file.exists()) {
            return null;
        }
        InputStream in =null;
        ByteArrayOutputStream out = null ;
        try{
            in =new FileInputStream(fullFilePath);
            out = new ByteArrayOutputStream();
            byte[] buff = new byte[4096];
            int rc = 0;
            while ((rc = in.read(buff)) != -1) {
                out.write(buff, 0, rc);
            }
            byte[] in2b = out.toByteArray();
            return in2b;
        }catch (IOException e){
            LogHelper.fatal(e.getMessage(),e);
            return null;
        }finally {
            try{
                in.close();
                out.flush();
                out.close();
            }catch (IOException e){
                LogHelper.fatal(e.getMessage(),e);
                return null;
            }
        }
    }

    /**
     * 字节写入响应流
     * @param bytes
     * @param response
     */
    public static void byte2Response(byte[] bytes, ServletResponse response) {
        OutputStream outputStream =null;
        try{
            outputStream = response.getOutputStream();
            outputStream.write(bytes);
        }catch (IOException e){
            LogHelper.fatal(e.getMessage(),e);
        }finally {
            try{
                outputStream.flush();
                outputStream.close();
            }catch (IOException e){
                LogHelper.fatal(e.getMessage(),e);
            }
        }
    }

    /**
     * 文件写入响应流
     * @param fullFilePath
     * @param response
     */
    public static void output(String fullFilePath, HttpServletResponse response) {
        File file = new File(fullFilePath);
        if (!file.exists()) {
            return;
        }
        InputStream in = null;
        OutputStream out = null;
        try {
            in = new FileInputStream(file);
            out = response.getOutputStream();
            int i;
            byte[] temp = new byte[1024];
            while ((i = in.read(temp)) > 0) {
                out.write(temp, 0, i);
            }
        } catch (Exception e) {
            LogHelper.fatal(e.getMessage(), e);
        } finally {
            try {
                out.close();
                out.flush();
                in.close();
            } catch (IOException e) {
                LogHelper.fatal(e.getMessage(), e);
            }
        }
    }
}
