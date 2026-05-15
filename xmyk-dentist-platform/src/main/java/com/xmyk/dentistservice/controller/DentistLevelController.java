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
import com.xmyk.dentistservice.domain.DentistLevel;
import com.xmyk.dentistservice.service.IDentistLevelService;
import com.xmyk.common.utils.poi.ExcelUtil;
import com.xmyk.common.core.page.TableDataInfo;

/**
 * 牙科等级Controller
 * 
 * @author anlex
 * @date 2026-05-15
 */
@Api("牙科等级管理")
@RestController
@RequestMapping("/dentistservice/level")
public class DentistLevelController extends BaseController
{
    @Autowired
    private IDentistLevelService dentistLevelService;

    /**
     * 查询牙科等级列表
     */
    @PreAuthorize("@ss.hasPermi('dentistservice:level:list')")
    @GetMapping("/list")
    @ApiOperation("获取牙科等级列表")
    public TableDataInfo<List<DentistLevel>> list(@ApiParam("查询参数") DentistLevel dentistLevel)
    {
        startPage();
        List<DentistLevel> list = dentistLevelService.selectDentistLevelList(dentistLevel);
        return getDataTable(list);
    }

    /**
     * 导出牙科等级列表
     */
    @PreAuthorize("@ss.hasPermi('dentistservice:level:export')")
    @Log(title = "牙科等级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ApiOperation("导出牙科等级列表")
    public void export(@ApiParam("响应对象") HttpServletResponse response,@ApiParam("查询参数") DentistLevel dentistLevel)
    {
        List<DentistLevel> list = dentistLevelService.selectDentistLevelList(dentistLevel);
        ExcelUtil<DentistLevel> util = new ExcelUtil<DentistLevel>(DentistLevel.class);
        util.exportExcel(response, list, "牙科等级数据");
    }

    /**
     * 获取牙科等级详细信息
     */
    @ApiOperation("获取牙科等级详细信息")
    @PreAuthorize("@ss.hasPermi('dentistservice:level:query')")
    @GetMapping(value = "/{id}")
    public R<DentistLevel> getInfo(@PathVariable("id") @ApiParam("等级id") Long id)
    {
        return R.ok(dentistLevelService.selectDentistLevelById(id));
    }

    /**
     * 新增牙科等级
     */
    @ApiOperation("新增牙科等级")
    @PreAuthorize("@ss.hasPermi('dentistservice:level:add')")
    @Log(title = "牙科等级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody @ApiParam("新增的等级对象") DentistLevel dentistLevel)
    {
        return toAjax(dentistLevelService.insertDentistLevel(dentistLevel));
    }

    /**
     * 修改牙科等级
     */
    @ApiOperation("修改牙科等级")
    @PreAuthorize("@ss.hasPermi('dentistservice:level:edit')")
    @Log(title = "牙科等级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody @ApiParam("修改后的等级对象") DentistLevel dentistLevel)
    {
        return toAjax(dentistLevelService.updateDentistLevel(dentistLevel));
    }

    /**
     * 删除牙科等级
     */
    @ApiOperation("删除牙科等级")
    @PreAuthorize("@ss.hasPermi('dentistservice:level:remove')")
    @Log(title = "牙科等级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable @ApiParam("要删除的等级id数组") Long[] ids)
    {
        return toAjax(dentistLevelService.deleteDentistLevelByIds(ids));
    }
}
