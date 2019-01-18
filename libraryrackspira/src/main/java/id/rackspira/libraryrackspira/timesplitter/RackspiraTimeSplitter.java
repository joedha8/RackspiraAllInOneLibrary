package id.rackspira.libraryrackspira.timesplitter;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.rackspira.libraryrackspira.util.Language;

public class RackspiraTimeSplitter {
    private static final RackspiraTimeSplitter INSTANCE = new RackspiraTimeSplitter();

    private RackspiraTimeSplitter() {}

    public static RackspiraTimeSplitter getInstance() {
        return INSTANCE;
    }

    public String getNameTime(String language) {
        if (language.equals(Language.INDONESIA))
            return getNameIndonesia();
        else if (language.equals(Language.ENGLISH))
            return getNameEnglish();
        else
            return "Language Not Found";
    }

    public String getNameIndonesia() {
        Calendar cal = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("HH");

        if (Integer.parseInt(sdf.format(cal.getTime())) >= 4 && Integer.parseInt(sdf.format(cal.getTime())) <= 10)
            return "Selamat Pagi";
        else if (Integer.parseInt(sdf.format(cal.getTime())) > 10 && Integer.parseInt(sdf.format(cal.getTime())) <= 14)
            return "Selamat Siang";
        else if (Integer.parseInt(sdf.format(cal.getTime())) > 14 && Integer.parseInt(sdf.format(cal.getTime())) <= 18)
            return "Selamat Sore";
        else if (Integer.parseInt(sdf.format(cal.getTime())) > 18)
            return "Selamat Malam";
        else
            return "Not Found";
    }

    public String getNameEnglish() {
        Calendar cal = Calendar.getInstance();
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("HH");

        if (Integer.parseInt(sdf.format(cal.getTime())) >= 4 && Integer.parseInt(sdf.format(cal.getTime())) <= 10)
            return "Good Morning";
        else if (Integer.parseInt(sdf.format(cal.getTime())) > 10 && Integer.parseInt(sdf.format(cal.getTime())) <= 14)
            return "Good Afternoon";
        else if (Integer.parseInt(sdf.format(cal.getTime())) > 14 && Integer.parseInt(sdf.format(cal.getTime())) <= 18)
            return "Good Evening";
        else if (Integer.parseInt(sdf.format(cal.getTime())) > 18)
            return "Good Night";
        else
            return "Not Found";
    }
}
