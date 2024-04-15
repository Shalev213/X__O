import javax.swing.*;
import java.awt.*;

public class Window extends JFrame{
    private int counter;
    private WinWindow winWindow1;
    private  JLabel text;
    private JButton[] cell;
    private int y = 3;
    private boolean isFirstGame = true;


    public  Window(){
        this.counter = 0;
        text = new JLabel();
        winWindow1 = new WinWindow(text);

        this.setVisible(false);
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("My Game: Tic Tac Toe");
        GridLayout gridLayout = new GridLayout(y,y,10,10);
        this.setLayout(gridLayout);

        cell = new JButton[y*y];

        mainGameLoop();
        this.winWindow1.getRematch().addActionListener(e -> {
            winWindow1.setVisible(false);
            showWindow();
            isFirstGame = false;
            for (int i = 0; i < y*y; i++) {
                cell[i].setText("");
            }
            mainGameLoop();
        });
    }
    public void mainGameLoop(){

        for (int i = 0; i < y*y; i++) {
            if(isFirstGame) {
                cell[i] = new JButton();
            }
            int finalI = i;
            cell[i].addActionListener((e) -> {
                cell[finalI].setFont(new Font("Arial", Font.BOLD, 120));
                if (cell[finalI].getText().equals("")) {
                    if (this.counter % 2 == 0) {
                        cell[finalI].setText("X");
                        cell[finalI].setForeground(Color.yellow);
                    } else {
                        cell[finalI].setText("O");
                        cell[finalI].setForeground(Color.blue);
                    }
                    this.counter++;
                    if (!cell[0].getText().equals("") && cell[0].getText().equals(cell[1].getText()) && cell[1].getText().equals(cell[2].getText()) ||
                            !cell[3].getText().equals("") && cell[3].getText().equals(cell[4].getText()) && cell[4].getText().equals(cell[5].getText())||
                            !cell[6].getText().equals("") && cell[6].getText().equals(cell[7].getText()) && cell[7].getText().equals(cell[8].getText())||
                            !cell[0].getText().equals("") && cell[0].getText().equals(cell[3].getText()) && cell[3].getText().equals(cell[6].getText())||
                            !cell[1].getText().equals("") && cell[1].getText().equals(cell[4].getText()) && cell[4].getText().equals(cell[7].getText())||
                            !cell[2].getText().equals("") && cell[2].getText().equals(cell[5].getText()) && cell[5].getText().equals(cell[8].getText())||
                            !cell[0].getText().equals("") && cell[0].getText().equals(cell[4].getText()) && cell[4].getText().equals(cell[8].getText())||
                            !cell[2].getText().equals("") && cell[2].getText().equals(cell[4].getText()) && cell[4].getText().equals(cell[6].getText())){


                        if (counter % 2 == 0){
                            this.setVisible(false);
                            winWindow1.setVisible(true);
                            text.setText("The winner is: O");
                            this.text.setBounds(75,160,700,100);
                            this.text.setFont(new Font("Arial", Font.BOLD, 55));
                            text.setForeground(Color.blue);
                            winWindow1.setTitle(text);

                        }else{
                            this.setVisible(false);
                            winWindow1.setVisible(true);
                            text.setText("The winner is: X");
                            this.text.setBounds(75,160,700,100);
                            this.text.setFont(new Font("Arial", Font.BOLD, 55));
                            text.setForeground(Color.yellow);
                            winWindow1.setTitle(text);
                        }

                    }else if (cell[0].getText()!= "" && cell[1].getText()!="" && cell[2].getText()!="" && cell[3].getText()!=""
                            && cell[4].getText()!="" && cell[5].getText()!="" && cell[6].getText()!="" && cell[7].getText()!="" && cell[8].getText()!=""){

                        this.setVisible(false); // 1
                        text.setFont(new Font("Arial", Font.BOLD, 80));
                        text.setBounds(185,160,700,100);
                        winWindow1.setVisible(true);
                        text.setText("Draw");
                        text.setForeground(Color.cyan);
                        winWindow1.add(text);
                    }

                }
            });
            this.add(cell[i]);

        }
    }

    public void showWindow() {
        this.setVisible(true);
    }
}
