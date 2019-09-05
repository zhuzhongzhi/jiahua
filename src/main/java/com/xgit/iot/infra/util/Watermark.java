package com.xgit.iot.infra.util;

import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

public class Watermark {

    private static Logger logger = Logger.getLogger(Watermark.class);

    /**
     * @param tarImgPath       保存的图片路径
     * @param waterMarkContent 水印内容
     * @param markContentColor 水印颜色
     * @param font             水印字体
     */
    public static void addWaterMark(InputStream srcImgFileIn, String tarImgPath,
                                    String waterMarkContent, Color markContentColor, Font font) throws Exception{
            // 读取原图片信息
//            Image srcImg = ImageIO.read(srcImgFile);//文件转化为图片
            BufferedImage srcImg = ImageIO.read(srcImgFileIn);
            int srcImgWidth = srcImg.getWidth(null);//获取图片的宽
            int srcImgHeight = srcImg.getHeight(null);//获取图片的高
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            g.setColor(markContentColor); //根据图片的背景设置水印颜色
            g.setFont(font);              //设置字体
            //设置水印的坐标
            g.drawString(waterMarkContent, srcImgWidth/2, srcImgHeight/2);  //画出水印
            g.dispose();
            // 输出图片
            File file = new File(tarImgPath);
            if(!file.getParentFile().exists()){
                file.getParentFile().mkdirs();
            }
            FileOutputStream outImgStream = new FileOutputStream(tarImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
    }
}
