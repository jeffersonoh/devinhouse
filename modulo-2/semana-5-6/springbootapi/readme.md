# Show me the code !!!



## 1. Intrudução a API REST

### Um breve histórico das APIs 

As APIs surgiram nos primeiros dias da computação, muito antes do computador pessoal. Naquela época, elas eram normalmente usadas como bibliotecas para sistemas operacionais. Embora a API enviasse mensagens entre mainframes em alguns momentos, ela era quase sempre local para os sistemas em que operava. Depois de quase 30 anos, as APIs se expandiram para além dos ambientes locais. No início dos anos 2000, elas estavam se tornando uma tecnologia importante para a integração remota de dados.

### O que é uma API

Uma interface de programação de aplicações (API) é um conjunto de definições e protocolos para criar e integrar softwares de aplicações. As APIs são referidas como um contrato entre um provedor e um usuário de informações, estabelecendo o conteúdo exigido pelo consumidor (a chamada) e o conteúdo exigido pelo produtor (a resposta).

Por exemplo, uma API de um serviço meteorológico pode especificar que o usuário forneça um CEP e o produtor responda em duas partes, a primeira contendo a temperatura mais elevada e a segunda com a temperatura mais baixa.   

![](./images/api-graphic.png)

Por exemplo, imagine uma empresa distribuidora de livros. Essa distribuidora de livros *poderia* oferecer aos clientes uma aplicação em que os atendentes de uma livraria pudessem verificar a disponibilidade de um título diretamente com a distribuidora. Essa aplicação poderia ser cara de desenvolver, limitada pela plataforma e exigiria longos períodos de desenvolvimento e manutenção contínua.

Como alternativa, a distribuidora, poderia fornecer uma API para verificar a disponibilidade no estoque. Essa abordagem proporciona vários benefícios, incluindo:

- O acesso aos dados por meio de uma API ajuda os clientes a consolidarem informações sobre seu inventário em um único local.
- A distribuidora de livros pode fazer alterações nos sistemas internos sem causar impacto nos clientes, contanto que o comportamento da API não mude.
- Com uma API disponibilizada publicamente, os desenvolvedores que trabalham para a distribuidora de livros, os vendedores ou terceiros poderiam desenvolver uma aplicação para ajudar os clientes a encontrar os livros que procuram. Isso poderia resultar no aumento das vendas ou outras oportunidades de negócios.

Para resumir, com as APIs, você libera o acesso aos seus recursos sem abrir mão da segurança e do controle. É você quem determina como isso será feito e quem terá acesso. A segurança das APIs dependem de um bom gerenciamento. É possível conectar APIs, bem como criar aplicações que fazem uso dos dados ou funcionalidades disponibilizadas por elas, usando uma plataforma de integração distribuída que ligue todos os elementos, incluindo sistemas legados e dispositivos de Internet das Coisas (IoT).

Existem três abordagens para políticas de lançamento de APIs.

#### **1. API Privada**

A API é usada apenas internamente. Isso oferece às empresas um maior controle .

#### **2. API de Parceiros**

A API é compartilhada com parceiros de negócios específicos. Isso pode fornecer fluxos de receita adicionais sem comprometer a qualidade.

#### **3. API Pública**

A API é disponibilizada para todos. Terceiros podem desenvolver aplicações que interajam com a sua API e isso pode se tornar uma fonte de inovação.

## REST

REST é um acrônimo em inglês que significa **R**(epresentational)  **S**(tate) **T**(ransfer). APIs web que adotam as restrições de arquitetura REST são chamadas de APIs **RESTful**.

