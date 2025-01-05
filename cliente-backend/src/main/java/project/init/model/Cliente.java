package project.init.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "CLIENTE", schema = "microservicesdb")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(columnDefinition = "VARCHAR(100)")
    private String names;
    @Column(name = "mat_lnames", columnDefinition = "VARCHAR(100)")
    private String matLnames;
    @Column(name = "pat_lnames", columnDefinition = "VARCHAR(100)")
    private String patLnames;
    @Column(columnDefinition = "CHAR(9)")
    private String cellphone;
    @Column(columnDefinition = "CHAR(8)")
    private String dni;
    @Column(columnDefinition = "VARCHAR(200)")
    private String address;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNames() {
        return names;
    }

    public void setNames(String names) {
        this.names = names;
    }

    public String getMatLnames() {
        return matLnames;
    }

    public void setMatLnames(String matLnames) {
        this.matLnames = matLnames;
    }

    public String getPatLnames() {
        return patLnames;
    }

    public void setPatLnames(String patLnames) {
        this.patLnames = patLnames;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
