#Author: refaelaugsuto.paiva@e2etreinamentos.com.br

@regressivos
Feature: User List API Test
  Como usuario
  Quero acessar o servico List User da API
  Para realizar a consulta e validacao do retorno da lista de usuarios
  
  Background: acessar servico
  Given que acesso a baseURL "https://reqres.in"
  
  @statusCodeLT
  Scenario: Validar Status Code
    When envio uma request GET para <page>
    Then valido o status code esperado 200
		
    
  @atributosLT
  Scenario Outline: Validar atributos de usuario List Users
    When envio uma request GET para <page>
    Then valido os atributos esperados <posicao> <id>, <email>, <first_name>, <last_name>
    
     Examples: 
  | page  | posicao |  id  |            email             | first_name  |  last_name  |
  |   2   |    0    |  7   |  "michael.lawson@reqres.in"  |  "Michael"  |   "Lawson"  |
  |   2   |    1    |  8   | "lindsay.ferguson@reqres.in" |  "Lindsay"  |  "Ferguson" |
  |   2   |    2    |  9   |   "tobias.funke@reqres.in"   |  "Tobias"   |    "Funke"  |
  |   2   |    3    |  10  |   "byron.fields@reqres.in"   |   "Byron"   |    "Fields" |
  |   1   |    0    |  1   |   "george.bluth@reqres.in"   |  "George"   |    "Bluth"  |