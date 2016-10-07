package org.ibankapp.core.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.ibankapp.core.type.CustomerType;

/**
 * 公司客户实体类
 *
 * @author codelder
 * @version 1.0.0, 16/09/22
 */
@Entity
@Table(name = "CORE_CORPCUSTOMER")
public class CorpCustomer extends Customer {

    public CorpCustomer(){
        super();
        this.setType(CustomerType.CORP);
    }

//    @Override
//    public CustomerType getType() {
//        return CustomerType.CORP;
//    }
//
//    @Override
//    public void setType(CustomerType type) {
//        super.setType(CustomerType.CORP);
//    }
}
