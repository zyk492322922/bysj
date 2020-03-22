package com.bysj.web.controller.mobile.service;

import com.bysj.web.controller.mobile.domain.TMobile;

import java.util.List;

/**
 * 手机终端Service接口
 * 
 * @author bysj
 * @date 2020-03-17
 */
public interface ITMobileService 
{
    /**
     * 查询手机终端
     * 
     * @param id 手机终端ID
     * @return 手机终端
     */
    public TMobile selectTMobileById(Integer id);

    /**
     * 查询手机终端列表
     * 
     * @param tMobile 手机终端
     * @return 手机终端集合
     */
    public List<TMobile> selectTMobileList(TMobile tMobile);

    /**
     * 新增手机终端
     * 
     * @param tMobile 手机终端
     * @return 结果
     */
    public int insertTMobile(TMobile tMobile);

    /**
     * 修改手机终端
     * 
     * @param tMobile 手机终端
     * @return 结果
     */
    public int updateTMobile(TMobile tMobile);

    /**
     * 批量删除手机终端
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTMobileByIds(String ids);

    /**
     * 删除手机终端信息
     * 
     * @param id 手机终端ID
     * @return 结果
     */
    public int deleteTMobileById(Integer id);
}
