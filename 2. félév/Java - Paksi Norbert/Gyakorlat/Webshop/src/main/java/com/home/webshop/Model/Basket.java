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
@Table(name = "basket")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Basket.findAll", query = "SELECT b FROM Basket b"),
    @NamedQuery(name = "Basket.findById", query = "SELECT b FROM Basket b WHERE b.id = :id"),
    @NamedQuery(name = "Basket.findByUserId", query = "SELECT b FROM Basket b WHERE b.userId = :userId"),
    @NamedQuery(name = "Basket.findByProductId", query = "SELECT b FROM Basket b WHERE b.productId = :productId"),
    @NamedQuery(name = "Basket.findByQuantity", query = "SELECT b FROM Basket b WHERE b.quantity = :quantity"),
    @NamedQuery(name = "Basket.findByUploadTime", query = "SELECT b FROM Basket b WHERE b.uploadTime = :uploadTime"),
    @NamedQuery(name = "Basket.findByStatus", query = "SELECT b FROM Basket b WHERE b.status = :status"),
    @NamedQuery(name = "Basket.findByDeleteTime", query = "SELECT b FROM Basket b WHERE b.deleteTime = :deleteTime")})
public class Basket implements Serializable {

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
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantity")
    private int quantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "upload_time")
    @Temporal(TemporalType.DATE)
    private Date uploadTime;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "status")
    private String status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "delete_time")
    @Temporal(TemporalType.DATE)
    private Date deleteTime;

    public Basket() {
    }

    public Basket(Integer id) {
        this.id = id;
    }

    public Basket(Integer id, int userId, int productId, int quantity, Date uploadTime, String status, Date deleteTime) {
        this.id = id;
        this.userId = userId;
        this.productId = productId;
        this.quantity = quantity;
        this.uploadTime = uploadTime;
        this.status = status;
        this.deleteTime = deleteTime;
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

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(Date uploadTime) {
        this.uploadTime = uploadTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDeleteTime() {
        return deleteTime;
    }

    public void setDeleteTime(Date deleteTime) {
        this.deleteTime = deleteTime;
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
        if (!(object instanceof Basket)) {
            return false;
        }
        Basket other = (Basket) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.home.webshop.Model.Basket[ id=" + id + " ]";
    }
    
    
    
    // SAJÁT FÜGGVÉNYEK
    public static boolean createBasket(Integer userId, Integer productId, Integer quantity, String uploadTime, String status, String deleteTime) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("createBasket");
            
            spq.registerStoredProcedureParameter("user_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("product_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("quatityIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("upload_timeIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("statusIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("delete_timeIN", String.class, ParameterMode.IN);
            
            spq.setParameter("user_idIN", userId);
            spq.setParameter("product_idIN", productId);
            spq.setParameter("quatityIN", quantity);
            spq.setParameter("upload_timeIN", uploadTime);
            spq.setParameter("statusIN", status);
            spq.setParameter("delete_timeIN", deleteTime);
            
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
    
    public static boolean deleteBasket(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteBasket");
            
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
    
    public static boolean updateBasket(Integer id, Integer newUserId, Integer newProductId, Integer newQuantity, String newUploadTime, String newStatus, String newDeleteTime) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateBasket");
            
            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newUser_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newProduct_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newQuantityIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newUpload_timeIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newStatusIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newDelete_timeIN", String.class, ParameterMode.IN);
            
            spq.setParameter("idIN", id);
            spq.setParameter("newUser_idIN", newUserId);
            spq.setParameter("newProduct_idIN", newProductId);
            spq.setParameter("newQuantityIN", newQuantity);
            spq.setParameter("newUpload_timeIN", newUploadTime);
            spq.setParameter("newStatusIN", newStatus);
            spq.setParameter("newDelete_timeIN", newDeleteTime);
            
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
