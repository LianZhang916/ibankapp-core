package org.ibankapp.core.service.impl;

import org.ibankapp.base.persistence.IJpaDao;
import org.ibankapp.core.model.CorpCustomer;
import org.ibankapp.core.model.Customer;
import org.ibankapp.core.model.RetailCustomer;
import org.ibankapp.core.service.ICustomerService;
import org.ibankapp.core.type.CustomerType;
import org.ibankapp.core.type.Idtp;

import javax.annotation.Resource;
import java.util.List;

/**
 * 默认客户信息服务类
 *
 * @author codelder
 * @version 1.0.0, 16/09/26
 */
public class DefaultCustomerService implements ICustomerService {

    /**
     * jpa持久化数据操作对象
     */
    @Resource
    private IJpaDao jpaDao;

    @Override
    public void addCustomer(Customer customer) {
        jpaDao.persist(customer);
    }

    @Override
    public void addCustomer(CustomerType type, Idtp idtp, String idno, String name, String password) {
        Customer customer;

        if (type.equals(CustomerType.CORP)) {
            customer = new CorpCustomer();
        } else {
            customer = new RetailCustomer();
        }

        customer.setIdtp(idtp);
        customer.setIdno(idno);
        customer.setName(name);
        customer.setPassword(password);
        jpaDao.persist(customer);
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
        List<Customer> customers = (List<Customer>) jpaDao.createQuery(jpql);

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
