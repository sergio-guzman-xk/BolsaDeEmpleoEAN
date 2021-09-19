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
public class PanelBusquedaOrdenamiento extends JPanel implements ActionListener {
    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    private static final String BUSCAR = "Buscar";
    private static final String ORDENAR_ANIOSEXPERIENCIA = "OrdenaraniosExperiencia";
    private static final String ORDENAR_EDAD = "OrdenarEdad";
    private static final String ORDENAR_PROFESION = "OrdenarProfesion";

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
     * Es el bot�n para ordenar la lista de aspirantes por a�os de experiencia
     */
    private JButton botonOrdenarAniosExperiencia;

    /**
     * Es el bot�n para ordenar la lista de aspirantes por edad
     */
    private JButton botonOrdenarEdad;

    /**
     * Es el bot�n para ordenar lista de aspirantes por nombre
     */
    private JButton botonOrdenarProfesion;

    /**
     * Es el bot�n para realizar una b�squeda
     */
    private JButton botonBuscar;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye el panel e inicializa todos sus componentes
     * @param interfaz Es una referencia a la clase principal de la interfaz - interfaz != null
     */
    public PanelBusquedaOrdenamiento(InterfazBolsaDeEmpleo interfaz) {
        principal = interfaz;
        setLayout(new GridBagLayout());
        setBorder(new TitledBorder("B�squeda y Ordenamiento"));

        botonOrdenarAniosExperiencia = new JButton("Ordenar por experiencia");
        botonOrdenarAniosExperiencia.setActionCommand(ORDENAR_ANIOSEXPERIENCIA);
        botonOrdenarAniosExperiencia.addActionListener(this);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.insets = new Insets(5, 18, 5, 18);
        add(botonOrdenarAniosExperiencia, gbc);

        botonOrdenarEdad = new JButton("Ordenar por Edad");
        botonOrdenarEdad.setActionCommand(ORDENAR_EDAD);
        botonOrdenarEdad.addActionListener(this);
        gbc.gridy = 1;
        add(botonOrdenarEdad, gbc);

        botonOrdenarProfesion = new JButton("Ordenar por profesi�n");
        botonOrdenarProfesion.setActionCommand(ORDENAR_PROFESION);
        botonOrdenarProfesion.addActionListener(this);
        gbc.gridy = 2;
        add(botonOrdenarProfesion, gbc);

        botonBuscar = new JButton("Buscar Aspirante");
        botonBuscar.setActionCommand(BUSCAR);
        botonBuscar.addActionListener(this);
        gbc.gridy = 3;
        add(botonBuscar, gbc);

    }

    // -----------------------------------------------------------------
    // M�todos
    // -----------------------------------------------------------------

    /**
     * Ejecuta una acci�n seg�n el bot�n que se haya presionado
     * @param evento El evento de click sobre un bot�n - evento!=null
     */
    public void actionPerformed(ActionEvent evento) {
        String comando = evento.getActionCommand();

        if (ORDENAR_ANIOSEXPERIENCIA.equals(comando)) {
            principal.ordenarPorAniosExperiencia();
        }
        if (ORDENAR_EDAD.equals(comando)) {
            principal.ordenarPorEdad();
        }
        if (ORDENAR_PROFESION.equals(comando)) {
            principal.ordenarPorProfesion();
        }
        else if (BUSCAR.equals(comando)) {
            principal.buscar();
        }
    }

}
