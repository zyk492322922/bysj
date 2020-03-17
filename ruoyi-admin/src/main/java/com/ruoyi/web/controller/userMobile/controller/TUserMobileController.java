package com.ruoyi.web.controller.userMobile.controller;

import com.ruoyi.web.controller.userMobile.domain.TUserMobile;
import com.ruoyi.web.controller.userMobile.service.ITUserMobileService;
import org.springframework.stereotype.Controller;


import java.util.List;
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
 * 用户和手机持有关联Controller
 * 
 * @author ruoyi
 * @date 2020-03-17
 */
@Controller
@RequestMapping("/system/userMobile")
public class TUserMobileController extends BaseController
{
    private String prefix = "/userMobile";

    @Autowired
    private ITUserMobileService tUserMobileService;

    @RequiresPermissions("system:userMobile:view")
    @GetMapping()
    public String userMobile()
    {
        return prefix + "/userMobile";
    }

    /**
     * 查询用户和手机持有关联列表
     */
    @RequiresPermissions("system:userMobile:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(TUserMobile tUserMobile)
    {
        startPage();
        List<TUserMobile> list = tUserMobileService.selectTUserMobileList(tUserMobile);
        return getDataTable(list);
    }

    /**
     * 导出用户和手机持有关联列表
     */
    @RequiresPermissions("system:userMobile:export")
    @Log(title = "用户和手机持有关联", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(TUserMobile tUserMobile)
    {
        List<TUserMobile> list = tUserMobileService.selectTUserMobileList(tUserMobile);
        ExcelUtil<TUserMobile> util = new ExcelUtil<TUserMobile>(TUserMobile.class);
        return util.exportExcel(list, "userMobile");
    }

    /**
     * 新增用户和手机持有关联
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存用户和手机持有关联
     */
    @RequiresPermissions("system:userMobile:add")
    @Log(title = "用户和手机持有关联", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(TUserMobile tUserMobile)
    {
        return toAjax(tUserMobileService.insertTUserMobile(tUserMobile));
    }

    /**
     * 修改用户和手机持有关联
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        TUserMobile tUserMobile = tUserMobileService.selectTUserMobileById(id);
        mmap.put("tUserMobile", tUserMobile);
        return prefix + "/edit";
    }

    /**
     * 修改保存用户和手机持有关联
     */
    @RequiresPermissions("system:userMobile:edit")
    @Log(title = "用户和手机持有关联", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(TUserMobile tUserMobile)
    {
        return toAjax(tUserMobileService.updateTUserMobile(tUserMobile));
    }

    /**
     * 删除用户和手机持有关联
     */
    @RequiresPermissions("system:userMobile:remove")
    @Log(title = "用户和手机持有关联", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(tUserMobileService.deleteTUserMobileByIds(ids));
    }
}
