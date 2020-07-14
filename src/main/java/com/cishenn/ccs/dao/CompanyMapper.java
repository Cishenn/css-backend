package com.cishenn.ccs.dao;

import com.cishenn.ccs.entity.Company;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;

@Mapper
public interface CompanyMapper {
    int save(Company company);

    int update(String ID, Company company);

    int delete(String ID);

    Company getOne(Integer ID);

    List<Company> getAll();
}