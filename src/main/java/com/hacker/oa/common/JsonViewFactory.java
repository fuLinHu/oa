package com.hacker.oa.common;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JsonViewFactory {
    public final String ERRORSTATUS="404";
    public final String SUCCESSSTATUS="200";
    private String message;
    private String DATA="data";
    private String status="200";
    private boolean success=true;
    private JSONObject jsonObject;
    public static final String Default_DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private JsonConfig entryConfig;
    private static JsonViewFactory jsonViewFactory;


    public JsonViewFactory(){
        jsonObject = new JSONObject();
        entryConfig = new JsonConfig();
        jsonObject.put("status",status);
        jsonObject.put("success",success);
    }
    public static JsonViewFactory  create(){
        jsonViewFactory = new JsonViewFactory();
        return jsonViewFactory;
    }
    public static JSONObject toJson(){
        return jsonViewFactory.jsonObject;
    }
    public JsonViewFactory put(String key,Object obj){
        jsonObject.put(key,obj);
        return jsonViewFactory;
    }
    public JsonViewFactory setDateFormat(String dataFormat){
        if(dataFormat!=null&&!"".equals(dataFormat)){
            entryConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor(dataFormat));
        }else{
            entryConfig.registerJsonValueProcessor(Date.class,new JsonDateValueProcessor(Default_DATE_PATTERN));
        }
        Object o = jsonObject.get(DATA);
        if(o instanceof java.util.List){
            jsonObject.put(DATA, JSONArray.fromObject(o,entryConfig));
        }else{
            jsonObject.put(DATA, JSONObject.fromObject(o,entryConfig));
        }
        return jsonViewFactory;
    }


    public boolean getSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {

        this.success = success;
        jsonObject.put("success",success);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
        jsonObject.put("message",message);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        jsonObject.put("status",status);
    }
}
