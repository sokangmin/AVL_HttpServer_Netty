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
public class NGAVL_VL12002 extends JsonSvcIF<NGAVL_VL12002.In, NGAVL_VL12002.Out> implements Runnable {
				
		public NGAVL_VL12002(MessageEvent e, HttpRequest request) {
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
			private String 	BLDG_SEQ;
			private String 	BLDG_NAME;
			private String 	STRUCT_1;
			private String 	STRUCT_2;
			private String 	STRUCT_3;
			private String 	USTORY_CNT;
			private String 	BSTORY_CNT;
			private String 	FLOOR_AREA;
			private String 	TOT_AREA;
			private String 	SESC_STAIR_CNT;
			private String 	LOT_AREA;
			private String 	ESC_STAIR_CNT;
			private String 	COM_STAIR_CNT;
			private String 	OUT_STAIR_CNT;
			private String 	INCLINE_CNT;
			private String 	EMGLIFT_CNT;
			private String 	ESCAL_CNT;
			private String 	EXIT_CNT;
			private String 	ROOT_YN;
			private String 	HOME_CNT;
			private String 	SPACE1;
			private String 	SPACE2;
			private String 	RPSN_BLDGDONG_YN;
			private String 	HOUSE_CNT;
			private String 	ENTRPS_CNT;
			private String 	INHBTNT_CNT;
			private String 	BLDGDONG_HIGH;
			private String 	ELVTR;
			private String 	PMT_DATE;
			private String 	SWORK_DATE;
			private String 	USE_CONFM_DATE;
			private String 	REMOVE_DATE;
			private String 	REMOVE_YN;
			private String 	BLDGDONG_MAIN_USE_CD;
			private String 	BLDGDONG_SUB_USE_CD;
			private String 	BLDGDONG_MAIN_USE_CDNAME;
			private String 	BLDGDONG_SUB_USE_CDNAME;
			private String 	CONST_REGSTR_PK;
			
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
			 * @return the bLDG_SEQ
			 */
			public String getBLDG_SEQ() {
				return BLDG_SEQ;
			}

			/**
			 * @param bLDG_SEQ the bLDG_SEQ to set
			 */
			public void setBLDG_SEQ(String bLDG_SEQ) {
				BLDG_SEQ = bLDG_SEQ;
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
			 * @return the sTRUCT_1
			 */
			public String getSTRUCT_1() {
				return STRUCT_1;
			}

			/**
			 * @param sTRUCT_1 the sTRUCT_1 to set
			 */
			public void setSTRUCT_1(String sTRUCT_1) {
				STRUCT_1 = sTRUCT_1;
			}

			/**
			 * @return the sTRUCT_2
			 */
			public String getSTRUCT_2() {
				return STRUCT_2;
			}

			/**
			 * @param sTRUCT_2 the sTRUCT_2 to set
			 */
			public void setSTRUCT_2(String sTRUCT_2) {
				STRUCT_2 = sTRUCT_2;
			}

			/**
			 * @return the sTRUCT_3
			 */
			public String getSTRUCT_3() {
				return STRUCT_3;
			}

			/**
			 * @param sTRUCT_3 the sTRUCT_3 to set
			 */
			public void setSTRUCT_3(String sTRUCT_3) {
				STRUCT_3 = sTRUCT_3;
			}

			/**
			 * @return the uSTORY_CNT
			 */
			public String getUSTORY_CNT() {
				return USTORY_CNT;
			}

			/**
			 * @param uSTORY_CNT the uSTORY_CNT to set
			 */
			public void setUSTORY_CNT(String uSTORY_CNT) {
				USTORY_CNT = uSTORY_CNT;
			}

			/**
			 * @return the bSTORY_CNT
			 */
			public String getBSTORY_CNT() {
				return BSTORY_CNT;
			}

			/**
			 * @param bSTORY_CNT the bSTORY_CNT to set
			 */
			public void setBSTORY_CNT(String bSTORY_CNT) {
				BSTORY_CNT = bSTORY_CNT;
			}

			/**
			 * @return the fLOOR_AREA
			 */
			public String getFLOOR_AREA() {
				return FLOOR_AREA;
			}

			/**
			 * @param fLOOR_AREA the fLOOR_AREA to set
			 */
			public void setFLOOR_AREA(String fLOOR_AREA) {
				FLOOR_AREA = fLOOR_AREA;
			}

			/**
			 * @return the tOT_AREA
			 */
			public String getTOT_AREA() {
				return TOT_AREA;
			}

			/**
			 * @param tOT_AREA the tOT_AREA to set
			 */
			public void setTOT_AREA(String tOT_AREA) {
				TOT_AREA = tOT_AREA;
			}

			/**
			 * @return the sESC_STAIR_CNT
			 */
			public String getSESC_STAIR_CNT() {
				return SESC_STAIR_CNT;
			}

			/**
			 * @param sESC_STAIR_CNT the sESC_STAIR_CNT to set
			 */
			public void setSESC_STAIR_CNT(String sESC_STAIR_CNT) {
				SESC_STAIR_CNT = sESC_STAIR_CNT;
			}

			/**
			 * @return the lOT_AREA
			 */
			public String getLOT_AREA() {
				return LOT_AREA;
			}

			/**
			 * @param lOT_AREA the lOT_AREA to set
			 */
			public void setLOT_AREA(String lOT_AREA) {
				LOT_AREA = lOT_AREA;
			}

			/**
			 * @return the eSC_STAIR_CNT
			 */
			public String getESC_STAIR_CNT() {
				return ESC_STAIR_CNT;
			}

			/**
			 * @param eSC_STAIR_CNT the eSC_STAIR_CNT to set
			 */
			public void setESC_STAIR_CNT(String eSC_STAIR_CNT) {
				ESC_STAIR_CNT = eSC_STAIR_CNT;
			}

			/**
			 * @return the cOM_STAIR_CNT
			 */
			public String getCOM_STAIR_CNT() {
				return COM_STAIR_CNT;
			}

			/**
			 * @param cOM_STAIR_CNT the cOM_STAIR_CNT to set
			 */
			public void setCOM_STAIR_CNT(String cOM_STAIR_CNT) {
				COM_STAIR_CNT = cOM_STAIR_CNT;
			}

			/**
			 * @return the oUT_STAIR_CNT
			 */
			public String getOUT_STAIR_CNT() {
				return OUT_STAIR_CNT;
			}

			/**
			 * @param oUT_STAIR_CNT the oUT_STAIR_CNT to set
			 */
			public void setOUT_STAIR_CNT(String oUT_STAIR_CNT) {
				OUT_STAIR_CNT = oUT_STAIR_CNT;
			}

			/**
			 * @return the iNCLINE_CNT
			 */
			public String getINCLINE_CNT() {
				return INCLINE_CNT;
			}

			/**
			 * @param iNCLINE_CNT the iNCLINE_CNT to set
			 */
			public void setINCLINE_CNT(String iNCLINE_CNT) {
				INCLINE_CNT = iNCLINE_CNT;
			}

			/**
			 * @return the eMGLIFT_CNT
			 */
			public String getEMGLIFT_CNT() {
				return EMGLIFT_CNT;
			}

			/**
			 * @param eMGLIFT_CNT the eMGLIFT_CNT to set
			 */
			public void setEMGLIFT_CNT(String eMGLIFT_CNT) {
				EMGLIFT_CNT = eMGLIFT_CNT;
			}

			/**
			 * @return the eSCAL_CNT
			 */
			public String getESCAL_CNT() {
				return ESCAL_CNT;
			}

			/**
			 * @param eSCAL_CNT the eSCAL_CNT to set
			 */
			public void setESCAL_CNT(String eSCAL_CNT) {
				ESCAL_CNT = eSCAL_CNT;
			}

			/**
			 * @return the eXIT_CNT
			 */
			public String getEXIT_CNT() {
				return EXIT_CNT;
			}

			/**
			 * @param eXIT_CNT the eXIT_CNT to set
			 */
			public void setEXIT_CNT(String eXIT_CNT) {
				EXIT_CNT = eXIT_CNT;
			}

			/**
			 * @return the rOOT_YN
			 */
			public String getROOT_YN() {
				return ROOT_YN;
			}

			/**
			 * @param rOOT_YN the rOOT_YN to set
			 */
			public void setROOT_YN(String rOOT_YN) {
				ROOT_YN = rOOT_YN;
			}

			/**
			 * @return the hOME_CNT
			 */
			public String getHOME_CNT() {
				return HOME_CNT;
			}

			/**
			 * @param hOME_CNT the hOME_CNT to set
			 */
			public void setHOME_CNT(String hOME_CNT) {
				HOME_CNT = hOME_CNT;
			}

			/**
			 * @return the sPACE1
			 */
			public String getSPACE1() {
				return SPACE1;
			}

			/**
			 * @param sPACE1 the sPACE1 to set
			 */
			public void setSPACE1(String sPACE1) {
				SPACE1 = sPACE1;
			}

			/**
			 * @return the sPACE2
			 */
			public String getSPACE2() {
				return SPACE2;
			}

			/**
			 * @param sPACE2 the sPACE2 to set
			 */
			public void setSPACE2(String sPACE2) {
				SPACE2 = sPACE2;
			}

			/**
			 * @return the rPSN_BLDGDONG_YN
			 */
			public String getRPSN_BLDGDONG_YN() {
				return RPSN_BLDGDONG_YN;
			}

			/**
			 * @param rPSN_BLDGDONG_YN the rPSN_BLDGDONG_YN to set
			 */
			public void setRPSN_BLDGDONG_YN(String rPSN_BLDGDONG_YN) {
				RPSN_BLDGDONG_YN = rPSN_BLDGDONG_YN;
			}

			/**
			 * @return the hOUSE_CNT
			 */
			public String getHOUSE_CNT() {
				return HOUSE_CNT;
			}

			/**
			 * @param hOUSE_CNT the hOUSE_CNT to set
			 */
			public void setHOUSE_CNT(String hOUSE_CNT) {
				HOUSE_CNT = hOUSE_CNT;
			}

			/**
			 * @return the eNTRPS_CNT
			 */
			public String getENTRPS_CNT() {
				return ENTRPS_CNT;
			}

			/**
			 * @param eNTRPS_CNT the eNTRPS_CNT to set
			 */
			public void setENTRPS_CNT(String eNTRPS_CNT) {
				ENTRPS_CNT = eNTRPS_CNT;
			}

			/**
			 * @return the iNHBTNT_CNT
			 */
			public String getINHBTNT_CNT() {
				return INHBTNT_CNT;
			}

			/**
			 * @param iNHBTNT_CNT the iNHBTNT_CNT to set
			 */
			public void setINHBTNT_CNT(String iNHBTNT_CNT) {
				INHBTNT_CNT = iNHBTNT_CNT;
			}

			/**
			 * @return the bLDGDONG_HIGH
			 */
			public String getBLDGDONG_HIGH() {
				return BLDGDONG_HIGH;
			}

			/**
			 * @param bLDGDONG_HIGH the bLDGDONG_HIGH to set
			 */
			public void setBLDGDONG_HIGH(String bLDGDONG_HIGH) {
				BLDGDONG_HIGH = bLDGDONG_HIGH;
			}

			/**
			 * @return the eLVTR
			 */
			public String getELVTR() {
				return ELVTR;
			}

			/**
			 * @param eLVTR the eLVTR to set
			 */
			public void setELVTR(String eLVTR) {
				ELVTR = eLVTR;
			}

			/**
			 * @return the pMT_DATE
			 */
			public String getPMT_DATE() {
				return PMT_DATE;
			}

			/**
			 * @param pMT_DATE the pMT_DATE to set
			 */
			public void setPMT_DATE(String pMT_DATE) {
				PMT_DATE = pMT_DATE;
			}

			/**
			 * @return the sWORK_DATE
			 */
			public String getSWORK_DATE() {
				return SWORK_DATE;
			}

			/**
			 * @param sWORK_DATE the sWORK_DATE to set
			 */
			public void setSWORK_DATE(String sWORK_DATE) {
				SWORK_DATE = sWORK_DATE;
			}

			/**
			 * @return the uSE_CONFM_DATE
			 */
			public String getUSE_CONFM_DATE() {
				return USE_CONFM_DATE;
			}

			/**
			 * @param uSE_CONFM_DATE the uSE_CONFM_DATE to set
			 */
			public void setUSE_CONFM_DATE(String uSE_CONFM_DATE) {
				USE_CONFM_DATE = uSE_CONFM_DATE;
			}

			/**
			 * @return the rEMOVE_DATE
			 */
			public String getREMOVE_DATE() {
				return REMOVE_DATE;
			}

			/**
			 * @param rEMOVE_DATE the rEMOVE_DATE to set
			 */
			public void setREMOVE_DATE(String rEMOVE_DATE) {
				REMOVE_DATE = rEMOVE_DATE;
			}

			/**
			 * @return the rEMOVE_YN
			 */
			public String getREMOVE_YN() {
				return REMOVE_YN;
			}

			/**
			 * @param rEMOVE_YN the rEMOVE_YN to set
			 */
			public void setREMOVE_YN(String rEMOVE_YN) {
				REMOVE_YN = rEMOVE_YN;
			}

			/**
			 * @return the bLDGDONG_MAIN_USE_CD
			 */
			public String getBLDGDONG_MAIN_USE_CD() {
				return BLDGDONG_MAIN_USE_CD;
			}

			/**
			 * @param bLDGDONG_MAIN_USE_CD the bLDGDONG_MAIN_USE_CD to set
			 */
			public void setBLDGDONG_MAIN_USE_CD(String bLDGDONG_MAIN_USE_CD) {
				BLDGDONG_MAIN_USE_CD = bLDGDONG_MAIN_USE_CD;
			}

			/**
			 * @return the bLDGDONG_SUB_USE_CD
			 */
			public String getBLDGDONG_SUB_USE_CD() {
				return BLDGDONG_SUB_USE_CD;
			}

			/**
			 * @param bLDGDONG_SUB_USE_CD the bLDGDONG_SUB_USE_CD to set
			 */
			public void setBLDGDONG_SUB_USE_CD(String bLDGDONG_SUB_USE_CD) {
				BLDGDONG_SUB_USE_CD = bLDGDONG_SUB_USE_CD;
			}

			/**
			 * @return the bLDGDONG_MAIN_USE_CDNAME
			 */
			public String getBLDGDONG_MAIN_USE_CDNAME() {
				return BLDGDONG_MAIN_USE_CDNAME;
			}

			/**
			 * @param bLDGDONG_MAIN_USE_CDNAME the bLDGDONG_MAIN_USE_CDNAME to set
			 */
			public void setBLDGDONG_MAIN_USE_CDNAME(String bLDGDONG_MAIN_USE_CDNAME) {
				BLDGDONG_MAIN_USE_CDNAME = bLDGDONG_MAIN_USE_CDNAME;
			}

			/**
			 * @return the bLDGDONG_SUB_USE_CDNAME
			 */
			public String getBLDGDONG_SUB_USE_CDNAME() {
				return BLDGDONG_SUB_USE_CDNAME;
			}

			/**
			 * @param bLDGDONG_SUB_USE_CDNAME the bLDGDONG_SUB_USE_CDNAME to set
			 */
			public void setBLDGDONG_SUB_USE_CDNAME(String bLDGDONG_SUB_USE_CDNAME) {
				BLDGDONG_SUB_USE_CDNAME = bLDGDONG_SUB_USE_CDNAME;
			}

			/**
			 * @return the cONST_REGSTR_PK
			 */
			public String getCONST_REGSTR_PK() {
				return CONST_REGSTR_PK;
			}

			/**
			 * @param cONST_REGSTR_PK the cONST_REGSTR_PK to set
			 */
			public void setCONST_REGSTR_PK(String cONST_REGSTR_PK) {
				CONST_REGSTR_PK = cONST_REGSTR_PK;
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
				session.selectList("SQL.SUPPORT.NGAVL_VL12002", map);
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
