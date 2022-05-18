package com.example.PruebaTecnica.Controllers;

import com.example.PruebaTecnica.DAO.ContractDAOImp;
import com.example.PruebaTecnica.DAO.EmployeeDAOImp;
import com.example.PruebaTecnica.Models.Contract;
import com.example.PruebaTecnica.Models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private EmployeeDAOImp usuarioDAO;

    @Autowired
    private ContractDAOImp contratoDAO;

    @RequestMapping(value = "/employees")
    public List<Employee> getEmpleados(){
        return usuarioDAO.getEmpleados();
    }

    @RequestMapping(value = "/employees/active")
    public List<Employee> getEmpleadosActivos(){
        return usuarioDAO.getEmpleadosActivos();
    }

    @RequestMapping(value = "/employees/{id}")
    public Employee getEmpleado(int id){
        return usuarioDAO.getEmpleado(id);
    }

    @RequestMapping(value = "/Contracts")
    public List<Contract> getContratos(){
        return contratoDAO.getContratos();
    }



}
