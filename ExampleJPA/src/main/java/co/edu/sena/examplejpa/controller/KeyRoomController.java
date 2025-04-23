/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.KeyRoom;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;
import java.util.List;

/**
 Date: 25/03/2025
 * @author alejo
 */
public class KeyRoomController implements IKeyRoomController{
    

    @Override
    public void insert(KeyRoom keyRoom) throws Exception {
        if (keyRoom.getId() == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        if ("".equals(keyRoom.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        if ("".equals(keyRoom.getRoom()))
        {
            throw new Exception("La sala es obligatoria");
        }
        if (keyRoom.getCount() == 0)
        {
            throw new Exception("La cantidad es obligatoria");
        }
        if("".equals(keyRoom.getObservation()))
        {
            throw new Exception("La observación es obligatoria");
        }
        //Insert
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().insert(keyRoom);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void update(KeyRoom keyRoom) throws Exception {
        if (keyRoom.getId() == 0)
        {
            throw new Exception("El id es obligatorio");
        }
        if ("".equals(keyRoom.getName()))
        {
            throw new Exception("El nombre es obligatorio");
        }
        if ("".equals(keyRoom.getRoom()))
        {
            throw new Exception("La sala es obligatoria");
        }
        if (keyRoom.getCount() == 0)
        {
            throw new Exception("La cantidad es obligatoria");
        }
        if("".equals(keyRoom.getObservation()))
        {
            throw new Exception("La observación es obligatoria");
        }
        
        if (keyRoom == null)
        {
            throw new Exception("La llave no existe");
        }
        //Merge
        keyRoom.setCount(keyRoom.getCount());
        keyRoom.setName(keyRoom.getName());
        keyRoom.setObservation(keyRoom.getObservation());
        keyRoom.setRoom(keyRoom.getRoom());
        
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().insert(keyRoom);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (id == 0)
        {
            throw new Exception("El ID es obligatorio");
        }
        KeyRoom keyExists = DAOFactory.getKeyRoomDAO().findByID(id);
        if("".equals(keyExists.getName()))
        {
            throw new Exception("La llave no existe");
        }
        EntityManagerHelper.beginTransaction();
        DAOFactory.getKeyRoomDAO().delete(keyExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public List<KeyRoom> findAll() throws Exception {
        return DAOFactory.getKeyRoomDAO().finfAll();
        }
    

    @Override
    public KeyRoom findById(Integer id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
