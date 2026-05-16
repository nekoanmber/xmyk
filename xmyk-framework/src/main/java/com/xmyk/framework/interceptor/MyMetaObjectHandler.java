package com.xmyk.framework.interceptor;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.xmyk.common.core.domain.model.LoginUser;
import com.xmyk.common.utils.DateUtils;
import com.xmyk.common.utils.SecurityUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyMetaObjectHandler implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {
        this.strictInsertFill(metaObject, "createBy", String.class, String.valueOf(getLoginUserId()));
        this.strictInsertFill(metaObject, "createTime", Date.class, DateUtils.getNowDate());
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("updateTime", DateUtils.getNowDate(), metaObject);
        this.setFieldValByName("updateBy", String.valueOf(getLoginUserId()), metaObject);

//        this.strictInsertFill(metaObject, "updateBy", String.class, String.valueOf(getLoginUserId()));
//        this.strictUpdateFill(metaObject, "updateTime", Date.class, DateUtils.getNowDate());
    }

    public Long getLoginUserId(){
        LoginUser loginUser = SecurityUtils.getLoginUser();
        if(ObjectUtils.isNotEmpty(loginUser)){
            return loginUser.getUserId();
        }
        return 1L;
    }
}
