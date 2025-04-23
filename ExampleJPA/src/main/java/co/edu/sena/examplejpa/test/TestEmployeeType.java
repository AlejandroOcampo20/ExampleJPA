/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.test;

import co.edu.sena.examplejpa.Utils.MessageUtils;
import co.edu.sena.examplejpa.controller.EmployeeTypeController;
import co.edu.sena.examplejpa.controller.IEmployeeTypeController;
import co.edu.sena.examplejpa.model.EmployeeType;
import co.edu.sena.examplejpa.persistence.DAOFactory;
import java.util.List;

/**
 *DATE: 22/0empleado4/2025
 * @author alejo
 * Objetive: probar el controlador de tipo de empleado
 */
public class TestEmployeeType {
    
    public void insert()
    {
        try {
            EmployeeType employeeType = new EmployeeType();
            employeeType.setDescript("Nuevo tipo");
            IEmployeeTypeController controller = new EmployeeTypeController();
            controller.insert(employeeType);
            MessageUtils.ShowInfoMessage("Tipo de empleado creado exitosamente");
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }
    
    public void update()
    {
        try {
            EmployeeType employeeType = DAOFactory.getEmployeeTypeDAO().findByID(8);
            employeeType.setDescript("Nuevo tipo actualizado");
            IEmployeeTypeController controller = new EmployeeTypeController();
            controller.update(employeeType);
            MessageUtils.ShowInfoMessage("Tipo de empleado modificado exitosamente");
        } catch (Exception e) {
        }
    }
    
    public  void delete()
    {
        try {
            EmployeeType employeeType = DAOFactory.getEmployeeTypeDAO().findByID(8);
            IEmployeeTypeController controller = new EmployeeTypeController();
            controller.delete(employeeType.getId());
            MessageUtils.ShowInfoMessage("Tipo de empleado eliminado exitosamente");
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }
    
    public void findAll()
    {
        try {
            IEmployeeTypeController controller = new EmployeeTypeController();
            List<EmployeeType> types = controller.findAll();
            String messages = " ";
            for (EmployeeType type : types) {
                messages += " Id: " + type.getId() + " Descripción: " + type.getDescript() +"\n";
            }
            MessageUtils.ShowInfoMessage(messages);
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        TestEmployeeType test = new TestEmployeeType();
        //test.insert();
       // test.update();
       //test.delete();
       test.findAll();
    }
}
