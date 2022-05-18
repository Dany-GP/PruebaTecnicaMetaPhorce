package com.example.PruebaTecnica.DAO;

import com.example.PruebaTecnica.Models.Contract;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ContractDAOImp implements ContractDAO {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Contract> getContratos() {
        String query = "FROM Contract";
        return entityManager.createQuery(query).getResultList();
    }
}
