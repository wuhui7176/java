package com.code1j;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.sun.tools.internal.ws.api.TJavaGeneratorExtension;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @ wuhui
 * @ date  2017/9/26下午5:58
 */
public class DruidTest {


    public static DruidDataSource druidDataSource =  null;

    public static void main(String[] args) throws SQLException, InterruptedException {


        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    init();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(1000);
        DruidPooledConnection druidPooledConnection = druidDataSource.getConnection();

//        ResultSet resultSet = druidPooledConnection.getConnection().createStatement().executeQuery("SELECT * FROM orders limit 0,10");
//
//        while (resultSet.next()){
//
//            System.out.println(resultSet.getString(1));
//        }

        while (true){
            Thread.sleep(1000000);

        }

    }


    public static void init() throws SQLException {
        druidDataSource = new DruidDataSource();

        druidDataSource.setKeepAlive(true);
        druidDataSource.setUsername("root");
        druidDataSource.setUrl("jdbc:mysql://hb:3306/tqhMZwtU?useUnicode=true&zeroDateTimeBehavior=round&transformedBitIsBoolean=true&autoReconnect=true\n");

        druidDataSource.setInitialSize(10000);
        druidDataSource.setMaxActive(20000);

//        druidDataSource.setPassword("JDglDh05opUq");
        druidDataSource.setDriverClassName("com.mysql.jdbc.Driver");

        druidDataSource.init();


    }

}
