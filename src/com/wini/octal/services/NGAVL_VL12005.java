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
public class NGAVL_VL12005 extends JsonSvcIF<NGAVL_VL12005.In, NGAVL_VL12005.Out> implements Runnable {
				
		public NGAVL_VL12005(MessageEvent e, HttpRequest request) {
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
			private String 	HIST_TYPE_CD;
			private String 	HIST_TYPE_CDNAME;
			private String 	CONST_USE;
			private String 	STRUCT_1;
			private String 	STRUCT_2;
			private String 	STRUCT_3;
			private String 	FLOOR_AREA;
			private String 	TOT_AREA;
			private String 	USTORY_CNT;
			private String 	BSTORY_CNT;
			private String 	GRANT_DATE;
			private String 	ETC;
			private String 	PREUSE_YN;
			private String 	FINISH_DATE;
			private String 	CHG_DESC;

			
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
			 * @return the hIST_TYPE_CD
			 */
			public String getHIST_TYPE_CD() {
				return HIST_TYPE_CD;
			}


			/**
			 * @param hIST_TYPE_CD the hIST_TYPE_CD to set
			 */
			public void setHIST_TYPE_CD(String hIST_TYPE_CD) {
				HIST_TYPE_CD = hIST_TYPE_CD;
			}


			/**
			 * @return the hIST_TYPE_CDNAME
			 */
			public String getHIST_TYPE_CDNAME() {
				return HIST_TYPE_CDNAME;
			}


			/**
			 * @param hIST_TYPE_CDNAME the hIST_TYPE_CDNAME to set
			 */
			public void setHIST_TYPE_CDNAME(String hIST_TYPE_CDNAME) {
				HIST_TYPE_CDNAME = hIST_TYPE_CDNAME;
			}


			/**
			 * @return the cONST_USE
			 */
			public String getCONST_USE() {
				return CONST_USE;
			}


			/**
			 * @param cONST_USE the cONST_USE to set
			 */
			public void setCONST_USE(String cONST_USE) {
				CONST_USE = cONST_USE;
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
			 * @return the gRANT_DATE
			 */
			public String getGRANT_DATE() {
				return GRANT_DATE;
			}


			/**
			 * @param gRANT_DATE the gRANT_DATE to set
			 */
			public void setGRANT_DATE(String gRANT_DATE) {
				GRANT_DATE = gRANT_DATE;
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
			 * @return the pREUSE_YN
			 */
			public String getPREUSE_YN() {
				return PREUSE_YN;
			}


			/**
			 * @param pREUSE_YN the pREUSE_YN to set
			 */
			public void setPREUSE_YN(String pREUSE_YN) {
				PREUSE_YN = pREUSE_YN;
			}


			/**
			 * @return the fINISH_DATE
			 */
			public String getFINISH_DATE() {
				return FINISH_DATE;
			}


			/**
			 * @param fINISH_DATE the fINISH_DATE to set
			 */
			public void setFINISH_DATE(String fINISH_DATE) {
				FINISH_DATE = fINISH_DATE;
			}


			/**
			 * @return the cHG_DESC
			 */
			public String getCHG_DESC() {
				return CHG_DESC;
			}


			/**
			 * @param cHG_DESC the cHG_DESC to set
			 */
			public void setCHG_DESC(String cHG_DESC) {
				CHG_DESC = cHG_DESC;
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
				session.selectList("SQL.SUPPORT.NGAVL_VL12005", map);
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
