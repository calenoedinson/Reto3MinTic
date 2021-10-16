package co.usa.ciclo3.ciclo3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "calificacion")
public class Calificacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String vr_mensaje;
    private String vr_reserva;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getVr_mensaje() {
        return vr_mensaje;
    }

    public void setVr_mensaje(String vr_mensaje) {
        this.vr_mensaje = vr_mensaje;
    }

    public String getVr_reserva() {
        return vr_reserva;
    }

    public void setVr_reserva(String vr_reserva) {
        this.vr_reserva = vr_reserva;
    }


}
