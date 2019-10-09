package test;

import daoconfig.HzzDataSource;
import daoconfig.mysqldb;

import java.util.List;
import java.util.Map;

public class gpsinfodb {
    public static void main(String[] args) {
        HzzDataSource.createhzzdb(HzzDataSource.MYSQL,HzzDataSource.web);
        String sql="select * from gps_hisdata.gpsinfo_20190706 where simNo='012805920855' and sendTime >=? " +
                " and sendTime<=? and velocity>=1 and abnormalType=0 order by sendTime asc ";
        mysqldb mysqldb=new mysqldb();
        List<Map> datas= (List<Map>) mysqldb.searchnopagesqlobject(sql,"2019-07-11 21:57:28","2019-07-11 23:23:48");
        int allmileage=0;
        double startlatitude=0;
        double startlongitude=0;
        int co=1;
//        for (Map data : datas) {
//            double latitude = Double.parseDouble(String.valueOf(data.get("latitude"))) ;
//            double longitude=Double.parseDouble(String.valueOf( data.get("longitude")));
//            if(co==1){
//            }else{
//                allmileage = allmileage + test.getDistance(startlatitude, startlongitude, latitude, longitude);
//            }
//            startlatitude=latitude;
//            startlongitude=longitude;
//            co=co+1;
//        }
//        System.out.println(allmileage);//算出来是900米
    }
}
