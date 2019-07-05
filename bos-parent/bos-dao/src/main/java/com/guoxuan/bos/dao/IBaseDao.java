/**   
 * Copyright © 2019 COFCO. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.guoxuan.bos.dao 
 * @author: cofco   
 * @date: Jul 3, 2019 2:42:34 PM 
 */
package com.guoxuan.bos.dao;
import java.io.Serializable;
import java.util.List;
/**   
 * @Description: 
 * @author: guoxuan
 * @date: Jul 3, 2019
*/
public interface IBaseDao<T> {
	public void save(T entity);
	public void delete(T entity);
	public void update(T entity);
	public T findById(Serializable id);
	public List<T> findAll();
}
