using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using StreetFighter.Dominio;

namespace StreetFighter.Web.Models
{
    public class PersonagemModel
    {
        private List<Personagem> ListaPersonagens { get; set; }

        public PersonagemModel(List<Personagem> listaPersonagens)
        {
            this.ListaPersonagens = listaPersonagens;
        }
    }
}