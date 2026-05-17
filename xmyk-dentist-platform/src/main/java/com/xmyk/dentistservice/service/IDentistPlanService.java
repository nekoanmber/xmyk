package com.xmyk.dentistservice.service;

import java.util.List;
import com.xmyk.dentistservice.domain.DentistPlan;
import com.baomidou.mybatisplus.extension.service.IService;
import com.xmyk.dentistservice.dto.DentistPlanDto;
import com.xmyk.dentistservice.vo.DentistPlanVo;

/**
 * 牙科计划Service接口
 * 
 * @author anlex
 * @date 2026-05-16
 */
public interface IDentistPlanService extends IService<DentistPlan>
{
    /**
     * 查询牙科计划
     * 
     * @param id 牙科计划主键
     * @return 牙科计划
     */
    public DentistPlanVo selectDentistPlanById(Long id);

    /**
     * 查询牙科计划列表
     * 
     * @param dentistPlan 牙科计划
     * @return 牙科计划集合
     */
    public List<DentistPlan> selectDentistPlanList(DentistPlan dentistPlan);

    /**
     * 新增牙科计划
     * 
     * @param dentistPlanDto 牙科计划
     * @return 结果
     */
    public int insertDentistPlan(DentistPlanDto dentistPlanDto);

    /**
     * 修改牙科计划
     * 
     * @param dentistPlanDto 牙科计划
     * @return 结果
     */
    public int updateDentistPlan(DentistPlanDto dentistPlanDto);

    /**
     * 批量删除牙科计划
     * 
     * @param ids 需要删除的牙科计划主键集合
     * @return 结果
     */
    public int deleteDentistPlanByIds(Long[] ids);

    /**
     * 删除牙科计划信息
     * 
     * @param id 牙科计划主键
     * @return 结果
     */
    public int deleteDentistPlanById(Long id);

    /**
     * 获取全部牙科计划（Vo）
     * @return 获取全部牙科计划
     */
    List<DentistPlanVo> getAllPlans();
}
