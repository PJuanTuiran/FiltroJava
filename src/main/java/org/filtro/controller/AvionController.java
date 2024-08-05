package org.filtro.controller;

import org.filtro.entities.AvionEntity;
import org.filtro.models.AvionModel;

import javax.swing.*;

public class AvionController {

    public static void create(){






                String modelo = "";
                while (modelo.isEmpty()) {
                    modelo = JOptionPane.showInputDialog("Insert the model of the plane");
                    if (modelo == null || modelo.trim().isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Model cannot be empty. Please enter a valid model.");
                        modelo = "";
                    }
                }

                int capacidad = -1;
                while (capacidad <= 0) {
                    String capacidadStr = JOptionPane.showInputDialog("Insert the capacity of plane");
                    try {
                        capacidad = Integer.parseInt(capacidadStr);
                        if (capacidad <= 0) {
                            JOptionPane.showMessageDialog(null, "Capacity must be a positive number. Please enter a valid capacity.");
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Invalid input. Please enter a valid number for capacity.");
                    }
                }

                AvionEntity avionEntity = new AvionEntity(modelo, capacidad);
                AvionModel avionModel = new AvionModel();
                AvionEntity avionCreated = avionModel.create(avionEntity);

                JOptionPane.showMessageDialog(null, "Plane created successfully!");
            }

            public static void delete(){
                int
            }










}
