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
public class NGAVL_VL02003 extends JsonSvcIF<NGAVL_VL02003.In, NGAVL_VL02003.Out> implements Runnable {
				
		public NGAVL_VL02003(MessageEvent e, HttpRequest request) {
			this.e = e;
			this.request = request;
		}
	
		// Input class
		public class In {
			private String DSR_SEQ;
			private String DSP_WARD_ID;
			private String CAR_ID;
			private String DSP_ORD;
			
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
			
		}
		
		// Output Class
		public class Out {
			private String CAR_MOVE_CD;
			private String PROC_DTIME1;
			
			public Out() {}

			/**
			 * @return the cAR_MOVE_CD
			 */
			public String getCAR_MOVE_CD() {
				return CAR_MOVE_CD;
			}

			/**
			 * @param cAR_MOVE_CD the cAR_MOVE_CD to set
			 */
			public void setCAR_MOVE_CD(String cAR_MOVE_CD) {
				CAR_MOVE_CD = cAR_MOVE_CD;
			}

			/**
			 * @return the pROC_DTIME1
			 */
			public String getPROC_DTIME1() {
				return PROC_DTIME1;
			}

			/**
			 * @param pROC_DTIME1 the pROC_DTIME1 to set
			 */
			public void setPROC_DTIME1(String pROC_DTIME1) {
				PROC_DTIME1 = pROC_DTIME1;
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
				session.selectList("SQL.CCC.NGAVL_VL02003", map);
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
