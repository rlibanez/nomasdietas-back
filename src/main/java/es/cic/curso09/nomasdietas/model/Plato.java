package es.cic.curso09.nomasdietas.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

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

    @Size(min = 1, max = 256)
    private String descripcion;

    @Size(max = 64)
    private List<@Size(min = 1, max = 64) String> otrosIngredientes = new ArrayList<>();

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

    public List<String> getOtrosIngredientes() {
        return otrosIngredientes;
    }

    public void setOtrosIngredientes(List<String> otrosIngredientes) {
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

}
