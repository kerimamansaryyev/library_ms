package domain.entities.library_member;

import java.util.ArrayList;
import java.util.List;

public class CheckoutRecord implements  Cloneable{
    private final List<CheckoutEntry> checkoutEntries;

    CheckoutRecord (){
        this.checkoutEntries = new ArrayList<>();
    }

    public List<CheckoutEntry> getCheckoutEntries() {
        return List.copyOf(checkoutEntries);
    }

    @Override
    public CheckoutRecord clone() {
        try {
            return (CheckoutRecord) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
