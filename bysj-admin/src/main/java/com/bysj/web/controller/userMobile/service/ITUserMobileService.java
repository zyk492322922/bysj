package com.bysj.web.controller.userMobile.service;

import com.bysj.web.controller.userMobile.domain.TUserMobile;

import java.util.List;

/**
 * 用户和手机持有关联Service接口
 * 
 * @author bysj
 * @date 2020-03-17
 */
public interface ITUserMobileService 
{
    /**
     * 查询用户和手机持有关联
     * 
     * @param id 用户和手机持有关联ID
     * @return 用户和手机持有关联
     */
    public TUserMobile selectTUserMobileById(Integer id);

    /**
     * 查询用户和手机持有关联列表
     * 
     * @param tUserMobile 用户和手机持有关联
     * @return 用户和手机持有关联集合
     */
    public List<TUserMobile> selectTUserMobileList(TUserMobile tUserMobile);

    /**
     * 新增用户和手机持有关联
     * 
     * @param tUserMobile 用户和手机持有关联
     * @return 结果
     */
    public int insertTUserMobile(TUserMobile tUserMobile);

    /**
     * 修改用户和手机持有关联
     * 
     * @param tUserMobile 用户和手机持有关联
     * @return 结果
     */
    public int updateTUserMobile(TUserMobile tUserMobile);

    /**
     * 批量删除用户和手机持有关联
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteTUserMobileByIds(String ids);

    /**
     * 删除用户和手机持有关联信息
     * 
     * @param id 用户和手机持有关联ID
     * @return 结果
     */
    public int deleteTUserMobileById(Integer id);
}
