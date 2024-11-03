import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calc implements ActionListener{

    JFrame frame;
    JTextField textfield;
    JButton[] numberButton = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JButton addButton,subButton,mulButton,divButton;
    JButton decButton,equButton,delButton,clrButton,negButton;
    JPanel panel;

    double num1=0,num2=0,result=0;
    char operator;


    Calc(){

        frame =new JFrame("calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);


        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setEditable(false);


        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        decButton = new JButton(".");
        equButton = new JButton("=");
        delButton = new JButton("DELETE");
        clrButton = new JButton("clr");
        negButton = new JButton("-");
        
        functionButtons[0]=addButton;
        functionButtons[1]=subButton;
        functionButtons[2]=mulButton;
        functionButtons[3]=divButton;
        functionButtons[4]=decButton;
        functionButtons[5]=equButton;
        functionButtons[6]=delButton;
        functionButtons[7]=clrButton;
        functionButtons[8]=negButton;

        for(int i=0;i<9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFocusable(false);
        }

        for(int i=0;i<10;i++){
            numberButton[i] = new JButton(String.valueOf(i));
            numberButton[i].addActionListener(this);
            numberButton[i].setFocusable(false);
        }
        negButton.setBounds(50,430,100,50);
        delButton.setBounds(150,430,100,50);
        clrButton.setBounds(250,430,100,50);


        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        
        panel.add(numberButton[1]);
        panel.add(numberButton[2]);
        panel.add(numberButton[3]);
        panel.add(addButton);

        panel.add(numberButton[4]);
        panel.add(numberButton[5]);
        panel.add(numberButton[6]);
        panel.add(subButton);
        panel.add(numberButton[7]);
        panel.add(numberButton[8]);
        panel.add(numberButton[9]);
        panel.add(mulButton);
        panel.add(decButton);
        panel.add(numberButton[0]);
        panel.add(equButton);
        panel.add(divButton);


        frame.add(panel);
        frame.add(negButton);
        frame.add(delButton);
        frame.add(clrButton);
        frame.add(textfield);
        frame.setVisible(true);


    }


    public static void main(String [] args){
        Calc Calc = new Calc();
    }



    public void actionPerformed(ActionEvent e){

        for(int i=0;i<10;i++) {
			if(e.getSource() == numberButton[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
        if (e.getSource()==decButton) {
            textfield.setText(textfield.getText().concat("."));
            
        }
        if (e.getSource()==addButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '+';
            textfield.setText("");
            
        }
        if (e.getSource()== subButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '-';
            textfield.setText("");
            
        }

        if (e.getSource()==mulButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '*';
            textfield.setText("");
            
        }

        if (e.getSource()==divButton) {
            num1 = Double.parseDouble(textfield.getText());
            operator = '/';
            textfield.setText("");
            
        }
        

        if (e.getSource()==equButton) {
            num2 = Double.parseDouble(textfield.getText());
            
            switch (operator) {
                case '+':
                    result=num1+num2;
                    break;
                case '-':
                    result=num1-num2;
                    break;
                case '*':
                    result=num1*num2;
                    break;
                case '/':
                    result=num1/num2;
                    break;
                default:
                    break;
            }
            textfield.setText(String.valueOf(result));
            num1=result;
            
        }
        if(e.getSource()==clrButton){
            textfield.setText(null);
        }
        if (e.getSource()==delButton) {
            String String =textfield.getText();
            textfield.setText("");
            for(int i=0;i<String.length()-1;i++){
                textfield.setText(textfield.getText()+String.charAt(i));
            }
            
        }
        if(e.getSource()==negButton){
            Double temp = Double.parseDouble(textfield.getText());
            temp*=-1;
            textfield.setText(String.valueOf(temp));
        }

    }

}
