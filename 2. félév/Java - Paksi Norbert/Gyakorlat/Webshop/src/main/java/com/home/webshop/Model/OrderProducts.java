/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home.webshop.Model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gapz
 */
@Entity
@Table(name = "order_products")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "OrderProducts.findAll", query = "SELECT o FROM OrderProducts o"),
    @NamedQuery(name = "OrderProducts.findById", query = "SELECT o FROM OrderProducts o WHERE o.id = :id"),
    @NamedQuery(name = "OrderProducts.findByProductId", query = "SELECT o FROM OrderProducts o WHERE o.productId = :productId"),
    @NamedQuery(name = "OrderProducts.findByProductQuantity", query = "SELECT o FROM OrderProducts o WHERE o.productQuantity = :productQuantity"),
    @NamedQuery(name = "OrderProducts.findByOrderId", query = "SELECT o FROM OrderProducts o WHERE o.orderId = :orderId")})
public class OrderProducts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_id")
    private int productId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "product_quantity")
    private int productQuantity;
    @Basic(optional = false)
    @NotNull
    @Column(name = "order_id")
    private int orderId;

    public OrderProducts() {
    }

    public OrderProducts(Integer id) {
        this.id = id;
    }

    public OrderProducts(Integer id, int productId, int productQuantity, int orderId) {
        this.id = id;
        this.productId = productId;
        this.productQuantity = productQuantity;
        this.orderId = orderId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
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
        if (!(object instanceof OrderProducts)) {
            return false;
        }
        OrderProducts other = (OrderProducts) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.home.webshop.Model.OrderProducts[ id=" + id + " ]";
    }
    
    
    
    // SAJÁT FÜGGVÉNYEK
    public static boolean createOrder_products(Integer productId, Integer productQuantity, Integer orderId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("createOrder_products");
            
            spq.registerStoredProcedureParameter("product_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("product_quantityIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("order_idIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("product_idIN", productId);
            spq.setParameter("product_quantityIN", productQuantity);
            spq.setParameter("order_idIN", orderId);
            
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
    
    public static boolean deleteOrder_products(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteOrder_products");
            
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
    
    public static boolean updateOrder_products(Integer id, Integer newProductId, Integer newProductQuantity, Integer newOrderId) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateOrder_products");
            
            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newProduct_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newProduct_quantityIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newOrder_idIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("idIN", id);
            spq.setParameter("newProduct_idIN", newProductId);
            spq.setParameter("newProduct_quantityIN", newProductQuantity);
            spq.setParameter("newOrder_idIN", newOrderId);
            
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
