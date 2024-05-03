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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gapz
 */
@Entity
@Table(name = "order")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Order1.findAll", query = "SELECT o FROM Order1 o"),
    @NamedQuery(name = "Order1.findById", query = "SELECT o FROM Order1 o WHERE o.id = :id"),
    @NamedQuery(name = "Order1.findByUserId", query = "SELECT o FROM Order1 o WHERE o.userId = :userId"),
    @NamedQuery(name = "Order1.findByDate", query = "SELECT o FROM Order1 o WHERE o.date = :date"),
    @NamedQuery(name = "Order1.findByStatus", query = "SELECT o FROM Order1 o WHERE o.status = :status"),
    @NamedQuery(name = "Order1.findBySumPrice", query = "SELECT o FROM Order1 o WHERE o.sumPrice = :sumPrice"),
    @NamedQuery(name = "Order1.findByAddressId", query = "SELECT o FROM Order1 o WHERE o.addressId = :addressId"),
    @NamedQuery(name = "Order1.findByModifier", query = "SELECT o FROM Order1 o WHERE o.modifier = :modifier"),
    @NamedQuery(name = "Order1.findByModificationDate", query = "SELECT o FROM Order1 o WHERE o.modificationDate = :modificationDate"),
    @NamedQuery(name = "Order1.findByCuponId", query = "SELECT o FROM Order1 o WHERE o.cuponId = :cuponId")})
public class Order1 implements Serializable {

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
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sum_price")
    private int sumPrice;
    @Basic(optional = false)
    @NotNull
    @Column(name = "address_id")
    private int addressId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modifier")
    private int modifier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modification_date")
    @Temporal(TemporalType.DATE)
    private Date modificationDate;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cupon_id")
    private int cuponId;

    public Order1() {
    }

    public Order1(Integer id) {
        this.id = id;
    }

    public Order1(Integer id, int userId, Date date, int status, int sumPrice, int addressId, int modifier, Date modificationDate, int cuponId) {
        this.id = id;
        this.userId = userId;
        this.date = date;
        this.status = status;
        this.sumPrice = sumPrice;
        this.addressId = addressId;
        this.modifier = modifier;
        this.modificationDate = modificationDate;
        this.cuponId = cuponId;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(int sumPrice) {
        this.sumPrice = sumPrice;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public void setModificationDate(Date modificationDate) {
        this.modificationDate = modificationDate;
    }

    public int getCuponId() {
        return cuponId;
    }

    public void setCuponId(int cuponId) {
        this.cuponId = cuponId;
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
        if (!(object instanceof Order1)) {
            return false;
        }
        Order1 other = (Order1) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.home.webshop.Model.Order1[ id=" + id + " ]";
    }
    
    
    
    // SAJÁT FÜGGVÉNYEK
    public static boolean createOrder(Integer userId, String date, Integer status, Integer sumPrice, Integer addressId, Integer modifier, String modificationDate, Integer cuponId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("createOrder");
            
            spq.registerStoredProcedureParameter("user_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("dateIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("statusIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("sum_priceIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("address_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("modifierIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("modification_dateIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("cupon_idIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("user_isIN", userId);
            spq.setParameter("dateIN", date);
            spq.setParameter("statusIN", status);
            spq.setParameter("sum_priceIN", sumPrice);
            spq.setParameter("address_idIN", addressId);
            spq.setParameter("modifierIN", modifier);
            spq.setParameter("modification_dateIN", modificationDate);
            spq.setParameter("cupon_idIN", cuponId);
            
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
    
    public static boolean deleteOrder(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteOrder");
            
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
    
    public static boolean updateOrder(Integer id, Integer newUserId, String newDate, Integer newStatus, Integer newSumPrice, Integer newAddressId, Integer newModifier, String newModificationDate, Integer newCuponId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateOrder");
            
            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newUser_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newDateIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newStatusIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newSum_priceIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newAddress_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newModifierIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newModification_dateIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newCupon_idIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("idIN", id);
            spq.setParameter("newUser_idIN", newUserId);
            spq.setParameter("newDateIN", newDate);
            spq.setParameter("newStatusIN", newStatus);
            spq.setParameter("newSum_priceIN", newSumPrice);
            spq.setParameter("newAddress_idIN", newAddressId);
            spq.setParameter("newModifierIN", newModifier);
            spq.setParameter("newModification_dateIN", newModificationDate);
            spq.setParameter("newCupon_idIN", newCuponId);
            
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
