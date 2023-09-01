enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(val nome: String)

data class ConteudoEducacional(val nome: String, val duracao: Int = 60)

class Formacao(val nome: String, val nivel: Nivel, val conteudos: List<ConteudoEducacional>) {
    val inscritos = mutableSetOf<Usuario>()

    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("Usuário ${usuario.nome} matriculado na formação $nome.")
    }

    fun listarInscritos() {
        if (inscritos.isNotEmpty()) {
            println("Alunos matriculados na formação $nome:")
            inscritos.forEachIndexed { index, aluno ->
                println("${index + 1}. ${aluno.nome}")
            }
        } else {
            println("Nenhum aluno matriculado na formação $nome ainda.")
        }
    }

    fun listarConteudos() {
        println("Conteúdos da formação $nome:")
        conteudos.forEachIndexed { index, conteudo ->
            println("${index + 1}. ${conteudo.nome} (${conteudo.duracao} minutos)")
        }
    }
}

fun main() {
    val conteudo1 = ConteudoEducacional("Introdução à Programação", 90)
    val conteudo2 = ConteudoEducacional("Estruturas de Dados", 120)

    val formacao1 = Formacao("Formação de Desenvolvimento de Software", Nivel.INTERMEDIARIO, listOf(conteudo1, conteudo2))
    val formacao2 = Formacao("Formação de Data Science", Nivel.INTERMEDIARIO, listOf(conteudo1))

    val aluno1 = Usuario("João")
    val aluno2 = Usuario("Maria")

    formacao1.matricular(aluno1)
    formacao2.matricular(aluno1)
    formacao2.matricular(aluno2)

    println("Inscritos nas formações:")
    listarInscritos(formacao1, formacao2)

    println("Conteúdos das formações:")
    listarConteudos(formacao1, formacao2)
}

fun listarInscritos(vararg formacoes: Formacao) {
    formacoes.forEach { formacao ->
        formacao.listarInscritos()
    }
}

fun listarConteudos(vararg formacoes: Formacao) {
    formacoes.forEach { formacao ->
        formacao.listarConteudos()
    }
}