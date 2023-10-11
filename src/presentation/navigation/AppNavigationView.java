package presentation.navigation;

final class AppNavigationView {

    private final AppNavigationWindow window;

    AppNavigationView(AppNavigationWindow window){
        this.window = window;
    }

      void activate(){
        window.getJFrame().setVisible(true);
      }

      void deactivate(){
        sleep();
        window.getJFrame().dispose();
      }

      void sleep(){
        window.getJFrame().setVisible(false);
      }
}
