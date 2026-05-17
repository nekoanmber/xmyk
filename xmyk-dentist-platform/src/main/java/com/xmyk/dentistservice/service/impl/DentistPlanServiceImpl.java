package com.xmyk.dentistservice.service.impl;

import java.util.Arrays;
import java.util.List;
import com.xmyk.common.utils.DateUtils;
import com.xmyk.common.utils.bean.BeanUtils;
import com.xmyk.dentistservice.dto.DentistPlanDto;
import com.xmyk.dentistservice.mapper.DentistProjectPlanMapper;
import com.xmyk.dentistservice.vo.DentistPlanVo;
import com.xmyk.dentistservice.vo.DentistProjectPlanVo;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xmyk.dentistservice.mapper.DentistPlanMapper;
import com.xmyk.dentistservice.domain.DentistPlan;
import com.xmyk.dentistservice.service.IDentistPlanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;

/**
 * 牙科计划Service业务层处理
 * 
 * @author anlex
 * @date 2026-05-16
 */
@Service
public class DentistPlanServiceImpl extends ServiceImpl<DentistPlanMapper, DentistPlan> implements IDentistPlanService
{
    @Autowired
    private DentistPlanMapper dentistPlanMapper;

    @Autowired
    private DentistProjectPlanMapper dentistProjectPlanMapper;

    /**
     * 查询牙科计划
     * 
     * @param id 牙科计划主键
     * @return 牙科计划
     */
    @Override
    public DentistPlanVo selectDentistPlanById(Long id)
    {
        //查询套餐基本信息
        DentistPlan dentistPlan = dentistPlanMapper.selectById(id);

        //查询套餐关联的项目集合
        List<DentistProjectPlanVo> projectPlans = dentistProjectPlanMapper.selectByPlanId(id);

        //合并为一个对象返回
        DentistPlanVo dentistPlanVo = new DentistPlanVo();
        BeanUtils.copyProperties(dentistPlan, dentistPlanVo);
        dentistPlanVo.setProjectPlans(projectPlans);
        return dentistPlanVo;
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
     * @param dentistPlanDto 牙科计划
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int insertDentistPlan(DentistPlanDto dentistPlanDto)
    {
        //1.保存牙科套餐
        DentistPlan dentistPlan = new DentistPlan();
        //1.1 属性拷贝
        BeanUtils.copyProperties(dentistPlanDto, dentistPlan);
        dentistPlan.setCreateTime(DateUtils.getNowDate());

        dentistPlanMapper.insert(dentistPlan);
        //主键返回：因为传进来的dentistPlanDto是没有id的，使用了mybatisplus的insert方法，可以主键返回id给dentistPlan

        //2.批量保存牙科计划和牙科项目的对应关系
        int count = dentistProjectPlanMapper.batchInsert(dentistPlanDto.getProjectPlans(), dentistPlan.getId());

        return count == 0 ? 0 : 1;
    }

    /**
     * 修改牙科计划
     * 
     * @param dentistPlanDto 牙科计划
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int updateDentistPlan(DentistPlanDto dentistPlanDto)
    {
        if(dentistPlanDto.getProjectPlans() != null && !dentistPlanDto.getProjectPlans().isEmpty()){
            dentistProjectPlanMapper.deleteByPlanId(dentistPlanDto.getId());

            dentistProjectPlanMapper.batchInsert(dentistPlanDto.getProjectPlans(), dentistPlanDto.getId());
        }

        DentistPlan dentistPlan = new DentistPlan();
        BeanUtils.copyProperties(dentistPlanDto, dentistPlan);
        return dentistPlanMapper.updateById(dentistPlan);
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
        return removeByIds(Arrays.asList(ids)) ? 1 : 0;
    }

    /**
     * 删除牙科计划信息
     * 
     * @param id 牙科计划主键
     * @return 结果
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteDentistPlanById(Long id)
    {
        //删除关联的项目
        dentistProjectPlanMapper.deleteByPlanId(id);
        //删除套餐
        return removeById(id) ? 1 : 0;
    }
}
