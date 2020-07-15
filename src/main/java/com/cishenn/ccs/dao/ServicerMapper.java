package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Servicer;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface ServicerMapper {
    @Insert("insert into customer_service(phone, password, nickName, realName) values(#{phone},#{password},#{nickName},#{realName})")
    int save(Servicer servicer);

    int update(Integer id, Servicer servicer);

    int delete(Integer id);

    Servicer getOne(Integer id);

    List<Servicer> getAll();

    @Select("select * from customer_service where phone = #{phone} and password = #{password}")
    Servicer login(Servicer servicer);
}
