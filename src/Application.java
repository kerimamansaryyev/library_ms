import presentation.navigation.AppNavigationFactory;

import java.awt.*;

public class Application {
    public static void main(String[] args) {
        EventQueue.invokeLater(AppNavigationFactory::navigateToStartUpWindow);
    }
}
