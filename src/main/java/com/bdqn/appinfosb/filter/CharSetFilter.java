package com.bdqn.appinfosb.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
/**
 * ClassName: {@link CharSetFilter}
 * create by:  xyf
 * description: TODO 字符过滤器
 * create time: 2019/9/16 21:07
 */
@WebFilter(filterName = "CharSetFilter", urlPatterns = "/*")
public class CharSetFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
