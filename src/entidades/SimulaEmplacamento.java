package entidades;

import exceptions.ValorDeEntradaInvalidoException;

public class SimulaEmplacamento {
    private String nomeDaPlaca;
    private Double valorDoEmplacamento;
    private Integer quantidadeDeParcelas;
    public static final Double JUROS_DAS_PARCELAS = 0.043;

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

    public static Double calculaValorTotal(Double valorDoEmplacamento, Double valorDeEntrada){
        if (valorDeEntrada > valorDoEmplacamento){
            throw new ValorDeEntradaInvalidoException("O Valor de Entrada não pode ser maior que o Valor do Emplacamento");
        }
        double valorMenosAEntrada = valorDoEmplacamento - valorDeEntrada;
        return valorMenosAEntrada * SimulaEmplacamento.JUROS_DAS_PARCELAS + valorMenosAEntrada;
    }

    public static Double calculaValorDaParcela(Double valorDoEmplacamento, Integer quantidadeDeParcelas, Double valorDeEntrada){
        double valorTotal = calculaValorTotal(valorDoEmplacamento,valorDeEntrada);
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
}
