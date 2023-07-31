package fr.groupe_3.fil_rouge.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class Orders {

    // Attributs
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "type_presta")
    private String typePresta;

    private String designation;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    
    @Column(name = "nb_days")
    private int nbDays;
    
    @Column(name = "unit_price")
    private int unitPrice;
    
    private int state;
    
    // Constructeurs
    public Orders() {
    }
    
    public Orders(int id, String typePresta, String designation, int nbDays, int unitPrice, int state) {
        this.id = id;
        this.typePresta = typePresta;
        this.designation = designation;
        this.nbDays = nbDays;
        this.unitPrice = unitPrice;
        this.state = state;
    }
    
    // Getters Setters
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getTypePresta() {
        return typePresta;
    }
    
    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }
    
    public String getDesignation() {
        return designation;
    }
    
    public void setDesignation(String designation) {
        this.designation = designation;
    }
    
    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    // To string

    @Override
    public String toString() {
        return "Orders [id=" + id + ", typePresta=" + typePresta + ", designation=" + designation + ", nbDays=" + nbDays
                + ", unitPrice=" + unitPrice + ", state=" + state + "]";
    }

}
