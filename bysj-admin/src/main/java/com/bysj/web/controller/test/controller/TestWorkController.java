package com.bysj.web.controller.test.controller;

import com.bysj.common.annotation.Log;
import com.bysj.common.core.controller.BaseController;
import com.bysj.common.core.domain.AjaxResult;
import com.bysj.common.core.page.TableDataInfo;
import com.bysj.common.enums.BusinessType;
import com.bysj.common.utils.poi.ExcelUtil;
import com.bysj.framework.util.ShiroUtils;
import com.bysj.system.domain.SysUser;
import com.bysj.web.controller.mobile.domain.TMobile;
import com.bysj.web.controller.mobile.service.ITMobileService;
import com.bysj.web.controller.pkg.domain.TApk;
import com.bysj.web.controller.pkg.service.ITApkService;
import com.bysj.web.controller.userMobile.domain.TUserMobile;
import com.bysj.web.controller.userMobile.service.ITUserMobileService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 手机终端Controller
 * 
 * @author bysj
 * @date 2020-03-17
 */
@Controller
@RequestMapping("/system/test")
public class TestWorkController extends BaseController
{
    private String prefix = "test";

    @Autowired
    private ITMobileService tMobileService;

    @Autowired
    private ITApkService itApkService;

    @Autowired
    private ITUserMobileService userMobileService;

    @RequiresPermissions("system:test:view")
    @GetMapping()
    public String mobile(ModelMap modelMap)
        {

        modelMap.put("applicationList",itApkService.selectTApkList( new TApk()));
        SysUser sysUser = ShiroUtils.getSysUser();
        TUserMobile userMobile = new TUserMobile();
        userMobile.setUserId(Integer.valueOf(sysUser.getUserId().toString()));
        List<TUserMobile> userMobileList = userMobileService.selectTUserMobileList(userMobile);
        List<TMobile> mobileList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(userMobileList)){
         userMobileList.forEach(x ->{
             mobileList.add(tMobileService.selectTMobileById(x.getMobileId()));
         });
        }

        modelMap.put("mobileList",mobileList);
        return prefix + "/test";
    }

    /**
     * 查询手机终端列表
     */
    @RequiresPermissions("system:test:list")
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
