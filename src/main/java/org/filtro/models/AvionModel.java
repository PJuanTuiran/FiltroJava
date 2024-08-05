package org.filtro.models;

import org.filtro.entities.AvionEntity;
import org.filtro.persistence.ConfigDB;
import org.filtro.persistence.imodels.IAvionModel;

import javax.swing.*;
import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AvionModel implements IAvionModel {

    @Override
    public AvionEntity create(AvionEntity request) {
        Connection connection;
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        connection = ConfigDB.openConnection();
        String queryCreate = "INSERT INTO avion(modelo, capacidad) VALUES(?,?)";
        try {
            preparedStatement = connection.prepareStatement(queryCreate, PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, request.getModelo());
            preparedStatement.setInt(2, request.getCapacidad());
            int rowsAffected = preparedStatement.executeUpdate();
            if(rowsAffected > 0){
                result = preparedStatement.getGeneratedKeys();
                if(result.next()){
                    request.setIdAvion(result.getInt(1));
                }
                System.out.println("created succesfull");

            }else{
                System.out.println("An error to create the avion");
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(result != null) result.close();
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) ConfigDB.closeConnection();





            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        return request;
    }

    @Override
    public void delete(String modelo ) {
        PreparedStatement preparedStatement = null;
        Connection connection = ConfigDB.openConnection();
        String queryDelete = "DELETE FROM avion WHERE modelo = ? ";
        try {
            preparedStatement = connection.prepareStatement(queryDelete);
            preparedStatement.setString(1, modelo);
            int rowAffected =  preparedStatement.executeUpdate();
            if(rowAffected > 0){
                JOptionPane.showMessageDialog(null, "Record deleted succesfully");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) ConfigDB.closeConnection();

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }




    }



    @Override
    public void update(AvionEntity object, Integer id) {
        Connection connection = ConfigDB.openConnection();
        PreparedStatement preparedStatement = null;
        String sqlUpdate = "UPDATE avion SET modelo = ? capacidad = ? WHERE id = ?;";

        try{

            preparedStatement = connection.prepareStatement(sqlUpdate);
            preparedStatement.setString(1, object.getModelo());
            preparedStatement.setInt(2, object.getCapacidad());
            preparedStatement.setInt(3, id);
            int row = preparedStatement.executeUpdate();
            if(row > 0){
                System.out.println("registre avtualizado");
                
            }else {
                System.out.println("error");
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public ArrayList<AvionEntity> read(String value) {
        PreparedStatement preparedStatement = null;
        ResultSet result = null;
        ArrayList<AvionEntity> aviones = new ArrayList<>();
        Connection connection = ConfigDB.openConnection();
        String queryRead = "SELECT * FROM avion WHERE modelo = ? ";

        try {
            preparedStatement = connection.prepareStatement(queryRead);
            preparedStatement.setString(1, value);
            result = preparedStatement.executeQuery();
            while(result.next()){
                AvionEntity avion = new AvionEntity();
                avion.setIdAvion(result.getInt(1));
                avion.setModelo(result.getString(2));
                avion.setCapacidad(result.getInt(3));
                aviones.add(avion);

            }



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            try{
                if(result != null) result.close();
                if(preparedStatement != null) preparedStatement.close();
                if(connection != null) ConfigDB.closeConnection();



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }


        return aviones;
    }


}
