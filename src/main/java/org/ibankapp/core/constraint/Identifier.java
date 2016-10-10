package org.ibankapp.core.constraint;

import org.ibankapp.core.constraint.impl.IdentifierValidator;
import org.ibankapp.core.type.Idtp;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * Annotation type description
 */
@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = IdentifierValidator.class)
@Documented
public @interface Identifier {
    String message() default "{constraints.identifier}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String typefield();

    String numfield();

    @Target({TYPE, ANNOTATION_TYPE})
    @Retention(RUNTIME)
    @Documented
    @interface List {
        Identifier[] value();
    }
}
