import javax.swing.*;
import javax.swing.event.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;

class cityJFrame extends JFrame implements ListSelectionListener{
    private JLabel findMt;
    private JList<String> lst;
    private JPanel cityPane;
    private JTextArea txtShow;
    private JScrollPane jsp;
    private String[] city = {"台北", "宜蘭", "桃園", "台中", "南投"};
    cityJFrame(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("找各地名山");
        setBounds(50, 50, 300, 300);
        setLayout(null);

        findMt = new JLabel("找各地名山:");
        add(findMt);
        findMt.setBounds(50, 10, 100, 100);

        //list
        lst = new JList<>();
        lst.setListData(city);
        lst.setVisibleRowCount(4);
        cityPane = new JPanel();
        add(cityPane);
        cityPane.setBounds(120, 40, 80, 80);
        cityPane.add(lst);
        lst.addListSelectionListener(this); //事件傾聽

        //textArea
        String str = "可選取地名...";
        txtShow = new JTextArea(str);
        txtShow.setLineWrap(true); //文字自動換行
        jsp = new JScrollPane(txtShow, ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jsp.setBounds(30, 130, 200, 100);
        add(jsp);

        setVisible(true);
    }

    @Override
    public void valueChanged(ListSelectionEvent e){    
        for(String s : city){
            if(lst.getSelectedValuesList().contains((String)s)){
                switch (s) {
                    case "台北":
                        txtShow.setText(s+"名山 : 台北山");
                        break;
                    case "宜蘭":
                        txtShow.setText(s+"名山 : 宜蘭山");
                    case "桃園":
                        txtShow.setText(s+"名山 : 桃園山");
                    case "台中":
                        txtShow.setText(s+"名山 : 台中山");
                    case "南投":
                        txtShow.setText(s+"名山 : 南投山");
                    default:
                        break;
                }
            }
        }
    }
}

public class hw_city{
    public static void main(String[] args) {
        cityJFrame cj = new cityJFrame();
    }
}
