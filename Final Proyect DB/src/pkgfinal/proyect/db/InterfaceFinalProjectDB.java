
package pkgfinal.proyect.db;

import java.sql.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static pkgfinal.proyect.db.ConsultProfessor.jTextFieldSearch;
import static pkgfinal.proyect.db.Conexion.getConection;

/**
 *
 * @author Angelius
 * 
 */



public class InterfaceFinalProjectDB extends javax.swing.JFrame {

    /**
     * Creates new form InterfaceFinalProjectDB
     */
        Connection conn = null;
	Statement stmt = null;
	BufferedReader in = null;

	static final String URL = "jdbc:mysql://localhost/";
	static final String BD = "practiceDB";		// name of the data base
	static final String USER = "root";		// name of the user
        static final String PASSWD = "password";//   password of the user
            
            
    
    public InterfaceFinalProjectDB() throws SQLException, Exception{
        
        initComponents();
          
        	// this will load the MySQL driver, each DB has its own driver
		Class.forName( "com.mysql.cj.jdbc.Driver" );
		System.out.print( "Connecting to the database... " );
             

		// setup the connection with the DB
		conn = DriverManager.getConnection( URL+BD, USER, PASSWD );
		System.out.println( "connected\n\n" );
                jTextArea2.setText( " Connecting to the database... \n Connected \n All ready! \n "
                        + "Nivel de aislamiento = " + conn.getTransactionIsolation() + "\n" );
                

		conn.setAutoCommit( false );         // begginig of the transaction
		stmt = conn.createStatement();
		in = new BufferedReader( new InputStreamReader(System.in) );
        
    }
    

