package com.ruoyi.web.controller.mobile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 手机终端对象 t_mobile
 * 
 * @author ruoyi
 * @date 2020-03-17
 */
public class TMobile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Integer id;

    /** 资产编号 */
    @Excel(name = "资产编号")
    private String assetCode;

    /** 设备识别码 */
    @Excel(name = "设备识别码")
    private String imei;

    /** 设备型号 */
    @Excel(name = "设备型号")
    private String type;

    /** 0: 未删除 1：已删除 */
    private String delFlag;

    /** 0: 未占用；1：已占用 */
    @Excel(name = "0: 未占用；1：已占用")
    private String status;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setAssetCode(String assetCode) 
    {
        this.assetCode = assetCode;
    }

    public String getAssetCode() 
    {
        return assetCode;
    }
    public void setImei(String imei) 
    {
        this.imei = imei;
    }

    public String getImei() 
    {
        return imei;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("assetCode", getAssetCode())
            .append("imei", getImei())
            .append("type", getType())
            .append("delFlag", getDelFlag())
            .append("status", getStatus())
            .toString();
    }
}
