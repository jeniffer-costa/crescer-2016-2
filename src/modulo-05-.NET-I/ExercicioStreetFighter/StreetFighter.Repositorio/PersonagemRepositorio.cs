using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio
    {
        const string CaminhoArquivo = @"C:\Users\diiego\Desktop\ListaDePersonagens.txt";
        public List<Personagem> Personagens { get; private set; } = new List<Personagem>();

        public PersonagemRepositorio()
        {
            var personagens = File.ReadAllLines(CaminhoArquivo).ToList();
            foreach (var personagem in personagens)
            {
                var propriedadesPersonagem = personagem.Split(';');

                //Personagens.Add(new Personagem(personagem));
            }

        }
        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            throw new NotImplementedException();
        }
    }
}
