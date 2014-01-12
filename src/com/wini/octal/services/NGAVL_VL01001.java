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
public class NGAVL_VL01001 extends JsonSvcIF<NGAVL_VL01001.In, NGAVL_VL01001.Out> implements Runnable {
				
		public NGAVL_VL01001(MessageEvent e, HttpRequest request) {
			this.e = e;
			this.request = request;
		}
	
		// Input class
		public class In {
			private String ADJ_WARD_ID;
			private String CAR_ID;
			
			In() {}

			/**
			 * @return the aDJ_WARD_ID
			 */
			public String getADJ_WARD_ID() {
				return ADJ_WARD_ID;
			}

			/**
			 * @param aDJ_WARD_ID the aDJ_WARD_ID to set
			 */
			public void setADJ_WARD_ID(String aDJ_WARD_ID) {
				ADJ_WARD_ID = aDJ_WARD_ID;
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

					
		}
		
		// Output Class
		public class Out {
			private String DSR_SEQ;
			private String REG_ROUTE_CD;
			private String REG_DTIME;
			private String CALL_NAME;
			private String CALL_TEL;
			private String CALL_CONTENT;
			private String DSR_ZIP_SEQ;
			private String DSR_SIDO_CD;
			private String DSR_GUGUN_CD;
			private String DSR_DONG_CD;
			private String DSR_RI_CD;
			private String DSR_HOUSE_NO;
			private String DSR_ETC_ADDR;
			private String FULL_ADDR;
			private String GIS_X;
			private String GIS_Y;
			private String DSPCMD_DTIME;
			private String DSP_ORD;
			private String DSR_KND_CD;
			private String WARD_DIST;
			private String DSR_CLS_CD; 
			private String SAFEMAN; 
			private String POINT_ACCR_CLS_NM; 
			private String TTY_ID; 
			private String SAFEMAN_NAME ;
			private String OBJ_ID;
			
			public Out() {}

			/**
			 * @return the dSR_SEQ
			 */
			public String getDSR_SEQ() {
				return DSR_SEQ;
			}

			/**
			 * @param dSR_SEQ the dSR_SEQ to set
			 */
			public void setDSR_SEQ(String dSR_SEQ) {
				DSR_SEQ = dSR_SEQ;
			}

			/**
			 * @return the rEG_ROUTE_CD
			 */
			public String getREG_ROUTE_CD() {
				return REG_ROUTE_CD;
			}

			/**
			 * @param rEG_ROUTE_CD the rEG_ROUTE_CD to set
			 */
			public void setREG_ROUTE_CD(String rEG_ROUTE_CD) {
				REG_ROUTE_CD = rEG_ROUTE_CD;
			}

			/**
			 * @return the rEG_DTIME
			 */
			public String getREG_DTIME() {
				return REG_DTIME;
			}

			/**
			 * @param rEG_DTIME the rEG_DTIME to set
			 */
			public void setREG_DTIME(String rEG_DTIME) {
				REG_DTIME = rEG_DTIME;
			}

			/**
			 * @return the cALL_NAME
			 */
			public String getCALL_NAME() {
				return CALL_NAME;
			}

			/**
			 * @param cALL_NAME the cALL_NAME to set
			 */
			public void setCALL_NAME(String cALL_NAME) {
				CALL_NAME = cALL_NAME;
			}

			/**
			 * @return the cALL_TEL
			 */
			public String getCALL_TEL() {
				return CALL_TEL;
			}

			/**
			 * @param cALL_TEL the cALL_TEL to set
			 */
			public void setCALL_TEL(String cALL_TEL) {
				CALL_TEL = cALL_TEL;
			}

			/**
			 * @return the cALL_CONTENT
			 */
			public String getCALL_CONTENT() {
				return CALL_CONTENT;
			}

			/**
			 * @param cALL_CONTENT the cALL_CONTENT to set
			 */
			public void setCALL_CONTENT(String cALL_CONTENT) {
				CALL_CONTENT = cALL_CONTENT;
			}

			/**
			 * @return the dSR_ZIP_SEQ
			 */
			public String getDSR_ZIP_SEQ() {
				return DSR_ZIP_SEQ;
			}

			/**
			 * @param dSR_ZIP_SEQ the dSR_ZIP_SEQ to set
			 */
			public void setDSR_ZIP_SEQ(String dSR_ZIP_SEQ) {
				DSR_ZIP_SEQ = dSR_ZIP_SEQ;
			}

			/**
			 * @return the dSR_SIDO_CD
			 */
			public String getDSR_SIDO_CD() {
				return DSR_SIDO_CD;
			}

			/**
			 * @param dSR_SIDO_CD the dSR_SIDO_CD to set
			 */
			public void setDSR_SIDO_CD(String dSR_SIDO_CD) {
				DSR_SIDO_CD = dSR_SIDO_CD;
			}

			/**
			 * @return the dSR_GUGUN_CD
			 */
			public String getDSR_GUGUN_CD() {
				return DSR_GUGUN_CD;
			}

			/**
			 * @param dSR_GUGUN_CD the dSR_GUGUN_CD to set
			 */
			public void setDSR_GUGUN_CD(String dSR_GUGUN_CD) {
				DSR_GUGUN_CD = dSR_GUGUN_CD;
			}

			/**
			 * @return the dSR_DONG_CD
			 */
			public String getDSR_DONG_CD() {
				return DSR_DONG_CD;
			}

			/**
			 * @param dSR_DONG_CD the dSR_DONG_CD to set
			 */
			public void setDSR_DONG_CD(String dSR_DONG_CD) {
				DSR_DONG_CD = dSR_DONG_CD;
			}

