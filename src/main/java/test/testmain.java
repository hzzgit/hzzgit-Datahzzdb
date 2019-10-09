package test;

import daoconfig.HzzDataSource;
import daoconfig.mysqldb;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Map;

public class testmain {
    public static void main(String[] args) throws UnsupportedEncodingException {
        HzzDataSource.createhzzdb(HzzDataSource.MYSQL,HzzDataSource.web);

        mysqldb mysql=new mysqldb();
      List<Map> datas= (List<Map>) mysql.searchnopagesqlobject("SELECT * FROM  vehicle ");
        System.out.println("shuk"+datas.size());
        for (Map data : datas) {
            String depid= (String) data.get("depId");
            String plateNo= (String) data.get("plateNo");
            String simNo= (String) data.get("simNo");
            String vehicleId= (String) data.get("vehicleId");
            List<Map> data22= (List<Map>) mysql.searchnopagesqlobject("select * from gpsrealdata where simNo='"+simNo+"'");
        if(data22.size()>0){

        }else{
            String sql="INSERT INTO gpsrealdata(depId,online,plateNo,simNo,updateDate,onlineDate,altitude,gas,latitude,longitude,mileage,recordVelocity,valid,vehicleId,velocity,signalState,lastDayMileage,tiredLevel,unusualDriveBeaviour,videoAlarm,videoCoverAlarmStatus,videoLossAlarmStatus,videoStorageFaultAlarmStatus,direction) VALUES('"+depid+"',FALSE,'"+plateNo+"','"+simNo+"',NOW(),NOW(),0,0,0,0,0,0,0,"+vehicleId+",0,0,0,0,0,0,0,0,0,0)";
            System.out.println(sql);
              mysql.executesql(sql);
        }

        }

    }
}
