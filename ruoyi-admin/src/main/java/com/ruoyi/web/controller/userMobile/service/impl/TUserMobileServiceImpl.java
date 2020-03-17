package com.ruoyi.web.controller.userMobile.service.impl;

import java.util.List;

import com.ruoyi.web.controller.userMobile.domain.TUserMobile;
import com.ruoyi.web.controller.userMobile.mapper.TUserMobileMapper;
import com.ruoyi.web.controller.userMobile.service.ITUserMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.common.core.text.Convert;

/**
 * 用户和手机持有关联Service业务层处理
 * 
 * @author ruoyi
 * @date 2020-03-17
 */
@Service
public class TUserMobileServiceImpl implements ITUserMobileService
{
    @Autowired
    private TUserMobileMapper tUserMobileMapper;

    /**
     * 查询用户和手机持有关联
     * 
     * @param id 用户和手机持有关联ID
     * @return 用户和手机持有关联
     */
    @Override
    public TUserMobile selectTUserMobileById(Integer id)
    {
        return tUserMobileMapper.selectTUserMobileById(id);
    }

    /**
     * 查询用户和手机持有关联列表
     * 
     * @param tUserMobile 用户和手机持有关联
     * @return 用户和手机持有关联
     */
    @Override
    public List<TUserMobile> selectTUserMobileList(TUserMobile tUserMobile)
    {
        return tUserMobileMapper.selectTUserMobileList(tUserMobile);
    }

    /**
     * 新增用户和手机持有关联
     * 
     * @param tUserMobile 用户和手机持有关联
     * @return 结果
     */
    @Override
    public int insertTUserMobile(TUserMobile tUserMobile)
    {
        return tUserMobileMapper.insertTUserMobile(tUserMobile);
    }

    /**
     * 修改用户和手机持有关联
     * 
     * @param tUserMobile 用户和手机持有关联
     * @return 结果
     */
    @Override
    public int updateTUserMobile(TUserMobile tUserMobile)
    {
        return tUserMobileMapper.updateTUserMobile(tUserMobile);
    }

    /**
     * 删除用户和手机持有关联对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTUserMobileByIds(String ids)
    {
        return tUserMobileMapper.deleteTUserMobileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除用户和手机持有关联信息
     * 
     * @param id 用户和手机持有关联ID
     * @return 结果
     */
    @Override
    public int deleteTUserMobileById(Integer id)
    {
        return tUserMobileMapper.deleteTUserMobileById(id);
    }
}
