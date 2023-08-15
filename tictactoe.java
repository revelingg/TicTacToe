/* Danny Adenuga
Java PD 4
6/8/22 
*/

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.util.Random;
import javax.swing.JOptionPane;

class Main {
  JFrame frame;
  JPanel contentPane, title, button;
  JButton reset;
  JLabel text, logo;
  boolean winner, player1turn;
  int totalRow = 3;
  int totalCol = 3;
  int totalCell = 9;
  char playerSign;
  JButton[] buttons = new JButton[totalCell];
  Random random = new Random();

  public Main() {
    frame = new JFrame("Tick Tac Toe");
    reset = new JButton("reset");
    contentPane = new JPanel();
    text = new JLabel("    ");
    logo = new JLabel(" Welcome!! ");

    button = new JPanel();

    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    contentPane = new JPanel();

    text.setFont(new Font("Ink Free", Font.BOLD, 20));
    text.setVerticalAlignment(JLabel.TOP);
    text.setBackground(Color.white);
    text.setOpaque(false);

    button.setLayout(new GridLayout(3, 3));

    reset.setHorizontalAlignment(JButton.CENTER);
    reset.setVerticalAlignment(JButton.BOTTOM);

    contentPane.setBackground(Color.black);
    contentPane.add(text);
    contentPane.add(button);
    contentPane.add(reset);
    frame.setContentPane(contentPane);
    frame.setSize(200, 200);
    frame.setVisible(true);
   

      
   runMethod();


          
   

  } // ends the sub main method

  public void game() {

    // the game method basically creates the tictac toe board itselt and sets the
    // color and the loop
    text.setText("Welcome!!");

    for (int i = 0; i <= 8; i++) {
      buttons[i] = new JButton();
      buttons[i].setText("");
      buttons[i].setBackground(Color.black);
      buttons[i].setFont(new Font("MV Boli", Font.BOLD, 20));
      buttons[i].setFocusable(false);
      buttons[i].setPreferredSize(new Dimension(70, 70));
      button.add(buttons[i]);
      contentPane.add(text);
      contentPane.add(button);

      frame.setContentPane(contentPane);

      buttons[i].addActionListener(new Click());
      reset.addActionListener(new Press());

    } // ends the for loop
  }// ends the game method itself

  class Press implements ActionListener {
    public void actionPerformed(ActionEvent event) {

      for (int i = 0; i < 9; i++) {
        buttons[i].setText("");
        buttons[i].setBackground(Color.black);
        text.setText("New Game");
         Main TT = new Main();

          

    
   
      }
    }
  }

  class Click implements ActionListener {

    // actionlistner simply says that if the button is clicked and its the player
    // turn and the space is blank it should set the color and the string to X or O
    // depending on whos playing and change the title to the next person turn

    public void actionPerformed(ActionEvent event) {
      JButton clicked = (JButton) event.getSource();
      if (event.getSource() == clicked) {
        if (player1turn) {
          if (clicked.getText() == "") {
            clicked.setForeground(Color.blue);
            clicked.setText("X");
            player1turn = false;
            text.setText("O's Turn");
            check();
          } // closes the 3rd if
        } // closes the second if
        else {
          if (clicked.getText() == "") {
            clicked.setForeground(Color.red);
            clicked.setText("O");
            player1turn = true;
            text.setText("X's Turn");
            // text.setSize();
            check();
          } // closes the if for O
        } // closes the else
      } // closes the original if that nests all of this
        // closes the for statment that creates the loop
    } // closes the void actionvent
  } // closes the actionListener

  public void xWins(int a, int b, int c) {

    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);

