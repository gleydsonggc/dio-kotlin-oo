enum class Nivel { BASICO, INTERMEDIARIO, DIFICIL }

data class Aluno(val nome: String)

data class ConteudoEducacional(var nome: String, val duracao: Int)

data class Formacao(val nome: String, val nivel: Nivel, var conteudos: List<ConteudoEducacional>) {
    val matriculados = mutableListOf<Aluno>()    
    fun matricular(vararg alunos: Aluno) {
        matriculados.addAll(alunos)
    }
}

fun main() {
    val c1 = ConteudoEducacional("TDD", 50)
    val c2 = ConteudoEducacional("DDD", 100)
    val c3 = ConteudoEducacional("Algoritmos", 150)    
    val formacao = Formacao("Formação em Programação", Nivel.INTERMEDIARIO, listOf(c1, c2, c3))    
    
    formacao.matricular(Aluno("A"), Aluno("B"), Aluno("C"))
    
    println("Formação: ${formacao.nome}")
    println("\nConteúdos da formação:")
    for (conteudo in formacao.conteudos) println(conteudo.nome)
    println("\nAlunos matriculados na formação:")
    for (aluno in formacao.matriculados) println(aluno.nome)
}
