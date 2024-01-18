import java.util.Scanner;
import java.io.*;
import java.nio.file.*;
import java.awt.*;
import javax.swing.*;

import sqlpack.sqlclass;

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

    sqlclass newobj=new sqlclass();

    public atm_awt() throws FileNotFoundException {
        setLayout(new BorderLayout());

        bu6 = new JButton("EXIT");
        bu6.addActionListener((l) -> {
            System.exit(0);
        });
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
        finwith.add(label1);
        finwith.add(label2);
    
        savingsw.addActionListener((l) -> {
            setContentPane(amtpan);
            this.revalidate();
            savornot = "Savings";
            try {
                temp1=newobj.query_results("account_type", username);
            } catch (Exception e) {
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
                        
                        bal=Double.parseDouble(newobj.query_results("balance", username));
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    bal1 = Double.parseDouble(getamount.getText());
                    if (bal > bal1) {
                        curbal = bal - bal1;
                        try {
                            newobj.update_values("balance",String.valueOf(curbal),username);
                        } catch (Exception e) {
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
                this.revalidate();
                amtpan.add(inacc);
            }

        });

        currentw.addActionListener((l) -> {
            setContentPane(amtpan);
            this.revalidate();
            savornot = "Current";
            try {
                temp1=newobj.query_results("account_type", username);
            } catch (Exception e) {
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
                        bal=Double.parseDouble(newobj.query_results("balance", username));
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    bal1 = Double.parseDouble(getamount.getText());
                    if (bal > bal1) {
                        curbal = bal - bal1;
                        try {
                            newobj.update_values("balance",String.valueOf(curbal),username);
                        } catch (Exception e) {
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
    
        finwith1.add(label11);
        finwith1.add(label12);

        savingsd.addActionListener((l) -> {
            setContentPane(amtpan1);
            this.revalidate();
            savornot = "Savings";
            try {
                temp1=newobj.query_results("account_type", username);
            } catch (Exception e) {
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
                        bal=Double.parseDouble(newobj.query_results("balance", username));
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    bal1 = Double.parseDouble(getamount1.getText());
                    curbal = bal1 + bal;
                    try {
                        newobj.update_values("balance",String.valueOf(curbal),username);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    label11.setText("THE CASH DEPOSITE SUCCUSSFULLY");
                    this.revalidate();
                    label12.setText("CURRENT BALANCE=" + curbal);
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
                temp1=newobj.query_results("account_type", username);
            } catch (Exception e) {
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
                        bal=Double.parseDouble(newobj.query_results("balance", username));
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    bal1 = Double.parseDouble(getamount1.getText());
                    curbal = bal1 + bal;
                    try {
                        newobj.update_values("balance",String.valueOf(curbal),username);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    label11.setText("THE CASH DEPOSITE SUCCUSSFULLY");
                    this.revalidate();
                    label12.setText("CURRENT BALANCE=" + curbal);
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
                    temp1=newobj.query_results("password", username);
                } catch (Exception e) {
                    System.out.println(e);
                }


            String newnum = pinconf.getText();
            try {
                newobj.update_values("password",String.valueOf(newnum),username);
            } catch (Exception e) {
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
                temp=newobj.query_results("account_type", username);
            } catch (Exception e) {
                System.out.println(e);
            }
            //this.repaint(); 
        });

        bu2.addActionListener((l) -> {
            this.setContentPane(deposit);
            //this.repaint();
            this.revalidate();
            String temp = "";
            try {
                temp=newobj.query_results("account_type", username);
            } catch (Exception e) {
                System.out.println(e);
            }

        });

        bu3.addActionListener((l) -> {
            setContentPane(balance);
            this.revalidate();

            String temp = "";
            try {
                temp=newobj.query_results("balance", username);
            } catch (Exception e) {
                System.out.println(e);
            }

            bal.setText("CURRENT BALANCE " + temp);

        });

        bu4.addActionListener((l) -> {
            setContentPane(pchange);
            this.revalidate();

            try {
                temp=newobj.query_results("phone_number", username);
            } catch (Exception e) {
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
                try {
                    temp2=newobj.query_results("account_number", username);
                } catch (Exception e) {
                    System.out.println(e);
                }
                
                if (temp2.equals(accnum)) {
                    mobinner.add(newmob);
                    mobinner.add(mobnew);
                    mobinner.add(chnum);
                    mobinner.add(mobbut);

                mobbut.addActionListener((all) -> {
                        String temp1 = "";
                        try {
                            temp1=newobj.query_results("phone_number", username);
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                        String newnum = mobnew.getText();
                        try {
                            newobj.update_values("phone_number",String.valueOf(newnum),username);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        mobinner.remove(mobbut);
                        this.revalidate();
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
            
            a=newobj.finduser(username, pinnum);
            
            if(a==1)
            {
                setContentPane(pan2);
                this.revalidate();
                try {
                    String name=newobj.query_results("name", username);
                    namelab.setText("WELCOME : " + name);
                } catch (Exception ie) {
                    System.out.println(ie);
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