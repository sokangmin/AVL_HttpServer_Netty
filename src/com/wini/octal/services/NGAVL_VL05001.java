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
public class NGAVL_VL05001 extends JsonSvcIF<NGAVL_VL05001.In, NGAVL_VL05001.Out> implements Runnable {
				
		public NGAVL_VL05001(MessageEvent e, HttpRequest request) {
			this.e = e;
			this.request = request;
		}
	
		// Input class
		public class In {
			private String DEVICE_ID;
			private String DSR_SEQ;
			private String WARD_ID;
			private String CAR_ID;
			private String INPUT_DATETIME;
			private String INPUT_SEQ;
			private String COLLECT_TIME;
			private String CAR_GIS_X;
			private String CAR_GIS_Y;
			
			In() {}

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
			 * @return the iNPUT_DATETIME
			 */
			public String getINPUT_DATETIME() {
				return INPUT_DATETIME;
			}

			/**
			 * @param iNPUT_DATETIME the iNPUT_DATETIME to set
			 */
			public void setINPUT_DATETIME(String iNPUT_DATETIME) {
				INPUT_DATETIME = iNPUT_DATETIME;
			}

			/**
			 * @return the iNPUT_SEQ
			 */
			public String getINPUT_SEQ() {
				return INPUT_SEQ;
			}

			/**
			 * @param iNPUT_SEQ the iNPUT_SEQ to set
			 */
			public void setINPUT_SEQ(String iNPUT_SEQ) {
				INPUT_SEQ = iNPUT_SEQ;
			}

			/**
			 * @return the cOLLECT_TIME
			 */
			public String getCOLLECT_TIME() {
				return COLLECT_TIME;
			}

			/**
			 * @param cOLLECT_TIME the cOLLECT_TIME to set
			 */
			public void setCOLLECT_TIME(String cOLLECT_TIME) {
				COLLECT_TIME = cOLLECT_TIME;
			}

			/**
			 * @return the cAR_GIS_X
			 */
			public String getCAR_GIS_X() {
				return CAR_GIS_X;
			}

			/**
			 * @param cAR_GIS_X the cAR_GIS_X to set
			 */
			public void setCAR_GIS_X(String cAR_GIS_X) {
				CAR_GIS_X = cAR_GIS_X;
			}

			/**
			 * @return the cAR_GIS_Y
			 */
			public String getCAR_GIS_Y() {
				return CAR_GIS_Y;
			}

			/**
			 * @param cAR_GIS_Y the cAR_GIS_Y to set
			 */
			public void setCAR_GIS_Y(String cAR_GIS_Y) {
				CAR_GIS_Y = cAR_GIS_Y;
			}
			
		}
		
		// Output Class
		public class Out {	
			
			public Out() {}		
			
		}

		
		@Override
		public void run() {
			// Input get
			InputClass<In> input = getInput(new TypeToken<InputClass<In>>(){}.getType());
			Map<String, Object> map = Object2Map(input.getParam().get(0));
			List <Out> out = new ArrayList<Out>();
			
			
			// DB serv
			SqlSession session = null;
			try {
				session = SqlSessionManager.getSqlSession().openSession(false);
				session.update("SQL.CCC.NGAVL_VL05001", map);
				session.commit();
			} catch(Exception e) {
				session.rollback();
				logger.error("Unexpected exception from DB.", e.getCause());
				throw (RuntimeException)e;
			} finally {
				session.close();
			}
			
			// Output

			
			writeResponse(e, getOutput(out, (String)map.get("ERRCODE"), (String) map.get("ERRMSG")));
			
		}
	}
