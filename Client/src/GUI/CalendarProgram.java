package GUI;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class CalendarProgram{
    static JLabel lblWeek;
    static JButton btnPrev, btnNext;
    static JTable tblCalendar;
    static JComboBox cmbYear;
    static JFrame frmMain;
    static Container pane;
    static DefaultTableModel mtblCalendar; //Table model
    static JScrollPane stblCalendar; //The scrollpane
    static JPanel pnlCalendar;
    static int realYear, realWeek, realDay, currentYear, currentWeek;
    private static JButton btnOpretEvent;
    private static JButton btnOpretNoteTil;
    private static JButton btnDato;
    private static JButton button;
    private static JButton btnSeDato;
    private static JButton btnSeDato_1;
    private static JButton btnSeDato_2;
    private static JButton btnSeDato_3;
    private static JButton btnSeDato_4;
    
    public static void main (String args[]){
        //Look and feel
        try {UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());}
        catch (ClassNotFoundException e) {}
        catch (InstantiationException e) {}
        catch (IllegalAccessException e) {}
        catch (UnsupportedLookAndFeelException e) {}
        
        //Prepare frame
        frmMain = new JFrame ("CBS Calendar"); //Create frame
        frmMain.setSize(821, 342); //Set size to 400x400 pixels
        pane = frmMain.getContentPane();
        frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //Close when X is clicked
        
        //Create controls
        lblWeek = new JLabel ("Uge 1");
        lblWeek.setBounds(388, 38, 180, 25);
        cmbYear = new JComboBox();
        cmbYear.setBounds(625, 248, 160, 30);
        btnPrev = new JButton ("Tilbage");
        btnPrev.setBounds(177, 25, 100, 50);
        btnNext = new JButton ("Næste");
        btnNext.setBounds(583, 25, 100, 50);
        mtblCalendar = new DefaultTableModel(){public boolean isCellEditable(int rowIndex, int mColIndex){return false;}};
        tblCalendar = new JTable(mtblCalendar);
        stblCalendar = new JScrollPane(tblCalendar);
        stblCalendar.setBounds(15, 79, 773, 36);
        pnlCalendar = new JPanel(null);
        pnlCalendar.setBounds(0, 0, 808, 523);
        
        //Set border
        pnlCalendar.setBorder(BorderFactory.createTitledBorder("Week view"));
        
        //Register action listeners
        btnPrev.addActionListener(new btnPrev_Action());
        btnNext.addActionListener(new btnNext_Action());
        cmbYear.addActionListener(new cmbYear_Action());
        frmMain.getContentPane().setLayout(null);
        
        //Add controls to pane
        pane.add(pnlCalendar);
        pnlCalendar.setLayout(null);
        pnlCalendar.add(lblWeek);
        
        btnOpretEvent = new JButton("Opret event");
        btnOpretEvent.setBounds(15, 241, 131, 45);
        btnOpretEvent.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        btnOpretNoteTil = new JButton("Opret note til event");
        btnOpretNoteTil.setBounds(179, 241, 169, 45);
        btnOpretNoteTil.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        	}
        });
        pnlCalendar.add(btnOpretNoteTil);
        
        btnSeDato = new JButton("Se dato1");
        btnSeDato.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnSeDato.setBounds(234, 119, 112, 45);
        pnlCalendar.add(btnSeDato);
        
        btnDato = new JButton("Dato");
        btnDato.setBounds(15, 119, 112, 45);
        pnlCalendar.add(btnDato);
        
        btnSeDato_1 = new JButton("se dato2");
        btnSeDato_1.setBounds(343, 119, 112, 45);
        pnlCalendar.add(btnSeDato_1);
        
        btnSeDato_4 = new JButton("se dato5");
        btnSeDato_4.setBounds(673, 119, 115, 45);
        pnlCalendar.add(btnSeDato_4);
        
        button = new JButton("New button");
        button.setBounds(124, 119, 112, 45);
        pnlCalendar.add(button);
        
        btnSeDato_3 = new JButton("se dato4");
        btnSeDato_3.setBounds(564, 119, 115, 45);
        pnlCalendar.add(btnSeDato_3);
        
        btnSeDato_2 = new JButton("se dato3");
        btnSeDato_2.setBounds(452, 119, 115, 45);
        pnlCalendar.add(btnSeDato_2);
        pnlCalendar.add(btnOpretEvent);
        pnlCalendar.add(cmbYear);
        pnlCalendar.add(btnPrev);
        pnlCalendar.add(btnNext);
        pnlCalendar.add(stblCalendar);
        
        //Make frame visible
        frmMain.setResizable(false);
        frmMain.setVisible(true);
        
        //Get real week/year
        GregorianCalendar cal = new GregorianCalendar(); //Create calendar
        realDay = cal.get(GregorianCalendar.DAY_OF_WEEK); //Get day
        realWeek = cal.get(GregorianCalendar.WEEK_OF_YEAR); //Get week
        realYear = cal.get(GregorianCalendar.YEAR); //Get year
        currentWeek = realWeek; //Match week and year
        currentYear = realYear;
        
        //Add headers
        String[] headers = {"Søn", "Man", "Tirs", "Ons", "Tors", "Fre", "Lør"}; //All headers
        for (int i=0; i<7; i++){
            mtblCalendar.addColumn(headers[i]);
        }
        
        tblCalendar.getParent().setBackground(tblCalendar.getBackground()); //Set background
        
        //No resize/reorder
        tblCalendar.getTableHeader().setResizingAllowed(false);
        tblCalendar.getTableHeader().setReorderingAllowed(false);
        
        //Single cell selection
        tblCalendar.setColumnSelectionAllowed(true);
        tblCalendar.setRowSelectionAllowed(true);
        tblCalendar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
               //Populate table
      for (int i=realYear; i<=realYear+100; i++){
           cmbYear.addItem(String.valueOf(i));
        }
        
        //Refresh calendar
        refreshCalendar (realWeek, realYear); //Refresh calendar
    }
    
    public static void refreshCalendar(int week, int year){
    	
    	//Variables
        String[] weeks =  {"Uge 1", "Uge 2", "Uge 3", "Uge 4", "Uge 5", "Uge 6", "Uge 7", "Uge 8", "Uge 9", "Uge 10", "Uge 11", "Uge 12", "Uge13", "Uge 14", "Uge 15", "Uge 16", "Uge 17", "Uge 18", "Uge 19", "Uge 20", "Uge 21", "Uge 22", "Uge 23", "Uge 24", "Uge 25", "Uge 26", "Uge 27", "Uge 28", "Uge 29", "Uge 30", "Uge 31", "Uge 32", "Uge 33", "Uge 34", "Uge 35", "Uge 36", "Uge 37", "Uge 38", "Uge 39", "Uge 40", "Uge 41", "Uge 52", "Uge 43", "Uge 44", "Uge 45", "Uge 46", "Uge 47", "Uge 48", "Uge 49", "Uge 50", "Uge 51", "Uge 52"};
        int nod, som; //Number of week
        
        //Allow/disallow buttons
        btnPrev.setEnabled(true);
        btnNext.setEnabled(true);
        if (week == 0 && year <= realYear-10){btnPrev.setEnabled(false);} //Too early
        if (week == 51 && year >= realYear+100){btnNext.setEnabled(false);} //Too late
        lblWeek.setText(weeks[week-1]);
        cmbYear.setSelectedItem(String.valueOf(year)); //Select the correct year in the combo box
        
        //Clear table
        for (int i=0; i<6; i++){
            for (int j=0; j<7; j++){
                mtblCalendar.setValueAt(null, i, j);
            }
        }
        
        //Get first day of month and number of days
        GregorianCalendar cal = new GregorianCalendar(year, week, 1);
        nod = cal.getActualMaximum(GregorianCalendar.WEEK_OF_YEAR);
        som = cal.get(GregorianCalendar.DAY_OF_WEEK);
        
        //Draw calendar
        for (int i=1; i<=nod; i++){
            int row = new Integer((i+som-2)/30);
            int column  =  (i+som-2)%30;
            mtblCalendar.setValueAt(i, row, column);
        }
        
        //Apply renderers
        tblCalendar.setDefaultRenderer(tblCalendar.getColumnClass(0), new tblCalendarRenderer());
    }
    
    static class tblCalendarRenderer extends DefaultTableCellRenderer{
        public Component getTableCellRendererComponent (JTable table, Object value, boolean selected, boolean focused, int row, int column){
            super.getTableCellRendererComponent(table, value, selected, focused, row, column);
            if (column == 0 || column == 6){ //Week-end
                setBackground(new Color(255, 220, 220));
            }
            else{ //Week
                setBackground(new Color(255, 255, 255));
            }
            if (value != null){
                if (Integer.parseInt(value.toString()) == realDay && currentWeek == realWeek && currentYear == realYear){ //Today
                    setBackground(new Color(220, 220, 255));
                }
            }
            setBorder(null);
            setForeground(Color.black);
            return this;
        }
    }
    
    static class btnPrev_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentWeek == 0){ //Back one year
                currentWeek = 51;
                currentYear -= 1;
            }
            else{ //Back one Week
            	currentWeek -= 1;
            }
            refreshCalendar(currentWeek, currentYear);
        }
    }
    static class btnNext_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (currentWeek == 51){ //Foward one year
                currentWeek = 0;
                currentYear += 1;
            }
            else{ //Foward one week
                currentWeek += 1;
            }
            refreshCalendar(currentWeek, currentYear);
        }
    }
    static class cmbYear_Action implements ActionListener{
        public void actionPerformed (ActionEvent e){
            if (cmbYear.getSelectedItem() != null){
                String b = cmbYear.getSelectedItem().toString();
                currentYear = Integer.parseInt(b);
                refreshCalendar(currentWeek, currentYear);
            }
        }
    }
            }
