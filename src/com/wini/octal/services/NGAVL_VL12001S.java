package com.wini.octal.services;

import java.io.File;
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
import com.wini.octal.ftp.FTPUtil;
import com.wini.octal.ftp.SFTPUtil;
import com.wini.octal.inout.InputClass;

import static com.wini.octal.conf.ConfigContext.*;
import static com.wini.octal.conf.Prop.*;

@Component
@Scope("prototype")
public class NGAVL_VL12001S extends JsonSvcIF<NGAVL_VL12001S.In, NGAVL_VL12001S.Out> implements Runnable {
				
		public NGAVL_VL12001S(MessageEvent e, HttpRequest request) {
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
			private String 	OBJ_ID;
			private String 	WARD_ID;
			private String 	OBJ_MAN_NUM;
			private String 	USED_CD;
			private String 	USED_CDNAME;
			private String 	SPACE1;
			private String 	OBJ_CD;
			private String 	OBJ_CDNAME;
			private String 	CONST_NAME;
			private String 	RPSN_FIRM_NAME;
			private String 	SIDO_CD;
			private String 	GUGUN_CD;
			private String 	DONG_CD;
			private String 	RI_CD;
			private String 	HOUSE_NO;
			private String 	ETC_ADDR;
			private String 	ZIP_CODE;
			private String 	OBJ_STD_CD;
			private String 	OBJ_STD_CDNAME;
			private String 	ETC_OBJ_CLS_CD;
			private String 	ETC_OBJ_CLS_CDNAME;
			private String 	SAN_ADDRNO_YN;
			private String 	MAIN_BLDG_NO;
			private String 	SUB_BLDG_NO;
			private String 	BLDG_NM;
			private String 	BLDG_NM_ETC;
			private String 	ROAD_NM;
			private String 	SPACE2;
			private String 	SPACE3;
			private String 	SPACE4;
			private String 	SPACE5;
			private String 	WEAKOBJ_YN;
			private String 	SELFOBJ_YN;
			private String 	PUB_FMGROBJ_YN;
			private String 	SPACE6;
			private String 	ADJ_INFO;
			private String 	SPACE7;
			private String 	SPACE8;
			private String 	SPACE9;
			private String 	SPACE10;
			private String 	SPACE11;
			private String 	SPACE12;
			private String 	DAY_TEL;
			private String 	NIGHT_TEL;
			private String 	INSU_JOIN_DATE;
			private String 	INSU_EXPIRE_DATE;
			private String 	INSU_CO_NAME;
			private String 	INSU_JOIN_OBJ;
			private String 	INSU_CONTR_AMT;
			private String 	PREVDST_TEL;
			private String 	USE_CONFM_DATE;
			private String 	INSTIT_YN;
			private String 	INSTIT_CLS_CD;
			private String 	INSTIT_CLS_CDNAME;
			private String 	PUBFACL_YN;
			private String 	NEW_PUBFACL_YN;
			private String 	WEAKOBJ_CD;
			private String 	WEAKOBJ_CDNAME;
			private String 	FEQUIP_EWORK_CONFM_DATE;
			private String 	TUNNEL_CLS_CD;
			private String 	TUNNEL_CLS_CDNAME;
			private String 	TUNNEL_LENGTH;
			private String 	SUB_USE_DESC;
			private String 	FEQUIP_SPEC_5HO_YN;
			private String 	FEQUIP_SPEC_6HO_YN;
			private String 	FEQUIP_SPEC_5HO_RSN_CD;
			private String 	FEQUIP_SPEC_5HO_RSN_CDNAME;
			private String 	FEQUIP_SPEC_6HO_RSN_CD;
			private String 	FEQUIP_SPEC_6HO_RSN_CDNAME;
			private String 	OLD_OBJ_MAN_NUM;
			private String 	FIRE_MK_YN;
			private String 	BLDG_REGSTR_PK;
			private String 	SPACE13;
			private String 	WARD_NAME;
			
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
			 * @return the oBJ_MAN_NUM
			 */
			public String getOBJ_MAN_NUM() {
				return OBJ_MAN_NUM;
			}

			/**
			 * @param oBJ_MAN_NUM the oBJ_MAN_NUM to set
			 */
			public void setOBJ_MAN_NUM(String oBJ_MAN_NUM) {
				OBJ_MAN_NUM = oBJ_MAN_NUM;
			}

			/**
			 * @return the uSED_CD
			 */
			public String getUSED_CD() {
				return USED_CD;
			}

			/**
			 * @param uSED_CD the uSED_CD to set
			 */
			public void setUSED_CD(String uSED_CD) {
				USED_CD = uSED_CD;
			}

			/**
			 * @return the uSED_CDNAME
			 */
			public String getUSED_CDNAME() {
				return USED_CDNAME;
			}

			/**
			 * @param uSED_CDNAME the uSED_CDNAME to set
			 */
			public void setUSED_CDNAME(String uSED_CDNAME) {
				USED_CDNAME = uSED_CDNAME;
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
			 * @return the oBJ_CDNAME
			 */
			public String getOBJ_CDNAME() {
				return OBJ_CDNAME;
			}

			/**
			 * @param oBJ_CDNAME the oBJ_CDNAME to set
			 */
			public void setOBJ_CDNAME(String oBJ_CDNAME) {
				OBJ_CDNAME = oBJ_CDNAME;
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
			 * @return the oBJ_STD_CD
			 */
			public String getOBJ_STD_CD() {
				return OBJ_STD_CD;
			}

			/**
			 * @param oBJ_STD_CD the oBJ_STD_CD to set
			 */
			public void setOBJ_STD_CD(String oBJ_STD_CD) {
				OBJ_STD_CD = oBJ_STD_CD;
			}

			/**
			 * @return the oBJ_STD_CDNAME
			 */
			public String getOBJ_STD_CDNAME() {
				return OBJ_STD_CDNAME;
			}

			/**
			 * @param oBJ_STD_CDNAME the oBJ_STD_CDNAME to set
			 */
			public void setOBJ_STD_CDNAME(String oBJ_STD_CDNAME) {
				OBJ_STD_CDNAME = oBJ_STD_CDNAME;
			}

			/**
			 * @return the eTC_OBJ_CLS_CD
			 */
			public String getETC_OBJ_CLS_CD() {
				return ETC_OBJ_CLS_CD;
			}

			/**
			 * @param eTC_OBJ_CLS_CD the eTC_OBJ_CLS_CD to set
			 */
			public void setETC_OBJ_CLS_CD(String eTC_OBJ_CLS_CD) {
				ETC_OBJ_CLS_CD = eTC_OBJ_CLS_CD;
			}

			/**
			 * @return the eTC_OBJ_CLS_CDNAME
			 */
			public String getETC_OBJ_CLS_CDNAME() {
				return ETC_OBJ_CLS_CDNAME;
			}

			/**
			 * @param eTC_OBJ_CLS_CDNAME the eTC_OBJ_CLS_CDNAME to set
			 */
			public void setETC_OBJ_CLS_CDNAME(String eTC_OBJ_CLS_CDNAME) {
				ETC_OBJ_CLS_CDNAME = eTC_OBJ_CLS_CDNAME;
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
			 * @return the mAIN_BLDG_NO
			 */
			public String getMAIN_BLDG_NO() {
				return MAIN_BLDG_NO;
			}

			/**
			 * @param mAIN_BLDG_NO the mAIN_BLDG_NO to set
			 */
			public void setMAIN_BLDG_NO(String mAIN_BLDG_NO) {
				MAIN_BLDG_NO = mAIN_BLDG_NO;
			}

			/**
			 * @return the sUB_BLDG_NO
			 */
			public String getSUB_BLDG_NO() {
				return SUB_BLDG_NO;
			}

			/**
			 * @param sUB_BLDG_NO the sUB_BLDG_NO to set
			 */
			public void setSUB_BLDG_NO(String sUB_BLDG_NO) {
				SUB_BLDG_NO = sUB_BLDG_NO;
			}

			/**
			 * @return the bLDG_NM
			 */
			public String getBLDG_NM() {
				return BLDG_NM;
			}

			/**
			 * @param bLDG_NM the bLDG_NM to set
			 */
			public void setBLDG_NM(String bLDG_NM) {
				BLDG_NM = bLDG_NM;
			}

			/**
			 * @return the bLDG_NM_ETC
			 */
			public String getBLDG_NM_ETC() {
				return BLDG_NM_ETC;
			}

			/**
			 * @param bLDG_NM_ETC the bLDG_NM_ETC to set
			 */
			public void setBLDG_NM_ETC(String bLDG_NM_ETC) {
				BLDG_NM_ETC = bLDG_NM_ETC;
			}

			/**
			 * @return the rOAD_NM
			 */
			public String getROAD_NM() {
				return ROAD_NM;
			}

			/**
			 * @param rOAD_NM the rOAD_NM to set
			 */
			public void setROAD_NM(String rOAD_NM) {
				ROAD_NM = rOAD_NM;
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
			 * @return the sPACE3
			 */
			public String getSPACE3() {
				return SPACE3;
			}

			/**
			 * @param sPACE3 the sPACE3 to set
			 */
			public void setSPACE3(String sPACE3) {
				SPACE3 = sPACE3;
			}

			/**
			 * @return the sPACE4
			 */
			public String getSPACE4() {
				return SPACE4;
			}

			/**
			 * @param sPACE4 the sPACE4 to set
			 */
			public void setSPACE4(String sPACE4) {
				SPACE4 = sPACE4;
			}

			/**
			 * @return the sPACE5
			 */
			public String getSPACE5() {
				return SPACE5;
			}

			/**
			 * @param sPACE5 the sPACE5 to set
			 */
			public void setSPACE5(String sPACE5) {
				SPACE5 = sPACE5;
			}

			/**
			 * @return the wEAKOBJ_YN
			 */
			public String getWEAKOBJ_YN() {
				return WEAKOBJ_YN;
			}

			/**
			 * @param wEAKOBJ_YN the wEAKOBJ_YN to set
			 */
			public void setWEAKOBJ_YN(String wEAKOBJ_YN) {
				WEAKOBJ_YN = wEAKOBJ_YN;
			}

			/**
			 * @return the sELFOBJ_YN
			 */
			public String getSELFOBJ_YN() {
				return SELFOBJ_YN;
			}

			/**
			 * @param sELFOBJ_YN the sELFOBJ_YN to set
			 */
			public void setSELFOBJ_YN(String sELFOBJ_YN) {
				SELFOBJ_YN = sELFOBJ_YN;
			}

			/**
			 * @return the pUB_FMGROBJ_YN
			 */
			public String getPUB_FMGROBJ_YN() {
				return PUB_FMGROBJ_YN;
			}

			/**
			 * @param pUB_FMGROBJ_YN the pUB_FMGROBJ_YN to set
			 */
			public void setPUB_FMGROBJ_YN(String pUB_FMGROBJ_YN) {
				PUB_FMGROBJ_YN = pUB_FMGROBJ_YN;
			}

			/**
			 * @return the sPACE6
			 */
			public String getSPACE6() {
				return SPACE6;
			}

			/**
			 * @param sPACE6 the sPACE6 to set
			 */
			public void setSPACE6(String sPACE6) {
				SPACE6 = sPACE6;
			}

			/**
			 * @return the aDJ_INFO
			 */
			public String getADJ_INFO() {
				return ADJ_INFO;
			}

			/**
			 * @param aDJ_INFO the aDJ_INFO to set
			 */
			public void setADJ_INFO(String aDJ_INFO) {
				ADJ_INFO = aDJ_INFO;
			}

			/**
			 * @return the sPACE7
			 */
			public String getSPACE7() {
				return SPACE7;
			}

			/**
			 * @param sPACE7 the sPACE7 to set
			 */
			public void setSPACE7(String sPACE7) {
				SPACE7 = sPACE7;
			}

			/**
			 * @return the sPACE8
			 */
			public String getSPACE8() {
				return SPACE8;
			}

			/**
			 * @param sPACE8 the sPACE8 to set
			 */
			public void setSPACE8(String sPACE8) {
				SPACE8 = sPACE8;
			}

			/**
			 * @return the sPACE9
			 */
			public String getSPACE9() {
				return SPACE9;
			}

			/**
			 * @param sPACE9 the sPACE9 to set
			 */
			public void setSPACE9(String sPACE9) {
				SPACE9 = sPACE9;
			}

			/**
			 * @return the sPACE10
			 */
			public String getSPACE10() {
				return SPACE10;
			}

			/**
			 * @param sPACE10 the sPACE10 to set
			 */
			public void setSPACE10(String sPACE10) {
				SPACE10 = sPACE10;
			}

			/**
			 * @return the sPACE11
			 */
			public String getSPACE11() {
				return SPACE11;
			}

			/**
			 * @param sPACE11 the sPACE11 to set
			 */
			public void setSPACE11(String sPACE11) {
				SPACE11 = sPACE11;
			}

			/**
			 * @return the sPACE12
			 */
			public String getSPACE12() {
				return SPACE12;
			}

			/**
			 * @param sPACE12 the sPACE12 to set
			 */
			public void setSPACE12(String sPACE12) {
				SPACE12 = sPACE12;
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
			 * @return the iNSU_JOIN_DATE
			 */
			public String getINSU_JOIN_DATE() {
				return INSU_JOIN_DATE;
			}

			/**
			 * @param iNSU_JOIN_DATE the iNSU_JOIN_DATE to set
			 */
			public void setINSU_JOIN_DATE(String iNSU_JOIN_DATE) {
				INSU_JOIN_DATE = iNSU_JOIN_DATE;
			}

			/**
			 * @return the iNSU_EXPIRE_DATE
			 */
			public String getINSU_EXPIRE_DATE() {
				return INSU_EXPIRE_DATE;
			}

			/**
			 * @param iNSU_EXPIRE_DATE the iNSU_EXPIRE_DATE to set
			 */
			public void setINSU_EXPIRE_DATE(String iNSU_EXPIRE_DATE) {
				INSU_EXPIRE_DATE = iNSU_EXPIRE_DATE;
			}

			/**
			 * @return the iNSU_CO_NAME
			 */
			public String getINSU_CO_NAME() {
				return INSU_CO_NAME;
			}

			/**
			 * @param iNSU_CO_NAME the iNSU_CO_NAME to set
			 */
			public void setINSU_CO_NAME(String iNSU_CO_NAME) {
				INSU_CO_NAME = iNSU_CO_NAME;
			}

			/**
			 * @return the iNSU_JOIN_OBJ
			 */
			public String getINSU_JOIN_OBJ() {
				return INSU_JOIN_OBJ;
			}

			/**
			 * @param iNSU_JOIN_OBJ the iNSU_JOIN_OBJ to set
			 */
			public void setINSU_JOIN_OBJ(String iNSU_JOIN_OBJ) {
				INSU_JOIN_OBJ = iNSU_JOIN_OBJ;
			}

			/**
			 * @return the iNSU_CONTR_AMT
			 */
			public String getINSU_CONTR_AMT() {
				return INSU_CONTR_AMT;
			}

			/**
			 * @param iNSU_CONTR_AMT the iNSU_CONTR_AMT to set
			 */
			public void setINSU_CONTR_AMT(String iNSU_CONTR_AMT) {
				INSU_CONTR_AMT = iNSU_CONTR_AMT;
			}

			/**
			 * @return the pREVDST_TEL
			 */
			public String getPREVDST_TEL() {
				return PREVDST_TEL;
			}

			/**
			 * @param pREVDST_TEL the pREVDST_TEL to set
			 */
			public void setPREVDST_TEL(String pREVDST_TEL) {
				PREVDST_TEL = pREVDST_TEL;
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
			 * @return the iNSTIT_YN
			 */
			public String getINSTIT_YN() {
				return INSTIT_YN;
			}

			/**
			 * @param iNSTIT_YN the iNSTIT_YN to set
			 */
			public void setINSTIT_YN(String iNSTIT_YN) {
				INSTIT_YN = iNSTIT_YN;
			}

			/**
			 * @return the iNSTIT_CLS_CD
			 */
			public String getINSTIT_CLS_CD() {
				return INSTIT_CLS_CD;
			}

			/**
			 * @param iNSTIT_CLS_CD the iNSTIT_CLS_CD to set
			 */
			public void setINSTIT_CLS_CD(String iNSTIT_CLS_CD) {
				INSTIT_CLS_CD = iNSTIT_CLS_CD;
			}

			/**
			 * @return the iNSTIT_CLS_CDNAME
			 */
			public String getINSTIT_CLS_CDNAME() {
				return INSTIT_CLS_CDNAME;
			}

			/**
			 * @param iNSTIT_CLS_CDNAME the iNSTIT_CLS_CDNAME to set
			 */
			public void setINSTIT_CLS_CDNAME(String iNSTIT_CLS_CDNAME) {
				INSTIT_CLS_CDNAME = iNSTIT_CLS_CDNAME;
			}

			/**
			 * @return the pUBFACL_YN
			 */
			public String getPUBFACL_YN() {
				return PUBFACL_YN;
			}

			/**
			 * @param pUBFACL_YN the pUBFACL_YN to set
			 */
			public void setPUBFACL_YN(String pUBFACL_YN) {
				PUBFACL_YN = pUBFACL_YN;
			}

			/**
			 * @return the nEW_PUBFACL_YN
			 */
			public String getNEW_PUBFACL_YN() {
				return NEW_PUBFACL_YN;
			}

			/**
			 * @param nEW_PUBFACL_YN the nEW_PUBFACL_YN to set
			 */
			public void setNEW_PUBFACL_YN(String nEW_PUBFACL_YN) {
				NEW_PUBFACL_YN = nEW_PUBFACL_YN;
			}

			/**
			 * @return the wEAKOBJ_CD
			 */
			public String getWEAKOBJ_CD() {
				return WEAKOBJ_CD;
			}

			/**
			 * @param wEAKOBJ_CD the wEAKOBJ_CD to set
			 */
			public void setWEAKOBJ_CD(String wEAKOBJ_CD) {
				WEAKOBJ_CD = wEAKOBJ_CD;
			}

			/**
			 * @return the wEAKOBJ_CDNAME
			 */
			public String getWEAKOBJ_CDNAME() {
				return WEAKOBJ_CDNAME;
			}

			/**
			 * @param wEAKOBJ_CDNAME the wEAKOBJ_CDNAME to set
			 */
			public void setWEAKOBJ_CDNAME(String wEAKOBJ_CDNAME) {
				WEAKOBJ_CDNAME = wEAKOBJ_CDNAME;
			}

			/**
			 * @return the fEQUIP_EWORK_CONFM_DATE
			 */
			public String getFEQUIP_EWORK_CONFM_DATE() {
				return FEQUIP_EWORK_CONFM_DATE;
			}

			/**
			 * @param fEQUIP_EWORK_CONFM_DATE the fEQUIP_EWORK_CONFM_DATE to set
			 */
			public void setFEQUIP_EWORK_CONFM_DATE(String fEQUIP_EWORK_CONFM_DATE) {
				FEQUIP_EWORK_CONFM_DATE = fEQUIP_EWORK_CONFM_DATE;
			}

			/**
			 * @return the tUNNEL_CLS_CD
			 */
			public String getTUNNEL_CLS_CD() {
				return TUNNEL_CLS_CD;
			}

			/**
			 * @param tUNNEL_CLS_CD the tUNNEL_CLS_CD to set
			 */
			public void setTUNNEL_CLS_CD(String tUNNEL_CLS_CD) {
				TUNNEL_CLS_CD = tUNNEL_CLS_CD;
			}

			/**
			 * @return the tUNNEL_CLS_CDNAME
			 */
			public String getTUNNEL_CLS_CDNAME() {
				return TUNNEL_CLS_CDNAME;
			}

			/**
			 * @param tUNNEL_CLS_CDNAME the tUNNEL_CLS_CDNAME to set
			 */
			public void setTUNNEL_CLS_CDNAME(String tUNNEL_CLS_CDNAME) {
				TUNNEL_CLS_CDNAME = tUNNEL_CLS_CDNAME;
			}

			/**
			 * @return the tUNNEL_LENGTH
			 */
			public String getTUNNEL_LENGTH() {
				return TUNNEL_LENGTH;
			}

			/**
			 * @param tUNNEL_LENGTH the tUNNEL_LENGTH to set
			 */
			public void setTUNNEL_LENGTH(String tUNNEL_LENGTH) {
				TUNNEL_LENGTH = tUNNEL_LENGTH;
			}

			/**
			 * @return the sUB_USE_DESC
			 */
			public String getSUB_USE_DESC() {
				return SUB_USE_DESC;
			}

			/**
			 * @param sUB_USE_DESC the sUB_USE_DESC to set
			 */
			public void setSUB_USE_DESC(String sUB_USE_DESC) {
				SUB_USE_DESC = sUB_USE_DESC;
			}

			/**
			 * @return the fEQUIP_SPEC_5HO_YN
			 */
			public String getFEQUIP_SPEC_5HO_YN() {
				return FEQUIP_SPEC_5HO_YN;
			}

			/**
			 * @param fEQUIP_SPEC_5HO_YN the fEQUIP_SPEC_5HO_YN to set
			 */
			public void setFEQUIP_SPEC_5HO_YN(String fEQUIP_SPEC_5HO_YN) {
				FEQUIP_SPEC_5HO_YN = fEQUIP_SPEC_5HO_YN;
			}

			/**
			 * @return the fEQUIP_SPEC_6HO_YN
			 */
			public String getFEQUIP_SPEC_6HO_YN() {
				return FEQUIP_SPEC_6HO_YN;
			}

			/**
			 * @param fEQUIP_SPEC_6HO_YN the fEQUIP_SPEC_6HO_YN to set
			 */
			public void setFEQUIP_SPEC_6HO_YN(String fEQUIP_SPEC_6HO_YN) {
				FEQUIP_SPEC_6HO_YN = fEQUIP_SPEC_6HO_YN;
			}

			/**
			 * @return the fEQUIP_SPEC_5HO_RSN_CD
			 */
			public String getFEQUIP_SPEC_5HO_RSN_CD() {
				return FEQUIP_SPEC_5HO_RSN_CD;
			}

			/**
			 * @param fEQUIP_SPEC_5HO_RSN_CD the fEQUIP_SPEC_5HO_RSN_CD to set
			 */
			public void setFEQUIP_SPEC_5HO_RSN_CD(String fEQUIP_SPEC_5HO_RSN_CD) {
				FEQUIP_SPEC_5HO_RSN_CD = fEQUIP_SPEC_5HO_RSN_CD;
			}

			/**
			 * @return the fEQUIP_SPEC_5HO_RSN_CDNAME
			 */
			public String getFEQUIP_SPEC_5HO_RSN_CDNAME() {
				return FEQUIP_SPEC_5HO_RSN_CDNAME;
			}

			/**
			 * @param fEQUIP_SPEC_5HO_RSN_CDNAME the fEQUIP_SPEC_5HO_RSN_CDNAME to set
			 */
			public void setFEQUIP_SPEC_5HO_RSN_CDNAME(String fEQUIP_SPEC_5HO_RSN_CDNAME) {
				FEQUIP_SPEC_5HO_RSN_CDNAME = fEQUIP_SPEC_5HO_RSN_CDNAME;
			}

			/**
			 * @return the fEQUIP_SPEC_6HO_RSN_CD
			 */
			public String getFEQUIP_SPEC_6HO_RSN_CD() {
				return FEQUIP_SPEC_6HO_RSN_CD;
			}

			/**
			 * @param fEQUIP_SPEC_6HO_RSN_CD the fEQUIP_SPEC_6HO_RSN_CD to set
			 */
			public void setFEQUIP_SPEC_6HO_RSN_CD(String fEQUIP_SPEC_6HO_RSN_CD) {
				FEQUIP_SPEC_6HO_RSN_CD = fEQUIP_SPEC_6HO_RSN_CD;
			}

			/**
			 * @return the fEQUIP_SPEC_6HO_RSN_CDNAME
			 */
			public String getFEQUIP_SPEC_6HO_RSN_CDNAME() {
				return FEQUIP_SPEC_6HO_RSN_CDNAME;
			}

			/**
			 * @param fEQUIP_SPEC_6HO_RSN_CDNAME the fEQUIP_SPEC_6HO_RSN_CDNAME to set
			 */
			public void setFEQUIP_SPEC_6HO_RSN_CDNAME(String fEQUIP_SPEC_6HO_RSN_CDNAME) {
				FEQUIP_SPEC_6HO_RSN_CDNAME = fEQUIP_SPEC_6HO_RSN_CDNAME;
			}

			/**
			 * @return the oLD_OBJ_MAN_NUM
			 */
			public String getOLD_OBJ_MAN_NUM() {
				return OLD_OBJ_MAN_NUM;
			}

			/**
			 * @param oLD_OBJ_MAN_NUM the oLD_OBJ_MAN_NUM to set
			 */
			public void setOLD_OBJ_MAN_NUM(String oLD_OBJ_MAN_NUM) {
				OLD_OBJ_MAN_NUM = oLD_OBJ_MAN_NUM;
			}

			/**
			 * @return the fIRE_MK_YN
			 */
			public String getFIRE_MK_YN() {
				return FIRE_MK_YN;
			}

			/**
			 * @param fIRE_MK_YN the fIRE_MK_YN to set
			 */
			public void setFIRE_MK_YN(String fIRE_MK_YN) {
				FIRE_MK_YN = fIRE_MK_YN;
			}

			/**
			 * @return the bLDG_REGSTR_PK
			 */
			public String getBLDG_REGSTR_PK() {
				return BLDG_REGSTR_PK;
			}

			/**
			 * @param bLDG_REGSTR_PK the bLDG_REGSTR_PK to set
			 */
			public void setBLDG_REGSTR_PK(String bLDG_REGSTR_PK) {
				BLDG_REGSTR_PK = bLDG_REGSTR_PK;
			}

			/**
			 * @return the sPACE13
			 */
			public String getSPACE13() {
				return SPACE13;
			}

			/**
			 * @param sPACE13 the sPACE13 to set
			 */
			public void setSPACE13(String sPACE13) {
				SPACE13 = sPACE13;
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

		}

		
		@Override
		public void run() {
			// Input get
			InputClass<In> input = getInput(new TypeToken<InputClass<In>>(){}.getType());
			Map<String, Object> map = Object2Map(input.getParam().get(0));
			List<Map<String, String>> images = null;
			String path = "";
			
			// DB serv
			SqlSession session = null;
			try {
				session = SqlSessionManager.getSqlSession().openSession();
				session.selectList("SQL.SUPPORT.NGAVL_VL12009", map);
			} catch(Exception e) {
				logger.error("Unexpected exception from DB.", e.getCause());
				throw (RuntimeException)e;
			} finally {
				session.close();
			}
			
			images = (List)map.get("LIST_CURSOR");
			
			try {
				session = SqlSessionManager.getSqlSession().openSession();
				session.selectList("SQL.SUPPORT.NGAVL_VL12001", map);
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
			
			// Ftp Image Down
			path = getClass().getResource("/").getPath()
					.replaceAll("/WEB-INF/classes/", "/")+"/NGAVL/gi_data/";
			
			File dir = new File(path);
			if(!dir.exists()) dir.mkdirs();
			
			if(CONFIG_INSTNACE.getProperty(FtpType).equalsIgnoreCase("SFTP")) {
				SFTPUtil sftp = new SFTPUtil();
				sftp.init(CONFIG_INSTNACE.getProperty(FtpIp), CONFIG_INSTNACE.getProperty(FtpId)
						, CONFIG_INSTNACE.getProperty(FtpPasswd)
						, CONFIG_INSTNACE.getProperty2Int(FtpPort));
				sftp.download(images, path);
				sftp.disconnection();
			} else {
				FTPUtil ftputil = new FTPUtil();
				ftputil.FtpGet(CONFIG_INSTNACE.getProperty(FtpIp)
						, CONFIG_INSTNACE.getProperty2Int(FtpPort)
						, CONFIG_INSTNACE.getProperty(FtpId), CONFIG_INSTNACE.getProperty(FtpPasswd)
						, path, images);
			}
			
		}
	}
