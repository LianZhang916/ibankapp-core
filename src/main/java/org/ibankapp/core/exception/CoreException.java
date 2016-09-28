package org.ibankapp.core.exception;


import org.ibankapp.base.exception.BaseException;
import org.ibankapp.base.exception.PropertyUtil;

public class CoreException extends BaseException {

    private static final long serialVersionUID = 1L;

    private final static String MESSAGE_FILE = "sysmng_message.properties";

    static {
        PropertyUtil.load(MESSAGE_FILE);
    }
}
