package test;

import daoconfig.HzzDataSource;
import daoconfig.mysqldb;

import java.util.*;

public class zhuancar {

    public static void main(String[] args) {
        HzzDataSource.createhzzdb(HzzDataSource.MYSQL,HzzDataSource.web);

        mysqldb mysql=new mysqldb();

        String sql="select simNo from vehicle where deleted =false ";
        ArrayList searchnopagesqlobject = (ArrayList) mysql.searchnopagesqlobject(sql);
        for (Object o : searchnopagesqlobject) {
            Map data=(Map)o;
            String simNo=data.get("simNo").toString();
            System.out.println(simNo);
        }
    }

}
