package com.xmyk.dentistservice.mapper;

import java.util.List;
import com.xmyk.dentistservice.domain.DentistLevel;

/**
 * 牙科等级Mapper接口
 * 
 * @author anlex
 * @date 2026-05-15
 */
public interface DentistLevelMapper 
{
    /**
     * 查询牙科等级
     * 
     * @param id 牙科等级主键
     * @return 牙科等级
     */
    public DentistLevel selectDentistLevelById(Long id);

    /**
     * 查询牙科等级列表
     * 
     * @param dentistLevel 牙科等级
     * @return 牙科等级集合
     */
    public List<DentistLevel> selectDentistLevelList(DentistLevel dentistLevel);

    /**
     * 新增牙科等级
     * 
     * @param dentistLevel 牙科等级
     * @return 结果
     */
    public int insertDentistLevel(DentistLevel dentistLevel);

    /**
     * 修改牙科等级
     * 
     * @param dentistLevel 牙科等级
     * @return 结果
     */
    public int updateDentistLevel(DentistLevel dentistLevel);

    /**
     * 删除牙科等级
     * 
     * @param id 牙科等级主键
     * @return 结果
     */
    public int deleteDentistLevelById(Long id);

    /**
     * 批量删除牙科等级
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDentistLevelByIds(Long[] ids);
}
