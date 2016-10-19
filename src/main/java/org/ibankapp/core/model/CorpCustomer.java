/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.model;

import org.ibankapp.core.type.CustomerType;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * 公司客户实体类
 *
 * @author codelder
 * @version 1.0.0, 16/09/22
 */
@Entity
@Table(name = "CORE_CORPCUSTOMER", uniqueConstraints = @UniqueConstraint(columnNames = {"idtp", "idno"}))
public class CorpCustomer extends Customer {

    public CorpCustomer() {
        super();
        this.setType(CustomerType.CORP);
    }
}
