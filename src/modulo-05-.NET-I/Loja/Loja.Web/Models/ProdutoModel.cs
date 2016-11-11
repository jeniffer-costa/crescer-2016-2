using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Loja.Web.Models
{
    public class ProdutoModel
    {
        public ProdutoModel()
        {

        }
        private List<Produto> ListaProdutos { get; set; }
        public int Id { get; set; }
        public string Nome { get; set; }
        public decimal Valor { get; set; }

        public ProdutoModel(List<Produto> ListaProdutos)
        {
            this.ListaProdutos = ListaProdutos;
        }
    }
}