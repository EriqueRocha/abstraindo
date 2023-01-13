enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

data class Usuario(var nome: String, var idade: Int)

data class ConteudoEducacional(var nome: String, var duracao: Int, var nivel: Nivel)

val inscritos = mutableListOf<Usuario>()
val conteudo= mutableListOf<ConteudoEducacional>()

fun matricular() {
    println("o que vc quer matricular?")
    println(" digite USUÁRIO ou CONTEÚDO para prosseguirmos")
    var escolha = readLine()

    when(escolha){
        "USUÁRIO" ->matricularUser()

        "CONTEÚDO" ->matricularConteudo()

        else -> {
            println("Tenha certeza de digitar corretamente")
            println("vamos tentar novamente")
            println("========================================")
            matricular()
        }
    }
    main()

}

fun matricularConteudo() {
    println("qual o nome do conteúdo?")
    var nome:String = readLine().toString()
    println("qual a duração do conteúdo?")
    var duracao:Int = readLine()!!.toInt()
    println("qual o nivel conteúdo, BÁSICO, INTERMEDIÁRIO, AVANÇADO?")
    var nivel:String = readLine().toString()
    when(nivel){
        "BÁSICO"-> conteudo.add(ConteudoEducacional(nome, duracao, Nivel.BASICO))
        "INTERMEDIÁRIO"-> conteudo.add(ConteudoEducacional(nome, duracao, Nivel.INTERMEDIARIO))
        "AVANÇADO"-> conteudo.add(ConteudoEducacional(nome, duracao, Nivel.AVANCADO))
        else -> {
            println("Tenha certeza de digitar corretamente")
            println("vamos tentar novamente")
            println("========================================")
            matricularConteudo()
        }
    }
    println("A formação de ADS ficou da seguinte maneira:")
    println(conteudo)
    main()

}

fun matricularUser() {
    println("qual o nome do usuário?")
    var nome:String = readLine().toString()
    println("qual a idade do usuário?")
    var idade:Int = readLine()!!.toInt()
    inscritos.add(Usuario(nome, idade))
}

fun main() {
    println("O que deseja fazer?")
    println("exibir USUÁRIOS ,FORMAÇÕES ou efetuar MATRICULAS?")
    var escolha:String = readLine().toString()
    when(escolha){
        "USUÁRIOS"-> printUser()
        "FORMAÇÕES"-> printFormacao()
        "MATRICULAS"-> matricular()
        else -> {
            println("Tenha certeza de digitar corretamente")
            println("vamos tentar novamente")
            println("========================================")
            main()
        }
    }

}
fun printUser(){
    println(inscritos)
    println("========================================")
    main()
}
fun printFormacao(){
    println(conteudo)
    println("========================================")
    main()
}
