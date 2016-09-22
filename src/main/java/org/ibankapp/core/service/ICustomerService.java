package org.ibankapp.core.service;

import org.ibankapp.core.model.Customer;
import org.ibankapp.core.type.CustomerType;
import org.ibankapp.core.type.Idtp;

/**
 * 客户信息服务接口
 *
 *
 * @version        1.0.0, 16/09/22
 * @author         codelder
 */
public interface ICustomerService {

    /**
     * 新增客户
     *
     *
     * @param customer 客户对象
     */
    void addCustomer(Customer customer);

    /**
     * 新增客户
     *
     *
     * @param type 客户类型
     * @param idtp 证件种类
     * @param idno 证件号码
     * @param name 客户名称
     * @param password 密码
     */
    void addCustomer(CustomerType type, Idtp idtp, String idno, String name, String password);
}
