package com.im.main;

import com.common.exception.BizException;
import com.common.util.RPCResult;
import com.common.util.StringUtils;
import com.common.web.AbstractController;
import com.passport.rpc.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;

/**
 * Created by dabai on 2017/5/12.
 */
@Slf4j
public abstract class AbstractClientController extends AbstractController {

    @Resource
    private RPCBean rpcBean;

    protected UserDTO getUser() {
        UserDTO dto = (UserDTO) request.getSession().getAttribute("token");
        if (dto != null) {
            return dto;
        }
        String token = getToken();
        try {
            RPCResult<UserDTO> result = rpcBean.getRpcService().verificationToken(token);
            if (!result.getSuccess()) {
                throw new BizException("login.error", "获取token失败");
            }

            if (result.getSuccess()) {
                request.getSession().setAttribute("token", result.getData());
                return result.getData();
            }
        } catch (Exception e) {
            if (e instanceof BizException) {
                throw e;
            }
            log.error("userRPCService.verificationToken.error", e);
        }
        throw new BizException("login.rpc.error", "获取token失败");
    }

    protected String getToken() {
        String token = getRequest().getHeader("token");
        if (StringUtils.isBlank(token)) {
            Cookie tokenCookie = null;
            for (Cookie item : getRequest().getCookies()) {
                if (StringUtils.equals(item.getName(), "token")) {
                    tokenCookie = item;
                    break;
                }
            }
            if (tokenCookie == null) {
                throw new BizException("token.error", "获取token失败");
            }
            token = tokenCookie.getValue();
        }
        return token;
    }

}
