import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUI extends JFrame {

    private Dimension ScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private Dimension ApplicationSize = new Dimension(520, 310);
    private shop myShop = new shop();
    private JButton buttonMaxPrice = new JButton("max price");
    private JButton buttonPopularBrand = new JButton("popular brand");
    private JButton buttonSetTime = new JButton("set time");
    private JTextField inputTypeArrow = new JTextField("", 5);
    private JTextField inputTimeValue = new JTextField("", 5);
    private DefaultListModel<String> datalist = new DefaultListModel< >();
    private JList<String> list = new JList<>(datalist);

    private JPanel dataPanel = new JPanel();
    private JPanel inputPanel = new JPanel();

    private JPanel buttonsPanel = new JPanel();
    private JScrollPane scrollPanel = new JScrollPane(new JList(datalist));

    public GUI(){
        super("Main application");
        this.setSize(ApplicationSize.width, ApplicationSize.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container container = this.getContentPane();
        this.setResizable(false);

        container.setLayout(new GridLayout(2,1));
        container.add(scrollPanel);
        container.add(inputPanel);

        inputPanel.add(inputTypeArrow);
        inputPanel.add(inputTimeValue);

        inputPanel.add(buttonsPanel);

        buttonsPanel.add(buttonMaxPrice);
        buttonsPanel.add(buttonSetTime);
        buttonsPanel.add(buttonPopularBrand);

        inputPanel.setLayout(new GridLayout(1, 2));
        buttonsPanel.setLayout(new GridLayout(3, 1));

        buttonMaxPrice.addActionListener(new btnEventListener());
        buttonPopularBrand.addActionListener(new btnEventListener());
        buttonSetTime.addActionListener(new btnEventListener());

        this.setLocation((int) (ScreenSize.width * 0.5 - ApplicationSize.width * 0.5),
                (int) (ScreenSize.height * 0.5 - ApplicationSize.height * 0.5));
    }
    public void fillList(shop s) {
        for(int i = 0; i < s.list.size(); i++){
            datalist.addElement(s.list.get(i).toString());
        }
    }
    public void clearList() {datalist.clear();}
    public void delFromList() {
        datalist.remove(list.getSelectedIndex());
    }
    class btnEventListener implements ActionListener {
        public Clock_int.types_arrow parseArrow(String str) {
            if (str.equals("H") || str.equals("Hours")) {
                return Clock_int.types_arrow.H;
            }
            else if (str.equals("M") || str.equals("Minutes")) {
                return Clock_int.types_arrow.M;
            }
            else if (str.equals("S") || str.equals("Seconds")) {
                return Clock_int.types_arrow.S;
            }
            throw new ArrayStoreException("Enter only \"H(Hours), M(Minutes), S(Seconds)\"");
        }
        public void actionPerformed(ActionEvent event) {
            if(event.getActionCommand().equals("max price")) {
                String output = String.valueOf(myShop.getMaxCost());
                JOptionPane.showMessageDialog(null, output, "Price", JOptionPane.PLAIN_MESSAGE);
            }
            if(event.getActionCommand().equals("popular brand")) {
                String message = myShop.getMaxCountName();
                JOptionPane.showMessageDialog(null, message, "Brand", JOptionPane.PLAIN_MESSAGE);
            }
            if(event.getActionCommand().equals("set time")) {
                try {
                    Clock_int.types_arrow temp1 = parseArrow(inputTypeArrow.getText());
                    int temp2 = Integer.parseInt(inputTimeValue.getText());
                    if(temp1 == Clock_int.types_arrow.H){
                        myShop.setTimeAllClocks(temp1, temp2);
                    }
                    if(temp1 == Clock_int.types_arrow.M){
                        myShop.setTimeAllClocks(temp1, temp2);
                    }
                    if(temp1 == Clock_int.types_arrow.S){
                        myShop.setTimeAllClocks(temp1, temp2);
                    }
                    datalist.clear();
                    for(int i = 0; i < myShop.list.size(); i++){
                        datalist.addElement(myShop.list.get(i).toString());
                    }
                }
                catch (Exception exc) {
                    JOptionPane.showMessageDialog(null, exc, "Error", JOptionPane.PLAIN_MESSAGE);
                }

            }

        }
    }
}
