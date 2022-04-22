package com.xiaozheng.model.vo.proc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Map;

/**
 * What -- 流程定义Vo
 * <br>
 * Describe --
 * <br>
 *
 * @Package: com.xiaozheng.model.vo.proc
 * @ClassName: ProcessDefinitionVo
 * @Author: 小政同学    QQ:xiaozheng666888@qq.com
 * @CreateTime: 2022/4/20 16:25
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProcessDefinitionVo {


    private String ioSpecification;
    private String name;
    private String description;
    private String key;
    private int version;
    private String category;
    private String deploymentId;
    private String resourceName;
    private String tenantId;
    private Integer historyLevel;
    private String diagramResourceName;
    private boolean isGraphicalNotationDefined;
    private Map<String, Object> variables;
    private boolean hasStartFormKey;
    private int suspensionState;
    private boolean isIdentityLinksInitialized;
    private String engineVersion;
    private String id;
    private int revision;
    private boolean isInserted;
    private boolean isUpdated;
    private  boolean    isDeleted;
}
