package com.cstech.cwanime.core;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.cglib.beans.BeanCopier;
import org.springframework.cglib.core.Converter;
import org.springframework.util.CollectionUtils;

/**
 * Bean拷贝 工具类
 * @author Satsuki.Cyan
 * @date 2019-03-14
 */
public class BeanObjectCopyUtils {

	private static Logger LOGGER = LoggerFactory.getLogger( BeanObjectCopyUtils.class );

	public static <T, E> T copyObject( T targetObj, E srcObj ) {
		if( targetObj != null && srcObj != null ) {
			try {
				BeanCopier bc = BeanCopier.create( srcObj.getClass(), targetObj.getClass(), false );
				bc.copy( srcObj, targetObj, ( Converter )null );
			} catch( Exception e ) {
				LOGGER.error( "object copy error", e );
				throw new RuntimeException( "object copy error", e );
			}
		}
		return targetObj;
	}

	public static <T, E> T copyObject( T targetObj, E srcObj, String... ignoreProperties ) {
		if( targetObj != null && srcObj != null ) {
			try {
				BeanUtils.copyProperties( targetObj, srcObj, ignoreProperties );
			} catch( Exception e ) {
				LOGGER.error( "object ( ignoreProperties ) copy error", e );
				throw new RuntimeException( "object ( ignoreProperties ) copy error", e );
			}
		}
		return targetObj;
	}

	public static <T> List<T> copyListObjToListObj( Class<T> targetClass, List srcList ) {
		List targetList = new ArrayList();
		if( !CollectionUtils.isEmpty( srcList ) ) {
			try {
				BeanCopier bc = BeanCopier.create( srcList.get( 0 ).getClass(), targetClass, false );

				for( Object srcObj : srcList ) {
					Object targetObj = targetClass.newInstance();
					bc.copy( srcObj, targetObj, ( Converter )null );
					targetList.add( targetObj );
				}
			} catch( Exception e ) {
				LOGGER.error( "list copy error", e );
				throw new RuntimeException( "list copy error", e );
			}
		}

		return targetList;
	}

	// public static PageInfo copyToPageInfo( PageInfo pageInfo, Object srcObj ) {
	// if( srcObj != null && pageInfo != null ) {
	// try {
	// BeanCopier bc = BeanCopier.create( srcObj.getClass(), pageInfo.getClass(), false );
	// bc.copy( srcObj, pageInfo, ( Converter )null );
	// int start = pageInfo.getStart();
	// int limit = pageInfo.getLimit();
	// pageInfo.setStart( ( start - 1 ) * limit );
	// } catch( Exception var5 ) {
	// LOGGER.error( "pageInfo copy error", var5 );
	// throw new RuntimeException( "pageInfo copy error", var5 );
	// }
	// }
	//
	// return pageInfo;
	// }

}
