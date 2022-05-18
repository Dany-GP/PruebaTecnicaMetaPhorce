package com.example.PruebaTecnica.DAO;

import com.example.PruebaTecnica.Models.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class EmployeeDAOImp implements EmployeeDAO {

    /***
     * Entity to manage the connection
     * between database and controller
     */
    @PersistenceContext
    EntityManager entityManager;

    /***
     *
     * @return a list with Employees of the database
     */
    @Override
    public List<Employee> getEmpleados() {
        String query = "FROM Employee";
        return entityManager.createQuery(query).getResultList();
    }

    /***
     *
     * @return A list with Employees who are active in the register
     * of the database
     */
    @Override
    public List<Employee> getEmpleadosActivos() {
        String query = "FROM Employee WHERE activo=1";
        return entityManager.createQuery(query).getResultList();
    }

    /***
     *
     * @param id The id of an Employee
     * @return an employee who contain the id
     */
    @Override
    public Employee getEmpleado(int id) {
        String query = "FROM Employee WHERE id="+id;
        return (Employee) entityManager.createQuery(query).getResultList().get(0);
    }

    /***
     *
     * @param empleado An emloyee to add to the database
     * @throws Exception if the employee contain a duplicate email in
     * the database
     */
    @Override
    public void agregarEmpleado(Employee empleado) throws Exception {
        if(correoExistente(empleado)){
            throw  new Exception("El correo ya existe en la BD");
        }else{
            entityManager.merge(empleado);
        }

    }

    /***
     *
     * @param empleado An employee to replace in the ddatabase
     */
    @Override
    public void actualizarEmpleado(Employee empleado)  {
        entityManager.merge(empleado);

    }

    /***
     *
     * @param id The id of the employee who will be deleted from
     *           the DATABASE
     * @throws Exception if the id of the employee doesn't exist
     */
    @Override
    public void eliminarEmpleado(int id) throws Exception {
        Employee empleado = getEmpleado(id);
        if(empleado!=null){
            entityManager.remove(empleado);
        }else{
            throw new Exception("El empleado no existe");
        }
    }

    /***
     *
     * @param empleado Verify if the employee contain a duplicate email
     * @return @True if the employee contains a duplicate email @False otherwise
     */
    boolean correoExistente(Employee empleado){
        String query = "FROM Employee WHERE correo='"+empleado.getCorreo()+"'";
        if(entityManager.createQuery(query).getResultList().size()>0){
            return true;
        }
        return false;
    }
}
