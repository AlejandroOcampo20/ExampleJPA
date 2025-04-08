/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.persistence;

import co.edu.sena.examplejpa.model.EmployeeType;
import java.util.List;

/**
 *
 * @author alejo
 * Objetive: interface tipo de empleado DAO
 */
public interface IEmployeeTypeDAO {
    public void insert(EmployeeType employeeType)throws Exception;
    public void update(EmployeeType employeeType)throws Exception;
    public void delete(EmployeeType employeeType)throws Exception;
    public EmployeeType findByID(Integer id)throws Exception;
    public List <EmployeeType> findAll()throws Exception;
            
}
