package com.steven.netty.demo.resource;


import com.steven.netty.demo.bo.UserCreateSuccess;
import com.steven.netty.demo.bo.UserInfo;
import com.steven.netty.demo.service.UserService;
import com.steven.netty.nettyrest.ApiProtocol;
import com.steven.netty.nettyrest.BaseResource;
import com.steven.netty.nettyrest.StatusCode;
import com.steven.netty.nettyrest.response.Info;
import com.steven.netty.nettyrest.response.Result;

public class UserResource extends BaseResource {

    public UserResource(ApiProtocol apiProtocol) {
        super(apiProtocol);
    }

    public Result get() {

        int uid;

        Object uidCheck = parameterIntCheck(apiProtocol, "uid");
        if (uidCheck instanceof Result) {
            return (Result) uidCheck;
        } else {
            uid = (int) uidCheck;
        }

        UserService userService = new UserService(apiProtocol);
        UserInfo userInfo    = new UserInfo(userService.get(uid));

        return new Result<Info>(userInfo);
    }

    public Result post() {
        UserCreateSuccess userCreateSuccess = new UserCreateSuccess();
        userCreateSuccess.setId(2);
        userCreateSuccess.setUrl("http://netty.restful.api.mengkang.net/user/2");
        userCreateSuccess.setCode(StatusCode.CREATED_SUCCESS);
        return new Result<>(userCreateSuccess);
    }

    public Result patch() {
        return success(202);
    }

    public Result delete() {
        return success(203);
    }

}
