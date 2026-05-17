package com.xmyk.dentistservice.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "牙科计划")
public class DentistPlanVo {
    /**
     *  套餐id
     */
    @ApiModelProperty("套餐id")
    private Long id;

    /**
     *  排序号
     */
    @ApiModelProperty("排序号")
    private Integer sortNo;

    /**
     *  名称
     */
    @ApiModelProperty("名称")
    private String planName;

    /**
     *  状态 0禁用 1启用
     */
    @ApiModelProperty("状态 0禁用 1启用")
    private Integer status;

    /**
     *  套餐和项目关联表
     */
    @ApiModelProperty("套餐和项目关联表")
    private List<DentistProjectPlanVo> projectPlans;

    @ApiModelProperty("创建时间")
    private String createTime;

    @ApiModelProperty("创建人")
    private String createBy;
}
