

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Game extends JFrame implements ActionListener {
	JButton bt[] = new JButton[16];
	JButton bt_up, bt_down, bt_right, bt_left, bt_restart;
	JLabel lb;
	int random1, random2, random3, random4, start1, start2, flag = 0, flagout = 0, score = 0;

	public Game() {
		for (int i = 0; i <= 15; i++) {
			bt[i] = new JButton("");
			bt[i].setEnabled(false);
			bt[i].setBackground(Color.blue);
		}
		bt_up = new JButton("U");
		bt_down = new JButton("D");
		bt_right = new JButton("R");
		bt_left = new JButton("L");
		bt_restart = new JButton("RESTART");
		lb = new JLabel("0");
		bt[0].setBounds(20, 20, 70, 70);
		bt[1].setBounds(92, 20, 70, 70);
		bt[2].setBounds(164, 20, 70, 70);
		bt[3].setBounds(236, 20, 70, 70);
		bt[4].setBounds(20, 92, 70, 70);
		bt[5].setBounds(92, 92, 70, 70);
		bt[6].setBounds(164, 92, 70, 70);
		bt[7].setBounds(236, 92, 70, 70);
		bt[8].setBounds(20, 164, 70, 70);
		bt[9].setBounds(92, 164, 70, 70);
		bt[10].setBounds(164, 164, 70, 70);
		bt[11].setBounds(236, 164, 70, 70);
		bt[12].setBounds(20, 236, 70, 70);
		bt[13].setBounds(92, 236, 70, 70);
		bt[14].setBounds(164, 236, 70, 70);
		bt[15].setBounds(236, 236, 70, 70);
		bt_up.setBounds(138, 315, 50, 50);
		bt_left.setBounds(86, 367, 50, 50);
		bt_right.setBounds(190, 367, 50, 50);
		bt_down.setBounds(138, 419, 50, 50);
		bt_restart.setBounds(20, 475, 286, 50);
		lb.setBounds(80, 530, 86, 50);
		lb.setForeground(Color.green);
		for (int i = 0; i <= 15; i++) {
			add(bt[i]);
		}
		add(lb);
		add(bt_up);
		add(bt_down);
		add(bt_left);
		add(bt_right);
		add(bt_restart);
		for (int i = 0; i <= 15; i++) {
			bt[i].addActionListener(this);
		}
		bt_up.addActionListener(this);
		bt_down.addActionListener(this);
		bt_right.addActionListener(this);
		bt_left.addActionListener(this);
		bt_restart.addActionListener(this);
		random1 = (int) (100 + 899 * Math.random());
		random2 = (int) (1000 + 999 * Math.random());
		random3 = (int) (0 + 15 * Math.random());
		random4 = (int) (0 + 15 * Math.random());
		while (true) {
			if (random3 == random4) {
				random4 = (int) (0 + 15 * Math.random());
			} else {
				bt[random3].setBackground(Color.black);
				bt[random4].setBackground(Color.black);
				if (random1 % 2 == 0) {
					bt[random3].setLabel("2");
				} else {
					bt[random3].setLabel("4");
				}
				if (random2 % 2 == 0) {
					bt[random4].setLabel("2");
				} else {
					bt[random4].setLabel("4");
				}
				break;
			}
		}
		System.out.println("r1 " + random1 + " r2 " + random2 + " r3 " + random3 + " r4 " + random4);
		setLayout(null);
		setSize(340, 610);
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == bt_down) {
			for (int i = 15; i >= 12; i--) {
				if (bt[i].getLabel().equals("")) {
					if (bt[i - 4].getLabel().equals("")) {
						if (bt[i - 8].getLabel().equals("")) {
							if (!(bt[i - 12].getLabel().equals(""))) {
								bt[i].setLabel(bt[i - 12].getLabel());
								bt[i - 12].setLabel("");
								bt[i].setBackground(Color.black);
								bt[i - 12].setBackground(Color.blue);
								flagout = 1;
							} else {

							}
						} else {
							if (bt[i - 12].getLabel().equals("")) {
								bt[i].setLabel(bt[i - 8].getLabel());
								bt[i - 8].setLabel("");
								bt[i].setBackground(Color.black);
								bt[i - 8].setBackground(Color.blue);
								flagout = 1;
							} else {
								if (bt[i - 8].getLabel().equals(bt[i - 12].getLabel())) {
									String temp = Integer.toString(Integer.parseInt(bt[i - 8].getLabel())
											+ Integer.parseInt(bt[i - 12].getLabel()));
									score = score + Integer.parseInt(bt[i - 8].getLabel())
											+ Integer.parseInt(bt[i - 12].getLabel());
									lb.setText(Integer.toString(score));
									bt[i].setLabel(temp);
									bt[i - 8].setLabel("");
									bt[i - 12].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i - 8].setBackground(Color.blue);
									bt[i - 12].setBackground(Color.blue);
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i - 8].getLabel());
									bt[i - 4].setLabel(bt[i - 12].getLabel());
									bt[i - 8].setLabel("");
									bt[i - 12].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i - 4].setBackground(Color.black);
									bt[i - 8].setBackground(Color.blue);
									bt[i - 12].setBackground(Color.blue);
									flagout = 1;
								}
							}
						}
					} else {
						if (bt[i - 8].getLabel().equals("")) {
							if (bt[i - 12].getLabel().equals("")) {
								bt[i].setLabel(bt[i - 4].getLabel());
								bt[i - 4].setLabel("");
								bt[i].setBackground(Color.black);
								bt[i - 4].setBackground(Color.blue);
								flagout = 1;
							} else {
								int temp1 = Integer.parseInt(bt[i - 4].getLabel());
								int temp2 = Integer.parseInt(bt[i - 12].getLabel());
								if (temp1 == temp2) {
									temp1 = temp1 + temp2;
									bt[i].setLabel(Integer.toString(temp1));
									score = score + temp1;
									lb.setText(Integer.toString(score));
									bt[i - 4].setLabel("");
									bt[i - 12].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i - 4].setBackground(Color.blue);
									bt[i - 12].setBackground(Color.blue);
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i - 4].getLabel());
									bt[i].setBackground(Color.black);
									bt[i - 4].setLabel(bt[i - 12].getLabel());
									bt[i - 12].setLabel("");
									bt[i - 12].setBackground(Color.blue);
									flagout = 1;
								}
							}
						} else {
							if (bt[i - 12].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i - 4].getLabel());
								int temp2 = Integer.parseInt(bt[i - 8].getLabel());
								if (temp1 == temp2) {
									temp1 = temp1 + temp2;
									bt[i].setLabel(Integer.toString(temp1));
									score = score + temp1;
									lb.setText(Integer.toString(score));
									bt[i - 4].setLabel("");
									bt[i - 8].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i - 4].setBackground(Color.blue);
									bt[i - 8].setBackground(Color.blue);
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i - 4].getLabel());
									bt[i - 4].setLabel(bt[i - 8].getLabel());
									bt[i].setBackground(Color.black);
									bt[i - 4].setBackground(Color.black);
									bt[i - 8].setLabel("");
									bt[i - 8].setBackground(Color.blue);
									flagout = 1;
								}
							} else {
								int temp1 = Integer.parseInt(bt[i - 4].getLabel());
								int temp2 = Integer.parseInt(bt[i - 8].getLabel());
								int temp3 = Integer.parseInt(bt[i - 12].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 4].setLabel(bt[i - 12].getLabel());
									bt[i].setBackground(Color.black);
									bt[i - 8].setBackground(Color.blue);
									bt[i - 12].setBackground(Color.blue);
									bt[i - 8].setLabel("");
									bt[i - 12].setLabel("");
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i].setLabel(bt[i - 4].getLabel());
									bt[i - 4].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i].setBackground(Color.black);
									bt[i - 8].setBackground(Color.blue);
									bt[i - 12].setBackground(Color.blue);
									bt[i - 8].setLabel("");
									bt[i - 12].setLabel("");
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i - 4].getLabel());
									bt[i - 4].setLabel(bt[i - 8].getLabel());
									bt[i - 8].setLabel(bt[i - 12].getLabel());
									bt[i - 12].setLabel("");
									bt[i - 12].setBackground(Color.blue);
									bt[i].setBackground(Color.black);
									flagout = 1;
								}
							}

						}
					}
				} else {
					if (bt[i - 4].getLabel().equals("")) {
						if (bt[i - 8].getLabel().equals("")) {
							if (!(bt[i - 12].getLabel().equals(""))) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i - 12].getLabel());
								if (temp1 == temp2) {
									temp1 = temp1 + temp2;
									bt[i].setLabel(Integer.toString(temp1));
									score = score + temp1;
									lb.setText(Integer.toString(score));
									bt[i].setBackground(Color.black);
									bt[i - 12].setBackground(Color.blue);
									bt[i - 12].setLabel("");
									flagout = 1;
								} else {
									bt[i - 4].setLabel(bt[i - 12].getLabel());
									bt[i - 4].setBackground(Color.black);
									bt[i - 12].setLabel("");
									bt[i - 12].setBackground(Color.blue);
									flagout = 1;
								}
							}
						} else {
							if (bt[i - 12].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i - 8].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 8].setBackground(Color.blue);
									bt[i - 8].setLabel("");
									flagout = 1;
								} else {
									bt[i - 4].setLabel(Integer.toString(temp2));
									bt[i - 4].setBackground(Color.black);
									bt[i - 8].setBackground(Color.blue);
									bt[i - 8].setLabel("");
									flagout = 1;
								}
							} else {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i - 8].getLabel());
								int temp3 = Integer.parseInt(bt[i - 12].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 4].setLabel(bt[i - 12].getLabel());
									bt[i - 4].setBackground(Color.black);
									bt[i - 8].setBackground(Color.blue);
									bt[i - 12].setBackground(Color.blue);
									bt[i - 8].setLabel("");
									bt[i - 12].setLabel("");
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i - 4].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 4].setBackground(Color.black);
									bt[i - 8].setBackground(Color.blue);
									bt[i - 12].setBackground(Color.blue);
									bt[i - 8].setLabel("");
									bt[i - 12].setLabel("");
									flagout = 1;
								} else {
									bt[i - 4].setLabel(bt[i - 8].getLabel());
									bt[i - 8].setLabel(bt[i - 12].getLabel());
									bt[i - 12].setLabel("");
									bt[i - 4].setBackground(Color.black);
									bt[i - 12].setBackground(Color.blue);
									flagout = 1;
								}
							}
						}
					} else {
						if (bt[i - 8].getLabel().equals("")) {
							if (bt[i - 12].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i - 4].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 4].setLabel("");
									bt[i - 4].setBackground(Color.blue);
									flagout = 1;
								} else {

								}
							} else {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i - 4].getLabel());
								int temp3 = Integer.parseInt(bt[i - 12].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 4].setLabel(bt[i - 12].getLabel());
									bt[i - 12].setBackground(Color.blue);
									bt[i - 12].setLabel("");
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i - 4].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 12].setBackground(Color.blue);
									bt[i - 12].setLabel("");
									flagout = 1;
								} else {
									bt[i - 8].setLabel(bt[i - 12].getLabel());
									bt[i - 8].setBackground(Color.black);
									bt[i - 12].setBackground(Color.blue);
									bt[i - 12].setLabel("");
									flagout = 1;
								}
							}
						} else {
							if (bt[i - 12].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i - 4].getLabel());
								int temp3 = Integer.parseInt(bt[i - 8].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 4].setLabel(bt[i - 8].getLabel());
									bt[i - 8].setLabel("");
									bt[i - 8].setBackground(Color.blue);
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i - 4].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 8].setLabel("");
									bt[i - 8].setBackground(Color.blue);
									flagout = 1;
								} else {

								}
							} else {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i - 4].getLabel());
								int temp3 = Integer.parseInt(bt[i - 8].getLabel());
								int temp4 = Integer.parseInt(bt[i - 12].getLabel());
								if (temp1 == temp2 && temp3 == temp4) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									bt[i - 4].setLabel(Integer.toString(temp3 + temp4));
									int temp = temp1 + temp2 + temp3 + temp4;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 8].setLabel("");
									bt[i - 12].setLabel("");
									bt[i - 8].setBackground(Color.blue);
									bt[i - 12].setBackground(Color.blue);
									flagout = 1;
								} else if (temp1 == temp2 && temp3 != temp4) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 4].setLabel(bt[i - 8].getLabel());
									bt[i - 8].setLabel(bt[i - 12].getLabel());
									bt[i - 12].setLabel("");
									bt[i - 12].setBackground(Color.blue);
									flagout = 1;
								} else if (temp1 != temp2 && temp3 == temp4) {
									bt[i - 8].setLabel(Integer.toString(temp3 + temp4));
									int temp = temp3 + temp4;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 12].setLabel("");
									bt[i - 12].setBackground(Color.blue);
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i - 4].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp3 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 8].setLabel(bt[i - 12].getLabel());
									bt[i - 12].setLabel("");
									bt[i - 12].setBackground(Color.blue);
									flagout = 1;
								} else {

								}
							}
						}
					}
				}
			}
			int random1, random2, flagfill = 0;
			while (true) {
				random1 = (int) (0 + 100 * Math.random());
				random2 = (int) (0 + 15 * Math.random());
				if (bt[random2].getLabel().equals("")) {
					if (random1 % 2 == 0) {
						bt[random2].setLabel("2");
						bt[random2].setBackground(Color.black);
					} else {
						bt[random2].setLabel("4");
						bt[random2].setBackground(Color.black);
					}
					flagfill = 1;
					break;
				}
			}
			if (flagfill == 0 && flagout == 0) {
				bt_down.setEnabled(false);
				bt_left.setEnabled(false);
				bt_up.setEnabled(false);
				bt_right.setEnabled(false);
				JOptionPane.showMessageDialog(this, "Game Over,Your Score is " + score);
			} else {
				flagfill = 0;
				flagout = 0;
			}
		}
		if (e.getSource() == bt_up) {
			for (int i = 0; i <= 3; i++) {
				if (bt[i].getLabel().equals("")) {
					if (bt[i + 4].getLabel().equals("")) {
						if (bt[i + 8].getLabel().equals("")) {
							if (!(bt[i + 12].getLabel().equals(""))) {
								bt[i].setLabel(bt[i + 12].getLabel());
								bt[i + 12].setLabel("");
								bt[i].setBackground(Color.black);
								bt[i + 12].setBackground(Color.blue);
								flagout = 1;
							} else {

							}
						} else {
							if (bt[i + 12].getLabel().equals("")) {
								bt[i].setLabel(bt[i + 8].getLabel());
								bt[i + 8].setLabel("");
								bt[i].setBackground(Color.black);
								bt[i + 8].setBackground(Color.blue);
								flagout = 1;
							} else {
								if (bt[i + 8].getLabel().equals(bt[i + 12].getLabel())) {
									String temp = Integer.toString(Integer.parseInt(bt[i + 8].getLabel())
											+ Integer.parseInt(bt[i + 12].getLabel()));
									bt[i].setLabel(temp);
									score = score + Integer.parseInt(bt[i + 8].getLabel())
											+ Integer.parseInt(bt[i + 12].getLabel());
									lb.setText(Integer.toString(score));
									bt[i].setLabel(temp);
									bt[i + 8].setLabel("");
									bt[i + 12].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i + 8].setBackground(Color.blue);
									bt[i + 12].setBackground(Color.blue);
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i + 8].getLabel());
									bt[i + 4].setLabel(bt[i + 12].getLabel());
									bt[i + 8].setLabel("");
									bt[i + 12].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i + 4].setBackground(Color.black);
									bt[i + 8].setBackground(Color.blue);
									bt[i + 12].setBackground(Color.blue);
									flagout = 1;
								}
							}
						}
					} else {
						if (bt[i + 8].getLabel().equals("")) {
							if (bt[i + 12].getLabel().equals("")) {
								bt[i].setLabel(bt[i + 4].getLabel());
								bt[i + 4].setLabel("");
								bt[i].setBackground(Color.black);
								bt[i + 4].setBackground(Color.blue);
								flagout = 1;
							} else {
								int temp1 = Integer.parseInt(bt[i + 4].getLabel());
								int temp2 = Integer.parseInt(bt[i + 12].getLabel());
								if (temp1 == temp2) {
									temp1 = temp1 + temp2;
									bt[i].setLabel(Integer.toString(temp1));
									score = score + temp1;
									lb.setText(Integer.toString(score));
									bt[i + 4].setLabel("");
									bt[i + 12].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i + 4].setBackground(Color.blue);
									bt[i + 12].setBackground(Color.blue);
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i + 4].getLabel());
									bt[i].setBackground(Color.black);
									bt[i + 4].setLabel(bt[i + 12].getLabel());
									bt[i + 12].setLabel("");
									bt[i + 12].setBackground(Color.blue);
									flagout = 1;
								}
							}
						} else {
							if (bt[i + 12].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i + 4].getLabel());
								int temp2 = Integer.parseInt(bt[i + 8].getLabel());
								if (temp1 == temp2) {
									temp1 = temp1 + temp2;
									bt[i].setLabel(Integer.toString(temp1));
									score = score + temp1;
									lb.setText(Integer.toString(score));
									bt[i + 4].setLabel("");
									bt[i + 8].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i + 4].setBackground(Color.blue);
									bt[i + 8].setBackground(Color.blue);
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i + 4].getLabel());
									bt[i + 4].setLabel(bt[i + 8].getLabel());
									bt[i].setBackground(Color.black);
									bt[i + 4].setBackground(Color.black);
									bt[i + 8].setLabel("");
									bt[i + 8].setBackground(Color.blue);
									flagout = 1;
								}
							} else {
								int temp1 = Integer.parseInt(bt[i + 4].getLabel());
								int temp2 = Integer.parseInt(bt[i + 8].getLabel());
								int temp3 = Integer.parseInt(bt[i + 12].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 4].setLabel(bt[i + 12].getLabel());
									bt[i].setBackground(Color.black);
									bt[i + 8].setBackground(Color.blue);
									bt[i + 12].setBackground(Color.blue);
									bt[i + 8].setLabel("");
									bt[i + 12].setLabel("");
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i].setLabel(bt[i + 4].getLabel());
									bt[i + 4].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp3 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i].setBackground(Color.black);
									bt[i + 8].setBackground(Color.blue);
									bt[i + 12].setBackground(Color.blue);
									bt[i + 8].setLabel("");
									bt[i + 12].setLabel("");
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i + 4].getLabel());
									bt[i + 4].setLabel(bt[i + 8].getLabel());
									bt[i + 8].setLabel(bt[i + 12].getLabel());
									bt[i + 12].setLabel("");
									bt[i + 12].setBackground(Color.blue);
									bt[i].setBackground(Color.black);
									flagout = 1;
								}
							}

						}
					}
				} else {
					if (bt[i + 4].getLabel().equals("")) {
						if (bt[i + 8].getLabel().equals("")) {
							if (!(bt[i + 12].getLabel().equals(""))) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 12].getLabel());
								if (temp1 == temp2) {
									int temp = temp1 + temp2;
									bt[i].setLabel(Integer.toString(temp));
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i].setBackground(Color.black);
									bt[i + 12].setBackground(Color.blue);
									bt[i + 12].setLabel("");
									flagout = 1;
								} else {
									bt[i + 4].setLabel(bt[i + 12].getLabel());
									bt[i + 4].setBackground(Color.black);
									bt[i + 12].setLabel("");
									bt[i + 12].setBackground(Color.blue);
									flagout = 1;
								}
							}
						} else {
							if (bt[i + 12].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 8].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 8].setBackground(Color.blue);
									bt[i + 8].setLabel("");
									flagout = 1;
								} else {
									bt[i + 4].setLabel(Integer.toString(temp2));
									bt[i + 4].setBackground(Color.black);
									bt[i + 8].setBackground(Color.blue);
									bt[i + 8].setLabel("");
									flagout = 1;
								}
							} else {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 8].getLabel());
								int temp3 = Integer.parseInt(bt[i + 12].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 4].setLabel(bt[i + 12].getLabel());
									bt[i + 4].setBackground(Color.black);
									bt[i + 8].setBackground(Color.blue);
									bt[i + 12].setBackground(Color.blue);
									bt[i + 8].setLabel("");
									bt[i + 12].setLabel("");
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i + 4].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 4].setBackground(Color.black);
									bt[i + 8].setBackground(Color.blue);
									bt[i + 12].setBackground(Color.blue);
									bt[i + 8].setLabel("");
									bt[i + 12].setLabel("");
									flagout = 1;
								} else {
									bt[i + 4].setLabel(bt[i + 8].getLabel());
									bt[i + 8].setLabel(bt[i + 12].getLabel());
									bt[i + 12].setLabel("");
									bt[i + 4].setBackground(Color.black);
									bt[i + 12].setBackground(Color.blue);
									flagout = 1;
								}
							}
						}
					} else {
						if (bt[i + 8].getLabel().equals("")) {
							if (bt[i + 12].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 4].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 4].setLabel("");
									bt[i + 4].setBackground(Color.blue);
									flagout = 1;
								} else {

								}
							} else {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 4].getLabel());
								int temp3 = Integer.parseInt(bt[i + 12].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 4].setLabel(bt[i + 12].getLabel());
									bt[i + 12].setBackground(Color.blue);
									bt[i + 12].setLabel("");
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i + 4].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 12].setBackground(Color.blue);
									bt[i + 12].setLabel("");
									flagout = 1;
								} else {
									bt[i + 8].setLabel(bt[i + 12].getLabel());
									bt[i + 8].setBackground(Color.black);
									bt[i + 12].setBackground(Color.blue);
									bt[i + 12].setLabel("");
									flagout = 1;
								}
							}
						} else {
							if (bt[i + 12].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 4].getLabel());
								int temp3 = Integer.parseInt(bt[i + 8].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 4].setLabel(bt[i + 8].getLabel());
									bt[i + 8].setLabel("");
									bt[i + 8].setBackground(Color.blue);
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i + 4].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 8].setLabel("");
									bt[i + 8].setBackground(Color.blue);
									flagout = 1;
								} else {

								}
							} else {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 4].getLabel());
								int temp3 = Integer.parseInt(bt[i + 8].getLabel());
								int temp4 = Integer.parseInt(bt[i + 12].getLabel());
								if (temp1 == temp2 && temp3 == temp4) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									bt[i + 4].setLabel(Integer.toString(temp3 + temp4));
									int temp = temp1 + temp2 + temp3 + temp4;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 8].setLabel("");
									bt[i + 12].setLabel("");
									bt[i + 8].setBackground(Color.blue);
									bt[i + 12].setBackground(Color.blue);
									flagout = 1;
								} else if (temp1 == temp2 && temp3 != temp4) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 4].setLabel(bt[i + 8].getLabel());
									bt[i + 8].setLabel(bt[i + 12].getLabel());
									bt[i + 12].setLabel("");
									bt[i + 12].setBackground(Color.blue);
									flagout = 1;
								} else if (temp1 != temp2 && temp3 == temp4) {
									bt[i + 8].setLabel(Integer.toString(temp3 + temp4));
									int temp = temp3 + temp4;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 12].setLabel("");
									bt[i + 12].setBackground(Color.blue);
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i + 4].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 8].setLabel(bt[i + 12].getLabel());
									bt[i + 12].setLabel("");
									bt[i + 12].setBackground(Color.blue);
									flagout = 1;
								} else {

								}
							}
						}
					}
				}
			}
			int random1, random2, flagfill = 0;
			while (true) {
				random1 = (int) (0 + 100 * Math.random());
				random2 = (int) (0 + 15 * Math.random());
				if (bt[random2].getLabel().equals("")) {
					if (random1 % 2 == 0) {
						bt[random2].setLabel("2");
						bt[random2].setBackground(Color.black);
					} else {
						bt[random2].setLabel("4");
						bt[random2].setBackground(Color.black);
					}
					flagfill = 1;
					break;
				}
			}
			if (flagfill == 0 && flagout == 0) {
				bt_down.setEnabled(false);
				bt_left.setEnabled(false);
				bt_up.setEnabled(false);
				bt_right.setEnabled(false);
				JOptionPane.showMessageDialog(this, "Game Over,Your Score is " + score);
			} else {
				flagfill = 0;
				flagout = 0;
			}
		}
		if (e.getSource() == bt_right) {
			for (int i = 15; i >= 3; i = i - 4) {
				if (bt[i].getLabel().equals("")) {
					if (bt[i - 1].getLabel().equals("")) {
						if (bt[i - 2].getLabel().equals("")) {
							if (!(bt[i - 3].getLabel().equals(""))) {
								bt[i].setLabel(bt[i - 3].getLabel());
								bt[i - 3].setLabel("");
								bt[i].setBackground(Color.black);
								bt[i - 3].setBackground(Color.blue);
								flagout = 1;
							} else {

							}
						} else {
							if (bt[i - 3].getLabel().equals("")) {
								bt[i].setLabel(bt[i - 2].getLabel());
								bt[i - 2].setLabel("");
								bt[i].setBackground(Color.black);
								bt[i - 2].setBackground(Color.blue);
								flagout = 1;
							} else {
								if (bt[i - 2].getLabel().equals(bt[i - 3].getLabel())) {
									String temp = Integer.toString(Integer.parseInt(bt[i - 2].getLabel())
											+ Integer.parseInt(bt[i - 3].getLabel()));
									bt[i].setLabel(temp);
									score = score + Integer.parseInt(bt[i - 2].getLabel())
											+ Integer.parseInt(bt[i - 3].getLabel());
									lb.setText(Integer.toString(score));
									bt[i].setLabel(temp);
									bt[i - 2].setLabel("");
									bt[i - 3].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i - 2].setBackground(Color.blue);
									bt[i - 3].setBackground(Color.blue);
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i - 2].getLabel());
									bt[i - 1].setLabel(bt[i - 3].getLabel());
									bt[i - 2].setLabel("");
									bt[i - 3].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i - 1].setBackground(Color.black);
									bt[i - 2].setBackground(Color.blue);
									bt[i - 3].setBackground(Color.blue);
									flagout = 1;
								}
							}
						}
					} else {
						if (bt[i - 2].getLabel().equals("")) {
							if (bt[i - 3].getLabel().equals("")) {
								bt[i].setLabel(bt[i - 1].getLabel());
								bt[i - 1].setLabel("");
								bt[i].setBackground(Color.black);
								bt[i - 1].setBackground(Color.blue);
								flagout = 1;
							} else {
								int temp1 = Integer.parseInt(bt[i - 1].getLabel());
								int temp2 = Integer.parseInt(bt[i - 3].getLabel());
								if (temp1 == temp2) {
									temp1 = temp1 + temp2;
									bt[i].setLabel(Integer.toString(temp1));
									score = score + temp1;
									lb.setText(Integer.toString(score));
									bt[i - 1].setLabel("");
									bt[i - 3].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i - 1].setBackground(Color.blue);
									bt[i - 3].setBackground(Color.blue);
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i - 1].getLabel());
									bt[i].setBackground(Color.black);
									bt[i - 1].setLabel(bt[i - 3].getLabel());
									bt[i - 3].setLabel("");
									bt[i - 3].setBackground(Color.blue);
									flagout = 1;
								}
							}
						} else {
							if (bt[i - 3].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i - 1].getLabel());
								int temp2 = Integer.parseInt(bt[i - 2].getLabel());
								if (temp1 == temp2) {
									temp1 = temp1 + temp2;
									bt[i].setLabel(Integer.toString(temp1));
									score = score + temp1;
									lb.setText(Integer.toString(score));
									bt[i - 1].setLabel("");
									bt[i - 2].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i - 1].setBackground(Color.blue);
									bt[i - 2].setBackground(Color.blue);
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i - 1].getLabel());
									bt[i - 1].setLabel(bt[i - 2].getLabel());
									bt[i].setBackground(Color.black);
									bt[i - 1].setBackground(Color.black);
									bt[i - 2].setLabel("");
									bt[i - 2].setBackground(Color.blue);
									flagout = 1;
								}
							} else {
								int temp1 = Integer.parseInt(bt[i - 1].getLabel());
								int temp2 = Integer.parseInt(bt[i - 2].getLabel());
								int temp3 = Integer.parseInt(bt[i - 3].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 1].setLabel(bt[i - 3].getLabel());
									bt[i].setBackground(Color.black);
									bt[i - 2].setBackground(Color.blue);
									bt[i - 3].setBackground(Color.blue);
									bt[i - 2].setLabel("");
									bt[i - 3].setLabel("");
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i].setLabel(bt[i - 1].getLabel());
									bt[i - 1].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i].setBackground(Color.black);
									bt[i - 2].setBackground(Color.blue);
									bt[i - 3].setBackground(Color.blue);
									bt[i - 2].setLabel("");
									bt[i - 3].setLabel("");
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i - 1].getLabel());
									bt[i - 1].setLabel(bt[i - 2].getLabel());
									bt[i - 2].setLabel(bt[i - 3].getLabel());
									bt[i - 3].setLabel("");
									bt[i - 3].setBackground(Color.blue);
									bt[i].setBackground(Color.black);
									flagout = 1;
								}
							}

						}
					}
				} else {
					if (bt[i - 1].getLabel().equals("")) {
						if (bt[i - 2].getLabel().equals("")) {
							if (!(bt[i - 3].getLabel().equals(""))) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i - 3].getLabel());
								if (temp1 == temp2) {
									temp1 = temp1 + temp2;
									bt[i].setLabel(Integer.toString(temp1));
									score = score + temp1;
									lb.setText(Integer.toString(score));
									bt[i].setBackground(Color.black);
									bt[i - 3].setBackground(Color.blue);
									bt[i - 3].setLabel("");
									flagout = 1;
								} else {
									bt[i - 1].setLabel(bt[i - 3].getLabel());
									bt[i - 1].setBackground(Color.black);
									bt[i - 3].setLabel("");
									bt[i - 3].setBackground(Color.blue);
									flagout = 1;
								}
							}
						} else {
							if (bt[i - 3].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i - 2].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 2].setBackground(Color.blue);
									bt[i - 2].setLabel("");
									flagout = 1;
								} else {
									bt[i - 1].setLabel(Integer.toString(temp2));
									bt[i - 1].setBackground(Color.black);
									bt[i - 2].setBackground(Color.blue);
									bt[i - 2].setLabel("");
									flagout = 1;
								}
							} else {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 2].getLabel());
								int temp3 = Integer.parseInt(bt[i + 3].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 1].setLabel(bt[i - 3].getLabel());
									bt[i - 1].setBackground(Color.black);
									bt[i - 2].setBackground(Color.blue);
									bt[i - 3].setBackground(Color.blue);
									bt[i - 2].setLabel("");
									bt[i - 3].setLabel("");
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i - 1].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 1].setBackground(Color.black);
									bt[i - 2].setBackground(Color.blue);
									bt[i - 3].setBackground(Color.blue);
									bt[i - 2].setLabel("");
									bt[i - 3].setLabel("");
									flagout = 1;
								} else {
									bt[i - 1].setLabel(bt[i - 2].getLabel());
									bt[i - 2].setLabel(bt[i - 3].getLabel());
									bt[i - 3].setLabel("");
									bt[i - 1].setBackground(Color.black);
									bt[i - 3].setBackground(Color.blue);
									flagout = 1;
								}
							}
						}
					} else {
						if (bt[i - 2].getLabel().equals("")) {
							if (bt[i - 3].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i - 1].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 1].setLabel("");
									bt[i - 1].setBackground(Color.blue);
									flagout = 1;
								} else {

								}
							} else {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i - 1].getLabel());
								int temp3 = Integer.parseInt(bt[i - 3].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 1].setLabel(bt[i - 3].getLabel());
									bt[i - 3].setBackground(Color.blue);
									bt[i - 3].setLabel("");
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i - 1].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 3].setBackground(Color.blue);
									bt[i - 3].setLabel("");
									flagout = 1;
								} else {
									bt[i - 2].setLabel(bt[i - 3].getLabel());
									bt[i - 2].setBackground(Color.black);
									bt[i - 3].setBackground(Color.blue);
									bt[i - 3].setLabel("");
									flagout = 1;
								}
							}
						} else {
							if (bt[i - 3].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i - 1].getLabel());
								int temp3 = Integer.parseInt(bt[i - 2].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 1].setLabel(bt[i - 2].getLabel());
									bt[i - 2].setLabel("");
									bt[i - 2].setBackground(Color.blue);
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i - 1].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 2].setLabel("");
									bt[i - 2].setBackground(Color.blue);
									flagout = 1;
								} else {

								}
							} else {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i - 1].getLabel());
								int temp3 = Integer.parseInt(bt[i - 2].getLabel());
								int temp4 = Integer.parseInt(bt[i - 3].getLabel());
								if (temp1 == temp2 && temp3 == temp4) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									bt[i - 1].setLabel(Integer.toString(temp3 + temp4));
									int temp = temp1 + temp2 + temp3 + temp4;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 2].setLabel("");
									bt[i - 3].setLabel("");
									bt[i - 2].setBackground(Color.blue);
									bt[i - 3].setBackground(Color.blue);
									flagout = 1;
								} else if (temp1 == temp2 && temp3 != temp4) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 1].setLabel(bt[i - 2].getLabel());
									bt[i - 2].setLabel(bt[i - 3].getLabel());
									bt[i - 3].setLabel("");
									bt[i - 3].setBackground(Color.blue);
									flagout = 1;
								} else if (temp1 != temp2 && temp3 == temp4) {
									bt[i - 2].setLabel(Integer.toString(temp3 + temp4));
									int temp = temp3 + temp4;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 3].setLabel("");
									bt[i - 3].setBackground(Color.blue);
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i - 1].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i - 2].setLabel(bt[i - 3].getLabel());
									bt[i - 3].setLabel("");
									bt[i - 3].setBackground(Color.blue);
									flagout = 1;
								} else {

								}
							}
						}
					}
				}
			}
			int random1, random2, flagfill = 0;
			while (true) {
				random1 = (int) (0 + 100 * Math.random());
				random2 = (int) (0 + 15 * Math.random());
				if (bt[random2].getLabel().equals("")) {
					if (random1 % 2 == 0) {
						bt[random2].setLabel("2");
						bt[random2].setBackground(Color.black);
					} else {
						bt[random2].setLabel("4");
						bt[random2].setBackground(Color.black);
					}
					flagfill = 1;
					break;
				}
			}
			if (flagfill == 0 && flagout == 0) {
				bt_down.setEnabled(false);
				bt_left.setEnabled(false);
				bt_up.setEnabled(false);
				bt_right.setEnabled(false);
				JOptionPane.showMessageDialog(this, "Game Over,Your Score is " + score);
			} else {
				flagfill = 0;
				flagout = 0;
			}
		}
		if (e.getSource() == bt_left) {
			for (int i = 0; i <= 12; i = i + 4) {
				if (bt[i].getLabel().equals("")) {
					if (bt[i + 1].getLabel().equals("")) {
						if (bt[i + 2].getLabel().equals("")) {
							if (!(bt[i + 3].getLabel().equals(""))) {
								bt[i].setLabel(bt[i + 3].getLabel());
								bt[i + 3].setLabel("");
								bt[i].setBackground(Color.black);
								bt[i + 3].setBackground(Color.blue);
								flagout = 1;
							} else {

							}
						} else {
							if (bt[i + 3].getLabel().equals("")) {
								bt[i].setLabel(bt[i + 2].getLabel());
								bt[i + 2].setLabel("");
								bt[i].setBackground(Color.black);
								bt[i + 2].setBackground(Color.blue);
								flagout = 1;
							} else {
								if (bt[i + 2].getLabel().equals(bt[i + 3].getLabel())) {
									String temp = Integer.toString(Integer.parseInt(bt[i + 2].getLabel())
											+ Integer.parseInt(bt[i + 3].getLabel()));
									score = score + Integer.parseInt(bt[i + 2].getLabel())
											+ Integer.parseInt(bt[i + 3].getLabel());
									lb.setText(Integer.toString(score));
									bt[i].setLabel(temp);
									bt[i].setLabel(temp);
									bt[i + 2].setLabel("");
									bt[i + 3].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i + 2].setBackground(Color.blue);
									bt[i + 3].setBackground(Color.blue);
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i + 2].getLabel());
									bt[i + 1].setLabel(bt[i + 3].getLabel());
									bt[i + 2].setLabel("");
									bt[i + 3].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i + 1].setBackground(Color.black);
									bt[i + 2].setBackground(Color.blue);
									bt[i + 3].setBackground(Color.blue);
									flagout = 1;
								}
							}
						}
					} else {
						if (bt[i + 2].getLabel().equals("")) {
							if (bt[i + 3].getLabel().equals("")) {
								bt[i].setLabel(bt[i + 1].getLabel());
								bt[i + 1].setLabel("");
								bt[i].setBackground(Color.black);
								bt[i + 1].setBackground(Color.blue);
								flagout = 1;
							} else {
								int temp1 = Integer.parseInt(bt[i + 1].getLabel());
								int temp2 = Integer.parseInt(bt[i + 3].getLabel());
								if (temp1 == temp2) {
									temp1 = temp1 + temp2;
									bt[i].setLabel(Integer.toString(temp1));
									score = score + temp1;
									lb.setText(Integer.toString(score));
									bt[i + 1].setLabel("");
									bt[i + 3].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i + 1].setBackground(Color.blue);
									bt[i + 3].setBackground(Color.blue);
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i + 1].getLabel());
									bt[i].setBackground(Color.black);
									bt[i + 1].setLabel(bt[i + 3].getLabel());
									bt[i + 3].setLabel("");
									bt[i + 3].setBackground(Color.blue);
									flagout = 1;
								}
							}
						} else {
							if (bt[i + 3].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i + 1].getLabel());
								int temp2 = Integer.parseInt(bt[i + 2].getLabel());
								if (temp1 == temp2) {
									int temp = temp1 + temp2;
									bt[i].setLabel(Integer.toString(temp));
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 1].setLabel("");
									bt[i + 2].setLabel("");
									bt[i].setBackground(Color.black);
									bt[i + 1].setBackground(Color.blue);
									bt[i + 2].setBackground(Color.blue);
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i + 1].getLabel());
									bt[i + 1].setLabel(bt[i + 2].getLabel());
									bt[i].setBackground(Color.black);
									bt[i + 1].setBackground(Color.black);
									bt[i + 2].setLabel("");
									bt[i + 2].setBackground(Color.blue);
									flagout = 1;
								}
							} else {
								int temp1 = Integer.parseInt(bt[i + 1].getLabel());
								int temp2 = Integer.parseInt(bt[i + 2].getLabel());
								int temp3 = Integer.parseInt(bt[i + 3].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 1].setLabel(bt[i + 3].getLabel());
									bt[i].setBackground(Color.black);
									bt[i + 2].setBackground(Color.blue);
									bt[i + 3].setBackground(Color.blue);
									bt[i + 2].setLabel("");
									bt[i + 3].setLabel("");
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i].setLabel(bt[i + 1].getLabel());
									bt[i + 1].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i].setBackground(Color.black);
									bt[i + 2].setBackground(Color.blue);
									bt[i + 3].setBackground(Color.blue);
									bt[i + 2].setLabel("");
									bt[i + 3].setLabel("");
									flagout = 1;
								} else {
									bt[i].setLabel(bt[i + 1].getLabel());
									bt[i + 1].setLabel(bt[i + 2].getLabel());
									bt[i + 2].setLabel(bt[i + 3].getLabel());
									bt[i + 3].setLabel("");
									bt[i + 3].setBackground(Color.blue);
									bt[i].setBackground(Color.black);
									flagout = 1;
								}
							}

						}
					}
				} else {
					if (bt[i + 1].getLabel().equals("")) {
						if (bt[i + 2].getLabel().equals("")) {
							if (!(bt[i + 3].getLabel().equals(""))) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 3].getLabel());
								if (temp1 == temp2) {
									int temp = temp1 + temp2;
									bt[i].setLabel(Integer.toString(temp));
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i].setBackground(Color.black);
									bt[i + 3].setBackground(Color.blue);
									bt[i + 3].setLabel("");
									flagout = 1;
								} else {
									bt[i + 1].setLabel(bt[i + 3].getLabel());
									bt[i + 1].setBackground(Color.black);
									bt[i + 3].setLabel("");
									bt[i + 3].setBackground(Color.blue);
									flagout = 1;
								}
							}
						} else {
							if (bt[i + 3].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 2].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 2].setBackground(Color.blue);
									bt[i + 2].setLabel("");
									flagout = 1;
								} else {
									bt[i + 1].setLabel(Integer.toString(temp2));
									bt[i + 1].setBackground(Color.black);
									bt[i + 2].setBackground(Color.blue);
									bt[i + 2].setLabel("");
									flagout = 1;
								}
							} else {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 2].getLabel());
								int temp3 = Integer.parseInt(bt[i + 3].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 1].setLabel(bt[i + 3].getLabel());
									bt[i + 1].setBackground(Color.black);
									bt[i + 2].setBackground(Color.blue);
									bt[i + 3].setBackground(Color.blue);
									bt[i + 2].setLabel("");
									bt[i + 3].setLabel("");
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i + 1].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 1].setBackground(Color.black);
									bt[i + 2].setBackground(Color.blue);
									bt[i + 3].setBackground(Color.blue);
									bt[i + 2].setLabel("");
									bt[i + 3].setLabel("");
									flagout = 1;
								} else {
									bt[i + 1].setLabel(bt[i + 2].getLabel());
									bt[i + 2].setLabel(bt[i + 3].getLabel());
									bt[i + 3].setLabel("");
									bt[i + 1].setBackground(Color.black);
									bt[i + 3].setBackground(Color.blue);
									flagout = 1;
								}
							}
						}
					} else {
						if (bt[i + 2].getLabel().equals("")) {
							if (bt[i + 3].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 1].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 1].setLabel("");
									bt[i + 1].setBackground(Color.blue);
									flagout = 1;
								} else {

								}
							} else {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 1].getLabel());
								int temp3 = Integer.parseInt(bt[i + 3].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 1].setLabel(bt[i + 3].getLabel());
									bt[i + 3].setBackground(Color.blue);
									bt[i + 3].setLabel("");
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i + 1].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 3].setBackground(Color.blue);
									bt[i + 3].setLabel("");
									flagout = 1;
								} else {
									bt[i + 2].setLabel(bt[i + 3].getLabel());
									bt[i + 2].setBackground(Color.black);
									bt[i + 3].setBackground(Color.blue);
									bt[i + 3].setLabel("");
									flagout = 1;
								}
							}
						} else {
							if (bt[i + 3].getLabel().equals("")) {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 1].getLabel());
								int temp3 = Integer.parseInt(bt[i + 2].getLabel());
								if (temp1 == temp2) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 1].setLabel(bt[i + 2].getLabel());
									bt[i + 2].setLabel("");
									bt[i + 2].setBackground(Color.blue);
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i + 1].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 2].setLabel("");
									bt[i + 2].setBackground(Color.blue);
									flagout = 1;
								} else {

								}
							} else {
								int temp1 = Integer.parseInt(bt[i].getLabel());
								int temp2 = Integer.parseInt(bt[i + 1].getLabel());
								int temp3 = Integer.parseInt(bt[i + 2].getLabel());
								int temp4 = Integer.parseInt(bt[i + 3].getLabel());
								if (temp1 == temp2 && temp3 == temp4) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									bt[i + 1].setLabel(Integer.toString(temp3 + temp4));
									int temp = temp1 + temp2 + temp3 + temp4;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 2].setLabel("");
									bt[i + 3].setLabel("");
									bt[i + 2].setBackground(Color.blue);
									bt[i + 3].setBackground(Color.blue);
									flagout = 1;
								} else if (temp1 == temp2 && temp3 != temp4) {
									bt[i].setLabel(Integer.toString(temp1 + temp2));
									int temp = temp1 + temp2;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 1].setLabel(bt[i + 2].getLabel());
									bt[i + 2].setLabel(bt[i + 3].getLabel());
									bt[i + 3].setLabel("");
									bt[i + 3].setBackground(Color.blue);
									flagout = 1;
								} else if (temp1 != temp2 && temp3 == temp4) {
									bt[i + 2].setLabel(Integer.toString(temp3 + temp4));
									int temp = temp3 + temp4;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 3].setLabel("");
									bt[i + 3].setBackground(Color.blue);
									flagout = 1;
								} else if (temp2 == temp3) {
									bt[i + 1].setLabel(Integer.toString(temp2 + temp3));
									int temp = temp2 + temp3;
									score = score + temp;
									lb.setText(Integer.toString(score));
									bt[i + 2].setLabel(bt[i + 3].getLabel());
									bt[i + 3].setLabel("");
									bt[i + 3].setBackground(Color.blue);
									flagout = 1;
								} else {

								}
							}
						}
					}
				}
			}
			int random1, random2, flagfill = 0;
			while (true) {
				random1 = (int) (0 + 100 * Math.random());
				random2 = (int) (0 + 15 * Math.random());
				if (bt[random2].getLabel().equals("")) {
					if (random1 % 2 == 0) {
						bt[random2].setLabel("2");
						bt[random2].setBackground(Color.black);
					} else {
						bt[random2].setLabel("4");
						bt[random2].setBackground(Color.black);
					}
					flagfill = 1;
					break;
				}
			}
			if (flagfill == 0 && flagout == 0) {
				bt_down.setEnabled(false);
				bt_left.setEnabled(false);
				bt_up.setEnabled(false);
				bt_right.setEnabled(false);
				JOptionPane.showMessageDialog(this, "Game Over,Your Score is " + score);
			} else {
				flagfill = 0;
				flagout = 0;
			}
		}
		if (e.getSource() == bt_restart) {
			for (int i = 0; i <= 15; i++) {
				bt[i].setLabel("");
				bt[i].setBackground(Color.blue);
			}
			random1 = (int) (100 + 899 * Math.random());
			random2 = (int) (1000 + 999 * Math.random());
			random3 = (int) (0 + 15 * Math.random());
			random4 = (int) (0 + 15 * Math.random());
			while (true) {
				if (random3 == random4) {
					random4 = (int) (0 + 15 * Math.random());
				} else {
					bt[random3].setBackground(Color.black);
					bt[random4].setBackground(Color.black);
					if (random1 % 2 == 0) {
						bt[random3].setLabel("2");
					} else {
						bt[random3].setLabel("4");
					}
					if (random2 % 2 == 0) {
						bt[random4].setLabel("2");
					} else {
						bt[random4].setLabel("4");
					}
					break;
				}
			}
		}
		for (int i = 0; i <= 15; i++) {
			if (bt[i].getLabel().equals("2")) {
				bt[i].setBackground(Color.white);
			}
			if (bt[i].getLabel().equals("4")) {
				bt[i].setBackground(Color.orange);
			}
			if (bt[i].getLabel().equals("8")) {
				bt[i].setBackground(Color.pink);
			}
			if (bt[i].getLabel().equals("16")) {
				bt[i].setBackground(Color.green);
			}
			if (bt[i].getLabel().equals("32")) {
				bt[i].setBackground(Color.gray);
			}
			if (bt[i].getLabel().equals("64")) {
				bt[i].setBackground(Color.magenta);
			}
			if (bt[i].getLabel().equals("128")) {
				bt[i].setBackground(Color.yellow);
			}
			if (bt[i].getLabel().equals("256")) {
				bt[i].setBackground(Color.DARK_GRAY);
			}
			if (bt[i].getLabel().equals("512")) {
				bt[i].setBackground(Color.LIGHT_GRAY);
			}
			if (bt[i].getLabel().equals("1024")) {
				bt[i].setBackground(Color.red);
			}
			if (bt[i].getLabel().equals("2048")) {
				bt[i].setBackground(Color.red);
			}
			if (bt[i].getLabel().equals("4096")) {
				bt[i].setBackground(Color.red);
			}
			if (bt[i].getLabel().equals("8192")) {
				bt[i].setBackground(Color.red);
			}
			if (bt[i].getLabel().equals("16384")) {
				bt[i].setBackground(Color.red);
			}
		}
	}

	public static void main(String[] args) {
		Game g = new Game();
	}

}