    public DefaultTableModel showProfessor()
    {
        String []  nombresColumnas = {"IDProfessor","NameT","Times"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
    
        String sql = "SELECT * FROM professor";
        
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
            cn = conn;
            pst = cn.prepareStatement(sql);                    
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("IDProfessor");                
                registros[1] = rs.getString("NameT");                
                registros[2] = rs.getString("Times");
                modelo.addRow(registros);     
            }
           }
        catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null,"Error to connect");      
        }
        finally{
            try{
                if (rs != null) rs.close();
                if (pst != null) pst.close();                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
    
        
    
   
    
     public DefaultTableModel showCourses()
    {
        String []  nombresColumnas = {"CourseCode","Section","Title", "Professor"};
        String [] registros = new String[4];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM Course";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = conn;
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("CourseCode");
                
                registros[1] = rs.getString("Section");
                
                registros[2] = rs.getString("Title");
                
                registros[3] = rs.getString("Professor");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
    
         return modelo;
    }
     
     
     
     public DefaultTableModel showAllReservations()
    {
        String []  nombresColumnas = {"RoomID","NameTT","DateTime", "Duration"};
        String [] registros = new String[4];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM reservation";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = conn;
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("RoomId");
                
                registros[1] = rs.getString("NameTT");
                
                registros[2] = rs.getString("DateTimeT");
                
                registros[3] = rs.getString("Duration");
                
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
   
      public DefaultTableModel showRoom()
    {
        String []  nombresColumnas = {"RoomId","Capacity","Type"};
        String [] registros = new String[3];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM room";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = conn;
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("RoomId");
                
                registros[1] = rs.getString("Capacity");
                
                registros[2] = rs.getString("Type");
                              
                modelo.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
      
     public DefaultTableModel showSchedule()
    {
        String []  nombresColumnas = {"KeySche", "Section", "WeekDay", "HourT", "MinuteT", "Duration", "Period", "Semester", "RoomId"};
        String [] registros = new String[9];
        
        DefaultTableModel modeloSchedule = new DefaultTableModel(null,nombresColumnas);
        
        String sql = "SELECT * FROM ScheduleT";
        
        Connection cn = null;
        
        PreparedStatement pst = null;
        
        ResultSet rs = null;
        
        try
        {
            cn = Conexion.getConection();
            
            pst = cn.prepareStatement(sql);                        
            
            rs = pst.executeQuery();
            
            while(rs.next())
            {
                registros[0] = rs.getString("KeySche");  
                registros[1] = rs.getString("Section");
                registros[2] = rs.getString("WeekDay");
                registros[3] = rs.getString("HourT");
                registros[4] = rs.getString("MinuteT");
                registros[5] = rs.getString("Duration");
                registros[6] = rs.getString("Period");
                registros[7] = rs.getString("Semester");
                registros[8] = rs.getString("RoomId");
                              
                modeloSchedule.addRow(registros);
                
            }
            
           
        }
        catch(SQLException e)
        {
            
            JOptionPane.showMessageDialog(null,"Error al conectar");
            
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                
                if (pst != null) pst.close();
                
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modeloSchedule;
    }
    
      
    private void dumpResultSet( ResultSet rset ) throws SQLException {

		ResultSetMetaData rsetmd = rset.getMetaData();
		int i = rsetmd.getColumnCount();

		while( rset.next() ) {

			for( int j = 1; j <= i; j++ ) {
				System.out.print( rset.getString(j) + "\t" );
                             //  ConsultProfessor.jTextArea1Professor.setText(rset.getString(j) + "\t" );
			}
			
                        System.out.println();
		}
	}
    

      private void query( String statement ) throws SQLException {

		ResultSet rset = stmt.executeQuery( statement );
		System.out.println( "Results:" );
                //ConsultProfessor.jTextArea1Professor.setText( "Results: \n" );
		dumpResultSet( rset );

		System.out.println();
		rset.close();
	}

	public void close() throws SQLException {

		stmt.close();
		conn.close();
	}
        
        public boolean menu() throws SQLException, IOException {

		String statement;

	
		return true;
	}

  
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jPanel5 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jTextFieldReservationID = new javax.swing.JTextField();
        jTextFieldReservationNAME = new javax.swing.JTextField();
        jTextFieldReservationDATE = new javax.swing.JTextField();
        jTextFieldReservationDURATION = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField1CourseKey = new javax.swing.JTextField();
        jTextField6Section = new javax.swing.JTextField();
        jTextField7Period = new javax.swing.JTextField();
        jTextField8WeekDay = new javax.swing.JTextField();
        jTextField9Semester = new javax.swing.JTextField();
        jButton8Save = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jTextField1ConfirmHour = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField1ConfirmMinut = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 153, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(1095, 1022));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(0, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("SYSTEM CONSULT FOR RESERVATIONS");
        jLabel1.setOpaque(true);
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-6, 19, 1010, 60));

        jPanel2.setBackground(new java.awt.Color(51, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 310, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 310, 40));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("WELCOME");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 10, 288, 53));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel4.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 680, 250));

        jTabbedPane1.addTab("tab1", jPanel4);

        jPanel5.setBackground(new java.awt.Color(102, 204, 255));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ConsultProfessor.jpg"))); // NOI18N
        jButton4.setText("Professors");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ConsultCourses.jpg"))); // NOI18N
        jButton5.setText("Courses");
        jButton5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ConsultReservations.jpg"))); // NOI18N
        jButton6.setText("All Reservations");
        jButton6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/ConsultRooms.jpg"))); // NOI18N
        jButton7.setText("Rooms");
        jButton7.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        jButton7.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(0, 48, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab2", jPanel5);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel3.setText("Please make your Reservation");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 240, 25));

        jTextField2.setEditable(false);
        jTextField2.setText("DURATION:");
        jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 90, 20));

        jTextField3.setEditable(false);
        jTextField3.setText("YOUR NAME:");
        jPanel3.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 90, -1));

        jTextField4.setEditable(false);
        jTextField4.setText("ID ROOM:");
        jPanel3.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, 90, -1));

        jTextField5.setEditable(false);
        jTextField5.setText("CONFIRM DATE & TIME:");
        jPanel3.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 130, 140, -1));

        jTextFieldReservationID.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldReservationIDKeyTyped(evt);
            }
        });
        jPanel3.add(jTextFieldReservationID, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 130, 280, -1));

        jTextFieldReservationNAME.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldReservationNAMEKeyTyped(evt);
            }
        });
        jPanel3.add(jTextFieldReservationNAME, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 280, -1));
        jPanel3.add(jTextFieldReservationDATE, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 130, 240, -1));
        jPanel3.add(jTextFieldReservationDURATION, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 200, 230, -1));

        jButton3.setBackground(new java.awt.Color(102, 255, 102));
        jButton3.setText("NEXT");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 40, 100, -1));

        jTabbedPane1.addTab("tab3", jPanel3);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("COURSE KEY:");
        jPanel6.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        jLabel5.setText("SECTION:");
        jPanel6.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, -1, -1));

        jLabel6.setText("WEEK DAY:");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, -1, -1));

        jLabel7.setText("PERIOD:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 230, -1, -1));

        jLabel8.setText("SEMESTER:");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 160, -1, -1));
        jPanel6.add(jTextField1CourseKey, new org.netbeans.lib.awtextra.AbsoluteConstraints(169, 90, 170, -1));
        jPanel6.add(jTextField6Section, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 170, -1));
        jPanel6.add(jTextField7Period, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 230, 170, -1));
        jPanel6.add(jTextField8WeekDay, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 170, -1));
        jPanel6.add(jTextField9Semester, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 150, 170, -1));

        jButton8Save.setBackground(new java.awt.Color(102, 255, 102));
        jButton8Save.setText("SAVE");
        jButton8Save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8SaveActionPerformed(evt);
            }
        });
        jPanel6.add(jButton8Save, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 290, 100, -1));

        jLabel9.setText("HOUR:");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 290, -1, -1));
        jPanel6.add(jTextField1ConfirmHour, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 170, -1));

        jLabel10.setText("MINUTE:");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 290, -1, -1));
        jPanel6.add(jTextField1ConfirmMinut, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 290, 170, -1));

        jTabbedPane1.addTab("tab4", jPanel6);

        jPanel1.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(155, 100, 850, 380));

        jButton1.setBackground(new java.awt.Color(102, 255, 204));
        jButton1.setText("Consult");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 130, -1));

        jButton2.setBackground(new java.awt.Color(0, 255, 255));
        jButton2.setText("Make a reservation");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 260, 130, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 525));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jTabbedPane1.setSelectedIndex(1);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jTabbedPane1.setSelectedIndex(2);
        jButton3.setVisible(true);
        
        
        
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldReservationIDKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldReservationIDKeyTyped
        
    }//GEN-LAST:event_jTextFieldReservationIDKeyTyped

    private void jTextFieldReservationNAMEKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldReservationNAMEKeyTyped
        /*
        char c = evt.getKeyChar();
        if (c < '0' || c > '9'){
            evt.consume();
            JOptionPane.showMessageDialog(null, "Please type only numbers...");
        }*/
    }//GEN-LAST:event_jTextFieldReservationNAMEKeyTyped

    
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                  
        DefaultTableModel modelo = new DefaultTableModel();
               
            PreparedStatement ps = null;
            try{
                conn = DriverManager.getConnection( URL+BD, USER, PASSWD );
                ps = conn.prepareStatement("INSERT INTO `practicedb`.`reservation` (`RoomId`, `NameTT`, `DateTimeT`, `Duration`) "
                        + "VALUES (?, ?, ?, ?);");
                ps.setString(1, jTextFieldReservationID.getText());
                ps.setString(2, jTextFieldReservationNAME.getText());
                ps.setString(3, jTextFieldReservationDATE.getText());
                ps.setString(4, jTextFieldReservationDURATION.getText());
                
                ps.execute();
                
                JOptionPane.showMessageDialog(null, "Reservation Done");
                Object[] fila = new Object[4];
                fila[0] = jTextFieldReservationID.getText();
                fila[1] = jTextFieldReservationNAME.getText();
                fila[2] = jTextFieldReservationDATE.getText();
                fila[3] = jTextFieldReservationDURATION.getText();
                modelo.addRow(fila);
            }   catch (SQLException ex) {
                Logger.getLogger(InterfaceFinalProjectDB.class.getName()).log(Level.SEVERE, null, ex);
            }
            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        
              ConsultProfessor buttonConsultProfessor = new ConsultProfessor();
        buttonConsultProfessor.setVisible(true);
        
        try {
         query( "select * from professor" );
     } catch (SQLException ex) {
         Logger.getLogger(InterfaceFinalProjectDB.class.getName()).log(Level.SEVERE, null, ex);
     }
      
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        
        ConsultCourse buttonConsultCourse = new ConsultCourse();
        buttonConsultCourse.setVisible(true);
        
        try {
         query( "select * from course" );
     } catch (SQLException ex) {
         Logger.getLogger(InterfaceFinalProjectDB.class.getName()).log(Level.SEVERE, null, ex);
     }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        
         ConsultRoom buttonConsultRoom = new ConsultRoom();
        buttonConsultRoom.setVisible(true);
        
        try {
         query( "select * from room" );
     } catch (SQLException ex) {
         Logger.getLogger(InterfaceFinalProjectDB.class.getName()).log(Level.SEVERE, null, ex);
     }
        
              
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        
          ConsultReservations buttonConsultAllReservations = new ConsultReservations();
        buttonConsultAllReservations.setVisible(true);
        
        try {
         query( "select * from reservation" );
     } catch (SQLException ex) {
         Logger.getLogger(InterfaceFinalProjectDB.class.getName()).log(Level.SEVERE, null, ex);
     }
        
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8SaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8SaveActionPerformed
        
        DefaultTableModel modeloScheduleB = new DefaultTableModel();
              
            PreparedStatement ps = null;
            try{
                
                ps = conn.prepareStatement("INSERT INTO `practicedb`.`scheduleT` (`KeySche`, `Section`, `WeekDay`, `HourT`, `MinuteT`, "
                        + "`Duration`, `Period`, `Semester`, `RoomId`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);");
                ps.setString(1, jTextField1CourseKey.getText());
                ps.setString(2, jTextField6Section.getText());
                ps.setString(3, jTextField8WeekDay.getText());
                ps.setString(4, jTextField1ConfirmHour.getText());
                ps.setString(5, jTextField1ConfirmMinut.getText());
                ps.setString(6, jTextFieldReservationDURATION.getText());
                ps.setString(7, jTextField7Period.getText());
                ps.setString(8, jTextField9Semester.getText());
                ps.setString(9, jTextFieldReservationID.getText());
                                
                ps.execute();
                
                JOptionPane.showMessageDialog(null, "Reservation Done");
                Object[] fila = new Object[9];
                fila[0] = jTextField1CourseKey.getText();
                fila[1] = jTextField6Section.getText();
                fila[2] = jTextField8WeekDay.getText();
                fila[3] = jTextField1ConfirmHour.getText();
                fila[4] = jTextField1ConfirmMinut.getText();
                fila[5] = jTextFieldReservationDURATION.getText();
                fila[6] = jTextField7Period.getText();
                fila[7] = jTextField9Semester.getText();
                fila[8] = jTextFieldReservationID.getText();
                modeloScheduleB.addRow(fila);
            }   catch (SQLException ex) {
                Logger.getLogger(InterfaceFinalProjectDB.class.getName()).log(Level.SEVERE, null, ex);
            }           
    }//GEN-LAST:event_jButton8SaveActionPerformed

    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) throws SQLException, Exception {

        
        
          /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {                
                    new InterfaceFinalProjectDB().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(InterfaceFinalProjectDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
         
        if( args.length != 0 ) {

			System.err.println( "Use: java TransactionMySQL" );
			System.exit( 1 );
		}

		InterfaceFinalProjectDB transaction = new InterfaceFinalProjectDB();

		while( true )

			try {
				if( ! transaction.menu() )
					break;

			} catch( Exception e ) {

				System.err.println( "failed" );
				e.printStackTrace( System.err );
			}
                transaction.close();
	
      
        
        	
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JButton jButton3;
    public static javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    public static javax.swing.JButton jButton8Save;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea2;
    public static javax.swing.JTextField jTextField1ConfirmHour;
    private javax.swing.JTextField jTextField1ConfirmMinut;
    public static javax.swing.JTextField jTextField1CourseKey;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    public static javax.swing.JTextField jTextField6Section;
    public static javax.swing.JTextField jTextField7Period;
    public static javax.swing.JTextField jTextField8WeekDay;
    public static javax.swing.JTextField jTextField9Semester;
    private javax.swing.JTextField jTextFieldReservationDATE;
    private javax.swing.JTextField jTextFieldReservationDURATION;
    private javax.swing.JTextField jTextFieldReservationID;
    private javax.swing.JTextField jTextFieldReservationNAME;
    // End of variables declaration//GEN-END:variables

}
