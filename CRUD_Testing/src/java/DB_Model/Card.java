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
@Table(name = "CARD")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Card.findAll", query = "SELECT c FROM Card c"),
    @NamedQuery(name = "Card.findByCardId", query = "SELECT c FROM Card c WHERE c.cardId = :cardId"),
    @NamedQuery(name = "Card.findByCardHolderName", query = "SELECT c FROM Card c WHERE c.cardHolderName = :cardHolderName"),
    @NamedQuery(name = "Card.findByCardNumber", query = "SELECT c FROM Card c WHERE c.cardNumber = :cardNumber"),
    @NamedQuery(name = "Card.findByCvcOrCvv", query = "SELECT c FROM Card c WHERE c.cvcOrCvv = :cvcOrCvv"),
    @NamedQuery(name = "Card.findByExpiryDate", query = "SELECT c FROM Card c WHERE c.expiryDate = :expiryDate")})
public class Card implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CARD_ID")
    private Integer cardId;
    @Basic(optional = false)
    @Column(name = "CARD_HOLDER_NAME")
    private String cardHolderName;
    @Basic(optional = false)
    @Column(name = "CARD_NUMBER")
    private String cardNumber;
    @Basic(optional = false)
    @Column(name = "CVC_OR_CVV")
    private String cvcOrCvv;
    @Basic(optional = false)
    @Column(name = "EXPIRY_DATE")
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne(optional = false)
    private CustomerRegister customerId;

    public Card() {
    }

    public Card(Integer cardId) {
        this.cardId = cardId;
    }

    public Card(Integer cardId, String cardHolderName, String cardNumber, String cvcOrCvv, Date expiryDate) {
        this.cardId = cardId;
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.cvcOrCvv = cvcOrCvv;
        this.expiryDate = expiryDate;
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvcOrCvv() {
        return cvcOrCvv;
    }

    public void setCvcOrCvv(String cvcOrCvv) {
        this.cvcOrCvv = cvcOrCvv;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
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
        hash += (cardId != null ? cardId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Card)) {
            return false;
        }
        Card other = (Card) object;
        if ((this.cardId == null && other.cardId != null) || (this.cardId != null && !this.cardId.equals(other.cardId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB_Model.Card[ cardId=" + cardId + " ]";
    }
    
}
