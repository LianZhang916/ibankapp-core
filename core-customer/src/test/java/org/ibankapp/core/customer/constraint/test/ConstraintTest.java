/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.constraint.test;

import org.ibankapp.base.exception.BaseException;
import org.ibankapp.base.persistence.repository.JpaRepository;
import org.ibankapp.base.validation.type.Idtp;
import org.ibankapp.core.customer.configure.test.TestConfigContext;
import org.ibankapp.core.customer.model.Customer;
import org.ibankapp.core.customer.service.ICustomerService;
import org.ibankapp.core.customer.type.CustomerType;
import org.junit.After;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestConfigContext.class})
public class ConstraintTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Resource
    private ICustomerService customerService;
    @Resource
    private JpaRepository repository;

    @After
    public void clear() {
        repository.deleteAll(Customer.class);
    }

    @Test
    public void testValidator() {

        thrown.expect(BaseException.class);
        thrown.expectMessage("证件类型与客户类型不匹配");
        thrown.expectMessage("证件号码不合法");

        customerService.createCustomer(CustomerType.CORP, Idtp.IDCARD, "911202246818640656", "交行",
                "wangyued@126.com", "13901171063");
    }

    @Test
    public void testValidator1() {

        thrown.expect(BaseException.class);
        thrown.expectMessage("证件类型与客户类型不匹配");

        customerService.createCustomer(CustomerType.RETIAL,Idtp.USCIC, "911202246818640656", "交行",
                "wangyued@126.com", "13901171063");
    }

    @Test
    public void testValidator2() {

        thrown.expect(BaseException.class);
        thrown.expectMessage("证件类型与客户类型不匹配");

        customerService.createCustomer(CustomerType.CORP, Idtp.PASSPORT, "911202246818640656", "交行",
                "wangyued@126.com", "13901171063");
    }

    @Test
    public void testValidator3() {

        thrown.expect(BaseException.class);
        thrown.expectMessage("证件类型与客户类型不匹配");
        thrown.expectMessage("证件号码不合法");

        customerService.createCustomer(CustomerType.RETIAL,Idtp.OCC,"911202246818640656", "交行",
                "wangyued@126.com", "13901171063");
    }

}
