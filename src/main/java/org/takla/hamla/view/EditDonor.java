package org.takla.hamla.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.LayoutStyle;
import javax.swing.SpinnerNumberModel;

import org.takla.hamla.control.CancelActionListener;
import org.takla.hamla.control.SaveActionListener;
import org.takla.hamla.control.SaveAndNewActionListener;
import org.takla.hamla.modle.Address;
import org.takla.hamla.modle.Donor;
import org.takla.hamla.run.AllRun;

public class EditDonor extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private ViewDonors viewPane;
	private ViewHamla viewHmalaPane;
	private ButtonGroup buttonGroup1;
	private ButtonGroup buttonGroup2;
	private JButton jButtonCancel;
	private JButton jButtonSave;
	private JButton jButtonSaveNew;
	private JCheckBox jCheckBoxWant;
	private JComboBox<String> jComboBoxChurch;
	private JComboBox<String> jComboBoxFather;
	private JComboBox<String> jComboBoxZone;
	private JComboBox<String> jComboBoxBloodType;
	private JLabel jLabel1;
	private JLabel jLabel12;
	private JLabel jLabel13;
	private JLabel jLabel14;
	private JLabel jLabel15;
	private JLabel jLabel16;
	private JLabel jLabel2;
	private JLabel jLabel3;
	private JLabel jLabel4;
	private JLabel jLabel5;
	private JLabel jLabel6;
	private JLabel jLabel7;
	private JLabel jLabel8;
	private JLabel jLabel9;
	private JLabel jLabel10;
	private JLabel jLabelDay;
	private JLabel jLabelMonth;
	private JLabel jLabelYear;
	private JPanel jPanelLeft;
	private JPanel jPanelRight;
	private JRadioButton jRadioButtonCan;
	private JRadioButton jRadioButtonCannot;
	private JRadioButton jRadioButtonFemale;
	private JRadioButton jRadioButtonMale;
	private JSpinner jSpinnerDay;
	private JSpinner jSpinnerMonth;
	private JSpinner jSpinnerYear;
	private JTextField jTextFieldE_mail;
	private JTextField jTextFieldFlat;
	private JTextField jTextFieldFloor;
	private JTextField jTextFieldHouse;
	private JTextField jTextFieldMobile;
	private JTextField jTextFieldName;
	private JTextField jTextFieldStreet;

	public EditDonor(Donor don, ViewDonors viewPane, boolean editOnly) {
		this.viewPane = viewPane;
		this.setView(don, editOnly);
	}

	public EditDonor(Donor don, ViewHamla pane, boolean editOnly) {
		this.viewHmalaPane = pane;
		this.setView(don, editOnly);
	}

	public void setView(Donor donator, boolean editOnly) {
		this.removeAll();
		this.buttonGroup1 = new ButtonGroup();
		this.buttonGroup2 = new ButtonGroup();
		this.jPanelRight = new JPanel();
		this.jLabel1 = new JLabel();
		this.jLabel2 = new JLabel();
		this.jLabel3 = new JLabel();
		this.jLabel4 = new JLabel();
		this.jLabel5 = new JLabel();
		this.jLabel6 = new JLabel();
		this.jLabel7 = new JLabel();
		this.jLabel8 = new JLabel();
		this.jLabel9 = new JLabel();
		this.jPanelLeft = new JPanel();
		this.jTextFieldName = new JTextField();
		this.jRadioButtonMale = new JRadioButton();
		this.jRadioButtonFemale = new JRadioButton();
		this.jCheckBoxWant = new JCheckBox();
		this.jLabelYear = new JLabel();
		this.jLabelMonth = new JLabel();
		this.jLabelDay = new JLabel();
		this.jTextFieldHouse = new JTextField();
		this.jLabel12 = new JLabel();
		this.jLabel13 = new JLabel();
		this.jLabel10 = new JLabel();
		this.jTextFieldStreet = new JTextField();
		this.jLabel14 = new JLabel();
		this.jLabel15 = new JLabel();
		this.jTextFieldFlat = new JTextField();
		this.jTextFieldFloor = new JTextField();
		this.jLabel16 = new JLabel();
		this.jComboBoxZone = new JComboBox<String>();
		this.jComboBoxBloodType = new JComboBox<String>();
		this.jSpinnerYear = new JSpinner();
		this.jSpinnerMonth = new JSpinner();
		this.jSpinnerDay = new JSpinner();
		this.jComboBoxFather = new JComboBox<String>();
		this.jComboBoxChurch = new JComboBox<String>();
		this.jTextFieldE_mail = new JTextField();
		this.jRadioButtonCan = new JRadioButton();
		this.jRadioButtonCannot = new JRadioButton();
		this.jButtonCancel = new JButton();
		this.jButtonSaveNew = new JButton();
		this.jButtonSave = new JButton();
		this.jTextFieldMobile = new JTextField();
		this.setLayout(new BorderLayout());
		this.jLabel1.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel1.setForeground(new Color(255, 51, 51));
		this.jLabel1.setHorizontalAlignment(4);
		this.jLabel1.setText("الاسم");
		this.jLabel2.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel2.setForeground(new Color(255, 51, 51));
		this.jLabel2.setHorizontalAlignment(4);
		this.jLabel2.setText("النوع");
		this.jLabel3.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel3.setForeground(new Color(255, 51, 51));
		this.jLabel3.setHorizontalAlignment(4);
		this.jLabel3.setText("تاريخ الميلاد");
		this.jLabel4.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel4.setForeground(new Color(255, 51, 51));
		this.jLabel4.setHorizontalAlignment(4);
		this.jLabel4.setText("العنوان");
		this.jLabel5.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel5.setForeground(new Color(255, 51, 51));
		this.jLabel5.setHorizontalAlignment(4);
		this.jLabel5.setText("اب الاعتراف");
		this.jLabel6.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel6.setForeground(new Color(255, 51, 51));
		this.jLabel6.setHorizontalAlignment(4);
		this.jLabel6.setText("الكنيسة");
		this.jLabel7.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel7.setForeground(new Color(255, 51, 51));
		this.jLabel7.setHorizontalAlignment(4);
		this.jLabel7.setText("Mobile");
		this.jLabel8.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel8.setForeground(new Color(255, 51, 51));
		this.jLabel8.setHorizontalAlignment(4);
		this.jLabel8.setText("الحالة");
		this.jLabel9.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel9.setForeground(new Color(255, 51, 51));
		this.jLabel9.setHorizontalAlignment(4);
		this.jLabel9.setText("E_Mail");
		this.jLabel10.setFont(new Font("Times New Roman", 1, 18));
		this.jLabel10.setForeground(new Color(255, 51, 51));
		this.jLabel10.setHorizontalAlignment(4);
		this.jLabel10.setText("فصيلة الدم");
		this.jTextFieldName.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldName.setHorizontalAlignment(4);
		this.jRadioButtonMale.setFont(new Font("Andalus", 0, 18));
		this.jRadioButtonMale.setText("ذكر");
		this.jRadioButtonFemale.setFont(new Font("Andalus", 0, 18));
		this.jRadioButtonFemale.setText("انثى");
		this.jCheckBoxWant.setFont(new Font("Andalus", 0, 18));
		this.jCheckBoxWant.setSelected(true);
		this.jCheckBoxWant.setText(" يريد");
		this.jLabelYear.setFont(new Font("Andalus", 0, 18));
		this.jLabelYear.setHorizontalAlignment(0);
		this.jLabelYear.setText("السنة");
		this.jLabelMonth.setFont(new Font("Andalus", 0, 18));
		this.jLabelMonth.setHorizontalAlignment(0);
		this.jLabelMonth.setText("الشهر");
		this.jLabelDay.setFont(new Font("Andalus", 0, 18));
		this.jLabelDay.setHorizontalAlignment(0);
		this.jLabelDay.setText("اليوم");
		this.jTextFieldHouse.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldHouse.setHorizontalAlignment(0);
		this.jLabel12.setFont(new Font("Andalus", 0, 18));
		this.jLabel12.setHorizontalAlignment(0);
		this.jLabel12.setText("رقم العمارة");
		this.jLabel13.setFont(new Font("Andalus", 0, 18));
		this.jLabel13.setHorizontalAlignment(0);
		this.jLabel13.setText("اسم الشارع");
		this.jTextFieldStreet.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldStreet.setHorizontalAlignment(0);
		this.jLabel14.setFont(new Font("Andalus", 0, 18));
		this.jLabel14.setHorizontalAlignment(0);
		this.jLabel14.setText("المنطقة");
		this.jLabel15.setFont(new Font("Andalus", 0, 18));
		this.jLabel15.setHorizontalAlignment(0);
		this.jLabel15.setText("الشقة");
		this.jTextFieldFlat.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldFlat.setHorizontalAlignment(0);
		this.jTextFieldFloor.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldFloor.setHorizontalAlignment(0);
		this.jLabel16.setFont(new Font("Andalus", 0, 18));
		this.jLabel16.setHorizontalAlignment(0);
		this.jLabel16.setText("الدور");
		this.jTextFieldE_mail.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldE_mail.setHorizontalAlignment(4);
		this.jRadioButtonCan.setFont(new Font("Andalus", 0, 18));
		this.jRadioButtonCan.setText("صالح للتبرع");
		this.jRadioButtonCannot.setFont(new Font("Andalus", 0, 18));
		this.jRadioButtonCannot.setText("غير صالح للتبرع");
		this.jButtonCancel.setFont(new Font("Times New Roman", 1, 20));
		this.jButtonCancel.setText("Cancel");
		this.jButtonSaveNew.setFont(new Font("Times New Roman", 1, 20));
		this.jButtonSaveNew.setText("Save and add new");
		this.jButtonSave.setFont(new Font("Times New Roman", 1, 20));
		this.jButtonSave.setText("save");
		this.jTextFieldMobile.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldMobile.setHorizontalAlignment(4);
		this.jComboBoxBloodType.setFont(new Font("Times New Roman", 0, 18));
		this.jComboBoxBloodType.setModel(new DefaultComboBoxModel<String>(AllRun.basicData.getBloodTypes()));
		GroupLayout jPanelRightLayout = new GroupLayout(this.jPanelRight);
		this.jPanelRight.setLayout(jPanelRightLayout);
		jPanelRightLayout.setHorizontalGroup(jPanelRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanelRightLayout.createSequentialGroup()
						.addGroup(jPanelRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(jPanelRightLayout.createSequentialGroup().addGap(10, 10, 10)
										.addComponent(this.jLabel2, -1, 84, 32767))
						.addGroup(jPanelRightLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel1,
								-1, 84, 32767))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanelRightLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel5,
										-1, 84, 32767))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanelRightLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel6,
										-1, 84, 32767))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanelRightLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel3,
										-1, 84, 32767))
						.addGroup(jPanelRightLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel4,
								-1, 84, 32767))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanelRightLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel9,
										-1, 84, 32767))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanelRightLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel7,
										-1, 84, 32767))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanelRightLayout.createSequentialGroup().addContainerGap().addComponent(this.jLabel8,
										-1, 84, 32767))
								.addGroup(GroupLayout.Alignment.TRAILING, jPanelRightLayout.createSequentialGroup()
										.addContainerGap().addComponent(this.jLabel10, -1, 84, 32767)))
						.addContainerGap()));
		jPanelRightLayout.setVerticalGroup(jPanelRightLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanelRightLayout.createSequentialGroup().addContainerGap()
						.addComponent(this.jLabel1, -2, 29, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jLabel2, -2, 36, -2).addGap(32, 32, 32)
						.addComponent(this.jLabel3, -2, 35, -2).addGap(25, 25, 25)
						.addComponent(this.jLabel4, -2, 34, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(this.jLabel5, -2, 32, -2).addGap(18, 18, 18)
						.addComponent(this.jLabel6, -2, 32, -2).addGap(16, 16, 16)
						.addComponent(this.jLabel7, -2, 36, -2).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(this.jLabel9, -2, 36, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(this.jLabel8, -2, 42, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(this.jLabel10, -2, 42, -2).addContainerGap(56, 32767)));
		this.add((Component) this.jPanelRight, "After");
		this.jTextFieldName.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldName.setHorizontalAlignment(4);
		this.jRadioButtonMale.setFont(new Font("Andalus", 0, 18));
		this.jRadioButtonMale.setText("ذكر");
		this.jRadioButtonFemale.setFont(new Font("Andalus", 0, 18));
		this.jRadioButtonFemale.setText("انثى");
		this.jCheckBoxWant.setFont(new Font("Andalus", 0, 18));
		this.jCheckBoxWant.setSelected(true);
		this.jCheckBoxWant.setText(" يريد");
		this.jLabelYear.setFont(new Font("Andalus", 0, 18));
		this.jLabelYear.setHorizontalAlignment(0);
		this.jLabelYear.setText("السنة");
		this.jLabelMonth.setFont(new Font("Andalus", 0, 18));
		this.jLabelMonth.setHorizontalAlignment(0);
		this.jLabelMonth.setText("الشهر");
		this.jLabelDay.setFont(new Font("Andalus", 0, 18));
		this.jLabelDay.setHorizontalAlignment(0);
		this.jLabelDay.setText("اليوم");
		this.jTextFieldHouse.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldHouse.setHorizontalAlignment(0);
		this.jLabel12.setFont(new Font("Andalus", 0, 18));
		this.jLabel12.setHorizontalAlignment(0);
		this.jLabel12.setText("رقم العمارة");
		this.jLabel13.setFont(new Font("Andalus", 0, 18));
		this.jLabel13.setHorizontalAlignment(0);
		this.jLabel13.setText("اسم الشارع");
		this.jTextFieldStreet.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldStreet.setHorizontalAlignment(0);
		this.jLabel14.setFont(new Font("Andalus", 0, 18));
		this.jLabel14.setHorizontalAlignment(0);
		this.jLabel14.setText("المنطقة");
		this.jLabel15.setFont(new Font("Andalus", 0, 18));
		this.jLabel15.setHorizontalAlignment(0);
		this.jLabel15.setText("الشقة");
		this.jTextFieldFlat.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldFlat.setHorizontalAlignment(0);
		this.jTextFieldFloor.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldFloor.setHorizontalAlignment(0);
		this.jLabel16.setFont(new Font("Andalus", 0, 18));
		this.jLabel16.setHorizontalAlignment(0);
		this.jLabel16.setText("الدور");
		this.jComboBoxZone.setEditable(true);
		this.jComboBoxZone.setFont(new Font("Times New Roman", 1, 20));
		this.jComboBoxZone.setModel(new DefaultComboBoxModel<String>(AllRun.basicData.getZones()));
		this.jSpinnerYear.setFont(new Font("Times New Roman", 0, 18));
		this.jSpinnerYear.setModel(new SpinnerNumberModel((Number) 1988, null, null, (Number) 1));
		this.jSpinnerMonth.setFont(new Font("Times New Roman", 0, 18));
		this.jSpinnerMonth.setModel(new SpinnerNumberModel(1, 1, 12, 1));
		this.jSpinnerDay.setFont(new Font("Times New Roman", 0, 18));
		this.jSpinnerDay.setModel(new SpinnerNumberModel(1, 1, 31, 1));
		this.jComboBoxFather.setEditable(true);
		this.jComboBoxFather.setFont(new Font("Times New Roman", 1, 20));
		this.jComboBoxFather.setModel(new DefaultComboBoxModel<String>(AllRun.basicData.getFathers()));
		this.jComboBoxFather.setSelectedIndex(2);
		this.jComboBoxChurch.setEditable(true);
		this.jComboBoxChurch.setFont(new Font("Times New Roman", 1, 20));
		this.jComboBoxChurch.setModel(new DefaultComboBoxModel<String>(AllRun.basicData.getChurches()));
		this.jComboBoxChurch.setSelectedIndex(1);
		this.jTextFieldE_mail.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldE_mail.setHorizontalAlignment(4);
		this.jRadioButtonCan.setFont(new Font("Andalus", 0, 18));
		this.jRadioButtonCan.setText("صالح للتبرع");
		this.jRadioButtonCannot.setFont(new Font("Andalus", 0, 18));
		this.jRadioButtonCannot.setText("غير صالح للتبرع");
		this.jButtonCancel.setFont(new Font("Times New Roman", 1, 20));
		this.jButtonCancel.setText("Cancel");
		this.jButtonSaveNew.setFont(new Font("Times New Roman", 1, 20));
		this.jButtonSaveNew.setText("Save and add new");
		this.jButtonSave.setFont(new Font("Times New Roman", 1, 20));
		this.jButtonSave.setText("save");
		this.jTextFieldMobile.setFont(new Font("Times New Roman", 1, 20));
		this.jTextFieldMobile.setHorizontalAlignment(4);
		this.jComboBoxBloodType.setFont(new Font("Times New Roman", 0, 18));
		this.jComboBoxBloodType.setModel(new DefaultComboBoxModel<String>(AllRun.basicData.getBloodTypes()));
		GroupLayout jPanelLeftLayout = new GroupLayout(this.jPanelLeft);
		this.jPanelLeft.setLayout(jPanelLeftLayout);
		jPanelLeftLayout.setHorizontalGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanelLeftLayout.createSequentialGroup().addContainerGap()
						.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
								.addGroup(GroupLayout.Alignment.TRAILING,
										jPanelLeftLayout.createSequentialGroup().addComponent(this.jRadioButtonFemale)
												.addGap(18, 18, 18).addComponent(this.jRadioButtonMale))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanelLeftLayout.createSequentialGroup().addGap(93, 93, 93)
										.addComponent(this.jTextFieldName, -1, 373, 32767))
						.addGroup(
								jPanelLeftLayout.createSequentialGroup()
										.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
												.addComponent(this.jComboBoxZone, GroupLayout.Alignment.LEADING, 0, 124,
														32767)
												.addComponent(this.jLabel14, -1, 124, 32767))
								.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(
										jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
												.addComponent(this.jLabel15, GroupLayout.Alignment.TRAILING, -1, -1,
														32767)
												.addComponent(this.jTextFieldFlat, GroupLayout.Alignment.TRAILING, -1,
														51, 32767))
								.addGap(6, 6, 6)
								.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jLabel16, -1, -1, 32767)
										.addComponent(this.jTextFieldFloor, -1, 52, 32767))
								.addGap(6, 6, 6)
								.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.TRAILING)
										.addComponent(this.jLabel13, -1, 144, 32767)
										.addComponent(this.jTextFieldStreet, -1, 144, 32767))
								.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
								.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jLabel12, -1, -1, 32767)
										.addComponent(this.jTextFieldHouse, -1, 67, 32767)))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanelLeftLayout.createSequentialGroup().addComponent(this.jRadioButtonCannot)
										.addGap(18, 18, 18).addComponent(this.jRadioButtonCan))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanelLeftLayout.createSequentialGroup().addGap(97, 97, 97)
										.addComponent(this.jTextFieldE_mail, -1, 369, 32767))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanelLeftLayout.createSequentialGroup().addGap(97, 97, 97)
										.addComponent(this.jTextFieldMobile, -1, 369, 32767))
						.addGroup(GroupLayout.Alignment.TRAILING, jPanelLeftLayout.createSequentialGroup()
								.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jSpinnerDay, -1, 63, 32767)
										.addComponent(this.jLabelDay, -2, 63, -2))
								.addGap(18, 18, 18)
								.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jLabelMonth, -1, -1, 32767)
										.addComponent(this.jSpinnerMonth, -2, 51, -2))
								.addGap(18, 18, 18)
								.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
										.addComponent(this.jLabelYear, -1, -1, 32767)
										.addComponent(this.jSpinnerYear, -2, 70, -2))
								.addGap(18, 18, 18).addComponent(this.jCheckBoxWant))
						.addGroup(GroupLayout.Alignment.TRAILING,
								jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
										.addComponent(this.jComboBoxFather, GroupLayout.Alignment.TRAILING, 0, -1,
												32767)
								.addComponent(this.jComboBoxChurch, GroupLayout.Alignment.TRAILING, 0, -1, 32767))
						.addGroup(jPanelLeftLayout.createSequentialGroup().addComponent(this.jButtonCancel, -2, 101, -2)
								.addGap(18, 18, 18).addComponent(this.jButtonSaveNew).addGap(18, 18, 18)
								.addComponent(this.jButtonSave, -2, 130, -2))
						.addComponent(this.jComboBoxBloodType, GroupLayout.Alignment.TRAILING, -2, -1, -2))
						.addContainerGap()));
		jPanelLeftLayout.setVerticalGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
				.addGroup(jPanelLeftLayout.createSequentialGroup().addContainerGap()
						.addComponent(this.jTextFieldName, -2, 33, -2).addGap(7, 7, 7)
						.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jRadioButtonMale).addComponent(this.jRadioButtonFemale))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jLabelYear, -2, 21, -2).addComponent(this.jLabelMonth, -2, 21, -2)
								.addComponent(this.jLabelDay, -2, 21, -2))
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jCheckBoxWant).addComponent(this.jSpinnerYear, -2, -1, -2)
								.addComponent(this.jSpinnerMonth, -2, -1, -2)
								.addComponent(this.jSpinnerDay, -2, -1, -2))
						.addGap(1, 1, 1)
						.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
								.addGroup(GroupLayout.Alignment.LEADING,
										jPanelLeftLayout.createSequentialGroup().addComponent(this.jLabel12, -2, 25, -2)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(this.jTextFieldHouse, -2, 29, -2))
								.addGroup(GroupLayout.Alignment.LEADING,
										jPanelLeftLayout.createSequentialGroup().addComponent(this.jLabel13, -2, 25, -2)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(this.jTextFieldStreet, -2, 29, -2))
								.addGroup(GroupLayout.Alignment.LEADING,
										jPanelLeftLayout.createSequentialGroup().addComponent(this.jLabel14, -2, 25, -2)
												.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
												.addComponent(this.jComboBoxZone))
								.addGroup(GroupLayout.Alignment.LEADING, jPanelLeftLayout.createSequentialGroup()
										.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
												.addComponent(this.jLabel15, -2, 25, -2)
												.addComponent(this.jLabel16, -2, 25, -2))
										.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
										.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
												.addComponent(this.jTextFieldFloor, -2, 29, -2)
												.addComponent(this.jTextFieldFlat, -2, 29, -2))))
						.addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(this.jComboBoxFather, -2, 34, -2).addGap(18, 18, 18)
						.addComponent(this.jComboBoxChurch, -2, 34, -2).addGap(18, 18, 18)
						.addComponent(this.jTextFieldMobile, -2, 33, -2).addGap(11, 11, 11)
						.addComponent(this.jTextFieldE_mail, -2, 33, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jRadioButtonCan).addComponent(this.jRadioButtonCannot))
						.addGap(18, 18, 18).addComponent(this.jComboBoxBloodType, -2, 26, -2)
						.addPreferredGap(LayoutStyle.ComponentPlacement.RELATED, 26, 32767)
						.addGroup(jPanelLeftLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
								.addComponent(this.jButtonCancel, -2, 33, -2)
								.addComponent(this.jButtonSaveNew, -2, 33, -2)
								.addComponent(this.jButtonSave, -2, 33, -2))
						.addContainerGap()));
		this.add((Component) this.jPanelLeft, "Center");
		this.buttonGroup1.add(this.jRadioButtonCan);
		this.buttonGroup1.add(this.jRadioButtonCannot);
		this.buttonGroup2.add(this.jRadioButtonMale);
		this.buttonGroup2.add(this.jRadioButtonFemale);
		if (!editOnly) {
			this.jButtonSave.addActionListener(new SaveActionListener(this.viewPane, this, donator, false));
			this.jButtonSaveNew.addActionListener(new SaveAndNewActionListener(this.viewPane, this, donator));
			this.jButtonCancel.addActionListener(new CancelActionListener(this.viewPane, this, donator));
		} else {
			this.jButtonSave.addActionListener(new SaveActionListener(this.viewHmalaPane, this, donator, true));
			this.jButtonSaveNew.setEnabled(false);
			this.jButtonCancel
					.addActionListener(new CancelActionListener(this.viewHmalaPane.getJTabbedPaneAll(), this, donator));
		}
		this.jRadioButtonCan.setSelected(true);
		this.jRadioButtonMale.setSelected(true);
		this.jRadioButtonMale.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				EditDonor.this.jCheckBoxWant.setText("يريد");
				EditDonor.this.jRadioButtonCan.setText("صالح للتبرع");
				EditDonor.this.jRadioButtonCannot.setText("غير صالح للتبرع");
			}
		});
		this.jRadioButtonFemale.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				EditDonor.this.jCheckBoxWant.setText("تريد");
				EditDonor.this.jRadioButtonCan.setText("صالحة للتبرع");
				EditDonor.this.jRadioButtonCannot.setText("غير صالحة للتبرع");
			}
		});
		this.jCheckBoxWant.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				boolean temp = false;
				if (EditDonor.this.jCheckBoxWant.isSelected()) {
					temp = true;
				}
				EditDonor.this.jSpinnerDay.setEnabled(temp);
				EditDonor.this.jSpinnerMonth.setEnabled(temp);
				EditDonor.this.jSpinnerYear.setEnabled(temp);
				EditDonor.this.jLabelDay.setEnabled(temp);
				EditDonor.this.jLabelMonth.setEnabled(temp);
				EditDonor.this.jLabelYear.setEnabled(temp);
			}
		});
		this.setName("تعديل");
		if (donator.getId() != -1) {
			if (!donator.isMale().booleanValue()) {
				this.jCheckBoxWant.setText("تريد");
				this.jRadioButtonCan.setText("صالحة للتبرع");
				this.jRadioButtonCannot.setText("غير صالحة للتبرع");
			}
			this.jRadioButtonMale.setSelected(donator.isMale());
			this.jRadioButtonCan.setSelected(donator.isCanDonate());
			this.jTextFieldName.setText(donator.getName());
			this.jTextFieldE_mail.setText(donator.getE_mail());
			this.jTextFieldFlat.setText(donator.getAddress().getFlat());
			this.jTextFieldFloor.setText(donator.getAddress().getFloor());
			this.jTextFieldHouse.setText(donator.getAddress().getHouse());
			this.jTextFieldStreet.setText(donator.getAddress().getStreet());
			this.jTextFieldMobile.setText(donator.getMobile());
			this.jComboBoxChurch.addItem(donator.getChurch());
			this.jComboBoxChurch.setSelectedItem(donator.getChurch());
			this.jComboBoxFather.addItem(donator.getFather());
			this.jComboBoxFather.setSelectedItem(donator.getFather());
			this.jComboBoxBloodType.setSelectedIndex(donator.getBloodType());
			this.jComboBoxZone.addItem(donator.getAddress().getZone());
			this.jComboBoxZone.setSelectedItem(donator.getAddress().getZone());
			this.jRadioButtonMale.setSelected(donator.isMale());
			this.jRadioButtonFemale.setSelected(donator.isMale() == false);
			this.jRadioButtonCan.setSelected(donator.isCanDonate());
			this.jRadioButtonCannot.setSelected(!donator.isCanDonate());
			if (donator.DobToView().compareTo(" ") == 0) {
				this.jCheckBoxWant.setSelected(false);
				boolean temp = false;
				this.jSpinnerDay.setEnabled(temp);
				this.jSpinnerMonth.setEnabled(temp);
				this.jSpinnerYear.setEnabled(temp);
				this.jLabelDay.setEnabled(temp);
				this.jLabelMonth.setEnabled(temp);
				this.jLabelYear.setEnabled(temp);
			} else {
				this.jSpinnerDay.setValue(donator.getDay());
				this.jSpinnerMonth.setValue(donator.getMonth());
				this.jSpinnerYear.setValue(donator.getYear());
			}
			if (!donator.isMale().booleanValue()) {
				this.jRadioButtonFemale.setSelected(true);
			}
			if (!donator.isCanDonate()) {
				this.jRadioButtonCannot.setSelected(true);
			}
		}
		Color r = new Color(255, 0, 0);
		Color w = new Color(255, 255, 255);
		this.jButtonSave.setBackground(r);
		this.jButtonSave.setForeground(w);
		this.jButtonSaveNew.setBackground(r);
		this.jButtonSaveNew.setForeground(w);
		this.jButtonCancel.setBackground(r);
		this.jButtonCancel.setForeground(w);
	}

	public Donor getNewData(int id) {
		int year = 1941;
		int month = 1;
		int day = 1;
		if (this.jCheckBoxWant.isSelected()) {
			year = Integer.parseInt(this.jSpinnerYear.getValue().toString());
			month = Integer.parseInt(this.jSpinnerMonth.getValue().toString());
			day = Integer.parseInt(this.jSpinnerDay.getValue().toString());
		}
		@SuppressWarnings("deprecation")
		Date d = new Date(year - 1, month - 1, day);
		Address add = new Address(this.jTextFieldFlat.getText(), this.jTextFieldFloor.getText(),
				this.jTextFieldHouse.getText(), this.jTextFieldStreet.getText(),
				this.jComboBoxZone.getSelectedItem().toString());
		Donor don = new Donor(id, this.jTextFieldName.getText(), add, this.jTextFieldMobile.getText(),
				this.jTextFieldE_mail.getText(), this.jComboBoxFather.getSelectedItem().toString(),
				this.jComboBoxChurch.getSelectedItem().toString(), this.jComboBoxBloodType.getSelectedIndex(), d,
				this.jRadioButtonMale.isSelected(), this.jRadioButtonCan.isSelected());
		return don;
	}

}
