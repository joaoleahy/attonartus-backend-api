# Avaliação Desenvolvedor Back-end Attornatus

O objetivo deste documento é identificar seus conhecimentos quanto às tecnologias utilizadas no cotidiano de desenvolvimento da equipe de Back-end na Attornatus Procuradoria Digital.

Esta análise propõe avaliar os seguintes temas: 

- Qualidade de código
- Java, Spring boot
- API REST
- Testes


## Qualidade de código

  Durante a implementação de uma nova funcionalidade de software solicitada, quais critérios você avalia e implementa para garantia de qualidade de software?

	Existem alguns critérios que eu consideraria ao implementar uma nova funcionalidade de software para garantir a qualidade do software:

  --> Testes unitários: escrever testes unitários para garantir que cada parte do código está funcionando corretamente e isoladamente.

  --> Testes de integração: escrever testes de integração para garantir que as diferentes partes do sistema estão funcionando corretamente juntas.

  --> Manutenibilidade: escrever código legível e bem estruturado, utilizando boas práticas de programação, para facilitar a manutenção do software no futuro.

  --> Segurança: considerar aspectos de segurança ao implementar a funcionalidade, como proteção contra ataques de injeção de SQL ou outras vulnerabilidades comuns.

  --> Escalabilidade: considerar se a solução implementada é escalável e se será capaz de lidar com um aumento no volume de usuários ou dados.

  --> Usabilidade: testar a funcionalidade com usuários reais para garantir que ela é fácil de usar e intuitiva.

## Em qual etapa da implementação você considera a qualidade de software?

	Acredito que a qualidade de software é importante em praticamente todo o processo de implementação e mostro abaixo:
  
 --> Planejamento: definir os requisitos e objetivos da funcionalidade e estabelecer critérios de qualidade para garantir que a funcionalidade atenda às necessidades do usuário e seja de alta qualidade.

 --> Design: projetar a solução de forma a atender aos critérios de qualidade estabelecidos e garantir que o código será fácil de entender e manter.

 --> Implementação: escrever código de alta qualidade, seguindo boas práticas de programação, e testá-lo para garantir que está funcionando corretamente.

 --> Testes: realizar testes unitários, de integração e de aceitação para garantir a qualidade do software e identificar e corrigir quaisquer problemas.

 --> Lançamento: realizar testes adicionais e verificações antes do lançamento para garantir que o software está pronto para uso.

	
## Desafio Java

Usando Spring boot, crie uma API simples para gerenciar Pessoas. Esta API deve permitir:  

 - Criar uma pessoa
 - Editar uma pessoa
 - Consultar uma pessoa
 - Listar pessoas
 - Criar endereço para pessoa
 - Listar endereços da pessoa
 - Poder informar qual endereço é o principal da pessoa  

Uma Pessoa deve ter os seguintes campos:  
- Nome
- Data de nascimento
- Endereço:
    - Logradouro 
    - CEP
    - Número
    - Cidade

## Requisitos:
 Todas as respostas da API devem ser JSON.  
 Banco de dados H2.

## Diferencial:
	Testes.
	Clean Code.
 
## Será levado em avaliação:
 Estrutura, arquitetura e organização do projeto. 
 Boas práticas de programação.
 Alcance dos objetivos propostos.
