package org.maaProxyBack.model;

public class ResponseCustom {
    private String statusCode;
    private String message;

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String statusMsg) {
        this.message = statusMsg;
    }

}
