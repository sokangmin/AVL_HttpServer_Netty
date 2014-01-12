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
public class NGAVL_VL01002 extends JsonSvcIF<NGAVL_VL01002.In, NGAVL_VL01002.Out> implements Runnable {
				
		public NGAVL_VL01002(MessageEvent e, HttpRequest request) {
			this.e = e;
			this.request = request;
		}
	
		// Input class
		public class In {
			private String DSR_SEQ;
			private String DSP_WARD_ID;
			
			In() {}

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
			 * @return the dSP_WARD_ID
			 */
			public String getDSP_WARD_ID() {
				return DSP_WARD_ID;
			}

			/**
			 * @param dSP_WARD_ID the dSP_WARD_ID to set
			 */
			public void setDSP_WARD_ID(String dSP_WARD_ID) {
				DSP_WARD_ID = dSP_WARD_ID;
			}
		
			
		}
		
		// Output Class
		public class Out {
			private String WARD_ID;
			private String WARD_NAME;
			private String DSP_ORD;
			private String CAR_ID;
			private String CAR_NO;
			private String RADIO_CALLSIGN;
			private String CAR_KIND;
			private String GIS_X;
			private String GIS_Y;
			
			public Out() {}

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
			 * @return the cAR_NO
			 */
			public String getCAR_NO() {
				return CAR_NO;
			}

			/**
			 * @param cAR_NO the cAR_NO to set
			 */
			public void setCAR_NO(String cAR_NO) {
				CAR_NO = cAR_NO;
			}

			/**
			 * @return the rADIO_CALLSIGN
			 */
			public String getRADIO_CALLSIGN() {
				return RADIO_CALLSIGN;
			}

			/**
			 * @param rADIO_CALLSIGN the rADIO_CALLSIGN to set
			 */
			public void setRADIO_CALLSIGN(String rADIO_CALLSIGN) {
				RADIO_CALLSIGN = rADIO_CALLSIGN;
			}

			/**
			 * @return the cAR_KIND
			 */
			public String getCAR_KIND() {
				return CAR_KIND;
			}

			/**
			 * @param cAR_KIND the cAR_KIND to set
			 */
			public void setCAR_KIND(String cAR_KIND) {
				CAR_KIND = cAR_KIND;
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
				session.selectList("SQL.CCC.NGAVL_VL01002", map);
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
