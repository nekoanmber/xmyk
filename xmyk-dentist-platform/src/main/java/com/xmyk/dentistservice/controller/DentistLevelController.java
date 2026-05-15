package com.xmyk.dentistservice.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
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
    public TableDataInfo list(DentistLevel dentistLevel)
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
    public void export(HttpServletResponse response, DentistLevel dentistLevel)
    {
        List<DentistLevel> list = dentistLevelService.selectDentistLevelList(dentistLevel);
        ExcelUtil<DentistLevel> util = new ExcelUtil<DentistLevel>(DentistLevel.class);
        util.exportExcel(response, list, "牙科等级数据");
    }

    /**
     * 获取牙科等级详细信息
     */
    @PreAuthorize("@ss.hasPermi('dentistservice:level:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dentistLevelService.selectDentistLevelById(id));
    }

    /**
     * 新增牙科等级
     */
    @PreAuthorize("@ss.hasPermi('dentistservice:level:add')")
    @Log(title = "牙科等级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DentistLevel dentistLevel)
    {
        return toAjax(dentistLevelService.insertDentistLevel(dentistLevel));
    }

    /**
     * 修改牙科等级
     */
    @PreAuthorize("@ss.hasPermi('dentistservice:level:edit')")
    @Log(title = "牙科等级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DentistLevel dentistLevel)
    {
        return toAjax(dentistLevelService.updateDentistLevel(dentistLevel));
    }

    /**
     * 删除牙科等级
     */
    @PreAuthorize("@ss.hasPermi('dentistservice:level:remove')")
    @Log(title = "牙科等级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dentistLevelService.deleteDentistLevelByIds(ids));
    }
}
