/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.constraint.impl;

import org.ibankapp.base.validation.type.Idtp;
import org.ibankapp.core.customer.constraint.CustomerIdtp;
import org.ibankapp.core.customer.type.CustomerType;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.ibankapp.base.validation.type.Idtp.IDCARD;
import static org.ibankapp.base.validation.type.Idtp.OCC;
import static org.ibankapp.base.validation.type.Idtp.PASSPORT;
import static org.ibankapp.base.validation.type.Idtp.USCIC;

public class IdtpValidator implements ConstraintValidator<CustomerIdtp,Idtp> {

    private CustomerType type;

    @Override
    public void initialize(CustomerIdtp constraintAnnotation) {
        this.type = constraintAnnotation.type();
    }

    @Override
    public boolean isValid(Idtp value, ConstraintValidatorContext context) {
        if (type.equals(CustomerType.RETIAL))
            return value.equals(IDCARD) || value.equals(PASSPORT);
        else
            return type.equals(CustomerType.CORP) && (value.equals(OCC) || value.equals(USCIC));
    }
}
