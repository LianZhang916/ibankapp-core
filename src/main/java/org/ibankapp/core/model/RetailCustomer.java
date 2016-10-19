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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Size;

/**
 * 零售客户实体类
 *
 * @author codelder
 * @version 1.0.0, 16/09/22
 */
@Entity
@Table(name = "CORE_RETAILCUSTOMER", uniqueConstraints = @UniqueConstraint(columnNames = {"idtp", "idno"}))
public class RetailCustomer extends Customer {

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    public RetailCustomer() {
        super();
        this.setType(CustomerType.RETIAL);
    }

    /**
     * 获取邮箱地址
     *
     * @return 邮箱地址
     */
    @Column(length = 128)
    @Size(max = 128)
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱地址
     *
     * @param email 邮箱地址
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取手机号码
     *
     * @return 手机号码
     */
    @Column(length = 20)
    @Size(max = 20)
    public String getMobile() {
        return mobile;
    }

    /**
     * 设置手机号码
     *
     * @param mobile 手机号码
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}