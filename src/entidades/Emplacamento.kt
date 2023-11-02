package entidades

data class Emplacamento(
    val nomeDaPlaca: String,
    val valorDoEmplacamento: Double,
    val quantideDeParcelas: Int ){

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Emplacamento

        return nomeDaPlaca == other.nomeDaPlaca
    }

    override fun hashCode(): Int {
        return nomeDaPlaca.hashCode()
    }
}