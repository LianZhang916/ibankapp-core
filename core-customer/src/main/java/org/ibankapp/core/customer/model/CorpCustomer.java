/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.model;

import org.ibankapp.base.validation.type.Idtp;
import org.ibankapp.core.customer.constraint.CustomerIdtp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;

/**
 * 公司客户实体类
 *
 * @author codelder
 * @version 1.0.0, 16/09/22
 */
@Entity
@DiscriminatorValue("CORP")
public class CorpCustomer extends Customer {

    @Override
    @CustomerIdtp(type = CorpCustomer.class)
    @Column(
            length = 16,
            nullable = false,
            insertable = false,
            updatable = false
    )
    @Enumerated(EnumType.STRING)
    @NotNull(message = "证件种类不能为空")
    public Idtp getIdtp() {
        return super.getIdtp();
    }
}
