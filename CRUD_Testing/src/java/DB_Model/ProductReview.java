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
@Table(name = "PRODUCT_REVIEW")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductReview.findAll", query = "SELECT p FROM ProductReview p"),
    @NamedQuery(name = "ProductReview.findByReviewId", query = "SELECT p FROM ProductReview p WHERE p.reviewId = :reviewId"),
    @NamedQuery(name = "ProductReview.findByReviewStar", query = "SELECT p FROM ProductReview p WHERE p.reviewStar = :reviewStar"),
    @NamedQuery(name = "ProductReview.findByReviewContent", query = "SELECT p FROM ProductReview p WHERE p.reviewContent = :reviewContent")})
public class ProductReview implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REVIEW_ID")
    private Integer reviewId;
    @Basic(optional = false)
    @Column(name = "REVIEW_STAR")
    private int reviewStar;
    @Basic(optional = false)
    @Column(name = "REVIEW_CONTENT")
    private String reviewContent;
    @JoinColumn(name = "CUSTOMER_ID", referencedColumnName = "CUSTOMER_ID")
    @ManyToOne
    private CustomerRegister customerId;
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")
    @ManyToOne
    private Product productId;

    public ProductReview() {
    }

    public ProductReview(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public ProductReview(Integer reviewId, int reviewStar, String reviewContent) {
        this.reviewId = reviewId;
        this.reviewStar = reviewStar;
        this.reviewContent = reviewContent;
    }

    public Integer getReviewId() {
        return reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public int getReviewStar() {
        return reviewStar;
    }

    public void setReviewStar(int reviewStar) {
        this.reviewStar = reviewStar;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public CustomerRegister getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerRegister customerId) {
        this.customerId = customerId;
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
        hash += (reviewId != null ? reviewId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductReview)) {
            return false;
        }
        ProductReview other = (ProductReview) object;
        if ((this.reviewId == null && other.reviewId != null) || (this.reviewId != null && !this.reviewId.equals(other.reviewId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB_Model.ProductReview[ reviewId=" + reviewId + " ]";
    }
    
}
