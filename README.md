Projeto em andamento de api de vagas.


Desenvolvido em JAVA Spring + SGBD PostgreSQL.


Utilize o comando docker up para subir um conteiner via docker. o docker composer ira subir um conteiner com aplicação e outro para o banco de dados.


END POINTS DA API>:

CRIAR CANDIDATO
METODO: POST
URL: localhost:8080/candidatos/create

BODY: {
    "nome" : "Allan",
    "username" : "allkardec4",
    "email" : "allan4@live.com",
    "password" : "123456",
    "descricao" : "abc123",
    "curriculum" : "a654faga",
    "createdAt" : "2025-10-06T14:40:12.233700"
}

LISTAR TODOS OS CANDIDATOS
METODO: GET
URL: localhost:8080/candidatos/all


VER DADOS DE UM CANDIDATO
METODO: GET
URL: localhost:8080/candidatos/f96e12ee-a5b3-45e4-9cbe-6147f867d5ce

OBS: passar uuid apos /candidatos/*********
