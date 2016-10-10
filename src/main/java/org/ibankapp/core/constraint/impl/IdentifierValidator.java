package org.ibankapp.core.constraint.impl;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.ibankapp.base.exception.BaseException;
import org.ibankapp.base.validation.IdentifierValidation;
import org.ibankapp.core.constraint.Identifier;
import org.ibankapp.core.type.Idtp;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class IdentifierValidator implements ConstraintValidator<Identifier, Object> {

    private String typeFieldName;
    private String numFieldName;

    @Override
    public void initialize(Identifier constraintAnnotation) {
        this.typeFieldName = constraintAnnotation.typefield();
        this.numFieldName = constraintAnnotation.numfield();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        try {
            final Idtp idtp= (Idtp) PropertyUtils.getProperty(value,typeFieldName);
            final String idno = BeanUtils.getProperty(value, numFieldName);

            if(idtp.equals(Idtp.IDCARD)){
                return IdentifierValidation.isIdCardNo(idno);
            }

            if(idtp.equals(Idtp.OCC)){
                return IdentifierValidation.isOcc(idno);
            }

            if(idtp.equals(Idtp.USCIC)){
                return IdentifierValidation.isUscic(idno);
            }
        } catch (Exception e){
            throw new BaseException("E-BASE-000001",e.getMessage());
        }

        return true;
    }
}
