package br.com.zup.edu.store.api.aplicativo;

public class AplicativoResponse {

    private String nome;
    private String link;
    private int quantidadeDownloads;
    private int quantidadeLikes;

    public AplicativoResponse(Aplicativo aplicativo) {
        this.nome = aplicativo.getNome();
        this.link = aplicativo.getLink();
        this.quantidadeDownloads = aplicativo.getQuantidadeDownloads();
        this.quantidadeLikes = aplicativo.getQuantidadeLikes();
    }

    public String getNome() {
        return nome;
    }

    public String getLink() {
        return link;
    }

    public int getQuantidadeDownloads() {
        return quantidadeDownloads;
    }

    public int getQuantidadeLikes() {
        return quantidadeLikes;
    }
}
