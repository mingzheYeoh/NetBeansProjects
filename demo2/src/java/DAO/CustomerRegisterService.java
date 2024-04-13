package DAO;

import DB_Model.Customerregister;
import jakarta.persistence.EntityManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CustomerRegisterService {
    private static final Logger logger = Logger.getLogger(CustomerRegisterService.class.getName());

    private EntityManager mgr;

    public CustomerRegisterService(EntityManager entityManager) {
        this.mgr = entityManager;
    }

    public boolean addCustomer(Customerregister customer) {
        try {
            mgr.getTransaction().begin();
            mgr.persist(customer);
            mgr.getTransaction().commit();
            return true;
        } catch (Exception ex) {
            mgr.getTransaction().rollback();
            logger.log(Level.SEVERE, "An error occurred while adding customer", ex);
            return false;
        }
    }

    public Customerregister findCustomerById(int customerId) {
        return mgr.find(Customerregister.class, customerId);
    }

    public List<Customerregister> findAllCustomers() {
        return mgr.createNamedQuery("CustomerRegister.findAll", Customerregister.class).getResultList();
    }

    public boolean updateCustomer(Customerregister customer) {
        try {
            Customerregister existingCustomer = findCustomerById(customer.getCustomerId());
            if (existingCustomer != null) {
                mgr.getTransaction().begin();
                existingCustomer.setCustomerName(customer.getCustomerName());
                existingCustomer.setCustomerEmail(customer.getCustomerEmail());
                existingCustomer.setCustomerPassword(customer.getCustomerPassword());
                existingCustomer.setJoinedDate(customer.getJoinedDate());
                mgr.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception ex) {
            mgr.getTransaction().rollback();
            logger.log(Level.SEVERE, "An error occurred while updating customer", ex);
            return false;
        }
    }
    
    public boolean deleteCustomer(int customerId) {
        try {
            Customerregister customer = findCustomerById(customerId);
            if (customer != null) {
                mgr.getTransaction().begin();
                mgr.remove(customer);
                mgr.getTransaction().commit();
                return true;
            }
            return false;
        } catch (Exception ex) {
            mgr.getTransaction().rollback();
            logger.log(Level.SEVERE, "An error occurred while deleting customer", ex);
            return false;
        }
    }
}
