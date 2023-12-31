package presentation.navigation.utils;

import presentation.navigation.AppNavigationFacade;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class NavigationWindowListener extends WindowAdapter {
    @Override
    public void windowClosing(WindowEvent e) {
        AppNavigationFacade.goBack();
    }
}
