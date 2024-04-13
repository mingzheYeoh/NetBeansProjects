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
import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author mingzhe
 */
@Entity
@Table(name = "SALES_REPORT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SalesReport.findAll", query = "SELECT s FROM SalesReport s"),
    @NamedQuery(name = "SalesReport.findBySalesReportId", query = "SELECT s FROM SalesReport s WHERE s.salesReportId = :salesReportId"),
    @NamedQuery(name = "SalesReport.findByTotalProductSold", query = "SELECT s FROM SalesReport s WHERE s.totalProductSold = :totalProductSold"),
    @NamedQuery(name = "SalesReport.findByProductName", query = "SELECT s FROM SalesReport s WHERE s.productName = :productName"),
    @NamedQuery(name = "SalesReport.findByTotalNetProfit", query = "SELECT s FROM SalesReport s WHERE s.totalNetProfit = :totalNetProfit"),
    @NamedQuery(name = "SalesReport.findByTotalProfitPerProduct", query = "SELECT s FROM SalesReport s WHERE s.totalProfitPerProduct = :totalProfitPerProduct"),
    @NamedQuery(name = "SalesReport.findByCreatedTime", query = "SELECT s FROM SalesReport s WHERE s.createdTime = :createdTime")})
public class SalesReport implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "SALES_REPORT_ID")
    private Integer salesReportId;
    @Basic(optional = false)
    @Column(name = "TOTAL_PRODUCT_SOLD")
    private int totalProductSold;
    @Basic(optional = false)
    @Column(name = "PRODUCT_NAME")
    private String productName;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "TOTAL_NET_PROFIT")
    private BigDecimal totalNetProfit;
    @Basic(optional = false)
    @Column(name = "TOTAL_PROFIT_PER_PRODUCT")
    private BigDecimal totalProfitPerProduct;
    @Basic(optional = false)
    @Column(name = "CREATED_TIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdTime;
    @JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")
    @ManyToOne(optional = false)
    private ProductOrder orderId;

    public SalesReport() {
    }

    public SalesReport(Integer salesReportId) {
        this.salesReportId = salesReportId;
    }

    public SalesReport(Integer salesReportId, int totalProductSold, String productName, BigDecimal totalNetProfit, BigDecimal totalProfitPerProduct, Date createdTime) {
        this.salesReportId = salesReportId;
        this.totalProductSold = totalProductSold;
        this.productName = productName;
        this.totalNetProfit = totalNetProfit;
        this.totalProfitPerProduct = totalProfitPerProduct;
        this.createdTime = createdTime;
    }

    public Integer getSalesReportId() {
        return salesReportId;
    }

    public void setSalesReportId(Integer salesReportId) {
        this.salesReportId = salesReportId;
    }

    public int getTotalProductSold() {
        return totalProductSold;
    }

    public void setTotalProductSold(int totalProductSold) {
        this.totalProductSold = totalProductSold;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getTotalNetProfit() {
        return totalNetProfit;
    }

    public void setTotalNetProfit(BigDecimal totalNetProfit) {
        this.totalNetProfit = totalNetProfit;
    }

    public BigDecimal getTotalProfitPerProduct() {
        return totalProfitPerProduct;
    }

    public void setTotalProfitPerProduct(BigDecimal totalProfitPerProduct) {
        this.totalProfitPerProduct = totalProfitPerProduct;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public ProductOrder getOrderId() {
        return orderId;
    }

    public void setOrderId(ProductOrder orderId) {
        this.orderId = orderId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (salesReportId != null ? salesReportId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalesReport)) {
            return false;
        }
        SalesReport other = (SalesReport) object;
        if ((this.salesReportId == null && other.salesReportId != null) || (this.salesReportId != null && !this.salesReportId.equals(other.salesReportId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB_Model.SalesReport[ salesReportId=" + salesReportId + " ]";
    }
    
}
