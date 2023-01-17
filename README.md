<h1 align="center"> TESTE TÉCNICO BACK END - ATTORNATUS </h1>
<p align="center">
<img src="http://img.shields.io/static/v1?label=STATUS&message=CONCLUIDO&color=GREEN&style=for-the-badge"/>
</p>


Desafio: 

Desenvolver uma API para gerenciar Pessoas e seus Endereços, fazendo um CRUD em Java com Spring Boot,
além de utilizar o banco de dados em memória H2.
#

<h1 align="center"> 💻  Tecnologias utilizadas 💡 </h1>

* `Java`
* `Spring Boot`
* `Lombok`
* `JUnit`
* `H2 DataBase`
#

<h1 align="center"> :hammer: Funcionalidades do projeto </h1>

   Criando uma pessoa :
   
![postPessoa](https://user-images.githubusercontent.com/69120175/212985965-9fab32c8-dd90-4137-a2cb-37921240084a.png)
#
Criando um endereço e associando ele a pessoa criada, que no nosso caso tem o ID = 1, o segundo ID = 2 e assim sucessivamente :

![postEndereço](https://user-images.githubusercontent.com/69120175/212986676-8ddb73ef-e882-444a-9125-510c65435371.png)
#
Listando todas as pessoas :

![getAll](https://user-images.githubusercontent.com/69120175/212988263-8a2e32ba-f511-4dc7-90be-8209602b18f0.png)
#
Busca uma pessoa específica pelo ID :

![getById](https://user-images.githubusercontent.com/69120175/212988956-1236370f-efff-49a2-b4d4-6e97269e4111.png)
#
Atualiza os dados de um pessoa, nesse caso foi atualizado o endereço :

![putPessoa](https://user-images.githubusercontent.com/69120175/212990283-3cefcd80-39c8-4682-8897-a67e23404937.png)
#
Deleta uma pessoa, nesse exemplo foi a pessoa com ID = 1 :

![deletePessoa](https://user-images.githubusercontent.com/69120175/212991614-1c274285-825b-4038-ae87-01d2a9ac4c42.png)
#

* TAMBÉM É POSSIVEL CRIAR, LISTAR, BUSCAR PELO ID, ATUALIZAR E DELETAR OS ENDEREÇOS SEPARADAMENTE.
A APLICAÇÃO PERMITE FAZER O CRUD TANTO DE PESSOA, COMO TAMBÉM DE ENDEREÇO, BASTA MUDAR A URL. 

`http://localhost:8080/person`

`http://localhost:8080/address`
#


- `H2 DataBase`: Dados no banco de dados 

Url do banco: http://localhost:8080/h2/login.do?jsessionid=5c31549a8ba708983152127e3196f9b4 

Select de Pessoa:

![bdPessoa](https://user-images.githubusercontent.com/69120175/212996251-bb0df773-c185-45d7-827c-2857816262aa.png)
#
Select de Endereço :

![bdEndereco](https://user-images.githubusercontent.com/69120175/212996719-5c832af1-1eae-4612-89fa-f23a771a648f.png)












