package com.xmyk.dentistservice.service.impl;

import java.util.Arrays;
import java.util.List;
import com.xmyk.common.utils.DateUtils;
import com.xmyk.dentistservice.vo.DentistLevelVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xmyk.dentistservice.mapper.DentistLevelMapper;
import com.xmyk.dentistservice.domain.DentistLevel;
import com.xmyk.dentistservice.service.IDentistLevelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 牙科等级Service业务层处理
 * 
 * @author anlex
 * @date 2026-05-16
 */
@Service
public class DentistLevelServiceImpl extends ServiceImpl<DentistLevelMapper, DentistLevel> implements IDentistLevelService
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
        return getById(id);
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
        return save(dentistLevel) ? 1 : 0;
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
        return updateById(dentistLevel) ? 1 : 0;
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
        return removeByIds(Arrays.asList(ids)) ? 1 : 0;
    }

    /**
     * 查询牙科等级列表(返回Vo)
     *
     * @param dentistLevel 牙科等级
     * @return 牙科等级集合
     */
    @Override
    public List<DentistLevelVo> selectDentistLevelVoList(DentistLevel dentistLevel) {
        return dentistLevelMapper.selectDentistLevelVoList(dentistLevel);
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
        return removeById(id) ? 1 : 0;
    }
}
