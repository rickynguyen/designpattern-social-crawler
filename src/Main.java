import app.Application;

import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        try {
            Application app = Application.getInstance();
            app.navigateTo("MainController", "main", null);
            
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage() + e.getMessage());
        }
    }
}
