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
@Table(name = "ADMIN_REGISTER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AdminRegister.findAll", query = "SELECT a FROM AdminRegister a"),
    @NamedQuery(name = "AdminRegister.findByAdminId", query = "SELECT a FROM AdminRegister a WHERE a.adminId = :adminId"),
    @NamedQuery(name = "AdminRegister.findByAdminName", query = "SELECT a FROM AdminRegister a WHERE a.adminName = :adminName"),
    @NamedQuery(name = "AdminRegister.findByAdminEmail", query = "SELECT a FROM AdminRegister a WHERE a.adminEmail = :adminEmail"),
    @NamedQuery(name = "AdminRegister.findByAdminPassword", query = "SELECT a FROM AdminRegister a WHERE a.adminPassword = :adminPassword"),
    @NamedQuery(name = "AdminRegister.findByAdminStatus", query = "SELECT a FROM AdminRegister a WHERE a.adminStatus = :adminStatus"),
    @NamedQuery(name = "AdminRegister.findByAdminRole", query = "SELECT a FROM AdminRegister a WHERE a.adminRole = :adminRole"),
    @NamedQuery(name = "AdminRegister.findByEnrolledDate", query = "SELECT a FROM AdminRegister a WHERE a.enrolledDate = :enrolledDate"),
    @NamedQuery(name = "AdminRegister.findByModifiedDate", query = "SELECT a FROM AdminRegister a WHERE a.modifiedDate = :modifiedDate")})
public class AdminRegister implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ADMIN_ID")
    private Integer adminId;
    @Basic(optional = false)
    @Column(name = "ADMIN_NAME")
    private String adminName;
    @Basic(optional = false)
    @Column(name = "ADMIN_EMAIL")
    private String adminEmail;
    @Basic(optional = false)
    @Column(name = "ADMIN_PASSWORD")
    private String adminPassword;
    @Basic(optional = false)
    @Column(name = "ADMIN_STATUS")
    private String adminStatus;
    @Basic(optional = false)
    @Column(name = "ADMIN_ROLE")
    private String adminRole;
    @Basic(optional = false)
    @Column(name = "ENROLLED_DATE")
    @Temporal(TemporalType.DATE)
    private Date enrolledDate;
    @Column(name = "MODIFIED_DATE")
    @Temporal(TemporalType.DATE)
    private Date modifiedDate;

    public AdminRegister() {
    }

    public AdminRegister(Integer adminId) {
        this.adminId = adminId;
    }

    public AdminRegister(Integer adminId, String adminName, String adminEmail, String adminPassword, String adminStatus, String adminRole, Date enrolledDate) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.adminEmail = adminEmail;
        this.adminPassword = adminPassword;
        this.adminStatus = adminStatus;
        this.adminRole = adminRole;
        this.enrolledDate = enrolledDate;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    public String getAdminRole() {
        return adminRole;
    }

    public void setAdminRole(String adminRole) {
        this.adminRole = adminRole;
    }

    public Date getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(Date enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (adminId != null ? adminId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AdminRegister)) {
            return false;
        }
        AdminRegister other = (AdminRegister) object;
        if ((this.adminId == null && other.adminId != null) || (this.adminId != null && !this.adminId.equals(other.adminId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DB_Model.AdminRegister[ adminId=" + adminId + " ]";
    }
    
}
