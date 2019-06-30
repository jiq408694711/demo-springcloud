package com.xx.sbc.common.constant;

/**
 * Created by jiyiqin on 2019/6/29.
 */
public enum CommonErrorCode {

    CONTINUE(100, "Continue"),
    SWITCHING_PROTOCOLS(101, "Switching Protocols"),
    PROCESSING(102, "Processing"),
    CHECKPOINT(103, "Checkpoint"),
    OK(200, "OK"),;

    private final int value;
    private final String description;

    private CommonErrorCode(int value, String description) {
        this.value = value;
        this.description = description;
    }
}
