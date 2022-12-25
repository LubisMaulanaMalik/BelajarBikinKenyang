package tp11;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class FRAMETP11_1301204222 extends JFrame{
    
    private JLabel label_TODOS = new JLabel("TODOS");
    private JLabel label_list = new JLabel("My To-Do-List");
    private JList<String> jlist;
    private JTextField textfield = new JTextField();
    private JScrollPane scroll;
    private JScrollBar scrollBar;
    private JButton btnAdd = new JButton("ADD");
    private JButton btnDelete = new JButton("Delete");
    private DefaultListModel dList = new DefaultListModel();
    private DefaultTableModel mt;
    private JTable tbl;
    
    public FRAMETP11_1301204222(){
        super("TP MODUL 13");
        this.setSize(400, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setLayout(null);
        
        //Label TODOS
        label_TODOS.setFont(new Font("Times New Roman", Font.BOLD, 38));
        label_TODOS.setBounds(125, 35, 190, 40);
        
        //Membuat scroll dalam textfield
        scroll = new JScrollPane(textfield);
        scroll.setSize(250, 40);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        scroll.setLocation(35, 80);
        
        //mengatur ukuran dan posisi tombol add
        btnAdd.setSize(75, 30);
        btnAdd.setLocation(290, 80);

        //Label yang diatas JList
        label_list.setFont(new Font("Times New Roman",0 , 12));
        label_list.setBounds(35, 145, 200, 15);
        
        //Membuat jlist
        jlist = new JList(dList);
        jlist.setSize(250, 200);
        jlist.setLocation(35, 160);
        
        //mengatur ukuran dan posisi tombol delete
        btnDelete.setSize(75, 30);
        btnDelete.setLocation(290, 160);
        
        //Buat tabel
        mt = new DefaultTableModel();
        mt.setColumnIdentifiers(new Object[]{"Username","Paswword"});
        tbl = new JTable(mt);
        tbl.setSize(330, 200);
        tbl.setLocation(35, 400);
        
        //menambahkan komponen ke frame
        this.add(label_TODOS);
        this.add(scroll);
        this.add(btnAdd);
        this.add(label_list);
        this.add(jlist);
        this.add(btnDelete);
        this.add(tbl);
        
        //command kalau tombol ADD diklik
        
        btnAdd.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                if (textfield.getText().equals("")){
                    JOptionPane.showMessageDialog(null, "Tidak ada task yang ditambahkan");
                }else{
                    String str = String.valueOf(textfield.getText());
                    dList.addElement(str);
                    mt.addRow(new Object[]{str, "00"});
                    textfield.setText("");
                    JOptionPane.showMessageDialog(null, "Task berhasil ditambahkan");
                }
            }
        });
        
        //command kalau tombol Delete diklik
        btnDelete.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                int ind = jlist.getSelectedIndex();
                dList.remove(ind);
            }
        });
        
        this.show();
    }
    
    public static void main(String[] args) {
        new FRAMETP11_1301204222();
    }
}