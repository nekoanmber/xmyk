package com.xmyk.dentistservice.domain;

import java.math.BigDecimal;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import com.xmyk.common.annotation.Excel;
import com.xmyk.common.core.domain.BaseEntity;

/**
 * 服务项目对象 service_project
 * 
 * @author anlex
 * @date 2026-05-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "服务项目")
public class ServiceProject extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 编号 */
    @ApiModelProperty("编号")
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    @ApiModelProperty("名称")
    private String name;

    /** 排序号 */
    @Excel(name = "排序号")
    @ApiModelProperty("排序号")
    private Integer orderNo;

    /** 单位 */
    @Excel(name = "单位")
    @ApiModelProperty("单位")
    private String unit;

    /** 价格 */
    @Excel(name = "价格")
    @ApiModelProperty("价格")
    private BigDecimal price;

    /** 图片 */
    @Excel(name = "图片")
    @ApiModelProperty("图片")
    private String image;

    /** 服务要求 */
    @Excel(name = "服务要求")
    @ApiModelProperty("服务要求")
    private String nursingRequirement;

    /** 状态（0：禁用，1：启用） */
    @Excel(name = "状态", readConverterExp = "0=：禁用，1：启用")
    @ApiModelProperty("状态（0：禁用，1：启用）")
    private Integer status;

}
