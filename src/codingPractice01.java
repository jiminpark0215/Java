import java.io.*;
import java.util.StringTokenizer;

public class codingPractice01 {

    public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = in.readLine();
        StringTokenizer st = new StringTokenizer(line);

        int month = Integer.parseInt(st.nextToken());//월
        int day = Integer.parseInt(st.nextToken());//일

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] dayOfTheWeeks = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

        int totalDays = day;

        for (int i = 0; i < month - 1; i++) {
            totalDays += daysInMonth[i];
        }
        out.write(dayOfTheWeeks[totalDays % 7]);

        out.flush();
        out.close();
    }
}