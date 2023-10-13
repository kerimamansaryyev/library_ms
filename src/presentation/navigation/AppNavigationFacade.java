package presentation.navigation;

import domain.library_system.User;
import domain.library_system.operations.library_operations.IAddBookCopyOperation;
import domain.library_system.operations.library_operations.IAddBookOperation;
import domain.library_system.operations.library_operations.IAddMemberOperation;
import domain.library_system.operations.library_operations.ICheckoutBookOperation;
import presentation.windows.add_book.AddBookWindow;
import presentation.windows.add_book_copy.AddBookCopyWindow;
import presentation.windows.add_member.AddMemberWindow;
import presentation.windows.checkout_book.CheckoutBookWindow;
import presentation.windows.dashboard.DashboardWindow;
import presentation.windows.login.LoginWindow;

public final class AppNavigationFacade {

    private static final AppNavigator navigator = new AppNavigator();

    public static void navigateToAddBookWindow(IAddBookOperation addBookOperation){
        justNavigateTo(
          new AddBookWindow(addBookOperation)
        );
    }

    public static void navigateToStartUpWindow(){
        justNavigateTo(new LoginWindow());
    }

    public static void navigateToDashboardWindow(User user){
        justNavigateTo(new DashboardWindow(user));
    }

    public static void navigateToAddMemberWindow(IAddMemberOperation addMemberOperation){
        justNavigateTo(new AddMemberWindow(addMemberOperation));
    }

    public static void navigateToCheckoutBookWindow(ICheckoutBookOperation checkoutBookOperation){
        justNavigateTo(new CheckoutBookWindow(checkoutBookOperation));
    }

    public static void navigateToAddBookCopyWindow(IAddBookCopyOperation addBookCopyOperation){
        justNavigateTo(new AddBookCopyWindow(addBookCopyOperation));
    }

    private static void justNavigateTo(AppNavigationWindow window){
        navigateTo(window, true);
    }

    public static AppNavigationView navigateTo(AppNavigationWindow window, boolean shouldHidePrevious){
        final var view = new AppNavigationView(window);
        navigator.navigateTo(
            view, shouldHidePrevious
        );
        return view;
    }

    public static void goBack(){
        navigator.goBack();
    }

}
