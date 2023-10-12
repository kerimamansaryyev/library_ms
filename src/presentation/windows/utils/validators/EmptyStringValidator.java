package presentation.windows.utils.validators;

import java.util.List;

public class EmptyStringValidator implements  InputValidator{
    @Override
    public boolean areValuesValid(List<String> values) {
         for(final var value: values){
             if(value == null || value.trim().isEmpty()){
                return false;
             }
         }
         return  true;
    }
}
