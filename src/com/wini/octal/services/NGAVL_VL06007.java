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
public class NGAVL_VL06007 extends JsonSvcIF<NGAVL_VL06007.In, NGAVL_VL06007.Out> implements Runnable {
				
		public NGAVL_VL06007(MessageEvent e, HttpRequest request) {
			this.e = e;
			this.request = request;
		}
	
		// Input class
		public class In {
			private String GUGUN_CD;
			private String DONG_CD;
			private String HOSP_NAME;
			
			In() {}

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
			 * @return the hOSP_NAME
			 */
			public String getHOSP_NAME() {
				return HOSP_NAME;
			}

			/**
			 * @param hOSP_NAME the hOSP_NAME to set
			 */
			public void setHOSP_NAME(String hOSP_NAME) {
				HOSP_NAME = hOSP_NAME;
			}

		}
		
		// Output Class
		public class Out {
			private String HOSP_ID;
			private String HOSP_NAME;
			private String HOSP_CLS_CD;
			private String ER_MEDICAL_YN;
			private String MAIN_TREAT;
			private String SICKBED_CNT;
			private String DOCTOR_CNT;
			private String AMBUL_CNT;
			private String ZIP_SEQ;
			private String SIDO_CD;
			private String GUGUN_CD;
			private String DONG_CD;
			private String RI_CD;
			private String HOUSE_NO;
			private String ETC_ADDR;
			private String DAY_TEL;
			private String NIGHT_TEL;
			private String NAVI_X;
			private String NAVI_Y;
			private String ON_DUTY_YN;
			
			public Out() {}

			/**
			 * @return the hOSP_ID
			 */
			public String getHOSP_ID() {
				return HOSP_ID;
			}

			/**
			 * @param hOSP_ID the hOSP_ID to set
			 */
			public void setHOSP_ID(String hOSP_ID) {
				HOSP_ID = hOSP_ID;
			}

			/**
			 * @return the hOSP_NAME
			 */
			public String getHOSP_NAME() {
				return HOSP_NAME;
			}

			/**
			 * @param hOSP_NAME the hOSP_NAME to set
			 */
			public void setHOSP_NAME(String hOSP_NAME) {
				HOSP_NAME = hOSP_NAME;
			}

			/**
			 * @return the hOSP_CLS_CD
			 */
			public String getHOSP_CLS_CD() {
				return HOSP_CLS_CD;
			}

			/**
			 * @param hOSP_CLS_CD the hOSP_CLS_CD to set
			 */
			public void setHOSP_CLS_CD(String hOSP_CLS_CD) {
				HOSP_CLS_CD = hOSP_CLS_CD;
			}

			/**
			 * @return the eR_MEDICAL_YN
			 */
			public String getER_MEDICAL_YN() {
				return ER_MEDICAL_YN;
			}

			/**
			 * @param eR_MEDICAL_YN the eR_MEDICAL_YN to set
			 */
			public void setER_MEDICAL_YN(String eR_MEDICAL_YN) {
				ER_MEDICAL_YN = eR_MEDICAL_YN;
			}

			/**
			 * @return the mAIN_TREAT
			 */
			public String getMAIN_TREAT() {
				return MAIN_TREAT;
			}

			/**
			 * @param mAIN_TREAT the mAIN_TREAT to set
			 */
			public void setMAIN_TREAT(String mAIN_TREAT) {
				MAIN_TREAT = mAIN_TREAT;
			}

			/**
			 * @return the sICKBED_CNT
			 */
			public String getSICKBED_CNT() {
				return SICKBED_CNT;
			}

			/**
			 * @param sICKBED_CNT the sICKBED_CNT to set
			 */
			public void setSICKBED_CNT(String sICKBED_CNT) {
				SICKBED_CNT = sICKBED_CNT;
			}

			/**
			 * @return the dOCTOR_CNT
			 */
			public String getDOCTOR_CNT() {
				return DOCTOR_CNT;
			}

			/**
			 * @param dOCTOR_CNT the dOCTOR_CNT to set
			 */
			public void setDOCTOR_CNT(String dOCTOR_CNT) {
				DOCTOR_CNT = dOCTOR_CNT;
			}

			/**
			 * @return the aMBUL_CNT
			 */
			public String getAMBUL_CNT() {
				return AMBUL_CNT;
			}

			/**
			 * @param aMBUL_CNT the aMBUL_CNT to set
			 */
			public void setAMBUL_CNT(String aMBUL_CNT) {
				AMBUL_CNT = aMBUL_CNT;
			}

			/**
			 * @return the zIP_SEQ
			 */
			public String getZIP_SEQ() {
				return ZIP_SEQ;
			}

			/**
			 * @param zIP_SEQ the zIP_SEQ to set
			 */
			public void setZIP_SEQ(String zIP_SEQ) {
				ZIP_SEQ = zIP_SEQ;
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
			 * @return the dAY_TEL
			 */
			public String getDAY_TEL() {
				return DAY_TEL;
			}

			/**
			 * @param dAY_TEL the dAY_TEL to set
			 */
			public void setDAY_TEL(String dAY_TEL) {
				DAY_TEL = dAY_TEL;
			}

			/**
			 * @return the nIGHT_TEL
			 */
			public String getNIGHT_TEL() {
				return NIGHT_TEL;
			}

			/**
			 * @param nIGHT_TEL the nIGHT_TEL to set
			 */
			public void setNIGHT_TEL(String nIGHT_TEL) {
				NIGHT_TEL = nIGHT_TEL;
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
			 * @return the oN_DUTY_YN
			 */
			public String getON_DUTY_YN() {
				return ON_DUTY_YN;
			}

			/**
			 * @param oN_DUTY_YN the oN_DUTY_YN to set
			 */
			public void setON_DUTY_YN(String oN_DUTY_YN) {
				ON_DUTY_YN = oN_DUTY_YN;
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
				session.selectList("SQL.SUPPORT.NGAVL_VL06007", map);
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
