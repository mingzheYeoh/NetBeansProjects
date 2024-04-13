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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mingzhe
 */
@Entity
@Table(name = "CUSTOMER_ADDRESS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerAddress.findAll", query = "SELECT c FROM CustomerAddress c"),
    @NamedQuery(name = "CustomerAddress.findByAddressId", query = "SELECT c FROM CustomerAddress c WHERE c.addressId = :addressId"),
    @NamedQuery(name = "CustomerAddress.findByFirstName", query = "SELECT c FROM CustomerAddress c WHERE c.firstName = :firstName"),
    @NamedQuery(name = "CustomerAddress.findByLastName", query = "SELECT c FROM CustomerAddress c WHERE c.lastName = :lastName"),
    @NamedQuery(name = "CustomerAddress.findByFirstAddress", query = "SELECT c FROM CustomerAddress c WHERE c.firstAddress = :firstAddress"),
    @NamedQuery(name = "CustomerAddress.findBySecondAddress", query = "SELECT c FROM CustomerAddress c WHERE c.secondAddress = :secondAddress"),
    @NamedQuery(name = "CustomerAddress.findByState", query = "SELECT c FROM CustomerAddress c WHERE c.state = :state"),
    @NamedQuery(name = "CustomerAddress.findByCity", query = "SELECT c FROM CustomerAddress c WHERE c.city = :city"),
    @NamedQuery(name = "CustomerAddress.findByPostalCode", query = "SELECT c FROM CustomerAddress c WHERE c.postalCode = :postalCode"),
    @NamedQuery(name = "CustomerAddress.findByPhoneNumber", query = "SELECT c FROM CustomerAddress c WHERE c.phoneNumber = :phoneNumber")})
public class CustomerAddress implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ADDRESS_ID")
    private Integer addressId;
    @Basic(optional = false)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "LAST_NAME")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "FIRST_ADDRESS")
    private String firstAddress;
    @Basic(optional = false)
    @Column(name = "SECOND_ADDRESS")
    private String secondAddress;
    @Basic(optional = false)
    @Column(name = "STATE")
    private String state;
    @Basic(optional = false)
    @Column(name = "CITY")
    private String city;
    @Basic(optional = false)
    @Column(name = "POSTAL_CODE")
    private String postalCode;
    @Basic(optional = false)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false)
    private CustomerRegister customerId;

    public CustomerAddress() {
    }

    public CustomerAddress(Integer addressId) {
        this.addressId = addressId;
    }

    public CustomerAddress(Integer addressId, String firstName, String lastName, String firstAddress, String secondAddress, String state, String city, String postalCode, String phoneNumber) {
        this.addressId = addressId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.firstAddress = firstAddress;
        this.secondAddress = secondAddress;
        this.state = state;
        this.city = city;
        this.postalCode = postalCode;
        this.phoneNumber = phoneNumber;
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstAddress() {
        return firstAddress;
    }

    public void setFirstAddress(String firstAddress) {
        this.firstAddress = firstAddress;
    }

    public String getSecondAddress() {
        return secondAddress;
    }

    public void setSecondAddress(String secondAddress) {
        this.secondAddress = secondAddress;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public CustomerRegister getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerRegister customerId) {
        this.customerId = customerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (addressId != null ? addressId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CustomerAddress)) {
            return false;
        }
        CustomerAddress other = (CustomerAddress) object;
        if ((this.addressId == null && other.addressId != null) || (this.addressId != null && !this.addressId.equals(other.addressId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB_Model.CustomerAddress[ addressId=" + addressId + " ]";
    }
    
}
