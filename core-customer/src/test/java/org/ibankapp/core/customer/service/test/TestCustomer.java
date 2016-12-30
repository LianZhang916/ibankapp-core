/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.service.test;

import org.ibankapp.core.customer.model.Customer;

import javax.persistence.Entity;

@Entity
public class TestCustomer extends Customer {

    private String id;

    public TestCustomer(String id){
        this.id = id;
    }

}
