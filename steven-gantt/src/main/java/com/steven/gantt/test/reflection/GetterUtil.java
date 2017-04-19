package com.steven.gantt.test.reflection;

/**
 * Created by Steven on 2017/4/19.
 */
public class GetterUtil {


    /**
     * Get getter method name by field name
     * @param fieldname
     * @return
     */
    public static String toGetter(String fieldname) {
        if (fieldname == null || fieldname.length() == 0) {
            return null;
        }
        /* If the second char is upper, make 'get' + field name as getter name. For example, eBlog -> geteBlog */
        if (fieldname.length() > 2) {
            String second = fieldname.substring(1, 2);
            if (second.equals(second.toUpperCase())) {
                return new StringBuffer("get").append(fieldname).toString();
            }
        }

        fieldname = new StringBuffer("get").append(fieldname.substring(0, 1).toUpperCase())
                .append(fieldname.substring(1)).toString();
        return  fieldname;
    }


    public static void main(String[] args) {
        System.out.println(GetterUtil.toGetter("getUser"));
    }
}
