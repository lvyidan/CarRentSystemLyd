package com.jd.framwork.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CharacterEncodingFilter implements Filter {

	String encoding = null;// 系统默认的编码方式

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		encoding = null;
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		if (null != encoding) {
			request.setCharacterEncoding(encoding);
			response.setCharacterEncoding(encoding);
		}

		filterChain.doFilter(request, response);// 此方法不能少，保证用户的请求继续进行
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.encoding = filterConfig.getInitParameter("encoding");
	}

}
