using StreetFighter.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace StreetFighter.RepositorioFramework
{
    public class PersonagemRepositorioEF
    {
        public Personagem BuscarPorIdEF(int id)
        {
            using (var context = new DatabaseContext())
            {
                Personagem personagemFound = context.Personagem.Find(id);
                return personagemFound;
            }
        }

        public List<Personagem> ListarPersonagensEF(string filtro = null)
        {
            using (var context = new DatabaseContext())
            {
                var personagens = context.Personagem;

                if (!String.IsNullOrEmpty(filtro))
                {
                    return personagens.Where(per => per.Nome.Contains(filtro)).ToList();

                }
                else
                {
                    return personagens.ToList();
                }
            }
        }

        public void AdicionarPersonagemEF(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                if (personagem.Id == 0)
                {
                    context.Entry<Personagem>(personagem).State = EntityState.Added;
                }
                else
                {
                    context.Entry<Personagem>(personagem).State = EntityState.Modified;
                }
                context.SaveChanges();
            }
        }

        public void EditarPersonagemEF(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {
                if (personagem.Id != 0)
                {
                    context.Entry<Personagem>(personagem).State = EntityState.Modified;
                }
                context.SaveChanges();
            }
        }

        public void ExcluirPersonagemEF(Personagem personagem)
        {
            using (var context = new DatabaseContext())
            {

                var personagemSelecionado = context.Personagem.Where(p => p.Id.Equals(personagem.Id)).FirstOrDefault();

                if (personagemSelecionado != null)
                {
                    context.Personagem.Remove(personagemSelecionado);
                    context.SaveChanges();
                }
            }
        }
    }
}