using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public class ProdutoServico
    {
        private IProdutoRepositorio produtoRepositorio;

        public ProdutoServico(IProdutoRepositorio produtoServico)
        {
            this.produtoRepositorio = produtoServico;
        }

        public void Salvar(Produto produto)
        {
            produtoRepositorio.Salvar(produto);
        }

        public void Editar(Produto produto)
        {
            produtoRepositorio.Editar(produto);
        }

        public List<Produto> Listar(string filtro)
        {
            return produtoRepositorio.Listar(filtro);
        }

        public Produto BuscarPorId(int id)
        {
            return produtoRepositorio.BuscarPorId(id);
        }
    }
}
