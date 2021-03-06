package com.bysj.web.controller.userMobile.controller;

import com.bysj.common.core.text.Convert;
import com.bysj.common.utils.CommonUtils;
import com.bysj.system.domain.SysUser;
import com.bysj.system.service.ISysUserService;
import com.bysj.web.controller.mobile.domain.TMobile;
import com.bysj.web.controller.mobile.service.ITMobileService;
import com.bysj.web.controller.userMobile.domain.TUserMobile;
import com.bysj.web.controller.userMobile.domain.TUserMobileDto;
import com.bysj.web.controller.userMobile.service.ITUserMobileService;
import org.springframework.stereotype.Controller;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.bysj.common.annotation.Log;
import com.bysj.common.enums.BusinessType;
import com.bysj.common.core.controller.BaseController;
import com.bysj.common.core.domain.AjaxResult;
import com.bysj.common.utils.poi.ExcelUtil;
import com.bysj.common.core.page.TableDataInfo;

/**
 * 用户和手机持有关联Controller
 * 
 * @author bysj
 * @date 2020-03-17
 */
@Controller
@RequestMapping("/system/userMobile")
public class TUserMobileController extends BaseController
{
    private String prefix = "userMobile";

    @Autowired
    private ISysUserService iSysUserService;

    @Autowired
    private ITMobileService itMobileService;

    @Autowired
    private ITUserMobileService tUserMobileService;

    @Autowired
    private ISysUserService sysUserService;

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
        List<TUserMobileDto> dtoList = CommonUtils.convertBeanList(list,TUserMobileDto.class);
        dtoList.forEach(x ->{
            x.setAssetCode(itMobileService.selectTMobileById(x.getMobileId()).getAssetCode());
            x.setUserName(sysUserService.selectUserById(Long.parseLong(String.valueOf(x.getUserId()))).getUserName());
        });
        return getDataTable(dtoList);
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
    public String add(Model model)
    {
        SysUser user = new SysUser();
        user.setStatus("0");
        model.addAttribute("userList",iSysUserService.selectUserList(user));
        TMobile mobile = new TMobile();
        mobile.setStatus("0");
        model.addAttribute("mobileList",itMobileService.selectTMobileList(mobile));
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
        tUserMobileService.insertTUserMobile(tUserMobile);
        TMobile mobile = new TMobile();
        mobile.setId(tUserMobile.getMobileId());
        mobile.setStatus("1");
        itMobileService.updateTMobile(mobile);
        return toAjax(1);
    }

    /**
     * 修改用户和手机持有关联
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id, ModelMap mmap)
    {
        TUserMobile tUserMobile = tUserMobileService.selectTUserMobileById(id);
        mmap.put("tUserMobile", tUserMobile);
        TMobile mobile = new TMobile();
        //mobile.setStatus("0");
        List<TMobile> mobileList = itMobileService.selectTMobileList(mobile);
        Iterator iterator = mobileList.iterator();
        while (iterator.hasNext()){
            mobile = (TMobile)iterator.next();
            // 未占用或者原来的数据保留，其他删除
            if (mobile.getStatus().equals("0") || mobile.getId().equals(tUserMobile.getMobileId())){
                mobile.setStatus("0");
            }else {
                iterator.remove();
            }
        }
        mmap.put("mobileList",mobileList);
        mmap.put("mobileId",tUserMobile.getMobileId());
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
        // 判断新得mobileId和原来mobileId是否一致， 否则，原来mobileId状态改为未占用,新的改为占用
        TUserMobile origin = tUserMobileService.selectTUserMobileById(tUserMobile.getId());
        if (!origin.getMobileId().equals(tUserMobile.getMobileId())){
            TMobile mobile = new TMobile();
            mobile.setId(origin.getMobileId());
            mobile.setStatus("0");
            itMobileService.updateTMobile(mobile);

            mobile = new TMobile();
            mobile.setId(tUserMobile.getMobileId());
            mobile.setStatus("1");
            itMobileService.updateTMobile(mobile);
        }
        tUserMobileService.updateTUserMobile(tUserMobile);


        return toAjax(1);
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
        // 对应手机重置成未占用状态
        List idList = Arrays.asList(Convert.toStrArray(ids));
        idList.forEach(x->{
            TMobile mobile = new TMobile();
            mobile.setId(tUserMobileService.selectTUserMobileById(Integer.valueOf(x.toString())).getMobileId());
            mobile.setStatus("0");
            itMobileService.updateTMobile(mobile);
        });
        tUserMobileService.deleteTUserMobileByIds(ids);
        return toAjax(1);
    }
}
