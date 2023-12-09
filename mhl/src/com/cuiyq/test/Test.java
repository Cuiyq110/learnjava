package com.cuiyq.test;

import com.cuiyq.utils.JDBCUtilsByDruid;

import java.sql.SQLException;

public class Test {
    @org.junit.Test
    public void test() {
        try {
            JDBCUtilsByDruid.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
        }
    }
}
