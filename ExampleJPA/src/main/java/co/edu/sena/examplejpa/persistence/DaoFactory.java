/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.sena.examplejpa.persistence;

/**
 *
 * @author alejo
 * Objetive: instanciar todos los DAO's creados en la persistencia
 */
public class DaoFactory {
    private static IEmployeeTypeDAO employeeTypeDAO = new EmployeeTypeDAO();
    private static IEmployeeDAO employeeDAO = new EmployeeDAO();
    private static IKeyRoomDAO keyRoomDAO = new KeyRoomDAO();
    private static IRecordDAO iRecordDAO = new RecordDAO();

    public static IEmployeeTypeDAO getEmployeeTypeDAO() {
        return employeeTypeDAO;
    }

    public static IEmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public static IKeyRoomDAO getKeyRoomDAO() {
        return keyRoomDAO;
    }

    public static IRecordDAO getiRecordDAO() {
        return iRecordDAO;
    }
    
    
}
