/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.specification;

import org.ibankapp.base.util.StringUtil;
import org.ibankapp.core.customer.model.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;


public class CustomerSpecification {

    private CustomerSpecification(){

    }

    public static <T extends Customer> Specification<T> Criteria(T customer){

        return (root, query, cb) -> {

            Predicate predicate = cb.conjunction();

            if(!StringUtil.isEmpty(customer.getIdno())){
                predicate = cb.and(predicate,cb.like(root.get("idno"),"%"+customer.getIdno()+"%"));
            }

            if(!StringUtil.isEmpty(customer.getName())){
                predicate = cb.and(predicate,cb.like(root.get("name"),"%"+customer.getName()+"%"));
            }

            if(!StringUtil.isEmpty(customer.getEmail())){
                predicate = cb.and(predicate,cb.like(root.get("email"),"%"+customer.getEmail()+"%"));
            }

            if(!StringUtil.isEmpty(customer.getMobile())){
                predicate = cb.and(predicate,cb.like(root.get("mobile"),"%"+customer.getMobile()+"%"));
            }

            if(customer.getIdtp()!=null){
                predicate = cb.and(predicate,cb.equal(root.get("idtp"),customer.getIdtp()));
            }

            return predicate;

        };
    }
}
