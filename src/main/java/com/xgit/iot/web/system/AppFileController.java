package com.xgit.iot.web.system;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@RestController
@RequestMapping("/app")
@Slf4j
public class AppFileController {

    @Value("${mobileApp.file.path}")
    private String appFilePath;

    @Value("${mobileApp.file.name}")
    private String appFileName;

    @GetMapping("/download/android")
    public void download(HttpServletRequest request, HttpServletResponse response) {
        File file = new File(appFilePath + appFileName);
        log.info("appFilePath:" + appFilePath + "appFileName:" + appFileName);
        try {
            if (file.exists()) {
                InputStream fis = new BufferedInputStream(new FileInputStream(file));
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer);
                fis.close();
                response.reset();
                response.addHeader("Content-Disposition", "attachment;filename=" + file.getName());
                response.addHeader("Content-Length", "" + file.length());
                OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
                toClient.write(buffer);
                toClient.flush();
                toClient.close();
            }
        } catch (Exception e) {
            System.out.println("下载文件失败" + e.getMessage());
        }
    }
}
