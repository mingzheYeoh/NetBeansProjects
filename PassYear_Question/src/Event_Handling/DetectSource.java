package Event_Handling;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class DetectSource extends JFrame {

    private JButton jbtOK = new JButton("OK");
    private JButton jbtCancel = new JButton("Cancel");

    public DetectSource() {
        setLayout(new FlowLayout());
        add(jbtOK);
        add(jbtCancel);
        jbtOK.addActionListener(new ButtonListenerClass());
        jbtCancel.addActionListener(new ButtonListenerClass());

        setSize(300, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private class ButtonListenerClass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == jbtOK) {
                JOptionPane.showMessageDialog(null, "OK button clicked");
            } else if (e.getSource() == jbtCancel) {
                JOptionPane.showMessageDialog(null, "Cancel button clicked.");
            }
        }
    }

    public static void main(String[] args) {
        new DetectSource();
    }

}
