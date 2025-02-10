import java.math.*;
import java.text.*;
import java.util.*;

public class Functions {

    public static void main(String[] args) {
        
    }

    // function to format the salary
    public String formatter_salary(BigDecimal sum){
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.'); 
        symbols.setDecimalSeparator(',');
        DecimalFormat format = new DecimalFormat("R$ #,###.##", symbols);
        String sum_correct = format.format(sum, new StringBuffer(), new FieldPosition(0)).toString();

        return sum_correct;
    }

    // function to normalizer the name
    public String normalizer_text(String text){
        if (text == null) return "";

        text = Normalizer.normalize(text, Normalizer.Form.NFD).replaceAll("\\p{M}", "");

        // text = text.replaceAll("[a-zA-Z]","").trim();

        return text;
    }
}
