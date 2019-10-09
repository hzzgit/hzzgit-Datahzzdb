package test;

import daoconfig.HzzDataSource;
import daoconfig.mysqldb;

import java.util.List;
import java.util.Map;

public class test2main {
    public static void main(String[] args)  {
        HzzDataSource.createhzzdb(HzzDataSource.MYSQL,HzzDataSource.web);

        mysqldb mysql=new mysqldb();
        String sql="select vehicleId from vehicle where deleted=false limit 0,20000";
        List<Map> datas= (List<Map>)  mysql.searchnopagesqlobject(sql);
        String text="";
        for (Map data : datas) {
            String vehicleId= (String) data.get("vehicleId");
            text += "'"+vehicleId + "',";

        }

        System.out.println(text);
    }
}
