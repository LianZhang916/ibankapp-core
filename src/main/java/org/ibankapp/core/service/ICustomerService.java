package org.ibankapp.core.service;

import java.util.List;

import org.ibankapp.base.persistence.IJpaDao;
import org.ibankapp.core.model.Customer;
import org.ibankapp.core.type.CustomerType;
import org.ibankapp.core.type.Idtp;

/**
 * 客户信息服务接口
 *
 * @author codelder
 * @version 1.0.0, 16/09/22
 */
public interface ICustomerService {

    /**
     * 新增客户
     *
     * @param customer 客户对象
     */
    @SuppressWarnings("unused")
    void addCustomer(Customer customer);

    /**
     * 新增客户
     *
     * @param type     客户类型
     * @param idtp     证件种类
     * @param idno     证件号码
     * @param name     客户名称
     * @param password 密码
     */
    @SuppressWarnings("unused")
    void addCustomer(CustomerType type, Idtp idtp, String idno, String name, String password);

    /**
     * 获取指定客户类型的所有客户信息
     *
     * @param type 客户类型
     * @return 客户信息列表
     */
    @SuppressWarnings("unused")
    List<Customer> getAllCustomers(CustomerType type);

    /**
     * 获取jpa持久化数据操作对象
     *
     * @return jpa持久化数据操作对象
     */
    @SuppressWarnings("unused")
    IJpaDao getJpaDao();

    /**
     * 设置jpa持久化数据操作对象
     *
     * @param jpaDao jpa持久化数据操作对象
     */
    @SuppressWarnings("unused")
    void setJpaDao(IJpaDao jpaDao);

    /**
     * 生成新的客户信息ID
     *
     * @return 客户信息ID
     */
    String getNewCustomerId();
}
