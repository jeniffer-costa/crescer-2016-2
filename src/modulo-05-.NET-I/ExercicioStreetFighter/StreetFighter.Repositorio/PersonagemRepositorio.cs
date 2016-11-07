using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Globalization;
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
            var UltimoID = File.ReadAllLines(CaminhoArquivo).Length + 1;
            personagem.Id = UltimoID;

            File.AppendAllText(CaminhoArquivo, Environment.NewLine + personagem.ToString());

        }

        public void EditarPersonagem(Personagem personagem)
        {
            int indexDoPersonagem = this.Personagens.FindIndex(p => p.Id == personagem.Id);
            this.Personagens.RemoveAt(indexDoPersonagem);
            this.Personagens.Insert(indexDoPersonagem, personagem);
            File.WriteAllLines(CaminhoArquivo, this.Personagens.Select(p => p.ToString()));

        }

        public List<Personagem> ListarPersonagens(string filtro)
        {
            var lista = new List<Personagem>();
            var personagens = File.ReadLines(CaminhoArquivo);

            foreach (var item in personagens)
            {
                var parametros = item.Split(';');
                var ptBR = new CultureInfo("pt-BR", false).DateTimeFormat;

                var personagem = new Personagem( Convert.ToInt32(parametros[0]),
                                                parametros[1],
                                                Convert.ToDateTime(parametros[2], ptBR),
                                                Convert.ToInt32(parametros[3]),
                                                Convert.ToDecimal(parametros[4]),
                                                parametros[5],
                                                parametros[6],
                                                parametros[7],
                                                Convert.ToBoolean(parametros[8]));

                if (filtro == null || personagem.Nome.Contains(filtro))
                    lista.Add(personagem);
            }

            return lista;
        }

        public Personagem BuscarPorId(int id)
        {
            List<Personagem> personagens = this.ListarPersonagens(null);

            return personagens.Find(personagem => personagem.Id == id);
        }
    }
}
