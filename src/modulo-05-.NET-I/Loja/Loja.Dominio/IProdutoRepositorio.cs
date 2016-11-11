using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loja.Dominio
{
    public interface IProdutoRepositorio
    {
        void Salvar(Produto produto);
        void Editar(Produto produto);
        List<Produto> Listar(string filtro);
    }
}
