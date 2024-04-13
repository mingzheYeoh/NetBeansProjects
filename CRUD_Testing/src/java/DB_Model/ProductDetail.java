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
@Table(name = "PRODUCT_DETAIL")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductDetail.findAll", query = "SELECT p FROM ProductDetail p"),
    @NamedQuery(name = "ProductDetail.findByProductDetailId", query = "SELECT p FROM ProductDetail p WHERE p.productDetailId = :productDetailId"),
    @NamedQuery(name = "ProductDetail.findByColor", query = "SELECT p FROM ProductDetail p WHERE p.color = :color"),
    @NamedQuery(name = "ProductDetail.findByHexColor", query = "SELECT p FROM ProductDetail p WHERE p.hexColor = :hexColor")})
public class ProductDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "PRODUCT_DETAIL_ID")
    private Integer productDetailId;
    @Basic(optional = false)
    @Column(name = "COLOR")
    private String color;
    @Basic(optional = false)
    @Column(name = "HEX_COLOR")
    private String hexColor;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "productDetailId")
    private List<ProductSize> productSizeList;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    @ManyToOne
    private Product productId;

    public ProductDetail() {
    }

    public ProductDetail(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public ProductDetail(Integer productDetailId, String color, String hexColor) {
        this.productDetailId = productDetailId;
        this.color = color;
        this.hexColor = hexColor;
    }

    public Integer getProductDetailId() {
        return productDetailId;
    }

    public void setProductDetailId(Integer productDetailId) {
        this.productDetailId = productDetailId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getHexColor() {
        return hexColor;
    }

    public void setHexColor(String hexColor) {
        this.hexColor = hexColor;
    }

    @XmlTransient
    public List<ProductSize> getProductSizeList() {
        return productSizeList;
    }

    public void setProductSizeList(List<ProductSize> productSizeList) {
        this.productSizeList = productSizeList;
    }

    public Product getProductId() {
        return productId;
    }

    public void setProductId(Product productId) {
        this.productId = productId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productDetailId != null ? productDetailId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductDetail)) {
            return false;
        }
        ProductDetail other = (ProductDetail) object;
        if ((this.productDetailId == null && other.productDetailId != null) || (this.productDetailId != null && !this.productDetailId.equals(other.productDetailId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB_Model.ProductDetail[ productDetailId=" + productDetailId + " ]";
    }
    
}
