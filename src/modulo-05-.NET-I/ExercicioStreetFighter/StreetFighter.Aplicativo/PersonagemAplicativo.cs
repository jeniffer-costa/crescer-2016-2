﻿using StreetFighter.Dominio;
using StreetFighter.Repositorio;
using StreetFighter.RepositorioFramework;
using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.Aplicativo
{
    public class PersonagemAplicativo
    {
        private readonly PersonagemRepositorio repositorio;
        

        public PersonagemAplicativo()
        {
            this.repositorio = new PersonagemRepositorio();
        }

        public Personagem BuscarPorId(int id)
        {
            return this.repositorio.BuscarPorId(id);
        }

        public Personagem BuscarPorIdSQL(int id)
        {
            return this.repositorio.BuscarPorIdSQL(id);
        }

        public Personagem BuscarPorIdEF(int id)
        {
            PersonagemRepositorioEF personagemRepositorioEF = new PersonagemRepositorioEF();
            return personagemRepositorioEF.BuscarPorIdEF(id);
        }
        public void Editar(Personagem personagem)
        {
            this.repositorio.EditarPersonagemSQL(personagem);
        }

        public void EditarEF(Personagem personagem)
        {
            PersonagemRepositorioEF personagemRepositorioEF = new PersonagemRepositorioEF();
            personagemRepositorioEF.EditarPersonagemEF(personagem);
        }
        public void Excluir(Personagem personagem)
        {
            this.repositorio.ExcluirPersonagem(personagem);
        }

        public void ExcluirSQL(int id)
        {
            this.repositorio.ExcluirPersonagemSQL(id);
        }

        public void ExcluirEF(Personagem personagem)
        {
            PersonagemRepositorioEF personagemRepositorioEF = new PersonagemRepositorioEF();
            personagemRepositorioEF.ExcluirPersonagemEF(personagem);
        }

        public List<Personagem> ListarPersonagens(string filtro = null)
        {
            return repositorio.ListarPersonagens(filtro);
        }

        public List<Personagem> ListarPersonagensSQL(string filtro = null)
        {
            return repositorio.ListarPersonagensSQL(filtro);
        }

        public List<Personagem> ListarPersonagensEF(string filtroNome)
        {
            PersonagemRepositorioEF personagemRepositorioEF = new PersonagemRepositorioEF();
            return personagemRepositorioEF.ListarPersonagensEF(filtroNome);
        }

        public void Salvar(Personagem personagem)
        {
            if (personagem.Id == 0)
                repositorio.AdicionarPersonagem(personagem);
            else
                Console.WriteLine("Editar");
        }

        public void SalvarEF(Personagem personagem)
        {
            PersonagemRepositorioEF personagemRepositorioEF = new PersonagemRepositorioEF();
            personagemRepositorioEF.AdicionarPersonagemEF(personagem);       
        }

        public void SalvarSQL(Personagem personagem)
        {
            if (personagem.Id == 0)
                repositorio.AdicionarPersonagemSQL(personagem);
            else
                repositorio.EditarPersonagemSQL(personagem);
        }
    }
}
