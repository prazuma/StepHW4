import java.io.*;
import java.util.Calendar;

/**
 * Created by hashimotomika on 6/20/15.
 */
public class IsOpenNow {
    public static Hours[][] hours = new Hours[7][5];
    public static void main(String[] args){
        for(int i = 0; i < hours.length; i++){
            for(int j = 0; j < hours[i].length; j++){
                hours[i][j] = new Hours();
            }
        }
        fileRead("openings.txt");
        if(isOpenNow()){
            System.out.println("営業時間内です");
        }else{
            System.out.println("営業時間外です");
        }
    }

    public static void fileRead(String filePath){
        try {
            File file = new File(filePath);
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);
            String str = br.readLine();
            while(str != null){
                String[] splited = str.split(",");
                int dayOfWeek = Integer.parseInt(splited[0]);
                for(int i = 0; i <= splited.length / 2; i += 2){
                    int startH = Integer.parseInt(splited[i+1]);
                    int finishH = Integer.parseInt(splited[i+2]);
                    hours[dayOfWeek][i/2].startH = startH;
                    hours[dayOfWeek][i/2].finishH = finishH;
                }
                str = br.readLine();
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isOpenNow1(int hour, int start, int finish){
        return start <= hour && hour < finish;
    }

    public static boolean isOpenNow2(int hour, int start, int finish){
        return start <= hour+24 && hour+24 < finish;
    }

    public static boolean isOpenNow(int hour, Hours[] today, Hours[] yesterday){
        Hours[] schedule = today;
        int i = 0;
        while(i < schedule.length){
            int startH = schedule[i].startH;
            int finishH = schedule[i].finishH;
            if(isOpenNow1(hour, startH, finishH))
                return true;
            i++;
        }
        schedule = yesterday;
        i = 0;
        while(i < schedule.length){
            int startH = schedule[i].startH;
            int finishH = schedule[i].finishH;
            if(isOpenNow2(hour, startH, finishH))
                return true;
            i++;
        }
        return false;
    }

    public static boolean isOpenNow(){
        Calendar calendar = Calendar.getInstance();
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int indexToday = dayOfWeek - 1;
        int indexYesterday = (7 + dayOfWeek - 2) % 7;
        Hours[] today = hours[indexToday];
        Hours[] yesterday = hours[indexYesterday];
        return isOpenNow(hour, today, yesterday);
    }
}
class Hours{
    int startH;
    int finishH;

    Hours(){
        startH = 0;
        finishH = 0;
    }

}
