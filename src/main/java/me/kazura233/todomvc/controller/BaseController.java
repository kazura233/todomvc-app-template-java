package me.kazura233.todomvc.controller;

import me.kazura233.todomvc.common.RestResult;

public class BaseController {
    public RestResult success() {
        return new RestResult();
    }

    public RestResult success(Object resource) {
        return new RestResult(resource);
    }

    public RestResult error(String message) {
        return new RestResult(500, message, null);
    }

    public RestResult error(int code, String message) {
        return new RestResult(code, message, null);
    }

}
