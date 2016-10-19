/*
 * iBankApp
 *
 * License : Apache License,Version 2.0, January 2004
 *
 * See the LICENSE file in English or LICENSE.zh_CN in chinese
 * in the root directory or <http://www.apache.org/licenses/>.
 */

package org.ibankapp.core.exception;

import org.ibankapp.base.exception.BaseException;
import org.ibankapp.base.util.PropertyUtil;


/**
 * 账务核心异常类
 *
 * @author codelder
 * @version 1.0.0, 16/09/30
 */
public class CoreException extends BaseException {

    /**
     * 序列化ID
     */
    private static final long serialVersionUID = 1L;

    /**
     * 异常信息属性文件
     */
    private final static String MESSAGE_FILE = "core_message.properties";

    static {
        PropertyUtil.load(MESSAGE_FILE);
    }
}
