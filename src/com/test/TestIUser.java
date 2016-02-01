package com.test;

import org.apache.ibatis.session.SqlSession;

import com.utils.MyBatisUtils;

public class TestIUser {
	public static void main(String[] args){
		SqlSession sqlSession = MyBatisUtils.getSqlSession();
		
		//查询单条记录
		//使用接口全名+方法名字即可。。。
		String sql = "com.test.IUser.findSingle";
		User user1 = sqlSession.selectOne(sql, 1);
		System.out.println(user1.getUserName());
	}
}
