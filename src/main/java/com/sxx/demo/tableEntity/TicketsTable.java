package com.sxx.demo.tableEntity;

import javax.persistence.*;

/**
 * 用户登陆票证表
 */
@Entity
@Table(name = "ticket" ,uniqueConstraints={@UniqueConstraint(columnNames={"uId"})})
public class TicketsTable {
    @Id
    @GeneratedValue
    private Integer id;
    private String uId;//用户id
    @Column(name = "createTime")
    private long createTime;//生成时间
    @Column(name = "ticker")
    private String ticker;//token

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public String getTicker() {
        return ticker;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }
}
