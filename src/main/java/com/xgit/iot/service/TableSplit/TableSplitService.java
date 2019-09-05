package com.xgit.iot.service.tableSplit;

import com.bkrwin.ufast.infra.infra.log.LogHelper;
import com.xgit.iot.dao.mapper.TableSplitMapper;
import com.xgit.iot.infra.ErrorCode;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@Service
@Scope("prototype")
public class TableSplitService  {

	TableSplitMapper tableSplitMapper;
	public void addMapper(TableSplitMapper tableSplitMapper){
		this.tableSplitMapper = tableSplitMapper;
	}

	/**
	 * 获取所有月份List
	 * @param beginDate
	 * @param endDate
	 * @return
	 */
	public List<String> getMonthBetween(String beginDate, String endDate)  {
		// 1、获取所有月份集合
		List<String> monthList = getMonthBetweenList(beginDate,endDate);

		// 2、判断月份表是否存在,不存在则移除
		List<String> availableMonthList = monthList.stream().filter(t -> existsMonthYearTable(t)).collect(Collectors.toList());

		return availableMonthList;
	}

	public List<String> getMonthBetweenList(String beginDate, String endDate) {
		ArrayList<String> result = new ArrayList<>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");

		Calendar min = Calendar.getInstance();
		Calendar max = Calendar.getInstance();
		try {
			min.setTime(sdf.parse(beginDate));
		} catch (ParseException ex) {
			LogHelper.fatal("日期转化异常,minDate:" + beginDate + ",maxDate:" + endDate, ex);
			return new ArrayList<>();
		}
		int year = min.get(Calendar.YEAR);
		int month = min.get(Calendar.MONTH);
		min.set(year, month, 1);

		try {
			max.setTime(sdf.parse(endDate));
		} catch (ParseException ex) {
			LogHelper.fatal("日期转化异常,minDate:" + beginDate + ",maxDate:" + endDate, ex);
			return new ArrayList<>();
		}
		max.set(max.get(Calendar.YEAR), max.get(Calendar.MONTH), 2);

		Calendar curr = min;
		while (curr.before(max)) {
			result.add(sdf.format(curr.getTime()));
			curr.add(Calendar.MONTH, 1);
		}

		return result;
	}

	/**
	 * 判断表是否存在该表
	 * @param monthYearTable
	 * @return
	 */
	public boolean existsMonthYearTable(String monthYearTable){
		int count = tableSplitMapper.count(monthYearTable);
		return count > 0;
	}

	/**
	 * 生成当月表
	 * @param curMonthYear
	 * @return
	 */
	public ErrorCode CreateCurMonthYearTable(String curMonthYear){
		boolean existsCurMonthYear = existsMonthYearTable(curMonthYear);
		if(existsCurMonthYear){
			return ErrorCode.Success;
		}

		try{
			tableSplitMapper.createTable(curMonthYear);
		}
		catch(Exception ex){
			return ErrorCode.CreateMocDpuSendTableFail;
		}

		return ErrorCode.Success;
	}
}
