/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.test;

import org.ibankapp.base.persistence.DefaultJpaDaoImpl;
import org.ibankapp.base.persistence.IJpaDao;
import org.ibankapp.core.model.CorpCustomer;
import org.ibankapp.core.model.Customer;
import org.ibankapp.core.dao.ICustomerDao;
import org.ibankapp.core.dao.imp.DefaultCustomerDao;
import org.ibankapp.core.type.Idtp;
import org.ibankapp.core.type.RecordStatus;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 客户信息服务测试类
 *
 * @author codelder
 * @version 1.0.0, 16/09/22
 */
public class CustomerServiceTest {

    /**
     * jpa实体管理器
     */
    private IJpaDao jpaDao;

    /**
     * 测试按必输项添加客户
     */
    @Test
    public void addCustomerNotNullTest() {
        Customer customer = new CorpCustomer();

        jpaDao.beginTrans();
        customer.setIdtp(Idtp.IDCARD);
        customer.setIdno("130404197602293014");
        customer.setName("wangyue");
        customer.setStatus(RecordStatus.NORMAL);

        ICustomerDao customerService = new DefaultCustomerDao();

        customerService.setJpaDao(jpaDao);
        customerService.createCustomer(customer);

        jpaDao.commitTrans();

        List customers = jpaDao.query("from CorpCustomer").getResultList();

        assertEquals(1,customers.size());
        CorpCustomer customer1 = (CorpCustomer)customers.get(0);

        assertEquals(16,customer1.getId().length());
    }

    /**
     * 从实体管理工厂中创建实体管理器并将实体管理器注入到测试类中
     */
    @Before
    public void setJpaDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ibankapp");
        EntityManager entityManager = factory.createEntityManager();

        IJpaDao jpaDao = new DefaultJpaDaoImpl();

        jpaDao.setEntityManager(entityManager);

        this.jpaDao = jpaDao;
    }
}
