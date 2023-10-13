package presentation.navigation;


import java.util.Stack;

final class AppNavigator {

    private static class AppNavigationViewStack{
        private final Stack<AppNavigationView> navigationViews = new Stack<>();

        private void push(AppNavigationView view, boolean shouldHidePrevious){

            if(!navigationViews.isEmpty() && shouldHidePrevious){
                final var last = navigationViews.peek();
                last.sleep();
            }

            view.activate();

            navigationViews.push(view);
        }

        private void pop(){
            if(navigationViews.isEmpty()){
                System.exit(0);
                return;
            }

            navigationViews.pop().deactivate();

            if(!navigationViews.isEmpty()){
                navigationViews.peek().activate();
            }
        }

    }

    private final AppNavigationViewStack appNavigationViewStack = new AppNavigationViewStack();

    void navigateTo(AppNavigationView view, boolean shouldHidePrevious){
        appNavigationViewStack.push(view, shouldHidePrevious);
    }

    void goBack(){
        appNavigationViewStack.pop();

    }

}
