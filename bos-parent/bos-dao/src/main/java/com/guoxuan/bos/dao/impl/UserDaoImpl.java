/**   
 * Copyright © 2019 COFCO. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.guoxuan.bos.dao.impl 
 * @author: cofco   
 * @date: Jul 4, 2019 2:29:35 PM 
 */
package com.guoxuan.bos.dao.impl;

import org.springframework.stereotype.Repository;

import com.guoxuan.bos.dao.IUserDao;
import com.guoxuan.bos.domain.User;

/**   
 * @Description: UserDao实现类
 * @author: guoxuan
 * @date: Jul 4, 2019
*/
@Repository
public class UserDaoImpl extends BaseDaoImpl<User> implements IUserDao {

}
