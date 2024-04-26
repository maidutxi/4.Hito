package src;

import javax.swing.*;

public class VisualizadorFotos extends JFrame {
    private JComboBox<Fotografo> comboBoxFotografos;
    private JLabel labelFotografo;
    private JXDatePicker datePicker;
    private JLabel labelFecha;
    private JList<Fotografia> listFotos;
    private JLabel labelImagen;

    // Constructor
    public VisualizadorFotos() {
        // Configurar la ventana
        setTitle("Visualizador de Fotos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2));

        // Componentes
        comboBoxFotografos = new JComboBox<>();
        labelFotografo = new JLabel("Photographer");
        datePicker = new JXDatePicker();
        labelFecha = new JLabel("Photos after");
        listFotos = new JList<>();
        labelImagen = new JLabel();


        // Ajustar el tamaño del JComboBox
        comboBoxFotografos.setPreferredSize(labelFotografo.getPreferredSize());

        // Estilo del JXDatePicker
        datePicker.setFormats("dd/MM/yyyy");
        datePicker.setLightWeightPopupEnabled(true);

        // Crear paneles para organizar los componentes y etiquetas
        JPanel panelComboBox = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JPanel panelDatePicker = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Agregar componentes y etiquetas a los paneles
        panelComboBox.add(labelFotografo);
        panelComboBox.add(comboBoxFotografos);
        panelDatePicker.add(labelFecha);
        panelDatePicker.add(datePicker);

        // Agregar paneles a la ventana
        add(panelComboBox);
        add(panelDatePicker);
        add(new JScrollPane(listFotos));
        add(labelImagen);


        // Eventos
        comboBoxFotografos.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cargarFotos();
            }
        });

        // Cargar fotógrafos en el JComboBox
        cargarFotografos();
    }

    // Método para cargar los fotógrafos desde la base de datos
    private void cargarFotografos() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM Fotografos");

            while (rs.next()) {
                int id = rs.getInt("IdFotografo");
                String nombre = rs.getString("Nombre");
                boolean premiado = rs.getBoolean("Premiado");
                comboBoxFotografos.addItem(new Fotografo(id, nombre, premiado));
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los fotógrafos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}