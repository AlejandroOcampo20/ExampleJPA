/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.test;

import co.edu.sena.examplejpa.Utils.MessageUtils;
import co.edu.sena.examplejpa.controller.EmployeeController;
import co.edu.sena.examplejpa.controller.EmployeeTypeController;
import co.edu.sena.examplejpa.controller.IEmployeeController;
import co.edu.sena.examplejpa.controller.IEmployeeTypeController;
import co.edu.sena.examplejpa.model.Employee;
import co.edu.sena.examplejpa.model.EmployeeType;
import java.util.List;

/**
 *DATE: 22/0empleado4/2025
 * @author alejo
 * Objetive: probar el controlador  de empleado
 */
public class TestEmployee {
    public void insert()
    {
        try {
            Employee employee = new Employee(1120L, "zoila kelava", "Tvr 12", "223");
            IEmployeeTypeController typeController = new EmployeeTypeController();
            EmployeeType type = typeController.findById(1);
            employee.setTypeId(type); //FK
            IEmployeeController controller = new EmployeeController();
            controller.insert(employee);
            MessageUtils.ShowInfoMessage("Empleado creado exitosamente");
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }
    
    public void update()
    {
       try {
            Employee employee = new Employee(1120L, "ALBERTO CATESTA", "Tvr 13", "316");
            IEmployeeTypeController typeController = new EmployeeTypeController();
            EmployeeType type = typeController.findById(1);
            employee.setTypeId(type); //FK
            IEmployeeController controller = new EmployeeController();
            controller.update(employee);
            MessageUtils.ShowInfoMessage("Empleado modificado exitosamente");
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }
    
    public void delete()
    {
        try {
            IEmployeeController controller = new EmployeeController();
            Employee employee = controller.findById(1120L);
            controller.delete(employee.getDocument());
            MessageUtils.ShowInfoMessage("Empleado eliminado exitosamente");
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    }
    
    public void findAll()
    {
        try {
            IEmployeeController controller = new EmployeeController();
            List<Employee> employees = controller.findall();
            String message = " ";
            for (Employee e : employees) {
                message += "Documento: " + e.getDocument() + "Nombre: " + e.getFullname() + 
                        "Dirección: " + e.getDireccion() + "Telefono: " + e.getTelefono() + 
                        "Tipo: " + e.getTypeId().getDescript() + "\n";
            }
            MessageUtils.ShowInfoMessage(message);
        } catch (Exception e) {
            MessageUtils.ShowErrorMessage(e.getMessage());
        }
    
    }
    
    public static void main(String[] args) {
        TestEmployee test = new TestEmployee();
        //test.insert();
        //test.update();
        //test.delete();
        test.findAll();
    }
    
}
