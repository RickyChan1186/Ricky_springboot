package com.ricky.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;

/**
 * @author ricky
 * @create 2020-02-28 16:12
 */
@Component
public class LoginFilter extends ZuulFilter {

    /** 过滤器类型，前置过滤器
     * @Author chenzefan
     * @Description //TODO
     * @Date 16:15 2020/2/28
     * @Param []
     * @Return java.lang.String
     **/
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /** 过滤器顺序，越小越先执行
     * @Author chenzefan
     * @Description //TODO
     * @Date 16:17 2020/2/28
     * @Param []
     * @Return int
     **/
    @Override
    public int filterOrder() {
        return 4;
    }

    /** 过滤是否生效
     * @Author chenzefan
     * @Description //TODO
     * @Date 16:18 2020/2/28
     * @Param []
     * @Return boolean
     **/
    @Override
    public boolean shouldFilter() {

        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        System.out.println(request.getRequestURI());
        //System.out.println(request.getRequestURL());

        //进行拦截
        if("/product-service/api/v1/product/listProduct".equalsIgnoreCase(request.getRequestURI())){
            return true;
        }
        return false;
    }

    /** 业务逻辑处理
     * @Author chenzefan
     * @Description //TODO
     * @Date 16:23 2020/2/28
     * @Param []
     * @Return java.lang.Object
     **/
    @Override
    public Object run() throws ZuulException {
        //JWT
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();

        String token = request.getHeader("token");

        if(StringUtils.isBlank(token)){
            token = request.getParameter("token");
        }

        //登陆逻辑检验
        if(StringUtils.isBlank(token)){
            requestContext.setSendZuulResponse(false);
            requestContext.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        return null;
    }
}
