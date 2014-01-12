package com.wini.octal.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.jboss.netty.channel.MessageEvent;
import org.jboss.netty.handler.codec.http.HttpRequest;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.google.gson.reflect.TypeToken;
import com.wini.octal.sql.SqlSessionManager;
import com.wini.octal.inout.InputClass;

@Component
@Scope("prototype")
public class NGAVL_VL12008 extends JsonSvcIF<NGAVL_VL12008.In, NGAVL_VL12008.Out> implements Runnable {
				
		public NGAVL_VL12008(MessageEvent e, HttpRequest request) {
			this.e = e;
			this.request = request;
		}
	
		// Input class
		public class In {
			private String OBJ_ID;
			
			In() {}

			/**
			 * @return the oBJ_ID
			 */
			public String getOBJ_ID() {
				return OBJ_ID;
			}

			/**
			 * @param oBJ_ID the oBJ_ID to set
			 */
			public void setOBJ_ID(String oBJ_ID) {
				OBJ_ID = oBJ_ID;
			}

			
		}
		
		// Output Class
		public class Out {			
			private String 	CONST_NAME;
			private String 	REL_SEQ;
			private String 	OBJ_ID;
			private String 	REL_CD;
			private String 	REL_CDNAME;
			private String 	REL_NAME;
			private String 	REL_BIRTHDAY;
			private String 	SIDO_CD;
			private String 	GUGUN_CD;
			private String 	DONG_CD;
			private String 	RI_CD;
			private String 	HOUSE_NO;
			private String 	ETC_ADDR;
			private String 	HOME_TEL;
			private String 	JOB_DESC;
			private String 	ZIP_CODE;
			private String 	JUMIN_NO;
			private String 	AGE;


			public Out() {}


			/**
			 * @return the cONST_NAME
			 */
			public String getCONST_NAME() {
				return CONST_NAME;
			}


			/**
			 * @param cONST_NAME the cONST_NAME to set
			 */
			public void setCONST_NAME(String cONST_NAME) {
				CONST_NAME = cONST_NAME;
			}


			/**
			 * @return the rEL_SEQ
			 */
			public String getREL_SEQ() {
				return REL_SEQ;
			}


			/**
			 * @param rEL_SEQ the rEL_SEQ to set
			 */
			public void setREL_SEQ(String rEL_SEQ) {
				REL_SEQ = rEL_SEQ;
			}


			/**
			 * @return the oBJ_ID
			 */
			public String getOBJ_ID() {
				return OBJ_ID;
			}


			/**
			 * @param oBJ_ID the oBJ_ID to set
			 */
			public void setOBJ_ID(String oBJ_ID) {
				OBJ_ID = oBJ_ID;
			}


			/**
			 * @return the rEL_CD
			 */
			public String getREL_CD() {
				return REL_CD;
			}


			/**
			 * @param rEL_CD the rEL_CD to set
			 */
			public void setREL_CD(String rEL_CD) {
				REL_CD = rEL_CD;
			}


			/**
			 * @return the rEL_CDNAME
			 */
			public String getREL_CDNAME() {
				return REL_CDNAME;
			}


			/**
			 * @param rEL_CDNAME the rEL_CDNAME to set
			 */
			public void setREL_CDNAME(String rEL_CDNAME) {
				REL_CDNAME = rEL_CDNAME;
			}


			/**
			 * @return the rEL_NAME
			 */
			public String getREL_NAME() {
				return REL_NAME;
			}


			/**
			 * @param rEL_NAME the rEL_NAME to set
			 */
			public void setREL_NAME(String rEL_NAME) {
				REL_NAME = rEL_NAME;
			}


			/**
			 * @return the rEL_BIRTHDAY
			 */
			public String getREL_BIRTHDAY() {
				return REL_BIRTHDAY;
			}


			/**
			 * @param rEL_BIRTHDAY the rEL_BIRTHDAY to set
			 */
			public void setREL_BIRTHDAY(String rEL_BIRTHDAY) {
				REL_BIRTHDAY = rEL_BIRTHDAY;
			}


			/**
			 * @return the sIDO_CD
			 */
			public String getSIDO_CD() {
				return SIDO_CD;
			}


