package com.xmyk.dentistservice.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.xmyk.common.core.domain.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.xmyk.common.annotation.Log;
import com.xmyk.common.core.controller.BaseController;
import com.xmyk.common.core.domain.AjaxResult;
import com.xmyk.common.enums.BusinessType;
import com.xmyk.dentistservice.domain.ServiceProject;
import com.xmyk.dentistservice.service.IServiceProjectService;
import com.xmyk.common.utils.poi.ExcelUtil;
import com.xmyk.common.core.page.TableDataInfo;

/**
 * 服务项目Controller
 * 
 * @author anlex
 * @date 2026-05-16
 */
@Api("服务项目管理")
@RestController
@RequestMapping("/dentistservice/project")
public class ServiceProjectController extends BaseController
{
    @Autowired
    private IServiceProjectService serviceProjectService;

    /**
     * 查询服务项目列表
     */
    @ApiOperation("查询服务项目列表")
    @PreAuthorize("@ss.hasPermi('dentistservice:project:list')")
    @GetMapping("/list")
    public TableDataInfo<List<ServiceProject>> list(@ApiParam("查询条件对象") ServiceProject serviceProject)
    {
        startPage();
        List<ServiceProject> list = serviceProjectService.selectServiceProjectList(serviceProject);
        return getDataTable(list);
    }

    /**
     * 导出服务项目列表
     */
    @ApiOperation("导出服务项目列表")
    @PreAuthorize("@ss.hasPermi('dentistservice:project:export')")
    @Log(title = "服务项目", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(@ApiParam("导出条件对象") HttpServletResponse response, ServiceProject serviceProject)
    {
        List<ServiceProject> list = serviceProjectService.selectServiceProjectList(serviceProject);
        ExcelUtil<ServiceProject> util = new ExcelUtil<ServiceProject>(ServiceProject.class);
        util.exportExcel(response, list, "服务项目数据");
    }

    /**
     * 获取服务项目详细信息
     */
    @ApiOperation("获取服务项目详细信息")
    @PreAuthorize("@ss.hasPermi('dentistservice:project:query')")
    @GetMapping(value = "/{id}")
    public R<ServiceProject> getInfo(@PathVariable("id") @ApiParam("服务项目ID") Long id)
    {
        return R.ok(serviceProjectService.selectServiceProjectById(id));
    }

    /**
     * 新增服务项目
     */
    @ApiOperation("新增服务项目")
    @PreAuthorize("@ss.hasPermi('dentistservice:project:add')")
    @Log(title = "服务项目", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @ApiParam("新增条件对象") ServiceProject serviceProject)
    {
        return toAjax(serviceProjectService.insertServiceProject(serviceProject));
    }

    /**
     * 修改服务项目
     */
    @ApiOperation("修改服务项目")
    @PreAuthorize("@ss.hasPermi('dentistservice:project:edit')")
    @Log(title = "服务项目", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody @ApiParam("修改条件对象") ServiceProject serviceProject)
    {
        return toAjax(serviceProjectService.updateServiceProject(serviceProject));
    }

    /**
     * 删除服务项目
     */
    @ApiOperation("删除服务项目")
    @PreAuthorize("@ss.hasPermi('dentistservice:project:remove')")
    @Log(title = "服务项目", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable @ApiParam("删除条件对象") Long[] ids)
    {
        return toAjax(serviceProjectService.deleteServiceProjectByIds(ids));
    }
}
