package com.tocomfome.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "produto")
@Data
@SequenceGenerator(name = "gen_produto", sequenceName = "gen_produto", allocationSize = 1)
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "gen_produto")
    private Long id;

    @Column(columnDefinition = "descricao")
    private String descricao;

    @Override
    public String toString() {
        return "Produto [id=" + id + ", descricao=" + descricao + "]";
    }
}
