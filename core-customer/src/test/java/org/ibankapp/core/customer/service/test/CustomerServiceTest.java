/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.service.test;

import org.ibankapp.base.persistence.repository.JpaRepository;
import org.ibankapp.base.validation.type.Idtp;
import org.ibankapp.core.customer.configure.test.TestConfigContext;
import org.ibankapp.core.customer.model.CorpCustomer;
import org.ibankapp.core.customer.model.Customer;
import org.ibankapp.core.customer.service.ICustomerService;
import org.ibankapp.core.customer.specification.CustomerSpecification;
import org.ibankapp.core.customer.type.CustomerType;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import javax.annotation.Resource;


/**
 * 客户信息服务测试类
 *
 * @author codelder
 * @version 1.0.0, 16/09/22
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfigContext.class})
public class CustomerServiceTest {

    @Resource
    private ICustomerService customerService;

    @Resource
    private JpaRepository repository;

    @After
    public void clear() {
        repository.deleteAll(Customer.class);
    }

    @Test
    @Transactional
    public void testCreateCorpCustomer() {
        customerService.createCustomer(CustomerType.CORP, Idtp.USCIC, "911202246818640656", "交行",
                "wangyued@126.com", "13901171063");
        List<Customer> customers = repository.findAll(Customer.class);
        Assert.assertEquals(1, customers.size());

    }

    @Test
    @Transactional
    public void testCreateRetailCustomer() {
        customerService.createCustomer(CustomerType.RETIAL, Idtp.IDCARD, "130404197602293014", "交行",
                "wangyued@126.com", "13901171063");
    }

    @Test
    @Transactional
    public void testRemoveCustomer() {
        testCreateCorpCustomer();
        List<Customer> customers = repository.findAll(Customer.class);
        String id = customers.get(0).getId();
        customerService.removeCustomer(id);
        customers = repository.findAll(Customer.class);
        Assert.assertEquals(0, customers.size());
    }

    @Test
    @Transactional
    public void testGetCustomers() {

        CustomerType customerType = CustomerType.CORP;

        customerService.createCustomer(customerType, Idtp.USCIC, "911202246818640656", "交行",
                "wangyued@126.com", "13901171063");

        customerService.createCustomer(CustomerType.RETIAL, Idtp.IDCARD, "130404197602293014", "交通银行",
                "wangyued@126.com", "13901171063");

        Customer customer = new Customer();
        customer.setIdno("3014");

        CustomerSpecification<Customer> customerSpecification = new CustomerSpecification<>(customer);
        List<Customer> customers = customerService.getCustomers(Customer.class, customerSpecification, null);

        Assert.assertEquals(1, customers.size());

        customer = new Customer();
        customer.setMobile("1063");

        customerSpecification = new CustomerSpecification<>(customer);
        customers = customerService.getCustomers(Customer.class, customerSpecification, null);

        Assert.assertEquals(2, customers.size());

        customer.setName("交");

        customerSpecification = new CustomerSpecification<>(customer);
        customers = customerService.getCustomers(Customer.class, customerSpecification, null);

        Assert.assertEquals(2, customers.size());

        customer.setEmail("wangyue");

        customerSpecification = new CustomerSpecification<>(customer);
        customers = customerService.getCustomers(Customer.class, customerSpecification, null);

        Assert.assertEquals(2, customers.size());

        customer.setName("交通");

        customerSpecification = new CustomerSpecification<>(customer);
        customers = customerService.getCustomers(Customer.class, customerSpecification, null);

        Assert.assertEquals(1, customers.size());

        Idtp idtp = Idtp.IDCARD;

        customer.setIdtp(idtp);

        customerSpecification = new CustomerSpecification<>(customer);
        customers = customerService.getCustomers(Customer.class, customerSpecification, null);

        Assert.assertEquals(1, customers.size());

        customer.setIdtp(Idtp.USCIC);

        customerSpecification = new CustomerSpecification<>(customer);
        customers = customerService.getCustomers(Customer.class, customerSpecification, null);

        Assert.assertEquals(0, customers.size());

        CorpCustomer corpCustomer = new CorpCustomer();
        customer.setMobile("1063");

        CustomerSpecification<CorpCustomer> corpCustomerCustomerSpecification = new CustomerSpecification<>(corpCustomer);
        List<CorpCustomer> corpcustomers = customerService.getCustomers(CorpCustomer.class,
                corpCustomerCustomerSpecification, null);
        Assert.assertEquals(1, corpcustomers.size());

    }

}