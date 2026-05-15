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
import com.xmyk.dentistservice.domain.DentistPlan;
import com.xmyk.dentistservice.service.IDentistPlanService;
import com.xmyk.common.utils.poi.ExcelUtil;
import com.xmyk.common.core.page.TableDataInfo;

/**
 * 牙科计划Controller
 * 
 * @author anlex
 * @date 2026-05-15
 */
@RestController
@RequestMapping("/dentistservice/plan")
public class DentistPlanController extends BaseController
{
    @Autowired
    private IDentistPlanService dentistPlanService;

    /**
     * 查询牙科计划列表
     */
    @PreAuthorize("@ss.hasPermi('dentistservice:plan:list')")
    @GetMapping("/list")
    public TableDataInfo list(DentistPlan dentistPlan)
    {
        startPage();
        List<DentistPlan> list = dentistPlanService.selectDentistPlanList(dentistPlan);
        return getDataTable(list);
    }

    /**
     * 导出牙科计划列表
     */
    @PreAuthorize("@ss.hasPermi('dentistservice:plan:export')")
    @Log(title = "牙科计划", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DentistPlan dentistPlan)
    {
        List<DentistPlan> list = dentistPlanService.selectDentistPlanList(dentistPlan);
        ExcelUtil<DentistPlan> util = new ExcelUtil<DentistPlan>(DentistPlan.class);
        util.exportExcel(response, list, "牙科计划数据");
    }

    /**
     * 获取牙科计划详细信息
     */
    @PreAuthorize("@ss.hasPermi('dentistservice:plan:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(dentistPlanService.selectDentistPlanById(id));
    }

    /**
     * 新增牙科计划
     */
    @PreAuthorize("@ss.hasPermi('dentistservice:plan:add')")
    @Log(title = "牙科计划", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DentistPlan dentistPlan)
    {
        return toAjax(dentistPlanService.insertDentistPlan(dentistPlan));
    }

    /**
     * 修改牙科计划
     */
    @PreAuthorize("@ss.hasPermi('dentistservice:plan:edit')")
    @Log(title = "牙科计划", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DentistPlan dentistPlan)
    {
        return toAjax(dentistPlanService.updateDentistPlan(dentistPlan));
    }

    /**
     * 删除牙科计划
     */
    @PreAuthorize("@ss.hasPermi('dentistservice:plan:remove')")
    @Log(title = "牙科计划", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dentistPlanService.deleteDentistPlanByIds(ids));
    }
}
