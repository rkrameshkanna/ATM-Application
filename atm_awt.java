import java.util.Scanner;
import java.nio.file.Files;
import java.io.*;
import java.nio.file.*;
import java.awt.*;
import javax.swing.*;

public class atm_awt extends JFrame {
    int position = 0, open = 1;
    JLabel title, usern, pinn;
    JTextField user, pin;
    JButton enter;
    String username, pinnum, phonenum;
    String savornot, temp, temp1, temp2;
    String accnum;
    Double bal, bal1, curbal;
    JButton bu1, bu2, bu3, bu4, bu5, bu6;

    public atm_awt() throws FileNotFoundException {
        setLayout(new BorderLayout());
        File obj1 = new File("file1.txt");
        Scanner sc1 = new Scanner(obj1);
        File obj2 = new File("file2.txt");
        Scanner sc2 = new Scanner(obj2);
        File obj3 = new File("file3.txt");
        //Scanner sc3 = new Scanner(obj3);
        File obj4 = new File("file4.txt");
        //Scanner sc4 = new Scanner(obj4);
        File obj5 = new File("file5.txt");
        //Scanner sc5 = new Scanner(obj5);
        File obj6 = new File("file6.txt");
        //Scanner sc6 = new Scanner(obj6);
        File obj7 = new File("file7.txt");
        //Scanner sc7 = new Scanner(obj7);


        bu6 = new JButton("EXIT");
        bu6.addActionListener((l) -> {
            System.exit(0);
        });
        /*JButton exit1 = new JButton("EXIT");
        exit1.addActionListener((l) -> {
            System.exit(0);
        });
        JButton exit2 = new JButton("EXIT");
        exit2.addActionListener((l) -> {
            System.exit(0);
        });
        JButton exit3 = new JButton("EXIT");
        exit3.addActionListener((l) -> {
            System.exit(0);
        });
        JButton exit4 = new JButton("EXIT");
        exit4.addActionListener((l) -> {
            System.exit(0);
        });
        JButton exit5 = new JButton("EXIT");
        exit5.addActionListener((l) -> {
            System.exit(0);
        });
        JButton exit6 = new JButton("EXIT");
        exit6.addActionListener((l) -> {
            System.exit(0);
        });
        JButton exit7 = new JButton("EXIT");
        exit7.addActionListener((l) -> {
            System.exit(0);
        });
        JButton exit8 = new JButton("EXIT");
        exit8.addActionListener((l) -> {
            System.exit(0);
        });
        JButton exit9 = new JButton("EXIT");
        exit9.addActionListener((l) -> {
            System.exit(0);
        });
        JButton exit10 = new JButton("EXIT");
        exit10.addActionListener((l) -> {
            System.exit(0);
        });*/

        // try {
        // } catch (FileNotFoundException e) {
        // System.out.println("File Error");
        // }
        JPanel p1 = new JPanel();
        p1.setLayout(new FlowLayout());
        title = new JLabel("ATM");
        usern = new JLabel("\nUSER NAME : ");
        pinn = new JLabel("\nPIN : ");
        user = new JTextField(30);
        pin = new JTextField(30);
        enter = new JButton("ENTER");
        JLabel namelab = new JLabel();

        // Panel 3 withdraw
        JPanel withdraw = new JPanel();
        JButton savingsw = new JButton("SAVINGS");
        JButton currentw = new JButton("CURRENT");
        JPanel amtpan = new JPanel();
        JLabel amtlab = new JLabel();
        JTextField getamount = new JTextField(20);
        JButton amtbut = new JButton("ENTER");
        JPanel finwith = new JPanel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();

        withdraw.add(savingsw);
        withdraw.add(currentw);
        
        //withdraw.add(exit1);
    
        //amtpan.add(exit2);
        finwith.add(label1);
        finwith.add(label2);
    
        //finwith.add(bu6);
        savingsw.addActionListener((l) -> {
            setContentPane(amtpan);
            this.revalidate();
            savornot = "Savings";
            try {
                temp1 = Files.readAllLines(Paths.get("file7.txt")).get(position);
                //System.out.println(temp1);
            } catch (IOException e) {
                System.out.println(e);
            }
            if (temp1.equals(savornot)) {
                amtpan.add(amtlab);
                amtlab.setText("ENTER THE AMOUNT TO WITHDRAW:");
                amtpan.add(getamount);
                amtpan.add(amtbut);
                amtbut.addActionListener((el) -> {
                    setContentPane(finwith);
                    this.revalidate();
                    try {
                        bal = Double.parseDouble(Files.readAllLines(Paths.get("file6.txt")).get(position));
                        //System.out.println(temp1);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    bal1 = Double.parseDouble(getamount.getText());
                    if (bal > bal1) {
                        //System.out.println("hello");
                        curbal = bal - bal1;
                        try {
                            String filePath = "file6.txt";
                            Scanner sc = new Scanner(new File(filePath));
                            StringBuffer buffer = new StringBuffer();
                            while (sc.hasNextLine()) {
                                buffer.append(sc.nextLine() + System.lineSeparator());
                            }
                            String fileContents = buffer.toString();
                            sc.close();
                            String oldLine = String.valueOf(bal);
                            String newLine = String.valueOf(curbal);
                            //System.out.println(oldLine);
                            //System.out.println(newLine);
                            fileContents = fileContents.replaceAll(oldLine, newLine);
                            FileWriter writer = new FileWriter(filePath);
                            writer.append(fileContents);
                            writer.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        label1.setText("COLLECT THE CASH");
                        label2.setText("CURRENT BALANCE=" + curbal);
                    }
                    else
                    {
                        //this.revalidate();
                        JLabel inbal=new JLabel("INSUFFICENT BALANCE");
                        finwith.add(inbal);
                    }
                });
            }
            else{
                JLabel inacc=new JLabel("INVALID ACCOUNT TYPE");
                //this.revalidate();
                amtpan.add(inacc);
            }

        });

        currentw.addActionListener((l) -> {
            setContentPane(amtpan);
            this.revalidate();
            savornot = "Current";
            try {
                temp1 = Files.readAllLines(Paths.get("file7.txt")).get(position);
                //System.out.println(temp1);
            } catch (IOException e) {
                System.out.println(e);
            }
            if (temp1.equals(savornot)) {
                amtpan.add(amtlab);
                amtlab.setText("ENTER THE AMOUNT TO WITHDRAW:");
                amtpan.add(getamount);
                amtpan.add(amtbut);
                amtbut.addActionListener((el) -> {
                    setContentPane(finwith);
                    this.revalidate();
                    try {
                        bal = Double.parseDouble(Files.readAllLines(Paths.get("file6.txt")).get(position));
                        //System.out.println(temp1);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    bal1 = Double.parseDouble(getamount.getText());
                    //System.out.println(bal1);
                    //System.out.println(bal);
                    if (bal > bal1) {
                        //System.out.println("hello");
                        curbal = bal - bal1;
                        try {
                            String filePath = "file6.txt";
                            Scanner sc = new Scanner(new File(filePath));
                            StringBuffer buffer = new StringBuffer();
                            while (sc.hasNextLine()) {
                                buffer.append(sc.nextLine() + System.lineSeparator());
                            }
                            String fileContents = buffer.toString();
                            sc.close();
                            String oldLine = String.valueOf(bal);
                            String newLine = String.valueOf(curbal);
                            fileContents = fileContents.replaceAll(oldLine, newLine);
                            FileWriter writer = new FileWriter(filePath);
                            writer.append(fileContents);
                            writer.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        label1.setText("COLLECT THE CASH");
                        label2.setText("CURRENT BALANCE=" + curbal);
                    }
                    else
                    {
                        JLabel inbal=new JLabel("INSUFFICENT BALANCE");
                        finwith.add(inbal);
                    }
                });
            }
            else{
                JLabel inacc=new JLabel("INVALID ACCOUNT TYPE");
                this.revalidate();
                amtpan.add(inacc);
            }
            //this.repaint();
        });

        // Panel 4 deposit
        JPanel deposit = new JPanel();
        JButton savingsd = new JButton("SAVINGS");
        JButton currentd = new JButton("CURRENT");
        JPanel amtpan1 = new JPanel();
        JLabel amtlab1 = new JLabel();
        JTextField getamount1 = new JTextField(20);
        JButton amtbut1 = new JButton("ENTER");
        JPanel finwith1 = new JPanel();
        JLabel label11 = new JLabel();
        JLabel label12 = new JLabel();

        deposit.add(savingsd);
        deposit.add(currentd);
    
        //deposit.add(exit3);
    
        //amtpan1.add(exit4);
        finwith1.add(label11);
        finwith1.add(label12);
    
        //finwith1.add(exit5);

        savingsd.addActionListener((l) -> {
            setContentPane(amtpan1);
            this.revalidate();
            savornot = "Savings";
            try {
                temp1 = Files.readAllLines(Paths.get("file7.txt")).get(position);
                //System.out.println(temp1);
            } catch (IOException e) {
                System.out.println(e);
            }
            if (temp1.equals(savornot)) {
                amtpan1.add(amtlab1);
                amtlab1.setText("ENTER THE AMOUNT TO DEPOSITE:");
                amtpan1.add(getamount1);
                amtpan1.add(amtbut1);
                amtbut1.addActionListener((el) -> {
                    setContentPane(finwith1);
                    this.revalidate();
                    try {
                        bal = Double.parseDouble(Files.readAllLines(Paths.get("file6.txt")).get(position));
                        //System.out.println(temp1);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    bal1 = Double.parseDouble(getamount1.getText());
                    //if (bal > bal1) {
                        //System.out.println("hello");
                        curbal = bal1 + bal;
                        try {
                            String filePath = "file6.txt";
                            Scanner sc = new Scanner(new File(filePath));
                            StringBuffer buffer = new StringBuffer();
                            while (sc.hasNextLine()) {
                                buffer.append(sc.nextLine() + System.lineSeparator());
                            }
                            String fileContents = buffer.toString();
                            sc.close();
                            String oldLine = String.valueOf(bal);
                            String newLine = String.valueOf(curbal);
                            fileContents = fileContents.replaceAll(oldLine, newLine);
                            FileWriter writer = new FileWriter(filePath);
                            writer.append(fileContents);
                            writer.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        label11.setText("THE CASH DEPOSITE SUCCUSSFULLY");
                        label12.setText("CURRENT BALANCE=" + curbal);
                    //}
                });
            }
            else{
                JLabel inacc=new JLabel("INVALID ACCOUNT TYPE");
                this.revalidate();
                amtpan1.add(inacc);
            }

        });

        currentd.addActionListener((l) -> {
            setContentPane(amtpan1);
            this.revalidate();
            savornot = "Current";
            try {
                temp1 = Files.readAllLines(Paths.get("file7.txt")).get(position);
                //System.out.println(temp1);
            } catch (IOException e) {
                System.out.println(e);
            }
            if (temp1.equals(savornot)) {
                amtpan1.add(amtlab1);
                amtlab1.setText("ENTER THE AMOUNT TO DEPOSITE:");
                amtpan1.add(getamount1);
                amtpan1.add(amtbut1);
                amtbut1.addActionListener((el) -> {
                    setContentPane(finwith1);
                    this.revalidate();
                    try {
                        bal = Double.parseDouble(Files.readAllLines(Paths.get("file6.txt")).get(position));
                        //System.out.println(temp1);
                    } catch (IOException e) {
                        System.out.println(e);
                    }
                    bal1 = Double.parseDouble(getamount1.getText());
                    //if (bal > bal1) {
                        //System.out.println("hello");
                        curbal = bal1 + bal;
                        try {
                            String filePath = "file6.txt";
                            Scanner sc = new Scanner(new File(filePath));
                            StringBuffer buffer = new StringBuffer();
                            while (sc.hasNextLine()) {
                                buffer.append(sc.nextLine() + System.lineSeparator());
                            }
                            String fileContents = buffer.toString();
                            sc.close();
                            String oldLine = String.valueOf(bal);
                            String newLine = String.valueOf(curbal);
                            fileContents = fileContents.replaceAll(oldLine, newLine);
                            FileWriter writer = new FileWriter(filePath);
                            writer.append(fileContents);
                            writer.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        label11.setText("THE CASH DEPOSITE SUCCUSSFULLY");
                        label12.setText("CURRENT BALANCE=" + curbal);
                    //}
                });
            }
            else{
                JLabel inacc=new JLabel("INVALID ACCOUNT TYPE");
                this.revalidate();
                amtpan1.add(inacc);
            }

        });

        // Panel5 balance

        JPanel balance = new JPanel();
        balance.setLayout(new BorderLayout());
        JLabel bal = new JLabel();
        balance.add(bal, BorderLayout.CENTER);
    
      //  balance.add(bu6, BorderLayout.SOUTH);
       // balance.add(exit6);

        // panel 6 change pin
        JPanel pchange = new JPanel();
        JLabel num = new JLabel("ENTER PHONE NUMBER : ");
        JTextField phone = new JTextField(20);
        JButton toinner = new JButton("ENTER");
        // inner
        JPanel inner = new JPanel();
        JLabel newpin = new JLabel("ENTER NEW PIN : ");
        JTextField pinnew = new JTextField(20);
        JLabel confpin = new JLabel("CONFIRM NEW PIN : ");
        JTextField pinconf = new JTextField(20);
        JLabel done = new JLabel();
        JButton noname = new JButton("ENTER");

        pchange.add(num);
        pchange.add(phone);
        pchange.add(toinner);
    
        //pchange.add(exit7);

    
        //inner.add(exit8);
        toinner.addActionListener((al) -> {
            setContentPane(inner);
            this.revalidate();
            phonenum = phone.getText();

            if (temp.equals(phonenum)) {
                inner.add(newpin);
                inner.add(pinnew);
                inner.add(confpin);
                inner.add(pinconf);
                inner.add(done);
                inner.add(noname);
                noname.addActionListener((ale) -> {
                try {
                    temp1 = Files.readAllLines(Paths.get("file2.txt")).get(position);
                    //System.out.println(temp1);
                } catch (IOException e) {
                    System.out.println(e);
                }


            String newnum = pinconf.getText();
            // System.out.println(newnum);
            // System.out.println(temp1);
            try {
                String filePath = "file2.txt";
                Scanner sc = new Scanner(new File(filePath));
                StringBuffer buffer = new StringBuffer();
                while (sc.hasNextLine()) {
                    buffer.append(sc.nextLine() + System.lineSeparator());
                }
                String fileContents = buffer.toString();
                sc.close();
                String oldLine = temp1;
                String newLine = newnum;// String.valueOf(newnum);
                fileContents = fileContents.replaceAll(oldLine, newLine);
                FileWriter writer = new FileWriter(filePath);
                writer.append(fileContents);
                writer.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            inner.remove(noname);
            done.setText("PIN CHANGED SUCCESFULLY!");
        });
            }
            else
            {
                JLabel inacc=new JLabel("INVALID MOBILE NUMBER");
                this.revalidate();
                inner.add(inacc);   
            }
        });

        // panel 7 change num
        JPanel nchange = new JPanel();
        JLabel acc = new JLabel("ENTER ACCOUNT NUMBER:");
        JTextField accno = new JTextField(20);
        JButton goinner = new JButton("ENTER");
        JPanel mobinner = new JPanel();
        JLabel newmob = new JLabel("ENTER NEW MOBILE NUMBER : ");
        JTextField mobnew = new JTextField(20);
        JLabel chnum = new JLabel();
        JButton mobbut = new JButton("ENTER");

        nchange.add(acc);
        nchange.add(accno);
        nchange.add(goinner);
    
        //nchange.add(exit9);
    
        //mobinner.add(exit10);

        // Panel 2
        JPanel pan2 = new JPanel();
        pan2.setLayout(new FlowLayout());
        bu1 = new JButton("WITHDRAW");
        bu2 = new JButton("CASH DEPOSIT");
        bu3 = new JButton("CHECK BALANCE");
        bu4 = new JButton("CHANGE PIN");
        bu5 = new JButton("CHANGE MOBILE NUM");

        bu1.addActionListener((l) -> {
            setContentPane(withdraw);
            this.revalidate();
            //withdraw.repaint();
            try {
                temp = Files.readAllLines(Paths.get("file7.txt")).get(position);
            } catch (IOException e) {
                System.out.println(e);
            }
            //if (temp.equals(savornot)) {
                // ..
            //}
            //this.repaint(); 
        });

        bu2.addActionListener((l) -> {
            this.setContentPane(deposit);
            //this.repaint();
            this.revalidate();
            String temp = "";
            try {
                temp = Files.readAllLines(Paths.get("file7.txt")).get(position);
            } catch (IOException e) {
                System.out.println(e);
            }
            //if (temp.equals(savornot)) {
                // ..
            //}

        });

        bu3.addActionListener((l) -> {
            setContentPane(balance);
            this.revalidate();

            String temp = "";
            try {
                temp = Files.readAllLines(Paths.get("file6.txt")).get(position);
            } catch (IOException e) {
                System.out.println(e);
            }

            bal.setText("CURRENT BALANCE " + temp);

        });

        bu4.addActionListener((l) -> {
            setContentPane(pchange);
            this.revalidate();

            try {
                temp = Files.readAllLines(Paths.get("file5.txt")).get(position);
                //System.out.println(temp);
            } catch (IOException e) {
                System.out.println(e);
            }

            
        });

        bu5.addActionListener((l) -> {
            setContentPane(nchange);
            this.revalidate();
            
            goinner.addActionListener((ll) -> {
                setContentPane(mobinner);
                this.revalidate();
                accnum = accno.getText();
                //System.out.println("hgfdserty");
                try {
                    temp2 = Files.readAllLines(Paths.get("file3.txt")).get(position);
                    System.out.println(temp2);
                } catch (IOException e) {
                    System.out.println(e);
                }
                
                //System.out.println(temp2);
                //System.out.println(accnum);

                if (temp2.equals(accnum)) {
                    mobinner.add(newmob);
                    mobinner.add(mobnew);
                    mobinner.add(chnum);
                    mobinner.add(mobbut);

                mobbut.addActionListener((all) -> {
                        String temp1 = "";
                        try {
                            temp1 = Files.readAllLines(Paths.get("file5.txt")).get(position);
                        } catch (IOException e) {
                            System.out.println(e);
                        }
                        String newnum = mobnew.getText();
                        //System.out.println(temp1);
                        //System.out.println(newnum);
                        try {
                            String filePath = "file5.txt";
                            Scanner sc = new Scanner(new File(filePath));
                            StringBuffer buffer = new StringBuffer();
                            while (sc.hasNextLine()) {
                                buffer.append(sc.nextLine() + System.lineSeparator());
                            }
                            String fileContents = buffer.toString();
                            sc.close();
                            String oldLine = temp1;
                            String newLine = String.valueOf(newnum);
                            fileContents = fileContents.replaceAll(oldLine, newLine);
                            FileWriter writer = new FileWriter(filePath);
                            writer.append(fileContents);
                            writer.flush();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        mobinner.remove(mobbut);
                        chnum.setText("MOBILE NUMBER CHANGED SUCCESFULLY!");
                });
            }
            else
            {
                JLabel inacc=new JLabel("INVALID ACCOUNT NUMBER");
                this.revalidate();
                mobinner.add(inacc);   
            }
            });
        });
        pan2.add(namelab);
        pan2.add(bu1);
        pan2.add(bu2);
        pan2.add(bu3);
        pan2.add(bu4);
        pan2.add(bu5);
    
        pan2.add(bu6);

        // Button Listener
        enter.addActionListener((e) -> {
            this.username = user.getText();
            this.pinnum = pin.getText();

            int a=0;
            while (sc1.hasNextLine() && sc2.hasNextLine()) {
                if ((username.equals(sc1.nextLine()))) {
                    a=1;
                    break;
                }
                position++;
            }

            String tempuser = "", temppin = "";
            try {
                tempuser = Files.readAllLines(Paths.get("file1.txt")).get(position);
                temppin = Files.readAllLines(Paths.get("file2.txt")).get(position);
            } catch (IOException ie) {
                System.out.println(ie);
            } catch (IndexOutOfBoundsException aoe) {
                JOptionPane.showMessageDialog(this, "No user found", "Information", JOptionPane.INFORMATION_MESSAGE);
            }
            if(a==1)
            {
                if (tempuser.equals(username) && temppin.equals(pinnum) && open == 1) {
                    setContentPane(pan2);
                    this.revalidate();
                    try {
                        String name = Files.readAllLines(Paths.get("file4.txt")).get(position);
                        namelab.setText("WELCOME : " + name);
                    } catch (IOException ie) {
                        System.out.println(ie);
                    }
                }
            }
            else{
            JLabel error = new JLabel("INVALID USER");
            this.revalidate();
            add(error);
            }
        });

        add(title, BorderLayout.NORTH);
        p1.add(usern);
        p1.add(user);
        p1.add(pinn);
        p1.add(pin);
        add(enter, BorderLayout.SOUTH);

        add(p1, BorderLayout.CENTER);
    }

    public static void main(String[] args) throws FileNotFoundException {
        atm_awt obj = new atm_awt();
        obj.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        obj.setVisible(true);
        obj.setSize(new Dimension(500, 500));
        obj.setLocationRelativeTo(null);
        obj.setResizable(true);
    }

}