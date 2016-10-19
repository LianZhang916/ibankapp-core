/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.dao.imp;

import java.util.List;

import javax.annotation.Resource;

import org.ibankapp.base.persistence.IJpaDao;
import org.ibankapp.core.model.CorpCustomer;
import org.ibankapp.core.model.Customer;
import org.ibankapp.core.model.RetailCustomer;
import org.ibankapp.core.dao.ICustomerDao;
import org.ibankapp.core.type.CustomerType;
import org.ibankapp.core.type.Idtp;

/**
 * 默认客户信息服务类
 *
 * @author codelder
 * @version 1.0.0, 16/09/26
 */
public class DefaultCustomerDao implements ICustomerDao {

    /**
     * jpa持久化数据操作对象
     */
    @Resource
    private IJpaDao jpaDao;

    @Override
    public void createCustomer(Customer customer) {

        if (customer != null && customer.getType().equals(CustomerType.RETIAL)) {
            if (((RetailCustomer) customer).getEmail() == null) {
                jpaDao.query("from RetailCustomer where email='" + ((RetailCustomer) customer).getEmail() + "'").
                        getResultList().size();

            }
        }
        jpaDao.persist(customer);
    }

    @Override
    public void createCustomer(CustomerType type, Idtp idtp, String idno, String name) {
        Customer customer;

        if (type.equals(CustomerType.CORP)) {
            customer = new CorpCustomer();
        } else {
            customer = new RetailCustomer();
        }

        customer.setIdtp(idtp);
        customer.setIdno(idno);
        customer.setName(name);
        createCustomer(customer);
    }

    @Override
    public List<Customer> getAllCustomers(CustomerType type) {
        String jpql;

        if (type.equals(CustomerType.CORP)) {
            jpql = "from CorpCustomer";
        } else {
            jpql = "from RetailCustomer";
        }

        @SuppressWarnings("unchecked")
        List<Customer> customers = (List<Customer>) jpaDao.query(jpql).getResultList();

        return customers;
    }

    @Override
    public IJpaDao getJpaDao() {
        return jpaDao;
    }

    @Override
    public void setJpaDao(IJpaDao jpaDao) {
        this.jpaDao = jpaDao;
    }

    @Override
    public String getNewCustomerId() {
        return String.format("%16d", System.nanoTime());
    }
}
