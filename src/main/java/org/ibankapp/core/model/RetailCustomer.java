package org.ibankapp.core.model;

import org.ibankapp.core.type.CustomerType;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 零售客户实体类
 *
 * @author codelder
 * @version 1.0.0, 16/09/22
 */
@Entity
@Table(name = "CORE_RETAILCUSTOMER")
public class RetailCustomer extends Customer {

    @Override
    public CustomerType getType() {
        return CustomerType.RETIAL;
    }

    @Override
    public void setType(CustomerType type) {
        super.setType(CustomerType.RETIAL);
    }
}