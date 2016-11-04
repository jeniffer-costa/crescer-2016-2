using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class FichaTecnicaModel
    {
        public string Imagem { get; set; }
        public String Nome { get; set; }
        public DateTime DataNascimento { get; set; }
        public int Altura { get; set; }
        public decimal Peso { get; set; }
        public String Origem { get; set; }
        public String GolpesEspeciais { get; set; }
        [DisplayName("Personagem Oculto")]
        public bool PersonagemOculto { get; set; }

        
    }
}