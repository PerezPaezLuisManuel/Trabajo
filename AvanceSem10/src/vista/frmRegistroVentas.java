package vista;
import Clases.Ventas;
import Crud.CrudProvedor;
import Crud.CrudVentas;
import Formatos.Mensajes;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Stack;
import javax.swing.JFormattedTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author james
 */
public class frmRegistroVentas extends javax.swing.JInternalFrame {
 
private CrudVentas crudVentas;  
public void actualizarTablaVentas() {
        cargarDatosVentas();
    }

    public frmRegistroVentas() {
      initComponents();
    cargarDatosVentas();

    // Obtén la pila de ventas eliminadas de CrudVentas
 
    }

    private void cargarDatosVentas() {
    DefaultTableModel modelo = (DefaultTableModel)tblVentas.getModel();
    modelo.setRowCount(0);  // Limpia la tabla antes de cargar nuevos datos

    CrudVentas crudVentas = new CrudVentas();
    ResultSet rs = crudVentas.obtenerDatosVentas();

    try {
        while (rs.next()) {
            // Obtiene los datos de la base de datos y agrega una fila a la tabla
            String idVenta = rs.getString("idVenta");
            String DNICliente = rs.getString("DNICliente");
            String idProducto = rs.getString("idProducto");
            Date fechaVenta = rs.getDate("FechaVenta");
            int cantidad = rs.getInt("Cantidad");
            float precioTotal = rs.getFloat("PrecioTotal");

            modelo.addRow(new Object[]{idVenta, DNICliente, idProducto, fechaVenta, cantidad, precioTotal});
        }
    } catch (SQLException ex) {
        Mensajes.M1("ERROR al cargar los registros de ventas: " + ex);
    }

    }
    
   
  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnEliminar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblVentas = new javax.swing.JTable();
        btnOrdenarFecha = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCodigoVenta = new javax.swing.JTextField();
        btnRecuperar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(53, 96, 154));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });
        jPanel1.add(btnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 280, 180, 70));

        tblVentas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "IdVenta", "clienteDNI", "productoId", "fecha", "cantidad", "precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class, java.lang.Integer.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblVentas);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 90, 750, 500));

        btnOrdenarFecha.setText("Ordenar");
        btnOrdenarFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarFechaActionPerformed(evt);
            }
        });
        jPanel1.add(btnOrdenarFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 180, 70));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 48)); // NOI18N
        jLabel1.setText("Ventas Realizadas");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 10, 430, 50));

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\james\\Downloads\\vetm.png")); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 10, 180, 110));

        txtCodigoVenta.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "IDVENTA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Segoe UI", 3, 14))); // NOI18N
        txtCodigoVenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoVentaActionPerformed(evt);
            }
        });
        jPanel1.add(txtCodigoVenta, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 180, 70));

        btnRecuperar.setText("Recuperar");
        btnRecuperar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecuperarActionPerformed(evt);
            }
        });
        jPanel1.add(btnRecuperar, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 470, 170, 70));

        jButton1.setText("Buscar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, 160, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1077, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 655, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
    String codigoVenta = txtCodigoVenta.getText().trim(); // Obtén el código de venta del campo de texto y elimina espacios en blanco alrededor

    if (!codigoVenta.isEmpty()) {
        if (crudVentas.eliminarVentaPorID(codigoVenta)) {
            actualizarTablaVentas(); // Vuelve a cargar los datos de ventas en la tabla
        } else {
            Mensajes.M1("Error al eliminar la venta.");
        }
    } else {
        Mensajes.M1("Ingresa el código de la venta que deseas eliminar.");
    }

    }//GEN-LAST:event_btnEliminarActionPerformed


    private void txtCodigoVentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoVentaActionPerformed
    
      
    }//GEN-LAST:event_txtCodigoVentaActionPerformed

    private void btnOrdenarFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarFechaActionPerformed

    }//GEN-LAST:event_btnOrdenarFechaActionPerformed

    private void btnRecuperarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecuperarActionPerformed
    
               // TODO add your handling code here:
    }//GEN-LAST:event_btnRecuperarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
   String IdVenta = txtCodigoVenta.getText();

    // Paso 2: Verificar si el campo de búsqueda no está vacío.
    if (!IdVenta.isEmpty()) {
        // Paso 3: Realizar una consulta a la base de datos para obtener los datos del Prooverdor por nruc ingresado.
        CrudVentas conexionBD = new CrudVentas();
        ResultSet datosVentas = conexionBD.obtenerVentaPorCodigo(IdVenta);

        DefaultTableModel modeloTabla = (DefaultTableModel) tblVentas.getModel();

        // Paso 4: Limpiar la tabla antes de mostrar los nuevos datos.
        modeloTabla.setRowCount(0);

        try {
            boolean encontrado = false;

            // Paso 5: Llevar a cabo una búsqueda secuencial de los prooveedores en la base de datos.
            while (datosVentas.next()) {
                // Paso 6: Obtener los datos del proovedor
                String codigoVenta = datosVentas.getString("IdVenta");
                String DniCliente = datosVentas.getString("DNICliente");
                String Idproducto = datosVentas.getString("IdProducto");
                Date fechaVenta = datosVentas.getDate("FechaVenta");
                int cantidad = datosVentas.getInt("cantidad");
                 float precioTotal =    datosVentas.getFloat("Preciototal");
                // Paso 7: Agregar los datos del proovedor la tabla.
                modeloTabla.addRow(new Object[]{codigoVenta, DniCliente, Idproducto, fechaVenta, cantidad, precioTotal});
                encontrado = true;
            }

            // Paso 8: Mostrar un mensaje si el proovedor no se encuentra.
            if (!encontrado) {
                Mensajes.M1("Venta no encontrada");
            }

            // Paso 9: Limpiar el campo de búsqueda después de mostrar los resultados.
            txtCodigoVenta.setText("");
        }  catch (SQLException ex) {
            // Paso 9: Manejar errores y mostrar un mensaje de error si ocurre una excepción.
            Mensajes.M1("Error al buscar la venta " + ex);
        } }
    
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton btnEliminar;
    public javax.swing.JButton btnOrdenarFecha;
    public javax.swing.JButton btnRecuperar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable tblVentas;
    public javax.swing.JTextField txtCodigoVenta;
    // End of variables declaration//GEN-END:variables
}