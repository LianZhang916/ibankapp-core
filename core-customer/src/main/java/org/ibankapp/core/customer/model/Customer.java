/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.model;

import org.ibankapp.base.persistence.model.Model;
import org.ibankapp.base.validation.constraint.Identifier;
import org.ibankapp.base.validation.constraint.Unique;
import org.ibankapp.base.validation.constraint.Uniques;
import org.ibankapp.base.validation.type.Idtp;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Inheritance;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 客户实体类的超类
 *
 * @author codelder
 * @version 1.0.0, 16/09/20
 */
@Entity
@Identifier(typefield = "idtp", codefield = "idno")
@Uniques(constraints = {@Unique(properties = "email", message = "该邮箱已被注册"),
        @Unique(properties = "mobile", message = "该手机已被注册"),
        @Unique(properties = {"idtp", "idno"}, message = "该证件已被注册")})
@Inheritance
@DiscriminatorColumn(name = "type")
public class Customer extends Model {

    /**
     * 证件种类
     */
    private Idtp idtp;

    /**
     * 证件号码
     */
    private String idno;

    /**
     * 客户名称
     */
    private String name;

    /**
     * 邮箱地址
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    @Override
    public String generateId() {
        return String.format("%16d", System.nanoTime() / 1000);
    }

    /**
     * 获取证件号码
     *
     * @return 证件号码
     */
    @Column(
            length = 64,
            nullable = false
    )
    @NotNull(message = "证件号码不能为空")
    @Size(max = 64, message = "证件号码不能超过64个字符")
    public String getIdno() {
        return idno;
    }

    /**
     * 设置证件号码
     *
     * @param idno 证件号码
     */
    public void setIdno(String idno) {
        this.idno = idno;
    }

    /**
     * 获取证件种类
     *
     * @return 证件种类
     */
    @Enumerated(EnumType.STRING)
    @Column(
            length = 16,
            nullable = false
    )
    @NotNull(message = "证件种类不能为空")
    public Idtp getIdtp() {
        return idtp;
    }

    /**
     * 设置证件种类
     *
     * @param idtp 证件种类
     */
    public void setIdtp(Idtp idtp) {
        this.idtp = idtp;
    }

    /**
     * 获取客户名称
     *
     * @return 客户名称
     */
    @Column(
            length = 128,
            nullable = false
    )
    @NotNull(message = "客户姓名不能为空")
    @Size(max = 128, message = "客户名称不能超过128个字符")
    public String getName() {
        return name;
    }

    /**
     * 设置客户名称
     *
     * @param name 客户名称
     */
    public void setName(String name) {
        this.name = name;
    }


    /**
     * 获取邮箱地址
     *
     * @return 邮箱地址
     */
    @Column(length = 128)
    @Size(max = 128, message = "邮箱地址不能超过128个字符")
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
    @Size(max = 20, message = "手机号码不能超过20个字符")
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