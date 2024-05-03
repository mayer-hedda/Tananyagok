/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home.webshop.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gapz
 */
@Entity
@Table(name = "cupon")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Cupon.findAll", query = "SELECT c FROM Cupon c"),
    @NamedQuery(name = "Cupon.findById", query = "SELECT c FROM Cupon c WHERE c.id = :id"),
    @NamedQuery(name = "Cupon.findByCuponCode", query = "SELECT c FROM Cupon c WHERE c.cuponCode = :cuponCode"),
    @NamedQuery(name = "Cupon.findByValidityStart", query = "SELECT c FROM Cupon c WHERE c.validityStart = :validityStart"),
    @NamedQuery(name = "Cupon.findByValidityEnd", query = "SELECT c FROM Cupon c WHERE c.validityEnd = :validityEnd"),
    @NamedQuery(name = "Cupon.findByStatus", query = "SELECT c FROM Cupon c WHERE c.status = :status")})
public class Cupon implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "cupon_code")
    private String cuponCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validity_start")
    @Temporal(TemporalType.DATE)
    private Date validityStart;
    @Basic(optional = false)
    @NotNull
    @Column(name = "validity_end")
    @Temporal(TemporalType.DATE)
    private Date validityEnd;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;

    public Cupon() {
    }

    public Cupon(Integer id) {
        this.id = id;
    }

    public Cupon(Integer id, String cuponCode, Date validityStart, Date validityEnd, int status) {
        this.id = id;
        this.cuponCode = cuponCode;
        this.validityStart = validityStart;
        this.validityEnd = validityEnd;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCuponCode() {
        return cuponCode;
    }

    public void setCuponCode(String cuponCode) {
        this.cuponCode = cuponCode;
    }

    public Date getValidityStart() {
        return validityStart;
    }

    public void setValidityStart(Date validityStart) {
        this.validityStart = validityStart;
    }

    public Date getValidityEnd() {
        return validityEnd;
    }

    public void setValidityEnd(Date validityEnd) {
        this.validityEnd = validityEnd;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cupon)) {
            return false;
        }
        Cupon other = (Cupon) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.home.webshop.Model.Cupon[ id=" + id + " ]";
    }
    
    
    
    // SAJÁT FÜGGVÉNYEK
    public static boolean createCupon(String cuponCode, String validityStart, String validityEnd, Integer status) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("createCupon");
            
            spq.registerStoredProcedureParameter("cupon_codeIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("validity_startIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("validity_endIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("statusIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("cupon_codeIN", cuponCode);
            spq.setParameter("validity_startIN", validityStart);
            spq.setParameter("validity_endIN", validityEnd);
            spq.setParameter("statusIN", status);
            
            spq.execute();
            
            return true;
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            em.clear();
            em.close();
            emf.close();
        }
        
    }
    
    public static boolean deleteCupon(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteCupon");
            
            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("idIN", id);
            
            spq.execute();
            
            return true;
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            em.clear();
            em.close();
            emf.close();
        }
    }
    
    public static boolean updateCupon(Integer id, String newCuponCode, String newValidityStart, String newValidityEnd, Integer newStatus) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateCupon");
            
            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newCupon_codeIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newValidity_startIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newValidity_endIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newStatusIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("idIN", id);
            spq.setParameter("newCupon_codeIN", newCuponCode);
            spq.setParameter("newValidity_startIN", newValidityStart);
            spq.setParameter("newValidity_endIN", newValidityEnd);
            spq.setParameter("newStatusIN", newStatus);
            
            spq.execute();
            
            return true;
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
            return false;
        } finally {
            em.clear();
            em.close();
            emf.close();
        }
    }
    
}
