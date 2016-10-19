/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.model;

import org.ibankapp.base.persistence.Model;
import org.ibankapp.core.constraint.Identifier;
import org.ibankapp.core.type.CustomerType;
import org.ibankapp.core.type.Idtp;
import org.ibankapp.core.type.RecordStatus;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * 客户实体类的超类
 *
 * @author codelder
 * @version 1.0.0, 16/09/20
 */
@Identifier(typefield = "idtp", codefield = "idno")
@MappedSuperclass
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
     * 客户状态
     */
    private RecordStatus status;

    /**
     * 客户类型
     */
    private CustomerType type;

    /**
     * 获取证件号码
     *
     * @return 证件号码
     */
    @Column(
            length = 64,
            nullable = false
    )
    @NotNull
    @Size(max = 64)
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
    @NotNull
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
    @NotNull
    @Size(max = 128)
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
     * 获取客户状态
     *
     * @return 客户状态
     */
    @Enumerated(EnumType.STRING)
    @Column(
            length = 16,
            nullable = false
    )
    @NotNull
    public RecordStatus getStatus() {
        return status;
    }

    /**
     * 设置客户状态
     *
     * @param status 客户状态
     */
    public void setStatus(RecordStatus status) {
        this.status = status;
    }

    /**
     * 获取客户类型
     *
     * @return 客户类型
     */
    @Transient
    @NotNull
    public CustomerType getType() {
        return type;
    }

    /**
     * 设置客户类型
     *
     * @param type 客户类型
     */
    public void setType(CustomerType type) {
        this.type = type;
    }

    /**
     * 根据当前的纳秒时间生成16位客户id
     *
     * @return 客户id
     */
    @Override
    public String generateId() {
        return String.format("%16d", System.nanoTime() / 1000);
    }
}