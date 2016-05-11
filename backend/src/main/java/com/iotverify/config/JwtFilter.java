//package com.iotverify.config;
//
//import org.springframework.web.filter.GenericFilterBean;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.ServletRequest;
//import javax.servlet.ServletResponse;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by lede on 5/11/16.
// */
//public class JwtFilter extends GenericFilterBean {
//    @Override
//    public void doFilter(final ServletRequest req,
//                         final ServletResponse res,
//                         final FilterChain chain) throws IOException, ServletException {
//
//        final HttpServletRequest request = (HttpServletRequest) req;
//        final HttpServletResponse response = (HttpServletResponse) res;
//        final String authHeader = request.getHeader("authorization");
//
//        if ("OPTIONS".equals(request.getMethod())) {
//            response.setStatus(HttpServletResponse.SC_OK);
//
//            chain.doFilter(req, res);
//        }
//
//    }
//}
