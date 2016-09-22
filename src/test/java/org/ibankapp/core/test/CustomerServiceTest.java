package org.ibankapp.core.test;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

/**
 * 客户信息服务测试类
 *
 *
 * @version        1.0.0, 16/09/22
 * @author         codelder
 */
public class CustomerServiceTest {

    /**
     * 新增客户测试方法
     *
     */
    @Test
    public void addCustomerTest() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ibankapp");
    }
}