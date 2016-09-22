package org.ibankapp.core.model;

import org.ibankapp.base.persistence.IJpaDao;

import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

/**
 * 零售客户实体类
 *
 *
 * @version        1.0.0, 16/09/22
 * @author         codelder
 */
@Entity
@Table(name = "CORE_RETAILCUSTOMER")
public class RetailCustomer extends Customer {

    /** 用于jpa持久化数据操作对象 */
    @Resource
    private IJpaDao jpaDao;

    /**
     * 默认构造函数,生成不重复的UUID的哈希值
     *
     */
    public RetailCustomer() {
        while (true) {
            int    id  = Math.abs(UUID.randomUUID().hashCode());
            String sid = "1" + String.format("%011d", id);

            if (jpaDao.get(RetailCustomer.class, sid) == null) {
                this.setId(sid);
                break;
            }
        }
    }
}
