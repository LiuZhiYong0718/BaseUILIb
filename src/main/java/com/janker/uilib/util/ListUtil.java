package com.janker.uilib.util;


import java.util.List;

/**
 * Created by cy-love on 14-1-11.
 */
public class ListUtil {

    /**
     * 判断数组是否为空
     * @param list
     * @return true表示为空
     */
    public static boolean isEmpty(List<?> list) {
        return (list == null || list.size() == 0);
    }
}
