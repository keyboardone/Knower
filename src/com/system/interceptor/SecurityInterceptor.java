package com.system.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.system.common.Constants;

public class SecurityInterceptor extends HandlerInterceptorAdapter {

	private final Logger log = LoggerFactory
			.getLogger(SecurityInterceptor.class);

	/**
	 * 登录拦截器
	 */
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response, Object handler) throws Exception {

		String url = request.getServletPath();
		if(url.contains("/login.do") || url.equals("/")){
			// session中设置URL信息
			this.setUseSessionUrlInfo(request.getRequestURL().toString(),request,response);
			return true;
		}else{
			if(StringUtils.isEmpty( request.getSession().getAttribute(Constants.USER_ID))){
				request.getRequestDispatcher("/").forward(request, response); 
				return false;
			}else{
				log.info("验证成功！");
				return true;
			}
		}
	}

	/**
	 * SESSION中设置URL信息
	 * 
	 * @param sUrl
	 * @param request
	 * @param response
	 */
	private void setUseSessionUrlInfo(String sUrl,HttpServletRequest request,HttpServletResponse response) {
		try {
			String[] splitList = sUrl.split(":");
			String defaultIPAddress;
			String defaultPort;

			if (splitList.length > 2) {
				int lastIndex = sUrl.lastIndexOf(":");
				String sDefaultPort = sUrl.substring(lastIndex + 1, sUrl
						.length());
				String sDefaultIPAddress = sUrl.substring(0, lastIndex);

				defaultIPAddress = sDefaultIPAddress
						.substring(sDefaultIPAddress.lastIndexOf("/") + 1);
				defaultPort = sDefaultPort.substring(0, sDefaultPort
						.indexOf("/"));
				log.info("-----------Has port!");
			} else {
				String httpTop = sUrl.substring(0, sUrl.indexOf(":"));
				if ("https".equals(httpTop.toLowerCase())) {
					defaultPort = "443";
				} else {
					defaultPort = "80";
				}

				defaultIPAddress = sUrl.substring(sUrl.indexOf(":") + 3);
				defaultIPAddress = defaultIPAddress.substring(0,
						defaultIPAddress.indexOf("/"));
				log.info("-----------With out port!");
			}
			log.info("-----------loginUrl:" + sUrl);
			log.info("-----------defaultPort:" + defaultPort);
			log.info("-----------defaultIPAddress:" + defaultIPAddress);

			request.getSession().setAttribute(Constants.SERVICE_ADDRESS,
					defaultIPAddress);
			request.getSession().setAttribute(Constants.SERVICE_PORT, defaultPort);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
