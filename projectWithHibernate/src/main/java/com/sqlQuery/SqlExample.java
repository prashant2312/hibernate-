package com.sqlQuery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;
import com.tute.Student;

public class SqlExample {
public static void main(String[] args) {
	SessionFactory factory=new Configuration().configure().buildSessionFactory();
	Session s= factory.openSession();
	
	String q="select * from stu_dent";
	
	NativeQuery createSQLQuery = s.createSQLQuery(q);
	
	List<Object []> list = createSQLQuery.list();
	
	for(Object[] st:list) {
		System.out.println(Arrays.toString(st));
	}
	
	s.close();
	factory.close();
	
}
}
