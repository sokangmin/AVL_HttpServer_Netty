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
public class NGAVL_VL12006 extends JsonSvcIF<NGAVL_VL12006.In, NGAVL_VL12006.Out> implements Runnable {
				
		public NGAVL_VL12006(MessageEvent e, HttpRequest request) {
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
			private String 	FMGR_SEQ;
			private String 	OBJ_ID;
			private String 	FMGR_NAME;
			private String 	FMGR_BIRTHDAY;
			private String 	SIDO_CD;
			private String 	GUGUN_CD;
			private String 	DONG_CD;
			private String 	RI_CD;
			private String 	HOUSE_NO;
			private String 	ETC_ADDR;
			private String 	HOME_TEL;
			private String 	ASSIGN_DATE;
			private String 	DISMISS_DATE;
			private String 	FLICN_CD;
			private String 	LICN_NO;
			private String 	JUMIN_NO;
			private String 	ZIP_CODE;
			private String 	SAN_ADDRNO_YN;
			private String 	BLDG_NAME;
			private String 	BLDG_NAME_ETC;
			private String 	MAIN_BLDG_NUM;
			private String 	SUB_BLDG_NUM;
			private String 	ROAD_NAME;
			private String 	FMNG_NOTE_NUM;
			private String 	MGE_AGENCY_YN;
			private String 	PUB_FMNG_YN;
			private String 	DISMISS_REMARK;
			private String 	TITLE;
			private String 	LEDU_DATE;

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
			 * @return the fMGR_SEQ
			 */
			public String getFMGR_SEQ() {
				return FMGR_SEQ;
			}

			/**
			 * @param fMGR_SEQ the fMGR_SEQ to set
			 */
			public void setFMGR_SEQ(String fMGR_SEQ) {
				FMGR_SEQ = fMGR_SEQ;
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
			 * @return the fMGR_NAME
			 */
			public String getFMGR_NAME() {
				return FMGR_NAME;
			}

			/**
			 * @param fMGR_NAME the fMGR_NAME to set
			 */
			public void setFMGR_NAME(String fMGR_NAME) {
				FMGR_NAME = fMGR_NAME;
			}

			/**
			 * @return the fMGR_BIRTHDAY
			 */
			public String getFMGR_BIRTHDAY() {
				return FMGR_BIRTHDAY;
			}

			/**
			 * @param fMGR_BIRTHDAY the fMGR_BIRTHDAY to set
			 */
			public void setFMGR_BIRTHDAY(String fMGR_BIRTHDAY) {
				FMGR_BIRTHDAY = fMGR_BIRTHDAY;
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
			 * @return the aSSIGN_DATE
			 */
			public String getASSIGN_DATE() {
				return ASSIGN_DATE;
			}

			/**
			 * @param aSSIGN_DATE the aSSIGN_DATE to set
			 */
			public void setASSIGN_DATE(String aSSIGN_DATE) {
				ASSIGN_DATE = aSSIGN_DATE;
			}

			/**
			 * @return the dISMISS_DATE
			 */
			public String getDISMISS_DATE() {
				return DISMISS_DATE;
			}

			/**
			 * @param dISMISS_DATE the dISMISS_DATE to set
			 */
			public void setDISMISS_DATE(String dISMISS_DATE) {
				DISMISS_DATE = dISMISS_DATE;
			}

			/**
			 * @return the fLICN_CD
			 */
			public String getFLICN_CD() {
				return FLICN_CD;
			}

			/**
			 * @param fLICN_CD the fLICN_CD to set
			 */
			public void setFLICN_CD(String fLICN_CD) {
				FLICN_CD = fLICN_CD;
			}

			/**
			 * @return the lICN_NO
			 */
			public String getLICN_NO() {
				return LICN_NO;
			}

			/**
			 * @param lICN_NO the lICN_NO to set
			 */
			public void setLICN_NO(String lICN_NO) {
				LICN_NO = lICN_NO;
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
			 * @return the sAN_ADDRNO_YN
			 */
			public String getSAN_ADDRNO_YN() {
				return SAN_ADDRNO_YN;
			}

			/**
			 * @param sAN_ADDRNO_YN the sAN_ADDRNO_YN to set
			 */
			public void setSAN_ADDRNO_YN(String sAN_ADDRNO_YN) {
				SAN_ADDRNO_YN = sAN_ADDRNO_YN;
			}

			/**
			 * @return the bLDG_NAME
			 */
			public String getBLDG_NAME() {
				return BLDG_NAME;
			}

			/**
			 * @param bLDG_NAME the bLDG_NAME to set
			 */
			public void setBLDG_NAME(String bLDG_NAME) {
				BLDG_NAME = bLDG_NAME;
			}

			/**
			 * @return the bLDG_NAME_ETC
			 */
			public String getBLDG_NAME_ETC() {
				return BLDG_NAME_ETC;
			}

			/**
			 * @param bLDG_NAME_ETC the bLDG_NAME_ETC to set
			 */
			public void setBLDG_NAME_ETC(String bLDG_NAME_ETC) {
				BLDG_NAME_ETC = bLDG_NAME_ETC;
			}

			/**
			 * @return the mAIN_BLDG_NUM
			 */
			public String getMAIN_BLDG_NUM() {
				return MAIN_BLDG_NUM;
			}

			/**
			 * @param mAIN_BLDG_NUM the mAIN_BLDG_NUM to set
			 */
			public void setMAIN_BLDG_NUM(String mAIN_BLDG_NUM) {
				MAIN_BLDG_NUM = mAIN_BLDG_NUM;
			}

			/**
			 * @return the sUB_BLDG_NUM
			 */
			public String getSUB_BLDG_NUM() {
				return SUB_BLDG_NUM;
			}

			/**
			 * @param sUB_BLDG_NUM the sUB_BLDG_NUM to set
			 */
			public void setSUB_BLDG_NUM(String sUB_BLDG_NUM) {
				SUB_BLDG_NUM = sUB_BLDG_NUM;
			}

			/**
			 * @return the rOAD_NAME
			 */
			public String getROAD_NAME() {
				return ROAD_NAME;
			}

			/**
			 * @param rOAD_NAME the rOAD_NAME to set
			 */
			public void setROAD_NAME(String rOAD_NAME) {
				ROAD_NAME = rOAD_NAME;
			}

			/**
			 * @return the fMNG_NOTE_NUM
			 */
			public String getFMNG_NOTE_NUM() {
				return FMNG_NOTE_NUM;
			}

			/**
			 * @param fMNG_NOTE_NUM the fMNG_NOTE_NUM to set
			 */
			public void setFMNG_NOTE_NUM(String fMNG_NOTE_NUM) {
				FMNG_NOTE_NUM = fMNG_NOTE_NUM;
			}

			/**
			 * @return the mGE_AGENCY_YN
			 */
			public String getMGE_AGENCY_YN() {
				return MGE_AGENCY_YN;
			}

			/**
			 * @param mGE_AGENCY_YN the mGE_AGENCY_YN to set
			 */
			public void setMGE_AGENCY_YN(String mGE_AGENCY_YN) {
				MGE_AGENCY_YN = mGE_AGENCY_YN;
			}

			/**
			 * @return the pUB_FMNG_YN
			 */
			public String getPUB_FMNG_YN() {
				return PUB_FMNG_YN;
			}

			/**
			 * @param pUB_FMNG_YN the pUB_FMNG_YN to set
			 */
			public void setPUB_FMNG_YN(String pUB_FMNG_YN) {
				PUB_FMNG_YN = pUB_FMNG_YN;
			}

			/**
			 * @return the dISMISS_REMARK
			 */
			public String getDISMISS_REMARK() {
				return DISMISS_REMARK;
			}

			/**
			 * @param dISMISS_REMARK the dISMISS_REMARK to set
			 */
			public void setDISMISS_REMARK(String dISMISS_REMARK) {
				DISMISS_REMARK = dISMISS_REMARK;
			}

			/**
			 * @return the tITLE
			 */
			public String getTITLE() {
				return TITLE;
			}

			/**
			 * @param tITLE the tITLE to set
			 */
			public void setTITLE(String tITLE) {
				TITLE = tITLE;
			}

			/**
			 * @return the lEDU_DATE
			 */
			public String getLEDU_DATE() {
				return LEDU_DATE;
			}

			/**
			 * @param lEDU_DATE the lEDU_DATE to set
			 */
			public void setLEDU_DATE(String lEDU_DATE) {
				LEDU_DATE = lEDU_DATE;
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
				session.selectList("SQL.SUPPORT.NGAVL_VL12006", map);
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
