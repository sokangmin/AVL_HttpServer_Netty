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
public class NGAVL_VL12003 extends JsonSvcIF<NGAVL_VL12003.In, NGAVL_VL12003.Out> implements Runnable {
				
		public NGAVL_VL12003(MessageEvent e, HttpRequest request) {
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
			private String 	BLDG_NAME;
			private String 	STORY_NO;
			private String 	SPEC_USE_CLS_CD;
			private String 	SPEC_USE_CLS_CDNAME;
			private String 	STORY_AREA;
			private String 	ETC;
			private String 	IN_EXTING_YN;
			private String 	OUT_EXTING_YN;
			private String 	EXTING_PUMP_YN;
			private String 	SPRINKLER_H_YN;
			private String 	SPRINKLER_AV_YN;
			private String 	SPRAY_EXTING_H_YN;
			private String 	SPRAY_EXTING_AV_YN;
			private String 	PO_EXTING_H_YN;
			private String 	PO_EXTING_AV_YN;
			private String 	CARBON_DIOX_H_YN;
			private String 	CARBON_DIOX_AV_YN;
			private String 	HALOGEN_COMP_H_YN;
			private String 	HALOGEN_COMP_AV_YN;
			private String 	POWDER_EXTING_H_YN;
			private String 	POWDER_EXTING_AV_YN;
			private String 	SLIDE_YN;
			private String 	LADDER_YN;
			private String 	RESCUE_YN;
			private String 	WANKWANG_YN;
			private String 	MEASURE_EQUIP_YN;
			private String 	MEASURE_ROPE_YN;
			private String 	SAFE_MAT_YN;
			private String 	RESCUE_EQUIP_YN;
			private String 	EMG_LIGHT_YN;
			private String 	WATER_EXTING_YN;
			private String 	EXTING_WATER_YN;
			private String 	LWTR_YN;
			private String 	RESMOKE_YN;
			private String 	WTRPIPE_YN;
			private String 	WATER_SPRINGKLING_YN;
			private String 	EMG_PLUG_YN;
			private String 	WIRELESS_COMM_YN;

			
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
			 * @return the sTORY_NO
			 */
			public String getSTORY_NO() {
				return STORY_NO;
			}


			/**
			 * @param sTORY_NO the sTORY_NO to set
			 */
			public void setSTORY_NO(String sTORY_NO) {
				STORY_NO = sTORY_NO;
			}


			/**
			 * @return the sPEC_USE_CLS_CD
			 */
			public String getSPEC_USE_CLS_CD() {
				return SPEC_USE_CLS_CD;
			}


			/**
			 * @param sPEC_USE_CLS_CD the sPEC_USE_CLS_CD to set
			 */
			public void setSPEC_USE_CLS_CD(String sPEC_USE_CLS_CD) {
				SPEC_USE_CLS_CD = sPEC_USE_CLS_CD;
			}


			/**
			 * @return the sPEC_USE_CLS_CDNAME
			 */
			public String getSPEC_USE_CLS_CDNAME() {
				return SPEC_USE_CLS_CDNAME;
			}


			/**
			 * @param sPEC_USE_CLS_CDNAME the sPEC_USE_CLS_CDNAME to set
			 */
			public void setSPEC_USE_CLS_CDNAME(String sPEC_USE_CLS_CDNAME) {
				SPEC_USE_CLS_CDNAME = sPEC_USE_CLS_CDNAME;
			}


			/**
			 * @return the sTORY_AREA
			 */
			public String getSTORY_AREA() {
				return STORY_AREA;
			}


			/**
			 * @param sTORY_AREA the sTORY_AREA to set
			 */
			public void setSTORY_AREA(String sTORY_AREA) {
				STORY_AREA = sTORY_AREA;
			}


			/**
			 * @return the eTC
			 */
			public String getETC() {
				return ETC;
			}


			/**
			 * @param eTC the eTC to set
			 */
			public void setETC(String eTC) {
				ETC = eTC;
			}


			/**
			 * @return the iN_EXTING_YN
			 */
			public String getIN_EXTING_YN() {
				return IN_EXTING_YN;
			}


			/**
			 * @param iN_EXTING_YN the iN_EXTING_YN to set
			 */
			public void setIN_EXTING_YN(String iN_EXTING_YN) {
				IN_EXTING_YN = iN_EXTING_YN;
			}


			/**
			 * @return the oUT_EXTING_YN
			 */
			public String getOUT_EXTING_YN() {
				return OUT_EXTING_YN;
			}


			/**
			 * @param oUT_EXTING_YN the oUT_EXTING_YN to set
			 */
			public void setOUT_EXTING_YN(String oUT_EXTING_YN) {
				OUT_EXTING_YN = oUT_EXTING_YN;
			}


			/**
			 * @return the eXTING_PUMP_YN
			 */
			public String getEXTING_PUMP_YN() {
				return EXTING_PUMP_YN;
			}


			/**
			 * @param eXTING_PUMP_YN the eXTING_PUMP_YN to set
			 */
			public void setEXTING_PUMP_YN(String eXTING_PUMP_YN) {
				EXTING_PUMP_YN = eXTING_PUMP_YN;
			}


			/**
			 * @return the sPRINKLER_H_YN
			 */
			public String getSPRINKLER_H_YN() {
				return SPRINKLER_H_YN;
			}


			/**
			 * @param sPRINKLER_H_YN the sPRINKLER_H_YN to set
			 */
			public void setSPRINKLER_H_YN(String sPRINKLER_H_YN) {
				SPRINKLER_H_YN = sPRINKLER_H_YN;
			}


			/**
			 * @return the sPRINKLER_AV_YN
			 */
			public String getSPRINKLER_AV_YN() {
				return SPRINKLER_AV_YN;
			}


			/**
			 * @param sPRINKLER_AV_YN the sPRINKLER_AV_YN to set
			 */
			public void setSPRINKLER_AV_YN(String sPRINKLER_AV_YN) {
				SPRINKLER_AV_YN = sPRINKLER_AV_YN;
			}


			/**
			 * @return the sPRAY_EXTING_H_YN
			 */
			public String getSPRAY_EXTING_H_YN() {
				return SPRAY_EXTING_H_YN;
			}


			/**
			 * @param sPRAY_EXTING_H_YN the sPRAY_EXTING_H_YN to set
			 */
			public void setSPRAY_EXTING_H_YN(String sPRAY_EXTING_H_YN) {
				SPRAY_EXTING_H_YN = sPRAY_EXTING_H_YN;
			}


			/**
			 * @return the sPRAY_EXTING_AV_YN
			 */
			public String getSPRAY_EXTING_AV_YN() {
				return SPRAY_EXTING_AV_YN;
			}


			/**
			 * @param sPRAY_EXTING_AV_YN the sPRAY_EXTING_AV_YN to set
			 */
			public void setSPRAY_EXTING_AV_YN(String sPRAY_EXTING_AV_YN) {
				SPRAY_EXTING_AV_YN = sPRAY_EXTING_AV_YN;
			}


			/**
			 * @return the pO_EXTING_H_YN
			 */
			public String getPO_EXTING_H_YN() {
				return PO_EXTING_H_YN;
			}


			/**
			 * @param pO_EXTING_H_YN the pO_EXTING_H_YN to set
			 */
			public void setPO_EXTING_H_YN(String pO_EXTING_H_YN) {
				PO_EXTING_H_YN = pO_EXTING_H_YN;
			}


			/**
			 * @return the pO_EXTING_AV_YN
			 */
			public String getPO_EXTING_AV_YN() {
				return PO_EXTING_AV_YN;
			}


			/**
			 * @param pO_EXTING_AV_YN the pO_EXTING_AV_YN to set
			 */
			public void setPO_EXTING_AV_YN(String pO_EXTING_AV_YN) {
				PO_EXTING_AV_YN = pO_EXTING_AV_YN;
			}


			/**
			 * @return the cARBON_DIOX_H_YN
			 */
			public String getCARBON_DIOX_H_YN() {
				return CARBON_DIOX_H_YN;
			}


			/**
			 * @param cARBON_DIOX_H_YN the cARBON_DIOX_H_YN to set
			 */
			public void setCARBON_DIOX_H_YN(String cARBON_DIOX_H_YN) {
				CARBON_DIOX_H_YN = cARBON_DIOX_H_YN;
			}


			/**
			 * @return the cARBON_DIOX_AV_YN
			 */
			public String getCARBON_DIOX_AV_YN() {
				return CARBON_DIOX_AV_YN;
			}


			/**
			 * @param cARBON_DIOX_AV_YN the cARBON_DIOX_AV_YN to set
			 */
			public void setCARBON_DIOX_AV_YN(String cARBON_DIOX_AV_YN) {
				CARBON_DIOX_AV_YN = cARBON_DIOX_AV_YN;
			}


			/**
			 * @return the hALOGEN_COMP_H_YN
			 */
			public String getHALOGEN_COMP_H_YN() {
				return HALOGEN_COMP_H_YN;
			}


			/**
			 * @param hALOGEN_COMP_H_YN the hALOGEN_COMP_H_YN to set
			 */
			public void setHALOGEN_COMP_H_YN(String hALOGEN_COMP_H_YN) {
				HALOGEN_COMP_H_YN = hALOGEN_COMP_H_YN;
			}


			/**
			 * @return the hALOGEN_COMP_AV_YN
			 */
			public String getHALOGEN_COMP_AV_YN() {
				return HALOGEN_COMP_AV_YN;
			}


			/**
			 * @param hALOGEN_COMP_AV_YN the hALOGEN_COMP_AV_YN to set
			 */
			public void setHALOGEN_COMP_AV_YN(String hALOGEN_COMP_AV_YN) {
				HALOGEN_COMP_AV_YN = hALOGEN_COMP_AV_YN;
			}


			/**
			 * @return the pOWDER_EXTING_H_YN
			 */
			public String getPOWDER_EXTING_H_YN() {
				return POWDER_EXTING_H_YN;
			}


			/**
			 * @param pOWDER_EXTING_H_YN the pOWDER_EXTING_H_YN to set
			 */
			public void setPOWDER_EXTING_H_YN(String pOWDER_EXTING_H_YN) {
				POWDER_EXTING_H_YN = pOWDER_EXTING_H_YN;
			}


			/**
			 * @return the pOWDER_EXTING_AV_YN
			 */
			public String getPOWDER_EXTING_AV_YN() {
				return POWDER_EXTING_AV_YN;
			}


			/**
			 * @param pOWDER_EXTING_AV_YN the pOWDER_EXTING_AV_YN to set
			 */
			public void setPOWDER_EXTING_AV_YN(String pOWDER_EXTING_AV_YN) {
				POWDER_EXTING_AV_YN = pOWDER_EXTING_AV_YN;
			}


			/**
			 * @return the sLIDE_YN
			 */
			public String getSLIDE_YN() {
				return SLIDE_YN;
			}


			/**
			 * @param sLIDE_YN the sLIDE_YN to set
			 */
			public void setSLIDE_YN(String sLIDE_YN) {
				SLIDE_YN = sLIDE_YN;
			}


			/**
			 * @return the lADDER_YN
			 */
			public String getLADDER_YN() {
				return LADDER_YN;
			}


			/**
			 * @param lADDER_YN the lADDER_YN to set
			 */
			public void setLADDER_YN(String lADDER_YN) {
				LADDER_YN = lADDER_YN;
			}


			/**
			 * @return the rESCUE_YN
			 */
			public String getRESCUE_YN() {
				return RESCUE_YN;
			}


			/**
			 * @param rESCUE_YN the rESCUE_YN to set
			 */
			public void setRESCUE_YN(String rESCUE_YN) {
				RESCUE_YN = rESCUE_YN;
			}


			/**
			 * @return the wANKWANG_YN
			 */
			public String getWANKWANG_YN() {
				return WANKWANG_YN;
			}


			/**
			 * @param wANKWANG_YN the wANKWANG_YN to set
			 */
			public void setWANKWANG_YN(String wANKWANG_YN) {
				WANKWANG_YN = wANKWANG_YN;
			}


			/**
			 * @return the mEASURE_EQUIP_YN
			 */
			public String getMEASURE_EQUIP_YN() {
				return MEASURE_EQUIP_YN;
			}


			/**
			 * @param mEASURE_EQUIP_YN the mEASURE_EQUIP_YN to set
			 */
			public void setMEASURE_EQUIP_YN(String mEASURE_EQUIP_YN) {
				MEASURE_EQUIP_YN = mEASURE_EQUIP_YN;
			}


			/**
			 * @return the mEASURE_ROPE_YN
			 */
			public String getMEASURE_ROPE_YN() {
				return MEASURE_ROPE_YN;
			}


			/**
			 * @param mEASURE_ROPE_YN the mEASURE_ROPE_YN to set
			 */
			public void setMEASURE_ROPE_YN(String mEASURE_ROPE_YN) {
				MEASURE_ROPE_YN = mEASURE_ROPE_YN;
			}


			/**
			 * @return the sAFE_MAT_YN
			 */
			public String getSAFE_MAT_YN() {
				return SAFE_MAT_YN;
			}


			/**
			 * @param sAFE_MAT_YN the sAFE_MAT_YN to set
			 */
			public void setSAFE_MAT_YN(String sAFE_MAT_YN) {
				SAFE_MAT_YN = sAFE_MAT_YN;
			}


			/**
			 * @return the rESCUE_EQUIP_YN
			 */
			public String getRESCUE_EQUIP_YN() {
				return RESCUE_EQUIP_YN;
			}


			/**
			 * @param rESCUE_EQUIP_YN the rESCUE_EQUIP_YN to set
			 */
			public void setRESCUE_EQUIP_YN(String rESCUE_EQUIP_YN) {
				RESCUE_EQUIP_YN = rESCUE_EQUIP_YN;
			}


			/**
			 * @return the eMG_LIGHT_YN
			 */
			public String getEMG_LIGHT_YN() {
				return EMG_LIGHT_YN;
			}


			/**
			 * @param eMG_LIGHT_YN the eMG_LIGHT_YN to set
			 */
			public void setEMG_LIGHT_YN(String eMG_LIGHT_YN) {
				EMG_LIGHT_YN = eMG_LIGHT_YN;
			}


			/**
			 * @return the wATER_EXTING_YN
			 */
			public String getWATER_EXTING_YN() {
				return WATER_EXTING_YN;
			}


			/**
			 * @param wATER_EXTING_YN the wATER_EXTING_YN to set
			 */
			public void setWATER_EXTING_YN(String wATER_EXTING_YN) {
				WATER_EXTING_YN = wATER_EXTING_YN;
			}


			/**
			 * @return the eXTING_WATER_YN
			 */
			public String getEXTING_WATER_YN() {
				return EXTING_WATER_YN;
			}


			/**
			 * @param eXTING_WATER_YN the eXTING_WATER_YN to set
			 */
			public void setEXTING_WATER_YN(String eXTING_WATER_YN) {
				EXTING_WATER_YN = eXTING_WATER_YN;
			}


			/**
			 * @return the lWTR_YN
			 */
			public String getLWTR_YN() {
				return LWTR_YN;
			}


			/**
			 * @param lWTR_YN the lWTR_YN to set
			 */
			public void setLWTR_YN(String lWTR_YN) {
				LWTR_YN = lWTR_YN;
			}


			/**
			 * @return the rESMOKE_YN
			 */
			public String getRESMOKE_YN() {
				return RESMOKE_YN;
			}


			/**
			 * @param rESMOKE_YN the rESMOKE_YN to set
			 */
			public void setRESMOKE_YN(String rESMOKE_YN) {
				RESMOKE_YN = rESMOKE_YN;
			}


			/**
			 * @return the wTRPIPE_YN
			 */
			public String getWTRPIPE_YN() {
				return WTRPIPE_YN;
			}


			/**
			 * @param wTRPIPE_YN the wTRPIPE_YN to set
			 */
			public void setWTRPIPE_YN(String wTRPIPE_YN) {
				WTRPIPE_YN = wTRPIPE_YN;
			}


			/**
			 * @return the wATER_SPRINGKLING_YN
			 */
			public String getWATER_SPRINGKLING_YN() {
				return WATER_SPRINGKLING_YN;
			}


			/**
			 * @param wATER_SPRINGKLING_YN the wATER_SPRINGKLING_YN to set
			 */
			public void setWATER_SPRINGKLING_YN(String wATER_SPRINGKLING_YN) {
				WATER_SPRINGKLING_YN = wATER_SPRINGKLING_YN;
			}


			/**
			 * @return the eMG_PLUG_YN
			 */
			public String getEMG_PLUG_YN() {
				return EMG_PLUG_YN;
			}


			/**
			 * @param eMG_PLUG_YN the eMG_PLUG_YN to set
			 */
			public void setEMG_PLUG_YN(String eMG_PLUG_YN) {
				EMG_PLUG_YN = eMG_PLUG_YN;
			}


			/**
			 * @return the wIRELESS_COMM_YN
			 */
			public String getWIRELESS_COMM_YN() {
				return WIRELESS_COMM_YN;
			}


			/**
			 * @param wIRELESS_COMM_YN the wIRELESS_COMM_YN to set
			 */
			public void setWIRELESS_COMM_YN(String wIRELESS_COMM_YN) {
				WIRELESS_COMM_YN = wIRELESS_COMM_YN;
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
				session.selectList("SQL.SUPPORT.NGAVL_VL12003", map);
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
