package employee.management.system;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class AddEmployee extends JFrame implements ActionListener {

    Random ran = new Random();

    int number = ran.nextInt(999999);

    JTextField tname,tfname,taddress,tphone,taadhar,temail,tsalary,tdesignation;

    JLabel tempid;

    JDateChooser tdob;

    JButton add,back;

    JComboBox Boxeducation;

    AddEmployee(){

        getContentPane().setBackground(new Color(163,255,188));

        JLabel heading = new JLabel("Add Emplopyee Detail");
        heading.setBounds(320,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,25));
        add(heading);


        JLabel name = new JLabel("Name");
        name.setBounds(50,120,150,30);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(name);


        tname = new JTextField();
        tname.setBounds(150,120,150,30);
        tname.setBackground(new Color(177,252,197));
        add(tname);


        JLabel fname = new JLabel("Father's Name");
        fname.setBounds(400,120,150,30);
        fname.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(fname);


        tfname = new JTextField();
        tfname.setBounds(600,120,150,30);
        tfname.setBackground(new Color(177,252,197));
        add(tfname);


        JLabel dob = new JLabel("D.O.B");
        dob.setBounds(50,200,150,30);
        dob.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(dob);


        tdob = new JDateChooser();
        tdob.setBounds(150,200,150,30);
        tdob.setBackground(new Color(177,252,197));
        add(tdob);


        JLabel salary = new JLabel("Salary");
        salary.setBounds(400,200,150,30);
        salary.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(salary);


        tsalary = new JTextField();
        tsalary.setBounds(600,200,150,30);
        tsalary.setBackground(new Color(177,252,197));
        add(tsalary);


        JLabel address = new JLabel("Address");
        address.setBounds(50,280,150,30);
        address.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(address);


        taddress = new JTextField();
        taddress.setBounds(150,280,150,30);
        taddress.setBackground(new Color(177,252,197));
        add(taddress);


        JLabel phone = new JLabel("Phone No.");
        phone.setBounds(400,280,150,30);
        phone.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(phone);


        tphone = new JTextField();
        tphone.setBounds(600,280,150,30);
        tphone.setBackground(new Color(177,252,197));
        add(tphone);


        JLabel email = new JLabel("Email");
        email.setBounds(50,365,150,30);
        email.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(email);


        temail = new JTextField();
        temail.setBounds(150,365,150,30);
        temail.setBackground(new Color(177,252,197));
        add(temail);


        JLabel education = new JLabel("Highest Education");
        education.setBounds(400,365,150,30);
        education.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(education);


        String items[] = {"BBA", "B.TECH" , "BCA" , "B.A" , "B.SC" , "B.COM" , "MBA" , "MCA" , "M.A" , "M.TECH" , "M.SC" , "PHD"};
        Boxeducation = new JComboBox(items);
        Boxeducation.setBackground(new Color(177,252,197));
        Boxeducation.setBounds(600,365,150,30);
        add(Boxeducation);


        JLabel aadhaar = new JLabel("Aadhaar No.");
        aadhaar.setBounds(400,445,150,30);
        aadhaar.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(aadhaar);


        taadhar = new JTextField();
        taadhar.setBounds(600,445,150,30);
        taadhar.setBackground(new Color(177,252,197));
        add(taadhar);


        JLabel empid = new JLabel("Employee ID");
        empid.setBounds(740,15,150,30);
        empid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(empid);


        tempid = new JLabel(""+number);
        tempid.setBounds(770,40,150,30);
        tempid.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        tempid.setForeground(Color.RED);
        add(tempid);


        JLabel designation = new JLabel("Design...");
        designation.setBounds(50,445,150,30);
        designation.setFont(new Font("SAN_SERIF",Font.BOLD,20));
        add(designation);


        tdesignation = new JTextField();
        tdesignation.setBounds(150,445,150,30);
        tdesignation.setBackground(new Color(177,252,197));
        add(tdesignation);

        add = new JButton("ADD");
        add.setBounds(440,540,150,35);
        add.setBackground(Color.WHITE);
        add.addActionListener(this);
        add(add);

        back = new JButton("BACK");
        back.setBounds(240,540,150,35);
        back.setBackground(Color.WHITE);
        back.addActionListener(this);
        add(back);





        setSize(900,650);
        setLayout(null);
        setLocation(300,100);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == add) {
            String name = tname.getText();
            String fname = tfname.getText();
            String dob = ((JTextField)tdob.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String address = taddress.getText();
            String aadhaar = taadhar.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String) Boxeducation.getSelectedItem();
            String designation = tdesignation.getText();
            String empID = tempid.getText();

            try{
                conn c = new conn();
                String query = "insert into employee values('"+name+"' , '"+fname+"' , '"+dob+"' , '"+salary+"' , '"+address+"' , '"+phone+"' , '"+email+"' , '"+education+"' , '"+designation+"' , '"+aadhaar+"' , '"+empID+"')";
                c.statement.executeUpdate(query);
                JOptionPane.showMessageDialog(null,"Detail Added Successfully");
                setVisible(false);
                new Main_class();

            }catch (Exception E){
                E.printStackTrace();
            }


        }else {
            setVisible(false);
            new Main_class();
        }
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}
