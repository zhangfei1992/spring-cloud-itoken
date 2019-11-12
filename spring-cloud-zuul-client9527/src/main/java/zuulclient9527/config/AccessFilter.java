package zuulclient9527.config;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_DECORATION_FILTER_ORDER;
import static org.springframework.cloud.netflix.zuul.filters.support.FilterConstants.PRE_TYPE;
@Configuration
public class AccessFilter extends ZuulFilter {
    /**
     * 通过int值来定义过滤器的执行顺序
     */
    @Override
    public int filterOrder() {
        // PreDecoration之前运行
        return PRE_DECORATION_FILTER_ORDER - 1;
    }

    /**
     * 过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型：
     *   public static final String ERROR_TYPE = "error";
     *   public static final String POST_TYPE = "post";
     *   public static final String PRE_TYPE = "pre";
     *   public static final String ROUTE_TYPE = "route";
     */
    @Override
    public String filterType() {
        return PRE_TYPE;
    }

    /**
     * 过滤器的具体逻辑
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        System.out.println(String.format("%s AccessFilter request to %s", request.getMethod(), request.getRequestURL().toString()));
        String accessToken = request.getParameter("accessToken");
        //有权限令牌
        if (!StringUtils.isEmpty(accessToken)) {
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            //可以设置一些值
            ctx.set("isSuccess", true);
            return null;
        } else {
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            ctx.setResponseBody("{\"result\":\"accessToken is not correct!\"}");
            //可以设置一些值
            ctx.set("isSuccess", false);
            return null;
        }
    }
        /**
         * 返回一个boolean类型来判断该过滤器是否要执行
         */
        @Override
        public boolean shouldFilter() {
            return true;
        }
}
