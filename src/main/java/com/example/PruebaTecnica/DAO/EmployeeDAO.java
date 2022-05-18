package com.example.PruebaTecnica.DAO;

import com.example.PruebaTecnica.Models.Employee;

import java.util.List;


public interface EmployeeDAO {
    List<Employee> getEmpleados();
    List<Employee> getEmpleadosActivos();
    Employee getEmpleado(int id);

    void agregarEmpleado(Employee empleado) throws Exception;
    void actualizarEmpleado(Employee empleado) throws Exception;
    void eliminarEmpleado(int id) throws Exception;
}
