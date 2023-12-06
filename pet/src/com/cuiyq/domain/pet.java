package com.cuiyq.domain;

import java.util.Date;

/**
 * @author Cuiyq
 * @version 1.0
 * describe:
 */
public class pet {
    private Integer id; //宠物id
    private String name; //名字
    private Integer typeId;//宠物类型
    private Integer health; //是否健康
    private Integer love;//爱心指数
    private Date birthday; //出生日期
    private String ownerId; //宠物主人id
    private String storeId;//宠物所属商店id

    public pet() {
    }

    public pet(Integer id, String name, Integer typeId, Integer health, Integer love, Date birthday, String ownerId, String storeId) {
        this.id = id;
        this.name = name;
        this.typeId = typeId;
        this.health = health;
        this.love = love;
        this.birthday = birthday;
        this.ownerId = ownerId;
        this.storeId = storeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public Integer getLove() {
        return love;
    }

    public void setLove(Integer love) {
        this.love = love;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    @Override
    public String toString() {
        return "\npet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeId=" + typeId +
                ", health=" + health +
                ", love=" + love +
                ", birthday=" + birthday +
                ", ownerId='" + ownerId + '\'' +
                ", storeId='" + storeId + '\'' +
                '}';
    }
}
