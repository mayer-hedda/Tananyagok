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
import javax.persistence.Lob;
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
@Table(name = "product_modification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductModification.findAll", query = "SELECT p FROM ProductModification p"),
    @NamedQuery(name = "ProductModification.findById", query = "SELECT p FROM ProductModification p WHERE p.id = :id"),
    @NamedQuery(name = "ProductModification.findByProductId", query = "SELECT p FROM ProductModification p WHERE p.productId = :productId"),
    @NamedQuery(name = "ProductModification.findByOldPrice", query = "SELECT p FROM ProductModification p WHERE p.oldPrice = :oldPrice"),
    @NamedQuery(name = "ProductModification.findByOldName", query = "SELECT p FROM ProductModification p WHERE p.oldName = :oldName"),
    @NamedQuery(name = "ProductModification.findByOldCategoryId", query = "SELECT p FROM ProductModification p WHERE p.oldCategoryId = :oldCategoryId"),
    @NamedQuery(name = "ProductModification.findByOldImage", query = "SELECT p FROM ProductModification p WHERE p.oldImage = :oldImage"),
    @NamedQuery(name = "ProductModification.findByOldStock", query = "SELECT p FROM ProductModification p WHERE p.oldStock = :oldStock"),
    @NamedQuery(name = "ProductModification.findByNewPrice", query = "SELECT p FROM ProductModification p WHERE p.newPrice = :newPrice"),
    @NamedQuery(name = "ProductModification.findByNewName", query = "SELECT p FROM ProductModification p WHERE p.newName = :newName"),
    @NamedQuery(name = "ProductModification.findByNewCategoryId", query = "SELECT p FROM ProductModification p WHERE p.newCategoryId = :newCategoryId"),
    @NamedQuery(name = "ProductModification.findByNewImage", query = "SELECT p FROM ProductModification p WHERE p.newImage = :newImage"),
    @NamedQuery(name = "ProductModification.findByNewStock", query = "SELECT p FROM ProductModification p WHERE p.newStock = :newStock"),
    @NamedQuery(name = "ProductModification.findByModifier", query = "SELECT p FROM ProductModification p WHERE p.modifier = :modifier"),
    @NamedQuery(name = "ProductModification.findByModificationDate", query = "SELECT p FROM ProductModification p WHERE p.modificationDate = :modificationDate")})
