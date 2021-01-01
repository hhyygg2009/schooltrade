package com.yu.st.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Servlet Filter implementation class EncodingFilter
 */
@WebFilter(
        urlPatterns = {"/*"}
)

public class EncodingFilter implements Filter {


    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        String url = ((HttpServletRequest) request).getRequestURI();
        if (url.indexOf(".css") > 0 || url.indexOf(".js") > 0 || url.indexOf(".png") > 0) {
            chain.doFilter(request, response);
            return;
        }

        response.setContentType("text/html;charset=utf-8");

        // pass the request along the filter chain
        chain.doFilter(request, response);
    }


}
