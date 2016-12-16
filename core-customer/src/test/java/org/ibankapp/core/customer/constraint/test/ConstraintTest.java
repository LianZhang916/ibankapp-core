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
import org.ibankapp.base.validation.type.Idtp;
import org.ibankapp.core.customer.configure.test.TestConfigContext;
import org.ibankapp.core.customer.service.ICustomerService;
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

    @Resource
    private ICustomerService customerService;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @After
    public void clear() {
        customerService.removeAll();
    }

    @Test
    public void testValidator() {

        thrown.expect(BaseException.class);
        thrown.expectMessage("证件类型与客户类型不匹配");
        thrown.expectMessage("证件号码不合法");

        customerService.createCorpCustomer(Idtp.IDCARD, "911202246818640656", "交行",
                "wangyued@126.com", "13901171063");
    }

}
