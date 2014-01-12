package com.wini.octal.services;

import static com.wini.octal.conf.ConfigContext.CONFIG_INSTNACE;
import static com.wini.octal.conf.Prop.TisIp;
import static com.wini.octal.conf.Prop.TisPort;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;
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
public class NGAVL_VL02002S extends JsonSvcIF<NGAVL_VL02002S.In, NGAVL_VL02002S.Out> implements Runnable {
				
		public NGAVL_VL02002S(MessageEvent e, HttpRequest request) {
			this.e = e;
			this.request = request;
		}
	
		// Input class
		public class In {
			private String CAR_MOVE_CD;
			private String CAR_ID;
			private String DSR_SEQ;
			private String DSP_WARD_ID;
			private String DSP_ORD;
			private String CTL_USER_ID;
			private String AVL_HOSP_CODE;
			private String TTY_ID;
			
			In() {}

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
			 * @return the cTL_USER_ID
			 */
			public String getCTL_USER_ID() {
				return CTL_USER_ID;
			}

			/**
			 * @param cTL_USER_ID the cTL_USER_ID to set
			 */
			public void setCTL_USER_ID(String cTL_USER_ID) {
				CTL_USER_ID = cTL_USER_ID;
			}

			/**
			 * @return the aVL_HOSP_CODE
			 */
			public String getAVL_HOSP_CODE() {
				return AVL_HOSP_CODE;
			}

			/**
			 * @param aVL_HOSP_CODE the aVL_HOSP_CODE to set
			 */
			public void setAVL_HOSP_CODE(String aVL_HOSP_CODE) {
				AVL_HOSP_CODE = aVL_HOSP_CODE;
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
				session.selectList("SQL.CCC.NGAVL_VL02002", map);
				session.commit();
			} catch(Exception e) {
				session.rollback();
				logger.error("Unexpected exception from DB.", e.getCause());
				throw (RuntimeException)e;
			} finally {
				session.close();
			}
			
			String errcode = (String)map.get("ERRCODE");
			
			//TODO tis serv
			if(errcode.equals("0")) {
				Socket sock = null;
				BufferedWriter bw = null;
				String msg = "";
				try {
					sock = new Socket();
					SocketAddress addr = new InetSocketAddress(CONFIG_INSTNACE.getProperty(TisIp)
							, CONFIG_INSTNACE.getProperty2Int(TisPort));
					
					sock.connect(addr, 5000);
					
					bw = new BufferedWriter(
							new OutputStreamWriter(sock.getOutputStream()));
					if (bw != null) {
						In in = input.getParam().get(0);
						
						// msg = "a1;" + dsr_seq + ";" + car_move_cd + ";" + car_id + ";@"; 
						msg = "a1;" + in.DSR_SEQ + ";" + in.CAR_MOVE_CD + ";" + in.CAR_ID + ";@"; 
						bw.write(msg);
						bw.flush();
					}
					
				} catch (IOException e) {
					logger.error("TIS Server Connect Error.", e);
				} finally {
					if (bw != null) try { bw.close(); } catch (IOException e) {}
					if (sock != null) try { sock.close(); } catch (IOException e) {}
				}
			}
			
			// Output
			
			
			writeResponse(e, getOutput(out, errcode, (String) map.get("ERRMSG")));
			
		}
	}
