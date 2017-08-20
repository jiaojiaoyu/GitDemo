package com.vae.dao;

import java.sql.SQLException;
import java.util.List;

import com.vae.domain.Person;

/**
 * PersonDao�ӿ� ר�Ŷ�Person����в�����������ɾ�Ĳ飩�Ľӿ�
 * @author DELL
 *
 */
public interface PersonDao {
	//��ӷ���
	public void add(Person p)throws SQLException;
	
	//���·���
	public void update(Person p)throws SQLException;
	
	//ɾ������
	public void delete(int id)throws SQLException;
	
	//���ҷ���
	public Person findById(int id)throws SQLException;
	
	//��������
	public List<Person> findAll()throws SQLException;
	
}