			/**
			 * @return the dSR_RI_CD
			 */
			public String getDSR_RI_CD() {
				return DSR_RI_CD;
			}

			/**
			 * @param dSR_RI_CD the dSR_RI_CD to set
			 */
			public void setDSR_RI_CD(String dSR_RI_CD) {
				DSR_RI_CD = dSR_RI_CD;
			}

			/**
			 * @return the dSR_HOUSE_NO
			 */
			public String getDSR_HOUSE_NO() {
				return DSR_HOUSE_NO;
			}

			/**
			 * @param dSR_HOUSE_NO the dSR_HOUSE_NO to set
			 */
			public void setDSR_HOUSE_NO(String dSR_HOUSE_NO) {
				DSR_HOUSE_NO = dSR_HOUSE_NO;
			}

			/**
			 * @return the dSR_ETC_ADDR
			 */
			public String getDSR_ETC_ADDR() {
				return DSR_ETC_ADDR;
			}

			/**
			 * @param dSR_ETC_ADDR the dSR_ETC_ADDR to set
			 */
			public void setDSR_ETC_ADDR(String dSR_ETC_ADDR) {
				DSR_ETC_ADDR = dSR_ETC_ADDR;
			}

			/**
			 * @return the fULL_ADDR
			 */
			public String getFULL_ADDR() {
				return FULL_ADDR;
			}

			/**
			 * @param fULL_ADDR the fULL_ADDR to set
			 */
			public void setFULL_ADDR(String fULL_ADDR) {
				FULL_ADDR = fULL_ADDR;
			}

			/**
			 * @return the gIS_X
			 */
			public String getGIS_X() {
				return GIS_X;
			}

			/**
			 * @param gIS_X the gIS_X to set
			 */
			public void setGIS_X(String gIS_X) {
				GIS_X = gIS_X;
			}

			/**
			 * @return the gIS_Y
			 */
			public String getGIS_Y() {
				return GIS_Y;
			}

			/**
			 * @param gIS_Y the gIS_Y to set
			 */
			public void setGIS_Y(String gIS_Y) {
				GIS_Y = gIS_Y;
			}

			/**
			 * @return the dSPCMD_DTIME
			 */
			public String getDSPCMD_DTIME() {
				return DSPCMD_DTIME;
			}

			/**
			 * @param dSPCMD_DTIME the dSPCMD_DTIME to set
			 */
			public void setDSPCMD_DTIME(String dSPCMD_DTIME) {
				DSPCMD_DTIME = dSPCMD_DTIME;
			}

			/**
			 * @return the dSP_ORD
			 */
			public String getDSP_ORD() {
				return DSP_ORD;
			}

			/**
			 * @param dSP_ORD the dSP_ORD to set
			 */
			public void setDSP_ORD(String dSP_ORD) {
				DSP_ORD = dSP_ORD;
			}

			/**
			 * @return the dSR_KND_CD
			 */
			public String getDSR_KND_CD() {
				return DSR_KND_CD;
			}

			/**
			 * @param dSR_KND_CD the dSR_KND_CD to set
			 */
			public void setDSR_KND_CD(String dSR_KND_CD) {
				DSR_KND_CD = dSR_KND_CD;
			}

			/**
			 * @return the wARD_DIST
			 */
			public String getWARD_DIST() {
				return WARD_DIST;
			}

			/**
			 * @param wARD_DIST the wARD_DIST to set
			 */
			public void setWARD_DIST(String wARD_DIST) {
				WARD_DIST = wARD_DIST;
			}

			/**
			 * @return the dSR_CLS_CD
			 */
			public String getDSR_CLS_CD() {
				return DSR_CLS_CD;
			}

			/**
			 * @param dSR_CLS_CD the dSR_CLS_CD to set
			 */
			public void setDSR_CLS_CD(String dSR_CLS_CD) {
				DSR_CLS_CD = dSR_CLS_CD;
			}

			/**
			 * @return the sAFEMAN
			 */
			public String getSAFEMAN() {
				return SAFEMAN;
			}

			/**
			 * @param sAFEMAN the sAFEMAN to set
			 */
			public void setSAFEMAN(String sAFEMAN) {
				SAFEMAN = sAFEMAN;
			}

			/**
			 * @return the pOINT_ACCR_CLS_NM
			 */
			public String getPOINT_ACCR_CLS_NM() {
				return POINT_ACCR_CLS_NM;
			}

			/**
			 * @param pOINT_ACCR_CLS_NM the pOINT_ACCR_CLS_NM to set
			 */
			public void setPOINT_ACCR_CLS_NM(String pOINT_ACCR_CLS_NM) {
				POINT_ACCR_CLS_NM = pOINT_ACCR_CLS_NM;
			}

			/**
			 * @return the tTY_ID
			 */
			public String getTTY_ID() {
				return TTY_ID;
			}

			/**
			 * @param tTY_ID the tTY_ID to set
			 */
			public void setTTY_ID(String tTY_ID) {
				TTY_ID = tTY_ID;
			}

			/**
			 * @return the sAFEMAN_NAME
			 */
			public String getSAFEMAN_NAME() {
				return SAFEMAN_NAME;
			}

			/**
			 * @param sAFEMAN_NAME the sAFEMAN_NAME to set
			 */
			public void setSAFEMAN_NAME(String sAFEMAN_NAME) {
				SAFEMAN_NAME = sAFEMAN_NAME;
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
				session.selectList("SQL.CCC.NGAVL_VL01001", map);
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
