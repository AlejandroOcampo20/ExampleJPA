/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import java.util.List;
import co.edu.sena.examplejpa.model.Record;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import co.edu.sena.examplejpa.persistence.EntityManagerHelper;

/**
 * Date: 25/03/2025
 *
 * @author alejo
 */
public class RecordController implements IRecordController {

    @Override
    public void insert(Record record) throws Exception {
        if (record == null) {
            throw new Exception("La fecha de grabación es obligatorio");
        }
        if (record.getId() == null) {
            throw new Exception("El inicio de grabación es obligatorio");
        }

        if (record.getDateRecord() == null) {
            throw new Exception("El id de empleado es obligatorio");
        }
        if (record.getStartTime() == null) {
            throw new Exception("La id de llave es obligatoria");
        }
        //FK
        if (record.getEmployeeId() == null) {
            throw new Exception("El status es obligatorio");
        }

        if (record.getKeyId() == null) //La PK no es autoincremental, se debe validar existencia de la grabación
        //Insert
        {
            EntityManagerHelper.beginTransaction();
        }
        DAOFactory.getiRecordDAO().insert(record);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();

    }

    @Override
    public void update(Record record) throws Exception {
        if (record == null) {
            throw new Exception("El empleado es nulo");
        }
        if (record.getId() == 0) {
            throw new Exception("El id no puede ser 0");
        }
        if (record.getDateRecord() == null) {
            throw new Exception("La fecha de grabación es obligatorio");
        }
        if (record.getStartTime() == null) {
            throw new Exception("El inicio de grabación es obligatorio");
        }
        if (record.getEmployeeId() == null) {
            throw new Exception("El id de empleado es obligatorio");
        }
        if (record.getKeyId() == null) {
            throw new Exception("La id de llave es obligatoria");
        }

        //Consultar si el registro existe en la DB
        Record recordExists = DAOFactory.getiRecordDAO().findByID(record.getId());
        if (recordExists != null) {
            throw new Exception("Ya existe una grabación con ese id");
        }
        if ("".equals(record.getStatus())) {
            throw new Exception("El status es obligatorio");
        }
        //Merge
        EntityManagerHelper.beginTransaction();
        DAOFactory.getiRecordDAO().update(recordExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();
    }

    @Override
    public void delete(Integer id) throws Exception {
        if (id == 0) {
            throw new Exception("El id es obligatorio");
        }
        Record recordExists = DAOFactory.getiRecordDAO().findByID(id);
        if (recordExists == null) {
            throw new Exception("No existe un registro con ese id");
        }
        EntityManagerHelper.beginTransaction();
        DAOFactory.getiRecordDAO().update(recordExists);
        EntityManagerHelper.commit();
        EntityManagerHelper.closeEntityManager();

    }

    @Override
    public List<Record> findAll() throws Exception {
        return DAOFactory.getiRecordDAO().findAll();
    }

    @Override
    public Record findById(Integer id) throws Exception {
        if (id == 0) {
            throw new Exception("El id no puede ser 0");
        }
        return DAOFactory.getiRecordDAO().findByID(id);
    }

}
