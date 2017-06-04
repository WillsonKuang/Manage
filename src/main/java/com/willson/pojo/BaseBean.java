package com.willson.pojo;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Created by Administrator on 2017/6/3 0003.
 */
public class BaseBean {

    private Timestamp createTime = new Timestamp(new Date().getTime());

    private Timestamp modifiedTime = new Timestamp(new Date().getTime());

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Timestamp modifiedTime) {
        this.modifiedTime = modifiedTime;
    }
}
