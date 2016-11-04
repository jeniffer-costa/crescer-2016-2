using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Dominio
{
    public class Personagem
    {
        private string personagem;

        public int Id { get; private set; }
        public string Nome { get; private set; }
        public string Origem { get; private set; }
        public DateTime DataNascimento { get; private set; }
        public int Altura { get; set; }
        public decimal Peso { get; set; }
        public string GolpesEspeciais { get; set; }
        public bool PersonagemOculto { get; set; }

        public Personagem(int id, string nome, string origem, DateTime dataNascimento, int altura, decimal peso, string golpesEspeciais, bool personagemOculto)
            : this(nome, origem, dataNascimento, altura, peso, golpesEspeciais, personagemOculto)
        {
            this.Id = id;
        }

        public Personagem(string nome, string origem, DateTime dataNascimento, int altura, decimal peso, string golpesEspeciais,bool personagemOculto)
        {
            this.Nome = nome;
            this.Origem = origem;
            this.DataNascimento = dataNascimento;
            this.Peso = peso;
            this.GolpesEspeciais = golpesEspeciais;
            this.PersonagemOculto = personagemOculto;
        }
    }
}
