interface Eatable{
    void taste();
}

interface Flyable{
    void fly(String weather);
}

interface Addable{
    int add(int a, int b);
}

public class Main {

    public void eat(Eatable e){
        System.out.println(e);
        e.taste();
    }
    public void drive(Flyable f){
        System.out.println("I'm driving "+f);
        f.fly("Sunny");
    }
    public void test(Addable a){
        System.out.println("5+3="+a.add(5,3));
    }
    public static void main(String[] args) {
        Main lambdatest=new Main();
        //无参数Lambda表达式,代码块只有一条语句
        lambdatest.eat(()->System.out.println("It's delicious"));
        //一个形参,代码块不止一条语句
        lambdatest.drive(weather -> {
            System.out.println("The weather today is "+weather);
            System.out.println("The driving is steady");
        });
        //代码块只有一条语句时,省略return关键字
        lambdatest.test((a,b)-> a+b);
    }
}
