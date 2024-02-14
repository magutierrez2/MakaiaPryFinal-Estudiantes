package com.example.pryEstudiante.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Estudiante")
public class Estudiante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 50)
    private String nombre;
    @Column (length = 50)
    private String documento;

    @Column(length = 50, unique = true)
    private String email;

    @Column(length = 100)
    private String contrasena;
  @OneToOne(mappedBy = "estudiante",cascade = CascadeType.ALL)
  private Aspirante aspirante;

  @OneToMany (mappedBy = "estudiante", cascade = CascadeType.ALL)
  List<Cohorte> cohorte;




    public Estudiante() {
    }




}

