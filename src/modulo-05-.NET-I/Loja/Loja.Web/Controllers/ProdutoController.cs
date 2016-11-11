using Loja.Dominio;
using Loja.Web.Models;
using Loja.Web.Servicos;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Loja.Web.Controllers
{
    public class ProdutoController : Controller
    {
        public ActionResult Produto(string filtro)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
            List<Produto> produtos = produtoServico.Listar(filtro);

            if (produtos.Count != 0)
            {
                return View(produtos);
            }

            ViewBag.ListaVazia = "Não há produtos cadastrados...";
            return View("Produto");
        }

        public ActionResult Salvar(ProdutoModel model)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();

            Produto produto = new Produto(
                                        model.Id == null ? 0 : (int)model.Id,
                                        model.Nome,
                                        model.Valor);
            if (produto.Id == 0)
            {
                ViewBag.Mensagem = "Produto cadastrado com sucesso!";
            }
            else
            {
                ViewBag.Mensagem = "Produto editado com sucesso!";
            }
            produtoServico.Salvar(produto);
            return RedirectToAction("Produto");
        }

        public ActionResult Cadastro(ProdutoModel model)
        {
            return View();
        }

        public ActionResult Editar(int id)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
            var produto = produtoServico.BuscarPorId(id);
            var model = new ProdutoModel()
            {
                Id = produto.Id,
                Nome = produto.Nome,
                Valor = produto.Valor
            };
            return View("Cadastro", model);
        }

        public ActionResult Excluir(int id)
        {
            ProdutoServico produtoServico = ServicoDeDependencias.MontarProdutoServico();
            var produto = produtoServico.Listar(null).Where(p => p.Id == id).ToList().ElementAt(0);
            produtoServico.Excluir(produto);

            return RedirectToAction("Produto");
        }
    }
}