public class ProductModification implements Serializable {

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
    @Column(name = "old_price")
    private int oldPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "old_name")
    private String oldName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "old_category_id")
    private int oldCategoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "old_image")
    private String oldImage;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "old_description")
    private String oldDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "old_stock")
    private int oldStock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "new_price")
    private int newPrice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "new_name")
    private String newName;
    @Basic(optional = false)
    @NotNull
    @Column(name = "new_category_id")
    private int newCategoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "new_image")
    private String newImage;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "new_description")
    private String newDescription;
    @Basic(optional = false)
    @NotNull
    @Column(name = "new_stock")
    private int newStock;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modifier")
    private int modifier;
    @Basic(optional = false)
    @NotNull
    @Column(name = "modification_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date modificationDate;

    public ProductModification() {
    }

    public ProductModification(Integer id) {
        this.id = id;
    }

    public ProductModification(Integer id, int productId, int oldPrice, String oldName, int oldCategoryId, String oldImage, String oldDescription, int oldStock, int newPrice, String newName, int newCategoryId, String newImage, String newDescription, int newStock, int modifier, Date modificationDate) {
        this.id = id;
        this.productId = productId;
        this.oldPrice = oldPrice;
        this.oldName = oldName;
        this.oldCategoryId = oldCategoryId;
        this.oldImage = oldImage;
        this.oldDescription = oldDescription;
        this.oldStock = oldStock;
        this.newPrice = newPrice;
        this.newName = newName;
        this.newCategoryId = newCategoryId;
        this.newImage = newImage;
        this.newDescription = newDescription;
        this.newStock = newStock;
        this.modifier = modifier;
        this.modificationDate = modificationDate;
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

    public int getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(int oldPrice) {
        this.oldPrice = oldPrice;
    }

    public String getOldName() {
        return oldName;
    }

    public void setOldName(String oldName) {
        this.oldName = oldName;
    }

    public int getOldCategoryId() {
        return oldCategoryId;
    }

    public void setOldCategoryId(int oldCategoryId) {
        this.oldCategoryId = oldCategoryId;
    }

    public String getOldImage() {
        return oldImage;
    }

    public void setOldImage(String oldImage) {
        this.oldImage = oldImage;
    }

    public String getOldDescription() {
        return oldDescription;
    }

    public void setOldDescription(String oldDescription) {
        this.oldDescription = oldDescription;
    }

    public int getOldStock() {
        return oldStock;
    }

    public void setOldStock(int oldStock) {
        this.oldStock = oldStock;
    }

    public int getNewPrice() {
        return newPrice;
    }

    public void setNewPrice(int newPrice) {
        this.newPrice = newPrice;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public int getNewCategoryId() {
        return newCategoryId;
    }

    public void setNewCategoryId(int newCategoryId) {
        this.newCategoryId = newCategoryId;
    }

    public String getNewImage() {
        return newImage;
    }

    public void setNewImage(String newImage) {
        this.newImage = newImage;
    }

    public String getNewDescription() {
        return newDescription;
    }

    public void setNewDescription(String newDescription) {
        this.newDescription = newDescription;
    }

    public int getNewStock() {
        return newStock;
    }

    public void setNewStock(int newStock) {
        this.newStock = newStock;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductModification)) {
            return false;
        }
        ProductModification other = (ProductModification) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.home.webshop.Model.ProductModification[ id=" + id + " ]";
    }
    
    
    
    // SAJÁT FÜGGVÉNYEK
    public static boolean createProduct_modification(Integer productId, Integer oldPrice, String oldName, Integer oldCategoryId, String oldImage, String oldDescription, Integer oldStock, Integer newPrice, String newName, Integer newCategoryId, String newImage, String newDescription, Integer newStock, Integer modifier, String modificationDate) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("createProduct_modification");
            
            spq.registerStoredProcedureParameter("product_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("old_priceIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("old_nameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("old_category_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("old_imageIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("old_descriptionIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("old_stockIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("new_priceIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("new_nameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("new_category_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("new_imageIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("new_descriptionIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("new_stockIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("modifierIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("modification_dateIN", String.class, ParameterMode.IN);
            
            spq.setParameter("product_idIN", productId);
            spq.setParameter("old_priceIN", oldPrice);
            spq.setParameter("old_nameIN", oldName);
            spq.setParameter("old_category_idIN", oldCategoryId);
            spq.setParameter("old_imageIN", oldImage);
            spq.setParameter("old_descriptionIN", oldDescription);
            spq.setParameter("old_stockIN", oldStock);
            spq.setParameter("new_priceIN", newPrice);
            spq.setParameter("new_nameIN", newName);
            spq.setParameter("new_category_idIN", newCategoryId);
            spq.setParameter("new_imageIN", newImage);
            spq.setParameter("new_descriptionIN", newDescription);
            spq.setParameter("new_stockIN", newStock);
            spq.setParameter("modifierIN", modifier);
            spq.setParameter("modification_dateIN", modificationDate);
            
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
    
    public static boolean deleteProduct_modification(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteProduct_modification");
            
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
    
    public static boolean updateProduct_modification(Integer id, Integer newProductId, Integer newOldPrice, String newOldName, Integer newOldCategoryId, String newOldImage, String newOldDescription, Integer newOldStock, Integer newNewPrice, String newNewName, Integer newNewCategoryId, String newNewImage, String newNewDescription, Integer newNewStock, Integer newModifier, String newModificationDate) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateProduct_modification");
            
            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newProduct_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newOld_priceIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newOld_nameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newOld_category_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newOld_imageIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newOld_descriptionIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newOld_stockIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newNew_priceIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newNew_nameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newNew_category_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newNew_imageIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newNew_descriptionIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newNew_stockIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newModifierIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newModification_dateIN", String.class, ParameterMode.IN);
            
            spq.setParameter("idIN", id);
            spq.setParameter("newProduct_idIN", newProductId);
            spq.setParameter("newOld_priceIN", newOldPrice);
            spq.setParameter("newOld_nameIN", newOldName);
            spq.setParameter("newOld_category_idIN", newOldCategoryId);
            spq.setParameter("newOld_imageIN", newOldImage);
            spq.setParameter("newOld_descriptionIN", newOldDescription);
            spq.setParameter("newOld_stockIN", newOldStock);
            spq.setParameter("newNew_priceIN", newNewPrice);
            spq.setParameter("newNew_nameIN", newNewName);
            spq.setParameter("newNew_category_idIN", newNewCategoryId);
            spq.setParameter("newNew_imageIN", newNewImage);
            spq.setParameter("newNew_descriptionIN", newNewDescription);
            spq.setParameter("newNew_stockIN", newNewStock);
            spq.setParameter("newModifierIN", newModifier);
            spq.setParameter("newModification_dateIN", newModificationDate);
            
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
