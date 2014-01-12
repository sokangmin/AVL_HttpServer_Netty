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
public class NGAVL_VL11001 extends JsonSvcIF<NGAVL_VL11001.In, NGAVL_VL11001.Out> implements Runnable {
				
		public NGAVL_VL11001(MessageEvent e, HttpRequest request) {
			this.e = e;
			this.request = request;
		}
	
		// Input class
		public class In {
			private String HOSP_ID;
			
			In() {}

			/**
			 * @return the hOSP_ID
			 */
			public String getHOSP_ID() {
				return HOSP_ID;
			}

			/**
			 * @param hOSP_ID the hOSP_ID to set
			 */
			public void setHOSP_ID(String hOSP_ID) {
				HOSP_ID = hOSP_ID;
			}		
		}
		
		// Output Class
		public class Out {
			private String NO_HPID;
			private String HOSP_ID;
			private String CD_HODI;
			private String CAT_HPGRA;
			private String CAT_HPEGRA;
			private String HOSP_NAME;
			private String NM_HPDI;
			private String NO_POST1;
			private String NO_POST2;
			private String LOC_ORG_ADDR;
			private String CNT_HPBD;
			private String CNT_HPGAMB;
			private String CNT_HPSAMB;
			private String NO_HPTEL1;
			private String NO_HPTEL2;
			private String NO_EMCTEL;
			private String NO_FAX;
			private String GB_HPTYPE;
			private String GB_HPVKL;
			private String CAT_HVEC;
			private String CAT_HVOC;
			private String CAT_HVCC;
			private String CAT_HVNCC;
			private String CAT_HVCCC;
			private String CAT_HVICC;
			private String CAT_HVGC;
			private String GB_HVCTAYN;
			private String GB_HVMRI;
			private String GB_HVANGO;
			private String GB_HVENTI;
			private String DT_HPIDATE;
			private String CD_ECID;
			private String NM_ECID;
			private String CD_EMCCD;
			private String NM_EMCCD;
			private String DT_REGT;
			private String CD_GIS;
			private String DT_HPIDATE_1;
			private String CAT_HVEC_1;
			private String CAT_HVOC_1;
			private String CAT_HVCC_1;
			private String CAT_HVNCC_1;
			private String CAT_HVCCC_1;
			private String CAT_HVICC_1;
			private String CAT_HVGC_1;
			private String GB_HVCTAYN_1;
			private String GB_HVMRI_1;
			private String GB_HVANGO_1;
			private String GB_HVENTI_1;
			private String DT_REGT_1;
			private String LOG_DATE;
			private String ORGN_DETL_NM;
			private String ORGN_DETL_NM_1;
			private String ORGN_DETL_NM_2;
			private String KIOSK_TY1;
			private String KIOSK_TY2;
			private String KIOSK_TY3;
			private String KIOSK_TY4;
			private String KIOSK_TY5;
			private String KIOSK_TY6;
			private String KIOSK_TY7;
			private String KIOSK_TY8;
			private String KIOSK_TY9;
			private String KIOSK_TY10;
			private String KIOSK_TY11;
			
			public Out() {}

			/**
			 * @return the nO_HPID
			 */
			public String getNO_HPID() {
				return NO_HPID;
			}

			/**
			 * @param nO_HPID the nO_HPID to set
			 */
			public void setNO_HPID(String nO_HPID) {
				NO_HPID = nO_HPID;
			}

			/**
			 * @return the hOSP_ID
			 */
			public String getHOSP_ID() {
				return HOSP_ID;
			}

			/**
			 * @param hOSP_ID the hOSP_ID to set
			 */
			public void setHOSP_ID(String hOSP_ID) {
				HOSP_ID = hOSP_ID;
			}

			/**
			 * @return the cD_HODI
			 */
			public String getCD_HODI() {
				return CD_HODI;
			}

			/**
			 * @param cD_HODI the cD_HODI to set
			 */
			public void setCD_HODI(String cD_HODI) {
				CD_HODI = cD_HODI;
			}

			/**
			 * @return the cAT_HPGRA
			 */
			public String getCAT_HPGRA() {
				return CAT_HPGRA;
			}

			/**
			 * @param cAT_HPGRA the cAT_HPGRA to set
			 */
			public void setCAT_HPGRA(String cAT_HPGRA) {
				CAT_HPGRA = cAT_HPGRA;
			}

