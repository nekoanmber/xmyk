package com.xmyk.dentistservice.mapper;

import java.util.List;
import com.xmyk.dentistservice.domain.DentistPlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 牙科计划Mapper接口
 * 
 * @author anlex
 * @date 2026-05-16
 */
@Mapper
public interface DentistPlanMapper extends BaseMapper<DentistPlan>
{
    /**
     * 查询牙科计划
     * 
     * @param id 牙科计划主键
     * @return 牙科计划
     */
    public DentistPlan selectDentistPlanById(Long id);

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
     * @param dentistPlan 牙科计划
     * @return 结果
     */
    public int insertDentistPlan(DentistPlan dentistPlan);

    /**
     * 修改牙科计划
     * 
     * @param dentistPlan 牙科计划
     * @return 结果
     */
    public int updateDentistPlan(DentistPlan dentistPlan);

    /**
     * 删除牙科计划
     * 
     * @param id 牙科计划主键
     * @return 结果
     */
    public int deleteDentistPlanById(Long id);

    /**
     * 批量删除牙科计划
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDentistPlanByIds(Long[] ids);
}
