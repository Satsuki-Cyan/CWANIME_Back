package com.cstech.cwanime.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;

import com.cstech.cwanime.constants.BaseConstant;

/**
 * 对 实体类（POJO） 进行基础校验 工具类
 * @author Satsuki.Cyan
 * @date 2019-03-27 17:59:23
 */
public class ParamValidatorUtils {

	/**
	 * 只抛出第一个错误
	 * @param bindingResult
	 * @return
	 */
	public static String getValidatorMsg( BindingResult bindingResult ) {
		String validatorMsg = "";
		if( bindingResult.hasErrors() ) {
			for( ObjectError objectError : bindingResult.getAllErrors() ) {
				validatorMsg = objectError.getDefaultMessage();
				break;
			}
		}
		return validatorMsg;
	}

	/**
	 * 抛出用逗号（，）拼接的全部错误
	 * @param bindingResult
	 * @return
	 */
	public static String getAllValidatorMsg( BindingResult bindingResult ) {
		StringBuffer validatorMsg = new StringBuffer();

		if( bindingResult.hasErrors() ) {
			int i = 0;
			for( ObjectError objectError : bindingResult.getAllErrors() ) {
				validatorMsg.append( objectError.getDefaultMessage() );
				i++;
				if( i != bindingResult.getAllErrors().size() ) {
					validatorMsg.append( BaseConstant.COMMA_CN );
				}
			}
		}
		return validatorMsg.toString();
	}

}
