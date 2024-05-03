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
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id"),
    @NamedQuery(name = "Address.findByCountry", query = "SELECT a FROM Address a WHERE a.country = :country"),
    @NamedQuery(name = "Address.findByPostcode", query = "SELECT a FROM Address a WHERE a.postcode = :postcode"),
    @NamedQuery(name = "Address.findByCity", query = "SELECT a FROM Address a WHERE a.city = :city"),
    @NamedQuery(name = "Address.findByHomeAddress", query = "SELECT a FROM Address a WHERE a.homeAddress = :homeAddress")})
public class Address implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "country")
    private String country;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 4)
    @Column(name = "postcode")
    private String postcode;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "city")
    private String city;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "home_address")
    private String homeAddress;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "comment")
    private String comment;

    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Address(Integer id, String country, String postcode, String city, String homeAddress, String comment) {
        this.id = id;
        this.country = country;
        this.postcode = postcode;
        this.city = city;
        this.homeAddress = homeAddress;
        this.comment = comment;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.home.webshop.Model.Address[ id=" + id + " ]";
    }
    
    
    
    // SAJÁT FÜGGVÉNYEK
    public static boolean createAddress(String country, String postcode, String city, String homeAddress, String comment) {
        // adatbázis kapcsolat példányosítása
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            // tárolt eljárás példányosítása
            StoredProcedureQuery spq = em.createStoredProcedureQuery("createAddress");
            
            // paraméterek regisztrációja
            spq.registerStoredProcedureParameter("countryIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("postcodeIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("cityIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("home_addressIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("commentIN", String.class, ParameterMode.IN);
            
            // paraméterek értékadása
            spq.setParameter("countryIN", country);
            spq.setParameter("postcodeIN", postcode);
            spq.setParameter("cityIN", city);
            spq.setParameter("home_addressIN", homeAddress);
            spq.setParameter("commentIN", comment);
            
            // eljárás meghívása
            spq.execute();
            
            return true;
        } catch(Exception ex) {
            // hibát dob a try ág
            System.err.println(ex.getMessage());
            return false;
        } finally {
            // adatbázis kapcsolat lezárása biztonsági okokból
            em.clear();
            em.close();
            emf.close();
        }
    }
    
    public static boolean deleteAddress(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteAddress");
            
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
    
    public static boolean updateAddress(Integer id, String newCountry, String newPostcode, String newCity, String newHomeAddress, String newComment) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateAddress");
            
            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newCountryIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newPostcodeIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newCityIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newHome_addressIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newCommentIN", String.class, ParameterMode.IN);
            
            spq.setParameter("idIN", id);
            spq.setParameter("newCountryIN", newCountry);
            spq.setParameter("newPostcodeIN", newPostcode);
            spq.setParameter("newCityIN", newCity);
            spq.setParameter("newHome_addressIN", newHomeAddress);
            spq.setParameter("newCommentIN", newComment);
            
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
