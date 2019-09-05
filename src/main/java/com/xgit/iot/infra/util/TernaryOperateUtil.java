package com.xgit.iot.infra.util;

import com.bkrwin.ufast.infra.infra.log.LogHelper;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Map;


/**
 * 类注释 三目运算符template 模板替换字符
 *
 * @author hz
 * @version 1.0.0 createTime: 2018/11/30 16:36
 */
public class TernaryOperateUtil {


    private static ScriptEngineManager m = new ScriptEngineManager();
    //获取JavaScript执行引擎
    private static ScriptEngine engine = m.getEngineByName("JavaScript");

    /**
     * @param calcExp      数据库三目运算符 表达式 eg {machineStatus}>=1?'启动':'关机'     2>1?  "a"  : "b"
     * @param variateCode  变量ID CODE            eg machineStatus
     * @param variateValue 变量内容               eg 1
     * @return
     */
    public static String getCalcValue(String calcExp, String variateCode, String variateValue) {
        Map<String, String> mapCalc = new HashMap<>();
        mapCalc.put("value", variateValue);
        String calcExpValue = StringTemplateUtils.render(calcExp, mapCalc);
        LogHelper.monitor("参数代入三目运算符结果: " + calcExpValue);
        String[] expValue = calcExpValue.split("[:?]");
        LogHelper.monitor("参数代入三目运算符结果 做切割: " + expValue);
        String calcParam = expValue[0].replace("?", "");
        String returnValue = null;
        try {
            Object result = engine.eval(calcExpValue);
            if (null != result) {
                returnValue = result.toString();
            }
        } catch (ScriptException e) {
            LogHelper.monitor(" ScriptEngineManager" + e.getMessage());
        }
        LogHelper.monitor("计算redis数据得出实时展示数据: " + returnValue);
        return returnValue;
    }

    /**
     * @param calcTypeCode 计算类型                  eg >=
     * @param calcParam    需要进行的计算的值        eg 2>=1
     * @param expValue1    三目运算 表达式内容 参数1 eg 开机
     * @param expValue2    三目运算 表达式内容 参数2 eg 关机
     * @return
     */
    public static String getCalcValueByCalcType(String calcTypeCode, String calcParam, String expValue1, String expValue2) {
        String returnValue = null;
        switch (calcTypeCode) {
            case "==":
                String[] calcResultSplitCaseOne = calcParam.split("==");
                LogHelper.monitor("需要进行的计算的值: " + calcResultSplitCaseOne);
                if (Double.valueOf(calcResultSplitCaseOne[0]) == Double.valueOf(calcResultSplitCaseOne[1])) {
                    returnValue = expValue1;
                    break;
                } else {
                    returnValue = expValue2;
                    break;
                }
            case "!=":
                String[] calcResultSplitCaseTwo = calcParam.split("!=");
                LogHelper.monitor("需要进行的计算的值: " + calcResultSplitCaseTwo);
                if (Double.valueOf(calcResultSplitCaseTwo[0]) != Double.valueOf(calcResultSplitCaseTwo[1])) {
                    returnValue = expValue1;
                    break;
                } else {
                    returnValue = expValue2;
                    break;
                }
            case ">=":
                String[] calcResultSplitCaseThree = calcParam.split(">=");
                LogHelper.monitor("需要进行的计算的值: " + calcResultSplitCaseThree);
                if (Double.valueOf(calcResultSplitCaseThree[0]) >= Double.valueOf(calcResultSplitCaseThree[1])) {
                    returnValue = expValue1;
                    break;
                } else {
                    returnValue = expValue2;
                    break;
                }
            case ">":
                String[] calcResultSplitCaseFour = calcParam.split(">");
                LogHelper.monitor("需要进行的计算的值: " + calcResultSplitCaseFour);
                if (Double.valueOf(calcResultSplitCaseFour[0]) > Double.valueOf(calcResultSplitCaseFour[1])) {
                    returnValue = expValue1;
                    break;
                } else {
                    returnValue = expValue2;
                    break;
                }
            case "<=":
                String[] calcResultSplitCaseFive = calcParam.split("<=");
                LogHelper.monitor("需要进行的计算的值: " + calcResultSplitCaseFive);
                if (Double.valueOf(calcResultSplitCaseFive[0]) <= Double.valueOf(calcResultSplitCaseFive[1])) {
                    returnValue = expValue1;
                    break;
                } else {
                    returnValue = expValue2;
                    break;
                }
            case "<":
                String[] calcResultSplitCaseSix = calcParam.split("<");
                LogHelper.monitor("需要进行的计算的值: " + calcResultSplitCaseSix);
                if (Double.valueOf(calcResultSplitCaseSix[0]) < Double.valueOf(calcResultSplitCaseSix[1])) {
                    returnValue = expValue1;
                    break;
                } else {
                    returnValue = expValue2;
                    break;
                }
        }
        return returnValue;
    }

}
