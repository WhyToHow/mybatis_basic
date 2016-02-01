package com.test;

import java.util.Set;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * 使用接口的注解来实现数据库数据的增删该查  省去映射配置文件
 *
 *需要在conf.xml中指定此接口类
 *	其他操作类似，只是还要注意字段与属性名字对应的问题
 *
 */
public interface IUser {
	@Select(value = { "select user_id userId,user_name userName from t_user where user_id = #{userId}" })
	public User findSingle(Integer userId);
	@Select(value={"select user_id userId , user_name userName from t_user"})
	public Set<User> findList();
	@Insert(value="insert into t_user values(hibernate_sequence.nextval,#{userName})")
	public int insert(User user);
	@Delete(value="delete from t_user where user_id = #{userId}")
	public int delete(Integer userId);
	@Update(value="update t_user set user_name = #{userName} where user_id = #{userId}")
	public int update(User user);
}
