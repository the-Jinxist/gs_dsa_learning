public class TimeFormatSolution {

    public static void main(String[] args) {
        final String changedTime = changeFormat("12:30:45PM");
        System.out.println(changedTime);
    }


    public static String changeFormat(String value){
        String[] splitValues = value.split(":");

        String hour = splitValues[0];
        String timeOfDay = splitValues[splitValues.length -1].substring(splitValues.length -1).toString().toLowerCase();

        int parsedHour = Integer.parseInt(hour);

        System.out.println("Hour: " + hour + " Time of day" + timeOfDay+ " Parsed hour "+ parsedHour);
        if(timeOfDay.equals("pm") && parsedHour != 12){
            System.out.println("time is pm");
            parsedHour = 12 + parsedHour;
            hour = String.valueOf(parsedHour);
        }

        if(timeOfDay.equals("am") && parsedHour == 12){
            parsedHour = 0;
            hour = "00";
        }

        String finalTime = hour + ":" + splitValues[1] + ":" + splitValues[splitValues.length -1].substring(0, 2);
        return finalTime;
    }
    
}
