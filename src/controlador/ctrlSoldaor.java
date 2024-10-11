package controlador;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import vista.AgregaSoldador;
import modelo.AgregarSoldador;

public class ctrlSoldaor implements MouseListener {
    private AgregarSoldador modelo;
    private AgregaSoldador vista;

    public ctrlSoldaor(AgregarSoldador modelo, AgregaSoldador vista) {
        this.modelo = modelo;
        this.vista = vista;

        vista.btnAgregar25.addMouseListener(this);
        modelo.Mostrar(vista.jtSoldador);
        vista.btnActualizar.addMouseListener(this);
        vista.jtSoldador.addMouseListener(this);
        vista.btnEliminar.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == vista.btnAgregar25) {
            agregarSoldador();
        } else if (e.getSource() == vista.btnEliminar) {
            eliminarSoldador();
        } else if (e.getSource() == vista.jtSoldador) {
            modelo.cargarDatosTabla(vista);
        } else if (e.getSource() == vista.btnActualizar) {
            actualizarSoldador();
        }
    }

    private void agregarSoldador() {
        modelo.setNombre(vista.txtNombre.getText());

        // Validar edad
        String edadTexto = vista.txtEdad.getText().trim();
        System.out.println("Texto de edad: '" + edadTexto + "'");
        if (isNumeric(edadTexto)) {
            modelo.setEdad(Integer.parseInt(edadTexto));
        } else {
            System.out.println("Error: Edad no válida.");
            return;
        }

        // Validar peso
        String pesoTexto = vista.txtPeso25.getText().trim();
        if (isNumeric(pesoTexto)) {
            modelo.setPeso(Integer.parseInt(pesoTexto));
        } else {
            System.out.println("Error: Peso no válido.");
            return;
        }

        modelo.setCorreo(vista.txtCorreo25.getText());
        modelo.GuardarCo();
        modelo.Mostrar(vista.jtSoldador);
    }

    private void eliminarSoldador() {
        modelo.Eliminar(vista.jtSoldador);
        modelo.Mostrar(vista.jtSoldador);
    }

    private void actualizarSoldador() {
        modelo.setNombre(vista.txtNombre.getText());

        // Validar edad
        String edadTexto = vista.txtEdad.getText().trim();
        System.out.println("Texto de edad: '" + edadTexto + "'");
        if (isNumeric(edadTexto)) {
            modelo.setEdad(Integer.parseInt(edadTexto));
        } else {
            System.out.println("Error: Edad no válida.");
            return;
        }

        // Validar peso
        String pesoTexto = vista.txtPeso25.getText().trim();
        if (isNumeric(pesoTexto)) {
            modelo.setPeso(Integer.parseInt(pesoTexto));
        } else {
            System.out.println("Error: Peso no válido.");
            return;
        }

        modelo.setCorreo(vista.txtCorreo25.getText());
        modelo.Actualizar(vista.jtSoldador);
        modelo.Mostrar(vista.jtSoldador);
    }

    private boolean isNumeric(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}
}
