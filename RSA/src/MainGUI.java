import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI  extends JFrame implements ActionListener {
    //allows us to get the message and use it in the encryption process
    public static String Message;
    public static String MessageToEncrypt(String m) {
        Message = m;
        return m;
    }

    //initialise new variables
    JLabel MainFrameMessage,invalidOutput, DisplaySolution, DisplayDecryptedMessage;

    JTextField MessageEncrypt;
    MainGUI () {

        //Creates the main frame
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(350, 200);
        this.setLayout(new FlowLayout());
        this.setLocation(250, 50);

        //new instance of JButton the button Submit
        JButton Submit = new JButton("Submit");
        //makes a new instance of MainFrameMessage with specified text for it to display
        MainFrameMessage = new JLabel("Please Input the message you would like to send to Bob");


        MessageEncrypt = new JTextField();
        //sets the Columns for MessageEncrypt text field
        MessageEncrypt.setColumns(25);
        //sets up an actionListener for MessageEncrypt
        MessageEncrypt.addActionListener(this);


        //adds welcome to the frame
        add(MainFrameMessage,BorderLayout.NORTH);

        //add the MessageEncrypt text field to the main frame
        add(MessageEncrypt,BorderLayout.CENTER);

        //add the Submit to the main frame
        add(Submit,BorderLayout.SOUTH);

        //makes everything visible on that frame
        setVisible(true);


        //new instance for invalidOutput
        invalidOutput = new JLabel();

        //Creates a Frame if an invalid input occurs
        JFrame invalidFrame = new JFrame("Invalid Input");
        invalidFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        invalidFrame.setSize(250, 150);
        invalidFrame.setLayout(new FlowLayout());
        invalidFrame.setLocation(250, 50);


        //new instance of JLabel, JTextField and JButton
        DisplaySolution = new JLabel();

        DisplayDecryptedMessage = new JLabel();

        //Creates a new frame called OutputFrame
        JFrame OutputFrame = new JFrame("OutputFrame");
        OutputFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        OutputFrame.setSize(800, 500);
        OutputFrame.setLayout(new FlowLayout());
        OutputFrame.setLocation(250, 50);

        //creates an ActionListener for the button submit, so when the button is pressed it can perform what it is meant to perform
        Submit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //checks if the correct button is pressed
                if(e.getActionCommand().equals("Submit")){
                    //gets the message the user inputted and saves it to message
                    Message = MessageEncrypt.getText();
                    //checks if the message is not empty
                    if(!Message.isEmpty()){

                        //sets DisplaySolution to the output from the function information from KeyGen
                        DisplaySolution.setText(KeyGen.information());
                        //adds the DisplaySolution to the OutputFrame
                        OutputFrame.add(DisplaySolution,BorderLayout.NORTH);

                        //sets the text for DisplayDecryptedMessage to be the decrypted message from RSADecryption.Decrypt()
                        DisplayDecryptedMessage.setText(" The message bob will see after decryption is:  "+ String.valueOf(RSADecryption.Decrypt()));
                        //sets DisplayDecryptedMessage colour to red so the result can be distinguished from the working out as
                        //bob would only see the message and not the method but as it is a prototype we have included the working out for our RSA system
                        DisplayDecryptedMessage.setForeground(Color.RED);

                        //adds the DisplayDecryptedMessage to the OutputFrame
                        OutputFrame.add(DisplayDecryptedMessage,BorderLayout.SOUTH);

                        //makes everything visible on the OutputFrame
                        OutputFrame.setVisible(true);


                    }
                    else{
                        //sets text for invalidOutput
                        invalidOutput.setText("Please Enter Valid Text");
                        //adds the invalidOutput to InvalidFrame
                        invalidFrame.add(invalidOutput);
                        //makes all buttons, labels, text fields visible on the invalidFrame
                        invalidFrame.setVisible(true);
                    }
                }
            }
        });
    }
    public static void main(String[] args) {
        //invoke later passes a new runnable object to it which creates a new Main() object and allows the GUI And App to run together
        SwingUtilities.invokeLater(() -> new MainGUI());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
