package com.steven.gantt.test.reflection;

import java.util.ArrayList;
import java.util.List;

/**
 * 将对象的属性名与属性值存于Map当中，以key，value的形式存在，而value并不希望以单一类型（如String）存在（因为涉及多种类型），
 * 所以用一个FieldEntity的自定义类（此类包含属性名，属性值，属性值类型 等属性）
 * Created by Steven on 2017/4/19.
 */
public class FieldEntity {

    // field name
    private String fieldname;

    // field value
    private Object value;

    // field value's class type
    private Class clazz;

    public FieldEntity() {
        super();
    }

    public FieldEntity(String fieldname, Object value, Class clazz) {
        this.fieldname = fieldname;
        this.value = value;
        this.clazz = clazz;
    }

    private FieldEntity(String fieldname, List<String> errorMsg) {
        this.fieldname = fieldname;
        this.errorMsg = errorMsg;
    }


    private List<String> errorMsg = new ArrayList<String>();

    public String getFieldname() {
        return fieldname;
    }

    public void setFieldname(String fieldname) {
        this.fieldname = fieldname;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Class getClazz() {
        return clazz;
    }

    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    public List<String> getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(List<String> errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "FieldEntity [fieldname=" + fieldname + ", value=" + value
                + ", clazz=" + clazz + ", errorMsg=" + errorMsg + "]";
    }
}
