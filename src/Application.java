import data.library_system.LibrarySystemImpl;
import presentation.navigation.AppNavigationFacade;

import java.awt.*;

public class Application {
    public static void main(String[] args) {
        LibrarySystemImpl.injectAsSingleton();
        EventQueue.invokeLater(AppNavigationFacade::navigateToStartUpWindow);
    }
}
