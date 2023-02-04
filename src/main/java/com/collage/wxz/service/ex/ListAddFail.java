package com.collage.wxz.service.ex;

public class ListAddFail extends ServiceException {
    public ListAddFail() {
    }

    public ListAddFail(String message) {
        super(message);
    }

    public ListAddFail(String message, Throwable cause) {
        super(message, cause);
    }

    public ListAddFail(Throwable cause) {
        super(cause);
    }

    public ListAddFail(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
