package org.ibankapp.core.model;

import javax.persistence.MappedSuperclass;

/**
 * 客户实体类的超类
 *
 *
 * @version        1.0.0, 16/09/20
 * @author         codelder
 */
@MappedSuperclass
public class Customer {

    /** Field description */
    private String idtp;

    /** Field description */
    private String idno;
}
