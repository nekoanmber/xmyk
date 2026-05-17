package com.xmyk.dentistservice.mapper;

import java.util.List;
import com.xmyk.dentistservice.domain.DentistProjectPlan;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xmyk.dentistservice.vo.DentistProjectPlanVo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 牙科计划和项目关联Mapper接口
 * 
 * @author anlex
 * @date 2026-05-17
 */
@Mapper
public interface DentistProjectPlanMapper extends BaseMapper<DentistProjectPlan>
{
    /**
     * 查询牙科计划和项目关联
     * 
     * @param id 牙科计划和项目关联主键
     * @return 牙科计划和项目关联
     */
    public DentistProjectPlan selectDentistProjectPlanById(Long id);

    /**
     * 查询牙科计划和项目关联列表
     * 
     * @param dentistProjectPlan 牙科计划和项目关联
     * @return 牙科计划和项目关联集合
     */
    public List<DentistProjectPlan> selectDentistProjectPlanList(DentistProjectPlan dentistProjectPlan);

    /**
     * 新增牙科计划和项目关联
     * 
     * @param dentistProjectPlan 牙科计划和项目关联
     * @return 结果
     */
    public int insertDentistProjectPlan(DentistProjectPlan dentistProjectPlan);

    /**
     * 修改牙科计划和项目关联
     * 
     * @param dentistProjectPlan 牙科计划和项目关联
     * @return 结果
     */
    public int updateDentistProjectPlan(DentistProjectPlan dentistProjectPlan);

    /**
     * 删除牙科计划和项目关联
     * 
     * @param id 牙科计划和项目关联主键
     * @return 结果
     */
    public int deleteDentistProjectPlanById(Long id);

    /**
     * 批量删除牙科计划和项目关联
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDentistProjectPlanByIds(Long[] ids);


    /**
     * 批量新增牙科计划和项目关联
     *
     * @param dentistProjectPlans
     * @param planId
     * @return 插入的条数
     */
    int batchInsert(@Param("dentistProjectPlans") List<DentistProjectPlan> dentistProjectPlans,@Param("planId") Long planId);

    /**
     * 根据计划id查询计划关联项目
     *
     * @param planId
     * @return
     */
    List<DentistProjectPlanVo> selectByPlanId(@Param("planId") Long planId);

    /**
     * 根据计划id删除计划关联项目
     *
     * @param planId
     */
    @Delete("delete from dentist_project_plan where plan_id = #{planId}")
    void deleteByPlanId(@Param("planId") Long planId);
}
