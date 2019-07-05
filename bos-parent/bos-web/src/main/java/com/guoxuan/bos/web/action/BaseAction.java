/**   
 * Copyright © 2019 COFCO. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.guoxuan.bos.web.action 
 * @author: cofco   
 * @date: Jul 3, 2019 4:25:51 PM 
 */
package com.guoxuan.bos.web.action;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

/**   
 * @Description: 描述
 * @author: guoxuan
 * @date: Jul 3, 2019
*/
public class BaseAction<T> extends ActionSupport implements ModelDriven<T> {
	private static final long serialVersionUID = 8832591606679916188L;
	
	private T model;
	// 构造器
	public BaseAction() {
		ParameterizedType superclass = (ParameterizedType)this.getClass().getGenericSuperclass();
		// 获取BaseAction上<>中的泛型数组
		Type[] actualTypeArguments = superclass.getActualTypeArguments();
		Class<T> entityClass = (Class<T>)actualTypeArguments[0];
		// 通过反射创建对象
		try {
			model = entityClass.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public T getModel() {
		return model;
	}
}
