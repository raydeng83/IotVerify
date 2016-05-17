package com.iotverify.config;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lede on 5/11/16.
 */
public class TokenFilter extends GenericFilterBean {
    @Override
    public void doFilter(final ServletRequest req,
                         final ServletResponse res,
                         final FilterChain chain) throws IOException, ServletException {

        final HttpServletRequest request = (HttpServletRequest) req;
        final HttpServletResponse response = (HttpServletResponse) res;
        final String apiKey = request.getHeader("X-KEY-API");

        if ("OPTIONS".equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);

            chain.doFilter(req, res);
        } else {

            if (apiKey == null ) {
                throw new ServletException("Missing API Key");
            }

            if (apiKey.equals("^xG=aUrahw<$+=[jQ`/y4^ke.&PuU)S<Y2N!QkJ`")) {
                chain.doFilter(req, res);
            } else {
                throw new ServletException("Invalid API Key");
            }


        }

    }
}
