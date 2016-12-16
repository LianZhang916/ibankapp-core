/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.customer.repository;

import org.ibankapp.base.springdata.repository.BaseJpaRepository;
import org.ibankapp.core.customer.model.CorpCustomer;

public interface CorpCustomerRepository extends BaseJpaRepository<CorpCustomer,String> {

}
