--1) Faça uma consulta que liste os empregados admitidos entre 01/05/1980 e 20/01/1982. Exibir também o total de
--meses de trabalho até a data de 31/12/2000.
Select nomeEmpregado, DATEDIFF(Month,DataAdmissao,GETDATE()) MesesTrabalhados
from empregado
where dataAdmissao between '1980-05-01' and '1982-01-20';

--2) Qual o cargo (tabela empregado) tem mais empregados?
SELECT TOP 1 cargo as 'Cargo com maior numero de empregados'
FROM empregado
group by cargo
order by count(nomeEmpregado) desc

--3) Liste a quantidade de cidades agrupando por UF – quantas cidades cada estado possuí ?
select uf,count(*) as QuantidadeCidades
from cidade
group by uf
--4) Liste as cidades que possuem o mesmo nome e UF – cidades duplicadas.

--5) Identifique qual deve ser o próximo ID para a criação de um novo registro na tabela Associado (maior + 1).
select MAX(IDAssociado)+1 as ProximoID
from associado

--6) Faça uma consulta que mostre o nome do empregado, o Salario e percentual a ser descontado do Imposto de
--Renda, considerando a tabela abaixo: --Até R$ 1.164,00 = 0% De R$ 1.164,00 a R$ 2.326,00 = 15%
--Acima de R$ 2.326,00 = 27,5%.
SELECT nomeEmpregado,Salario,
         CASE
            WHEN Salario < 1164 THEN '0%'
			WHEN Salario > 1164 and Salario <= 2326 THEN '15%'
            WHEN Salario > 2326 THEN '27.5%'
			end as '% IR'
  FROM empregado;

-- 7) Liste o nome do empregado, o nome do gerente, e o departamento de cada um.
select emp.NomeEmpregado,
       ger.NomeEmpregado as NomeGerente,
       dep.NomeDepartamento as DepartamentoEmpregado,
	   deg.NomeDepartamento as DepartamentoGerente
from Empregado emp 
inner join Empregado ger on emp.idgerente = ger.idempregado
inner join Departamento dep on emp.IDDepartamento = dep.IDDepartamento
inner join Departamento deg on ger.IDDepartamento = deg.IDDepartamento 

--8) Faça uma cópia da tabela Empregado e altere o salário de todos os empregados (Empregado) que o
--departamento fique na localidade de SAO PAULO, faça um reajuste de 14,5%
select * 
into EmpregadoAux 
from Empregado

begin tran
Update Empregado
set    Salario = Salario * 1.145
where  exists (select 1
               from   departamento
			   where  departamento.IDDepartamento = Empregado.IDDepartamento
			   and    departamento.Localizacao    = 'Sao Paulo');

--9) Liste a diferença que representará o reajuste aplicado no item anterior no somatório dos salários de todos
--os empregados.

select SUM(e.salario - a.Salario) as diferença
from Empregado e inner join EmpregadoAux a 
on e.idempregado = a.idempregado

--10)Liste o departamento com o empregado de maior salário

select top 1 d.NomeDepartamento
from Departamento d inner join Empregado e 
on e.IDDepartamento = d.IDDepartamento
group by d.NomeDepartamento
order by MAX(e.Salario) desc
