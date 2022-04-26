package br.com.zup.edu.store.api.aplicativo;

import javax.persistence.*;

@Entity
public class QuantidadeLikesAplicativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int quantidade;

    @Version
    private int versao;

    @OneToOne(optional = false)
    private Aplicativo aplicativo;

    public QuantidadeLikesAplicativo(Aplicativo aplicativo) {
        this.aplicativo = aplicativo;
        this.quantidade = 0;
    }

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public QuantidadeLikesAplicativo() {
    }

    public void incrementa() {
        this.quantidade++;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
