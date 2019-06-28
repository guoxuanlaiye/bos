/**   
 * Copyright © 2019 COFCO. All rights reserved.
 * 
 * 功能描述：
 * @Package: com.guoxuan.bos.commons 
 * @author: cofco   
 * @date: Jun 28, 2019 4:17:09 PM 
 */
package com.guoxuan.bos.commons;

import java.io.Serializable;
/**   
 * @Description: 返回格式统一
 * @author: guoxuan
 * @date: Jun 28, 2019
*/
public class BaseResult<T> implements Serializable{
	private static final long serialVersionUID = -8113343511272888809L;
	private boolean success;
	private T data;
	private String errorMsg;
	
	public BaseResult(boolean success, T data) {
		this.success = success;
		this.data = data;
	}
	public BaseResult(boolean success, String errorMsg) {
		this.success = success;
		this.errorMsg = errorMsg;
	}

	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	@Override
	public String toString() {
		return "BaseResult [success=" + success + ", data=" + data + ", errorMsg=" + errorMsg + "]";
	}
}
