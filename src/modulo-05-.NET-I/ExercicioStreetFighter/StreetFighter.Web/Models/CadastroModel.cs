using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace StreetFighter.Web.Models
{
    public class CadastroModel
    {
        [DisplayName("URL da Imagem:")]
        public string Imagem { get; set; }

        [Required]
        [DisplayName("Nome:")]
        public string Nome { get; set; }

        [Required]
        [DisplayName("Nascimento:")]
        public string DataNascimento { get; set; }

        [Required]
        [DisplayName("Altura:")]
        public int Altura { get; set; }

        [Required]
        [DisplayName("Peso:")]
        public decimal Peso { get; set; }

        [Required]
        [DisplayName("Golpes Especiais:")]
        public string GolpesEspeciais { get; set; }


        [DisplayName("Personagem Oculto")]
        public bool PersonagemOculto { get; set; }

        [Required]
        [DisplayName("Origem:")]
        public String Origem { get; set; }
    }
}