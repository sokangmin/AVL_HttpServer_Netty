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
public class NGAVL_VL12007 extends JsonSvcIF<NGAVL_VL12007.In, NGAVL_VL12007.Out> implements Runnable {
				
		public NGAVL_VL12007(MessageEvent e, HttpRequest request) {
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
			private String 	DGRMGR_SEQ;
			private String 	DGRMGR_NAME;
			private String 	ETC_ADDR;
			private String 	HOME_TEL;

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
			 * @return the dGRMGR_SEQ
			 */
			public String getDGRMGR_SEQ() {
				return DGRMGR_SEQ;
			}

			/**
			 * @param dGRMGR_SEQ the dGRMGR_SEQ to set
			 */
			public void setDGRMGR_SEQ(String dGRMGR_SEQ) {
				DGRMGR_SEQ = dGRMGR_SEQ;
			}

			/**
			 * @return the dGRMGR_NAME
			 */
			public String getDGRMGR_NAME() {
				return DGRMGR_NAME;
			}

			/**
			 * @param dGRMGR_NAME the dGRMGR_NAME to set
			 */
			public void setDGRMGR_NAME(String dGRMGR_NAME) {
				DGRMGR_NAME = dGRMGR_NAME;
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
				session.selectList("SQL.SUPPORT.NGAVL_VL12007", map);
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