			/**
			 * @return the cAT_HPEGRA
			 */
			public String getCAT_HPEGRA() {
				return CAT_HPEGRA;
			}

			/**
			 * @param cAT_HPEGRA the cAT_HPEGRA to set
			 */
			public void setCAT_HPEGRA(String cAT_HPEGRA) {
				CAT_HPEGRA = cAT_HPEGRA;
			}

			/**
			 * @return the hOSP_NAME
			 */
			public String getHOSP_NAME() {
				return HOSP_NAME;
			}

			/**
			 * @param hOSP_NAME the hOSP_NAME to set
			 */
			public void setHOSP_NAME(String hOSP_NAME) {
				HOSP_NAME = hOSP_NAME;
			}

			/**
			 * @return the nM_HPDI
			 */
			public String getNM_HPDI() {
				return NM_HPDI;
			}

			/**
			 * @param nM_HPDI the nM_HPDI to set
			 */
			public void setNM_HPDI(String nM_HPDI) {
				NM_HPDI = nM_HPDI;
			}

			/**
			 * @return the nO_POST1
			 */
			public String getNO_POST1() {
				return NO_POST1;
			}

			/**
			 * @param nO_POST1 the nO_POST1 to set
			 */
			public void setNO_POST1(String nO_POST1) {
				NO_POST1 = nO_POST1;
			}

			/**
			 * @return the nO_POST2
			 */
			public String getNO_POST2() {
				return NO_POST2;
			}

			/**
			 * @param nO_POST2 the nO_POST2 to set
			 */
			public void setNO_POST2(String nO_POST2) {
				NO_POST2 = nO_POST2;
			}

			/**
			 * @return the lOC_ORG_ADDR
			 */
			public String getLOC_ORG_ADDR() {
				return LOC_ORG_ADDR;
			}

			/**
			 * @param lOC_ORG_ADDR the lOC_ORG_ADDR to set
			 */
			public void setLOC_ORG_ADDR(String lOC_ORG_ADDR) {
				LOC_ORG_ADDR = lOC_ORG_ADDR;
			}

			/**
			 * @return the cNT_HPBD
			 */
			public String getCNT_HPBD() {
				return CNT_HPBD;
			}

			/**
			 * @param cNT_HPBD the cNT_HPBD to set
			 */
			public void setCNT_HPBD(String cNT_HPBD) {
				CNT_HPBD = cNT_HPBD;
			}

			/**
			 * @return the cNT_HPGAMB
			 */
			public String getCNT_HPGAMB() {
				return CNT_HPGAMB;
			}

			/**
			 * @param cNT_HPGAMB the cNT_HPGAMB to set
			 */
			public void setCNT_HPGAMB(String cNT_HPGAMB) {
				CNT_HPGAMB = cNT_HPGAMB;
			}

			/**
			 * @return the cNT_HPSAMB
			 */
			public String getCNT_HPSAMB() {
				return CNT_HPSAMB;
			}

			/**
			 * @param cNT_HPSAMB the cNT_HPSAMB to set
			 */
			public void setCNT_HPSAMB(String cNT_HPSAMB) {
				CNT_HPSAMB = cNT_HPSAMB;
			}

			/**
			 * @return the nO_HPTEL1
			 */
			public String getNO_HPTEL1() {
				return NO_HPTEL1;
			}

			/**
			 * @param nO_HPTEL1 the nO_HPTEL1 to set
			 */
			public void setNO_HPTEL1(String nO_HPTEL1) {
				NO_HPTEL1 = nO_HPTEL1;
			}

			/**
			 * @return the nO_HPTEL2
			 */
			public String getNO_HPTEL2() {
				return NO_HPTEL2;
			}

			/**
			 * @param nO_HPTEL2 the nO_HPTEL2 to set
			 */
			public void setNO_HPTEL2(String nO_HPTEL2) {
				NO_HPTEL2 = nO_HPTEL2;
			}

			/**
			 * @return the nO_EMCTEL
			 */
			public String getNO_EMCTEL() {
				return NO_EMCTEL;
			}

			/**
			 * @param nO_EMCTEL the nO_EMCTEL to set
			 */
			public void setNO_EMCTEL(String nO_EMCTEL) {
				NO_EMCTEL = nO_EMCTEL;
			}

			/**
			 * @return the nO_FAX
			 */
			public String getNO_FAX() {
				return NO_FAX;
			}

			/**
			 * @param nO_FAX the nO_FAX to set
			 */
			public void setNO_FAX(String nO_FAX) {
				NO_FAX = nO_FAX;
			}

