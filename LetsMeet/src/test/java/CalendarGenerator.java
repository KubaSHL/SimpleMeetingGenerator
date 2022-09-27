import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
//Made by Kuba Krzywik for the sake of job recruitment 
public class CalendarGenerator {

 //this function will return ranges of free time in inserted calendar
 public List<LocalTime> freeTime(LocalTime start , LocalTime end,  String[] list){
  List listOfFreeTime = new ArrayList();
  int lengthOfList = list.length;
  //in these two statements we check if meeting start or end along with workday
  if(start.isBefore(LocalTime.parse(list[0]))){
   listOfFreeTime.add(start);
   listOfFreeTime.add(LocalTime.parse(list[0]));
  }
  if(end.isAfter(LocalTime.parse(list[lengthOfList-1]))){
   listOfFreeTime.add(end);
   listOfFreeTime.add(LocalTime.parse(list[lengthOfList-1]));
  }

  //here we are getting end of meeting and start of next, which gives us pair of hours, this pair is ['Start if Free Time','End of Free Time'], so pretty much range of time
  //because we checked first and last values we start from index of 1 and end on index of n-1
  for(int i=1; i+1 < list.length; i+=2 ){
   if(list[i]!=list[i+1]){
    String timestamp1 = list[i];
    String timestamp2 = list[i+1];
    LocalTime startOfFreeTime = LocalTime.parse(timestamp1);
    LocalTime endOfFreeTime = LocalTime.parse(timestamp2);

    listOfFreeTime.add(startOfFreeTime);
    listOfFreeTime.add(endOfFreeTime);

   }else continue;}

  return listOfFreeTime;
 }
}
