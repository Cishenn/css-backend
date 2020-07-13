package com.cishenn.ccs.biz.impl;

import com.cishenn.ccs.biz.ICompanyBiz;
import com.cishenn.ccs.dao.CompanyMapper;
import com.cishenn.ccs.entity.Company;
import com.cishenn.ccs.exception.CompanyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyBizImpl implements ICompanyBiz {
    @Autowired
    CompanyMapper companyMapper;

    @Override
    public void save(Company company){
        int result=companyMapper.save(company);
        if(result==0){
            throw new CompanyException("Save Company Entity Error");
        }
    }

    @Override
    public void delete(String ID){
        int result=companyMapper.delete(ID);
        if(result==0){
            throw new CompanyException("Delete Company Entity Error");
        }
    }

    @Override
    public void update(String ID, Company company){
        int result=companyMapper.update(ID, company);
        if(result==0){
            throw new CompanyException("Update Company Entity Error");
        }
    }

    @Override
    public Company getOne(String ID) {
        Company result = companyMapper.getOne(ID);
        if(result==null){
            throw new CompanyException("Retrieve Company Entity Error(maybe no such entity");
        }
        return result;
    }

    @Override
    public List<Company> getAll() {
        return companyMapper.getAll();
    }
}