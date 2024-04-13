/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DB_Model;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mingzhe
 */
@Entity
@Table(name = "CUSTOMER_REGISTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CustomerRegister.findAll", query = "SELECT c FROM CustomerRegister c"),
    @NamedQuery(name = "CustomerRegister.findByCustomerId", query = "SELECT c FROM CustomerRegister c WHERE c.customerId = :customerId"),
    @NamedQuery(name = "CustomerRegister.findByCustomerName", query = "SELECT c FROM CustomerRegister c WHERE c.customerName = :customerName"),
    @NamedQuery(name = "CustomerRegister.findByCustomerEmail", query = "SELECT c FROM CustomerRegister c WHERE c.customerEmail = :customerEmail"),
    @NamedQuery(name = "CustomerRegister.findByCustomerPassword", query = "SELECT c FROM CustomerRegister c WHERE c.customerPassword = :customerPassword"),
    @NamedQuery(name = "CustomerRegister.findByJoinedDate", query = "SELECT c FROM CustomerRegister c WHERE c.joinedDate = :joinedDate")})
public class CustomerRegister implements Serializable {

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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private List<CustomerAddress> customerAddressList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private List<Payment> paymentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private List<ProductOrder> productOrderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private List<Card> cardList;
    @OneToMany(mappedBy = "customerId")
    private List<ProductReview> productReviewList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customerId")
    private List<Cart> cartList;

    public CustomerRegister() {
    }

    public CustomerRegister(Integer customerId) {
        this.customerId = customerId;
    }

    public CustomerRegister(Integer customerId, String customerName, String customerEmail, String customerPassword, Date joinedDate) {
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

    @XmlTransient
    public List<CustomerAddress> getCustomerAddressList() {
        return customerAddressList;
    }

    public void setCustomerAddressList(List<CustomerAddress> customerAddressList) {
        this.customerAddressList = customerAddressList;
    }

    @XmlTransient
    public List<Payment> getPaymentList() {
        return paymentList;
    }

    public void setPaymentList(List<Payment> paymentList) {
        this.paymentList = paymentList;
    }

    @XmlTransient
    public List<ProductOrder> getProductOrderList() {
        return productOrderList;
    }

    public void setProductOrderList(List<ProductOrder> productOrderList) {
        this.productOrderList = productOrderList;
    }

    @XmlTransient
    public List<Card> getCardList() {
        return cardList;
    }

    public void setCardList(List<Card> cardList) {
        this.cardList = cardList;
    }

    @XmlTransient
    public List<ProductReview> getProductReviewList() {
        return productReviewList;
    }

    public void setProductReviewList(List<ProductReview> productReviewList) {
        this.productReviewList = productReviewList;
    }

    @XmlTransient
    public List<Cart> getCartList() {
        return cartList;
    }

    public void setCartList(List<Cart> cartList) {
        this.cartList = cartList;
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
        if (!(object instanceof CustomerRegister)) {
            return false;
        }
        CustomerRegister other = (CustomerRegister) object;
        if ((this.customerId == null && other.customerId != null) || (this.customerId != null && !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB_Model.CustomerRegister[ customerId=" + customerId + " ]";
    }
    
}
