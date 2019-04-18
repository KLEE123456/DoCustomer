package com.klee.DoCustomer.test;

import com.klee.DoCustomer.mapper.CustomerMapper;
import com.klee.DoCustomer.mybatisUtils.MybatisUtils;
import com.klee.DoCustomer.pojo.Customer;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CustomerTest {
    /**
     * 通过id查询的测试方法
     * @throws IOException
     */
    @Test
    public  void findCustomerByIdTest()  {
        SqlSession sqlSession= MybatisUtils.getSqlSession(false);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer = customerMapper.findCustomerById(1);
        System.out.println(customer);
        MybatisUtils.closeSqlSession(sqlSession);
    }

    /**
     * 整表查询测试方法
     * @throws IOException
     */
    @Test
    public void  findAllCustomersTest() {
        SqlSession sqlSession= MybatisUtils.getSqlSession(false);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> allCustomers = customerMapper.findAllCustomers();
        for (Customer customer:allCustomers) {
            System.out.println(customer);
        }
        MybatisUtils.closeSqlSession(sqlSession);
    }

    /**
     * 模糊查询测试方法
     * @throws IOException
     */
    @Test
    public void findLikeCustomersTest() {
        SqlSession sqlSession= MybatisUtils.getSqlSession(false);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer=new Customer();
        customer.setUsername("四");
        List<Customer> likeCustomers = customerMapper.findLikeCustomers(customer);
        for (Customer customer1:likeCustomers) {
            System.out.println(customer1);
        }
        MybatisUtils.closeSqlSession(sqlSession);
    }

    /**
     * 新增测试方法
     * @throws IOException
     */
    @Test
    public  void  insertCustomerTest(){
        SqlSession sqlSession= MybatisUtils.getSqlSession(true);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer=new Customer();
        customer.setUsername("王五");
        customer.setJobs("教师");
        customer.setPhone("13698760000");
        int rows = customerMapper.insertCustomer(customer);
        if (rows>0){
            System.out.println("------------新增成功！---------");
        }
        else{
            System.out.println("------------新增失败！---------");
        }
        MybatisUtils.closeSqlSession(sqlSession);
    }

    /**
     * 修改测试方法
     * @throws IOException
     */
    @Test
    public  void updateCustomerTest()  {
        SqlSession sqlSession= MybatisUtils.getSqlSession(true);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer=new Customer();
        customer.setId(7);
        customer.setUsername("王伟");
        customer.setJobs("教师");
        customer.setPhone("13600001111");
        int rows = customerMapper.updateCustomer(customer);
        if (rows>0){
            System.out.println("-------------修改成功！--------------");
        }
        else {
            System.out.println("-------------修改失败！--------------");
        }
        MybatisUtils.closeSqlSession(sqlSession);
    }

    /**
     * 删除测试方法
     * @throws IOException
     */
    @Test
    public  void deleteCustomerTest()  {
        SqlSession sqlSession= MybatisUtils.getSqlSession(true);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        int rows = customerMapper.deleteCustomer(7);
        if (rows>0){
            System.out.println("---------------删除成功-----------------");
        }
        else {
            System.out.println("---------------删除失败-----------------");
        }
        MybatisUtils.closeSqlSession(sqlSession);
    }

    /**
     * 通过id和name查询
     * @throws IOException
     */
    @Test
    public void findCustomersByNameJobsTest() {
        SqlSession sqlSession=MybatisUtils.getSqlSession(false);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer=new Customer();
        customer.setUsername("四");
        customer.setJobs("软件测试员");
        List<Customer> customersByNameJobs = customerMapper.findCustomersByNameJobs(customer);
        for (Customer customer1:customersByNameJobs) {
            System.out.println(customer1);
        }
        MybatisUtils.closeSqlSession(sqlSession);
    }

    /**
     * 通过name或job或phone不为空查询
     * @throws IOException
     */
    @Test
    public void  findCustsByNameOrJobsOrPhoneTest() {
        SqlSession sqlSession=MybatisUtils.getSqlSession(false);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer=new Customer();
        //customer.setUsername("四");
        //customer.setJobs("软件测试");

        List<Customer> custsByNameOrJobsOrPhone = customerMapper.findCustsByNameOrJobsOrPhone(customer);
        for (Customer customer1:custsByNameOrJobsOrPhone) {
            System.out.println(customer1);
        }
        MybatisUtils.closeSqlSession(sqlSession);
    }

    /**
     * 修改客户信息测试方法（处理单个修改）
     * @throws IOException
     */
    @Test
    public void updateCustsNameOrJobOrPhoneTest()  {
        SqlSession sqlSession=MybatisUtils.getSqlSession(true);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        Customer customer=new Customer();
        customer.setUsername("王冰");
        customer.setId(9);
        int rows = customerMapper.updateCustsNameOrJobOrPhone(customer);
        if (rows>0){
            System.out.println("---------修改成功-----------");
        }
        else{
            System.out.println("---------修改失败-----------");
        }
        MybatisUtils.closeSqlSession(sqlSession);
    }

    /**
     * 通过多个id的记录
     * @throws IOException
     */
    @Test
    public  void  findCustsByIdsTest() {
        SqlSession sqlSession=MybatisUtils.getSqlSession(true);
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Integer> list=new ArrayList<>();
        list.add(3);
        list.add(5);
        List<Customer> custsByIds = customerMapper.findCustsByIds(list);
        for (Customer customer:custsByIds) {
            System.out.println(customer);
        }
    }

}