			/**
			 * @return the gB_HPTYPE
			 */
			public String getGB_HPTYPE() {
				return GB_HPTYPE;
			}

			/**
			 * @param gB_HPTYPE the gB_HPTYPE to set
			 */
			public void setGB_HPTYPE(String gB_HPTYPE) {
				GB_HPTYPE = gB_HPTYPE;
			}

			/**
			 * @return the gB_HPVKL
			 */
			public String getGB_HPVKL() {
				return GB_HPVKL;
			}

			/**
			 * @param gB_HPVKL the gB_HPVKL to set
			 */
			public void setGB_HPVKL(String gB_HPVKL) {
				GB_HPVKL = gB_HPVKL;
			}

			/**
			 * @return the cAT_HVEC
			 */
			public String getCAT_HVEC() {
				return CAT_HVEC;
			}

			/**
			 * @param cAT_HVEC the cAT_HVEC to set
			 */
			public void setCAT_HVEC(String cAT_HVEC) {
				CAT_HVEC = cAT_HVEC;
			}

			/**
			 * @return the cAT_HVOC
			 */
			public String getCAT_HVOC() {
				return CAT_HVOC;
			}

			/**
			 * @param cAT_HVOC the cAT_HVOC to set
			 */
			public void setCAT_HVOC(String cAT_HVOC) {
				CAT_HVOC = cAT_HVOC;
			}

			/**
			 * @return the cAT_HVCC
			 */
			public String getCAT_HVCC() {
				return CAT_HVCC;
			}

			/**
			 * @param cAT_HVCC the cAT_HVCC to set
			 */
			public void setCAT_HVCC(String cAT_HVCC) {
				CAT_HVCC = cAT_HVCC;
			}

			/**
			 * @return the cAT_HVNCC
			 */
			public String getCAT_HVNCC() {
				return CAT_HVNCC;
			}

			/**
			 * @param cAT_HVNCC the cAT_HVNCC to set
			 */
			public void setCAT_HVNCC(String cAT_HVNCC) {
				CAT_HVNCC = cAT_HVNCC;
			}

			/**
			 * @return the cAT_HVCCC
			 */
			public String getCAT_HVCCC() {
				return CAT_HVCCC;
			}

			/**
			 * @param cAT_HVCCC the cAT_HVCCC to set
			 */
			public void setCAT_HVCCC(String cAT_HVCCC) {
				CAT_HVCCC = cAT_HVCCC;
			}

			/**
			 * @return the cAT_HVICC
			 */
			public String getCAT_HVICC() {
				return CAT_HVICC;
			}

			/**
			 * @param cAT_HVICC the cAT_HVICC to set
			 */
			public void setCAT_HVICC(String cAT_HVICC) {
				CAT_HVICC = cAT_HVICC;
			}

			/**
			 * @return the cAT_HVGC
			 */
			public String getCAT_HVGC() {
				return CAT_HVGC;
			}

			/**
			 * @param cAT_HVGC the cAT_HVGC to set
			 */
			public void setCAT_HVGC(String cAT_HVGC) {
				CAT_HVGC = cAT_HVGC;
			}

			/**
			 * @return the gB_HVCTAYN
			 */
			public String getGB_HVCTAYN() {
				return GB_HVCTAYN;
			}

			/**
			 * @param gB_HVCTAYN the gB_HVCTAYN to set
			 */
			public void setGB_HVCTAYN(String gB_HVCTAYN) {
				GB_HVCTAYN = gB_HVCTAYN;
			}

			/**
			 * @return the gB_HVMRI
			 */
			public String getGB_HVMRI() {
				return GB_HVMRI;
			}

			/**
			 * @param gB_HVMRI the gB_HVMRI to set
			 */
			public void setGB_HVMRI(String gB_HVMRI) {
				GB_HVMRI = gB_HVMRI;
			}

			/**
			 * @return the gB_HVANGO
			 */
			public String getGB_HVANGO() {
				return GB_HVANGO;
			}

			/**
			 * @param gB_HVANGO the gB_HVANGO to set
			 */
			public void setGB_HVANGO(String gB_HVANGO) {
				GB_HVANGO = gB_HVANGO;
			}

			/**
			 * @return the gB_HVENTI
			 */
			public String getGB_HVENTI() {
				return GB_HVENTI;
			}

