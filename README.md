#Sistema de Detetive Investigativo
##Integrantes
Érica Gonçalves Domingos Do Nascimento
Julia Soares Catharino
Maria Luíza Barcelos Mendes
Maria Luiza Cordeiro Lisboa
Sarah De Moura Silva


##Disciplina
Desenvolvimento de Software

#Descrição do Projeto

O Sistema de Detetive Investigativo é uma aplicação desenvolvida em Java utilizando os conceitos de Programação Orientada a Objetos (POO). O sistema permite o gerenciamento de investigações criminais por meio do cadastro de casos, suspeitos, investigadores, pistas e interrogatórios.
O projeto foi desenvolvido seguindo a arquitetura MVC (Model-View-Controller) e contempla conceitos como herança, polimorfismo, interfaces, classes abstratas, tratamento de exceções, coleções e persistência de dados.

##Objetivos
- Aplicar os conceitos estudados durante a disciplina.
- Desenvolver um sistema organizado utilizando MVC.
- Implementar relacionamentos entre classes.
- Realizar persistência de dados em arquivos.
- Demonstrar o uso de herança, interfaces e polimorfismo.

#Funcionalidades
##Casos
- Cadastrar caso
- Alterar caso
- Excluir caso
- Listar casos

##Suspeitos
- Cadastrar suspeito
- Alterar suspeito
- Excluir suspeito
- Listar suspeitos

##Investigadores
- Cadastrar investigador
- Alterar investigador
- Excluir investigador
- Listar investigadores

##Pistas
- Cadastrar pista
- Alterar pista
- Excluir pista
- Listar pistas

##Interrogatórios
- Registrar interrogatório
- Alterar interrogatório
- Excluir interrogatório
- Listar interrogatórios


#Conceitos Aplicados
#Herança

##Classe abstrata:
Pessoa

##Classes filhas:
Suspeito
Investigador
Interface

##Interface:
Investigavel

Implementada por:
Suspeito
Caso

#Polimorfismo
- Sobrescrita de métodos da classe Pessoa.
- Sobrecarga de métodos de busca e cadastro.

#Coleções
Utilização de ArrayList para armazenamento das entidades do sistema.

#Persistência
Os dados são gravados em arquivos para evitar perda de informações ao encerrar a aplicação.

#Tratamento de Exceções
Utilização de blocos try-catch para validações e manipulação de erros.

#Estrutura do Projeto
src/
├── model/
├── controller/
├── view/
├── persistence/
├── interfaces/
└── Main.java

#Relacionamentos
##Associação
Investigador ↔ Caso

##Agregação
Caso ↔ Suspeito

##Composição
Caso ↔ Pista

#Responsabilidades da Equipe
Integrante                  	          Responsabilidade
Julia Soares Catharino      	          CRUD de Suspeitos, classe Suspeito, persistência de suspeitos
Sarah De Moura Silva                    CRUD de Investigadores, classe Investigador, classe abstrata Pessoa
Maria Luiza Barcelos Mendes            	CRUD de Casos, relacionamentos entre casos, suspeitos e investigadores
Maria Luiza Cordeiro Lisboa             CRUD de Pistas, composição entre Caso e Pista, persistência de pistas
Érica Gonçalves Domingos Do Nascimento  CRUD de Interrogatórios, interface Investigavel, menu principal e integração do sistema


## Utilização de Inteligência Artificial
Durante o desenvolvimento deste projeto, ferramentas de Inteligência Artificial foram utilizadas como apoio ao processo de aprendizagem e organização da equipe.
A IA foi utilizada principalmente para:

- Verificação dos requisitos do trabalho, garantindo que o projeto contemplasse conceitos como MVC, herança, interfaces, polimorfismo, persistência de dados, tratamento de exceções e CRUDs.
- Auxílio na definição da arquitetura do sistema e na organização dos pacotes.
- Sugestões para modelagem das classes e relacionamentos entre os objetos.
- Divisão equilibrada das tarefas entre os integrantes, permitindo que todos participassem de forma semelhante do desenvolvimento e compreendessem os conceitos aplicados.
- Esclarecimento de dúvidas sobre conceitos de Programação Orientada a Objetos, Java e boas práticas de programação.
- Revisão de trechos de código para identificação de possíveis erros e oportunidades de melhoria.
- Apoio na elaboração da documentação do projeto e organização do repositório GitHub.

A implementação final, as decisões de desenvolvimento, os testes e a integração das funcionalidades foram realizados pelos integrantes da equipe, utilizando a IA apenas como ferramenta de apoio ao aprendizado, planejamento e validação dos requisitos do projeto.

#Como Executar
- Clone o repositório.
- Abra o projeto no IntelliJ IDEA ou VS Code.
- Execute a classe Main.java.
- Utilize o menu principal para acessar as funcionalidades.

#Tecnologias Utilizadas
- Java
- Git
- GitHub
- Programação Orientada a Objetos
- MVC
- Repositório

##Link do GitHub:

(Adicionar link após criação do repositório)

##Observações
Este projeto foi desenvolvido para fins acadêmicos como requisito avaliativo da disciplina de Desenvolvimento de Software.
