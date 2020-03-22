package com.bysj.web.controller.pkg.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.bysj.common.annotation.Excel;
import com.bysj.common.core.domain.BaseEntity;

/**
 * apk包管理对象 t_apk
 * 
 * @author bysj
 * @date 2020-03-19
 */
public class TApk extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Long id;

    /** 应用名 */
    @Excel(name = "应用名")
    private String applicationName;

    /** 包名 */
    @Excel(name = "包名")
    private String packageName;

    /** 包路径 */
    @Excel(name = "包路径")
    private String packagePath;

    /** 下载路径 */
    private String downloadPath;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setApplicationName(String applicationName) 
    {
        this.applicationName = applicationName;
    }

    public String getApplicationName() 
    {
        return applicationName;
    }
    public void setPackageName(String packageName) 
    {
        this.packageName = packageName;
    }

    public String getPackageName() 
    {
        return packageName;
    }
    public void setPackagePath(String packagePath) 
    {
        this.packagePath = packagePath;
    }

    public String getPackagePath() 
    {
        return packagePath;
    }
    public void setDownloadPath(String downloadPath) 
    {
        this.downloadPath = downloadPath;
    }

    public String getDownloadPath() 
    {
        return downloadPath;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("applicationName", getApplicationName())
            .append("packageName", getPackageName())
            .append("packagePath", getPackagePath())
            .append("downloadPath", getDownloadPath())
            .toString();
    }
}
