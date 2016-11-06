using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        public int Id { get; set; }
        public string Imagem { get; private set; }
        public string Nome { get; private set; }
        public string Origem { get; private set; }
        public DateTime DataNascimento { get; private set; }
        public int Altura { get; set; }
        public decimal Peso { get; set; }
        public string GolpesEspeciais { get; set; }
        public bool PersonagemOculto { get; set; }

        public Personagem(int id,string nome, string imagem, string origem, DateTime dataNascimento, int altura, decimal peso, string golpesEspeciais,bool personagemOculto)
        {
            this.Id = id;
            this.Nome = nome;
            this.Imagem = imagem;
            this.Origem = origem;
            this.DataNascimento = dataNascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
        }

        public override string ToString()
        {
            return $"{Id}; {Nome}; {DataNascimento}; {Altura}; {Peso}; {Origem}; {Imagem}; {PersonagemOculto}";
        }
    }
}
