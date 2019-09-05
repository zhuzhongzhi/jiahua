package com.xgit.iot.infra.util;

import com.bkrwin.ufast.infra.infra.log.LogHelper;
import org.apache.commons.lang.StringUtils;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 类注释
 *
 * @author hz
 * @version 1.0.0 createTime: 2018/11/28 15:57
 */
public class StringTemplateUtils {
    public static final String DEF_REGEX = "\\{(.+?)\\}";

    /**
     * 根据模板 ，参数 替换
     *
     * @param template 模板
     * @param data     参数
     * @return
     */
    public static String render(String template, Map<String, String> data) {
        return render(template, data, DEF_REGEX);
    }

    public static String render(String template, Map<String, String> data, String regex) {
        if (StringUtils.isBlank(template)) {
            return "";
        }
        if (StringUtils.isBlank(regex)) {
            return template;
        }
        if (data == null || data.size() == 0) {
            return template;
        }
        try {
            StringBuffer sb = new StringBuffer();
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(template);
            while (matcher.find()) {
                String name = matcher.group(1);// 键名

                String value = data.get(name);// 键值
                if (StringUtils.isEmpty(value)) {
                    value = "";
                }
                if (isNumeric(value)) {
                    LogHelper.monitor("键值： "+value);
                    Double d= Double.parseDouble(value);
                    DecimalFormat df = new DecimalFormat("0.00");
                    value = df.format(d);
                    LogHelper.monitor("键值转化后： "+ value);
                }
                matcher.appendReplacement(sb, value);
            }
            matcher.appendTail(sb);
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return template;
    }

    /**
     * 获取信息模板内 变量内容
     *
     * @param template 模板
     * @return
     */
    public static List<String> getTemplateValue(String template) {
        List<String> list = new ArrayList<>();
        try {
            Pattern pattern = Pattern.compile(DEF_REGEX);
            Matcher matcher = pattern.matcher(template);
            while (matcher.find()) {
                String name = matcher.group(1);
                list.add(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

//    public static void main(String args[]) throws ParseException {
//        String template = "您提现{borrowAmount}元至尾号{tailNo}的请求失败，您可以重新提交提款申请。";
//        Map<String, String> data = new HashMap<String, String>();
//        data.put("borrowAmount", "1000.00");
//        data.put("tailNo", "1234");
//        System.out.println(render(template, data));
//    }


    /**
     * 判断字符串是否为数字
     *
     * @param str
     * @return
     */
    public static boolean isNumeric(String str) {
        Pattern pattern = Pattern.compile("-?[0-9]+.?[0-9]+");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
