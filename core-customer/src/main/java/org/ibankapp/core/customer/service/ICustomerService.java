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
import org.ibankapp.core.customer.model.CorpCustomer;
import org.ibankapp.core.customer.model.RetailCustomer;

public interface ICustomerService {

    void createCorpCustomer(Idtp idtp, String idno, String name, String email, String mobile);

    void createRetailCustomer(Idtp idtp, String idno, String name, String email, String mobile);

    void createCorpCustomer(CorpCustomer customer);

    void createRetailCustomer(RetailCustomer customer);

    void removeCorpCustomer(String customerId);

    void removeRetailCustomer(String customerId);

    void removeAll();

}
