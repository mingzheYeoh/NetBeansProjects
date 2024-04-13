/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB_Model;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mingzhe
 */
@Entity
@Table(name = "CUSTOMERREGISTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customerregister.findAll", query = "SELECT c FROM Customerregister c"),
    @NamedQuery(name = "Customerregister.findByCustomerId", query = "SELECT c FROM Customerregister c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "Customerregister.findByCustomerName", query = "SELECT c FROM Customerregister c WHERE c.customerName = :customerName"),
    @NamedQuery(name = "Customerregister.findByCustomerEmail", query = "SELECT c FROM Customerregister c WHERE c.customerEmail = :customerEmail"),
    @NamedQuery(name = "Customerregister.findByCustomerPassword", query = "SELECT c FROM Customerregister c WHERE c.customerPassword = :customerPassword"),
    @NamedQuery(name = "Customerregister.findByJoinedDate", query = "SELECT c FROM Customerregister c WHERE c.joinedDate = :joinedDate")})
public class Customerregister implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CUSTOMER_ID")
    private Integer customerId;
    @Basic(optional = false)
    @Column(name = "CUSTOMER_NAME")
    private String customerName;
    @Basic(optional = false)
    @Column(name = "CUSTOMER_EMAIL")
    private String customerEmail;
    @Basic(optional = false)
    @Column(name = "CUSTOMER_PASSWORD")
    private String customerPassword;
    @Basic(optional = false)
    @Column(name = "JOINED_DATE")
    @Temporal(TemporalType.DATE)
    private Date joinedDate;

    public Customerregister() {
    }

    public Customerregister(Integer customerId) {
        this.customerId = customerId;
    }

    public Customerregister(Integer customerId, String customerName, String customerEmail, String customerPassword, Date joinedDate) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPassword = customerPassword;
        this.joinedDate = joinedDate;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPassword() {
        return customerPassword;
    }

    public void setCustomerPassword(String customerPassword) {
        this.customerPassword = customerPassword;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (customerId != null ? customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customerregister)) {
            return false;
        }
        Customerregister other = (Customerregister) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB_Model.Customerregister[ customerId=" + customerId + " ]";
    }
    
}
