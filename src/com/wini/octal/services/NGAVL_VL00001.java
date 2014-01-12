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
public class NGAVL_VL00001 extends JsonSvcIF<NGAVL_VL00001.In, NGAVL_VL00001.Out> implements Runnable {
				
		public NGAVL_VL00001(MessageEvent e, HttpRequest request) {
			this.e = e;
			this.request = request;
		}
	
		// Input class
		public class In {
			private String CAR_NO;
			
			In() {}

			/**
			 * @return the cAR_NO
			 */
			public String getCAR_NO() {
				return CAR_NO;
			}

			/**
			 * @param cAR_NO the cAR_NO to set
			 */
			public void setCAR_NO(String cAR_NO) {
				CAR_NO = cAR_NO;
			}
			
			
		}
		
		// Output Class
		public class Out {
			private String 	MOBILE_ID;
			private String 	MOBILE_KND_CD;
			private String 	DEVICE_ID;
			private String 	CAR_ID;
			private String 	CAR_TYPE;
			private String 	CAR_KIND;
			private String 	UPWARD_ID;
			private String 	UPWARD_NAME;
			private String 	WARD_ID;
			private String 	WARD_NAME;
			private String 	MOBILE_STAT_CD;
			private String 	MOBILE_NM;
			private String 	MOBILE_SERIAL;
			private String 	LOGIN_USER_ID;
			private String 	CD_GRP;
			private String 	RADIO_CALLSIGN;
			private String 	NAVI_X;
			private String 	NAVI_Y;
			private String 	SIDO_CD;
			private String 	SIDO_NAME;

			
			public Out() {}


			/**
			 * @return the mOBILE_ID
			 */
			public String getMOBILE_ID() {
				return MOBILE_ID;
			}


			/**
			 * @param mOBILE_ID the mOBILE_ID to set
			 */
			public void setMOBILE_ID(String mOBILE_ID) {
				MOBILE_ID = mOBILE_ID;
			}


			/**
			 * @return the mOBILE_KND_CD
			 */
			public String getMOBILE_KND_CD() {
				return MOBILE_KND_CD;
			}


			/**
			 * @param mOBILE_KND_CD the mOBILE_KND_CD to set
			 */
			public void setMOBILE_KND_CD(String mOBILE_KND_CD) {
				MOBILE_KND_CD = mOBILE_KND_CD;
			}


			/**
			 * @return the dEVICE_ID
			 */
			public String getDEVICE_ID() {
				return DEVICE_ID;
			}


			/**
			 * @param dEVICE_ID the dEVICE_ID to set
			 */
			public void setDEVICE_ID(String dEVICE_ID) {
				DEVICE_ID = dEVICE_ID;
			}


			/**
			 * @return the cAR_ID
			 */
			public String getCAR_ID() {
				return CAR_ID;
			}


			/**
			 * @param cAR_ID the cAR_ID to set
			 */
			public void setCAR_ID(String cAR_ID) {
				CAR_ID = cAR_ID;
			}


			/**
			 * @return the cAR_TYPE
			 */
			public String getCAR_TYPE() {
				return CAR_TYPE;
			}


			/**
			 * @param cAR_TYPE the cAR_TYPE to set
			 */
			public void setCAR_TYPE(String cAR_TYPE) {
				CAR_TYPE = cAR_TYPE;
			}


			/**
			 * @return the cAR_KIND
			 */
			public String getCAR_KIND() {
				return CAR_KIND;
			}


			/**
			 * @param cAR_KIND the cAR_KIND to set
			 */
			public void setCAR_KIND(String cAR_KIND) {
				CAR_KIND = cAR_KIND;
			}


			/**
			 * @return the uPWARD_ID
			 */
			public String getUPWARD_ID() {
				return UPWARD_ID;
			}


			/**
			 * @param uPWARD_ID the uPWARD_ID to set
			 */
			public void setUPWARD_ID(String uPWARD_ID) {
				UPWARD_ID = uPWARD_ID;
			}


			/**
			 * @return the uPWARD_NAME
			 */
			public String getUPWARD_NAME() {
				return UPWARD_NAME;
			}


			/**
			 * @param uPWARD_NAME the uPWARD_NAME to set
			 */
			public void setUPWARD_NAME(String uPWARD_NAME) {
				UPWARD_NAME = uPWARD_NAME;
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
			 * @return the mOBILE_STAT_CD
			 */
			public String getMOBILE_STAT_CD() {
				return MOBILE_STAT_CD;
			}


			/**
			 * @param mOBILE_STAT_CD the mOBILE_STAT_CD to set
			 */
			public void setMOBILE_STAT_CD(String mOBILE_STAT_CD) {
				MOBILE_STAT_CD = mOBILE_STAT_CD;
			}


			/**
			 * @return the mOBILE_NM
			 */
			public String getMOBILE_NM() {
				return MOBILE_NM;
			}


			/**
			 * @param mOBILE_NM the mOBILE_NM to set
			 */
			public void setMOBILE_NM(String mOBILE_NM) {
				MOBILE_NM = mOBILE_NM;
			}


			/**
			 * @return the mOBILE_SERIAL
			 */
			public String getMOBILE_SERIAL() {
				return MOBILE_SERIAL;
			}


			/**
			 * @param mOBILE_SERIAL the mOBILE_SERIAL to set
			 */
			public void setMOBILE_SERIAL(String mOBILE_SERIAL) {
				MOBILE_SERIAL = mOBILE_SERIAL;
			}


			/**
			 * @return the lOGIN_USER_ID
			 */
			public String getLOGIN_USER_ID() {
				return LOGIN_USER_ID;
			}


			/**
			 * @param lOGIN_USER_ID the lOGIN_USER_ID to set
			 */
			public void setLOGIN_USER_ID(String lOGIN_USER_ID) {
				LOGIN_USER_ID = lOGIN_USER_ID;
			}


			/**
			 * @return the cD_GRP
			 */
			public String getCD_GRP() {
				return CD_GRP;
			}


			/**
			 * @param cD_GRP the cD_GRP to set
			 */
			public void setCD_GRP(String cD_GRP) {
				CD_GRP = cD_GRP;
			}


			/**
			 * @return the rADIO_CALLSIGN
			 */
			public String getRADIO_CALLSIGN() {
				return RADIO_CALLSIGN;
			}


			/**
			 * @param rADIO_CALLSIGN the rADIO_CALLSIGN to set
			 */
			public void setRADIO_CALLSIGN(String rADIO_CALLSIGN) {
				RADIO_CALLSIGN = rADIO_CALLSIGN;
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
			 * @return the sIDO_NAME
			 */
			public String getSIDO_NAME() {
				return SIDO_NAME;
			}


			/**
			 * @param sIDO_NAME the sIDO_NAME to set
			 */
			public void setSIDO_NAME(String sIDO_NAME) {
				SIDO_NAME = sIDO_NAME;
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
				session.selectList("SQL.CONFIG.NGAVL_VL00001", map);
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
