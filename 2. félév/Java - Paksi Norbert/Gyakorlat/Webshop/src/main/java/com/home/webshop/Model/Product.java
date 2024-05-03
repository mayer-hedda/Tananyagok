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
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.ParameterMode;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author gapz
 */
@Entity
@Table(name = "product")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Product.findAll", query = "SELECT p FROM Product p"),
    @NamedQuery(name = "Product.findById", query = "SELECT p FROM Product p WHERE p.id = :id"),
    @NamedQuery(name = "Product.findByPrice", query = "SELECT p FROM Product p WHERE p.price = :price"),
    @NamedQuery(name = "Product.findByName", query = "SELECT p FROM Product p WHERE p.name = :name"),
    @NamedQuery(name = "Product.findByCategoryId", query = "SELECT p FROM Product p WHERE p.categoryId = :categoryId"),
    @NamedQuery(name = "Product.findByImage", query = "SELECT p FROM Product p WHERE p.image = :image"),
    @NamedQuery(name = "Product.findByStock", query = "SELECT p FROM Product p WHERE p.stock = :stock")})
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "price")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "category_id")
    private int categoryId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "description")
    private String description;
    @Basic(optional = false)
    @NotNull
    @Column(name = "stock")
    private int stock;

    public Product() {
    }

    public Product(Integer id) {
        this.id = id;
    }

    public Product(Integer id, int price, String name, int categoryId, String image, String description, int stock) {
        this.id = id;
        this.price = price;
        this.name = name;
        this.categoryId = categoryId;
        this.image = image;
        this.description = description;
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
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
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.home.webshop.Model.Product[ id=" + id + " ]";
    }
    
    
    
    // SAJÁT FÜGGVÉNYEK
    public static boolean createProduct(Integer price, String name, Integer categoryId, String image, String description, Integer stock) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("createProduct");
            
            spq.registerStoredProcedureParameter("priceIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("nameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("category_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("imageIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("descriptionIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("stockIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("priceIN", price);
            spq.setParameter("nameIN", name);
            spq.setParameter("category_idIN", categoryId);
            spq.setParameter("imageIN", image);
            spq.setParameter("descriptionIN", description);
            spq.setParameter("stockIN", stock);
            
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
    
    public static boolean deleteProduct(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteProduct");
            
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
    
    public static boolean updateProduct(Integer id, Integer newPrice, String newName, Integer newCategoryId, String newImage, String newDescription, Integer newStock) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateProduct");
            
            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newPriceIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newNameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newCategory_idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newImageIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newDescriptionIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newStockIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("idIN", id);
            spq.setParameter("newPriceIN", newPrice);
            spq.setParameter("newNameIN", newName);
            spq.setParameter("newCategory_idIN", newCategoryId);
            spq.setParameter("newImageIN", newImage);
            spq.setParameter("newDescriptionIN", newDescription);
            spq.setParameter("newStockIN", newStock);
            
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
