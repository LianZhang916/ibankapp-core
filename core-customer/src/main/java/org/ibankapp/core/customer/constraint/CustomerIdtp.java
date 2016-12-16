/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.constraint;

import org.ibankapp.core.customer.constraint.impl.IdtpValidator;
import org.ibankapp.core.customer.type.CustomerType;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({METHOD, FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = IdtpValidator.class)
@Documented
public @interface CustomerIdtp {

    String message() default "{constraints.customerIdtp}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    CustomerType type();

}
