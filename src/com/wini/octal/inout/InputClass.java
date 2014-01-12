package com.wini.octal.inout;

import java.util.ArrayList;


public class InputClass<in> {
	// input
	private String Authkey = "";
	private String Action = "";		
	private String xmlns = "";
	private ArrayList<in> Param;
	
	private InputClass() {
	}
	
	public String getAuthkey() {
		return Authkey;
	}

	public void setAuthkey(String authkey) {
		Authkey = authkey;
	}

	public String getAction() {
		return Action;
	}

	public void setAction(String action) {
		Action = action;
	}

	public String getXmlns() {
		return xmlns;
	}

	public void setXmlns(String xmlns) {
		this.xmlns = xmlns;
	}

	public ArrayList<in> getParam() {
		return Param;
	}

	public void setParam(ArrayList<in> param) {
		Param = param;
	}
}
