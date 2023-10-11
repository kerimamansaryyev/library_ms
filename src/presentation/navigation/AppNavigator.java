package presentation.navigation;


import java.util.Stack;

final class AppNavigator {

    private static class AppNavigationViewStack{
        private final Stack<AppNavigationView> navigationViews = new Stack<>();

        private void push(AppNavigationView view){

            if(!navigationViews.isEmpty()){
                final var last = navigationViews.peek();
                last.sleep();
            }

            view.activate();

            navigationViews.push(view);
        }

        private void pop(){
            if(navigationViews.isEmpty()){
                return;
            }

            navigationViews.pop().deactivate();

            if(!navigationViews.isEmpty()){
                navigationViews.peek().activate();
            }
        }

    }

    private final AppNavigationViewStack appNavigationViewStack = new AppNavigationViewStack();

    void navigateTo(AppNavigationView view){
        appNavigationViewStack.push(view);
    }

    void goBack(){
        appNavigationViewStack.pop();

    }

}
