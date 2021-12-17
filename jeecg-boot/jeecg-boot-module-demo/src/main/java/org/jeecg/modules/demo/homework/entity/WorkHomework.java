package org.jeecg.modules.demo.homework.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import org.jeecgframework.poi.excel.annotation.Excel;
import org.jeecg.common.aspect.annotation.Dict;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @Description: 测试表
 * @Author: jeecg-boot
 * @Date:   2021-12-15
 * @Version: V1.0
 */
@Data
@TableName("work_homework")
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="work_homework对象", description="测试表")
public class WorkHomework implements Serializable {
    private static final long serialVersionUID = 1L;

	/**主键*/
	@TableId(type = IdType.ASSIGN_ID)
    @ApiModelProperty(value = "主键")
    private java.lang.String id;
	/**创建人*/
    @ApiModelProperty(value = "创建人")
    private java.lang.String createBy;
	/**创建日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建日期")
    private java.util.Date createTime;
	/**更新人*/
    @ApiModelProperty(value = "更新人")
    private java.lang.String updateBy;
	/**更新日期*/
	@JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新日期")
    private java.util.Date updateTime;
	/**所属部门*/
    @ApiModelProperty(value = "所属部门")
    private java.lang.String sysOrgCode;
	/**路线名称*/
	@Excel(name = "路线名称", width = 15)
    @ApiModelProperty(value = "路线名称")
    private java.lang.String rdName;
	/**路线代码*/
	@Excel(name = "路线代码", width = 15)
    @ApiModelProperty(value = "路线代码")
    private java.lang.String rdCode;
	/**路线类型*/
	@Excel(name = "路线类型", width = 15)
    @ApiModelProperty(value = "路线类型")
    private java.lang.String rdType;
	/**线宽*/
	@Excel(name = "线宽", width = 15)
    @ApiModelProperty(value = "线宽")
    private java.lang.String rdWidth;
	/**连接方式*/
	@Excel(name = "连接方式", width = 15, dicCode = "msg_category")
	@Dict(dicCode = "msg_category")
    @ApiModelProperty(value = "连接方式")
    private java.lang.String rdConnect;
	/**路线颜色*/
	@Excel(name = "路线颜色", width = 15)
    @ApiModelProperty(value = "路线颜色")
    private java.lang.String rdColor;
	/**上传附件*/
	@Excel(name = "上传附件", width = 15)
    @ApiModelProperty(value = "上传附件")
    private java.lang.String rdFile;
	/**备注*/
	@Excel(name = "备注", width = 15)
    @ApiModelProperty(value = "备注")
    private java.lang.String rdRemark;
}
