/**   
 * Copyright © 2019 COFCO. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.guoxuan.bos.dao.impl 
 * @author: cofco   
 * @date: Jul 3, 2019 2:53:26 PM 
 */
package com.guoxuan.bos.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.annotation.Resource;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import com.guoxuan.bos.dao.IBaseDao;

/**   
 * @Description: 描述
 * @author: guoxuan
 * @date: Jul 3, 2019
*/
public class BaseDaoImpl<T> extends HibernateDaoSupport implements IBaseDao<T> {
	private Class<T> entityClass;
	// 通过注解获取spring 配置文件中的applicationContext.xml中的sessionFactory
	// 只有设置完sessionFactory后，才会创建HibernateTemplate
	@Resource
	public void setSessionFac(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}
	
	public BaseDaoImpl() {
//		Type superclass = this.getClass().getGenericSuperclass();
//		有泛型的可以向下转换 (ParameterizedType为Type的子接口)
		ParameterizedType superclass = (ParameterizedType)this.getClass().getGenericSuperclass();
		Type[] actualTypeArguments = superclass.getActualTypeArguments();
		entityClass = (Class<T>)actualTypeArguments[0];
		
	}

	@Override
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
	}

	@Override
	public void delete(T entity) {
		this.getHibernateTemplate().delete(entity);
	}

	@Override
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
	}

	@Override
	public T findById(Serializable id) {
		return this.getHibernateTemplate().get(entityClass, id);
	}

	@Override
	public List<T> findAll() {
		String hql = "from "+entityClass.getSimpleName();
		List<T> find = (List<T>) this.getHibernateTemplate().find(hql);
		return find;
	}
}
