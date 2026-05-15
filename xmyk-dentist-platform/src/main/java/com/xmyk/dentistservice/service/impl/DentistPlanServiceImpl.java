package com.xmyk.dentistservice.service.impl;

import java.util.List;
import com.xmyk.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xmyk.dentistservice.mapper.DentistPlanMapper;
import com.xmyk.dentistservice.domain.DentistPlan;
import com.xmyk.dentistservice.service.IDentistPlanService;

/**
 * 牙科计划Service业务层处理
 * 
 * @author anlex
 * @date 2026-05-15
 */
@Service
public class DentistPlanServiceImpl implements IDentistPlanService 
{
    @Autowired
    private DentistPlanMapper dentistPlanMapper;

    /**
     * 查询牙科计划
     * 
     * @param id 牙科计划主键
     * @return 牙科计划
     */
    @Override
    public DentistPlan selectDentistPlanById(Long id)
    {
        return dentistPlanMapper.selectDentistPlanById(id);
    }

    /**
     * 查询牙科计划列表
     * 
     * @param dentistPlan 牙科计划
     * @return 牙科计划
     */
    @Override
    public List<DentistPlan> selectDentistPlanList(DentistPlan dentistPlan)
    {
        return dentistPlanMapper.selectDentistPlanList(dentistPlan);
    }

    /**
     * 新增牙科计划
     * 
     * @param dentistPlan 牙科计划
     * @return 结果
     */
    @Override
    public int insertDentistPlan(DentistPlan dentistPlan)
    {
        dentistPlan.setCreateTime(DateUtils.getNowDate());
        return dentistPlanMapper.insertDentistPlan(dentistPlan);
    }

    /**
     * 修改牙科计划
     * 
     * @param dentistPlan 牙科计划
     * @return 结果
     */
    @Override
    public int updateDentistPlan(DentistPlan dentistPlan)
    {
        dentistPlan.setUpdateTime(DateUtils.getNowDate());
        return dentistPlanMapper.updateDentistPlan(dentistPlan);
    }

    /**
     * 批量删除牙科计划
     * 
     * @param ids 需要删除的牙科计划主键
     * @return 结果
     */
    @Override
    public int deleteDentistPlanByIds(Long[] ids)
    {
        return dentistPlanMapper.deleteDentistPlanByIds(ids);
    }

    /**
     * 删除牙科计划信息
     * 
     * @param id 牙科计划主键
     * @return 结果
     */
    @Override
    public int deleteDentistPlanById(Long id)
    {
        return dentistPlanMapper.deleteDentistPlanById(id);
    }
}