REST é um estilo de arquitetura. Isso significa que não há um padrão oficial para APIs RESTful web. Conforme definido na dissertação de Roy Fielding [“Architectural Styles and the Design of Network-based Software Architectures”](https://www.ics.uci.edu/~fielding/pubs/dissertation/rest_arch_style.htm), as APIs serão consideradas RESTful se estiverem em conformidade com seis restrições de arquitetura:

- **Arquitetura cliente-servidor:** a arquitetura REST é composta por clientes, servidores e recursos. Ela lida com as solicitações via HTTP.
- **Sem monitoração de estado:** nenhum conteúdo do cliente é armazenado no servidor entre as solicitações. Em vez disso, as informações sobre o estado da sessão são mantidas com o cliente.
- **Capacidade de cache:** o armazenamento em cache pode eliminar a necessidade de algumas interações entre o cliente e o servidor.
- **Sistema em camadas:** as interações entre cliente e servidor podem ser mediadas por camadas adicionais. Essas camadas podem oferecer recursos extras, como balanceamento de carga, caches compartilhados ou segurança.
- **Código sob demanda (opcional):** os servidores podem ampliar a funcionalidade de um cliente por meio da transferência de códigos executáveis.
- **Interface uniforme:** essa restrição é essencial para o design de APIs RESTful e inclui quatro vertentes:
  - **Identificação de recursos nas solicitações:** os recursos são identificados nas solicitações e separados das representações retornadas para o cliente.
  - **Manipulação de recursos por meio de representações:** os clientes recebem arquivos que representam recursos. Essas representações precisam ter informações suficientes para permitir a modificação ou exclusão.
  - **Mensagens autodescritivas:** cada mensagem retornada para um cliente contém informações suficientes para descrever como ele deve processá-las.
  - **Hipermídia como plataforma do estado das aplicações:** depois de acessar um recurso, o cliente REST pode descobrir todas as outras ações disponíveis no momento por meio de hiperlinks.

Essas restrições podem parecer excessivas, mas são muito mais simples do que um protocolo prescrito. Por isso, as APIs RESTful estão se tornando mais comuns do que as APIs SOAP.

Nos últimos anos, as especificações da [OpenAPI](https://www.openapis.org/) se tornaram o padrão na hora de definir APIs REST. A OpenAPI permite que desenvolvedores de todas as linguagens criem interfaces de API REST compreensíveis com o mínimo de suposições.

### Entendendo uma requisição

#### O endpoint

A URL nada mais é que o caminho para fazer a requisição, porém é interessante ressaltar que ela segue a seguinte estrutura:

##### **Base URL**

Esse é o início da URL da requisição, aqui você basicamente falará a informação de domínio que se repete em qualquer requisição. Por exemplo:

* **https://api.minhagastronomia.com**

##### **Resource ou Path**

O recurso é o tipo de informação que você está buscando, ou seja, vamos simular que estamos buscando saber sobre vinhos, então acrescentamos o recurso vinhos:

* **https://api.minhagastronomia.com/vinhos**

##### **Query String**

A query string são os parâmetros daquela requisição, então, se eu quisesse saber os melhores vinhos da região sul do Brasil, eu incluiria esses parâmetros ?pais=brasil&regiao=sul e nossa URL ficaria assim:

* **https://api.minhagastronomia.com/vinhos?pais=brasil&regiao=sul**

Como podem ver acima, por se tratar de parâmetros da URL você usa a “?” e caso

queira utilizar mais de um parâmetro você utiliza o “&”.

Observação: A Query String não é somente utilizada para filtros, ela pode ser utilizada como parâmetros de paginação, versionamento, ordenação e muito mais.

#### **Métodos (Verbos)**

O método te ajuda a informar o tipo de ação que você está fazendo naquela requisição. Dentre os principais métodos, temos:

![](./images/metodos.png)

#### Headers

Headers ou cabeçalhos permitem que você envie informações adicionais na requisição. Ele pode ser utilizado para inúmeras funções, como: autenticação, formatação de objeto, e muito mais.
Para utilizá-lo é simples você coloca a propriedade, seguido dois pontos e o valor, tudo entre aspas, exemplo:

```shell
"Authorization: token123242343534"
```

#### **Body**

O body é o corpo da mensagem que você quer enviar na requisição. Ele é utilizado somente nos métodos de POST, PUT, PATCH, ou seja, ele contém o dado a ser processado pela API, e por isso ele não é necessário em métodos de leitura de dados.

#### **HTTP Status Codes**

Para facilitar o entendimento das respostas das APIs existem padrões de códigos de status que podem ser utilizados.

Os códigos mais utilizados para as respostas de uma requisição são o 200 (OK), o 201 (created), o 204 (no content), o 404 (not found), o 400 (bad request), e 500 (internal server error).

Como padrão, os códigos de sucesso tem o prefixo 20x, os de redirecionamento 30x, os de erro do cliente 40x e os de erro de servidor 50x.

Se quiser entender ainda mais sobre os requests, recomendo olhar uma API de testes para você conseguir “brincar” com algumas chamadas, como por exemplo os:

* https://reqres.in
* https://docs.github.com/pt/rest
* https://developer.twitter.com/en/docs/twitter-api
* https://stripe.com/docs/api