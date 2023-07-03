
//Package imports
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

//creating a class
public class CtaActivity implements ActionListener {
	// Creating Frames,Labels,Panels,Buttons,Text Fields
	JFrame f = new JFrame("Student Grading System");
	JLabel l1 = new JLabel("GRADE CALCULATOR");
	JLabel l2 = new JLabel("Enter IA-1 Marks");
	JLabel l3 = new JLabel("Enter IA-2 Marks");
	JLabel l4 = new JLabel("Enter IA-3 Marks");
	JLabel l5 = new JLabel("Enter CTA Marks");
	JLabel l6 = new JLabel("Enter SEE Marks");
	JLabel l8 = new JLabel("");

	// Creating borders
	Border bor1 = BorderFactory.createLineBorder(Color.black, 6);
	Border bor = BorderFactory.createLineBorder(Color.DARK_GRAY, 5);

	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JPanel p7 = new JPanel();
	JPanel p8 = new JPanel();

	JButton b1 = new JButton("CALCULATE");

	JTextField f1 = new JTextField(10);
	JTextField f2 = new JTextField(10);
	JTextField f3 = new JTextField(10);
	JTextField f4 = new JTextField(10);
	JTextField f5 = new JTextField(10);

	public CtaActivity() {

		// Arranging labels and Text Fields in their respective panels
		p1.add(l1);
		p2.add(l2);
		p2.add(f1);
		p3.add(l3);
		p3.add(f2);
		p4.add(l4);
		p4.add(f3);
		p5.add(l5);
		p5.add(f4);
		p6.add(l6);
		p6.add(f5);
		p7.add(b1);
		p8.add(l8);

		// Arranging Panels in a Frame
		f.add(p1);
		f.add(p2);
		f.add(p3);
		f.add(p4);
		f.add(p5);
		f.add(p6);
		f.add(p7);
		f.add(p8);

		// Setting sizes,colors,fonts and visibility of frame and button
		b1.setSize(100, 100);

		f.setVisible(true);
		f.setBounds(200, 200, 400, 500);
		f.setLayout(new GridLayout(10, 0));

		l1.setSize(200, 100);
		l1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		l1.setForeground(Color.BLUE);
		l1.setBackground(Color.MAGENTA);
		b1.setFont(new Font("Arial", Font.BOLD, 15));

		p1.setBorder(bor1);
		p2.setBackground(Color.cyan);
		p3.setBackground(Color.cyan);
		p4.setBackground(Color.cyan);
		p5.setBackground(Color.cyan);
		p6.setBackground(Color.cyan);
		p7.setBackground(Color.cyan);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1.addActionListener(this);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CtaActivity();
	}

	public void actionPerformed(ActionEvent e) {
		try {
			if (e.getSource() == b1) {
				// Creating variables
				double ia1 = Double.parseDouble(f1.getText());
				double ia2 = Double.parseDouble(f2.getText());
				double ia3 = Double.parseDouble(f3.getText());
				double cta = Double.parseDouble(f4.getText());
				double see = Double.parseDouble(f5.getText());

				// Checking Marks(Variables) limits
				if (ia1 < 0 || ia1 > 20 || ia2 < 0 || ia2 > 20 || ia3 < 0 || ia3 > 20 || cta < 0 || cta > 10 || see < 0
						|| see > 100) {
					l8.setText("Invalid marks entered.");
					return;
				}

				// Calculate CIE Marks
				double cie;
				double sum;

				if (ia1 >= ia2 && ia1 >= ia3) {
					sum = ia1;
					if (ia2 >= ia3) {
						sum += ia2;
					} else {
						sum += ia3;
					}
				} else if (ia2 >= ia1 && ia2 >= ia3) {
					sum = ia2;
					if (ia1 >= ia3) {
						sum += ia1;
					} else {
						sum += ia3;
					}
				} else {
					sum = ia3;
					if (ia1 >= ia2) {
						sum += ia1;
					} else {
						sum += ia2;
					}
				}
				cie = sum + cta;

				// Check if student is detained
				if (cie < 20) {
					l8.setText("The student has been detained from writing SEE");
					return;
				}

				// Upgrade SEE marks to 40 if 38 or 39
				if (see == 38 || see == 39) {
					see = 40;
				}
				if (see < 38) {
					// String grade="F";
					l8.setText("Grade:F");
					return;
				}

				// Calculate total marks
				double totalMarks = (cie + (see / 2));
				totalMarks = Math.round(totalMarks);

				// Calculate grade

				String grade;
				if (totalMarks >= 90) {
					grade = "S";
				} else if (totalMarks >= 80) {
					grade = "A";
				} else if (totalMarks >= 70) {
					grade = "B";
				} else if (totalMarks >= 60) {
					grade = "C";
				} else if (totalMarks >= 50) {
					grade = "D";
				} else if (totalMarks >= 40) {
					grade = "E";
				} else {
					grade = "F";
				}
				// Display of results
				l8.setText("Total Marks:" + totalMarks + "    " + "Grade:" + grade);
			}
		} catch (NumberFormatException nfe) {
			l8.setText("Invalid Number");
		}
	}
}
