//package test;
//
//import com.ltmonitor.util.StringUtil;
//
//import java.math.BigDecimal;
//import java.util.*;
//import java.util.concurrent.ConcurrentLinkedQueue;
//
//public class test {
//    public String name = "1";
//
//    public test(String name) {
//        this.name = name;
//    }
//
//    public void binaryToDecimal(int n) {
//
//    }
//
//
//    public static HashMap<String, test> basicDataMap = new HashMap<String, test>();
//    public static ConcurrentLinkedQueue<Integer> updateVehiclearg = new ConcurrentLinkedQueue();
//
//    public static void main(String[] args) {
//        double a=24.360068;
//        double b=118.023232;
//
//
//    }
//
//    /**
//     * 保留小数点几位
//     *
//     * @param cn    原始数据
//     * @param point 保留几位小数点
//     * @return
//     */
//    public static double keeppointbynum(double cn, int point) {
//        BigDecimal b = new BigDecimal(cn);
//        double f1 = b.setScale(point, BigDecimal.ROUND_HALF_UP).doubleValue();
//        return f1;
//    }
//
//    /**
//     * 获取两个时间之间，按照每天来区分时间的集合
//     *
//     * @return
//     */
//    public static List<Map<String, Date>> getdataallday(Date start, Date end) {
//        int dateco = end.getDate() - start.getDate();
//        List<Map<String, Date>> alldate = new ArrayList<>();
//        for (int i = 0; i < dateco + 1; i++) {
//            Date startTime = null;
//            Date endTime = null;
//            if (i == 0 && i != dateco) {
//                startTime = start;
//                endTime = getchangdaydate(start, 1);
//            } else if (i != 0 && i != dateco) {
//                startTime = test.getchangdaydate(start, i);
//                endTime = getchangdaydate(start, i + 1);
//            } else if (i != 0 && i == dateco) {
//                startTime = getchangdaydate(start, i);
//                endTime = end;
//            }
//            Map<String, Date> data = new HashMap<>();
//            data.put("startTime", startTime);
//            data.put("endTime", endTime);
//            alldate.add(data);
//        }
//        return alldate;
//    }
//
//    private static Date getchangdaydate(Date date, int day) {
//        Calendar c = Calendar.getInstance();
//        c.setTime(date);
//        c.add(Calendar.DAY_OF_MONTH, day);
//        c.set(Calendar.HOUR_OF_DAY, 0);
//        c.set(Calendar.MINUTE, 0);
//        c.set(Calendar.SECOND, 0);
//        c.set(Calendar.MILLISECOND, 0);
//        Date date1 = c.getTime();
//        return date1;
//    }
//
//
//    /**
//     * 通过经纬度获取距离(单位：米)
//     *
//     * @param lat1
//     * @param lng1
//     * @param lat2
//     * @param lng2
//     * @return
//     */
//    public static int getDistance(double lat1, double lng1, double lat2, double lng2) {
//
//        double EARTH_RADIUS = 6378.137;
//        double x1, y1, z1, x2, y2, z2;
//        lat1 = Math.PI * lat1 / 180.0;
//        lng1 = Math.PI * lng1 / 180.0;
//        double radiusCosLat = EARTH_RADIUS * Math.cos(lat1);
//        x1 = radiusCosLat * Math.sin(lng1);
//        y1 = (EARTH_RADIUS * Math.sin(lat1));
//        z1 = (radiusCosLat * Math.cos(lng1));
//        z1 = -z1;
//        lat2 = Math.PI * lat2 / 180.0;
//        lng2 = Math.PI * lng2 / 180.0;
//        double radiusCosLat2 = EARTH_RADIUS * Math.cos(lat2);
//        x2 = radiusCosLat2 * Math.sin(lng2);
//        y2 = (EARTH_RADIUS * Math.sin(lat2));
//        z2 = (radiusCosLat2 * Math.cos(lng2));
//        z2 = -z2;
//        double result = EARTH_RADIUS * Math.acos(CalcVectorCos(x1, y1, z1, x2, y2, z2)) * 1000;
//        return (int) result;
//    }
//
//    /**
//     * 计算2个向量之间的夹角余玄值
//     *
//     * @param x1
//     * @param y1
//     * @param z1
//     * @param x2
//     * @param y2
//     * @param z2
//     * @return
//     */
//    private static double CalcVectorCos(double x1, double y1, double z1, double x2, double y2, double z2) {
//        double l1 = Math.sqrt(x1 * x1 + y1 * y1 + z1 * z1);
//        double l2 = Math.sqrt(x2 * x2 + y2 * y2 + z2 * z2);
//        double result = (x1 * x2 + y1 * y2 + z1 * z2) / (l1 * l2);
//        if (result > 0.99999999999999 && result < 1) result = 1;
//        if (result < -1) result = -1;
//        if (result > 1) result = 1;
//        return result;
//    }
//
//    /**
//     * 获取设备视频通道数
//     *
//     * @param value
//     * @return
//     */
//    public static Map getvideonum(String value) throws Exception {
//        int videocos = 0;//设备视频通道数
//        Map data = new HashMap();
//        ArrayList<String> videonames = new ArrayList<>();
//        if (!StringUtil.isNullOrEmpty(value)) {//如果不为空
//            String[] videonums = value.split("\\|");
//            for (String videonum : videonums) {
//                String[] videoba = videonum.split(",");
//                if (!videoba[1].equals("0")) {//逻辑通道不为0的时候，代表着有视频通道数
//                    videocos += 1;
//                    videonames.add(videoba[0].trim());
//                }
//            }
//            String vehiclevideonames = "";
//            data.put("videocos", videocos);
//            for (String videoname : videonames) {
//                vehiclevideonames += videoname + ",通道" + videoname + ";";
//            }
//            data.put("videonames", vehiclevideonames);
//        }
//        return data;
//
//    }
//
//}
