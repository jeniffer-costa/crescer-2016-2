--1) Liste o total de pedidos realizados no m�s de setembro de 2016.

select count(1) as TotalPedido
from Pedido
where DataPedido between convert(datetime, '01/09/2016', 103) 
                     and convert(datetime, '30/09/2016', 103)+.99999

-- 2) Liste quais os produtos que utilizam o material de IDMaterial = 15836.

select *
from Produto p
where Exists(select *
              from ProdutoMaterial m 
			  where p.IDProduto = m.IDProduto
              and m.IDMaterial = 15836)

-- 3) Liste todos os clientes que tenham o LTDA no nome ou razao social.

select Nome,RazaoSocial
from Cliente
where RazaoSocial like '%LTDA%' 
or Nome like '%LTDA%'

--4) Crie (insira) um novo registro na tabela de Produto, com as seguintes informa��es:
--Nome: Galocha Maragato
--Pre�o de custo: 35.67
--Pre�o de venda: 77.95
--Situa��o: A
insert into Produto (Nome,DataCadastro,PrecoCusto,PrecoVenda,Situacao) values ('Galocha Maragato',GETDATE(),35.67,77.95,'A');

--5) Identifique e liste os produtos que n�o tiveram nenhum pedido, considere os relacionamentos no modelo de
--dados, pois n�o h� relacionamento direto entre Produto e Pedido (ser� preciso relacionar PedidoItem).
-- Obs.: o produto criado anteriormente dever� ser listado (apenas este)
select * 
from Produto p left join PedidoItem i
on p.IDProduto = i.IDProduto
where i.IDProduto is null

select idproduto,nome
from produto pro
where not exists(select 1
                 from PedidoItem item
				 where pro.IDProduto = item.IDProduto)

--6) Identifique qual o estado (coluna UF da tabela Cidade) possu� o maior n�mero de clientes (tabela Cliente), liste
--tamb�m qual o Estado possu� o menor n�mero de clientes.
select uf, COUNT(*) as MaiorNumeroClientes
from Cidade cid inner join Cliente cli on cid.IDCidade = cli.IDCidade
group by uf
order by MaiorNumeroClientes desc

select uf, COUNT(*) as Menor
from Cidade cid inner join Cliente cli on cid.IDCidade = cli.IDCidade
group by uf
order by Menor asc

--7) Alguns materiais est�o em falta no estoque, com isso alguns pedidos sofrer�o atraso na entrega. Abaixo mais
--informa��es:
--a. A lista de materiais que est�o em falta, s�o os seguintes:
--IDMaterial Descricao
--14650 Frente de caixa #14650
--15703 Sistema de rastreabilidade #15703
--15836 Intranet #15836
--16003 Controle de permiss�es #16003
--16604 Frente de caixa #16604
--17226 Frente de caixa #17226

--b. Liste os pedidos com produtos que precisam destes materiais, considere somente os pedidos que ser�o
--entregues em outubro de 2016.
--i. Campos que devem ser exibidos: IDPedido, DataEntrega, ValorPedido, Quantidade de itens
--c. Liste tamb�m os clientes destes pedidos, pois estes ser�o notificados pela �rea respons�vel.
select * from ProdutoMaterial
where IDMaterial = 14650
--1201, 1911, 2773

select * from Pedido
select p.IDPedido,p.DataEntrega,p.ValorPedido,i.Quantidade,p.IDCliente
from Pedido p inner join PedidoItem i on p.IDPedido = i.IDPedido
              Inner join ProdutoMaterial pm on pm.IDProduto = i.IDProduto
			  where p.DataEntrega between convert(datetime, '01/10/2016', 103) and convert(datetime, '31/10/2016', 103) 
			  and pm.IDMaterial in (14650,15703,15836,16003,16604,17226)

--8) Dentro da atual estrutura, cada produto � composto por 1 ou v�rios materiais (tabela ProdutoMaterial).
--Identifique se existe algum produto sem material relacionado.
select * 
from Produto pro left join ProdutoMaterial pm
on pro.IDProduto = pm.IDProduto
where pm.IDProduto is null

--9) Lista qual o primeiro nome mais popular entre os clientes, considere apenas o primeiro nome.
SELECT TOP 1 SUBSTRING(nome,1,(CHARINDEX(' ',nome+' '))) as PrimeiroNome,count(*) quantidadeDeClientesComEsseNome
FROM cliente
group by SUBSTRING(nome,1,(CHARINDEX(' ',nome+' ')))
having count(*) > 1 
order by quantidadeDeClientesComEsseNome desc

--10) Atualize a situa��o na tabela de Produto, considere as seguintes condi��es:
--Valor Condi��o
--F Produtos que est�o com materiais em falta no estoque conforme a lista na tabela 7.a
--A Todos os demais registros.
begin tran
update Produto 
set Situacao = 'F'
where IDProduto in (select pm.IDProduto from ProdutoMaterial pm
where pm.IDMaterial in (14650,15703,15836,16003,16604,17226))

--Q Produtos que n�o est�o em falta, por�m que est�o sem pedidos nos �ltimos 2 meses.


select * from Pedido
select * from PedidoItem

select distinct p.IDProduto,Nome,pro.DataPedido,pm.Quantidade
from ProdutoMaterial pm inner join PedidoItem i on pm.IDProduto = i.IDProduto
                        inner join Produto p on p.IDProduto = pm.IDProduto
						inner join Pedido pro on pro.IDPedido = i.IDPedido
where pm.Quantidade > 0
and pro.DataPedido between convert(datetime, '01/08/2016', 103) and convert(datetime, '17/10/2016', 103)

select * from Produto
where IDProduto in (6300,1201,217,3192,3165,5962)