//package com.zsx.common.servlet;
//
//
//import javax.servlet.annotation.WebInitParam;
//import javax.servlet.annotation.WebServlet;
// 
//import com.alibaba.druid.support.http.StatViewServlet;
// 
// 
///**
// * ����druid���ͳ�ƹ���
// * ��SpringBoot��Ŀ�л���ע������ã������web.xml���ã����������ü���
// * @author ZSX
// *
// */
// 
//@WebServlet(urlPatterns = "/druid/*",
//    initParams = {
////          @WebInitParam(name = "allow", value = "192.168.16.110,127.0.0.1"), // IP������ (û�����û���Ϊ�գ����������з���)
////          @WebInitParam(name="deny",value="192.168.16.111"), // IP������ (���ڹ�ͬʱ��deny������allow)
//            @WebInitParam(name="loginUsername",value="druid"),// �û���
//            @WebInitParam(name="loginPassword",value="druid"),// ����
//            @WebInitParam(name="resetEnable",value="false")// ����HTMLҳ���ϵġ�Reset All������
//    }
//)
//public class DruidStatViewServlet extends StatViewServlet {
//
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
// 
//}