			/**
			 * @param sIDO_CD the sIDO_CD to set
			 */
			public void setSIDO_CD(String sIDO_CD) {
				SIDO_CD = sIDO_CD;
			}


			/**
			 * @return the gUGUN_CD
			 */
			public String getGUGUN_CD() {
				return GUGUN_CD;
			}


			/**
			 * @param gUGUN_CD the gUGUN_CD to set
			 */
			public void setGUGUN_CD(String gUGUN_CD) {
				GUGUN_CD = gUGUN_CD;
			}


			/**
			 * @return the dONG_CD
			 */
			public String getDONG_CD() {
				return DONG_CD;
			}


			/**
			 * @param dONG_CD the dONG_CD to set
			 */
			public void setDONG_CD(String dONG_CD) {
				DONG_CD = dONG_CD;
			}


			/**
			 * @return the rI_CD
			 */
			public String getRI_CD() {
				return RI_CD;
			}


			/**
			 * @param rI_CD the rI_CD to set
			 */
			public void setRI_CD(String rI_CD) {
				RI_CD = rI_CD;
			}


			/**
			 * @return the hOUSE_NO
			 */
			public String getHOUSE_NO() {
				return HOUSE_NO;
			}


			/**
			 * @param hOUSE_NO the hOUSE_NO to set
			 */
			public void setHOUSE_NO(String hOUSE_NO) {
				HOUSE_NO = hOUSE_NO;
			}


			/**
			 * @return the eTC_ADDR
			 */
			public String getETC_ADDR() {
				return ETC_ADDR;
			}


			/**
			 * @param eTC_ADDR the eTC_ADDR to set
			 */
			public void setETC_ADDR(String eTC_ADDR) {
				ETC_ADDR = eTC_ADDR;
			}


			/**
			 * @return the hOME_TEL
			 */
			public String getHOME_TEL() {
				return HOME_TEL;
			}


			/**
			 * @param hOME_TEL the hOME_TEL to set
			 */
			public void setHOME_TEL(String hOME_TEL) {
				HOME_TEL = hOME_TEL;
			}


			/**
			 * @return the jOB_DESC
			 */
			public String getJOB_DESC() {
				return JOB_DESC;
			}


			/**
			 * @param jOB_DESC the jOB_DESC to set
			 */
			public void setJOB_DESC(String jOB_DESC) {
				JOB_DESC = jOB_DESC;
			}


			/**
			 * @return the zIP_CODE
			 */
			public String getZIP_CODE() {
				return ZIP_CODE;
			}


			/**
			 * @param zIP_CODE the zIP_CODE to set
			 */
			public void setZIP_CODE(String zIP_CODE) {
				ZIP_CODE = zIP_CODE;
			}


			/**
			 * @return the jUMIN_NO
			 */
			public String getJUMIN_NO() {
				return JUMIN_NO;
			}


			/**
			 * @param jUMIN_NO the jUMIN_NO to set
			 */
			public void setJUMIN_NO(String jUMIN_NO) {
				JUMIN_NO = jUMIN_NO;
			}


			/**
			 * @return the aGE
			 */
			public String getAGE() {
				return AGE;
			}


			/**
			 * @param aGE the aGE to set
			 */
			public void setAGE(String aGE) {
				AGE = aGE;
			}

					
		}

		
		@Override
		public void run() {
			// Input get
			InputClass<In> input = getInput(new TypeToken<InputClass<In>>(){}.getType());
			Map<String, Object> map = Object2Map(input.getParam().get(0));
			
			
			// DB serv
			SqlSession session = null;
			try {
				session = SqlSessionManager.getSqlSession().openSession();
				session.selectList("SQL.SUPPORT.NGAVL_VL12008", map);
			} catch(Exception e) {
				logger.error("Unexpected exception from DB.", e.getCause());
				throw (RuntimeException)e;
			} finally {
				session.close();
			}
			
			// Output
			@SuppressWarnings("rawtypes")
			List<Out> out = List2Out((List)map.get("LIST_CURSOR"),
					new TypeToken<ArrayList<Out>>(){}.getType());
			
			writeResponse(e, getOutput(out, (String) map.get("ERRCODE"), (String) map.get("ERRMSG")));
			
		}
	}
