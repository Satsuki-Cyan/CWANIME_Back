package com.cstech.cwanime.portal.web;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.cstech.cwanime.bean.AjaxMessageEntity;
import com.cstech.cwanime.bean.AjaxMessageResult;
import com.cstech.cwanime.bean.PageResult;
import com.cstech.cwanime.core.BeanObjectCopyUtils;
import com.cstech.cwanime.portal.service.UserService;
import com.cstech.cwanime.portal.service.bo.UserBO;
import com.cstech.cwanime.portal.web.vo.UserVO;
import com.cstech.cwanime.utils.ParamValidatorUtils;
import com.github.pagehelper.PageInfo;

/**
 * 用户 - 注册 controller
 * @author Satsuki
 * @date 2019-03-12
 */
@Scope( "prototype" )
@Controller
@RequestMapping( "/portal/register" )
public class RegisterController {

	private static Logger LOGGER = LoggerFactory.getLogger( RegisterController.class );

	@Autowired
	private UserService userService;

	/**
	 * 注册用户信息
	 * @param userVO
	 * @return String
	 */
	@RequestMapping( value = "/user.json", method = { RequestMethod.GET, RequestMethod.POST } )
	@ResponseBody
	public AjaxMessageEntity<UserBO> registerUserInfo( @Valid @RequestBody UserVO userVO, BindingResult bindingResult ) {
		AjaxMessageEntity<UserBO> ajaxMessageEntity = new AjaxMessageEntity<>();
		// 对VO进行基础校验
		String validatorMsg = ParamValidatorUtils.getValidatorMsg( bindingResult );
		// 判断是否存在错误信息
		if( StringUtils.isEmpty( validatorMsg ) ) {
			UserBO userBO = BeanObjectCopyUtils.copyObject( new UserBO(), userVO );
			UserBO resUserBO = userService.insertUser( userBO );
			ajaxMessageEntity.setCode( AjaxMessageResult.SUCCESS );
			ajaxMessageEntity.setData( resUserBO );
		} else {
			// 返回异常信息
			ajaxMessageEntity.setMessager( AjaxMessageResult.FAIL_ONE, validatorMsg );
		}
		return ajaxMessageEntity;
	}

	/**
	 * test
	 * @param id
	 * @return String
	 */
	@RequestMapping( value = "/test.json", method = { RequestMethod.GET, RequestMethod.POST } )
	@ResponseBody
	public String test( @RequestParam Long id ) {
		UserVO vo = new UserVO();
		vo.setAccountNo( "Satsuki.Cyan" );
		UserBO userBO = BeanObjectCopyUtils.copyObject( new UserBO(), vo );
		System.out.println( userBO.toString() );
		userBO.setId( id );
		userBO = userService.getUser( userBO );
		return userBO.getAccountNo();
	}

	/**
	 * test pageInfo
	 * @param vo
	 * @return String
	 */
	@RequestMapping( value = "/test-by-page.json", method = { RequestMethod.GET, RequestMethod.POST } )
	@ResponseBody
	public AjaxMessageEntity<PageResult<UserBO>> test( UserVO vo ) {
		AjaxMessageEntity<PageResult<UserBO>> ajaxMessageEntity = new AjaxMessageEntity<>();
		vo.setAccountNo( "Satsuki.Cyan" );
		UserBO userBO = BeanObjectCopyUtils.copyObject( new UserBO(), vo );
		System.out.println( userBO.toString() );
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageNum( 1 );
		pageInfo.setPageSize( 10 );
		PageResult<UserBO> pageResult = userService.queryUserByPage( userBO, pageInfo );
		ajaxMessageEntity.setMessager( AjaxMessageResult.SUCCESS, "OK" );
		ajaxMessageEntity.setData( pageResult );
		return ajaxMessageEntity;
	}

}
