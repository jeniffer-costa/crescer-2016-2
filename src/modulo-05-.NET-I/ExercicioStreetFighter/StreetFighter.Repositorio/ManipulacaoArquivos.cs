using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Repositorio
{
    public class ManipulacaoArquivos
    {
        public List<Personagem> Personagens { get; private set; } = new List<Personagem>();
        static string CaminhoArquivo = @"C:\Users\diiego\Desktop\ListaDePersonagens.txt";
    }

    public ManipulacaoArquivos()
    {
        var personagens = File.ReadAllLines(CaminhoArquivo).ToList();

        foreach (var frase in frases)
        {
            Frases.Add(new Frase(frase));
        }
    }

    public void AdicionarPersonagem(Personagem personagem)
    {
        this.Personagens.Add(personagem);
        File.AppendAllText(caminhoArquivo, Environment.NewLine + novaFrase.ToString());
    }
}
