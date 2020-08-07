package com.im.main;

import com.passport.rpc.UserRPCService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

@Component
public class RPCBean  {

    @Reference
    private UserRPCService rpcService;


    public UserRPCService getRpcService() {
        return rpcService;
    }
}
