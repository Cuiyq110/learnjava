package com.cuiyq.domain;

import java.util.Date;

/**
 * @author Cuiyq
 * @version 1.0
 * describe：多表联查
 */
public class MultiTableBean {
    private Integer id;
    private String billId;
    private Integer menuId;
    private Integer nums;
    private Double money;
    private Integer DingingTableId;
    private Date billDate;
    private String state;

    private String name;
    private Double price;

    public MultiTableBean() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBillId() {
        return billId;
    }

    public void setBillId(String billId) {
        this.billId = billId;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getDingingTableId() {
        return DingingTableId;
    }

    public void setDingingTableId(Integer dingingTableId) {
        DingingTableId = dingingTableId;
    }

    public Date getBillDate() {
        return billDate;
    }

    public void setBillDate(Date billDate) {
        this.billDate = billDate;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return  id +
                "\t\t\t" + menuId +
                "\t\t\t" + nums +
                "\t\t\t" + money +
                "\t\t" + DingingTableId +
                "\t\t" + billDate +
                "\t\t" + state +
                "\t\t" + name +
                "\t\t" + price;
    }
}
