package com.xgit.iot.infra.util;

import java.util.List;

public  class ListPageUtil {
    /**
     * @param page
     * 当前页数
     * @param pageSize
     * 每页得大小
     * @param list
     * 分页的对象
     * @return
     */
    public static <T> List<T> getListPage(int page, int pageSize, List<T> list) {
        if (list == null || list.size() == 0) {
            throw new RuntimeException("分页数据不能为空!");
        }

        //page == 0 或者 pageSize == 0 默认不分页
        if(page == 0 || pageSize == 0){
            return list;
        }

        int totalCount = list.size();
        page = page - 1;
        int fromIndex = page * pageSize;
        //分页不能大于总数
        if(fromIndex>=totalCount) {
            throw new RuntimeException("页数或分页大小不正确!");
        }
        int toIndex = ((page + 1) * pageSize);
        if (toIndex > totalCount) {
            toIndex = totalCount;
        }
        return list.subList(fromIndex, toIndex);

    }
}
