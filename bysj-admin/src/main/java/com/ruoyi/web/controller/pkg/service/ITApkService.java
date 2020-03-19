package com.ruoyi.web.controller.pkg.service;

import com.ruoyi.web.controller.pkg.domain.TApk;

import java.util.List;

/**
 * apk包管理Service接口
 * 
 * @author ruoyi
 * @date 2020-03-19
 */
public interface ITApkService 
{
    /**
     * 查询apk包管理
     * 
     * @param id apk包管理ID
     * @return apk包管理
     */
    public TApk selectTApkById(Long id);

    /**
     * 查询apk包管理列表
     * 
     * @param tApk apk包管理
     * @return apk包管理集合
     */
    public List<TApk> selectTApkList(TApk tApk);

    /**
     * 新增apk包管理
     * 
     * @param tApk apk包管理
     * @return 结果
     */
    public int insertTApk(TApk tApk);

    /**
     * 修改apk包管理
     * 
     * @param tApk apk包管理
     * @return 结果
     */
    public int updateTApk(TApk tApk);

    /**
     * 批量删除apk包管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTApkByIds(String ids);

    /**
     * 删除apk包管理信息
     * 
     * @param id apk包管理ID
     * @return 结果
     */
    public int deleteTApkById(Long id);
}
