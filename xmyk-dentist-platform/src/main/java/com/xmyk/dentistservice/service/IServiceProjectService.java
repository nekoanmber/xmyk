package com.xmyk.dentistservice.service;

import java.util.List;
import com.xmyk.dentistservice.domain.ServiceProject;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 服务项目Service接口
 * 
 * @author anlex
 * @date 2026-05-16
 */
public interface IServiceProjectService extends IService<ServiceProject>
{
    /**
     * 查询服务项目
     * 
     * @param id 服务项目主键
     * @return 服务项目
     */
    public ServiceProject selectServiceProjectById(Long id);

    /**
     * 查询服务项目列表
     * 
     * @param serviceProject 服务项目
     * @return 服务项目集合
     */
    public List<ServiceProject> selectServiceProjectList(ServiceProject serviceProject);

    /**
     * 新增服务项目
     * 
     * @param serviceProject 服务项目
     * @return 结果
     */
    public int insertServiceProject(ServiceProject serviceProject);

    /**
     * 修改服务项目
     * 
     * @param serviceProject 服务项目
     * @return 结果
     */
    public int updateServiceProject(ServiceProject serviceProject);

    /**
     * 批量删除服务项目
     * 
     * @param ids 需要删除的服务项目主键集合
     * @return 结果
     */
    public int deleteServiceProjectByIds(Long[] ids);

    /**
     * 删除服务项目信息
     * 
     * @param id 服务项目主键
     * @return 结果
     */
    public int deleteServiceProjectById(Long id);
}
