using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly PersonagemRepositorio repositorio;

        public PersonagemAplicativo()
        {
            this.repositorio = new PersonagemRepositorio();
        }

        public Personagem BuscarPorId(int id)
        {
            return this.repositorio.BuscarPorId(id);
        }

        public void Editar(Personagem personagem)
        {
            this.repositorio.EditarPersonagem(personagem);
        }

        public List<Personagem> ListarPersonagens(string filtro = null)
        {
            return repositorio.ListarPersonagens(filtro);
        }

        public void Salvar(Personagem personagem)
        {
            if (personagem.Id == 0)
                repositorio.AdicionarPersonagem(personagem);
            else
                Console.WriteLine("Editar");
        }
    }
}
