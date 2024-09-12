package es.cic.curso09.nomasdietas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Plato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 64)
    private String nombre;

    @Size(max = 256)
    private String descripcion;

    @Size(max = 64)
    private String otrosIngredientes;

    // Unidades por cada 100 gramos de plato
    @NotNull
    @Min(0)
    private float cantidadIngredientePrincipal;
    @Min(0)
    private float calorias;
    @Min(0)
    private float carbohidratos;
    @Min(0)
    private float proteinas;
    @Min(0)
    private float grasas;

    @NotNull
    private boolean favorito = false;

    // @NotNull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "ingrediente_id", nullable = false)
    // @JsonIgnore
    private Ingrediente ingrediente;

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

    public String getOtrosIngredientes() {
        return otrosIngredientes;
    }

    public void setOtrosIngredientes(String otrosIngredientes) {
        this.otrosIngredientes = otrosIngredientes;
    }

    public float getCantidadIngredientePrincipal() {
        return cantidadIngredientePrincipal;
    }

    public void setCantidadIngredientePrincipal(float cantidadIngredientePrincipal) {
        this.cantidadIngredientePrincipal = cantidadIngredientePrincipal;
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

    public boolean isFavorito() {
        return favorito;
    }

    public void setFavorito(boolean favorito) {
        this.favorito = favorito;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
        result = prime * result + ((descripcion == null) ? 0 : descripcion.hashCode());
        result = prime * result + ((otrosIngredientes == null) ? 0 : otrosIngredientes.hashCode());
        result = prime * result + Float.floatToIntBits(cantidadIngredientePrincipal);
        result = prime * result + Float.floatToIntBits(calorias);
        result = prime * result + Float.floatToIntBits(carbohidratos);
        result = prime * result + Float.floatToIntBits(proteinas);
        result = prime * result + Float.floatToIntBits(grasas);
        result = prime * result + (favorito ? 1231 : 1237);
        result = prime * result + ((ingrediente == null) ? 0 : ingrediente.hashCode());
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
        Plato other = (Plato) obj;
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
        if (otrosIngredientes == null) {
            if (other.otrosIngredientes != null)
                return false;
        } else if (!otrosIngredientes.equals(other.otrosIngredientes))
            return false;
        if (Float.floatToIntBits(cantidadIngredientePrincipal) != Float
                .floatToIntBits(other.cantidadIngredientePrincipal))
            return false;
        if (Float.floatToIntBits(calorias) != Float.floatToIntBits(other.calorias))
            return false;
        if (Float.floatToIntBits(carbohidratos) != Float.floatToIntBits(other.carbohidratos))
            return false;
        if (Float.floatToIntBits(proteinas) != Float.floatToIntBits(other.proteinas))
            return false;
        if (Float.floatToIntBits(grasas) != Float.floatToIntBits(other.grasas))
            return false;
        if (favorito != other.favorito)
            return false;
        if (ingrediente == null) {
            if (other.ingrediente != null)
                return false;
        } else if (!ingrediente.equals(other.ingrediente))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Plato [nombre=" + nombre + ", descripcion=" + descripcion + ", otrosIngredientes=" + otrosIngredientes
                + ", cantidadIngredientePrincipal=" + cantidadIngredientePrincipal + ", calorias=" + calorias
                + ", carbohidratos=" + carbohidratos + ", proteinas=" + proteinas + ", grasas=" + grasas + ", favorito="
                + favorito + ", ingrediente=" + ingrediente + "]";
    }

}
