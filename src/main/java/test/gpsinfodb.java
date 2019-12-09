package test;

import daoconfig.HzzDataSource;
import daoconfig.mysqldb;

import java.util.List;
import java.util.Map;

public class gpsinfodb {
    public static void main(String[] args) {
        HzzDataSource.createhzzdb(HzzDataSource.MYSQL,HzzDataSource.web);
        String sql = "select gpsData from  gps_hisdata.gpscompress where gpsDate ='2019-10-12' and SimNo='012805920035' ";
        mysqldb mysqldb=new mysqldb();
        List<Map> datas= (List<Map>) mysqldb.searchnopagesqlobject(sql);

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
