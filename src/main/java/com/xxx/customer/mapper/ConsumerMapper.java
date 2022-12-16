package com.xxx.customer.mapper;

import com.xxx.customer.pojo.Consumer;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Alba
 * @since 2022-11-30
 */
@Mapper
public interface ConsumerMapper extends BaseMapper<Consumer> {

    @Insert("INSERT INTO consumer(phoneNum,username,password,createdAt,updatedAt,avatar) VALUES(#{phoneNum},#{username},#{password},#{createdAt},#{updatedAt},#{avatar})")
    int insert(Consumer consumer);

    @Select("SELECT id FROM consumer WHERE phoneNum=#{phone}")
    int selectUserByPhone(String phone);

    @Select("SELECT * FROM consumer WHERE id=#{id}")
    Consumer userOfId(Integer id);
}
