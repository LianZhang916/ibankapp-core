package org.ibankapp.core.test;

import org.ibankapp.base.persistence.IJpaDao;
import org.ibankapp.base.persistence.JpaDaoImpl;
import org.ibankapp.core.model.CorpCustomer;
import org.ibankapp.core.model.Customer;
import org.ibankapp.core.service.ICustomerService;
import org.ibankapp.core.service.impl.DefaultCustomerService;
import org.ibankapp.core.type.CustomerType;
import org.ibankapp.core.type.Idtp;
import org.ibankapp.core.type.RecordStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

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
        customer.setPassword("123456");
        customer.setName("wangyue");
        customer.setStatus(RecordStatus.NORMAL);

        ICustomerService customerService = new DefaultCustomerService();

        customerService.setJpaDao(jpaDao);
        customerService.addCustomer(customer);

        List<Customer> customers = customerService.getAllCustomers(CustomerType.CORP);

        Assert.assertNotNull(customers);
        Assert.assertEquals(1, customers.size());

        customer = customers.get(0);

        Assert.assertNull(customer.getEmail());
        Assert.assertEquals("130404197602293014", customer.getIdno());
        Assert.assertNotNull(customer.getId());
        Assert.assertEquals(16, customer.getId().length());
        Assert.assertEquals(Idtp.IDCARD, customer.getIdtp());
        Assert.assertNull(customer.getMobile());
        Assert.assertEquals("wangyue", customer.getName());
        Assert.assertEquals("123456",customer.getPassword());
        Assert.assertEquals(CustomerType.CORP,customer.getType());

        jpaDao.commitTrans();
    }

    /**
     * 测试客户ID号重复时的报错
     */
    @Test(expected = EntityExistsException.class)
    public void addCustomerIdDupTest() {

        Customer customer = new CorpCustomer();

        jpaDao.beginTrans();
        customer.setIdtp(Idtp.IDCARD);
        customer.setIdno("130404197602293014");
        customer.setPassword("123456");
        customer.setName("wangyue");
        customer.setStatus(RecordStatus.NORMAL);

        String id = customer.getId();

        ICustomerService customerService = new DefaultCustomerService();

        customerService.setJpaDao(jpaDao);
        customerService.addCustomer(customer);
        customer = new CorpCustomer();
        customer.setId(id);
        customer.setIdtp(Idtp.IDCARD);
        customer.setIdno("130404197602293014");
        customer.setPassword("123456");
        customer.setName("wangyue");
        customer.setStatus(RecordStatus.NORMAL);
        customerService.addCustomer(customer);

        jpaDao.commitTrans();
    }

    /**
     * 从实体管理工厂中创建实体管理器并将实体管理器注入到测试类中
     */
    @Before
    public void setJpaDao() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("ibankapp");
        EntityManager entityManager = factory.createEntityManager();

        IJpaDao jpaDao = new JpaDaoImpl();

        jpaDao.setEntityManager(entityManager);

        this.jpaDao = jpaDao;
    }
}
