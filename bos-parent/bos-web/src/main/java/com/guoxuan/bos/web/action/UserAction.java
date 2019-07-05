/**   
 * Copyright © 2019 COFCO. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.guoxuan.bos.web.action 
 * @author: cofco   
 * @date: Jul 4, 2019 2:54:21 PM 
 */
package com.guoxuan.bos.web.action;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.guoxuan.bos.domain.User;


/**   
 * @Description: UserAction
 * @author: guoxuan
 * @date: Jul 4, 2019
*/
@Controller
//@Scope("prototype")  // 多例模式-spring启动时不会创建实例,使用到时才会创建；单例模式启动时创建实例对象
public class UserAction extends BaseAction<User> {
	private static final long serialVersionUID = -1151919156260047038L;
	// 验证码
	private String checkCode;
	public void setCheckCode(String checkCode) {
		this.checkCode = checkCode;
	}
	
	public String login() {
		String validatecode = (String)ServletActionContext.getRequest().getSession().getAttribute("key");
		if (StringUtils.isNotBlank(checkCode) && checkCode.equals(validatecode)) {
			
		} else {
			// 输入错误
			this.addActionError("输入验证码错误!");
			return LOGIN;
		}
		return "";
	}
}
