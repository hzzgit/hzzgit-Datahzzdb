package test;

public class gpsinstance {
    public static void main(String[] args) {
   Class cs=  Gpsinfo20190706.class;
        try {
            Object o = cs.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
