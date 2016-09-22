package org.ibankapp.core.model;

import java.util.UUID;

import javax.annotation.Resource;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.ibankapp.base.persistence.IJpaDao;

/**
 * 公司客户实体类
 *
 *
 * @version        1.0.0, 16/09/22
 * @author         codelder
 */
@Entity
@Table(name = "CORE_CORPCUSTOMER")
public class CorpCustomer extends Customer {

    /** 用于jpa持久化数据操作对象 */
    @Resource
    private IJpaDao jpaDao;

    /**
     * 默认构造函数,生成不重复的UUID的哈希值
     *
     */
    public CorpCustomer() {
        while (true) {
            int    id  = Math.abs(UUID.randomUUID().hashCode());
            String sid = "2" + String.format("%011d", id);

            if (jpaDao.get(CorpCustomer.class, sid) == null) {
                this.setId(sid);

                break;
            }
        }
    }
}
