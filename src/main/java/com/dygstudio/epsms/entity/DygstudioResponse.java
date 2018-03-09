package com.dygstudio.epsms.entity;

/**
 * @author: diyaguang
 * @date: 2018/03/07 上午10:10
 * @description: com.dygstudio.epsms.entity
 */
public class DygstudioResponse {
    private String responseMessage;
    public DygstudioResponse(String responseMessage){
        this.responseMessage = responseMessage;
    }
    public String getResponseMessage(){
        return responseMessage;
    }
}
