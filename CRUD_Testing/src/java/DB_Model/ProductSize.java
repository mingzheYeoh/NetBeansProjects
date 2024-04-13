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
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author mingzhe
 */
@Entity
@Table(name = "PRODUCT_SIZE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductSize.findAll", query = "SELECT p FROM ProductSize p"),
    @NamedQuery(name = "ProductSize.findBySizeId", query = "SELECT p FROM ProductSize p WHERE p.sizeId = :sizeId"),
    @NamedQuery(name = "ProductSize.findBySizeCategory", query = "SELECT p FROM ProductSize p WHERE p.sizeCategory = :sizeCategory"),
    @NamedQuery(name = "ProductSize.findByQuantity", query = "SELECT p FROM ProductSize p WHERE p.quantity = :quantity")})
public class ProductSize implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SIZE_ID")
    private Integer sizeId;
    @Basic(optional = false)
    @Column(name = "SIZE_CATEGORY")
    private String sizeCategory;
    @Basic(optional = false)
    @Column(name = "QUANTITY")
    private int quantity;
    @OneToMany(mappedBy = "sizeId")
    private List<CartProduct> cartProductList;
    @JoinColumn(name = "PRODUCT_DETAIL_ID", referencedColumnName = "PRODUCT_DETAIL_ID")
    @ManyToOne(optional = false)
    private ProductDetail productDetailId;

    public ProductSize() {
    }

    public ProductSize(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public ProductSize(Integer sizeId, String sizeCategory, int quantity) {
        this.sizeId = sizeId;
        this.sizeCategory = sizeCategory;
        this.quantity = quantity;
    }

    public Integer getSizeId() {
        return sizeId;
    }

    public void setSizeId(Integer sizeId) {
        this.sizeId = sizeId;
    }

    public String getSizeCategory() {
        return sizeCategory;
    }

    public void setSizeCategory(String sizeCategory) {
        this.sizeCategory = sizeCategory;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @XmlTransient
    public List<CartProduct> getCartProductList() {
        return cartProductList;
    }

    public void setCartProductList(List<CartProduct> cartProductList) {
        this.cartProductList = cartProductList;
    }

    public ProductDetail getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(ProductDetail productDetailId) {
        this.productDetailId = productDetailId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (sizeId != null ? sizeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductSize)) {
            return false;
        }
        ProductSize other = (ProductSize) object;
        if ((this.sizeId == null && other.sizeId != null) || (this.sizeId != null && !this.sizeId.equals(other.sizeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB_Model.ProductSize[ sizeId=" + sizeId + " ]";
    }
    
}
