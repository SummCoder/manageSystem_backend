package com.example.manage_backend.mapper;

import com.example.manage_backend.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {


    /**
     * 查询该系统中所有用户信息
     * @return 系统用户列表
     */
    @Select("SELECT * FROM sys_user")
    List<User> findAllUsers();

    /**
     * 创建用户
     * @param user
     */
    @Insert("INSERT INTO sys_user(username, password, address) VALUES (#{username}, #{password}, #{address})")
    int insertUser(User user);

    /**
     * 更新用户信息
     * @param user
     * @return
     */
    @Update("UPDATE sys_user SET password =#{password}, address =#{address} WHERE id = #{id}")
    int updateUser(User user);


    /**
     * 根据id删除用户
     * @param id
     * @return
     */
    @Delete("DELETE FROM sys_user WHERE id = #{id}")
    int deleteUser(Integer id);

    /**
     * 根据页数查询出相对应的user信息列表
     * @param pageNum
     * @param pageSize
     * @return
     */
    @Select("SELECT * FROM sys_user WHERE username LIKE concat('%', #{username}, '%') limit #{pageNum}, #{pageSize}")
    List<User> getUsersByPage(Integer pageNum, Integer pageSize, String username);

    /**
     * 返回总的数据条数
     * @return
     */
    @Select("SELECT COUNT(*) FROM sys_user")
    int getTotalNum(String username);
}
