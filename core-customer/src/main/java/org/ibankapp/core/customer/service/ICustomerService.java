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
import org.ibankapp.base.validation.type.Idtp;
import org.ibankapp.core.customer.model.Customer;
import org.ibankapp.core.customer.specification.CustomerSpecification;

import java.util.List;

public interface ICustomerService {

    <T extends Customer> void createCustomer(Class<T> entityClass, Idtp idtp, String idno, String name, String email,
                                             String mobile);

    <T extends Customer> void createCustomer(T customer);

    <T extends Customer> void updateCustomer(T customer);

    void removeCustomer(String customerId);

    <T extends Customer> List<T> getCustomers(Class<T> entityClass, CustomerSpecification<T> spec, Sort sort);

    <T extends Customer> T getCustomer(Class<T> entityClass, String customerId);
}
