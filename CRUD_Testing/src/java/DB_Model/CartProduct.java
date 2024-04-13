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
@Table(name = "CART_PRODUCT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CartProduct.findAll", query = "SELECT c FROM CartProduct c"),
    @NamedQuery(name = "CartProduct.findByCartProductId", query = "SELECT c FROM CartProduct c WHERE c.cartProductId = :cartProductId"),
    @NamedQuery(name = "CartProduct.findBySoldQuantity", query = "SELECT c FROM CartProduct c WHERE c.soldQuantity = :soldQuantity")})
public class CartProduct implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "CART_PRODUCT_ID")
    private Integer cartProductId;
    @Basic(optional = false)
    @Column(name = "SOLD_QUANTITY")
    private int soldQuantity;
    @JoinColumn(name = "CART_ID", referencedColumnName = "CART_ID")
    @ManyToOne
    private Cart cartId;
    @JoinColumn(name = "SIZE_ID", referencedColumnName = "SIZE_ID")
    @ManyToOne
    private ProductSize sizeId;

    public CartProduct() {
    }

    public CartProduct(Integer cartProductId) {
        this.cartProductId = cartProductId;
    }

    public CartProduct(Integer cartProductId, int soldQuantity) {
        this.cartProductId = cartProductId;
        this.soldQuantity = soldQuantity;
    }

    public Integer getCartProductId() {
        return cartProductId;
    }

    public void setCartProductId(Integer cartProductId) {
        this.cartProductId = cartProductId;
    }

    public int getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(int soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public Cart getCartId() {
        return cartId;
    }

    public void setCartId(Cart cartId) {
        this.cartId = cartId;
    }

    public ProductSize getSizeId() {
        return sizeId;
    }

    public void setSizeId(ProductSize sizeId) {
        this.sizeId = sizeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (cartProductId != null ? cartProductId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CartProduct)) {
            return false;
        }
        CartProduct other = (CartProduct) object;
        if ((this.cartProductId == null && other.cartProductId != null) || (this.cartProductId != null && !this.cartProductId.equals(other.cartProductId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB_Model.CartProduct[ cartProductId=" + cartProductId + " ]";
    }
    
}
