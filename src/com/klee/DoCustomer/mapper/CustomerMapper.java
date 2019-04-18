package com.klee.DoCustomer.mapper;

import com.klee.DoCustomer.pojo.Customer;

import java.util.List;

public interface CustomerMapper {
    //通过id查询方法
    Customer findCustomerById(int id);
    //查询所有记录
    List<Customer> findAllCustomers();
    //根据
    List<Customer> findLikeCustomers(Customer customer);
    List<Customer> findCustomersByNameJobs(Customer customer);
    List<Customer> findCustsByNameOrJobsOrPhone(Customer customer);
    int insertCustomer(Customer customer);
    int updateCustomer(Customer customer);
    int deleteCustomer(int id);
    int updateCustsNameOrJobOrPhone(Customer customer);
    List<Customer> findCustsByIds(List<Integer> list);
}
