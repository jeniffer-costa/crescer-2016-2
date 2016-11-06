using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Text.RegularExpressions;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class PersonagemRepositorio
    {
        public List<Personagem> Personagens { get; private set; } = new List<Personagem>();
        const string CaminhoArquivo = @"C:\Users\diiego\Documents\Visual Studio 2015\Projects\StreetFighter.Web\StreetFighter.Repositorio\BaseDeDados\ListaDePersonagens.csv";

        public PersonagemRepositorio()
        {
 
        }

        public void AdicionarPersonagem(Personagem personagem)
        {
            var UltimoID = File.ReadAllLines(CaminhoArquivo).Length +1;
            personagem.Id = UltimoID;

            File.AppendAllText(CaminhoArquivo, Environment.NewLine + personagem.ToString());

        }

        public List<Personagem> ListarPersonagens(string filtroNome)
        {
            throw new NotImplementedException();
        }
    }
}
