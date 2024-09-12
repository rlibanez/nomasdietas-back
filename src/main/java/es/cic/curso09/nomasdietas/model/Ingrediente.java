package es.cic.curso09.nomasdietas.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Ingrediente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 64)
    private String nombre;

    @Size(max = 256)
    private String descripcion;

    // Unidades por cada 100 gramos de ingrediente
    @Min(0)
    private float calorias;
    @Min(0)
    private float carbohidratos;
    @Min(0)
    private float proteinas;
    @Min(0)
    private float grasas;

    @JsonIgnore
    @OneToMany(mappedBy = "ingrediente", cascade = { CascadeType.PERSIST, CascadeType.MERGE }, orphanRemoval = false)
    private List<Plato> platos = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

    public float getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(float carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public float getProteinas() {
        return proteinas;
    }

    public void setProteinas(float proteinas) {
        this.proteinas = proteinas;
    }

    public float getGrasas() {
        return grasas;
    }

    public void setGrasas(float grasas) {
        this.grasas = grasas;
    }

    public List<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + Float.floatToIntBits(calorias);
        result = prime * result + Float.floatToIntBits(carbohidratos);
        result = prime * result + Float.floatToIntBits(proteinas);
        result = prime * result + Float.floatToIntBits(grasas);
        result = prime * result + ((platos == null) ? 0 : platos.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ingrediente other = (Ingrediente) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (nombre == null) {
            if (other.nombre != null)
                return false;
        } else if (!nombre.equals(other.nombre))
            return false;
        if (descripcion == null) {
            if (other.descripcion != null)
                return false;
        } else if (!descripcion.equals(other.descripcion))
            return false;
        if (Float.floatToIntBits(calorias) != Float.floatToIntBits(other.calorias))
            return false;
        if (Float.floatToIntBits(carbohidratos) != Float.floatToIntBits(other.carbohidratos))
            return false;
        if (Float.floatToIntBits(proteinas) != Float.floatToIntBits(other.proteinas))
            return false;
        if (Float.floatToIntBits(grasas) != Float.floatToIntBits(other.grasas))
            return false;
        if (platos == null) {
            if (other.platos != null)
                return false;
        } else if (!platos.equals(other.platos))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Ingrediente [nombre=" + nombre + ", descripcion=" + descripcion + ", calorias=" + calorias
                + ", carbohidratos=" + carbohidratos + ", proteinas=" + proteinas + ", grasas=" + grasas + ", platos="
                + platos + "]";
    }

}
