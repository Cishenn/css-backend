package com.cishenn.ccs.biz;

import com.cishenn.ccs.entity.Company;

import java.util.List;

public interface ICompanyBiz {
    void save(Company company);

    void update(String ID, Company company);

    void delete(String ID);

    Company getOne(String ID);

    List<Company> getAll();
}