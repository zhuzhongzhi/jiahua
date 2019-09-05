package com.xgit.iot.infra.util;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.cglib.beans.BeanMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;

public class ExportExcelUtil<T> {

    // sheet表妹每页的记录数
    private static final int SHEET_SIZE = 65535;
    // excel 文件名
    private String fileName;

    private String[] header;

    private String[] cols;

    private int[] numerics;

    private List<T> result;

    private HttpServletResponse resp;

    private HttpServletRequest req;

    public ExportExcelUtil(String fileName, String[] header, String[] cols, int[] numerics, List<T> result, HttpServletRequest req, HttpServletResponse resp) {

        this.fileName = fileName;
        this.header = header;
        this.cols = cols;
        this.result = result;
        this.numerics = numerics;
        this.req = req;
        this.resp = resp;
    }

    public void exportExcel() {
        OutputStream out=null;
        HSSFWorkbook hssfworkbook=null;
        try {
            out = resp.getOutputStream();
            hssfworkbook = new HSSFWorkbook(); // 创建一个excel对象
            for (int i = 0; i <= (result.size() / 65535); i++) {
                HSSFSheet hssfsheet = hssfworkbook.createSheet(); // 工作表
                // 工作表名称
                hssfworkbook.setSheetName(i, fileName.replace(".xls", "") + "(第" + (i + 1) + "页)");
                int beginRows = 65535 * i;
                int endRows = (result.size() > 65535 * (i + 1)) ? 65535 * (i + 1) - 1 : result.size() - 1;
                HSSFRow hssfrowHead = hssfsheet.createRow(0);
                // 输出excel 表头
                if (header != null && header.length > 0) {
                    for (int h = 0; h < header.length; h++) {
                        HSSFCell hssfcell = hssfrowHead.createCell(h, Cell.CELL_TYPE_STRING);
                        hssfcell.setCellValue(header[h]);
                    }
                }
                // 要设置数值型 列表
                HSSFCellStyle cellstyle = hssfworkbook.createCellStyle();
                cellstyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("##0"));
                // 是否是数值型
                boolean isnum = false;
                // 输出excel 数据
                for (int curRow = beginRows; curRow <= endRows; curRow++) {
                    // 获取数据
                    BeanMap hm = BeanMap.create(result.get(curRow));
                    // 创建excel行 表头1行 导致数据行数 延后一行
                    HSSFRow hssfrow = hssfsheet.createRow(curRow % 65535 + 1);
                    // 读取数据值
                    for (int k = 0; k < cols.length; k++) {
                        HSSFCell hssfcell = hssfrow.createCell(k);
                        // hssfcell.setCellValue(hm.get(cols[k])==null?"":hm.get(cols[k]).toString());
                        isnum = false;
                        if (numerics != null) {
                            for (int z = 0; z < numerics.length; z++) {
                                if (numerics[z] == k) {
                                    isnum = true;
                                    break;
                                }
                            }
                        }

                        if (isnum) {
                            if (hm.get(cols[k]) == null || hm.get(cols[k]).equals("")) {

                            } else {
                                hssfcell.setCellStyle(cellstyle);
                                hssfcell.setCellValue(Double.parseDouble(
                                        hm.get(cols[k]) == null ? "" : hm.get(cols[k]).toString().replace(",", "")));
                            }
                        } else {
                            hssfcell.setCellValue(hm.get(cols[k]) == null ? "" : hm.get(cols[k]).toString());
                        }
                    }
                }

            }
            // excel生成完毕，写到输出流

            setReponse();
            hssfworkbook.write(out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();

        } finally {
            try {
                out.close();
                hssfworkbook.close();
            } catch (Exception e) {

            }
        }
    }

    private void setReponse() {

        resp.setContentType("application/vnd.ms-excel");
        String contentDisposition = "";
        try {
            if (req.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {
                contentDisposition = "attachment; filename=\"" + new String(fileName.getBytes("UTF-8"), "ISO8859-1")
                        + "\"";// firefox浏览器
            } else {
                contentDisposition = "attachment; filename=\"" + URLEncoder.encode(fileName, "UTF-8") + "\"";// IE浏览器
            }
        } catch (UnsupportedEncodingException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        resp.setHeader("Content-Disposition", contentDisposition);
        resp.setCharacterEncoding("UTF-8");
    }
}

