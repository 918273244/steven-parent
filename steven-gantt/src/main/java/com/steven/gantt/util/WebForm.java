package com.steven.gantt.util;

import com.easyjf.beans.BeanUtils;
import com.easyjf.beans.BeanWrapper;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * 
* <p>Title: WebForm.java</p>

* <p>Description:表单对象和POJO转换类，该类可以将表单对象转换为POJO </p>

*/
public class WebForm {
    /**
	 * 把form表单中的数据转换成classType类对象，用在对象更新
	 * 
	 * @param request
	 *            前台请求，封装表单数据
	 * @param obj
	 *            数据库中已经存在的obj对象，泛类型
	 * @return
	 */
    public Object toPo(HttpServletRequest request, Object obj) {
		try {
			Map map = request.getParameterMap();
			java.util.Enumeration enum1 = request.getParameterNames();
			List<Map> maps = new ArrayList<Map>();
			while (enum1.hasMoreElements()) {
				String paramName = (String) enum1.nextElement();
				String value = request.getParameter(paramName);
				Map m1 = new HashMap();
				m1.put(paramName, value);
				maps.add(m1);
			}
			Map2Obj(maps, obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
    
    /**
	 * 把form表单中的数据转换成classType类对象，用户第一次新建对象
	 * 
	 * @param <T>
	 *            泛类型，和classType对应
	 * @param request
	 *            用户请求，封装表单数据
	 * @param classType
	 *            对象类型
	 * @return
	 */
	public <T> T toPo(HttpServletRequest request, Class<T> classType) {
		T obj = null;
		try {
			obj = classType.newInstance();
			Map map = request.getParameterMap();
			java.util.Enumeration enum1 = request.getParameterNames();
			List<Map> maps = new ArrayList<Map>();
			while (enum1.hasMoreElements()) {
				String paramName = (String) enum1.nextElement();
				String value = new String (request.getParameter(paramName).getBytes("UTF-8"),"UTF-8");
				Map m1 = new HashMap();
				m1.put(paramName, value);
				maps.add(m1);
			}
			Map2Obj(maps, obj);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	public void Map2Obj(List<Map> maps, Object obj) {
		BeanWrapper wrapper = new BeanWrapper(obj);
		java.beans.PropertyDescriptor[] propertys = wrapper
				.getPropertyDescriptors();
		for (int i = 0; i < propertys.length; i++) {
			String name = propertys[i].getName();
			if (!wrapper.isWritableProperty(name)
					|| propertys[i].getWriteMethod() == null)
				continue;
			Object propertyValue = null;
			for (int j = 0; j < maps.size(); j++) {
				Map map = (Map) maps.get(j);
				Iterator keys = map.keySet().iterator();
				while (keys.hasNext()) {
					String key = (String) keys.next();
					if (key.equals(propertys[i].getName())) {
							try {
								propertyValue = BeanUtils.convertType(map
										.get(key), propertys[i]
										.getPropertyType());
							} catch (Exception e) {
								if (propertys[i].getPropertyType().toString()
										.equals("int")) {
									propertyValue = 0;
								}
								if (propertys[i].getPropertyType().toString()
										.toLowerCase().indexOf("boolean") >= 0) {
									propertyValue = false;
								}
							}
							// System.out.println("复制值：" + propertyValue +
							// ",复制到："+ propertys[i].getName());
							//表单值不为空时赋值
							if(propertyValue != null){
								wrapper.setPropertyValue(propertys[i].getName(),
										propertyValue);
							}
					}
				}
			}
		}
	}
}
