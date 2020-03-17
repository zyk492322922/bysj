package com.ruoyi.web.controller.mobile.controller;

import java.util.List;

import com.ruoyi.web.controller.mobile.domain.TMobile;
import com.ruoyi.web.controller.mobile.service.ITMobileService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 手机终端Controller
 * 
 * @author ruoyi
 * @date 2020-03-17
 */
@Controller
@RequestMapping("/system/mobile")
public class TMobileController extends BaseController
{
    private String prefix = "mobile";

    @Autowired
    private ITMobileService tMobileService;

    @RequiresPermissions("system:mobile:view")
    @GetMapping()
    public String mobile()
    {
        return prefix + "/mobile";
    }

    /**
     * 查询手机终端列表
     */
    @RequiresPermissions("system:mobile:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TMobile tMobile)
    {
        startPage();
        List<TMobile> list = tMobileService.selectTMobileList(tMobile);
        return getDataTable(list);
    }

    /**
     * 导出手机终端列表
     */
    @RequiresPermissions("system:mobile:export")
    @Log(title = "手机终端", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TMobile tMobile)
    {
        List<TMobile> list = tMobileService.selectTMobileList(tMobile);
        ExcelUtil<TMobile> util = new ExcelUtil<TMobile>(TMobile.class);
        return util.exportExcel(list, "mobile");
    }

    /**
     * 新增手机终端
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存手机终端
     */
    @RequiresPermissions("system:mobile:add")
    @Log(title = "手机终端", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TMobile tMobile)
    {
        return toAjax(tMobileService.insertTMobile(tMobile));
    }

    /**
     * 修改手机终端
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        TMobile tMobile = tMobileService.selectTMobileById(id);
        mmap.put("tMobile", tMobile);
        return prefix + "/edit";
    }

    /**
     * 修改保存手机终端
     */
    @RequiresPermissions("system:mobile:edit")
    @Log(title = "手机终端", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TMobile tMobile)
    {
        return toAjax(tMobileService.updateTMobile(tMobile));
    }

    /**
     * 删除手机终端
     */
    @RequiresPermissions("system:mobile:remove")
    @Log(title = "手机终端", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tMobileService.deleteTMobileByIds(ids));
    }
}
