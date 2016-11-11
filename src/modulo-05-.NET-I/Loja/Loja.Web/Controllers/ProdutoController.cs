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
                produtoServico.Salvar(produto);
                return RedirectToAction("Produto");
            }
            else
            {
                ViewBag.Mensagem = "Erro no cadastro!";
                return View("Cadastro");
            }
        }

        public ActionResult Cadastro(ProdutoModel model)
        {
            return View();
        }
    }
}