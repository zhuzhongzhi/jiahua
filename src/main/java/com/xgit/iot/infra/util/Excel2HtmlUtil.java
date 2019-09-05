package com.xgit.iot.infra.util;

import jxl.Cell;
import jxl.Range;
import jxl.Sheet;
import jxl.Workbook;
import jxl.format.Alignment;
import jxl.format.CellFormat;
import jxl.format.Colour;
import jxl.format.VerticalAlignment;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * 注释：excel转换为HTML
 * 仅仅支持后缀为xls的Excel
 *
 * @author hz
 * @version 1.0.0
 * @createTime: 2019/1/15 10:27
 */
public class Excel2HtmlUtil {
    /**
     * 获取Excel文件转换为HTML后的字符串，仅仅支持后缀为xls的Excel
     *
     * @param is Excel文件 InputStream
     * @return 返回Excel转换后的HTML字符串
     * @throws Exception
     */
    public static String getExcelInfo(String sourceFile, Integer lastRowNum) throws Exception {
        StringBuffer sb = new StringBuffer();
        InputStream is = new FileInputStream(sourceFile);
        Workbook rwb = Workbook.getWorkbook(is);
        Sheet sheet = rwb.getSheet(0);
        int colnum = sheet.getColumns();
        if (lastRowNum == null) {
            lastRowNum = sheet.getRows()-1;
        }
        Map<String, String> map[] = getRowSpanColSpanMap(sheet);
        sb.append("<table border='1' cellspacing='0'>");
        for (int row = 0; row <= lastRowNum; row++) {
            sb.append("<tr>");
            for (int col = 0; col < colnum; col++) {
                Cell cell = sheet.getCell(col, row);
                String content = cell.getContents();
                CellFormat cellFormat = cell.getCellFormat();
                if (map[0].containsKey(row + "," + col)) {
                    String pointString = map[0].get(row + "," + col);
                    map[0].remove(row + "," + col);
                    int bottomeRow = Integer.valueOf(pointString.split(",")[0]);
                    int bottomeCol = Integer.valueOf(pointString.split(",")[1]);
                    int rowSpan = bottomeRow - row + 1;
                    int colSpan = bottomeCol - col + 1;
                    sb.append("<td rowspan= '" + rowSpan + "' colspan= '" + colSpan + "' ");
                } else if (map[1].containsKey(row + "," + col)) {
                    map[1].remove(row + "," + col);
                    continue;
                } else {
                    sb.append("<td ");
                }
                if (cellFormat != null) {
                    Alignment alignment = cellFormat.getAlignment();
                    sb.append("align='" + convertToHtmlGrammer(alignment) + "' ");
                    VerticalAlignment verticalAlignment = cellFormat.getVerticalAlignment();
                    sb.append("valign='" + convertToHtmlGrammer(verticalAlignment) + "' ");
                    sb.append("' ");
                }
                sb.append(">");
                if (content == null || "".equals(content.trim())) {
                    sb.append("   ");
                } else {
                    sb.append(content);
                }
                sb.append("</td>");
            }
            sb.append("</tr>");
        }
        sb.append("</table>");
        rwb.close();
        is.close();
        return sb.toString();
    }

    @SuppressWarnings("unchecked")
    private static Map<String, String>[] getRowSpanColSpanMap(Sheet sheet) {
        Map<String, String> map0 = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        Range[] range = sheet.getMergedCells();
        for (int i = 0; i < range.length; i++) {
            Cell topCell = range[i].getTopLeft();
            Cell bottomCell = range[i].getBottomRight();
            int topRow = topCell.getRow();
            int topCol = topCell.getColumn();
            int bottomRow = bottomCell.getRow();
            int bottomCol = bottomCell.getColumn();
            map0.put(topRow + "," + topCol, bottomRow + "," + bottomCol);
            int tempRow = topRow;
            while (tempRow <= bottomRow) {
                int tempCol = topCol;
                while (tempCol <= bottomCol) {
                    map1.put(tempRow + "," + tempCol, "");
                    tempCol++;
                }
                tempRow++;
            }
            map1.remove(topRow + "," + topCol);
        }
        Map[] map = {map0, map1};
        return map;
    }

    private static String convertToHtmlGrammer(Alignment alignment) {
        String align = "left";
        switch (alignment.getValue()) {
            case 1:
                align = "left";
                break;
            case 2:
                align = "center";
                break;
            case 3:
                align = "right";
                break;
            case 5:
                align = "justify";
                break;
            default:
                break;
        }
        return align;
    }

    private static String convertToHtmlGrammer(VerticalAlignment verticalAlignment) {
        String valign = "middle";
        switch (verticalAlignment.getValue()) {
            case 1:
                valign = "middle";
                break;
            case 2:
                valign = "bottom";
                break;
            case 3:
                valign = "top";
                break;
            default:
                break;
        }
        return valign;
    }

	/*private static String convertToHtmlGrammer(Colour colour) {
        StringBuffer sb = new StringBuffer("");
		if (colour != null && !"default background".equalsIgnoreCase(colour.getDescription())) {
			sb.append("#");
			sb.append(fillWithZero(Integer.toHexString(colour.getDefaultRGB().getRed())));
			sb.append(fillWithZero(Integer.toHexString(colour.getDefaultRGB().getGreen())));
			sb.append(fillWithZero(Integer.toHexString(colour.getDefaultRGB().getBlue())));
		}
		return sb.toString();
	}*/

    private static String fillWithZero(String str) {
        if (str != null && str.length() < 2) {
            return "0" + str;
        }
        return str;
    }
}
