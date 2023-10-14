package presentation.windows.utils.validators;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumericInputValidator implements InputValidator {
    @Override
    public boolean areValuesValid(List<String> values) {
        try {
            for(final var value:values){
                Pattern pattern = Pattern.compile("^[-+]?\\d+$");
                Matcher matcher = pattern.matcher(value);
                if(!matcher.matches()){
                    return false;
                }
            }
            return  true;
        } catch (Exception e){
            return  false;
        }
    }
}
