package com.moodpo.common.base;

import java.util.List;
import java.util.Map;

import com.moodpo.common.exception.DBException;


/**
 * 基类DAO接口
 * @author xiaoxie
 * @date 2013-4-3 下午04:15:31
 * @email yangxiaoxiehaha@gmail.com
 * @version 1.0
 * @param Model
 * @param String
 */
public interface IDao {
	/**
	 * 添加一条记录并返回ID
	 * @param entity
	 * @param sqlId
	 * @throws DBException
	 * @return id
	 */
	public String add(Model entity, String sqlId) throws DBException;
	
	/**
	 * 添加一条记录
	 * @param entity
	 * @param sqlId
	 * @throws DBException
	 */
	public void insert(Model entity, String sqlId) throws DBException;
	
	/**
	 * 通过主键删除一条记录
	 * @param id
	 * @param sqlId
	 * @throws DBException
	 */
	public void deleteById(String id, String sqlId) throws DBException;
	
	/**
	 * 通过实体删除多条记录
	 * @param entity
	 * @param sqlId
	 * @throws DBException
	 */
	public void delete(Model entity, String sqlId) throws DBException;
	
	/**
	 * 通过主键列表批量删除
	 * @param ids
	 * @param sqlId
	 * @throws DBException
	 */
	public void delete(List<String> ids, String sqlId) throws DBException;
	
	/**
	 * 通过实体更新一条记录
	 * @param entity
	 * @param sqlId
	 * @throws DBException
	 */
	public void update(Model entity, String sqlId) throws DBException;
	
	/**
	 * 通过主键查找一条记录
	 * @param id
	 * @param sqlId
	 * @return
	 * @throws DBException
	 */
	public Model find(String id, String sqlId) throws DBException;
	
	/**
	 * 通过实体查询多条记录
	 * @param entity
	 * @param sqlId
	 * @return
	 * @throws DBException
	 */
	public List<Model> query(Model entity, String sqlId) throws DBException;
	
	/**
	 * 通过map查询多条记录 分页方法
	 * @param params
	 * @param sqlId
	 * @return
	 * @throws DBException
	 */
	public List<Model> query(Map<String, Object> params, String sqlId)
			throws DBException;
	
	/**
	 * 查询记录总数
	 * @param params
	 * @param sqlId
	 * @return
	 * @throws DBException
	 */
	public Integer count(Map<String, Object> params, String sqlId)
			throws DBException;
	
}
