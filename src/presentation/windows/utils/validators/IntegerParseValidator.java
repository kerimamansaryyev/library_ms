package presentation.windows.utils.validators;

import java.util.List;

public class IntegerParseValidator implements InputValidator {
    @Override
    public boolean areValuesValid(List<String> values) {
        try {
            for(final var value:values){
                Integer.parseInt(value);
            }
            return  true;
        } catch (Exception e){
            return  false;
        }
    }
}
