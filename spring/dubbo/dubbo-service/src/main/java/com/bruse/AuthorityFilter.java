package com.bruse;

import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.rpc.AppResponse;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcContext;
import org.apache.dubbo.rpc.RpcException;

import java.util.List;

public class AuthorityFilter implements Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(AuthorityFilter.class);

    private IpWhiteList ipWhiteList;

    /**
     * dubbo通过setter方式自动注入
     * @param ipWhiteList
     */
    public void setIpWhiteList(IpWhiteList ipWhiteList) {
        this.ipWhiteList = ipWhiteList;
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        if (!ipWhiteList.isEnabled()) {
            LOGGER.debug("白名单禁用");
            return invoker.invoke(invocation);
        }

        String clientIp = RpcContext.getContext().getRemoteHost();
        LOGGER.debug("访问ip为" + clientIp);
        List<String> allowedIps = ipWhiteList.getAllowedIps();
        if (allowedIps.contains(clientIp)) {
            return invoker.invoke(invocation);
        } else {
            return new AppResponse();
        }
    }
}
