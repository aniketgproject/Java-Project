import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
 
public class StudentDetail implements ActionListener 
{
    JFrame frame;
    
     String[] city={"Kanpur","Agra","Surat","Jhansi"};
    String[] state={"Andaman and Nicobar Islands","Andhra Pradesh","Arunachal Pradesh","Assam","Bihar","Chandigarh","Chhattisgarh","Dadra and Nagar Haveli and Daman and Diu","Goa","Gujurat","Haryana","Himachal Pradesh","Jammu and Kashmir","Jharkhand","Karnataka","Kerela","Ladakh","Lakshadweep","Madhya Pradesh","Maharashtra","Manipur","Meghalaya","Mizoram","Nagaland","Delhi","Odisha","Puducherry","Punjab","Rajasthan","Sikkim","Tamil Nadu","Telangana","Tripura","Uttarakhand","Uttar Pradesh","West Bengal"};
    String[] country={"India","Srilanka","USA","Australia","Germany","Russia","Nepal","Bangladesh"};
    JLabel nameLabel=new JLabel("Name");
    JLabel dobLabel=new JLabel("Date of Birth");
    JLabel ageLabel=new JLabel("Age");
    JLabel joiningLabel=new JLabel("Joining Date");
    JLabel mobileLabel=new JLabel("Mobile");
    JLabel addressLabel=new JLabel("Address");
    JLabel cityLabel=new JLabel("City");
    JLabel stateLabel=new JLabel("State");
    JLabel countryLabel=new JLabel("Country");
    JLabel classLabel=new JLabel("Class");
    JLabel collegeLabel=new JLabel("College");
    JLabel percentageLabel=new JLabel("Percentage");
    

    JTextField nameTextField=new JTextField();
    JTextField dobTextField=new JTextField();
    JTextField ageTextField=new JTextField();
    JTextField joiningTextField=new JTextField();
    JTextField mobileTextField=new JTextField();
    JTextField addressTextField=new JTextField();
    JComboBox cityComboBox=new JComboBox(city);
    JComboBox stateComboBox=new JComboBox(state);
    JComboBox countryComboBox=new JComboBox(country);
    JTextField classTextField=new JTextField();
    JTextField collegeTextField=new JTextField();
    JTextField percentageTextField=new JTextField();

