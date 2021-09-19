/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * Universidad Ean (Bogot� - Colombia)
 * Departamento de Tecnolog�a de la Informaci�n y Comunicaciones
 * Licenciado bajo el esquema Academic Free License version 2.1
 * <p>
 * Basado en un Proyecto Cupi2 (http://cupi2.uniandes.edu.co)
 * Ejercicio: Bolsa de Empleo
 * Fecha: 11 de marzo de 2021
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package universidadean.empleo.interfaz;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel con las opciones para realizaci�n de consultas
 */
public class PanelConsultas extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String CONTRATAR = "Contratar";
    private static final String MAS_JOVEN = "M�s joven";
    private static final String MAYOR_EXPERIENCIA = "Mayor experiencia";
    private static final String MAYOR_EDAD = "Mayor edad";
    private static final String ELIMINAR_POR_EXPERIENCIA = "Eliminar por Experiencia";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Es una referencia a la clase principal de la interfaz
     */
    private InterfazBolsaDeEmpleo principal;

    // -----------------------------------------------------------------
    // Atributos de la Interfaz
    // -----------------------------------------------------------------

    /**
     * Es el bot�n para mostrar la informaci�n del aspirante m�s joven
     */
    private JButton botonMasJoven;

    /**
     * Es el bot�n mostrar la informaci�n del aspirante de mayor edad
     */
    private JButton botonMayorEdad;

    /**
     * Es el bot�n mostrar la informaci�n del aspirante de mayor experiencia
     */
    private JButton botonMayorExperiencia;

    /**
     * Es el bot�n para realizar una contrataci�n
     */
    private JButton botonContratar;

    /**
     * Es el bot�n para eliminar los aspirantes po a�os de experiencia
     */
    private JButton botonEliminarPorExperiencia;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa sus componentes
     * @param ventanaPrincipal Ventana principal de la aplicaci�n. ventanaPrincipal!=null
     */
    public PanelConsultas(InterfazBolsaDeEmpleo ventanaPrincipal) {
        principal = ventanaPrincipal;
        setLayout(new GridBagLayout());
        setBorder(new TitledBorder("Consultas"));

        botonMasJoven = new JButton("M�s Joven");
        botonMasJoven.addActionListener(this);
        botonMasJoven.setActionCommand(MAS_JOVEN);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 18, 5, 18);
        add(botonMasJoven, gbc);

        botonMayorEdad = new JButton("Mayor Edad");
        botonMayorEdad.addActionListener(this);
        botonMayorEdad.setActionCommand(MAYOR_EDAD);
        gbc.gridy = 1;
        add(botonMayorEdad, gbc);

        botonMayorExperiencia = new JButton("Mayor Experiencia");
        botonMayorExperiencia.addActionListener(this);
        botonMayorExperiencia.setActionCommand(MAYOR_EXPERIENCIA);
        gbc.gridy = 2;
        add(botonMayorExperiencia, gbc);

        botonContratar = new JButton("Contratar");
        botonContratar.addActionListener(this);
        botonContratar.setActionCommand(CONTRATAR);
        gbc.gridy = 3;
        add(botonContratar, gbc);

        botonEliminarPorExperiencia = new JButton("Eliminar por Experiencia");
        botonEliminarPorExperiencia.addActionListener(this);
        botonEliminarPorExperiencia.setActionCommand(ELIMINAR_POR_EXPERIENCIA);
        gbc.gridy = 4;
        add(botonEliminarPorExperiencia, gbc);

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta una acci�n seg�n el bot�n que se haya presionado
     * @param evento El evento de click sobre un bot�n. evento!=null
     */
    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();

        if (MAS_JOVEN.equals(comando)) {
            principal.buscarMasJoven();
        }
        else if (MAYOR_EXPERIENCIA.equals(comando)) {
            principal.buscarMayorExperiencia();
        }
        else if (MAYOR_EDAD.equals(comando)) {
            principal.buscarMayorEdad();
        }
        else if (CONTRATAR.equals(comando)) {
            principal.contratar();
        }
        else if (ELIMINAR_POR_EXPERIENCIA.equals(comando)) {
            principal.eliminarPorExperiencia();
        }
    }
}
