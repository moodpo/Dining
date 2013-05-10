package com.moodpo.common.base;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.moodpo.common.exception.DBException;

/**
 * dao 支持类
 * @author xiaoxie
 * @date 2013-4-3 下午04:25:22
 * @email yangxiaoxiehaha@gmail.com
 * @version 1.0
 * @param <Model>
 * @param <String>
 */
@Transactional
public class DaoSupport extends SqlMapClientDaoSupport implements IDao {
	
	@Resource
	public void setSqlMapClientBase(SqlMapClient sqlMapClient) {
		super.setSqlMapClient(sqlMapClient);
	}
	
	public String add(Model entity, String sqlId) throws DBException {
		try {
			return this.getSqlMapClientTemplate().insert(sqlId, entity).toString();
		} catch (DataAccessException e) {
			throw new DBException(e.getMessage());
		}		
	}
	
	public void insert(Model entity, String sqlId) throws DBException {
		try {
			this.getSqlMapClientTemplate().insert(sqlId, entity);
		} catch (DataAccessException e) {
			throw new DBException(e.getMessage());
		}		
	}
	
	public void deleteById(String id, String sqlId) throws DBException {
		try {
			this.getSqlMapClientTemplate().delete(sqlId, id);
		} catch (DataAccessException e) {
			throw new DBException(e.getMessage());
		}		
	}

	public void delete(Model entity, String sqlId) throws DBException {
		try {
			this.getSqlMapClientTemplate().delete(sqlId, entity);
		} catch (DataAccessException e) {
			throw new DBException(e.getMessage());
		}		
	}

	public void delete(List<String> ids, String sqlId) throws DBException {
		try {
			this.getSqlMapClientTemplate().delete(sqlId, ids);
		} catch (DataAccessException e) {
			throw new DBException(e.getMessage());
		}		
	}

	public void update(Model entity, String sqlId) throws DBException {
		try {
			this.getSqlMapClientTemplate().update(sqlId, entity);
		} catch (DataAccessException e) {
			throw new DBException(e.getMessage());
		}
	}

	public Model find(String id, String sqlId) throws DBException {
		try {
			return (Model) this.getSqlMapClientTemplate().queryForObject(sqlId, id);
		} catch (DataAccessException e) {
			throw new DBException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Model> query(Model entity, String sqlId) throws DBException {
		try {
			return this.getSqlMapClientTemplate().queryForList(sqlId, entity);
		} catch (DataAccessException e) {
			throw new DBException(e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<Model> query(Map<String, Object> params, String sqlId)
			throws DBException {
		try {
			return this.getSqlMapClientTemplate().queryForList(sqlId, params);
		} catch (DataAccessException e) {
			throw new DBException(e.getMessage());
		}
	}

	public Integer count(Map<String, Object> params, String sqlId)
			throws DBException {
		try {
			return (Integer) this.getSqlMapClientTemplate().queryForObject(sqlId,
					params);
		} catch (DataAccessException e) {
			throw new DBException(e.getMessage());
		}
	}

}
