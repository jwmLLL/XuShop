package com.sxx.demo.manager;

import com.sxx.demo.tableEntity.TicketsTable;

import java.util.UUID;

public class TokenManager {
    public TicketsTable createToken(String uid){
        TicketsTable ticketsTable = new TicketsTable();
        ticketsTable.setuId(uid);
        ticketsTable.setCreateTime(System.currentTimeMillis());
        ticketsTable.setTicker(UUID.randomUUID().toString().replace("_",""));
        return ticketsTable;
    }
}
