package com.cuiyq.interface_;

/**
 * 接口多肽数组
 */
public class InterfacePolyArr {
    public static void main(String[] args) {
        Usb[] usbs = new Usb[2];
        usbs[0] = new Camera_();
        usbs[1] = new Phone_();

        for (int i = 0; i < usbs.length; i++) {
            usbs[i].work();

            //如果是phone就输出call方法
            if (usbs[i] instanceof Phone_) {
                ((Phone_) usbs[i]).call();
            }
        }
    }
}

interface Usb {
    void work();
}

class Camera_ implements Usb {

    @Override
    public void work() {
        System.out.println("相机正在工作中");
    }
}

class Phone_ implements Usb {
    @Override
    public void work() {
        System.out.println("手机正在工作中");
    }

    public void call() {
        System.out.println("手机正在打电话。。。");
    }
}

