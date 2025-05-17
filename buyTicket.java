import javax.print.attribute.standard.DateTimeAtCompleted;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class buyTicket extends JFrame implements ActionListener  {
    
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19;
	   
	JButton b1,b2,b3,b4;

    JPanel P1,P2,P3,P4;

    JComboBox c1,c2,c3,c4,c5,c6;


    

    public buyTicket()
    {
        super("ticket buy");
        this.setSize(750,510);
        setLocationRelativeTo(null);
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    // panels
       
        P1 = new JPanel();
        P1.setBounds(0,0,750,50);
        P1.setBackground(new Color(118,113,113));
        P1.setBorder(BorderFactory.createLineBorder(Color.black));
        P1.setLayout(null);


        P2 = new JPanel();
        P2.setBounds(0,50,750,460);
        P2.setBackground(new Color(216,228,250));
        P2.setBorder(BorderFactory.createLineBorder(Color.black));
        P2.setLayout(null);


		P3 = new JPanel();
        P3.setBounds(0,50,750,460);
        P3.setBackground(new Color(216,228,250));
        P3.setBorder(BorderFactory.createLineBorder(Color.black));
        P3.setLayout(null);

       


    //panel 1 component

       l1 = new JLabel("Moviebuzz");
       l1.setFont(new Font("Serif",Font.ITALIC | Font.BOLD,36));
       l1.setForeground(Color.ORANGE);
       l1.setBounds(20,6,180,35);
       P1.add(l1);

       l2 = new JLabel(". . . Enjoy your show");
       l2.setFont(new Font("Serif",Font.ITALIC | Font.BOLD,12));
       l2.setForeground(Color.orange);
       l2.setBounds(190,27,150,15);
       P1.add(l2);
 



      


// panel 2 component 

	  // button
       b1 = new JButton("Continue");
       b1.setFont(new Font("Serif",Font.BOLD,26));
	   b1.setBounds(550,410,160,38);
       b1.setBackground(Color.ORANGE);
	   b1.addActionListener(this);
	   b1.setFocusable(false);
       b1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	   P2.add(b1);  
     
       b2 = new JButton("Back");
       b2.setFont(new Font("Serif",Font.BOLD,22));
	   b2.setBounds(30,415,100,34);
       b2.setBackground(Color.ORANGE);
	   b2.addActionListener(this);
	   b2.setFocusable(false);
       b2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	   P2.add(b2);


     //label
       l3 = new JLabel("    Grab your ticket now !");
       l3.setFont(new Font("Serif",Font.BOLD|Font.ITALIC,28));
       l3.setForeground(Color.darkGray);
       l3.setOpaque(true);
       l3.setBackground(new Color(173,185,245));
       l3.setBorder(BorderFactory.createLineBorder(Color.black));
       l3.setBounds(220,70,320,37);
       P2.add(l3);


     //movie selection
       l4 = new JLabel("Select movie : ");
	   l4.setFont(new Font("Serif",Font.BOLD,18));
	   l4.setForeground(Color.black);
	   l4.setBounds(35,150,125,20);
	   P2.add(l4);
			
	   String movie[]={"Minions: The Rise of Gru","Avatar: The Way of Water","Thor: Love and Thunder","Jurassic World Dominion"};
	   c1 = new JComboBox(movie);
	   c1.addActionListener(this);
	   c1.setBounds(150,150,200,28);
	   P2.add(c1);


	//hall selection
       l5 = new JLabel("Select Hall : ");
	   l5.setFont(new Font("Serif",Font.BOLD,18));
	   l5.setForeground(Color.black);
	   l5.setBounds(35,230,125,20);
	   P2.add(l5);
			
	   String hall[]={"Bashundhara City Complex","Jamuna Future Park","Shimanto Square"};
	   c2 = new JComboBox(hall);
	   c2.addActionListener(this);
	   c2.setBounds(150,230,200,28);
	   P2.add(c2);


    //showtime selection
       l6 = new JLabel("show time : ");
	   l6.setFont(new Font("Serif",Font.BOLD,18));
	   l6.setForeground(Color.black);
	   l6.setBounds(390,150,125,20);
	   P2.add(l6);
			
	   String showtime[]={"11.00 am","01.00 pm","03.00 pm","06.00 pm"};
	   c3 = new JComboBox(showtime);
	   c3.addActionListener(this);
	   c3.setBounds(510,150,200,28);
	   P2.add(c3);


    //mseat type selection
       l7 = new JLabel("Seat type : ");
	   l7.setFont(new Font("Serif",Font.BOLD,18));
	   l7.setForeground(Color.black);
	   l7.setBounds(390,230,125,20);
	   P2.add(l7);
			
	   String seattype[]={"Regular seat","Premium seat","VIP seat"};
	   c4 = new JComboBox(seattype);
	   c4.addActionListener(this);
	   c4.setBounds(510,230,200,28);
	   P2.add(c4);


    //mseat number selection
       l8 = new JLabel("Number of seat : ");
	   l8.setFont(new Font("Serif",Font.BOLD,17));
	   l8.setForeground(Color.black);
	   l8.setBounds(390,310,125,20);
	   P2.add(l8);
			
	   String seatno[]={"01","02","03","04","05"};
	   c5 = new JComboBox(seatno);
	   c5.addActionListener(this);
	   c5.setBounds(510,310,200,28);
	   P2.add(c5);


    //date selection
       l9 = new JLabel("Date : ");
	   l9.setFont(new Font("Serif",Font.BOLD,17));
	   l9.setForeground(Color.black);
	   l9.setBounds(35,310,125,20);
	   P2.add(l9);
			
	   String date[]={"22 August,2022","23 August,2022","24 August,2022","25 August,2022"};
	   c6 = new JComboBox(date);
	   c6.addActionListener(this);
	   c6.setBounds(150,310,200,28);
	   P2.add(c6);


	// total cose
       l10 = new JLabel("Total cost : ");
	   l10.setFont(new Font("Serif",Font.BOLD,18));
	   l10.setForeground(Color.black);
	   l10.setBounds(240,385,125,20);
	   P2.add(l10);

	   l11 = new JLabel();
	   l11.setFont(new Font("Serif",Font.BOLD,19));
	   l11.setOpaque(true);
	   l11.setBackground(Color.white);
	   l11.setForeground(Color.black);
	   l11.setBounds(350,385,75,28);
	   P2.add(l11);




	
// panel 3 component


     //button
       b3 = new JButton("Back");
       b3.setFont(new Font("Serif",Font.BOLD,22));
	   b3.setBounds(30,415,100,34);
       b3.setBackground(Color.ORANGE);
	   b3.addActionListener(this);
	   b3.setFocusable(false);
       b3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	   P3.add(b3);

	   b4 = new JButton("Confirm");
       b4.setFont(new Font("Serif",Font.BOLD,26));
	   b4.setBounds(560,410,140,38);
       b4.setBackground(Color.green);
	   b4.addActionListener(this);
	   b4.setFocusable(false);
       b4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	   P3.add(b4);

     //panel
	   P4 = new JPanel();
       P4.setBounds(200,130,340,310);
       P4.setBackground(Color.pink);
	   P4.setLayout(null);
    
	//label
	   l19 = new JLabel("Ticket Information :");
	   l19.setFont(new Font("Serif",Font.BOLD | Font.ITALIC,36));
	   l19.setBounds(220,70,350,30);
	   P3.add(l19);





 
// panel 4 component

      // for movie
       l12 = new JLabel();
	   l12.setFont(new Font("Serif",Font.BOLD,17));
	   l12.setBounds(10,20,350,20);
	   P4.add(l12);
	   
	   // for hall
	   l13 = new JLabel();
	   l13.setFont(new Font("Serif",Font.BOLD,17));
	   l13.setBounds(10,70,350,20);
	   P4.add(l13);

	   // for showtime
	   l14 = new JLabel();
	   l14.setFont(new Font("Serif",Font.BOLD,17));
	   l14.setBounds(10,120,300,20);
	   P4.add(l14);

	   // for seat type
	   l15 = new JLabel();
	   l15.setFont(new Font("Serif",Font.BOLD,17));
	   l15.setBounds(10,170,300,22);
	   P4.add(l15);


	   // for num of seat
	   l16 = new JLabel();
	   l16.setFont(new Font("Serif",Font.BOLD,17));
	   l16.setBounds(10,220,300,20);
	   P4.add(l16);

	   //for date
	   l17 = new JLabel();
	   l17.setFont(new Font("Serif",Font.BOLD,17));
	   l17.setBounds(10,270,300,20);
	   P4.add(l17);

	   // for ticket price
	   l18 = new JLabel();
	   l18.setFont(new Font("Serif",Font.BOLD,17));
	   l18.setBounds(10,320,300,20);
	   P4.add(l18);
	   
	

        this.add(P1);
        this.add(P2);
		
        setVisible(true);

    }



  
    
    public void actionPerformed(ActionEvent ae){

	//function for price calculation
		if((c4.getSelectedIndex()==0)){
			int a=300;
			int b = c5.getSelectedIndex();
			int sum = a*(b+1);

			l11.setText(" "+String.valueOf(sum)+" Tk");
		}

		else if((c4.getSelectedIndex()==1)){
			int a=500;
			int b = c5.getSelectedIndex();
			int sum = a*(b+1);

			l11.setText(" "+String.valueOf(sum)+" Tk");
		}

		else if((c4.getSelectedIndex()==2)){
			int a=700;
			int b = c5.getSelectedIndex();
			int sum = a*(b+1);

			l11.setText(" "+String.valueOf(sum)+" Tk");
		}

		

   //buttom function

       //continue button
        if(ae.getSource()==b1)
		{
			
			this.add(P4);
			this.add(P3);
			P2.setVisible(false);
			P3.setVisible(true);
			
		}

     //back button to main menu
		else if(ae.getSource()==b2)
		{
			movies s = new movies();
			this.setVisible(false);
		    s.setVisible(true);
		}

    // back button to buy ticket
		else if(ae.getSource()==b3)
		{
			P2.setVisible(true);
			P3.setVisible(false);
		}


	// confirm button

	    else if(ae.getSource()==b4)
		{
			payment s = new payment();
			this.setVisible(false);
		    s.setVisible(true);
		}




    //ticket info data input
        l12.setText("Movie              :   " + c1.getSelectedItem());
		
		l13.setText("Hall                  :   " + c2.getSelectedItem());

		l14.setText("Show time       :   " + c3.getSelectedItem());

		l15.setText("Seat type         :   " + c4.getSelectedItem());

		l16.setText("Num of seat    :   " + c5.getSelectedItem());

		l17.setText("Date                 :   " + c6.getSelectedItem());

		l17.setText("Ticket price     :  "+l11.getText());


    }



    public static void main(String [] args)
	{
		buyTicket m = new buyTicket();

		
		
	}

}
