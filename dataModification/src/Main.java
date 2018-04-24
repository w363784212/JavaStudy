import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import com.csvreader.*;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("===================================");
        System.out.println("请选择：1.读数据 2.修改数据(每秒50条)");
        System.out.println("===================================");
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        switch (a){
            case 1:
                read();
                break;
            case 2:
                modify();
                System.out.println("修改完毕");
                break;
            default:
                break;
        }
    }

    public static void modify(){

        String filePath = "C:\\Users\\Administrator\\Desktop\\数据\\飞行数据_2018_4_19\\DJI_0328.csv";
        String outputPath="C:\\Users\\Administrator\\Desktop\\数据\\飞行数据_2018_4_19\\modifiedData\\DJI_0328.csv";

        try {
            // 创建CSV读对象
            CsvReader csvReader = new CsvReader(filePath);
            CsvWriter csvWriter=new CsvWriter(outputPath);

            String[] headers={"id","time","longitude","latitude","height","flightPitch","flightRoll","flightYaw",
                    "gimbalPitch", "gimbalRoll","gimbalYaw","velocity_x","velocity_y","velocity_z"};

            // 读表头
            csvReader.readHeaders();
            csvWriter.writeRecord(headers);
            int n=0;
            ArrayList<Integer> list=new ArrayList<>();
            String pre="00:00";
            while (csvReader.readRecord()) {
                // 读这行的某一列
                String next = csvReader.get("time");
                if (next.equals(pre)) {
                    n++;
                } else {
                    list.add(n - 50);
                    //System.out.println(pre+"=="+n);
                    pre = next;
                    n = 1;
                }
            }
            list.add(n - 50);

            //删除多余数据
            csvReader=new CsvReader(filePath);
            csvReader.readHeaders();

            for(int i=0;i<list.size()-1;i++){
                int delnum=list.get(i);
                int already=0;
                if(delnum>0) {
                    int distance = (50 + delnum) / delnum;
                    for (int j = 1; j <= 50 + delnum; j++) {
                        csvReader.readRecord();
                        String row=csvReader.getRawRecord();
                        String[] c=row.split(",");
                        if((j-distance/2)%distance==0){
                            if(already<delnum) {
                                already++;
                                continue;
                            }
                        }
                        csvWriter.writeRecord(c);
                    }
                }else if(delnum==0){
                    for(int j=1;j<=50;j++){
                        if(csvReader.readRecord()) {
                            String row = csvReader.getRawRecord();
                            String[] c = row.split(",");
                            csvWriter.writeRecord(c);
                        }
                    }
                } else {
                    int total=delnum+50;
                    int increase=-delnum;
                    int distance=total/increase;
                    for(int j=1;j<=total;j++){
                        csvReader.readRecord();
                        String row=csvReader.getRawRecord();
                        String[] c=row.split(",");
                        if((j-distance/2)%distance==0 && increase>0){
                            csvWriter.writeRecord(c);
                            increase--;
                        }
                        csvWriter.writeRecord(c);
                    }
                }
            }
            int tail=list.get(list.size()-1);
            for(int i=1;i<=tail+50;i++){
                if(csvReader.readRecord()){
                    String row=csvReader.getRawRecord();
                    String[] c=row.split(",");
                    csvWriter.writeRecord(c);
                }
            }

            csvWriter.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void read(){
        String filePath = "C:\\Users\\Administrator\\Desktop\\数据\\飞行数据_2018_4_19\\modifiedData\\DJI_0328.csv";

        try {
            // 创建CSV读对象
            CsvReader csvReader = new CsvReader(filePath);
            // 读表头
            csvReader.readHeaders();
            int n = 0;
            String pre = "00:00";
            while(csvReader.readRecord()){
                String next=csvReader.get("time");
                if (next.equals(pre)) {
                    n++;
                } else {
                    System.out.println(pre+"=="+n);
                    pre = next;
                    n = 1;
                }
            }
            System.out.println(pre+"=="+n);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
