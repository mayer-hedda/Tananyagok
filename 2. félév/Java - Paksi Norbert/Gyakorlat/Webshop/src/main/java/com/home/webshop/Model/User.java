/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.home.webshop.Model;

import com.home.webshop.Exception.EmailException;
import com.home.webshop.Exception.PasswordException;
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
@Table(name = "user")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
    @NamedQuery(name = "User.findById", query = "SELECT u FROM User u WHERE u.id = :id"),
    @NamedQuery(name = "User.findByUsername", query = "SELECT u FROM User u WHERE u.username = :username"),
    @NamedQuery(name = "User.findByEmail", query = "SELECT u FROM User u WHERE u.email = :email"),
    @NamedQuery(name = "User.findByPassword", query = "SELECT u FROM User u WHERE u.password = :password"),
    @NamedQuery(name = "User.findByRank", query = "SELECT u FROM User u WHERE u.rank = :rank"),
    @NamedQuery(name = "User.findByPhone", query = "SELECT u FROM User u WHERE u.phone = :phone"),
    @NamedQuery(name = "User.findBySurename", query = "SELECT u FROM User u WHERE u.surename = :surename"),
    @NamedQuery(name = "User.findByForename", query = "SELECT u FROM User u WHERE u.forename = :forename"),
    @NamedQuery(name = "User.findByStatus", query = "SELECT u FROM User u WHERE u.status = :status"),
    @NamedQuery(name = "User.findByLastLogin", query = "SELECT u FROM User u WHERE u.lastLogin = :lastLogin"),
    @NamedQuery(name = "User.findByRegistrationTime", query = "SELECT u FROM User u WHERE u.registrationTime = :registrationTime")})
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "username")
    private String username;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "password")
    private String password;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 7)
    @Column(name = "rank")
    private String rank;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Invalid phone/fax format, should be as xxx-xxx-xxxx")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "phone")
    private String phone;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "surename")
    private String surename;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "forename")
    private String forename;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "last_login")
    @Temporal(TemporalType.DATE)
    private Date lastLogin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "registration_time")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationTime;

    public User() {
    }

    public User(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        User user = em.find(User.class, id);
        
        this.id = user.getId();
        this.email = user.getEmail();
        this.rank = user.getRank();
        this.username = user.getUsername();
        // stb
        
        em.clear();
        em.close();
        emf.close();
    }

    public User(Integer id, String username, String email, String password, String rank, String phone, String surename, String forename, int status, Date lastLogin, Date registrationTime) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.rank = rank;
        this.phone = phone;
        this.surename = surename;
        this.forename = forename;
        this.status = status;
        this.lastLogin = lastLogin;
        this.registrationTime = registrationTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSurename() {
        return surename;
    }

    public void setSurename(String surename) {
        this.surename = surename;
    }

    public String getForename() {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getRegistrationTime() {
        return registrationTime;
    }

    public void setRegistrationTime(Date registrationTime) {
        this.registrationTime = registrationTime;
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
        if (!(object instanceof User)) {
            return false;
        }
        User other = (User) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.home.webshop.Model.User[ id=" + id + "email= " + email + "admin="+ rank + "]";
    }
    
    
    
    // SAJÁT FÜGGVÉNYEK
    public static boolean createUser(String username, String email, String password, String rank, String phone, String surename, String forename, Integer status) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("createUser");
            
            spq.registerStoredProcedureParameter("usernameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("passwordIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("rankIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("phoneIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("surenameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("forenameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("statusIN", Integer.class, ParameterMode.IN);
            
            spq.setParameter("usernameIN", username);
            spq.setParameter("emailIN", email);
            spq.setParameter("passwordIN", password);
            spq.setParameter("rankIN", rank);
            spq.setParameter("phoneIN", phone);
            spq.setParameter("surenameIN", surename);
            spq.setParameter("forenameIN", forename);
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
    
    public static User login(String email, String password) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("login");
            
            spq.registerStoredProcedureParameter("emailIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("passwordIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("idOUT", Integer.class, ParameterMode.OUT);
            
            spq.setParameter("emailIN", email);
            spq.setParameter("passwordIN", password);
            
            spq.execute();
            
            Integer id = Integer.parseInt(spq.getOutputParameterValue("idOUT").toString());
            return new User(id);
            
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
            return new User();
            // saját exceptiont kéne írni, hogy a bejelentkezés sikertelen (miért)
        } finally {
            em.clear();
            em.close();
            emf.close();
        }
    }
    
    public static boolean deleteUser(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("deleteUser");
            
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
    
    public static boolean updateUser(Integer id, String newUsername, String newEmail, String newPassword, String newRank, String newPhone, String newSurename, String newForename, Integer newStatus, String newLastLogin, String newRegistrationTime) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("com.Home_Webshop_war_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();
        
        try {
            StoredProcedureQuery spq = em.createStoredProcedureQuery("updateUser");
            
            spq.registerStoredProcedureParameter("idIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newUsernameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newEmailIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newPasswordIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newRankIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newPhoneIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newSurenameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newForenameIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newStatusIN", Integer.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newLast_loginIN", String.class, ParameterMode.IN);
            spq.registerStoredProcedureParameter("newRegistration_timeIN", String.class, ParameterMode.IN);
            
            spq.setParameter("idIN", id);
            spq.setParameter("newUsernameIN", newUsername);
            spq.setParameter("newEmailIN", newEmail);
            spq.setParameter("newPasswordIN", newPassword);
            spq.setParameter("newRankIN", newRank);
            spq.setParameter("newPhoneIN", newPhone);
            spq.setParameter("newSurenameIN", newSurename);
            spq.setParameter("newForenameIN", newForename);
            spq.setParameter("newStatusIN", newStatus);
            spq.setParameter("newLast_loginIN", newLastLogin);
            spq.setParameter("newRegistration_timeIN", newRegistrationTime);
            
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
    
    public static boolean emailCheck(String email) throws EmailException {
        // gmail domain, @ előtt legalább 3 karakter, .com
        if(!email.contains("@gmail.com")) {
            throw new EmailException("Nem megfelelő az email formátuma (Csak gmail-es fiókkal tud regisztrálni)!");
        } else if(email.substring(0, email.indexOf("@")).length() < 3) {
            throw new EmailException("Az email címnek a domain-en kívül legalább 3 karaktert kell tartalmaznia.");
        } else {
            return true;
        }
    }
    
    public static boolean passwordCheck(String password) throws PasswordException {
        // 8 karakter hosszú
        if(password.length() < 8){
            throw new PasswordException("A jelszó nem elég hosszú!");
            // return false;
        }
//        // kisbetű
//        else if(!password.matches(".[a-z].")){
//            throw new PasswordException("A jelszónak tartalmaznia kell legalább egy kisbetűt.");
//        }
//        // nagybetű
//        else if(!password.matches(".[A-Z].")){
//            throw new PasswordException("A jelszónak tartalmaznia kell legalább egy nagybetűt.");
//        }
//        // szám
//        else if(!password.matches(".[0-9].")){
//            throw new PasswordException("A jelszónak tartalmaznia kell legalább egy számot.");
//        }
//        // speciális karakter
//        else if(!password.matches(".[!@#$%&()_+=|<>?{}\\[\\]~-].*")){
//            throw new PasswordException("A jelszónak tartalmaznia kell legalább egy speciális karaktert.");
//        }
        else{
            return true;
        }
    }
    
}
