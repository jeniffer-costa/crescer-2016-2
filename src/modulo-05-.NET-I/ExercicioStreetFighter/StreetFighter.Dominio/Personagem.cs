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
        public string Nome { get; set; }
        public DateTime DataNascimento { get; private set; }
        public int Altura { get; private set; }
        public decimal Peso { get; private set; }
        public string Origem { get; private set; }
        public string Imagem { get; private set; }
        public string GolpesEspeciais { get; private set; }
        public bool PersonagemOculto { get; private set; }

        public Personagem(int id,string nome, DateTime dataNascimento, int altura, decimal peso, string origem, string imagem, string golpesEspeciais,bool personagemOculto)
        {
            this.Id = id;
            this.Nome = nome;
            this.DataNascimento = dataNascimento;
            this.Altura = altura;
            this.Peso = peso;
            this.Origem = origem;
            this.Imagem = imagem;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
        }

        public override string ToString()
        {
            return $"{Id}; {Nome}; {DataNascimento}; {Altura}; {Peso}; {Origem}; {Imagem}; {GolpesEspeciais}; {PersonagemOculto}";
        }
    }
}
