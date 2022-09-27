import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
//Made by Kuba Krzywik for the sake of job recruitment 
public class MeetingGenerator {

    public List compareSchedule(List<LocalTime> freeTime1, List<LocalTime> freeTime2, LocalTime meetingTimeExpected  ){

        //Sorting for the sake of easier matching and looping
        Collections.sort(freeTime1);
        Collections.sort(freeTime2);

        List<String> possibleHours = new ArrayList();
        LocalTime possibleStartH = null;
        LocalTime possibleEndH = null;
        int i;
        int y;

        //this loop will take out a pair of hours which makes range of free time between meetings, it's not super optimal, but with this amount of data it works just ok
        for(i=0;i<freeTime1.size();i+=2){
            LocalTime start1= freeTime1.get(i);
            LocalTime end1= freeTime1.get(i+1);
            //this loop gets pair from upper loop and checks is you can match any pair with it
            for(y=0;y<freeTime2.size();y+=2){

                LocalTime start2 = freeTime2.get(y);
                LocalTime end2 = freeTime2.get(y+1);

                //statements here check matches and always pick pair of ['Later Hour of Start','Earlier Hour of End'], that will make sure that they do overlap of
                    if(start1.compareTo(start2)>0){
                        possibleStartH=start1;
                    }else possibleStartH=start2;



                    if(end1.compareTo(end2) >= 0) {
                        possibleEndH = end2;
                    } else possibleEndH = end1;

                    if(possibleEndH!=null && possibleStartH!=null ){ //if we found out that the hour we loop through is not matching statements we won't insert it into list of possibleHours
                        LocalTime diffrence = possibleEndH.minusHours(meetingTimeExpected.getHour()).minusMinutes(meetingTimeExpected.getMinute());
                        if( diffrence.compareTo(possibleStartH)>=0){//here we check if the possible start and possible end are at least "Meeting time expected" apart, which makes sure that we'll have enough time

                    possibleHours.add("[\""+possibleStartH.toString()+"\",\""+possibleEndH.toString()+"\"]"); //here we convert LocalTime to String for the sake of task
                    }}
                    //to make sure that next run the variables will be clear we just make them null
                    possibleEndH=null;
                    possibleStartH=null;

            }
        }

        return possibleHours;
    }
}
