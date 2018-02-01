import java.util.Calendar;

public class Main {

    public static void main(String[] args) {

        //print 2018-2-28
        Calendar cal1=Calendar.getInstance();
        cal1.set(2018,Calendar.JANUARY,31,0,0,0);
        cal1.add(Calendar.MONTH,1);
        System.out.println(cal1.getTime());

        //print 2018-2-28
        Calendar cal2=Calendar.getInstance();
        cal2.set(2018,Calendar.JANUARY,29,0,0,0);
        cal2.roll(Calendar.MONTH,13);
        System.out.println(cal2.getTime());

        //print 2018-3-3
        Calendar cal3=Calendar.getInstance();
        cal3.set(2018,Calendar.FEBRUARY,31,0,0,0);
        System.out.println(cal3.getTime());

        //set延迟修改,print 2018-5-1
        Calendar cal4=Calendar.getInstance();
        cal4.set(2018,Calendar.FEBRUARY,31,0,0,0);
        cal4.set(Calendar.MONTH,3);
        System.out.println(cal4.getTime());

    }
}
