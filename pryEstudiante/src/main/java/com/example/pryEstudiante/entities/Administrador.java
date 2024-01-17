package com.example.pryEstudiante.entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Administrador")
public class Administrador {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  protected Long id;

    @Column(length = 50)
    private String nombre;


    @Column(length = 50, unique = true)
    private String usuarioAdmin;

    @Column(length = 50)
    private String contrasenaAdmin;
    @OneToMany(mappedBy = "administrador", cascade = CascadeType.ALL)
    private List<Cohorte> cohortes;

    @OneToMany(mappedBy = "administradorEnvio", cascade = CascadeType.ALL)
    private List<Documento> documentosEnviados;

    public Administrador() {
    }

    public Administrador(Long id, String nombre, String usuarioAdmin, String contrasenaAdmin, List<Cohorte> cohortes, List<Documento> documentosEnviados) {
        this.id = id;
        this.nombre = nombre;
        this.usuarioAdmin = usuarioAdmin;
        this.contrasenaAdmin = contrasenaAdmin;
        this.cohortes = cohortes;
        this.documentosEnviados = documentosEnviados;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getUsuarioAdmin() {
        return usuarioAdmin;
    }

    public String getContrasenaAdmin() {
        return contrasenaAdmin;
    }

    public List<Cohorte> getCohortes() {return cohortes;}

    public List<Documento> getDocumentosEnviados() {return documentosEnviados;}
}
