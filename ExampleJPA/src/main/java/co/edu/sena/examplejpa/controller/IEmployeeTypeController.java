/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.sena.examplejpa.controller;

import co.edu.sena.examplejpa.model.EmployeeType;
import java.util.List;

/**
 *Date: 25/03/2025
 * @author alejo
 */
public interface IEmployeeTypeController {
     public void insert (EmployeeType employeeType) throws Exception;
     public void update (EmployeeType employeeType)throws Exception;
     public void delete(Integer Id)throws Exception;
     public List<EmployeeType> findAll () throws Exception;
     public EmployeeType findById (Integer Id) throws Exception;
     
}
