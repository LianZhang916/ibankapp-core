/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.service;

import org.ibankapp.base.validation.type.Idtp;
import org.ibankapp.core.customer.event.CorpCustomerRemovedEvent;
import org.ibankapp.core.customer.event.RetailCustomerRemovedEvent;
import org.ibankapp.core.customer.model.CorpCustomer;
import org.ibankapp.core.customer.model.Customer;
import org.ibankapp.core.customer.model.RetailCustomer;
import org.ibankapp.core.customer.repository.CorpCustomerRepository;
import org.ibankapp.core.customer.repository.RetailCustomerRepository;
import org.springframework.context.ApplicationContext;

import javax.annotation.Resource;

public class CustomerService implements ICustomerService {

    @Resource
    private CorpCustomerRepository corpCustomerRepository;

    @Resource
    private RetailCustomerRepository retailCustomerRepository;

    @Resource
    private ApplicationContext applicationContext;

    @Override
    public void createCorpCustomer(Idtp idtp, String idno, String name, String email, String mobile) {

        CorpCustomer customer = new CorpCustomer();

        createCustomer(customer, idtp, idno, name, email, mobile);

        createCorpCustomer(customer);
    }

    @Override
    public void createRetailCustomer(Idtp idtp, String idno, String name, String email, String mobile) {

        RetailCustomer customer = new RetailCustomer();

        createCustomer(customer, idtp, idno, name, email, mobile);

        createRetailCustomer(customer);
    }

    @Override
    public void createCorpCustomer(CorpCustomer customer) {
        corpCustomerRepository.save(customer);
    }

    @Override
    public void createRetailCustomer(RetailCustomer customer) {
        retailCustomerRepository.save(customer);
    }

    @Override
    public void removeCorpCustomer(String customerId) {
        CorpCustomer customer = corpCustomerRepository.findOne(customerId);
        corpCustomerRepository.delete(customerId);
        CorpCustomerRemovedEvent event = new CorpCustomerRemovedEvent(this);
        event.setCustomer(customer);
        applicationContext.publishEvent(event);
    }

    @Override
    public void removeRetailCustomer(String customerId) {
        RetailCustomer customer = retailCustomerRepository.findOne(customerId);
        retailCustomerRepository.delete(customerId);
        RetailCustomerRemovedEvent event = new RetailCustomerRemovedEvent(this);
        event.setCustomer(customer);
        applicationContext.publishEvent(event);
    }

    @Override
    public void removeAll() {
        retailCustomerRepository.deleteAll();
        corpCustomerRepository.deleteAll();
    }

    private <T extends Customer> T createCustomer(T customer, Idtp idtp, String idno, String name,
                                                  String email, String mobile) {

        customer.setName(name);
        customer.setMobile(mobile);
        customer.setEmail(email);
        customer.setIdno(idno);
        customer.setIdtp(idtp);

        return customer;
    }
}
