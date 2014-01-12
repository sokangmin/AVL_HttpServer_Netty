package com.wini.octal.inout;

import java.util.HashMap;
import java.util.List;


public class OutputClass<out> {
	// output 
	private HashMap<String,String> Head = new HashMap<String, String>();
	private HashMap<String,String> Tail = new HashMap<String, String>();
	private String Message = "";
	private String Code = "0";
	private String xmlns = "";
	private List<out> Param;
	
	public OutputClass() {
	}

	public HashMap<String,String> getHead() {
		return Head;
	}

	public void setHead(HashMap<String,String> head) {
		Head = head;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}

	public HashMap<String,String> getTail() {
		return Tail;
	}

	public void setTail(HashMap<String,String> tail) {
		Tail = tail;
	}

	public String getCode() {
		return Code;
	}

	public void setCode(String code) {
		Code = code;
	}

	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	public List<out> getParam() {
		return Param;
	}

	public void setParam(List<out> param) {
		Param = param;
	}
}
