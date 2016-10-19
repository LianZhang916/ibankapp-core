/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.dao;

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
public interface ICustomerDao {

    /**
     * 新增客户
     *
     * @param customer 客户信息对象
     */
    void createCustomer(Customer customer);

    /**
     * 新增客户
     *
     * @param type     客户类型
     * @param idtp     证件种类
     * @param idno     证件号码
     * @param name     客户名称
     */
    void createCustomer(CustomerType type, Idtp idtp, String idno, String name);

    /**
     * 获取指定客户类型的所有客户信息
     *
     * @param type 客户类型
     * @return 客户信息列表
     */
    List<Customer> getAllCustomers(CustomerType type);

    /**
     * 获取jpa持久化数据操作对象
     *
     * @return jpa持久化数据操作对象
     */
    IJpaDao getJpaDao();

    /**
     * 设置jpa持久化数据操作对象
     *
     * @param jpaDao jpa持久化数据操作对象
     */
    void setJpaDao(IJpaDao jpaDao);

    /**
     * 生成新的客户信息ID
     *
     * @return 客户信息ID
     */
    String getNewCustomerId();
}
