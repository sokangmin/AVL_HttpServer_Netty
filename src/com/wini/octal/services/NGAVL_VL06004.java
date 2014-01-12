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
public class NGAVL_VL06004 extends JsonSvcIF<NGAVL_VL06004.In, NGAVL_VL06004.Out> implements Runnable {
				
		public NGAVL_VL06004(MessageEvent e, HttpRequest request) {
			this.e = e;
			this.request = request;
		}
	
		// Input class
		public class In {
			private String SIDO_CD;
			private String GUGUN_CD;
			private String DONG_CD;
			private String ETC_ADDR;
			private String FORM_CD;
			
			In() {}

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
			 * @return the fORM_CD
			 */
			public String getFORM_CD() {
				return FORM_CD;
			}

			/**
			 * @param fORM_CD the fORM_CD to set
			 */
			public void setFORM_CD(String fORM_CD) {
				FORM_CD = fORM_CD;
			}

			
		}
		
		// Output Class
		public class Out {
			private String HYD_ID;
			private String WARD_ID;
			private String WARD_NAME;
			private String HOUSE_NO;
			private String ADJ_BLDG;
			private String HYDKND_CD;
			private String PIPE;
			private String WTR_PRESS;
			private String ETC_ADDR;
			private String NAVI_X;
			private String NAVI_Y;
			private String FORM_CD;
			
			public Out() {}

			/**
			 * @return the hYD_ID
			 */
			public String getHYD_ID() {
				return HYD_ID;
			}

			/**
			 * @param hYD_ID the hYD_ID to set
			 */
			public void setHYD_ID(String hYD_ID) {
				HYD_ID = hYD_ID;
			}

			/**
			 * @return the wARD_ID
			 */
			public String getWARD_ID() {
				return WARD_ID;
			}

			/**
			 * @param wARD_ID the wARD_ID to set
			 */
			public void setWARD_ID(String wARD_ID) {
				WARD_ID = wARD_ID;
			}

			/**
			 * @return the wARD_NAME
			 */
			public String getWARD_NAME() {
				return WARD_NAME;
			}

			/**
			 * @param wARD_NAME the wARD_NAME to set
			 */
			public void setWARD_NAME(String wARD_NAME) {
				WARD_NAME = wARD_NAME;
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
			 * @return the aDJ_BLDG
			 */
			public String getADJ_BLDG() {
				return ADJ_BLDG;
			}

			/**
			 * @param aDJ_BLDG the aDJ_BLDG to set
			 */
			public void setADJ_BLDG(String aDJ_BLDG) {
				ADJ_BLDG = aDJ_BLDG;
			}

			/**
			 * @return the hYDKND_CD
			 */
			public String getHYDKND_CD() {
				return HYDKND_CD;
			}

			/**
			 * @param hYDKND_CD the hYDKND_CD to set
			 */
			public void setHYDKND_CD(String hYDKND_CD) {
				HYDKND_CD = hYDKND_CD;
			}

			/**
			 * @return the pIPE
			 */
			public String getPIPE() {
				return PIPE;
			}

			/**
			 * @param pIPE the pIPE to set
			 */
			public void setPIPE(String pIPE) {
				PIPE = pIPE;
			}

			/**
			 * @return the wTR_PRESS
			 */
			public String getWTR_PRESS() {
				return WTR_PRESS;
			}

			/**
			 * @param wTR_PRESS the wTR_PRESS to set
			 */
			public void setWTR_PRESS(String wTR_PRESS) {
				WTR_PRESS = wTR_PRESS;
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
			 * @return the nAVI_X
			 */
			public String getNAVI_X() {
				return NAVI_X;
			}

			/**
			 * @param nAVI_X the nAVI_X to set
			 */
			public void setNAVI_X(String nAVI_X) {
				NAVI_X = nAVI_X;
			}

			/**
			 * @return the nAVI_Y
			 */
			public String getNAVI_Y() {
				return NAVI_Y;
			}

			/**
			 * @param nAVI_Y the nAVI_Y to set
			 */
			public void setNAVI_Y(String nAVI_Y) {
				NAVI_Y = nAVI_Y;
			}

			/**
			 * @return the fORM_CD
			 */
			public String getFORM_CD() {
				return FORM_CD;
			}

			/**
			 * @param fORM_CD the fORM_CD to set
			 */
			public void setFORM_CD(String fORM_CD) {
				FORM_CD = fORM_CD;
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
				session.selectList("SQL.SUPPORT.NGAVL_VL06004", map);
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
