/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.specification;

import org.ibankapp.base.persistence.domain.Specification;
import org.ibankapp.base.util.StringUtils;
import org.ibankapp.core.customer.model.Customer;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;


public class CustomerSpecification<T extends Customer> implements Specification<T> {

    private T customer;

    public CustomerSpecification(T customer) {

        this.customer = customer;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        Predicate predicate = cb.conjunction();

        if (!StringUtils.isEmpty(customer.getIdno())) {
            predicate = cb.and(predicate, cb.like(root.get("idno"), "%" + customer.getIdno() + "%"));
        }

        if (!StringUtils.isEmpty(customer.getName())) {
            predicate = cb.and(predicate, cb.like(root.get("name"), "%" + customer.getName() + "%"));
        }

        if (!StringUtils.isEmpty(customer.getEmail())) {
            predicate = cb.and(predicate, cb.like(root.get("email"), "%" + customer.getEmail() + "%"));
        }

        if (!StringUtils.isEmpty(customer.getMobile())) {
            predicate = cb.and(predicate, cb.like(root.get("mobile"), "%" + customer.getMobile() + "%"));
        }

        if (customer.getIdtp() != null) {
            predicate = cb.and(predicate, cb.equal(root.get("idtp"), customer.getIdtp()));
        }

        return predicate;
    }

}
