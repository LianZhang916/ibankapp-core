/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.service;

import org.ibankapp.base.persistence.domain.Sort;
import org.ibankapp.base.persistence.repository.JpaRepository;
import org.ibankapp.base.validation.type.Idtp;
import org.ibankapp.core.customer.model.Customer;
import org.ibankapp.core.customer.specification.CustomerSpecification;

import java.util.List;

import javax.annotation.Resource;

public class CustomerService implements ICustomerService {

    @Resource
    private JpaRepository repository;

    @Override
    public <T extends Customer> void createCustomer(Class<T> entityClass, Idtp idtp, String idno, String name, String
            email, String mobile) {

        Customer customer;

        try {
            customer = entityClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }

        customer.setName(name);
        customer.setMobile(mobile);
        customer.setEmail(email);
        customer.setIdno(idno);
        customer.setIdtp(idtp);

        createCustomer(customer);
    }

    @Override
    public <T extends Customer> void createCustomer(T customer) {
        repository.persist(customer);
    }

    @Override
    public <T extends Customer> void updateCustomer(T customer) {
        repository.merge(customer);
    }

    @Override
    public void removeCustomer(String customerId) {
        repository.delete(Customer.class, customerId);
    }

    //    @Override
    public <T extends Customer> List<T> getCustomers(Class<T> entityClass, CustomerSpecification<T> spec, Sort sort) {

        return repository.findAll(entityClass, spec, sort);
    }

    @Override
    public <T extends Customer> T getCustomer(Class<T> entityClass, String customerId) {

        return repository.findOne(entityClass, customerId);

    }


}
