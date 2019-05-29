import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Main {
    private static final String ENG_CHARS_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final String RUS_CHARS_STRING = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯабвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private static final String NUM_CHARS_STRING = "123457890";
    private static final String SPECIAL_CHARS_STRING = "`-=~!@#$%^&*()_+\\|/,.";
    private JRadioButton englishRadioButton;
    private JRadioButton russianRadioButton;
    private JRadioButton numbersRadioButton;
    private JRadioButton specialRadioButton;
    private JButton generateMeButton;
    private JTextField charLen;
    private JTextArea textWillBeThereTextArea;
    private JPanel mainPanel;


    public Main() {


        generateMeButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (englishRadioButton.isSelected()) generateEnglish();
                if (russianRadioButton.isSelected()) generateRussian();
                if (numbersRadioButton.isSelected()) generateNumbers();
                if (specialRadioButton.isSelected()) generateSpecial();
                super.mouseClicked(e);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Text generator");
        frame.setContentPane(new Main().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    void setText(String param) {
        int count = Integer.parseInt(charLen.getText());
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * param.length());
            builder.append(param.charAt(character));
        }
        textWillBeThereTextArea.setText(builder.toString());
    }

    void generateEnglish() {
        setText(ENG_CHARS_STRING);
    }

    void generateRussian() {
        setText(RUS_CHARS_STRING);
    }

    void generateNumbers() {
        setText(NUM_CHARS_STRING);
    }

    void generateSpecial() {
        setText(SPECIAL_CHARS_STRING);
    }

}
