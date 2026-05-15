package com.xmyk.dentistservice.service.impl;

import java.util.List;
import com.xmyk.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xmyk.dentistservice.mapper.ServiceProjectMapper;
import com.xmyk.dentistservice.domain.ServiceProject;
import com.xmyk.dentistservice.service.IServiceProjectService;

/**
 * 服务项目Service业务层处理
 * 
 * @author anlex
 * @date 2026-05-15
 */
@Service
public class ServiceProjectServiceImpl implements IServiceProjectService 
{
    @Autowired
    private ServiceProjectMapper serviceProjectMapper;

    /**
     * 查询服务项目
     * 
     * @param id 服务项目主键
     * @return 服务项目
     */
    @Override
    public ServiceProject selectServiceProjectById(Long id)
    {
        return serviceProjectMapper.selectServiceProjectById(id);
    }

    /**
     * 查询服务项目列表
     * 
     * @param serviceProject 服务项目
     * @return 服务项目
     */
    @Override
    public List<ServiceProject> selectServiceProjectList(ServiceProject serviceProject)
    {
        return serviceProjectMapper.selectServiceProjectList(serviceProject);
    }

    /**
     * 新增服务项目
     * 
     * @param serviceProject 服务项目
     * @return 结果
     */
    @Override
    public int insertServiceProject(ServiceProject serviceProject)
    {
        serviceProject.setCreateTime(DateUtils.getNowDate());
        return serviceProjectMapper.insertServiceProject(serviceProject);
    }

    /**
     * 修改服务项目
     * 
     * @param serviceProject 服务项目
     * @return 结果
     */
    @Override
    public int updateServiceProject(ServiceProject serviceProject)
    {
        serviceProject.setUpdateTime(DateUtils.getNowDate());
        return serviceProjectMapper.updateServiceProject(serviceProject);
    }

    /**
     * 批量删除服务项目
     * 
     * @param ids 需要删除的服务项目主键
     * @return 结果
     */
    @Override
    public int deleteServiceProjectByIds(Long[] ids)
    {
        return serviceProjectMapper.deleteServiceProjectByIds(ids);
    }

    /**
     * 删除服务项目信息
     * 
     * @param id 服务项目主键
     * @return 结果
     */
    @Override
    public int deleteServiceProjectById(Long id)
    {
        return serviceProjectMapper.deleteServiceProjectById(id);
    }
}
