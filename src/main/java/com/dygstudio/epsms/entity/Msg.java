package com.dygstudio.epsms.entity;

/**
 * @author: diyaguang
 * @date: 2018/03/13 下午7:36
 * @description: com.dygstudio.epsms.entity
 */
public class Msg {
    private String title;
    private String content;
    private String etraInfo;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getEtraInfo() {
        return etraInfo;
    }

    public void setEtraInfo(String etraInfo) {
        this.etraInfo = etraInfo;
    }

    public Msg(String title, String content, String etraInfo){
        super();

        this.title = title;
        this.content = content;
        this.etraInfo = etraInfo;
    }
}