			/**
			 * @param gB_HVENTI the gB_HVENTI to set
			 */
			public void setGB_HVENTI(String gB_HVENTI) {
				GB_HVENTI = gB_HVENTI;
			}

			/**
			 * @return the dT_HPIDATE
			 */
			public String getDT_HPIDATE() {
				return DT_HPIDATE;
			}

			/**
			 * @param dT_HPIDATE the dT_HPIDATE to set
			 */
			public void setDT_HPIDATE(String dT_HPIDATE) {
				DT_HPIDATE = dT_HPIDATE;
			}

			/**
			 * @return the cD_ECID
			 */
			public String getCD_ECID() {
				return CD_ECID;
			}

			/**
			 * @param cD_ECID the cD_ECID to set
			 */
			public void setCD_ECID(String cD_ECID) {
				CD_ECID = cD_ECID;
			}

			/**
			 * @return the nM_ECID
			 */
			public String getNM_ECID() {
				return NM_ECID;
			}

			/**
			 * @param nM_ECID the nM_ECID to set
			 */
			public void setNM_ECID(String nM_ECID) {
				NM_ECID = nM_ECID;
			}

			/**
			 * @return the cD_EMCCD
			 */
			public String getCD_EMCCD() {
				return CD_EMCCD;
			}

			/**
			 * @param cD_EMCCD the cD_EMCCD to set
			 */
			public void setCD_EMCCD(String cD_EMCCD) {
				CD_EMCCD = cD_EMCCD;
			}

			/**
			 * @return the nM_EMCCD
			 */
			public String getNM_EMCCD() {
				return NM_EMCCD;
			}

			/**
			 * @param nM_EMCCD the nM_EMCCD to set
			 */
			public void setNM_EMCCD(String nM_EMCCD) {
				NM_EMCCD = nM_EMCCD;
			}

			/**
			 * @return the dT_REGT
			 */
			public String getDT_REGT() {
				return DT_REGT;
			}

			/**
			 * @param dT_REGT the dT_REGT to set
			 */
			public void setDT_REGT(String dT_REGT) {
				DT_REGT = dT_REGT;
			}

			/**
			 * @return the cD_GIS
			 */
			public String getCD_GIS() {
				return CD_GIS;
			}

			/**
			 * @param cD_GIS the cD_GIS to set
			 */
			public void setCD_GIS(String cD_GIS) {
				CD_GIS = cD_GIS;
			}

			/**
			 * @return the dT_HPIDATE_1
			 */
			public String getDT_HPIDATE_1() {
				return DT_HPIDATE_1;
			}

			/**
			 * @param dT_HPIDATE_1 the dT_HPIDATE_1 to set
			 */
			public void setDT_HPIDATE_1(String dT_HPIDATE_1) {
				DT_HPIDATE_1 = dT_HPIDATE_1;
			}

			/**
			 * @return the cAT_HVEC_1
			 */
			public String getCAT_HVEC_1() {
				return CAT_HVEC_1;
			}

			/**
			 * @param cAT_HVEC_1 the cAT_HVEC_1 to set
			 */
			public void setCAT_HVEC_1(String cAT_HVEC_1) {
				CAT_HVEC_1 = cAT_HVEC_1;
			}

			/**
			 * @return the cAT_HVOC_1
			 */
			public String getCAT_HVOC_1() {
				return CAT_HVOC_1;
			}

			/**
			 * @param cAT_HVOC_1 the cAT_HVOC_1 to set
			 */
			public void setCAT_HVOC_1(String cAT_HVOC_1) {
				CAT_HVOC_1 = cAT_HVOC_1;
			}

			/**
			 * @return the cAT_HVCC_1
			 */
			public String getCAT_HVCC_1() {
				return CAT_HVCC_1;
			}

			/**
			 * @param cAT_HVCC_1 the cAT_HVCC_1 to set
			 */
			public void setCAT_HVCC_1(String cAT_HVCC_1) {
				CAT_HVCC_1 = cAT_HVCC_1;
			}

			/**
			 * @return the cAT_HVNCC_1
			 */
			public String getCAT_HVNCC_1() {
				return CAT_HVNCC_1;
			}

			/**
			 * @param cAT_HVNCC_1 the cAT_HVNCC_1 to set
			 */
			public void setCAT_HVNCC_1(String cAT_HVNCC_1) {
				CAT_HVNCC_1 = cAT_HVNCC_1;
			}

