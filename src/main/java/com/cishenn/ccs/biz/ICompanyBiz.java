package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.Company;

import java.util.List;

public interface ICompanyBiz {
    void save(Company company);

    void update(String id, Company company);

    void delete(String id);

    Company getOne(Integer id);

    List<Company> getAll();
}