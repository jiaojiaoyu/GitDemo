package com.vae.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.util.db.DBUtils;
import com.vae.dao.PersonDao;
import com.vae.domain.Person;

/**
 * PersonDao�ľ���ʵ����
 * @author lamp
 *
 */
public class PersonDaoImpl implements PersonDao{

	/**
	 * ʵ����ӷ���
	 */
	@Override
	public void add(Person p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into person(name,age,description)values(?,?,?)";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getDescription());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("�������ʧ��");
		}finally{
			DBUtils.close(null, ps, conn);
		}
	}

	/**
	 * ���·���
	 */
	@Override
	public void update(Person p) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update person set name=?,age=?,description=? where id=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, p.getName());
			ps.setInt(2, p.getAge());
			ps.setString(3, p.getDescription());
			ps.setInt(4, p.getId());
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("��������ʧ��");
		}finally{
			DBUtils.close(null, ps, conn);
		}		
	}

	/**
	 * ɾ������
	 */
	@Override
	public void delete(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from person where id=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1,id);
			ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException(" ɾ������ʧ��");
		}finally{
			DBUtils.close(null, ps, conn);
		}		
	}

	/**
	 * ����ID��ѯһ������
	 */
	@Override
	public Person findById(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Person p = null;
		String sql = "select name,age,description from person where id=?";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if(rs.next()){
				p = new Person();
				p.setId(id);
				p.setName(rs.getString(1));
				p.setAge(rs.getInt(2));
				p.setDescription(rs.getString(3));
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("����ID��ѯ����ʧ��");
		}finally{
			DBUtils.close(rs, ps, conn);
		}
		return p;
	}

	/**
	 * ��ѯ��������
	 */
	@Override
	public List<Person> findAll() throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Person p = null;
		List<Person> persons = new ArrayList<Person>();
		String sql = "select id,name,age,description from person";
		try{
			conn = DBUtils.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				p = new Person();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setAge(rs.getInt(3));
				p.setDescription(rs.getString(4));
				persons.add(p);
			}
		}catch(SQLException e){
			e.printStackTrace();
			throw new SQLException("��ѯ��������ʧ��");
		}finally{
			DBUtils.close(rs, ps, conn);
		}
		return persons;
	}

}