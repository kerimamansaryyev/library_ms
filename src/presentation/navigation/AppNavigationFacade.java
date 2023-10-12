package presentation.navigation;

import domain.library_system.User;
import domain.library_system.operations.library_operations.IAddMemberOperation;
import presentation.windows.add_member.AddMemberWindow;
import presentation.windows.dashboard.DashboardWindow;
import presentation.windows.login.LoginWindow;

public final class AppNavigationFacade {

    private static final AppNavigator navigator = new AppNavigator();


    public static void navigateToStartUpWindow(){
        navigateTo(new LoginWindow());
    }

    public static void navigateToDashboardWindow(User user){
        navigateTo(new DashboardWindow(user));
    }

    public static void navigateToAddMemberWindow(IAddMemberOperation addMemberOperation){
        navigateTo(new AddMemberWindow(addMemberOperation));
    }

    public static void navigateTo(AppNavigationWindow window){
        navigator.navigateTo(
                new AppNavigationView(window)
        );
    }

    public static void goBack(){
        navigator.goBack();
    }

}
