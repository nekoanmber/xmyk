package com.xmyk.dentistservice.domain;

import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.xmyk.common.annotation.Excel;
import com.xmyk.common.core.domain.BaseEntity;

/**
 * 牙科等级对象 dentist_level
 * 
 * @author anlex
 * @date 2026-05-15
 */
@ApiModel("牙科等级")
public class DentistLevel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键ID */
    @ApiModelProperty("主键ID")
    private Long id;

    /** 等级名称 */
    @ApiModelProperty("等级名称")
    @Excel(name = "等级名称")
    private String name;

    /** 牙科计划ID */
    @ApiModelProperty("牙科计划ID")
    @Excel(name = "牙科计划ID")
    private Long planId;

    /** 牙科费用 */
    @ApiModelProperty("牙科费用")
    @Excel(name = "牙科费用")
    private BigDecimal fee;

    /** 状态（0：禁用，1：启用） */
    @ApiModelProperty("状态（0：禁用，1：启用）")
    @Excel(name = "状态", readConverterExp = "0=：禁用，1：启用")
    private Integer status;

    /** 等级说明 */
    @ApiModelProperty("等级说明")
    @Excel(name = "等级说明")
    private String description;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }

    public void setPlanId(Long planId) 
    {
        this.planId = planId;
    }

    public Long getPlanId() 
    {
        return planId;
    }

    public void setFee(BigDecimal fee) 
    {
        this.fee = fee;
    }

    public BigDecimal getFee() 
    {
        return fee;
    }

    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("planId", getPlanId())
            .append("fee", getFee())
            .append("status", getStatus())
            .append("description", getDescription())
            .append("remark", getRemark())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("createBy", getCreateBy())
            .append("updateBy", getUpdateBy())
            .toString();
    }
}
