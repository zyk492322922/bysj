package com.ruoyi.web.controller.pkg.service.impl;

import java.util.List;

import com.ruoyi.web.controller.pkg.domain.TApk;
import com.ruoyi.web.controller.pkg.mapper.TApkMapper;
import com.ruoyi.web.controller.pkg.service.ITApkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * apk包管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-19
 */
@Service
public class TApkServiceImpl implements ITApkService
{
    @Autowired
    private TApkMapper tApkMapper;

    /**
     * 查询apk包管理
     * 
     * @param id apk包管理ID
     * @return apk包管理
     */
    @Override
    public TApk selectTApkById(Long id)
    {
        return tApkMapper.selectTApkById(id);
    }

    /**
     * 查询apk包管理列表
     * 
     * @param tApk apk包管理
     * @return apk包管理
     */
    @Override
    public List<TApk> selectTApkList(TApk tApk)
    {
        return tApkMapper.selectTApkList(tApk);
    }

    /**
     * 新增apk包管理
     * 
     * @param tApk apk包管理
     * @return 结果
     */
    @Override
    public int insertTApk(TApk tApk)
    {
        return tApkMapper.insertTApk(tApk);
    }

    /**
     * 修改apk包管理
     * 
     * @param tApk apk包管理
     * @return 结果
     */
    @Override
    public int updateTApk(TApk tApk)
    {
        return tApkMapper.updateTApk(tApk);
    }

    /**
     * 删除apk包管理对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTApkByIds(String ids)
    {
        return tApkMapper.deleteTApkByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除apk包管理信息
     * 
     * @param id apk包管理ID
     * @return 结果
     */
    @Override
    public int deleteTApkById(Long id)
    {
        return tApkMapper.deleteTApkById(id);
    }
}
