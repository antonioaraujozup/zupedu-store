package br.com.zup.edu.store.api.aplicativo;

import javax.persistence.*;

@Entity
public class Aplicativo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String descricao;

    @Column(nullable = false)
    private String link;

    @Version
    private int versao;

    @OneToOne(mappedBy = "aplicativo", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeDownloadsAplicativo quantidadeDownloads;

    @OneToOne(mappedBy = "aplicativo", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private QuantidadeLikesAplicativo quantidadeLikes;

    public Aplicativo(String nome, String descricao, String link) {
        this.nome = nome;
        this.descricao = descricao;
        this.link = link;
        this.quantidadeDownloads = new QuantidadeDownloadsAplicativo(this);
        this.quantidadeLikes = new QuantidadeLikesAplicativo(this);
    }

    /**
     * @deprecated Construtor para uso exclusivo do Hibernate.
     */
    @Deprecated
    public Aplicativo() {
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getLink() {
        return link;
    }

    public int getQuantidadeDownloads() {
        return quantidadeDownloads.getQuantidade();
    }

    public int getQuantidadeLikes() {
        return quantidadeLikes.getQuantidade();
    }

    public void incrementaDownloads() {
        this.quantidadeDownloads.incrementa();
    }

    public void incrementaLikes() {
        this.quantidadeLikes.incrementa();
    }
}
