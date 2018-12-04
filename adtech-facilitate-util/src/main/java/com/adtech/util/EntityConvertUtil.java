package com.adtech.util;


import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 数据转换util
 */
public class EntityConvertUtil {


   static Map<String,Map<String,String>> map = new HashMap<>();

    static {
        Map<String,String> map1 = new HashMap<>();
        map.put("test",map1);
        map1.put("EXTSID","typeName");
        map1.put("HDSD0005033","typeValue");
    }

    /**
     * 将ResultSet 转换为list<Map>
     * @param rc
     * @param tableName 需要转换字段的映射
     * @return
     */
    public List<Map<String,Object>> converdToListMap(ResultSet rc,String tableName){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,String> map1 = map.get(tableName);
        try {
            while (rc.next()){
                Map<String,Object> map2 = new HashMap<>();
                for(String s : map1.keySet()){
                    map2.put(map1.get(s),rc.getString(s));
                }
                list.add(map2);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return list;
    }

    /**
     * 转换对应实体list
     * @param rc
     * @param tableName
     * @param clazz
     * @param <T>
     * @return
     */
    public <T> List<T> converdToListEntity(ResultSet rc,String tableName,Class<T> clazz) {
        List<T> list = new ArrayList<>();
        Map<String,String> map1 = map.get(tableName);
        try {
            while (rc.next()) {
                T t = clazz.newInstance();
                for(String s : map1.keySet()){
                    Field field = clazz.getDeclaredField(map1.get(s));
                    InvokeUtil.invokeSet(map1.get(s),rc.getString(s),field,t);
                }
                list.add(t);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