			/**
			 * @return the cAT_HVCCC_1
			 */
			public String getCAT_HVCCC_1() {
				return CAT_HVCCC_1;
			}

			/**
			 * @param cAT_HVCCC_1 the cAT_HVCCC_1 to set
			 */
			public void setCAT_HVCCC_1(String cAT_HVCCC_1) {
				CAT_HVCCC_1 = cAT_HVCCC_1;
			}

			/**
			 * @return the cAT_HVICC_1
			 */
			public String getCAT_HVICC_1() {
				return CAT_HVICC_1;
			}

			/**
			 * @param cAT_HVICC_1 the cAT_HVICC_1 to set
			 */
			public void setCAT_HVICC_1(String cAT_HVICC_1) {
				CAT_HVICC_1 = cAT_HVICC_1;
			}

			/**
			 * @return the cAT_HVGC_1
			 */
			public String getCAT_HVGC_1() {
				return CAT_HVGC_1;
			}

			/**
			 * @param cAT_HVGC_1 the cAT_HVGC_1 to set
			 */
			public void setCAT_HVGC_1(String cAT_HVGC_1) {
				CAT_HVGC_1 = cAT_HVGC_1;
			}

			/**
			 * @return the gB_HVCTAYN_1
			 */
			public String getGB_HVCTAYN_1() {
				return GB_HVCTAYN_1;
			}

			/**
			 * @param gB_HVCTAYN_1 the gB_HVCTAYN_1 to set
			 */
			public void setGB_HVCTAYN_1(String gB_HVCTAYN_1) {
				GB_HVCTAYN_1 = gB_HVCTAYN_1;
			}

			/**
			 * @return the gB_HVMRI_1
			 */
			public String getGB_HVMRI_1() {
				return GB_HVMRI_1;
			}

			/**
			 * @param gB_HVMRI_1 the gB_HVMRI_1 to set
			 */
			public void setGB_HVMRI_1(String gB_HVMRI_1) {
				GB_HVMRI_1 = gB_HVMRI_1;
			}

			/**
			 * @return the gB_HVANGO_1
			 */
			public String getGB_HVANGO_1() {
				return GB_HVANGO_1;
			}

			/**
			 * @param gB_HVANGO_1 the gB_HVANGO_1 to set
			 */
			public void setGB_HVANGO_1(String gB_HVANGO_1) {
				GB_HVANGO_1 = gB_HVANGO_1;
			}

			/**
			 * @return the gB_HVENTI_1
			 */
			public String getGB_HVENTI_1() {
				return GB_HVENTI_1;
			}

			/**
			 * @param gB_HVENTI_1 the gB_HVENTI_1 to set
			 */
			public void setGB_HVENTI_1(String gB_HVENTI_1) {
				GB_HVENTI_1 = gB_HVENTI_1;
			}

			/**
			 * @return the dT_REGT_1
			 */
			public String getDT_REGT_1() {
				return DT_REGT_1;
			}

			/**
			 * @param dT_REGT_1 the dT_REGT_1 to set
			 */
			public void setDT_REGT_1(String dT_REGT_1) {
				DT_REGT_1 = dT_REGT_1;
			}

			/**
			 * @return the lOG_DATE
			 */
			public String getLOG_DATE() {
				return LOG_DATE;
			}

			/**
			 * @param lOG_DATE the lOG_DATE to set
			 */
			public void setLOG_DATE(String lOG_DATE) {
				LOG_DATE = lOG_DATE;
			}

			/**
			 * @return the oRGN_DETL_NM
			 */
			public String getORGN_DETL_NM() {
				return ORGN_DETL_NM;
			}

			/**
			 * @param oRGN_DETL_NM the oRGN_DETL_NM to set
			 */
			public void setORGN_DETL_NM(String oRGN_DETL_NM) {
				ORGN_DETL_NM = oRGN_DETL_NM;
			}

			/**
			 * @return the oRGN_DETL_NM_1
			 */
			public String getORGN_DETL_NM_1() {
				return ORGN_DETL_NM_1;
			}

			/**
			 * @param oRGN_DETL_NM_1 the oRGN_DETL_NM_1 to set
			 */
			public void setORGN_DETL_NM_1(String oRGN_DETL_NM_1) {
				ORGN_DETL_NM_1 = oRGN_DETL_NM_1;
			}

			/**
			 * @return the oRGN_DETL_NM_2
			 */
			public String getORGN_DETL_NM_2() {
				return ORGN_DETL_NM_2;
			}

