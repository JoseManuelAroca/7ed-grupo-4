package com.atm.buenas_practicas_java.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false, length = 30)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellidos;

    @Column(nullable = false, length = 30, unique = true)
    private String nickname;

    @Column(nullable = false, length = 30, unique = true)
    private String email;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false)
    private Integer token;
    @Basic(optional = false)
    private boolean active = true;

    // Rol
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private UserRol rol;
    // Relaciones bidireccionales
    @OneToMany(mappedBy = "usuario")
    private List<UsuarioContenido> usuarioContenidos;

    @OneToMany(mappedBy = "usuario")
    private List<Comentario> comentarios;

    @OneToMany(mappedBy = "usuario")
    private List<Like> likes;

    @OneToMany(mappedBy = "usuario")
    private List<Reporte> reportes;

    @OneToMany(mappedBy = "bloqueador")
    private List<UsuarioBloqueado> bloqueados;

    @OneToMany(mappedBy = "bloqueado")
    private List<UsuarioBloqueado> bloqueadores;

    @OneToMany(mappedBy = "emisor")
    private List<Chat> chatsEnviados;

    @OneToMany(mappedBy = "receptor")
    private List<Chat> chatsRecibidos;

    @OneToMany(mappedBy = "usuario")
    private List<Cartera> movimientos;
}
