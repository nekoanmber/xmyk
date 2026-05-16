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
 * 牙科等级对象 dentist_level
 * 
 * @author anlex
 * @date 2026-05-16
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(description = "牙科等级")
public class DentistLevel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @ApiModelProperty("主键ID")
    private Long id;

    /** 等级名称 */
    @Excel(name = "等级名称")
    @ApiModelProperty("等级名称")
    private String name;

    /** 牙科计划ID */
    @Excel(name = "牙科计划ID")
    @ApiModelProperty("牙科计划ID")
    private Long planId;

    /** 牙科费用 */
    @Excel(name = "牙科费用")
    @ApiModelProperty("牙科费用")
    private BigDecimal fee;

    /** 状态（0：禁用，1：启用） */
    @Excel(name = "状态", readConverterExp = "0=：禁用，1：启用")
    @ApiModelProperty("状态（0：禁用，1：启用）")
    private Integer status;

    /** 等级说明 */
    @Excel(name = "等级说明")
    @ApiModelProperty("等级说明")
    private String description;

}
