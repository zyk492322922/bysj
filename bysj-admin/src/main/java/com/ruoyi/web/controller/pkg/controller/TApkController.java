package com.ruoyi.web.controller.pkg.controller;

import java.util.List;

import com.ruoyi.web.controller.pkg.domain.TApk;
import com.ruoyi.web.controller.pkg.service.ITApkService;
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
 * apk包管理Controller
 * 
 * @author ruoyi
 * @date 2020-03-19
 */
@Controller
@RequestMapping("/system/apk")
public class TApkController extends BaseController
{
    private String prefix = "apk";

    @Autowired
    private ITApkService tApkService;

    @RequiresPermissions("system:apk:view")
    @GetMapping()
    public String apk()
    {
        return prefix + "/apk";
    }

    /**
     * 查询apk包管理列表
     */
    @RequiresPermissions("system:apk:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TApk tApk)
    {
        startPage();
        List<TApk> list = tApkService.selectTApkList(tApk);
        return getDataTable(list);
    }

    /**
     * 导出apk包管理列表
     */
    @RequiresPermissions("system:apk:export")
    @Log(title = "apk包管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TApk tApk)
    {
        List<TApk> list = tApkService.selectTApkList(tApk);
        ExcelUtil<TApk> util = new ExcelUtil<TApk>(TApk.class);
        return util.exportExcel(list, "apk");
    }

    /**
     * 新增apk包管理
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存apk包管理
     */
    @RequiresPermissions("system:apk:add")
    @Log(title = "apk包管理", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TApk tApk)
    {
        return toAjax(tApkService.insertTApk(tApk));
    }

    /**
     * 修改apk包管理
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Long id, ModelMap mmap)
    {
        TApk tApk = tApkService.selectTApkById(id);
        mmap.put("tApk", tApk);
        return prefix + "/edit";
    }

    /**
     * 修改保存apk包管理
     */
    @RequiresPermissions("system:apk:edit")
    @Log(title = "apk包管理", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TApk tApk)
    {
        return toAjax(tApkService.updateTApk(tApk));
    }

    /**
     * 删除apk包管理
     */
    @RequiresPermissions("system:apk:remove")
    @Log(title = "apk包管理", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tApkService.deleteTApkByIds(ids));
    }
}