    JButton addButton=new JButton("Add");
    JButton editButton=new JButton("Edit");
    JButton deleteButton=new JButton("Delete");
    JButton findButton=new JButton("Find");
    JButton saveButton=new JButton("Save");
 
 
    StudentDetail()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Registration");
        frame.setBounds(40,40,600,700);
		frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
    }
    public void setLocationAndSize()
    {
        nameLabel.setBounds(20,50,40,70);
        dobLabel.setBounds(20,100,80,70);
        ageLabel.setBounds(450,100,40,70);
        joiningLabel.setBounds(20,150,100,70);
        mobileLabel.setBounds(450,150,140,70);
        addressLabel.setBounds(20,200,500,70);
        cityLabel.setBounds(20,250,100,70);
        stateLabel.setBounds(20,300,100,70);
        countryLabel.setBounds(380,300,100,70);
        classLabel.setBounds(40,360,40,70);
        collegeLabel.setBounds(220,360,100,70);
        percentageLabel.setBounds(400,360,100,70);

        nameTextField.setBounds(180,55,165,30);
        dobTextField.setBounds(180,105,165,30);
        ageTextField.setBounds(520,105,80,30);
        joiningTextField.setBounds(180,155,165,30);
        mobileTextField.setBounds(520,155,151,30);
        addressTextField.setBounds(180,205,165,30);
        cityComboBox.setBounds(180,255,165,30);
        stateComboBox.setBounds(180,305,165,30);
        countryComboBox.setBounds(490,305,100,30);
        classTextField.setBounds(20,450,165,30);
        collegeTextField.setBounds(200,450,165,30);
        percentageTextField.setBounds(380,450,165,30);

        addButton.setBounds(20,10,70,35);
        editButton.setBounds(100,10,70,35);
        deleteButton.setBounds(180,10,70,35);
        findButton.setBounds(260,10,70,35);
        saveButton.setBounds(340,10,70,35);
    }
    public void addComponentsToFrame()
    {
        frame.add(nameLabel);
        frame.add(dobLabel);
        frame.add(ageLabel);
        frame.add(joiningLabel);
        frame.add(mobileLabel);
        frame.add(addressLabel);
        frame.add(cityLabel);
        frame.add(stateLabel);
        frame.add(countryLabel);
        frame.add(classLabel);
        frame.add(collegeLabel);
        frame.add(percentageLabel);

        frame.add(nameTextField);
        frame.add(dobTextField);
        frame.add(ageTextField);
        frame.add(joiningTextField);
        frame.add(mobileTextField);
        frame.add(addressTextField);
        frame.add(cityComboBox);
        frame.add(stateComboBox);
        frame.add(countryComboBox);
        frame.add(classTextField);
        frame.add(collegeTextField);
        frame.add(percentageTextField);
        

        frame.add(addButton);
        frame.add(editButton);
        frame.add(deleteButton);
        frame.add(findButton);
        frame.add(saveButton);
    }
    public void actionEvent()
    {
        addButton.addActionListener(this);
        editButton.addActionListener(this);
        deleteButton.addActionListener(this);
        findButton.addActionListener(this);
        saveButton.addActionListener(this);
    }
 
 
    @Override
    public void actionPerformed(ActionEvent e)
     {
        if(e.getSource()==addButton)
        {
            try {
                
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/gupta","root","qwerty");
                
                PreparedStatement Pstatement=connection.prepareStatement("insert into studentdetail values(?,?,?,?,?,?,?,?,?,?,?,?)");
               
                Pstatement.setString(1,nameTextField.getText());
                Pstatement.setString(2,dobTextField.getText());
                Pstatement.setString(3,ageTextField.getText());
                Pstatement.setString(4,joiningTextField.getText());
                Pstatement.setString(5,mobileTextField.getText());
                Pstatement.setString(6,addressTextField.getText());
                Pstatement.setString(7,cityComboBox.getSelectedItem().toString());
                Pstatement.setString(8,stateComboBox.getSelectedItem().toString());
                Pstatement.setString(9,countryComboBox.getSelectedItem().toString());
                Pstatement.setString(10,classTextField.getText());
                Pstatement.setString(11,collegeTextField.getText());
                Pstatement.setString(12,percentageTextField.getText());
                
                
                    Pstatement.executeUpdate();
                    JOptionPane.showMessageDialog(null,"Success");
               
 
            }
             catch (SQLException e1) {
                e1.printStackTrace();
            }
 
 
        }
        if(e.getSource()==deleteButton)
        {
            
            nameTextField.setText("");
            dobTextField.setText("");
            ageTextField.setText("");
            joiningTextField.setText("");
            mobileTextField.setText("");
            addressTextField.setText("");
            cityComboBox.setSelectedItem("Kanpur");
            stateComboBox.setSelectedItem("Gujrat");
            countryComboBox.setSelectedItem("India");
            classTextField.setText("");
            collegeTextField.setText("");
            percentageTextField.setText("");
			

        }

         else if(e.getSource()==addButton)
        {
            
            nameTextField.setText("");
            dobTextField.setText("");
            ageTextField.setText("");
            joiningTextField.setText("");
            mobileTextField.setText("");
            addressTextField.setText("");
            cityComboBox.setSelectedItem("Kanpur");
            stateComboBox.setSelectedItem("Gujrat");
            countryComboBox.setSelectedItem("India");
            classTextField.setText("");
            collegeTextField.setText("");
            percentageTextField.setText("");
			

        }
		
 
    }
}


