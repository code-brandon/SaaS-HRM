package com.xiaozheng.model.dto;

import com.xiaozheng.model.co.CoDepartmentEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel("部门列表 Dto")
public class DepartmentListDto {

    @ApiModelProperty("企业ID")
    private String companyId;

    @ApiModelProperty("公司名")
    private String companyName;

    @ApiModelProperty("公司联系人")
    private String companyManage;

    @ApiModelProperty("联合部门list")
    private List<CoDepartmentEntity> departments;
}
