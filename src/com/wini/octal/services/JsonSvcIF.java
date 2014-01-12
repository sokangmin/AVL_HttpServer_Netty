package com.wini.octal.services;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.util.CharsetUtil;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.wini.octal.inout.InputClass;
import com.wini.octal.inout.OutputClass;

public abstract class JsonSvcIF<In, Out> extends SvcIF {    
    protected static Gson gson = new GsonBuilder().serializeNulls().create();
    
    protected InputClass<In> getInput(Type collectionType) {	 
		
    	InputClass<In> input = gson.fromJson(request.getContent()
				.toString(CharsetUtil.UTF_8), collectionType);
		
		return input;
    }
    
    protected Map<String, Object> Object2Map(In obj) {
    	@SuppressWarnings("unchecked")
		HashMap<String, Object> map = gson.fromJson(toJson(obj), java.util.HashMap.class);
    
    	return map;
    }
    
    @SuppressWarnings("rawtypes")
	protected List<Out> List2Out(List list, Type collectionType) {
    	String json = toJson(list);
    	
    	return gson.fromJson(json, collectionType);	
    }
    
    protected String getOutput(List<Out> resultList) {
    	OutputClass<Out> out = new OutputClass<Out>();
		out.setXmlns(request.getUri());
		
		out.setParam(resultList);
		
		return toJson(out);
    }
    
    protected String getOutput(List<Out> resultList, String errCode, String errMsg) {
    	OutputClass<Out> out = new OutputClass<Out>();
		out.setXmlns(request.getUri());
		
		out.setParam(resultList);
		out.setCode(errCode);
		out.setMessage(errMsg);
		
		return toJson(out);
    }
    
    protected String getOutput(HashMap<String, String> head, List<Out> resultList, String errCode, String errMsg) {
    	OutputClass<Out> out = new OutputClass<Out>();
		out.setXmlns(request.getUri());
		
		out.setHead(head);
		out.setParam(resultList);
		out.setCode(errCode);
		out.setMessage(errMsg);
		
		return toJson(out);
    }
    
    private String toJson(Object obj) {
    	return obj==null?gson.toJson(obj):gson.toJson(obj).replace("null", "''");
    }
    
    protected void writeResponse(final MessageEvent e, final String content) {
    	writeResponse(e, "text/json", content);
    }
}
