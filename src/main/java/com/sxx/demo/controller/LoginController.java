package com.sxx.demo.controller;

import com.sxx.demo.dao.TicketsDao;
import com.sxx.demo.dao.UserDao;
import com.sxx.demo.manager.TokenManager;
import com.sxx.demo.model.response.BaseResponse;
import com.sxx.demo.model.response.FailResponse;
import com.sxx.demo.model.response.SuccessResponse;
import com.sxx.demo.tableEntity.TicketsTable;
import com.sxx.demo.tableEntity.UserTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController()
@RequestMapping(value = "/login")
public class LoginController {
    @Autowired
    UserDao userDao;
    @Autowired
    TicketsDao ticketsDao;

    @RequestMapping(value = "", method = RequestMethod.POST)
    BaseResponse login(@RequestBody Map<String, String> code) {
//        System.out.println("code   " + code.get("code"));
        if (checkIsHasLogin() != null) {
            return checkIsHasLogin();
        } else {
            return regist();
        }
    }

    private BaseResponse checkIsHasLogin() {
        UserTable userTable = userDao.findByopenId("xxxxxxxxxxx");
        BaseResponse<String> response = null;
        if (userTable != null) {//已注册
            TicketsTable ticketsTable = ticketsDao.findByuId(userTable.getuId());
            if (ticketsTable == null) {//没token
                TokenManager tokenManager = new TokenManager();
                TicketsTable token = tokenManager.createToken(userTable.getuId());
                ticketsDao.save(token);
                response = new SuccessResponse<String>("登陆成功");
                response.setData(ticketsTable.getTicker());
                return response;
            } else {
                long currentTime = System.currentTimeMillis();
                long diffTime = currentTime - ticketsTable.getCreateTime();
                if (diffTime > 1000 * 24 * 60 * 60 * 10) {//token 失效
                    response = new FailResponse("token 失效");
                    return response;
                } else {
                    response = new SuccessResponse<>("登陆成功");
                    response.setData(ticketsTable.getTicker());
                    return response;
                }
            }
        } else {
            return response;
        }


    }

    private BaseResponse regist() {
        UserTable userTable = new UserTable();
        userTable.setNickName("sxx");
        userTable.setAddress("上海浦东新区广兰路");
        userTable.setCreateTime(System.currentTimeMillis());
        userTable.setOpenId("xxxxxxxxxxx");
        userTable.setPhone("11111111111");
        userTable.setuId(UUID.randomUUID().toString());
        userDao.save(userTable);
        TokenManager tokenManager = new TokenManager();
        TicketsTable ticketsTable = tokenManager.createToken(userTable.getuId());
        ticketsDao.save(ticketsTable);
        BaseResponse<String> response = new SuccessResponse<String>("登陆成功");
        response.setData(ticketsTable.getTicker());
        return response;
    }


}
