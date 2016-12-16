/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.event;

import org.ibankapp.core.customer.model.RetailCustomer;
import org.springframework.context.ApplicationEvent;

public class RetailCustomerRemovedEvent extends ApplicationEvent {

    private RetailCustomer customer;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public RetailCustomerRemovedEvent(Object source) {
        super(source);
    }

    public RetailCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(RetailCustomer customer) {
        this.customer = customer;
    }
}
