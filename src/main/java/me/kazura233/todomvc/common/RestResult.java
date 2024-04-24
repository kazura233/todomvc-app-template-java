package me.kazura233.todomvc.common;

import java.util.HashMap;

public class RestResult extends HashMap<String, Object> {

    public static final String CODE_TAG = "code";

    public static final String MESSAGE_TAG = "message";

    public static final String RESOURCE_TAG = "resource";

    public RestResult() {
        this(200, "OK", null);
    }

    public RestResult(Object resource) {
        this(200, "OK", resource);
    }

    public RestResult(int code, String message, Object resource) {
        super.put(CODE_TAG, code);
        super.put(MESSAGE_TAG, message);
        super.put(RESOURCE_TAG, resource);
    }

}
