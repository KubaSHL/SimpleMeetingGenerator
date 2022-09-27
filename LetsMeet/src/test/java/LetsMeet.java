import java.time.LocalTime;
import java.util.List;
//Made by Kuba Krzywik for the sake of job recruitment 
public class LetsMeet {
//So the main idea of mine is to find ranges of time between meeting, and then find places where they overlap by at least expected meeting time, so we can point where the meeting can be placed

    public static void main(String[] str){

        //Here we keep data for the app, I wasn't sure how should I insert it so I kept it simple
        //The schedules are just arrays of hours sorted, where odd index is start and even is end of meeting, they could be mixed up and thrown into sorter but there is no need to write excessive code
        String[] schedule1 = new String[]{"09:00", "10:30","12:00","13:00","16:00","18:00"};
        String[] schedule2 = new String[]{"10:00", "11:30","12:30","14:30","14:30","15:00","16:00","17:00"};
        LocalTime start1 = LocalTime.of(9,00);
        LocalTime end1 = LocalTime.of(19,55);
        LocalTime start2 = LocalTime.of(10,00);
        LocalTime end2 = LocalTime.of(18,30);
        LocalTime meetingTimeExpected = LocalTime.of(0,30);

        //I used calendar generator to extract ranges of free time in which user could schedule meeting
        List<LocalTime> calendar1 = new CalendarGenerator().freeTime(start1, end1, schedule1);
        List<LocalTime> calendar2 = new CalendarGenerator().freeTime(start2, end2, schedule2);

        //Just initiating MeetingGenerator
        List test = new MeetingGenerator().compareSchedule(calendar1, calendar2, meetingTimeExpected);
        System.out.println(test);
    }
}
