package org.filtro;

import org.filtro.controller.AvionController;

import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int optionManager = 0;
        int optionCrud = 0;
        do{
            optionManager = Integer.parseInt(JOptionPane.showInputDialog("""
                    1. Plane Manager
                    2.vuelo manager
                    3.pasajeros manager
                    5.exit
                    
                    
                    
                    """));
            switch (optionManager){
                case 1:
                    do{
                        optionCrud = Integer.parseInt(JOptionPane.showInputDialog("""
                                1.create vuelo
                                2.delete vuelo
                                3.update vuelo
                                5.exit
                                
                                
                                
                                """));
                        switch (optionCrud){
                            case 1:
                                AvionController.create();
                        }

                    }while(optionCrud != 5);
                    break;

            }

        }while (optionManager != 5);
        JOptionPane.showMessageDialog(null, "Gracias por usar nuestra app");

    }
    private static void listAllAviones(AvionDAO avionDAO) {
        ArrayList<AvionEntity> aviones = avionDAO.findAll();
        StringBuilder sb = new StringBuilder("List of Aviones:\n");
        for (AvionEntity avion : aviones) {
            sb.append("ID: ").append(avion.getIdAvion())
                    .append(", Model: ").append(avion.getModelo())
                    .append(", Capacity: ").append(avion.getCapacidad())
                    .append("\n");
        }
        JOptionPane.showMessageDialog(null, sb.toString());
    }

    private static int getValidIntegerInput(String message, int min, int max) {
        while (true) {
            String input = JOptionPane.showInputDialog(message);
            if (input == null || input.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "La entrada no puede estar vacía. Intente nuevamente.");
                continue;
            }
            try {
                int value = Integer.parseInt(input.trim());
                if (value >= min && value <= max) {
                    return value;
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese un número entre " + min + " y " + max + ".");
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Entrada inválida. Por favor, ingrese un número válido.");
            }
        }
    }
}
}