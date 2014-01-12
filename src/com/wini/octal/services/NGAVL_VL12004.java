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
public class NGAVL_VL12004 extends JsonSvcIF<NGAVL_VL12004.In, NGAVL_VL12004.Out> implements Runnable {
				
		public NGAVL_VL12004(MessageEvent e, HttpRequest request) {
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
			private String 	ONST_NAME;
			private String 	ENV_DESC;
			private String 	EXPAND_RSN;
			private String 	RESC_ESC_CPLAN;
			private String 	WARD1_DIST;
			private String 	WARD2_DIST;
			private String 	ESC_PLACE;
			private String 	ETC_REMARK;
			
			public Out() {}


			/**
			 * @return the oNST_NAME
			 */
			public String getONST_NAME() {
				return ONST_NAME;
			}


			/**
			 * @param oNST_NAME the oNST_NAME to set
			 */
			public void setONST_NAME(String oNST_NAME) {
				ONST_NAME = oNST_NAME;
			}


			/**
			 * @return the eNV_DESC
			 */
			public String getENV_DESC() {
				return ENV_DESC;
			}


			/**
			 * @param eNV_DESC the eNV_DESC to set
			 */
			public void setENV_DESC(String eNV_DESC) {
				ENV_DESC = eNV_DESC;
			}


			/**
			 * @return the eXPAND_RSN
			 */
			public String getEXPAND_RSN() {
				return EXPAND_RSN;
			}


			/**
			 * @param eXPAND_RSN the eXPAND_RSN to set
			 */
			public void setEXPAND_RSN(String eXPAND_RSN) {
				EXPAND_RSN = eXPAND_RSN;
			}


			/**
			 * @return the rESC_ESC_CPLAN
			 */
			public String getRESC_ESC_CPLAN() {
				return RESC_ESC_CPLAN;
			}


			/**
			 * @param rESC_ESC_CPLAN the rESC_ESC_CPLAN to set
			 */
			public void setRESC_ESC_CPLAN(String rESC_ESC_CPLAN) {
				RESC_ESC_CPLAN = rESC_ESC_CPLAN;
			}


			/**
			 * @return the wARD1_DIST
			 */
			public String getWARD1_DIST() {
				return WARD1_DIST;
			}


			/**
			 * @param wARD1_DIST the wARD1_DIST to set
			 */
			public void setWARD1_DIST(String wARD1_DIST) {
				WARD1_DIST = wARD1_DIST;
			}


			/**
			 * @return the wARD2_DIST
			 */
			public String getWARD2_DIST() {
				return WARD2_DIST;
			}


			/**
			 * @param wARD2_DIST the wARD2_DIST to set
			 */
			public void setWARD2_DIST(String wARD2_DIST) {
				WARD2_DIST = wARD2_DIST;
			}


			/**
			 * @return the eSC_PLACE
			 */
			public String getESC_PLACE() {
				return ESC_PLACE;
			}


			/**
			 * @param eSC_PLACE the eSC_PLACE to set
			 */
			public void setESC_PLACE(String eSC_PLACE) {
				ESC_PLACE = eSC_PLACE;
			}


			/**
			 * @return the eTC_REMARK
			 */
			public String getETC_REMARK() {
				return ETC_REMARK;
			}


			/**
			 * @param eTC_REMARK the eTC_REMARK to set
			 */
			public void setETC_REMARK(String eTC_REMARK) {
				ETC_REMARK = eTC_REMARK;
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
				session.selectList("SQL.SUPPORT.NGAVL_VL12004", map);
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
