package com.xmyk.dentistservice.service.impl;

import java.util.List;
import com.xmyk.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xmyk.dentistservice.mapper.DentistLevelMapper;
import com.xmyk.dentistservice.domain.DentistLevel;
import com.xmyk.dentistservice.service.IDentistLevelService;

/**
 * 牙科等级Service业务层处理
 * 
 * @author anlex
 * @date 2026-05-15
 */
@Service
public class DentistLevelServiceImpl implements IDentistLevelService 
{
    @Autowired
    private DentistLevelMapper dentistLevelMapper;

    /**
     * 查询牙科等级
     * 
     * @param id 牙科等级主键
     * @return 牙科等级
     */
    @Override
    public DentistLevel selectDentistLevelById(Long id)
    {
        return dentistLevelMapper.selectDentistLevelById(id);
    }

    /**
     * 查询牙科等级列表
     * 
     * @param dentistLevel 牙科等级
     * @return 牙科等级
     */
    @Override
    public List<DentistLevel> selectDentistLevelList(DentistLevel dentistLevel)
    {
        return dentistLevelMapper.selectDentistLevelList(dentistLevel);
    }

    /**
     * 新增牙科等级
     * 
     * @param dentistLevel 牙科等级
     * @return 结果
     */
    @Override
    public int insertDentistLevel(DentistLevel dentistLevel)
    {
        dentistLevel.setCreateTime(DateUtils.getNowDate());
        return dentistLevelMapper.insertDentistLevel(dentistLevel);
    }

    /**
     * 修改牙科等级
     * 
     * @param dentistLevel 牙科等级
     * @return 结果
     */
    @Override
    public int updateDentistLevel(DentistLevel dentistLevel)
    {
        dentistLevel.setUpdateTime(DateUtils.getNowDate());
        return dentistLevelMapper.updateDentistLevel(dentistLevel);
    }

    /**
     * 批量删除牙科等级
     * 
     * @param ids 需要删除的牙科等级主键
     * @return 结果
     */
    @Override
    public int deleteDentistLevelByIds(Long[] ids)
    {
        return dentistLevelMapper.deleteDentistLevelByIds(ids);
    }

    /**
     * 删除牙科等级信息
     * 
     * @param id 牙科等级主键
     * @return 结果
     */
    @Override
    public int deleteDentistLevelById(Long id)
    {
        return dentistLevelMapper.deleteDentistLevelById(id);
    }
}
