package presentation.navigation;

import presentation.navigation.utils.NavigationWindowListener;

import javax.swing.*;

public interface AppNavigationWindow {
    JFrame getJFrame();

    default void overrideWindowClosing(){
        getJFrame().setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        getJFrame().addWindowListener(new NavigationWindowListener());
    }
}
