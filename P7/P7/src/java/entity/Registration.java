/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.io.Serializable;
import java.util.List;
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
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author User
 */
@Entity
@Table(name = "REGISTRATION")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registration.findAll", query = "SELECT r FROM Registration r"),
    @NamedQuery(name = "Registration.findByRegId", query = "SELECT r FROM Registration r WHERE r.regId = :regId")})
public class Registration implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "REG_ID")
    private Integer regId;
    @JoinColumn(name = "ID", referencedColumnName = "ID")
    @ManyToOne
    private Student id;
    //The cascade ensures that when a new Registration is persisted, any related RegisteredSubject records are also automatically persisted.
    @OneToMany(cascade=CascadeType.PERSIST,mappedBy = "regId")
    private List<RegisteredSubject> registeredSubjectList;

    public Registration() {
    }

    public Registration(Integer regId) {
        this.regId = regId;
    }
    
    public Registration(Student id, List<RegisteredSubject>registeredSubjectList){
        this.id = id;
        this.registeredSubjectList = registeredSubjectList;
    }
    
    public int getRegistrationTotal(){
        int total = 0;
        for(int i = 0; i <registeredSubjectList.size(); i++){
            total+= registeredSubjectList.get(i).getSubjectCode().getFee();
        }
        return total;
    }

    public Integer getRegId() {
        return regId;
    }

    public void setRegId(Integer regId) {
        this.regId = regId;
    }

    public Student getId() {
        return id;
    }

    public void setId(Student id) {
        this.id = id;
    }

    @XmlTransient
    public List<RegisteredSubject> getRegisteredSubjectList() {
        return registeredSubjectList;
    }

    public void setRegisteredSubjectList(List<RegisteredSubject> registeredSubjectList) {
        this.registeredSubjectList = registeredSubjectList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (regId != null ? regId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registration)) {
            return false;
        }
        Registration other = (Registration) object;
        if ((this.regId == null && other.regId != null) || (this.regId != null && !this.regId.equals(other.regId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Registration[ regId=" + regId + " ]";
    }
    
}
