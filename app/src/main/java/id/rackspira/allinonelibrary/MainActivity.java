package id.rackspira.allinonelibrary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import id.rackspira.libraryrackspira.currencyformatter.RackspiraCurrencyFormatter;
import id.rackspira.libraryrackspira.timesplitter.RackspiraTimeSplitter;
import id.rackspira.libraryrackspira.util.Currency;
import id.rackspira.libraryrackspira.util.Language;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Format", RackspiraCurrencyFormatter.getInstance().formatCurrency("20000", Currency.IDR));
        Log.d("Sapaan", RackspiraTimeSplitter.getInstance().getNameTime(Language.INDONESIA));
    }
}
