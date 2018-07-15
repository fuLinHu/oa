package com.hacker.oa.common;

import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class JsonViewFactory {
    /*JsonViewFactory.create()
            .toJson();
*/
    private String code;
    private String success;
    Map<String,Object> map = new HashMap<String,Object>();
    public static JsonViewFactory  create(){
        return new JsonViewFactory();
    }
    public String toJson(){
        JSONObject jsonObject = JSONObject.fromObject(this);
        return jsonObject.toString();
    }

    private JsonViewFactory(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}
