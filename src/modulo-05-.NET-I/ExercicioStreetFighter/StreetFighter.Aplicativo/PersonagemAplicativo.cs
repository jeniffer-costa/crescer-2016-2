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

        public List<Personagem> ListarPersonagens(string Filtro)
        {
            throw new NotImplementedException();
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
