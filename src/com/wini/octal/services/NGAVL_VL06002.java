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
public class NGAVL_VL06002 extends JsonSvcIF<NGAVL_VL06002.In, NGAVL_VL06002.Out> implements Runnable {
				
		public NGAVL_VL06002(MessageEvent e, HttpRequest request) {
			this.e = e;
			this.request = request;
		}
	
		// Input class
		public class In {
			private String SIDO_CD;
			private String GUGUN_CD;
			private String DONG_CD;
			private String CONST_NAME;
			private String DGR_DISPTN;
			
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
			 * @return the dGR_DISPTN
			 */
			public String getDGR_DISPTN() {
				return DGR_DISPTN;
			}

			/**
			 * @param dGR_DISPTN the dGR_DISPTN to set
			 */
			public void setDGR_DISPTN(String dGR_DISPTN) {
				DGR_DISPTN = dGR_DISPTN;
			}
		}
		
		// Output Class
		public class Out {
			private String OBJ_ID;
			private String WARD_ID;
			private String WARD_NAME;
			private String CONST_NAME;
			private String RPSN_FIRM_NAME;
			private String OBJ_CD;  
			private String HOUSE_NO;          
			private String ETC_ADDR;
			private String NAVI_X;
			private String NAVI_Y;
			private String DGR_DISPTN;
			
			public Out() {}

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
			 * @return the rPSN_FIRM_NAME
			 */
			public String getRPSN_FIRM_NAME() {
				return RPSN_FIRM_NAME;
			}

			/**
			 * @param rPSN_FIRM_NAME the rPSN_FIRM_NAME to set
			 */
			public void setRPSN_FIRM_NAME(String rPSN_FIRM_NAME) {
				RPSN_FIRM_NAME = rPSN_FIRM_NAME;
			}

			/**
			 * @return the oBJ_CD
			 */
			public String getOBJ_CD() {
				return OBJ_CD;
			}

			/**
			 * @param oBJ_CD the oBJ_CD to set
			 */
			public void setOBJ_CD(String oBJ_CD) {
				OBJ_CD = oBJ_CD;
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
			 * @return the dGR_DISPTN
			 */
			public String getDGR_DISPTN() {
				return DGR_DISPTN;
			}

			/**
			 * @param dGR_DISPTN the dGR_DISPTN to set
			 */
			public void setDGR_DISPTN(String dGR_DISPTN) {
				DGR_DISPTN = dGR_DISPTN;
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
				session.selectList("SQL.SUPPORT.NGAVL_VL06002", map);
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
