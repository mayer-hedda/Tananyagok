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
@Table(name = "user_addresses")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAddresses.findAll", query = "SELECT u FROM UserAddresses u"),
    @NamedQuery(name = "UserAddresses.findById", query = "SELECT u FROM UserAddresses u WHERE u.id = :id"),
    @NamedQuery(name = "UserAddresses.findByUserId", query = "SELECT u FROM UserAddresses u WHERE u.userId = :userId"),
    @NamedQuery(name = "UserAddresses.findByAddressId", query = "SELECT u FROM UserAddresses u WHERE u.addressId = :addressId"),
    @NamedQuery(name = "UserAddresses.findByType", query = "SELECT u FROM UserAddresses u WHERE u.type = :type"),
    @NamedQuery(name = "UserAddresses.findByCreationDate", query = "SELECT u FROM UserAddresses u WHERE u.creationDate = :creationDate")})
public class UserAddresses implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "user_id")
    private int userId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "address_id")
    private int addressId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "type")
    private String type;
    @Basic(optional = false)
    @NotNull
    @Column(name = "creation_date")
    @Temporal(TemporalType.DATE)
    private Date creationDate;

    public UserAddresses() {
    }

    public UserAddresses(Integer id) {
        this.id = id;
    }

    public UserAddresses(Integer id, int userId, int addressId, String type, Date creationDate) {
        this.id = id;
        this.userId = userId;
        this.addressId = addressId;
        this.type = type;
        this.creationDate = creationDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
        if (!(object instanceof UserAddresses)) {
            return false;
        }
        UserAddresses other = (UserAddresses) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.home.webshop.Model.UserAddresses[ id=" + id + " ]";
    }
    
    
    
    // SAJÁT FÜGGVÉNYEK
    public static boolean createUser_addresses(Integer userId, Integer addressId, String type, String creationDate) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("createUser_addresses");
            
            spq.registerStoredProcedureParameter("user_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("address_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("typeIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("creation_dateIN", String.class, ParameterMode.IN);
            
            spq.setParameter("user_idIN", userId);
            spq.setParameter("address_idIN", addressId);
            spq.setParameter("typeIN", type);
            spq.setParameter("creation_dateIN", creationDate);
            
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
    
    public static boolean deleteUser_addresses(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteUser_addresses");
            
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
    
    public static boolean updateUser_addresses(Integer id, Integer newUserId, Integer newAddressId, String newType, String newCreationDate) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateUser_addresses");
            
            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newUser_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newAddress_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newTypeIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newCreatin_dateIN", String.class, ParameterMode.IN);
            
            spq.setParameter("idIN", id);
            spq.setParameter("newUser_idIN", newUserId);
            spq.setParameter("newAddress_idIN", newAddressId);
            spq.setParameter("newTypeIN", newType);
            spq.setParameter("newCreatin_dateIN", newCreationDate);
            
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
