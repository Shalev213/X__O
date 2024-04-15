import javax.swing.*;
import java.awt.*;

public class WinWindow extends JFrame {
    private JLabel text;

    private JButton rematch;

    public WinWindow(JLabel text){
        this.setVisible(false);
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Result ;+)");
        this.setLayout(null);
        this.text = text;
        this.text.setText("THERE IS SOMETHING WRONG HERE...");
        this.text.setForeground(Color.red);
        this.text.setBounds(75,160,700,100);
        this.text.setFont(new Font("Arial", Font.BOLD, 55));
        this.text.setVisible(true);

        this.rematch = new JButton("Rematch");
        this.rematch.setFont(new Font("Arial", Font.BOLD, 25));
        this.rematch.setBounds(230, 400, 140,70);
        this.add(rematch);
    }

    public void setTitle(JLabel text) {
        this.text = text;
        this.add(this.text);

    }

    public JButton getRematch() {
        return rematch;
    }

}
