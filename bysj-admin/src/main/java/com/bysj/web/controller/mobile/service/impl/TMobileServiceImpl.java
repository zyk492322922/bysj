package com.bysj.web.controller.mobile.service.impl;

import java.util.List;

import com.bysj.web.controller.mobile.domain.TMobile;
import com.bysj.web.controller.mobile.mapper.TMobileMapper;
import com.bysj.web.controller.mobile.service.ITMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bysj.common.core.text.Convert;

/**
 * 手机终端Service业务层处理
 * 
 * @author bysj
 * @date 2020-03-17
 */
@Service
public class TMobileServiceImpl implements ITMobileService
{
    @Autowired
    private TMobileMapper tMobileMapper;

    /**
     * 查询手机终端
     * 
     * @param id 手机终端ID
     * @return 手机终端
     */
    @Override
    public TMobile selectTMobileById(Integer id)
    {
        return tMobileMapper.selectTMobileById(id);
    }

    /**
     * 查询手机终端列表
     * 
     * @param tMobile 手机终端
     * @return 手机终端
     */
    @Override
    public List<TMobile> selectTMobileList(TMobile tMobile)
    {
        return tMobileMapper.selectTMobileList(tMobile);
    }

    /**
     * 新增手机终端
     * 
     * @param tMobile 手机终端
     * @return 结果
     */
    @Override
    public int insertTMobile(TMobile tMobile)
    {
        return tMobileMapper.insertTMobile(tMobile);
    }

    /**
     * 修改手机终端
     * 
     * @param tMobile 手机终端
     * @return 结果
     */
    @Override
    public int updateTMobile(TMobile tMobile)
    {
        return tMobileMapper.updateTMobile(tMobile);
    }

    /**
     * 删除手机终端对象
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteTMobileByIds(String ids)
    {
        return tMobileMapper.deleteTMobileByIds(Convert.toStrArray(ids));
    }

    /**
     * 删除手机终端信息
     * 
     * @param id 手机终端ID
     * @return 结果
     */
    @Override
    public int deleteTMobileById(Integer id)
    {
        return tMobileMapper.deleteTMobileById(id);
    }
}
