/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.event;

import org.ibankapp.core.customer.model.CorpCustomer;
import org.springframework.context.ApplicationEvent;

public class CorpCustomerRemovedEvent extends ApplicationEvent {

    private CorpCustomer customer;

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public CorpCustomerRemovedEvent(Object source) {
        super(source);
    }

    public CorpCustomer getCustomer() {
        return customer;
    }

    public void setCustomer(CorpCustomer customer) {
        this.customer = customer;
    }
}
