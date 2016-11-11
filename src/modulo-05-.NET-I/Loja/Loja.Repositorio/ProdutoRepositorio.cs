using Loja.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Repositorio
{
    public class ProdutoRepositorio : IProdutoRepositorio
    {
        public void Salvar(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                if (produto.Id == 0)
                {
                    context.Entry<Produto>(produto).State = EntityState.Added;
                }
                else
                {
                    context.Entry<Produto>(produto).State = EntityState.Modified;
                }
                context.SaveChanges();
            }
        }

        public void Editar(Produto produto)
        {
            using (var context = new ContextoDeDados())
            {
                if (produto.Id != 0)
                {
                    context.Entry<Produto>(produto).State = EntityState.Modified;
                }
                context.SaveChanges();
            }
        }

        public List<Produto> Listar(string filtro)
        {
            using (var context = new ContextoDeDados())
            {
                var produtos = context.Produto;

                if (!String.IsNullOrEmpty(filtro))
                {
                    return produtos.Where(per => per.Nome.Contains(filtro)).ToList();

                }
                else
                {
                    return produtos.ToList();
                }
            }
        }

        public Produto BuscarPorId(int id)
        {
            using (var context = new ContextoDeDados())
            {
                Produto produto = context.Produto.Find(id);
                return produto;
            }
        }
    }
}
