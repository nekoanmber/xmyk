package com.xmyk.dentistservice.dto;

import com.xmyk.dentistservice.domain.DentistPlan;
import com.xmyk.dentistservice.domain.DentistProjectPlan;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class DentistPlanDto {

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
    List<DentistProjectPlan> projectPlans;
}
