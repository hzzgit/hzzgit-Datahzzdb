package test;

import daoconfig.HzzDataSource;
import daoconfig.mysqldb;

import java.util.List;

public class gpsinfodb2 {
    public static void main(String[] args) {
        HzzDataSource.createhzzdb(HzzDataSource.MYSQL,HzzDataSource.web);
        String sql="select * from gps_hisdata.gpsinfo_20190706 where simNo='012805920855' and sendTime >=? " +
                " and sendTime<=? and velocity>=1 and abnormalType=0 order by sendTime asc ";
        mysqldb mysqldb=new mysqldb();
        List<Gpsinfo20190706> datas= (List<Gpsinfo20190706>) mysqldb.searchnopagesqlclass(sql,Gpsinfo20190706.class,"2019-07-11 21:57:28","2019-07-11 23:23:48");
        int allmileage=0;
        double startlatitude=0;
        double startlongitude=0;
        int co=1;

    }
}
