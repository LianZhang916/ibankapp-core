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
@Identifier(typefield = "idtp",numfield = "idno")
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
     * 邮箱地址
     */
    private String email;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 客户密码
     */
    private String password;

    /**
     * 客户状态
     */
    private RecordStatus status;

    /**
     * 客户类型
     */
    private CustomerType type;

    /**
     * 默认构造函数,将当前时间的微秒数作为客户号
     */
    public Customer() {
        this.setId(String.format("%16d", System.nanoTime()/1000));
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
     * 获取客户密码
     *
     * @return 客户密码
     */
    @Column(
            length = 32,
            nullable = false
    )
    @NotNull
    @Size(max = 32)
    public String getPassword() {
        return password;
    }

    /**
     * 设置客户密码
     *
     * @param password 客户密码
     */
    public void setPassword(String password) {
        this.password = password;
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
}