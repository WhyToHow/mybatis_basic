package com.test;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class UserTest {
	public static void main(String[] args){
		String resource = "conf.xml";
		Reader reader = null;
		//加载配置文件
		try {
			reader = Resources.getResourceAsReader(resource);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//创建sqlSession工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		
		//创建sqlSession对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		
		//映射文件命名空间
		String namespace = "com.test.userMapper";
		//创建字符串 映射sql的字符串标识
		String sql =  namespace + ".findSingle";//映射标识 + .语句标识
		
		/*//执行单条查询语句
		User user = (User)sqlSession.selectOne(sql,2);
		
		if(user != null){
			System.out.println(user.getUserName()+" "+user.getUserId());
		}else{
			System.out.println("no data to return");
		}*/
		
		//查询列表
//		sql = ?
//		List<User> list = sqlSession.selectList(sql);
//		Iterator it = list.iterator();
//		while(it.hasNext()){
//			System.out.println(((User)(it.next())).getUserName());
//		}
		
		/*//插入记录元素
		sql = namespace + ".insertOne";
		User user2 = new User();
		user2.setUserName("赵六");
		int recordNum = sqlSession.insert(sql, user2);//注意需要提交事务
		System.out.println(recordNum);*/
		
		/*//更新数据
		sql = namespace + ".findSingle";
		User user3 = null;
		//先查询出记录
		user3 = sqlSession.selectOne(sql, 66);
		//修改记录
		user3.setUserName("new"+user3.getUserName());
		sql = namespace + ".updateOne";
		//更改记录
		int updateNum = sqlSession.update(sql, user3);
		System.out.println(updateNum);*/
		
		/*//删除数据
		sql = namespace + ".findSingle";
		User user4 = null;
		//先查询出记录
		user4 = sqlSession.selectOne(sql, 67);
		sql = namespace + ".deleteOne";
		//删除记录
		int deleteNum = sqlSession.delete(sql, user4.getUserId());
		System.out.println(deleteNum);*/
		
		
		
		//执行增删改时需要提交事务
		sqlSession.commit();
		
		try {
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sqlSession.close();
	}
}