    for (int i = 0; i < 9; i++) {
      buttons[i].setEnabled(false);
    }
    text.setText("X wins");
  }

  public void oWins(int a, int b, int c) {
    buttons[a].setBackground(Color.GREEN);
    buttons[b].setBackground(Color.GREEN);
    buttons[c].setBackground(Color.GREEN);

    for (int i = 0; i < 9; i++) {
      buttons[i].setEnabled(false);
    }
    text.setText("O wins");
  }

  public void turn() {

    // turn method essentially sets whos turn it is via a random int

    try {
      Thread.sleep(7000);
    } catch (InterruptedException error) {
      error.printStackTrace();
    } // closes try and catch

    if (random.nextInt(2) == 0) {
      player1turn = true;
      text.setText("X's Turn");

    } // closes if statement
    else {

      player1turn = false;
      text.setText("O's Turn");

    } // closes else statement
  } // closes the turn method

  public void check() {

    // check X win conditions
    if ((buttons[0].getText() == "X") &&
        (buttons[1].getText() == "X") &&
        (buttons[2].getText() == "X")) {
      xWins(0, 1, 2);
    }
    if ((buttons[3].getText() == "X") &&
        (buttons[4].getText() == "X") &&
        (buttons[5].getText() == "X")) {
      xWins(3, 4, 5);
    }
    if ((buttons[6].getText() == "X") &&
        (buttons[7].getText() == "X") &&
        (buttons[8].getText() == "X")) {
      xWins(6, 7, 8);
    }
    if ((buttons[0].getText() == "X") &&
        (buttons[3].getText() == "X") &&
        (buttons[6].getText() == "X")) {
      xWins(0, 3, 6);
    }
    if ((buttons[1].getText() == "X") &&
        (buttons[4].getText() == "X") &&
        (buttons[7].getText() == "X")) {
      xWins(1, 4, 7);
    }
    if ((buttons[2].getText() == "X") &&
        (buttons[5].getText() == "X") &&
        (buttons[8].getText() == "X")) {
      xWins(2, 5, 8);
    }
    if ((buttons[0].getText() == "X") &&
        (buttons[4].getText() == "X") &&
        (buttons[8].getText() == "X")) {
      xWins(0, 4, 8);
    }
    if ((buttons[2].getText() == "X") &&
        (buttons[4].getText() == "X") &&
        (buttons[6].getText() == "X")) {
      xWins(2, 4, 6);
    }
    // check O win conditions
    if ((buttons[0].getText() == "O") &&
        (buttons[1].getText() == "O") &&
        (buttons[2].getText() == "O")) {
      oWins(0, 1, 2);
    }
    if ((buttons[3].getText() == "O") &&
        (buttons[4].getText() == "O") &&
        (buttons[5].getText() == "O")) {
      oWins(3, 4, 5);
    }
    if ((buttons[6].getText() == "O") &&
        (buttons[7].getText() == "O") &&
        (buttons[8].getText() == "O")) {
      oWins(6, 7, 8);
    }
    if ((buttons[0].getText() == "O") &&
        (buttons[3].getText() == "O") &&
        (buttons[6].getText() == "O")) {
      oWins(0, 3, 6);
    }
    if ((buttons[1].getText() == "O") &&
        (buttons[4].getText() == "O") &&
        (buttons[7].getText() == "O")) {
      oWins(1, 4, 7);
    }
    if ((buttons[2].getText() == "O") &&
        (buttons[5].getText() == "O") &&
        (buttons[8].getText() == "O")) {
      oWins(2, 5, 8);
    }
    if ((buttons[0].getText() == "O") &&
        (buttons[4].getText() == "O") &&
        (buttons[8].getText() == "O")) {
      oWins(0, 4, 8);
    }
    if ((buttons[2].getText() == "O") &&
        (buttons[4].getText() == "O") &&
        (buttons[6].getText() == "O")) {
      oWins(2, 4, 6);

    }

  }

  public void runMethod(){
    int L = 0;
     L++;
    do{
      game();
    turn();
    check();
    } while ( L < 0);
  }

  public void resetButton() {
    for (int i = 0; i == 8; i++) {
      buttons[i].setText("");
      buttons[i].setBackground(Color.black);
    }
  }

  private static void runGUI() {

    // sets the outlook

    JFrame.setDefaultLookAndFeelDecorated(true);

    // creates a new main

    Main TT = new Main();
  } // closes run gui

  // runs the gui fully
  public static void main(String[] args) {
    javax.swing.SwingUtilities.invokeLater(new Runnable() {
      public void run() {
        runGUI();
      }

    });

  } // closes the invoke later
} // closes the main
