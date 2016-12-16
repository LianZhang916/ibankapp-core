/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.service.test;

import org.ibankapp.base.validation.type.Idtp;
import org.ibankapp.core.customer.configure.test.TestConfigContext;
import org.ibankapp.core.customer.service.ICustomerService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

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

    @After
    public void clear() {
        customerService.removeAll();
    }

    @Test
    public void testCreateCorpCustomer() {
        customerService.createCorpCustomer(Idtp.USCIC, "911202246818640656", "交行",
                "wangyued@126.com", "13901171063");
    }

    @Test
    public void testCreateRetailCustomer() {
        customerService.createRetailCustomer(Idtp.IDCARD, "130404197602293014", "交行",
                "wangyued@126.com", "13901171063");
    }

}