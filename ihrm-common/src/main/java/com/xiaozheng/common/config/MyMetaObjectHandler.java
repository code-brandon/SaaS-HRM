package com.xiaozheng.common.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.core.handlers.StrictFill;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Xiao
 */
@Slf4j
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ....");
        log.info(String.valueOf(new Date()));
        // 起始版本 3.3.0(推荐使用)
        List<StrictFill<?, ?>> strictFills = new ArrayList<>();
        strictFills.add(StrictFill.of("createDate", Date.class, new Date()));
        strictFills.add(StrictFill.of("createTime", Date.class, new Date()));
        this.strictInsertFill(findTableInfo(metaObject), metaObject,strictFills);
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ....");
        log.info(String.valueOf(new Date()));
        // 起始版本 3.3.0(推荐)
        List<StrictFill<?, ?>> strictFills = new ArrayList<>();
        strictFills.add(StrictFill.of("updateDate", Date.class, new Date()));
        strictFills.add(StrictFill.of("updateTime", Date.class, new Date()));
        this.strictInsertFill(findTableInfo(metaObject), metaObject,strictFills);
    }
}
