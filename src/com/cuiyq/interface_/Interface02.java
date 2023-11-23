package com.cuiyq.interface_;

public class Interface02 {
    public static void main(String[] args) {
        MysqlDB mysqlDB = new MysqlDB();
        Interface02.t(mysqlDB);
        System.out.println("========");
        OracleDB oracleDB = new OracleDB();
        Interface02.t(oracleDB);

    }

    public static void t(DBinterface dBinterface) {
        dBinterface.connect();
        dBinterface.close();
    }
}

interface DBinterface {
    void connect();

    void close();
}

class MysqlDB implements DBinterface {

    @Override
    public void connect() {
        System.out.println("mysql开始连接");
    }

    @Override
    public void close() {
        System.out.println("mysql开始关闭");
    }
}

class OracleDB implements DBinterface {

    @Override
    public void connect() {
        System.out.println("Orcle开始连接");
    }

    @Override
    public void close() {
        System.out.println("orcle关闭。。");
    }
}

interface IB {
    void h1();

}

interface IC {
    void f1();
}

class Pig  implements ID,IB,IC {

    @Override
    public void h1() {

    }

    @Override
    public void f1() {

    }


}



