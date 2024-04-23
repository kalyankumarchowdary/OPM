package com.project.opm.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Base64;

@Entity
@Table(name = "TENANT")
public class TenantEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TENANT_SEQ")
    @SequenceGenerator(sequenceName = "TENANT_SEQ", allocationSize = 1, name = "TENANT_SEQ")
    @Column(name = "TENANT_UID")
    private Integer tenantUID;
    @Column(name = "TENANT_ID")
    private String tenantId;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "ACCOUNT")
    private String account;
    @Column(name = "CREATED_DATE")
    private Date createdDate;
    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;
    @Column(name = "STATUS")
    private String status;

    public String getTenantId() {
        return tenantId;
    }

    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        byte[] decodedBytes = Base64.getDecoder().decode(password);
        // Return the decoded password
        return new String(decodedBytes);
    }

    public void setPassword(String password) {
        this.password = Base64.getEncoder().encodeToString(password.getBytes());
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
