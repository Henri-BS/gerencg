# Gerencg

O projeto Gerencg é um sistema para o gerenciamento de estoque destinado controlar fluxos de mercadorias,
entradas, saídas, despesas e rendimento. O sistema dispõe de uma estrutura organizacional baseada em categorias, onde
cada produto catalogado oferece suas informações individuais, assim como, entrega estatistíticas gerais através das categorias e dos pedidos de produtos.

---
### Produtos


- #### listagem e busca

  Os produtos estão organizados através de uma listagem paginada, a lista indica a quantidadte total de produtos 
  catalogados, também possível consultar um produto filtrando a sua descrição e os elementos correspondentes a descrição 
  do produto irá reorganizada na página seguindo a ordem pela filtragem.

![Lista de Produtos](https://github.com/Henri-BS/gerencg/blob/main/images/prod_list.jpeg)

***
- #### adição de um novo produto

  Novos produtos podem ser adicionados facilmente atravésda barra de navegação no topo da página, para inserir um novo 
  produto basta clicar no primeiro botão da barra de navegação e logo um pop-up irá surgir contendo um formulário com as 
  informações correspondentes ao produto, após preencher e salvar os dados o novo produto estará disponível para ser 
  acessado na lista, o mesmo processi pode ser feito para a adição de outros conteúdos.

  ![Adição de Produtos](https://github.com/Henri-BS/gerencg/blob/main/images/product_add.jpeg)

***
- ##### perfil do produto
  
  Ao selecionar um produto na lista é possível visualizar o perfil contendo as atuais informações do produto sendo elas: 
  descrição, preço, quantidade, valor e unidade de medida e a categoria. Também está presente alguns dados estatíticos 
  sobre quantidade por data de atualização. Barra superior disponibiliza as opções de atualizar, deletar ou notificar um produto.

 ![Perfil do Produto](https://github.com/Henri-BS/gerencg/blob/main/images/prod_profile.jpeg)
--- 


### Categorias
- ##### lista de categorias
  As categorias são uma forma de agrupar produtos de um determinado gênero, 
  na lista de categorias é possívl acessar cada uma delas e uma categoria é compostas uma lista de produtos relacionaddos e 
  estatíticas gerais sobre estes produtos.

![Lista de Categorias](https://github.com/Henri-BS/gerencg/blob/main/images/categ_list.jpeg)

***
- ##### perfil da categoria 
  No perfil da categoria é possível ter acessar uma lista paginada de produtos relacionados a categoria, 
  bem como informações sobre a quantidade total dos tipos de produtos e a quantidade de registros estatísticos da categoria.

![Perfil da Categoria](https://github.com/Henri-BS/gerencg/blob/main/images/categ_profile.jpeg)

***
- ##### estatísticas das categorias
  Na parte inferior da página de estatísticas é possível acompanhar os dados estatísticos das categorias, 
  estas informaçãos estão relacionadas com os pedidos de produtos, 
  os gráficos apresentam a expectativa de renda e também a soma total das unidades de produtos em cada categoria.

![Estatísticas das Categorias](https://github.com/Henri-BS/gerencg/blob/main/images/categ_stats.jpeg)

***

### Pedidos
- ##### lista de pedidos
  Os pedidos são as encomendas de produtos para o estoque, na listagem de pedidos é possível buscar por um pedido através do seu código,
  ver a quantidade atual de pedidos e obter imformações sobre a data, a distribuidora e a principal categoria de produtos do pedido. 
  Aléum disso, é possível filtrar os pedidos através barra de tags selecionando uma tag específica.

![Lista de Pedidos](https://github.com/Henri-BS/gerencg/blob/main/images/order_list.jpeg)

***
- ##### perfil do pedido 
  O perfil do pedido contém as informações de identificação do pedido que são: o código, data, a distribuidora, tags 
  e támbem oferece informações sobre os valores totais presentes no pedido como: valor total dos produtos, quantidade total dos items, 
  tipo de pacote, quantidade total de pacotes, quantidade total em unidades dos items e categoria. A lista de items relacionada aos produtos 
  pode ser acessada na parte inferior da página, através dela é possível acompanhar os valores específicos de cada item, é possível adicionar novos items 
  ao pedido através do botão de adição na parte superior da lista de items.
  
![Perfil da Pedido](https://github.com/Henri-BS/gerencg/blob/main/images/order_profile.jpeg)

***

- ##### estatísticas totais dos pedidos
  A parte inicial da página de estatísticas contém as informações estatísticas do pedidos, 
  pode-se visualizar a quantidade de pedidos feitos, a quantidade total de items dos pedidos,
  a quantidade total da despesas com os pedidos e a maior despesa já feita em um pedido.
  Além disso as esttatíticas apresentam gráficos com o custo total de pedidos por mês e a quantidade de pedidos por mês
  
![Estatísticas das Pedido](https://github.com/Henri-BS/gerencg/blob/main/images/order_stats.jpeg)

***

- ##### estatísticas dos pedidos por mês
  O usuário também poderá visualizar as informações individuais de cada mês através da lista na barra de datas da página de estatísticas, 
  o perfil da data informa a data inicial, a data final, o total de pedidos feitos no mês, o total de items recebidos no mês, 
  o total de despesas do mês e a média semanal de despesas. A página també exibe os gráficos sobre os pedidos com maior custo e os
  pedidos com maior quantidade de items
  
![Estatísticas das Pedido por data](https://github.com/Henri-BS/gerencg/blob/main/images/order_stats_by_date.jpeg)

***
