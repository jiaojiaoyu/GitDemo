package com.vae.dao;

import java.sql.SQLException;
import java.util.List;

import com.vae.domain.Person;

/**
 * PersonDao接口 专门对Person类进行操作（例如增删改查）的接口
 * @author DELL
 *
 */
public interface PersonDao {
	//添加方法
	public void add(Person p)throws SQLException;
	
	//更新方法
	public void update(Person p)throws SQLException;
	
	//删除方法
	public void delete(int id)throws SQLException;
	
	//查找方法
	public Person findById(int id)throws SQLException;
	
	//查找所有
	public List<Person> findAll()throws SQLException;
	
}
