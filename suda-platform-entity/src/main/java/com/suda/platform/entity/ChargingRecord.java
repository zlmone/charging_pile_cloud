package com.suda.platform.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.suda.platform.format.CustomBigDecimalSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 充电记录
 * </p>
 *
 * @author kongling
 * @since 2019-05-30
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ChargingRecord对象", description="充电记录")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChargingRecord extends Model<ChargingRecord> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "充电用户id")
    @TableField("stock_user_id")
    private Long stockUserId;

    @ApiModelProperty(value = "充电站id")
    @TableField("charging_stations_id")
    private Long chargingStationsId;

    @ApiModelProperty(value = "充电桩id")
    @TableField("charging_pile_info_id")
    private Long chargingPileInfoId;

    @ApiModelProperty(value = "省")
    @TableField("province")
    private String province;

    @ApiModelProperty(value = "市")
    @TableField("city")
    private String city;

    @ApiModelProperty(value = "县")
    @TableField("county")
    private String county;

    @ApiModelProperty(value = "详细地点")
    @TableField("address")
    private String address;

    @ApiModelProperty(value = "价格单位元")
    @TableField("price")
    @JsonSerialize(using = CustomBigDecimalSerializer.class)
    private BigDecimal price;

    @ApiModelProperty(value = "服务费 价格单位元度")
    @TableField("service_charge")
    @JsonSerialize(using = CustomBigDecimalSerializer.class)
    private BigDecimal serviceCharge;

    @ApiModelProperty(value = "创建时间")
    @TableField("create_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @TableField("timestamp")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date timestamp;

    @ApiModelProperty(value = "充电开始时间")
    @TableField("charge_start_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date chargeStartTime;

    @ApiModelProperty(value = "充电结束时间")
    @TableField("charge_end_time")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date chargeEndTime;

    @ApiModelProperty(value = "充电总金额")
    @TableField("charge_total_money")
    @JsonSerialize(using = CustomBigDecimalSerializer.class)
    private BigDecimal chargeTotalMoney;

    @ApiModelProperty(value = "充电总度数")
    @TableField("charge_num")
    @JsonSerialize(using = CustomBigDecimalSerializer.class)
    private BigDecimal chargeNum;

    @ApiModelProperty(value = "付款状态（0 false:未付款 1 true:已付款）")
    @TableField("payment_status")
    private Boolean paymentStatus;


    @ApiModelProperty(value = "充电状态 0:未充电 1:充电中 2:充电结束")
    @TableField("charge_status")
    private Integer chargeStatus;




    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
