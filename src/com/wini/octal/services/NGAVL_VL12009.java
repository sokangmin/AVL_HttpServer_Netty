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
public class NGAVL_VL12009 extends JsonSvcIF<NGAVL_VL12009.In, NGAVL_VL12009.Out> implements Runnable {
				
		public NGAVL_VL12009(MessageEvent e, HttpRequest request) {
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
			private String OBJ_PHOTO_TYPE_CD;
			private String OBJ_PHOTO_TYPE_CDNAME;
			private String FILE_NAME;
			private String FILE_TYPE;
			private String FILE_PATH;

			public Out() {}

			/**
			 * @return the oBJ_PHOTO_TYPE_CD
			 */
			public String getOBJ_PHOTO_TYPE_CD() {
				return OBJ_PHOTO_TYPE_CD;
			}

			/**
			 * @param oBJ_PHOTO_TYPE_CD the oBJ_PHOTO_TYPE_CD to set
			 */
			public void setOBJ_PHOTO_TYPE_CD(String oBJ_PHOTO_TYPE_CD) {
				OBJ_PHOTO_TYPE_CD = oBJ_PHOTO_TYPE_CD;
			}

			/**
			 * @return the oBJ_PHOTO_TYPE_CDNAME
			 */
			public String getOBJ_PHOTO_TYPE_CDNAME() {
				return OBJ_PHOTO_TYPE_CDNAME;
			}

			/**
			 * @param oBJ_PHOTO_TYPE_CDNAME the oBJ_PHOTO_TYPE_CDNAME to set
			 */
			public void setOBJ_PHOTO_TYPE_CDNAME(String oBJ_PHOTO_TYPE_CDNAME) {
				OBJ_PHOTO_TYPE_CDNAME = oBJ_PHOTO_TYPE_CDNAME;
			}

			/**
			 * @return the fILE_NAME
			 */
			public String getFILE_NAME() {
				return FILE_NAME;
			}

			/**
			 * @param fILE_NAME the fILE_NAME to set
			 */
			public void setFILE_NAME(String fILE_NAME) {
				FILE_NAME = fILE_NAME;
			}

			/**
			 * @return the fILE_TYPE
			 */
			public String getFILE_TYPE() {
				return FILE_TYPE;
			}

			/**
			 * @param fILE_TYPE the fILE_TYPE to set
			 */
			public void setFILE_TYPE(String fILE_TYPE) {
				FILE_TYPE = fILE_TYPE;
			}

			/**
			 * @return the fILE_PATH
			 */
			public String getFILE_PATH() {
				return FILE_PATH;
			}

			/**
			 * @param fILE_PATH the fILE_PATH to set
			 */
			public void setFILE_PATH(String fILE_PATH) {
				FILE_PATH = fILE_PATH;
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
				session.selectList("SQL.SUPPORT.NGAVL_VL12009", map);
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
