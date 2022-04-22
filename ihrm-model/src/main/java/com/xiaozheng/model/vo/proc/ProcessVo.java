package com.xiaozheng.model.vo.proc;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * What -- 流程Vo
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.model.vo.proc
 * @ClassName: ProcessVo
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/4/19 20:30
 */
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessVo implements Serializable {

    private String applyUnit;

    private String duration;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date endTime;

    private String holidayType;

    private String processKey;

    private String processName;

    private String reason;

    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private Date startTime;

    private String userId;
}