			/**
			 * @param oRGN_DETL_NM_2 the oRGN_DETL_NM_2 to set
			 */
			public void setORGN_DETL_NM_2(String oRGN_DETL_NM_2) {
				ORGN_DETL_NM_2 = oRGN_DETL_NM_2;
			}

			/**
			 * @return the kIOSK_TY1
			 */
			public String getKIOSK_TY1() {
				return KIOSK_TY1;
			}

			/**
			 * @param kIOSK_TY1 the kIOSK_TY1 to set
			 */
			public void setKIOSK_TY1(String kIOSK_TY1) {
				KIOSK_TY1 = kIOSK_TY1;
			}

			/**
			 * @return the kIOSK_TY2
			 */
			public String getKIOSK_TY2() {
				return KIOSK_TY2;
			}

			/**
			 * @param kIOSK_TY2 the kIOSK_TY2 to set
			 */
			public void setKIOSK_TY2(String kIOSK_TY2) {
				KIOSK_TY2 = kIOSK_TY2;
			}

			/**
			 * @return the kIOSK_TY3
			 */
			public String getKIOSK_TY3() {
				return KIOSK_TY3;
			}

			/**
			 * @param kIOSK_TY3 the kIOSK_TY3 to set
			 */
			public void setKIOSK_TY3(String kIOSK_TY3) {
				KIOSK_TY3 = kIOSK_TY3;
			}

			/**
			 * @return the kIOSK_TY4
			 */
			public String getKIOSK_TY4() {
				return KIOSK_TY4;
			}

			/**
			 * @param kIOSK_TY4 the kIOSK_TY4 to set
			 */
			public void setKIOSK_TY4(String kIOSK_TY4) {
				KIOSK_TY4 = kIOSK_TY4;
			}

			/**
			 * @return the kIOSK_TY5
			 */
			public String getKIOSK_TY5() {
				return KIOSK_TY5;
			}

			/**
			 * @param kIOSK_TY5 the kIOSK_TY5 to set
			 */
			public void setKIOSK_TY5(String kIOSK_TY5) {
				KIOSK_TY5 = kIOSK_TY5;
			}

			/**
			 * @return the kIOSK_TY6
			 */
			public String getKIOSK_TY6() {
				return KIOSK_TY6;
			}

			/**
			 * @param kIOSK_TY6 the kIOSK_TY6 to set
			 */
			public void setKIOSK_TY6(String kIOSK_TY6) {
				KIOSK_TY6 = kIOSK_TY6;
			}

			/**
			 * @return the kIOSK_TY7
			 */
			public String getKIOSK_TY7() {
				return KIOSK_TY7;
			}

			/**
			 * @param kIOSK_TY7 the kIOSK_TY7 to set
			 */
			public void setKIOSK_TY7(String kIOSK_TY7) {
				KIOSK_TY7 = kIOSK_TY7;
			}

			/**
			 * @return the kIOSK_TY8
			 */
			public String getKIOSK_TY8() {
				return KIOSK_TY8;
			}

			/**
			 * @param kIOSK_TY8 the kIOSK_TY8 to set
			 */
			public void setKIOSK_TY8(String kIOSK_TY8) {
				KIOSK_TY8 = kIOSK_TY8;
			}

			/**
			 * @return the kIOSK_TY9
			 */
			public String getKIOSK_TY9() {
				return KIOSK_TY9;
			}

			/**
			 * @param kIOSK_TY9 the kIOSK_TY9 to set
			 */
			public void setKIOSK_TY9(String kIOSK_TY9) {
				KIOSK_TY9 = kIOSK_TY9;
			}

			/**
			 * @return the kIOSK_TY10
			 */
			public String getKIOSK_TY10() {
				return KIOSK_TY10;
			}

			/**
			 * @param kIOSK_TY10 the kIOSK_TY10 to set
			 */
			public void setKIOSK_TY10(String kIOSK_TY10) {
				KIOSK_TY10 = kIOSK_TY10;
			}

			/**
			 * @return the kIOSK_TY11
			 */
			public String getKIOSK_TY11() {
				return KIOSK_TY11;
			}

			/**
			 * @param kIOSK_TY11 the kIOSK_TY11 to set
			 */
			public void setKIOSK_TY11(String kIOSK_TY11) {
				KIOSK_TY11 = kIOSK_TY11;
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
				session.selectList("SQL.SUPPORT.NGAVL_VL11001", map);
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
