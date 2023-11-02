package entidades;

import util.Juros;

public class SimulaEmplacamento {
    private String nomeDaPlaca;
    private Double valorDoEmplacamento;
    private Integer quantidadeDeParcelas;
    private Double valorTotal;
    private Double valorDaParcela;

    public SimulaEmplacamento(){
    }

    public SimulaEmplacamento(String nomeDaPlaca, Double valorDoEmplacamento, Integer quantidadeDeParcelas) {
        this.nomeDaPlaca = nomeDaPlaca;
        this.valorDoEmplacamento = valorDoEmplacamento;
        this.quantidadeDeParcelas = quantidadeDeParcelas;
    }

    @Override
    public String toString() {
        return "Nome da Placa: " + nomeDaPlaca + "\n"+
                "Valor do entidades.Emplacamento: " + valorDoEmplacamento + "R$\n"+
                "Parcelado em: " + quantidadeDeParcelas + " vezes";
    }

    public static Double calculaValorTotal(Double valorDoEmplacamento, Integer quantidadeDeParcelas){
        if (quantidadeDeParcelas == 1) return valorDoEmplacamento;
        if (quantidadeDeParcelas == 2) return (valorDoEmplacamento * Juros.JUROS_DE_2_PARCELAS) + valorDoEmplacamento;
        if (quantidadeDeParcelas == 3) return (valorDoEmplacamento * Juros.JUROS_DE_3_PARCELAS) + valorDoEmplacamento;
        if (quantidadeDeParcelas == 4) return (valorDoEmplacamento * Juros.JUROS_DE_4_PARCELAS) + valorDoEmplacamento;
        else return 0.0;
    }

    public static Double calculaValorDaParcela(Double valorDoEmplacamento, Integer quantidadeDeParcelas){
        var valorTotal = calculaValorTotal(valorDoEmplacamento,quantidadeDeParcelas);
        if (quantidadeDeParcelas == 1) return valorTotal;
        if (quantidadeDeParcelas == 2) return valorTotal / 2;
        if (quantidadeDeParcelas == 3) return valorTotal / 3;
        if (quantidadeDeParcelas == 4) return valorTotal / 4;
        else return 0.0;
    }

    public String getNomeDaPlaca() {
        return nomeDaPlaca;
    }

    public void setNomeDaPlaca(String nomeDaPlaca) {
        this.nomeDaPlaca = nomeDaPlaca;
    }

    public Integer getQuantidadeDeParcelas() {
        return quantidadeDeParcelas;
    }

    public void setQuantidadeDeParcelas(Integer quantidadeDeParcelas) {
        this.quantidadeDeParcelas = quantidadeDeParcelas;
    }

    public Double getValorDoEmplacamento() {
        return valorDoEmplacamento;
    }

    public void setValorDoEmplacamento(Double valorDoEmplacamento) {
        this.valorDoEmplacamento = valorDoEmplacamento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorDaParcela() {
        return valorDaParcela;
    }

    public void setValorDaParcela(Double valorDaParcela) {
        this.valorDaParcela = valorDaParcela;
    }
}
