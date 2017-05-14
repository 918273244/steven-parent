package com.steven.netty.demo.resource;



import com.steven.netty.demo.entity.User;
import com.steven.netty.demo.service.UserService;
import com.steven.netty.nettyrest.ApiProtocol;
import com.steven.netty.nettyrest.BaseResource;
import com.steven.netty.nettyrest.response.ListInfo;
import com.steven.netty.nettyrest.response.ListResult;
import com.steven.netty.nettyrest.response.Result;

import java.util.List;

public class UsersResource extends BaseResource {

    public UsersResource(ApiProtocol apiProtocol) {
        super(apiProtocol);
    }

    public Result get() {

        ListInfo info       = new ListInfo();
        ListResult listResult = new ListResult(info);

        UserService userService = new UserService(apiProtocol);

        List<User> list = userService.list();

        info.setNum(list.size());
        listResult.setItem(list);

        return listResult;
    }
}
