package com.terroir.entities;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long idProduit;
    @Column(name="nom")
    private String nom;
    @Column(name="descr")
    private String descr;
    @OneToMany(fetch = FetchType.EAGER,
            mappedBy = "produit",
            cascade = {CascadeType.MERGE,
                    CascadeType.DETACH,
                    CascadeType.PERSIST})
    List<ProduitMatiereAsso> produitMatieresAsso=new ArrayList<>();

}
