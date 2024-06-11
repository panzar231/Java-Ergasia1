package ui;

import javax.swing.JFrame;

public class ChildWindow extends JFrame {

    protected JFrame parentWindow;

    public ChildWindow(JFrame parentWindow) {
        this.parentWindow = parentWindow;
    }

}
