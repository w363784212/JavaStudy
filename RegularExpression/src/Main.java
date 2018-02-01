import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        String str="Hello,Java!";
        //贪婪模式
        System.out.println(str.replaceFirst("\\w*","#"));
        //勉强模式
        System.out.println(str.replaceFirst("\\w*?","#"));


        Pattern p=Pattern.compile("\\d{5,10}@qq\\.com");
        Matcher m=p.matcher("363784212@qq.com");
        System.out.println(m.find());
        System.out.println(m.start());
        System.out.println(m.group());


        String str1="I want to buy a Java book, call me at 18672485695"+"my phone1 number is 18672485696"
                +"my phone2 number is 18672485697";
        Matcher m1=Pattern.compile("(13|15|18)\\d{9}").matcher(str1);
        while(m1.find())
            System.out.println(m1.group());

    }
}
