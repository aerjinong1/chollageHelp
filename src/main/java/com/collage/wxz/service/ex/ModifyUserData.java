package com.collage.wxz.service.ex;

public class ModifyUserData extends ServiceException{
    public ModifyUserData() {
    }

    public ModifyUserData(String message) {
        super(message);
    }

    public ModifyUserData(String message, Throwable cause) {
        super(message, cause);
    }

    public ModifyUserData(Throwable cause) {
        super(cause);
    }

    public ModifyUserData(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
