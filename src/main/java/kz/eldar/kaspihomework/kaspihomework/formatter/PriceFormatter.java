package kz.eldar.kaspihomework.kaspihomework.formatter;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Component
public class PriceFormatter implements Formatter<BigDecimal> {
    @Override
    public BigDecimal parse(String text, Locale locale) throws ParseException {
        return new BigDecimal(text);
    }

    @Override
    public String print(BigDecimal object, Locale locale) {
        if (object == null) {
            return "";
        }

        NumberFormat formatter = NumberFormat.getNumberInstance(locale);
        formatter.setGroupingUsed(true);
        formatter.setMaximumFractionDigits(0);

        return formatter.format(object) + " ₸";
    }
}
