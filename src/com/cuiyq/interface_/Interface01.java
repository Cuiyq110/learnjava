package com.cuiyq.interface_;

public class Interface01 {

    public static void main(String[] args) {
        //手机
        Phone phone = new Phone();
        Camera camera = new Camera();

        Computer computer = new Computer();
        computer.work(phone);
        System.out.println("======");
        computer.work(camera);
    }
}


interface UsbInterface {
    //人为规定方法
    public void start();
    public void end();
}

class Camera implements UsbInterface {

    @Override
    public void start() {
        System.out.println("相机开始工作");
    }

    @Override
    public void end() {
        System.out.println("相机结束工作");
    }
}

class Phone implements UsbInterface {

    @Override
    public void start() {
        System.out.println("手机开始工作");
    }

    @Override
    public void end() {
        System.out.println("手机结束工作");
    }
}

class Computer{
    public void work(UsbInterface usbInterface){
        usbInterface.start();
        usbInterface.end();
    }
}

