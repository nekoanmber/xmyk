package com.xmyk.dentistservice.vo;

import com.xmyk.common.annotation.Excel;
import lombok.Data;

@Data
public class DentistProjectPlanVo {
    /**
     * 项目id
     */
    private String projectId;

    /**
     * 套餐和项目关联表id
     */
    private Long id;

    /**
     * 套餐id
     */
    @Excel(name = "项目id")
    private Long planId;

    /**
     * 计划执行时间
     */
    @Excel(name = "计划执行时间")
    private String executeTime;

    /**
     * 执行周期 0 天 1 周 2月
     */
    @Excel(name = "执行周期 0 天 1 周 2月")
    private String executeCycle;

    /**
     * 执行频次
     */
    @Excel(name = "执行频次")
    private Integer executeFrequency;

    /**
     * 创建人
     */
    private String createBy;

    /**
     * 创建时间
     */
    private String createTime;

}
