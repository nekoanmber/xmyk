package com.xmyk.dentistservice.service.impl;

import java.util.Arrays;
import java.util.List;
import com.xmyk.common.utils.DateUtils;
import com.xmyk.dentistservice.vo.ServiceProjectVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xmyk.dentistservice.mapper.ServiceProjectMapper;
import com.xmyk.dentistservice.domain.ServiceProject;
import com.xmyk.dentistservice.service.IServiceProjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

/**
 * 服务项目Service业务层处理
 * 
 * @author anlex
 * @date 2026-05-16
 */
@Service
public class ServiceProjectServiceImpl extends ServiceImpl<ServiceProjectMapper, ServiceProject> implements IServiceProjectService
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
        return getById(id);
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
        return save(serviceProject) ? 1 : 0;
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
        return updateById(serviceProject) ? 1 : 0;
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
        return removeByIds(Arrays.asList(ids)) ? 1 : 0;
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
        return removeById(id) ? 1 : 0;
    }

    /**
     * 获取全部服务项目
     *
     * @return 全部服务项目
     */
    @Override
    public List<ServiceProjectVo> getAllProjects() {
        return serviceProjectMapper.getAllProjects();
    }
}
