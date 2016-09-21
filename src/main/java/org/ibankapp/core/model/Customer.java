package org.ibankapp.core.model;

import javax.persistence.MappedSuperclass;

import org.ibankapp.base.persistence.Model;

/**
 * 客户实体类的超类
 *
 *
 * @version        1.0.0, 16/09/20
 * @author         codelder
 */
@MappedSuperclass
public class Customer extends Model {

    /** 证件种类 */
    private String idtp;

    /** 证件号码 */
    private String idno;

    /** 客户姓名 */
    private String name;
}


//~ Formatted by Jindent --- http://www.jindent.com
