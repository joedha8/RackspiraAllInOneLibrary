package id.rackspira.libraryrackspira.currencyformatter;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import id.rackspira.libraryrackspira.util.Currency;

public class RackspiraCurrencyFormatter {
    private static final RackspiraCurrencyFormatter INSTANCE = new RackspiraCurrencyFormatter();

    private RackspiraCurrencyFormatter() {}

    public static RackspiraCurrencyFormatter getInstance() {
        return INSTANCE;
    }

    public String formatCurrency(String nominal, String currency){
        if (currency.equals(Currency.IDR))
            return formatCurrencyIndonesia(nominal);
        else if (currency.equals(Currency.GBP))
            return formatCurrencyUK(nominal);
        else if (currency.equals(Currency.USD))
            return formatCurrencyUS(nominal);
        else if (currency.equals(Currency.CNY))
            return formatCurrencyChina(nominal);
        else if (currency.equals(Currency.EUR))
            return formatCurrencyEuro(nominal);
        else if (currency.equals(Currency.SGD))
            return formatCurrencySingapore(nominal);
        else if (currency.equals(Currency.MYR))
            return formatCurrencyMalaysia(nominal);
        else if (currency.equals(Currency.KRW))
            return formatCurrencySouthKorea(nominal);
        else if (currency.equals(Currency.JPY))
            return formatCurrencyJapan(nominal);
        else
            return "Currency Not Found";
    }

    private String formatCurrencyIndonesia(String nominal) {
        Double doubleNominal = Double.parseDouble(nominal);

        DecimalFormat kursIndonesia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("Rp. ");
        formatRp.setMonetaryDecimalSeparator(',');
        formatRp.setGroupingSeparator('.');

        kursIndonesia.setDecimalFormatSymbols(formatRp);

        if (String.valueOf(kursIndonesia.format(doubleNominal)).contains(",00"))
            return String.valueOf(kursIndonesia.format(doubleNominal));
        else
            return String.valueOf(kursIndonesia.format(doubleNominal))+",00";
    }

    private String formatCurrencyUS(String nominal) {
        Double doubleNominal = Double.parseDouble(nominal);

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        return currency.format(doubleNominal);
    }

    private String formatCurrencyChina(String nominal) {
        Double doubleNominal = Double.parseDouble(nominal);

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.CHINA);
        return currency.format(doubleNominal);
    }

    private String formatCurrencyUK(String nominal) {
        Double doubleNominal = Double.parseDouble(nominal);

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.UK);
        return currency.format(doubleNominal);
    }

    private String formatCurrencyEuro(String nominal) {
        Double doubleNominal = Double.parseDouble(nominal);

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        return currency.format(doubleNominal);
    }

    private String formatCurrencySingapore(String nominal) {
        Double doubleNominal = Double.parseDouble(nominal);

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.US);
        return currency.format(doubleNominal);
    }

    private String formatCurrencySouthKorea(String nominal) {
        Double doubleNominal = Double.parseDouble(nominal);

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.KOREA);
        return currency.format(doubleNominal);
    }

    private String formatCurrencyMalaysia(String nominal) {
        Double doubleNominal = Double.parseDouble(nominal);

        DecimalFormat kursMalaysia = (DecimalFormat) DecimalFormat.getCurrencyInstance();
        DecimalFormatSymbols formatRp = new DecimalFormatSymbols();

        formatRp.setCurrencySymbol("RM ");
        formatRp.setGroupingSeparator('.');

        kursMalaysia.setDecimalFormatSymbols(formatRp);

        return String.valueOf(kursMalaysia.format(doubleNominal));
    }

    private String formatCurrencyJapan(String nominal) {
        Double doubleNominal = Double.parseDouble(nominal);

        NumberFormat currency = NumberFormat.getCurrencyInstance(Locale.JAPAN);
        return currency.format(doubleNominal);
    }
}
