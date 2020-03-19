package com.ruoyi.web.controller.userMobile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户和手机持有关联对象 t_user_mobile
 * 
 * @author ruoyi
 * @date 2020-03-17
 */
public class TUserMobile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Integer id;

    /** 用户id */
    @Excel(name = "用户id")
    private Integer userId;

    /** 手机id */
    @Excel(name = "手机id")
    private Integer mobileId;

    /** 服务器ip */
    @Excel(name = "服务器ip")
    private String serverIp;

    /** 用途 */
    @Excel(name = "用途")
    private String usedWay;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setUserId(Integer userId) 
    {
        this.userId = userId;
    }

    public Integer getUserId() 
    {
        return userId;
    }
    public void setMobileId(Integer mobileId) 
    {
        this.mobileId = mobileId;
    }

    public Integer getMobileId() 
    {
        return mobileId;
    }
    public void setServerIp(String serverIp) 
    {
        this.serverIp = serverIp;
    }

    public String getServerIp() 
    {
        return serverIp;
    }
    public void setUsedWay(String usedWay) 
    {
        this.usedWay = usedWay;
    }

    public String getUsedWay() 
    {
        return usedWay;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("mobileId", getMobileId())
            .append("serverIp", getServerIp())
            .append("usedWay", getUsedWay())
            .toString();
    }
}
